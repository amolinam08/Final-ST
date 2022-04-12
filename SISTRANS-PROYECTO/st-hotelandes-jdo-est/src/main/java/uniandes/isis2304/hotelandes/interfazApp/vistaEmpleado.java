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

public class vistaEmpleado extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    /* ****************************************************************
     * 			Atributos
     *****************************************************************/
    private static Logger log = Logger.getLogger(InterfazHotelAndesApp.class.getName());
    private static final String CONFIG_INTERFAZ = "./src/main/resources/config/configuracionEmpleado.json";
    private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A.json";
    private JsonObject tableConfig;
    private HotelAndes hotelandes;
    private JsonObject guiConfig;
    private PanelDatos panelDatos;
    private JMenuBar menuBar;
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
        vistaEmpleado vista = new vistaEmpleado();
        vista.setVisible(true);
    }
    
}
