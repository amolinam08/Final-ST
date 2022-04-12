package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Servicioprestamo;
import java.sql.Timestamp;

class SQLServicioprestamo
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLServicioprestamo (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarServicioprestamo(PersistenceManager pm,Long idPrestamo,Timestamp fechaPrestamo,Timestamp fechaReintegro,Long consumo)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaServicioprestamo () + "(idPrestamo,fechaPrestamo,fechaReintegro,consumo) values (?,?,?,?)");
		q.setParameters(idPrestamo,fechaPrestamo,fechaReintegro,consumo);
		return (Long) q.executeUnique();
	}
	public Long eliminarServicioprestamoPorId (PersistenceManager pm,Long idPrestamo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicioprestamo () + " WHERE idPrestamo=?");
		q.setParameters(idPrestamo);
		return (Long) q.executeUnique();
	}
	public Servicioprestamo darServicioprestamoPorId (PersistenceManager pm,Long idPrestamo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicioprestamo() + " WHERE idPrestamo=?");
		q.setResultClass(Servicioprestamo.class);
		q.setParameters(idPrestamo);
		return (Servicioprestamo) q.executeUnique();
	}
	public List<Servicioprestamo> darServicioprestamos (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicioprestamo());
		q.setResultClass(Servicioprestamo.class);
		return (List<Servicioprestamo>) q.executeList();
	}
}