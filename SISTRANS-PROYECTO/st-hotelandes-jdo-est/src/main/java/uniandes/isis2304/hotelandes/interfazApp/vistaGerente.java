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
import uniandes.isis2304.hotelandes.negocio.Usuario;
import uniandes.isis2304.hotelandes.negocio.VOHabitacion;
import uniandes.isis2304.hotelandes.negocio.VOServicio;

public class vistaGerente extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    /*
     * ****************************************************************
     * Atributos
     *****************************************************************/
    private static Logger log = Logger.getLogger(vistaGerente.class.getName());
    private static final String CONFIG_INTERFAZ = "./src/main/resources/config/configuracionGerente.json";
    private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A.json";
    private JsonObject tableConfig;
    private HotelAndes hotelandes;
    private JsonObject guiConfig;
    private PanelDatos panelDatos;
    private JMenuBar menuBar;
    private JFrame Ventana;
    private Login_Register login;
    private Usuario usuario;

    public vistaGerente(Login_Register login,Usuario gerente) {
        Ventana = this;
        usuario=gerente;
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

    private JsonObject openConfig(String tipo, String archConfig) {
        JsonObject config = null;
        try {
            Gson gson = new Gson();
            FileReader file = new FileReader(archConfig);
            JsonReader reader = new JsonReader(file);
            config = gson.fromJson(reader, JsonObject.class);
            log.info("Se encontró un archivo de configuración válido: " + tipo);
        } catch (Exception e) {
            // e.printStackTrace ();
            log.info("NO se encontró un archivo de configuración válido");
            JOptionPane.showMessageDialog(null,
                    "No se encontró un archivo de configuración de interfaz válido: " + tipo, "HotelAndes App",
                    JOptionPane.ERROR_MESSAGE);
        }
        return config;
    }

    private void configurarFrame() {

        int alto = 0;
        int ancho = 0;
        String titulo = "";

        if (guiConfig == null) {
            log.info("Se aplica configuración por defecto");
            titulo = "HotelAndes APP Default";
            alto = 300;
            ancho = 500;
        } else {
            log.info("Se aplica configuración indicada en el archivo de configuración");
            titulo = guiConfig.get("title").getAsString();
            alto = guiConfig.get("frameH").getAsInt();
            ancho = guiConfig.get("frameW").getAsInt();
        }

        setLocation(50, 50);
        setResizable(true);
        setBackground(Color.WHITE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Ventana.dispose();
                login.setVisible(true);
                hotelandes.cerrarUnidadPersistencia();
            }
        });
        setTitle(titulo);
        setSize(ancho, alto);
        this.setVisible(true);
    }

    /**
     * Método para crear el menú de la aplicación con base em el objeto JSON leído
     * Genera una barra de menú y los menús con sus respectivas opciones
     * 
     * @param jsonMenu - Arreglo Json con los menùs deseados
     */
    private void crearMenu(JsonArray jsonMenu) {
        // Creación de la barra de menús
        menuBar = new JMenuBar();
        for (JsonElement men : jsonMenu) {
            // Creación de cada uno de los menús
            JsonObject jom = men.getAsJsonObject();

            String menuTitle = jom.get("menuTitle").getAsString();
            JsonArray opciones = jom.getAsJsonArray("options");

            JMenu menu = new JMenu(menuTitle);

            for (JsonElement op : opciones) {
                // Creación de cada una de las opciones del menú
                JsonObject jo = op.getAsJsonObject();
                String lb = jo.get("label").getAsString();
                String event = jo.get("event").getAsString();

                JMenuItem mItem = new JMenuItem(lb);
                mItem.addActionListener(this);
                mItem.setActionCommand(event);

                menu.add(mItem);
            }
            menuBar.add(menu);
        }
        setJMenuBar(menuBar);
    }

    @Override
    public void actionPerformed(ActionEvent pEvento) {
        String evento = pEvento.getActionCommand();
        try {
            Method req = vistaGerente.class.getMethod(evento);
            req.invoke(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private String generarMensajeError(Exception e) {
        String resultado = "************ Error en la ejecución\n";
        resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
        resultado += "\n\nRevise datanucleus.log y hotelandes.log para más detalles";
        return resultado;
    }

    private String darDetalleException(Exception e) {
        String resp = "";
        if (e.getClass().getName().equals("javax.jdo.JDODataStoreException")) {
            JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
            return je.getNestedExceptions()[0].getMessage();
        }
        return resp;
    }
    public void adicionarMantenimientoServicio(){
        try {
            
            // Timestamp diaHoraMantenimientoInicial = Timestamp.valueOf(JOptionPane.showInputDialog(this, "Fecha de entrada",
            //         "adicionarMantenimientoServicio", JOptionPane.QUESTION_MESSAGE)+":00");
                    
            // Timestamp diaHoraMantenimientoFinal = Timestamp.valueOf(JOptionPane.showInputDialog(this, "Fecha de salida", "adicionarMantenimientoServicio",
            //         JOptionPane.QUESTION_MESSAGE)+":00");

            // Boolean decision=Boolean.valueOf(JOptionPane.showInputDialog(this, "¿Desea añadir un mantenimiento a un servicio?", "adicionarMantenimientoServicio",
            //         JOptionPane.QUESTION_MESSAGE));
            // String razon = JOptionPane.showInputDialog(this, "Razón del mantenimiento", "adicionarMantenimientoServicio",
            //         JOptionPane.QUESTION_MESSAGE);
            Timestamp diaHoraMantenimientoInicial=Timestamp.valueOf("2022-05-28 14:10:00.0");
            Timestamp diaHoraMantenimientoFinal=Timestamp.valueOf("2022-06-28 14:10:00.0");
            Boolean decision=true;
            String razon="xd";
            if(decision){
                Long idServicio = Long.valueOf(JOptionPane.showInputDialog(this, "ID del servicio", "adicionarMantenimientoServicio",
                        JOptionPane.QUESTION_MESSAGE));
                
                VOServicio servicio= hotelandes.adicionarMantenimientoServicio(idServicio, diaHoraMantenimientoInicial, diaHoraMantenimientoFinal,razon);
                JOptionPane.showMessageDialog(this, "Se ha añadido el mantenimiento al servicio" + servicio.getIdServicio()  , "adicionarMantenimientoServicio",
                        JOptionPane.INFORMATION_MESSAGE);
                String resultado = "";
                resultado += "Servicio: " + servicio.getIdServicio() + "\n";
                
                
            }
            else{
                Long idHabitacion = Long.valueOf(JOptionPane.showInputDialog(this, "ID de la habitación", "adicionarMantenimientoServicio",
                        JOptionPane.QUESTION_MESSAGE));
                VOHabitacion habitacion=hotelandes.adicionarMantenimientoHabitacion(idHabitacion, diaHoraMantenimientoInicial, diaHoraMantenimientoFinal,razon);

            }
        }
        catch (Exception e) {
            String resultado = generarMensajeError(e);
            panelDatos.actualizarInterfaz(resultado);
        }

    }
    public void eliminarMantenimientoServicio(){

    }

}
