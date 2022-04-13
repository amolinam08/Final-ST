package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Hotelusuario;
import java.sql.Timestamp;

class SQLHotelusuario
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLHotelusuario (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarHotelusuario(PersistenceManager pm,Long idHotel,Long idUsuario)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaHotelusuario () + "(idHotel,idUsuario) values (?,?)");
		q.setParameters(idHotel,idUsuario);
		return (Long) q.executeUnique();
	}
	public Long eliminarHotelusuarioPorId (PersistenceManager pm,Long idHotel,Long idUsuario)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHotelusuario () + " WHERE idHotel=? and idUsuario=?");
		q.setParameters(idHotel,idUsuario);
		return (Long) q.executeUnique();
	}
	public Hotelusuario darHotelusuarioPorId (PersistenceManager pm,Long idHotel,Long idUsuario)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotelusuario() + " WHERE idHotel=? and idUsuario=?");
		q.setResultClass(Hotelusuario.class);
		q.setParameters(idHotel,idUsuario);
		return (Hotelusuario) q.executeUnique();
	}
	public List<Hotelusuario> darHotelusuarios (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotelusuario());
		q.setResultClass(Hotelusuario.class);
		return (List<Hotelusuario>) q.executeList();
	}
	public Long eliminarHotelusuarioPorIdhotel (PersistenceManager pm,Long Idhotel)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHotelusuario () + " WHERE idHotel=?");
		q.setParameters(Idhotel);
		return (Long) q.executeUnique();
	}
	public List<Hotelusuario> darHotelusuarioPorIdhotel (PersistenceManager pm,Long Idhotel)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotelusuario () + " WHERE idHotel=?");
		q.setResultClass(Hotelusuario.class);
		q.setParameters(Idhotel);
		return (List<Hotelusuario>) q.executeList();
	}
	public Long eliminarHotelusuarioPorIdusuario (PersistenceManager pm,Long Idusuario)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHotelusuario () + " WHERE idUsuario=?");
		q.setParameters(Idusuario);
		return (Long) q.executeUnique();
	}
	public List<Hotelusuario> darHotelusuarioPorIdusuario (PersistenceManager pm,Long Idusuario)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotelusuario () + " WHERE idUsuario=?");
		q.setResultClass(Hotelusuario.class);
		q.setParameters(Idusuario);
		return (List<Hotelusuario>) q.executeList();
	}
}