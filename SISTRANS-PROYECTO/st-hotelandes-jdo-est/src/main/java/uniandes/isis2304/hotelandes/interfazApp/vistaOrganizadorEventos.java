package uniandes.isis2304.hotelandes.interfazApp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
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

public class vistaOrganizadorEventos extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    /* ****************************************************************
     * 			Atributos
     *****************************************************************/
    private static Logger log = Logger.getLogger(InterfazHotelAndesApp.class.getName());
    private static final String CONFIG_INTERFAZ = "./src/main/resources/config/configuracionVistaOrganizadorEventos.json";
    private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A.json";

    private JsonObject tableConfig;
    private HotelAndes hotelandes;
    private JsonObject guiConfig;
    private PanelDatos panelDatos;
    private JMenuBar menuBar;
    private Login_Register login;
    private JFrame VENTANA; 

    public vistaOrganizadorEventos(Login_Register login) {
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
            Method req = vistaOrganizadorEventos.class.getMethod(evento);
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
    
    public void reservarAlojamientoYServiciosParaUnaConvencion() {
        List<Reserva> listaReservasSpa = new ArrayList<Reserva>();
        List<Reserva> listaReservasSalonConferencia = new ArrayList<Reserva>();
        List<Reserva> listaReservasSalonReunion = new ArrayList<Reserva>();
        List<Reserva> listaReservasHabitacion = new ArrayList<Reserva>();
        List<List<Reserva>> ListReservas = new ArrayList<List<Reserva>>();
        Long idConvencion = Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de la convención"));
        idConvencion = 1L;
        Long PlanPago = Long.parseLong(JOptionPane.showInputDialog("Ingrese el id del plan de pago"));
        PlanPago = null;
        Long CantidadServicios = Long
                .parseLong(JOptionPane.showInputDialog("Ingrese la cantidad de tipos de servicios"));
        CantidadServicios = 0L;

        Long CantidadTipoAlojamientos = Long
                .parseLong(JOptionPane.showInputDialog("Ingrese la cantidad de alojamientos"));
        CantidadTipoAlojamientos = 1L;
        try {
            for (int i = 0; i < CantidadTipoAlojamientos; i++) {
                Long tipoAlojamiento = Long.parseLong(JOptionPane.showInputDialog("Ingrese el tipo de alojamiento"));
                tipoAlojamiento = 3L;
                String Cantidad = JOptionPane.showInputDialog("Ingrese la cantidad de alojamientos");
                Cantidad = "3";
                Timestamp fechaInicio = Timestamp.valueOf(JOptionPane.showInputDialog("Ingrese la fecha de inicio"));
                fechaInicio = Timestamp.valueOf("2020-01-01 00:00:00.0");
                Timestamp fechaFin = Timestamp.valueOf(JOptionPane.showInputDialog("Ingrese la fecha de fin"));
                fechaFin = Timestamp.valueOf("2022-01-01 00:00:00.0");
                for (int j = 0; j < Integer.parseInt(Cantidad); j++) {
                    Reserva res = new Reserva(null, fechaInicio, null, "N", null, null, fechaFin, null, tipoAlojamiento,
                            null,
                            null);
                    listaReservasHabitacion.add(res);
                }
            }

            for (int i = 0; i < CantidadServicios; i++) {
                String tipoServicio = JOptionPane.showInputDialog("Ingrese el tipo de servicio");
                int Cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de servicios"));
                if (tipoServicio.equals("SPA")) {
                    for (int j = 0; j < Cantidad; j++) {
                        Long servicioSPA = Long.valueOf(JOptionPane.showInputDialog(this, "id Servicio",
                                "AdicionarReservaServicioSPA", JOptionPane.QUESTION_MESSAGE));
                        Timestamp diaHora = Timestamp.valueOf(JOptionPane.showInputDialog(this, "Fecha de entrada",
                                "AdicionarReservaServicioSPA", JOptionPane.QUESTION_MESSAGE));
                        Double duracion = Double.valueOf(JOptionPane.showInputDialog(this, "Duracion",
                                "AdicionarReservaServicioSPA", JOptionPane.QUESTION_MESSAGE));
                        Reserva res = new Reserva();
                        res.setDiaHora(diaHora);
                        res.setDuracion(duracion);
                        res.setOfertaServicio(servicioSPA);
                        listaReservasSpa.add(res);
                    }

                } else if (tipoServicio.equals("Salon conferencia")) {
                    for (int j = 0; j < Cantidad; j++) {
                        Long salon = Long.valueOf(JOptionPane.showInputDialog(this, "id Salon",
                                "AdicionarReservaSalonConferencia", JOptionPane.QUESTION_MESSAGE));
                        Timestamp diaHora = Timestamp.valueOf(JOptionPane.showInputDialog(this, "Fecha de entrada",
                                "AdicionarReservaSalonConferencia", JOptionPane.QUESTION_MESSAGE));
                        Timestamp diaHoraSalida = Timestamp.valueOf(JOptionPane.showInputDialog(this, "Fecha de salida",
                                "AdicionarReservaSalonConferencia", JOptionPane.QUESTION_MESSAGE));
                        Long numPersonas = Long.valueOf(JOptionPane.showInputDialog(this, "numero de personas",
                                "AdicionarReservaSalonConferencia", JOptionPane.QUESTION_MESSAGE));
                        Reserva res = new Reserva();
                        res.setDiaHora(diaHora);
                        res.setFechaSalida(diaHoraSalida);
                        res.setNumPersonas(numPersonas);
                        res.setServicio(salon);
                        listaReservasSalonConferencia.add(res);
                    }
                } else if (tipoServicio.equals("Salon reunion")) {
                    for (int j = 0; j < Cantidad; j++) {
                        Long salon = Long.valueOf(JOptionPane.showInputDialog(this, "id Salon",
                                "AdicionarReservaSalonConferencia", JOptionPane.QUESTION_MESSAGE));
                        Timestamp diaHora = Timestamp.valueOf(JOptionPane.showInputDialog(this, "Fecha de entrada",
                                "AdicionarReservaSalonConferencia", JOptionPane.QUESTION_MESSAGE));
                        Timestamp diaHoraSalida = Timestamp.valueOf(JOptionPane.showInputDialog(this, "Fecha de salida",
                                "AdicionarReservaSalonConferencia", JOptionPane.QUESTION_MESSAGE));
                        Long numPersonas = Long.valueOf(JOptionPane.showInputDialog(this, "numero de personas",
                                "AdicionarReservaSalonConferencia", JOptionPane.QUESTION_MESSAGE));
                        Reserva res = new Reserva();
                        res.setDiaHora(diaHora);
                        res.setFechaSalida(diaHoraSalida);
                        res.setNumPersonas(numPersonas);
                        res.setServicio(salon);
                        listaReservasSalonReunion.add(res);
                    }

                }

            }
            ListReservas.add(listaReservasHabitacion);
            ListReservas.add(listaReservasSpa);
            ListReservas.add(listaReservasSalonConferencia);
            ListReservas.add(listaReservasSalonReunion);
            List<VOReserva> reservasHechas = hotelandes.reservarAlojamientoYServiciosParaUnaConvencion(idConvencion,
                    PlanPago,
                    ListReservas);
            String a = "";

            for (VOReserva res : reservasHechas) {
                a = a + res.toString() + "\n";
            }
            panelDatos.actualizarInterfaz(a);
        } catch (Exception e) {
            String resultado = generarMensajeError(e);
            panelDatos.actualizarInterfaz(resultado);
        }
    }

    public Reserva cancelarReservasAsociadasAUnaConvencion() {
        return null;
    }
    
    
    
}
