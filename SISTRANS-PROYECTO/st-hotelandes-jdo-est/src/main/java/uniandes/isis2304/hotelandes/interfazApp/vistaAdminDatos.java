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
import javax.swing.UnsupportedLookAndFeelException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import org.apache.log4j.Logger;

import uniandes.isis2304.hotelandes.negocio.HotelAndes;


public class vistaAdminDatos extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
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
	private static final String CONFIG_INTERFAZ = "./src/main/resources/config/configuracionAdminDatos.json"; 
	
	/**
	 * Ruta al archivo de configuración de los nombres de tablas de la base de datos
	 */
	private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A.json";
	private JsonObject tableConfig;
    private HotelAndes hotelandes;
    private JsonObject guiConfig;
    private PanelDatos panelDatos;
	private JMenuBar menuBar;
	private Login_Register login;
	private JFrame VENTANA; 
	/* ****************************************************************
	 * 			Métodos administrativos
	 *****************************************************************/
	/**
	 * Muestra el log de HotelAndes
	 */
	public vistaAdminDatos(Login_Register login) {
		VENTANA= this;
		try {
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
		}
		catch ( Exception e ) {
			log.error( e.getMessage() );
		}
		// Carga la configuración de la interfaz desde un archivo JSON
		guiConfig = openConfig("Interfaz", CONFIG_INTERFAZ);
		//
		this.login = login;
		// Configura la apariencia del frame que contiene la interfaz gráfica
		configurarFrame();
		if (guiConfig != null) {
			crearMenu(guiConfig.getAsJsonArray("menuBar"));
		}
		tableConfig = openConfig("Tablas BD", CONFIG_TABLAS);
		hotelandes = new HotelAndes(tableConfig);

		String path = guiConfig.get("bannerPath").getAsString();
		panelDatos = new PanelDatos();
		
		setLayout(new BorderLayout());
		add(new JLabel(new ImageIcon(path)), BorderLayout.NORTH);
		add(panelDatos, BorderLayout.CENTER);
		this.setVisible(true);
	}
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
	public Login_Register getLogin() {
		return login;
	}
	public void setLogin(Login_Register login) {
		this.login = login;
	}
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
	public void mostrarLogHotelAndes ()
	{
		mostrarArchivo("hotelandes.log");
	}

	private boolean limpiarArchivo(String nombreArchivo) 
	{
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(new File(nombreArchivo)));
			bw.write("");
			bw.close();
			return true;
		} catch (IOException e) {
			//			e.printStackTrace();
			return false;
		}
	}
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
    	
        setLocation (50,50);
        setResizable( true );
        setBackground( Color.WHITE );
        addWindowListener(new WindowAdapter() {
		@Override
			public void windowClosing(WindowEvent e) {
				VENTANA.dispose();
				login.setVisible(true);
				hotelandes.cerrarUnidadPersistencia();
		}
		});
        setTitle( titulo );
		setSize ( ancho, alto);        
    }
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
	
	/**
	 * Muestra el log de datanucleus
	 */
	public void mostrarLogDatanuecleus ()
	{
		mostrarArchivo ("datanucleus.log");
	}
	
	/**
	 * Limpia el contenido del log de hotelandes
	 * Muestra en el panel de datos la traza de la ejecución
	 */
	public void limpiarLogHotelAndes ()
	{
		// Ejecución de la operación y recolección de los resultados
		boolean resp = limpiarArchivo ("hotelandes.log");

		// Generación de la cadena de caracteres con la traza de la ejecución de la demo
		String resultado = "\n\n************ Limpiando el log de hotelandes ************ \n";
		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");
		resultado += "\nLimpieza terminada";

		panelDatos.actualizarInterfaz(resultado);
	}
	
	/**
	 * Limpia el contenido del log de datanucleus
	 * Muestra en el panel de datos la traza de la ejecución
	 */
	public void limpiarLogDatanucleus ()
	{
		// Ejecución de la operación y recolección de los resultados
		boolean resp = limpiarArchivo ("datanucleus.log");

		// Generación de la cadena de caracteres con la traza de la ejecución de la demo
		String resultado = "\n\n************ Limpiando el log de datanucleus ************ \n";
		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");
		resultado += "\nLimpieza terminada";

		panelDatos.actualizarInterfaz(resultado);
	}
	
	/**
	 * Limpia todas las tuplas de todas las tablas de la base de datos de hotelandes
	 * Muestra en el panel de datos el número de tuplas eliminadas de cada tabla
	 */
	public void limpiarBD ()
	{
		try {
			// Ejecución de la demo y recolección de los resultados
			long eliminados[] = hotelandes.limpiarHotelAndes();

			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "\n\n************ Limpiando la base de datos ************ \n";
			resultado+=eliminados[0] +" Cuenta   Eliminados\n";
			resultado+=eliminados[1] +" Usuario   Eliminados\n";
			resultado+=eliminados[2] +" Prenda   Eliminados\n";
			resultado+=eliminados[3] +" Reserva   Eliminados\n";
			resultado+=eliminados[4] +" Habitacion   Eliminados\n";
			resultado+=eliminados[5] +" Mueble   Eliminados\n";
			resultado+=eliminados[6] +" Consumoconmueble   Eliminados\n";
			resultado+=eliminados[7] +" Consumo   Eliminados\n";
			resultado+=eliminados[8] +" Tipohabitacion   Eliminados\n";
			resultado+=eliminados[9] +" Tipousuario   Eliminados\n";
			resultado+=eliminados[10] +" Hotel   Eliminados\n";
			resultado+=eliminados[11] +" Cadenahotelera   Eliminados\n";
			resultado+=eliminados[12] +" Ofertaservicio   Eliminados\n";
			resultado+=eliminados[13] +" Registroconsumo   Eliminados\n";
			resultado+=eliminados[14] +" Utensilio   Eliminados\n";
			resultado+=eliminados[15] +" Producto   Eliminados\n";
			resultado+=eliminados[16] +" Servicioprestamo   Eliminados\n";
			resultado+=eliminados[17] +" Servicio   Eliminados\n";
			resultado+=eliminados[18] +" Cartaproductos   Eliminados\n";
			resultado+=eliminados[19] +" Estilo   Eliminados\n";
			resultado+=eliminados[20] +" Horarioservicio   Eliminados\n";
			resultado+=eliminados[21] +" Costoadicional   Eliminados\n";
			resultado+=eliminados[22] +" Tipocobro   Eliminados\n";
			resultado+=eliminados[23] +" Planconsumo   Eliminados\n";
			resultado+=eliminados[24] +" Restricciones   Eliminados\n";
			resultado+=eliminados[25] +" Servicioprestamoutensilio   Eliminados\n";
			resultado+=eliminados[26] +" Productoplanconsumo   Eliminados\n";
			resultado+=eliminados[27] +" Cartaproductosproductos   Eliminados\n";
			resultado+=eliminados[28] +" Serviciohorarioservicio   Eliminados\n";
			resultado+=eliminados[29] +" Consumoofertaservicio   Eliminados\n";
			resultado+=eliminados[30] +" Consumomuebleconconsumo   Eliminados\n";
			resultado+=eliminados[31] +" Planconsumoservicio   Eliminados\n";
			resultado+=eliminados[32] +" Hotelusuario   Eliminados\n";
			resultado+=eliminados[33] +" Planconsumorestricciones   Eliminados\n";
			resultado+=eliminados[34] +" Usuarioplanconsumo   Eliminados\n";
			resultado+=eliminados[35] +" Hotelplanconsumo   Eliminados\n";
			resultado+=eliminados[36] +" Consumocostoadicional   Eliminados\n";
			resultado += "\nLimpieza terminada";
			panelDatos.actualizarInterfaz(resultado);
		} catch (Exception e) {
			//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	private String generarMensajeError(Exception e) 
	{
		String resultado = "************ Error en la ejecución\n";
		resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
		resultado += "\n\nRevise datanucleus.log y hotelandes.log para más detalles";
		return resultado;
	}
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

    @Override
	public void actionPerformed(ActionEvent pEvento) {
		String evento = pEvento.getActionCommand( );		
        try 
        {
			Method req = vistaAdminDatos.class.getMethod ( evento );			
			req.invoke ( this );
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		} 
    }
}
