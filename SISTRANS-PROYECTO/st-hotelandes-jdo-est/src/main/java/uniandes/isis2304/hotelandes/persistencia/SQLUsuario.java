package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Usuario;
import java.sql.Timestamp;

class SQLUsuario
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLUsuario (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarUsuario(PersistenceManager pm,Long idUsuario,String pazSalvo,String tipoDocumento,String numeroDocumento,String correo,String nombre,Long cuenta,Long tipoUsuario,Long acompanante,String contrasena,Long idConvencion)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaUsuario () + "(idUsuario,pazSalvo,tipoDocumento,numeroDocumento,correo,nombre,cuenta,tipoUsuario,acompanante,contrasena,idConvencion) values (?,?,?,?,?,?,?,?,?,?,?)");
		q.setParameters(idUsuario,pazSalvo,tipoDocumento,numeroDocumento,correo,nombre,cuenta,tipoUsuario,acompanante,contrasena,idConvencion);
		return (Long) q.executeUnique();
	}
	public Long eliminarUsuarioPorId (PersistenceManager pm,Long idUsuario)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUsuario () + " WHERE idUsuario=?");
		q.setParameters(idUsuario);
		return (Long) q.executeUnique();
	}
	public Usuario darUsuarioPorId (PersistenceManager pm,Long idUsuario)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuario() + " WHERE idUsuario=?");
		q.setResultClass(Usuario.class);
		q.setParameters(idUsuario);
		return (Usuario) q.executeUnique();
	}
	public List<Usuario> darUsuarios (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuario());
		q.setResultClass(Usuario.class);
		return (List<Usuario>) q.executeList();
	}
	public Long eliminarUsuarioPorPazsalvo (PersistenceManager pm,String Pazsalvo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUsuario () + " WHERE pazSalvo=?");
		q.setParameters(Pazsalvo);
		return (Long) q.executeUnique();
	}
	public List<Usuario> darUsuarioPorPazsalvo (PersistenceManager pm,String Pazsalvo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuario () + " WHERE pazSalvo=?");
		q.setResultClass(Usuario.class);
		q.setParameters(Pazsalvo);
		return (List<Usuario>) q.executeList();
	}
	public void actualizarPazsalvo(PersistenceManager pm,String Pazsalvo,Long idUsuario)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaUsuario () + " SET pazSalvo=? WHERE idUsuario=?");
		q.setParameters(Pazsalvo,idUsuario);
		q.executeUnique();
	}
	public Long eliminarUsuarioPorTipodocumento (PersistenceManager pm,String Tipodocumento)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUsuario () + " WHERE tipoDocumento=?");
		q.setParameters(Tipodocumento);
		return (Long) q.executeUnique();
	}
	public List<Usuario> darUsuarioPorTipodocumento (PersistenceManager pm,String Tipodocumento)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuario () + " WHERE tipoDocumento=?");
		q.setResultClass(Usuario.class);
		q.setParameters(Tipodocumento);
		return (List<Usuario>) q.executeList();
	}
	public void actualizarTipodocumento(PersistenceManager pm,String Tipodocumento,Long idUsuario)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaUsuario () + " SET tipoDocumento=? WHERE idUsuario=?");
		q.setParameters(Tipodocumento,idUsuario);
		q.executeUnique();
	}
	public Long eliminarUsuarioPorNumerodocumento (PersistenceManager pm,String Numerodocumento)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUsuario () + " WHERE numeroDocumento=?");
		q.setParameters(Numerodocumento);
		return (Long) q.executeUnique();
	}
	public List<Usuario> darUsuarioPorNumerodocumento (PersistenceManager pm,String Numerodocumento)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuario () + " WHERE numeroDocumento=?");
		q.setResultClass(Usuario.class);
		q.setParameters(Numerodocumento);
		return (List<Usuario>) q.executeList();
	}
	public void actualizarNumerodocumento(PersistenceManager pm,String Numerodocumento,Long idUsuario)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaUsuario () + " SET numeroDocumento=? WHERE idUsuario=?");
		q.setParameters(Numerodocumento,idUsuario);
		q.executeUnique();
	}
	public Long eliminarUsuarioPorCorreo (PersistenceManager pm,String Correo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUsuario () + " WHERE correo=?");
		q.setParameters(Correo);
		return (Long) q.executeUnique();
	}
	public List<Usuario> darUsuarioPorCorreo (PersistenceManager pm,String Correo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuario () + " WHERE correo=?");
		q.setResultClass(Usuario.class);
		q.setParameters(Correo);
		return (List<Usuario>) q.executeList();
	}
	public void actualizarCorreo(PersistenceManager pm,String Correo,Long idUsuario)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaUsuario () + " SET correo=? WHERE idUsuario=?");
		q.setParameters(Correo,idUsuario);
		q.executeUnique();
	}
	public Long eliminarUsuarioPorNombre (PersistenceManager pm,String Nombre)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUsuario () + " WHERE nombre=?");
		q.setParameters(Nombre);
		return (Long) q.executeUnique();
	}
	public List<Usuario> darUsuarioPorNombre (PersistenceManager pm,String Nombre)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuario () + " WHERE nombre=?");
		q.setResultClass(Usuario.class);
		q.setParameters(Nombre);
		return (List<Usuario>) q.executeList();
	}
	public void actualizarNombre(PersistenceManager pm,String Nombre,Long idUsuario)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaUsuario () + " SET nombre=? WHERE idUsuario=?");
		q.setParameters(Nombre,idUsuario);
		q.executeUnique();
	}
	public Long eliminarUsuarioPorCuenta (PersistenceManager pm,Long Cuenta)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUsuario () + " WHERE cuenta=?");
		q.setParameters(Cuenta);
		return (Long) q.executeUnique();
	}
	public List<Usuario> darUsuarioPorCuenta (PersistenceManager pm,Long Cuenta)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuario () + " WHERE cuenta=?");
		q.setResultClass(Usuario.class);
		q.setParameters(Cuenta);
		return (List<Usuario>) q.executeList();
	}
	public void actualizarCuenta(PersistenceManager pm,Long Cuenta,Long idUsuario)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaUsuario () + " SET cuenta=? WHERE idUsuario=?");
		q.setParameters(Cuenta,idUsuario);
		q.executeUnique();
	}
	public Long eliminarUsuarioPorTipousuario (PersistenceManager pm,Long Tipousuario)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUsuario () + " WHERE tipoUsuario=?");
		q.setParameters(Tipousuario);
		return (Long) q.executeUnique();
	}
	public List<Usuario> darUsuarioPorTipousuario (PersistenceManager pm,Long Tipousuario)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuario () + " WHERE tipoUsuario=?");
		q.setResultClass(Usuario.class);
		q.setParameters(Tipousuario);
		return (List<Usuario>) q.executeList();
	}
	public void actualizarTipousuario(PersistenceManager pm,Long Tipousuario,Long idUsuario)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaUsuario () + " SET tipoUsuario=? WHERE idUsuario=?");
		q.setParameters(Tipousuario,idUsuario);
		q.executeUnique();
	}
	public Long eliminarUsuarioPorAcompanante (PersistenceManager pm,Long Acompanante)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUsuario () + " WHERE acompanante=?");
		q.setParameters(Acompanante);
		return (Long) q.executeUnique();
	}
	public List<Usuario> darUsuarioPorAcompanante (PersistenceManager pm,Long Acompanante)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuario () + " WHERE acompanante=?");
		q.setResultClass(Usuario.class);
		q.setParameters(Acompanante);
		return (List<Usuario>) q.executeList();
	}
	public void actualizarAcompanante(PersistenceManager pm,Long Acompanante,Long idUsuario)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaUsuario () + " SET acompanante=? WHERE idUsuario=?");
		q.setParameters(Acompanante,idUsuario);
		q.executeUnique();
	}
	public Long eliminarUsuarioPorContrasena (PersistenceManager pm,String Contrasena)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUsuario () + " WHERE contrasena=?");
		q.setParameters(Contrasena);
		return (Long) q.executeUnique();
	}
	public List<Usuario> darUsuarioPorContrasena (PersistenceManager pm,String Contrasena)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuario () + " WHERE contrasena=?");
		q.setResultClass(Usuario.class);
		q.setParameters(Contrasena);
		return (List<Usuario>) q.executeList();
	}
	public void actualizarContrasena(PersistenceManager pm,String Contrasena,Long idUsuario)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaUsuario () + " SET contrasena=? WHERE idUsuario=?");
		q.setParameters(Contrasena,idUsuario);
		q.executeUnique();
	}
	public Long eliminarUsuarioPorIdconvencion (PersistenceManager pm,Long Idconvencion)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUsuario () + " WHERE idConvencion=?");
		q.setParameters(Idconvencion);
		return (Long) q.executeUnique();
	}
	public List<Usuario> darUsuarioPorIdconvencion (PersistenceManager pm,Long Idconvencion)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuario () + " WHERE idConvencion=?");
		q.setResultClass(Usuario.class);
		q.setParameters(Idconvencion);
		return (List<Usuario>) q.executeList();
	}
	public void actualizarIdconvencion(PersistenceManager pm,Long Idconvencion,Long idUsuario)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaUsuario () + " SET idConvencion=? WHERE idUsuario=?");
		q.setParameters(Idconvencion,idUsuario);
		q.executeUnique();
	}
	public List<Usuario> darPorCorreoContrasena (PersistenceManager pm,String correo,String Contrasena)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuario() + " WHERE correo=? AND contrasena=?");
		q.setResultClass(Usuario.class);
		q.setParameters(correo, Contrasena);
		return (List<Usuario>) q.executeList();
	}
}
