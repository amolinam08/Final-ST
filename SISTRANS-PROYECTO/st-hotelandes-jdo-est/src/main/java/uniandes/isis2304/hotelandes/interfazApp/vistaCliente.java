package uniandes.isis2304.hotelandes.interfazApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.sql.Timestamp;

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
import javax.swing.UnsupportedLookAndFeelException;


import org.apache.log4j.Logger;

import uniandes.isis2304.hotelandes.negocio.HotelAndes;
import uniandes.isis2304.hotelandes.negocio.VOReserva;

public class vistaCliente extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    /* ****************************************************************
     * 			Atributos
     *****************************************************************/
    private static Logger log = Logger.getLogger(vistaCliente.class.getName());
    private static final String CONFIG_INTERFAZ = "./src/main/resources/config/configuracionCliente.json";
    private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A.json"; 

    private JsonObject tableConfig;
    private HotelAndes hotelandes;
    private JsonObject guiConfig;
    private PanelDatos panelDatos;
    private JMenuBar menuBar;
    private Login_Register login;
    private JFrame VENTANA; 
    /*Constructor*/
    public vistaCliente(Login_Register login) 
    {
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
            Method req = vistaCliente.class.getMethod(evento);
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
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}
    public void adicionarReservahabitacion()
    {
        try {
            Long habitacion = Long.valueOf(JOptionPane.showInputDialog(this, "id Habitacion",
                    "AdicionarReservahabitacion", JOptionPane.QUESTION_MESSAGE));
            String cliente = JOptionPane.showInputDialog(this, "numero de documento del cliente",
                    "AdicionarReservahabitacion", JOptionPane.QUESTION_MESSAGE);
            String planPago = JOptionPane.showInputDialog(this, "PlanPago", "AdicionarReservahabitacion",
                    JOptionPane.QUESTION_MESSAGE);
            //TODO PRUEBA HORA
            Long datetime = System.currentTimeMillis();
            Timestamp diaHora = new Timestamp(datetime);
            System.out.println("Current Time Stamp: " + diaHora);
            Long fechaSalidaM = 86400000 + datetime;
            Timestamp fechaSalida = new Timestamp(fechaSalidaM);
            //FIN PRUEBA HORA
            
            Long numPersonas = Long.valueOf(JOptionPane.showInputDialog(this, "numero de personas",
                    "AdicionarReservahabitacion", JOptionPane.QUESTION_MESSAGE));
            if (habitacion != null && cliente != null && planPago != null && diaHora != null && fechaSalida != null) {
                VOReserva tb = hotelandes.adicionarReservahabitacion(diaHora, numPersonas, planPago, fechaSalida,
                        cliente, habitacion);
                if (tb == null) {
                    throw new Exception("No se pudo crear la reserva de la habitacion con id " + habitacion
                            + " del cliente con numero de documento: " + cliente + " y los datos: " + planPago + ","
                            + diaHora + "," + fechaSalida + "," + numPersonas);
                }
                String resultado = "Se adicionó la reserva: " + tb.getIdReserva()
                        + " al cliente con numero de documento " + tb.getCliente() + " con los datos:"
                        + tb.getPlanPago() + "," + tb.getDiaHora() + "," + tb.getFechaSalida() + ","
                        + tb.getNumPersonas();
                resultado += "\nReserva añadida exitosamente";
                resultado += "\nOperación terminada";
                panelDatos.actualizarInterfaz(resultado);
            } else {
                panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
            }
        } catch (Exception e) {
            //			e.printStackTrace();
            String resultado = generarMensajeError(e);
            panelDatos.actualizarInterfaz(resultado);
        }
    }
    public void adicionarReservaSalonConferencia()
    {
        try {
            Long salon = Long.valueOf(JOptionPane.showInputDialog(this, "id Salon",
                    "AdicionarReservaSalonConferencia", JOptionPane.QUESTION_MESSAGE));
            String cliente = JOptionPane.showInputDialog(this, "numero de documento del cliente",
                    "AdicionarReservaSalonConferencia", JOptionPane.QUESTION_MESSAGE);
            String planPago = JOptionPane.showInputDialog(this, "PlanPago", "AdicionarReservaSalonConferencia",
                    JOptionPane.QUESTION_MESSAGE);
            Timestamp diaHora = Timestamp.valueOf(JOptionPane.showInputDialog(this, "Fecha de entrada",
                    "AdicionarReservaSalonConferencia", JOptionPane.QUESTION_MESSAGE));
            Double duracion = Double.valueOf(JOptionPane.showInputDialog(this, "Duracion",
                    "AdicionarReservaSalonConferencia", JOptionPane.QUESTION_MESSAGE));
            Long numPersonas = Long.valueOf(JOptionPane.showInputDialog(this, "numero de personas",
                    "AdicionarReservaSalonConferencia", JOptionPane.QUESTION_MESSAGE));
            if (salon != null && cliente != null && planPago != null && diaHora != null && duracion != null) {
                VOReserva tb = hotelandes.adicionarReservaSalonConferencia(diaHora, numPersonas, planPago, duracion,
                        cliente, salon);
                if (tb == null) {
                    throw new Exception("No se pudo crear la reserva del salon con id " + salon
                            + " del cliente con numero de documento: " + cliente + " y los datos: " + planPago + ","
                            + diaHora + "," + duracion + "," + numPersonas);
                }
                String resultado = "Se adicionó la reserva del salon: " + tb.getServicio()
                        + " al cliente con numero de documento " + cliente + " con los datos: planPago:"
                        + tb.getPlanPago() + ",fecha:" + tb.getDiaHora() + ",duracion:" + tb.getDuracion()
                        + ",numero de personas:" + tb.getNumPersonas();
                resultado += "\nReserva añadida exitosamente";
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
    public void adicionarReservaSalonReunion()
    {
        try {
            Long salon = Long.valueOf(JOptionPane.showInputDialog(this, "id Salon",
                    "AdicionarReservaSalonReunion", JOptionPane.QUESTION_MESSAGE));
            String cliente = JOptionPane.showInputDialog(this, "numero de documento del cliente",
                    "AdicionarReservaSalonReunion", JOptionPane.QUESTION_MESSAGE);
            String planPago = JOptionPane.showInputDialog(this, "PlanPago", "AdicionarReservaSalonReunion",
                    JOptionPane.QUESTION_MESSAGE);
            Timestamp diaHora = Timestamp.valueOf(JOptionPane.showInputDialog(this, "Fecha de entrada",
                    "AdicionarReservaSalonReunion", JOptionPane.QUESTION_MESSAGE));
            Double duracion = Double.valueOf(JOptionPane.showInputDialog(this, "Duracion",
                    "AdicionarReservaSalonReunion", JOptionPane.QUESTION_MESSAGE));
            Long numPersonas = Long.valueOf(JOptionPane.showInputDialog(this, "numero de personas",
                    "AdicionarReservaSalonReunion", JOptionPane.QUESTION_MESSAGE));
            if (salon != null && cliente != null && planPago != null && diaHora != null && duracion != null) {
                VOReserva tb = hotelandes.adicionarReservaSalonReunion(diaHora, numPersonas, planPago, duracion,
                        cliente, salon);
                if (tb == null) {
                    throw new Exception("No se pudo crear la reserva del salon con id " + salon
                            + " del cliente con numero de documento: " + cliente + " y los datos: " + planPago + ","
                            + diaHora + "," + duracion + "," + numPersonas);
                }
                String resultado = "Se adicionó la reserva del salon: " + tb.getServicio()
                        + " al cliente con numero de documento " + cliente + " con los datos: planPago:"
                        + tb.getPlanPago() + ",fecha:" + tb.getDiaHora() + ",duracion:" + tb.getDuracion()
                        + ",numero de personas:" + tb.getNumPersonas();
                resultado += "\nReserva añadida exitosamente";
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
    //metodo que permite adicionar una reserva de una habitacion
    
    public void adicionarReservaServicioSPA()
    {
        try {
            
            Long servicioSPA = Long.valueOf(JOptionPane.showInputDialog(this, "id Servicio",
                    "AdicionarReservaServicioSPA", JOptionPane.QUESTION_MESSAGE));
            String cliente = JOptionPane.showInputDialog(this, "numero de documento del cliente",
                    "AdicionarReservaServicioSPA", JOptionPane.QUESTION_MESSAGE);
            String planPago = JOptionPane.showInputDialog(this, "PlanPago", "AdicionarReservaServicioSPA",
                    JOptionPane.QUESTION_MESSAGE);
            Timestamp diaHora = Timestamp.valueOf(JOptionPane.showInputDialog(this, "Fecha de entrada",
                    "AdicionarReservaServicioSPA", JOptionPane.QUESTION_MESSAGE));
            Double duracion = Double.valueOf(JOptionPane.showInputDialog(this, "Duracion",
                    "AdicionarReservaServicioSPA", JOptionPane.QUESTION_MESSAGE));

            if (servicioSPA != null && cliente != null && planPago != null && diaHora != null && duracion != null) {
                VOReserva tb = hotelandes.adicionarReservaServicioSPA(diaHora, planPago, duracion,
                        cliente, servicioSPA);
                if (tb == null) {
                    throw new Exception("No se pudo crear la reserva del salon con id " + servicioSPA
                            + " del cliente con numero de documento: " + cliente + " y los datos: " + planPago + ","
                            + diaHora + "," + duracion);
                }
                String resultado = "Se adicionó la reserva del servicio: " + tb.getOfertaServicio()
                        + " al cliente con numero de documento " + cliente + " con los datos: planPago:"
                        + tb.getPlanPago() + ",fecha:" + tb.getDiaHora() + ",duracion:" + tb.getDuracion();
                resultado += "\nReserva añadida exitosamente";
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

    

    
}
