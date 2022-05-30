package uniandes.isis2304.hotelandes.interfazApp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileReader;
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

import uniandes.isis2304.hotelandes.negocio.Habitacion;
import uniandes.isis2304.hotelandes.negocio.HotelAndes;
import uniandes.isis2304.hotelandes.negocio.Producto;
import uniandes.isis2304.hotelandes.negocio.Reserva;
import uniandes.isis2304.hotelandes.negocio.VOHabitacion;
import uniandes.isis2304.hotelandes.negocio.VOProducto;
import uniandes.isis2304.hotelandes.negocio.VOReserva;

public class vistaRecepcionista extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    /* ****************************************************************
     * 			Atributos
     *****************************************************************/
    private static Logger log = Logger.getLogger(vistaRecepcionista.class.getName());
    private static final String CONFIG_INTERFAZ = "./src/main/resources/config/configuracionRecepcionista.json";
    private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A.json";

    private JsonObject tableConfig;
    private HotelAndes hotelandes;
    private JsonObject guiConfig;
    private PanelDatos panelDatos;
    private JMenuBar menuBar;
    private Login_Register login;
    private JFrame VENTANA; 

    public vistaRecepcionista(Login_Register login) {
        VENTANA = this;
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        this.login = login;
        guiConfig = openConfig("Interfaz", CONFIG_INTERFAZ);
        // Configura la apariencia del frame que contiene la interfaz gráfica
        configurarFrame();
        if (guiConfig != null) {
            crearMenu(guiConfig.getAsJsonArray("menuBar"));
        }
        this.login = login;
        tableConfig = openConfig("Tablas BD", CONFIG_TABLAS);
        hotelandes = new HotelAndes(tableConfig);

        String path = guiConfig.get("bannerPath").getAsString();
        panelDatos = new PanelDatos();

        setLayout(new BorderLayout());
        add(new JLabel(new ImageIcon(path)), BorderLayout.NORTH);
        add(panelDatos, BorderLayout.CENTER);
        this.setVisible(true);

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
        setSize(ancho, alto);
        this.setVisible(true);     
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

    /**
     *
     */

    @Override
    public void actionPerformed(ActionEvent pEvento) {
        String evento = pEvento.getActionCommand();
        try {
            Method req = vistaRecepcionista.class.getMethod(evento);
            req.invoke(this);
        } catch (Exception e) {
            e.printStackTrace();
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
        if (e.getClass().getName().equals("javax.jdo.JDODataStoreException")) {
            JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
            return je.getNestedExceptions()[0].getMessage();
        }
        return resp;
    }
    public void registrarLlegadaCliente()
    {
        try {
            //TODO ARREGLAR EL PROBLEMA DE QUE AL CLIENTE NO SE LE ASOCIAN LOS ACOMPAÑANTES DE SU RESERVA 
            Long reserva = Long.valueOf(JOptionPane.showInputDialog(this, "id reserva",
                    "RegistrarLlegadaCliente", JOptionPane.QUESTION_MESSAGE));
            String cliente = JOptionPane.showInputDialog(this, "numero de documento del cliente",
                    "RegistrarLlegadaCliente", JOptionPane.QUESTION_MESSAGE);
            if (reserva != null) {
                VOReserva tb = hotelandes.registrarLlegadaCliente(reserva, cliente);

                if (tb == null) {
                    throw new Exception("No se pudo registrar la llegada del cliente con id " + reserva);
                }
                String resultado = "";
                for (int i = 0; i < tb.getNumPersonas(); i++) {
                    String tipoDocumento = JOptionPane.showInputDialog(this, "tipo de documento del acompañante",
                            "RegistrarLlegadaCliente", JOptionPane.QUESTION_MESSAGE);
                    String numeroDocumento = JOptionPane.showInputDialog(this, "numero de documento del acompañante",
                            "RegistrarLlegadaCliente", JOptionPane.QUESTION_MESSAGE);
                    String correo = JOptionPane.showInputDialog(this, "correo del acompañante",
                            "RegistrarLlegadaCliente", JOptionPane.QUESTION_MESSAGE);
                    String nombre = JOptionPane.showInputDialog(this, "nombre del acompañante",
                            "RegistrarLlegadaCliente", JOptionPane.QUESTION_MESSAGE);
                    String contrasena = JOptionPane.showInputDialog(this, "contraseña del acompañante",
                            "RegistrarLlegadaCliente", JOptionPane.QUESTION_MESSAGE);
                    hotelandes.registrarAcompanante(tipoDocumento, numeroDocumento, correo, nombre, cliente, contrasena,
                            reserva);
                    resultado += "Se registró la llegada del acompañante con num documento " + numeroDocumento;
                }
                resultado += "Se registró la llegada del cliente con num documento " + cliente
                        + " para la reserva con id " + reserva;
                resultado += "Se hace efectiva la creación de la cuenta del cliente con sus acompañantes";
                resultado += "\nOperación terminada";
                panelDatos.actualizarInterfaz(resultado);
            } else {
                panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
            }
        } catch (Exception e) {
            String resultado = generarMensajeError(e);
            panelDatos.actualizarInterfaz(resultado);
        }
    }

    public void registrarSalidaCliente()
    {
        try {
            Long reserva = Long.valueOf(JOptionPane.showInputDialog(this, "id reserva",
                    "RegistrarSalidaCliente", JOptionPane.QUESTION_MESSAGE));
            String cliente = JOptionPane.showInputDialog(this, "numero de documento del cliente",
                    "RegistrarSalidaCliente", JOptionPane.QUESTION_MESSAGE);
            Long idEmpleado = Long.valueOf(JOptionPane.showInputDialog(this, "id empleado", "RegistrarSalidaCliente",
                    JOptionPane.QUESTION_MESSAGE));
            if (reserva != null && cliente != null) {
                List tb = hotelandes.registrarSalidaCliente(reserva, cliente, idEmpleado);
                Double costo = (Double) tb.get(0);
                List<VOProducto> productos = (List<VOProducto>) tb.get(1);
                VOHabitacion habitacion = (VOHabitacion) tb.get(2);
                VOReserva reserva1 = (VOReserva) tb.get(3);
                if (tb.isEmpty() || tb == null) {
                    throw new Exception("No se pudo registrar la salida del cliente con id " + reserva);
                }
                String resultado = "";
                resultado += "Se registró la salida del cliente con num documento " + cliente
                        + " para la reserva con id " + reserva + "\n";
                resultado += "el costo por el hospedaje y los productos es " + costo + "\n";
                resultado += "productos consumidos:"
                        + "\n";
                for (VOProducto producto : productos) {
                    resultado += producto.getNombre() + " " + producto.getCosto()
                            + "\n";
                }
                resultado += "Habitación: disponibilidad:" + habitacion.getOcupado() + " costo:"
                        + habitacion.getCostoAloj() + "\n";
                resultado += "Operación terminada";
                panelDatos.actualizarInterfaz(resultado);
            } else {
                panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
            }
        } catch (Exception e) {
            String resultado = generarMensajeError(e);
            panelDatos.actualizarInterfaz(resultado);
        }
    }

}
