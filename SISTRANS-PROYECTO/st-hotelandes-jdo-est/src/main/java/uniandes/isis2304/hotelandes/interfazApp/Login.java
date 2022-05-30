package uniandes.isis2304.hotelandes.interfazApp;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import uniandes.isis2304.hotelandes.negocio.HotelAndes;
import uniandes.isis2304.hotelandes.negocio.Usuario;
import org.apache.log4j.Logger;

public class Login {
	private String Rol;
	private Long id;
	private HotelAndes hotelandes;
	private Boolean AccesoCorrecto = false;
	private List user;
	private Usuario empleado;
	private static Logger log = Logger.getLogger(Login.class.getName());
    private JsonObject tableConfig;

	/**
	 * Ruta al archivo de configuración de la interfaz
	 */
	private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A.json"; 

	

	public Login(User userX) throws SQLException, ClassNotFoundException {
		tableConfig = openConfig("Tablas BD", CONFIG_TABLAS);
		hotelandes = new HotelAndes(tableConfig);
		user = hotelandes.iniciarSesion(userX.getCorreo(),userX.getContrasena());
		
		if (user.size() > 0) {
			empleado = (Usuario) user.get(0);
			Rol = user.get(1).toString();
		} else {
			throw new SQLException("Usuario o contraseña incorrectos");
		}

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
	public Usuario getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Usuario empleado) {
		this.empleado = empleado;
	}
	public String getRol() {
		return Rol;
	}

	public void setRol(String rol) {
		Rol = rol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Boolean getAccesoCorrecto() {
		return AccesoCorrecto;
	}

	public void setAccesoCorrecto(Boolean accesoCorrecto) {
		AccesoCorrecto = accesoCorrecto;
	}
	
}