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
	public Long adicionarUsuario(PersistenceManager pm,Long idUsuario,String pazSalvo,String tipoDocumento,String numeroDocumento,String correo,String nombre,Long cuenta,Long tipoUsuario,Long acompanante,String contrasena)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaUsuario () + "(idUsuario,pazSalvo,tipoDocumento,numeroDocumento,correo,nombre,cuenta,tipoUsuario,acompanante,contrasena) values (?,?,?,?,?,?,?,?,?,?)");
		q.setParameters(idUsuario,pazSalvo,tipoDocumento,numeroDocumento,correo,nombre,cuenta,tipoUsuario,acompanante,contrasena);
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
}