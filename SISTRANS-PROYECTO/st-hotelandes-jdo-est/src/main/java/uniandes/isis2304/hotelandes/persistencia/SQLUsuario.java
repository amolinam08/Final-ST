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
}