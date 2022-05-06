package uniandes.isis2304.hotelandes.interfazApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import uniandes.isis2304.hotelandes.negocio.Usuario;


public class Login {
	private String Rol;
	private Long id;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "BRAITO";
	private String password = "123";
	private Boolean AccesoCorrecto = false;
	private Usuario empleado;

	

	public Login(User userX) throws SQLException, ClassNotFoundException {
		String sql = "select * from USUARIO where correo=? and contrasena=?";

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, password);
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, userX.getCorreo());
		ps.setString(2, userX.getContrasena());
		ResultSet rs = ps.executeQuery();
		AccesoCorrecto = rs.next();
		empleado = new Usuario();
		
		Long idUsuario = rs.getLong("IDUSUARIO");
		String pazSalvo = rs.getString("PAZSALVO");
		String tipoDocumento = rs.getString("TIPODOCUMENTO");
		String numeroDocumento = rs.getString("NUMERODOCUMENTO");
		String correo = rs.getString("CORREO");
		String nombre = rs.getString("NOMBRE");
		Long cuenta = rs.getLong("CUENTA");
		Long tipoUsuario = rs.getLong("TIPOUSUARIO");
		Long acompanante = rs.getLong("ACOMPANANTE");
		String contrasena = rs.getString("CONTRASENA");
		empleado.setIdUsuario(idUsuario);
		empleado.setPazSalvo(pazSalvo);
		empleado.setTipoDocumento(tipoDocumento);
		empleado.setNumeroDocumento(numeroDocumento);
		empleado.setCorreo(correo);
		empleado.setNombre(nombre);
		empleado.setCuenta(cuenta);
		empleado.setTipoUsuario(tipoUsuario);
		empleado.setAcompanante(acompanante);
		empleado.setContrasena(contrasena);
		if (AccesoCorrecto) {
			id = rs.getLong(1);

			ResultSet rol = conn.prepareStatement("Select * from TipoUsuario where idTipoUsuario=" + rs.getString(8))
					.executeQuery();
			rol.next();
			Rol = rol.getString(2);
		}
		else {
			throw new SQLException("Usuario o contraseña incorrectos");
		}
		rs.close();
		ps.close();
		conn.close();
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

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getAccesoCorrecto() {
		return AccesoCorrecto;
	}

	public void setAccesoCorrecto(Boolean accesoCorrecto) {
		AccesoCorrecto = accesoCorrecto;
	}
	
}