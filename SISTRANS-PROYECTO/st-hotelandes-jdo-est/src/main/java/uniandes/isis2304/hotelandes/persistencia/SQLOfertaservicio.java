package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Ofertaservicio;
import java.sql.Timestamp;

class SQLOfertaservicio
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLOfertaservicio (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarOfertaservicio(PersistenceManager pm,Long idOfertaServicio,Double costo,Double duracion,Long servicio)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaOfertaservicio () + "(idOfertaServicio,costo,duracion,servicio) values (?,?,?,?)");
		q.setParameters(idOfertaServicio,costo,duracion,servicio);
		return (Long) q.executeUnique();
	}
	public Long eliminarOfertaservicioPorId (PersistenceManager pm,Long idOfertaServicio)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOfertaservicio () + " WHERE idOfertaServicio=?");
		q.setParameters(idOfertaServicio);
		return (Long) q.executeUnique();
	}
	public Ofertaservicio darOfertaservicioPorId (PersistenceManager pm,Long idOfertaServicio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOfertaservicio() + " WHERE idOfertaServicio=?");
		q.setResultClass(Ofertaservicio.class);
		q.setParameters(idOfertaServicio);
		return (Ofertaservicio) q.executeUnique();
	}
	public List<Ofertaservicio> darOfertaservicios (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOfertaservicio());
		q.setResultClass(Ofertaservicio.class);
		return (List<Ofertaservicio>) q.executeList();
	}
	public Long eliminarOfertaservicioPorCosto (PersistenceManager pm,Double Costo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOfertaservicio () + " WHERE costo=?");
		q.setParameters(Costo);
		return (Long) q.executeUnique();
	}
	public List<Ofertaservicio> darOfertaservicioPorCosto (PersistenceManager pm,Double Costo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOfertaservicio () + " WHERE costo=?");
		q.setResultClass(Ofertaservicio.class);
		q.setParameters(Costo);
		return (List<Ofertaservicio>) q.executeList();
	}
	public Long eliminarOfertaservicioPorDuracion (PersistenceManager pm,Double Duracion)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOfertaservicio () + " WHERE duracion=?");
		q.setParameters(Duracion);
		return (Long) q.executeUnique();
	}
	public List<Ofertaservicio> darOfertaservicioPorDuracion (PersistenceManager pm,Double Duracion)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOfertaservicio () + " WHERE duracion=?");
		q.setResultClass(Ofertaservicio.class);
		q.setParameters(Duracion);
		return (List<Ofertaservicio>) q.executeList();
	}
	public Long eliminarOfertaservicioPorServicio (PersistenceManager pm,Long Servicio)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOfertaservicio () + " WHERE servicio=?");
		q.setParameters(Servicio);
		return (Long) q.executeUnique();
	}
	public List<Ofertaservicio> darOfertaservicioPorServicio (PersistenceManager pm,Long Servicio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOfertaservicio () + " WHERE servicio=?");
		q.setResultClass(Ofertaservicio.class);
		q.setParameters(Servicio);
		return (List<Ofertaservicio>) q.executeList();
	}
}