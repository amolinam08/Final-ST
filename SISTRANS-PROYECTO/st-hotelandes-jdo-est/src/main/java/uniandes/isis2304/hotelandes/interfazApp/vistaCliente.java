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
import javax.swing.UnsupportedLookAndFeelException;


import org.apache.log4j.Logger;

import uniandes.isis2304.hotelandes.negocio.HotelAndes;

public class vistaCliente extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    /* ****************************************************************
     * 			Atributos
     *****************************************************************/
    private static Logger log = Logger.getLogger(InterfazHotelAndesApp.class.getName());
    private static final String CONFIG_INTERFAZ = "./src/main/resources/config/configuracionCliente.json";
    private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A.json"; 

    private JsonObject tableConfig;
    private HotelAndes hotelandes;
    private JsonObject guiConfig;
    private PanelDatos panelDatos;
    private JMenuBar menuBar;
    /*Constructor*/
    public vistaCliente() 
    {
        guiConfig = openConfig("Interfaz", CONFIG_INTERFAZ);
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

    /**
     *
     */

    @Override
    public void actionPerformed(ActionEvent pEvento) {
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
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
        vistaCliente vista = new vistaCliente();
        vista.setVisible(true);
    }
    
}
