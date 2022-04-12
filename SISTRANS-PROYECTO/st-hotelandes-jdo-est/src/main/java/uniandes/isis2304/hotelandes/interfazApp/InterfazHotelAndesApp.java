/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: HotelAndes Uniandes
 * @version 1.0
 * @author Brian Rivera
 * 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.isis2304.hotelandes.interfazApp;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import org.apache.log4j.Logger;

import uniandes.isis2304.hotelandes.negocio.HotelAndes;
import uniandes.isis2304.hotelandes.negocio.VOTipoBebida;
/**
 * Clase principal de la interfaz
 */
@SuppressWarnings("serial")

public class InterfazHotelAndesApp extends JFrame implements ActionListener
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(InterfazHotelAndesApp.class.getName());
	
	/**
	 * Ruta al archivo de configuración de la interfaz
	 */
	private static final String CONFIG_INTERFAZ = "./src/main/resources/config/interfaceConfigApp.json"; 
	
	/**
	 * Ruta al archivo de configuración de los nombres de tablas de la base de datos
	 */
	private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A.json"; 
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
    /**
     * Objeto JSON con los nombres de las tablas de la base de datos que se quieren utilizar
     */
    private JsonObject tableConfig;
    
    /**
     * Asociación a la clase principal del negocio.
     */
    private HotelAndes hotelandes;
    
	/* ****************************************************************
	 * 			Atributos de interfaz
	 *****************************************************************/
    /**
     * Objeto JSON con la configuración de interfaz de la app.
     */
    private JsonObject guiConfig;
    
    /**
     * Panel de despliegue de interacción para los requerimientos
     */
    private PanelDatos panelDatos;
    
    /**
     * Menú de la aplicación
     */
    private JMenuBar menuBar;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
    /**
     * Construye la ventana principal de la aplicación. <br>
     * <b>post:</b> Todos los componentes de la interfaz fueron inicializados.
     */
    public InterfazHotelAndesApp( )
    {
        // Carga la configuración de la interfaz desde un archivo JSON
		guiConfig = openConfig("Interfaz", CONFIG_INTERFAZ);
		//
		
        // Configura la apariencia del frame que contiene la interfaz gráfica
        configurarFrame ( );
        if (guiConfig != null) 	   
        {
     	   crearMenu( guiConfig.getAsJsonArray("menuBar") );
        }
        
        tableConfig = openConfig ("Tablas BD", CONFIG_TABLAS);
        hotelandes = new HotelAndes (tableConfig);
        
    	String path = guiConfig.get("bannerPath").getAsString();
        panelDatos = new PanelDatos ( );

        setLayout (new BorderLayout());
        add (new JLabel (new ImageIcon (path)), BorderLayout.NORTH );          
        add( panelDatos, BorderLayout.CENTER );        
    }
    
	/* ***************************************************************
	 * 			Métodos de configuración de la interfaz
	 *****************************************************************/
    /**
     * Lee datos de configuración para la aplicació, a partir de un archivo JSON o con valores por defecto si hay errores.
     * @param tipo - El tipo de configuración deseada
     * @param archConfig - Archivo Json que contiene la configuración
     * @return Un objeto JSON con la configuración del tipo especificado
     * 			NULL si hay un error en el archivo.
     */
    private JsonObject openConfig (String tipo, String archConfig)
    {
    	JsonObject config = null;
		try 
		{
			Gson gson = new Gson( );
			FileReader file = new FileReader (archConfig);
			JsonReader reader = new JsonReader ( file );
			config = gson.fromJson(reader, JsonObject.class);
			log.info ("Se encontró un archivo de configuración válido: " + tipo);
		} 
		catch (Exception e)
		{
//			e.printStackTrace ();
			log.info ("NO se encontró un archivo de configuración válido");			
			JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de interfaz válido: " + tipo, "HotelAndes App", JOptionPane.ERROR_MESSAGE);
		}	
        return config;
    }
    
    /**
     * Método para configurar el frame principal de la aplicación
     */
    private void configurarFrame(  )
    {
    	int alto = 0;
    	int ancho = 0;
    	String titulo = "";	
    	
    	if ( guiConfig == null )
    	{
    		log.info ( "Se aplica configuración por defecto" );			
			titulo = "HotelAndes APP Default";
			alto = 300;
			ancho = 500;
    	}
    	else
    	{
			log.info ( "Se aplica configuración indicada en el archivo de configuración" );
    		titulo = guiConfig.get("title").getAsString();
			alto= guiConfig.get("frameH").getAsInt();
			ancho = guiConfig.get("frameW").getAsInt();
    	}
    	
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocation (50,50);
        setResizable( true );
        setBackground( Color.WHITE );
        addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			hotelandes.cerrarUnidadPersistencia(); }
		});
        setTitle( titulo );
		setSize ( ancho, alto);        
    }

    /**
     * Método para crear el menú de la aplicación con base em el objeto JSON leído
     * Genera una barra de menú y los menús con sus respectivas opciones
     * @param jsonMenu - Arreglo Json con los menùs deseados
     */
    private void crearMenu(  JsonArray jsonMenu )
    {    	
    	// Creación de la barra de menús
        menuBar = new JMenuBar();       
        for (JsonElement men : jsonMenu)
        {
        	// Creación de cada uno de los menús
        	JsonObject jom = men.getAsJsonObject(); 

        	String menuTitle = jom.get("menuTitle").getAsString();        	
        	JsonArray opciones = jom.getAsJsonArray("options");
        	
        	JMenu menu = new JMenu( menuTitle);
        	
        	for (JsonElement op : opciones)
        	{       	
        		// Creación de cada una de las opciones del menú
        		JsonObject jo = op.getAsJsonObject(); 
        		String lb =   jo.get("label").getAsString();
        		String event = jo.get("event").getAsString();
        		
        		JMenuItem mItem = new JMenuItem( lb );
        		mItem.addActionListener( this );
        		mItem.setActionCommand(event);
        		
        		menu.add(mItem);
        	}       
        	menuBar.add( menu );
        }        
        setJMenuBar ( menuBar );	
    }
//     /* ****************************************************************
// 	 * 			RESERVA DE HABITACIÓN
// 	 *****************************************************************/
// 	public void adicionarReservahabitacion()
// 	{
// 		try 
//     	{
//     		long Habitacion = Long.valueOf(JOptionPane.showInputDialog (this, "id Habitacion", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE));
// 			long Cliente = Long.valueOf(JOptionPane.showInputDialog (this, "id Cliente", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE));
// 			String planPago =JOptionPane.showInputDialog (this, "PlanPago", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE);
//     		Timestamp FechaEntrada=Timestamp.valueOf(JOptionPane.showInputDialog (this, "Fecha de entrada", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE));
// 			Timestamp FechaSalida=Timestamp.valueOf(JOptionPane.showInputDialog (this, "Fecha de salida", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE));
// 			if (Habitacion != 0L && Cliente!= 0L && planPago!=null && FechaEntrada!= null && FechaSalida!=null)
//     		{
//         		VOReservahabitacion tb = hotelandes.adicionarReservahabitacion(Habitacion, Cliente, planPago, FechaEntrada, FechaSalida);
//         		if (tb == null)
//         		{
//         			throw new Exception ("No se pudo crear la reserva de la habitacion con id" + Habitacion+" del cliente con id:"+Cliente+"y los datos:"+planPago+"," +FechaEntrada+","+ FechaSalida);
//         		}
//         		String resultado = "Se adicionó la reserva:"+tb.getHabitacion()+" al cliente con id "+tb.getCliente()+"\n FechaEntrada:"+tb.getFechaEntrada()+"\nFechaSalida:"+tb.getFechaSalida()+"\nPlanPago:"+tb.getPlanPago();
//         		resultado += "\nReserva añadida exitosamente";
//     			resultado += "\nOperación terminada";
//     			panelDatos.actualizarInterfaz(resultado);
//     		}
//     		else
//     		{
//     			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
//     		}
// 		}
// 		catch (Exception e) 
//     	{
// //			e.printStackTrace();
// 			String resultado = generarMensajeError(e);
// 			panelDatos.actualizarInterfaz(resultado);
// 		}
// 	}
// 	/* ****************************************************************
// 	 * 			RESERVA DE SALON CONFERENCIA
// 	 *****************************************************************/
// 	public void adicionarReservaSalonConferencia()
// 	{
// 		try 
//     	{
// 			Long SalonConferencia=Long.valueOf(JOptionPane.showInputDialog (this, "id SalonConferencia", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE));
// 			Timestamp fechaHoraInicio =Timestamp.valueOf(JOptionPane.showInputDialog (this, "Digite la fecha de inicio", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE));	
// 			Double duracion =Double.valueOf(JOptionPane.showInputDialog (this, "Digite la duración", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE));	
// 			Long Cliente=Long.valueOf(JOptionPane.showInputDialog (this, "id Cliente", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE));
// 			Long IdReserva=Long.valueOf(JOptionPane.showInputDialog (this, "id reserva", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE));
// 			if (fechaHoraInicio!=null && duracion!=null && SalonConferencia!=null && Cliente!=null)
//     		{
//         		VOReserva tb = hotelandes.adicionarReservaSalonConferencia(IdReserva, fechaHoraInicio,duracion, SalonConferencia, Cliente);
//         		if (tb == null)
//         		{
//         			 throw new Exception ("No se pudo crear la reserva del salon de conferecnia con id " + SalonConferencia+" para el cliente con id:"+Cliente);
//         		}
//         		String resultado = "Se adicionó la reserva al salón de conferencia:"+tb.getSalonConferencia()+" al cliente con id "+tb.getCliente()+"\n FechaEntrada:"+tb.getFechaHoraInicio()+"\nduracion:"+tb.getDuracion();
//         		resultado += "\nReserva añadida exitosamente";
//     			resultado += "\nOperación terminada";
//     			panelDatos.actualizarInterfaz(resultado);
//     		}
//     		else
//     		{
//     			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
//     		}
// 		}
// 		catch (Exception e) 
//     	{
// //			e.printStackTrace();
// 			String resultado = generarMensajeError(e);
// 			panelDatos.actualizarInterfaz(resultado);
// 		}
// 	}
// 	/* ****************************************************************
// 	 * 			RESERVA DE SALON DE REUNION
// 	 *****************************************************************/
// 	public void adicionarReservaSalonReunion()
// 	{
// 		try 
//     	{
// 			Long SalonReunion=Long.valueOf(JOptionPane.showInputDialog (this, "id SalonReunion", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE));
// 			Timestamp fechaHoraInicio =Timestamp.valueOf(JOptionPane.showInputDialog (this, "Digite la fecha de inicio", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE));	
// 			Double duracion =Double.valueOf(JOptionPane.showInputDialog (this, "Digite la duración", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE));	
// 			Long Cliente=Long.valueOf(JOptionPane.showInputDialog (this, "id Cliente", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE));
// 			Long IdReserva=Long.valueOf(JOptionPane.showInputDialog (this, "id reserva", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE));
// 			if (fechaHoraInicio!=null && duracion!=null && SalonReunion!=null && Cliente!=null)
//     		{
//         		VOReserva tb = hotelandes.adicionarReservaSalonReunion(IdReserva, fechaHoraInicio,duracion, SalonReunion, Cliente);
//         		if (tb == null)
//         		{
//         			 throw new Exception ("No se pudo crear la reserva del salon de reunion con id " + SalonReunion+" para el cliente con id:"+Cliente);
//         		}
//         		String resultado = "Se adicionó la reserva al salón de reunion:"+tb.getSalonConferencia()+" al cliente con id "+tb.getCliente()+"\n FechaEntrada:"+tb.getFechaHoraInicio()+"\nduracion:"+tb.getDuracion();
//         		resultado += "\nReserva añadida exitosamente";
//     			resultado += "\nOperación terminada";
//     			panelDatos.actualizarInterfaz(resultado);
//     		}
//     		else
//     		{
//     			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
//     		}
// 		}
// 		catch (Exception e) 
//     	{
// //			e.printStackTrace();
// 			String resultado = generarMensajeError(e);
// 			panelDatos.actualizarInterfaz(resultado);
// 		}
// 	}
// 	/* ****************************************************************
// 	 * 			RESERVA DE servicio SPA
// 	 *****************************************************************/
	
// 	public void adicionarReservaServicioSPA()
// 	{
// 		try 
//     		{
// 			Long SPA=Long.valueOf(JOptionPane.showInputDialog (this, "id SPA", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE));
// 			Timestamp fechaHoraInicio =Timestamp.valueOf(JOptionPane.showInputDialog (this, "Digite la fecha de inicio", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE));	
// 			Double duracion =Double.valueOf(JOptionPane.showInputDialog (this, "Digite la duración", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE));	
// 			Long Cliente=Long.valueOf(JOptionPane.showInputDialog (this, "id Cliente", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE));
// 			Long IdReserva=Long.valueOf(JOptionPane.showInputDialog (this, "id reserva", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE));
// 			if (fechaHoraInicio!=null && duracion!=null && SPA!=null && Cliente!=null)
//     		{
//         		VOReserva tb = hotelandes.adicionarReservaServicioSPA(IdReserva, fechaHoraInicio,duracion, SPA, Cliente);
//         		if (tb == null)
//         		{
//         			 throw new Exception ("No se pudo crear la reserva del salon de conferecnia con id " + SPA+" para el cliente con id:"+Cliente);
//         		}
//         		String resultado = "Se adicionó la reserva al trabajo del SPA:"+tb.getTrabajo()+" al cliente con id "+tb.getCliente()+"\n FechaEntrada:"+tb.getFechaHoraInicio()+"\nduracion:"+tb.getDuracion();
//         		resultado += "\nReserva añadida exitosamente";
//     			resultado += "\nOperación terminada";
//     			panelDatos.actualizarInterfaz(resultado);
//     		}
//     		else
//     		{
//     			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
//     		}
// 		}
// 		catch (Exception e) 
//     	{
// //			e.printStackTrace();
// 			String resultado = generarMensajeError(e);
// 			panelDatos.actualizarInterfaz(resultado);
// 		}
// 	}

    public void adicionarTipoBebida( )
    {
    	try 
    	{
    		String nombreTipo = JOptionPane.showInputDialog (this, "Nombre del tipo de bedida?", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE);
    		if (nombreTipo != null)
    		{
        		VOTipoBebida tb = hotelandes.adicionarTipoBebida (nombreTipo);
        		if (tb == null)
        		{
        			throw new Exception ("No se pudo crear un tipo de bebida con nombre: " + nombreTipo);
        		}
        		String resultado = "En adicionarTipoBebida\n\n";
        		resultado += "Tipo de bebida adicionado exitosamente: " + tb;
    			resultado += "\n Operación terminada";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }

    /**
     * Consulta en la base de datos los tipos de bebida existentes y los muestra en el panel de datos de la aplicación
     */
    public void listarTipoBebida( )
    {
    	try 
    	{
			List <VOTipoBebida> lista = hotelandes.darVOTiposBebida();

			String resultado = "En listarTipoBebida";
			resultado +=  "\n" + listarTiposBebida (lista);
			panelDatos.actualizarInterfaz(resultado);
			resultado += "\n Operación terminada";
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }

    /**
     * Borra de la base de datos el tipo de bebida con el identificador dado po el usuario
     * Cuando dicho tipo de bebida no existe, se indica que se borraron 0 registros de la base de datos
     */
    public void eliminarTipoBebidaPorId( )
    {
    	try 
    	{
    		String idTipoStr = JOptionPane.showInputDialog (this, "Id del tipo de bedida?", "Borrar tipo de bebida por Id", JOptionPane.QUESTION_MESSAGE);
    		if (idTipoStr != null)
    		{
    			long idTipo = Long.valueOf (idTipoStr);
    			long tbEliminados = hotelandes.eliminarTipoBebidaPorId (idTipo);

    			String resultado = "En eliminar TipoBebida\n\n";
    			resultado += tbEliminados + " Tipos de bebida eliminados\n";
    			resultado += "\n Operación terminada";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }

    /**
     * Busca el tipo de bebida con el nombre indicado por el usuario y lo muestra en el panel de datos
     */
    public void buscarTipoBebidaPorNombre( )
    {
    	try 
    	{
    		String nombreTb = JOptionPane.showInputDialog (this, "Nombre del tipo de bedida?", "Buscar tipo de bebida por nombre", JOptionPane.QUESTION_MESSAGE);
    		if (nombreTb != null)
    		{
    			VOTipoBebida tipoBebida = hotelandes.darTipoBebidaPorNombre (nombreTb);
    			String resultado = "En buscar Tipo Bebida por nombre\n\n";
    			if (tipoBebida != null)
    			{
        			resultado += "El tipo de bebida es: " + tipoBebida;
    			}
    			else
    			{
        			resultado += "Un tipo de bebida con nombre: " + nombreTb + " NO EXISTE\n";    				
    			}
    			resultado += "\n Operación terminada";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }


	
	
	/**
	 * Muestra la presentación general del proyecto
	 */
	public void mostrarPresentacionGeneral ()
	{
		mostrarArchivo ("data/00-ST-HotelAndesJDO.pdf");
	}
	
	/**
	 * Muestra el modelo conceptual de HotelAndes
	 */
	public void mostrarModeloConceptual ()
	{
		mostrarArchivo ("data/Modelo Conceptual HotelAndes.pdf");
	}
	
	/**
	 * Muestra el esquema de la base de datos de HotelAndes
	 */
	public void mostrarEsquemaBD ()
	{
		mostrarArchivo ("data/Esquema BD HotelAndes.pdf");
	}
	
	/**
	 * Muestra el script de creación de la base de datos
	 */
	public void mostrarScriptBD ()
	{
		mostrarArchivo ("data/EsquemaHotelAndes.sql");
	}
	
	/**
	 * Muestra la arquitectura de referencia para HotelAndes
	 */
	public void mostrarArqRef ()
	{
		mostrarArchivo ("data/ArquitecturaReferencia.pdf");
	}
	
	/**
	 * Muestra la documentación Javadoc del proyectp
	 */
	public void mostrarJavadoc ()
	{
		mostrarArchivo ("doc/index.html");
	}
	
	/**
     * Muestra la información acerca del desarrollo de esta apicación
     */
    public void acercaDe ()
    {
		String resultado = "\n\n ************************************\n\n";
		resultado += " * Universidad	de	los	Andes	(Bogotá	- Colombia)\n";
		resultado += " * Departamento	de	Ingeniería	de	Sistemas	y	Computación\n";
		resultado += " * Licenciado	bajo	el	esquema	Academic Free License versión 2.1\n";
		resultado += " * \n";		
		resultado += " * Curso: isis2304 - Sistemas Transaccionales\n";
		resultado += " * Proyecto: HotelAndes Uniandes\n";
		resultado += " * @version 1.0\n";
		resultado += " * @author Brian Rivera\n";
		resultado += " * Abril de 2022\n";
		resultado += " * \n";
		resultado += "\n ************************************\n\n";

		panelDatos.actualizarInterfaz(resultado);		
    }
    

	/* ****************************************************************
	 * 			Métodos privados para la presentación de resultados y otras operaciones
	 *****************************************************************/
    /**
     * Genera una cadena de caracteres con la lista de los tipos de bebida recibida: una línea por cada tipo de bebida
     * @param lista - La lista con los tipos de bebida
     * @return La cadena con una líea para cada tipo de bebida recibido
     */
    private String listarTiposBebida(List<VOTipoBebida> lista) 
    {
    	String resp = "Los tipos de bebida existentes son:\n";
    	int i = 1;
        for (VOTipoBebida tb : lista)
        {
        	resp += i++ + ". " + tb.toString() + "\n";
        }
        return resp;
	}

    /**
     * Genera una cadena de caracteres con la descripción de la excepcion e, haciendo énfasis en las excepcionsde JDO
     * @param e - La excepción recibida
     * @return La descripción de la excepción, cuando es javax.jdo.JDODataStoreException, "" de lo contrario
     */
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}

	/**
	 * Genera una cadena para indicar al usuario que hubo un error en la aplicación
	 * @param e - La excepción generada
	 * @return La cadena con la información de la excepción y detalles adicionales
	 */
	private String generarMensajeError(Exception e) 
	{
		String resultado = "************ Error en la ejecución\n";
		resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
		resultado += "\n\nRevise datanucleus.log y hotelandes.log para más detalles";
		return resultado;
	}

	/**
	 * Limpia el contenido de un archivo dado su nombre
	 * @param nombreArchivo - El nombre del archivo que se quiere borrar
	 * @return true si se pudo limpiar
	 */
	private boolean limpiarArchivo(String nombreArchivo) 
	{
		BufferedWriter bw;
		try 
		{
			bw = new BufferedWriter(new FileWriter(new File (nombreArchivo)));
			bw.write ("");
			bw.close ();
			return true;
		} 
		catch (IOException e) 
		{
//			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Abre el archivo dado como parámetro con la aplicación por defecto del sistema
	 * @param nombreArchivo - El nombre del archivo que se quiere mostrar
	 */
	private void mostrarArchivo (String nombreArchivo)
	{
		try
		{
			Desktop.getDesktop().open(new File(nombreArchivo));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/* ****************************************************************
	 * 			Métodos de la Interacción
	 *****************************************************************/
    /**
     * Método para la ejecución de los eventos que enlazan el menú con los métodos de negocio
     * Invoca al método correspondiente según el evento recibido
     * @param pEvento - El evento del usuario
     */
    @Override
	public void actionPerformed(ActionEvent pEvento)
	{
		String evento = pEvento.getActionCommand( );		
        try 
        {
			Method req = InterfazHotelAndesApp.class.getMethod ( evento );			
			req.invoke ( this );
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		} 
	}
    
	/* ****************************************************************
	 * 			Programa principal
	 *****************************************************************/
    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args Arreglo de argumentos que se recibe por línea de comandos
     */
    public static void main( String[] args )
	{
        try
		{
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
            InterfazHotelAndesApp interfaz = new InterfazHotelAndesApp( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}
