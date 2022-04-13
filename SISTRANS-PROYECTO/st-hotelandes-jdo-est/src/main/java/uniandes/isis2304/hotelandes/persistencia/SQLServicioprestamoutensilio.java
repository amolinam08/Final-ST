package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Servicioprestamoutensilio;
import java.sql.Timestamp;

class SQLServicioprestamoutensilio
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLServicioprestamoutensilio (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarServicioprestamoutensilio(PersistenceManager pm,Long idServicioPrestamo,Long idUtensilio)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaServicioprestamoutensilio () + "(idServicioPrestamo,idUtensilio) values (?,?)");
		q.setParameters(idServicioPrestamo,idUtensilio);
		return (Long) q.executeUnique();
	}
	public Long eliminarServicioprestamoutensilioPorId (PersistenceManager pm,Long idServicioPrestamo,Long idUtensilio)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicioprestamoutensilio () + " WHERE idServicioPrestamo=? and idUtensilio=?");
		q.setParameters(idServicioPrestamo,idUtensilio);
		return (Long) q.executeUnique();
	}
	public Servicioprestamoutensilio darServicioprestamoutensilioPorId (PersistenceManager pm,Long idServicioPrestamo,Long idUtensilio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicioprestamoutensilio() + " WHERE idServicioPrestamo=? and idUtensilio=?");
		q.setResultClass(Servicioprestamoutensilio.class);
		q.setParameters(idServicioPrestamo,idUtensilio);
		return (Servicioprestamoutensilio) q.executeUnique();
	}
	public List<Servicioprestamoutensilio> darServicioprestamoutensilios (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicioprestamoutensilio());
		q.setResultClass(Servicioprestamoutensilio.class);
		return (List<Servicioprestamoutensilio>) q.executeList();
	}
	public Long eliminarServicioprestamoutensilioPorIdservicioprestamo (PersistenceManager pm,Long Idservicioprestamo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicioprestamoutensilio () + " WHERE idServicioPrestamo=?");
		q.setParameters(Idservicioprestamo);
		return (Long) q.executeUnique();
	}
	public List<Servicioprestamoutensilio> darServicioprestamoutensilioPorIdservicioprestamo (PersistenceManager pm,Long Idservicioprestamo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicioprestamoutensilio () + " WHERE idServicioPrestamo=?");
		q.setResultClass(Servicioprestamoutensilio.class);
		q.setParameters(Idservicioprestamo);
		return (List<Servicioprestamoutensilio>) q.executeList();
	}
	public Long eliminarServicioprestamoutensilioPorIdutensilio (PersistenceManager pm,Long Idutensilio)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicioprestamoutensilio () + " WHERE idUtensilio=?");
		q.setParameters(Idutensilio);
		return (Long) q.executeUnique();
	}
	public List<Servicioprestamoutensilio> darServicioprestamoutensilioPorIdutensilio (PersistenceManager pm,Long Idutensilio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicioprestamoutensilio () + " WHERE idUtensilio=?");
		q.setResultClass(Servicioprestamoutensilio.class);
		q.setParameters(Idutensilio);
		return (List<Servicioprestamoutensilio>) q.executeList();
	}
}