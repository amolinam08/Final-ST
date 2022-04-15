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
	public Long eliminarServicioprestamoPorFechaprestamo (PersistenceManager pm,Timestamp Fechaprestamo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicioprestamo () + " WHERE fechaPrestamo=?");
		q.setParameters(Fechaprestamo);
		return (Long) q.executeUnique();
	}
	public List<Servicioprestamo> darServicioprestamoPorFechaprestamo (PersistenceManager pm,Timestamp Fechaprestamo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicioprestamo () + " WHERE fechaPrestamo=?");
		q.setResultClass(Servicioprestamo.class);
		q.setParameters(Fechaprestamo);
		return (List<Servicioprestamo>) q.executeList();
	}
	public void actualizarFechaprestamo(PersistenceManager pm,Timestamp Fechaprestamo,Long idPrestamo)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicioprestamo () + " SET fechaPrestamo=? WHERE idPrestamo=?");
		q.setParameters(Fechaprestamo,idPrestamo);
		q.executeUnique();
	}
	public Long eliminarServicioprestamoPorFechareintegro (PersistenceManager pm,Timestamp Fechareintegro)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicioprestamo () + " WHERE fechaReintegro=?");
		q.setParameters(Fechareintegro);
		return (Long) q.executeUnique();
	}
	public List<Servicioprestamo> darServicioprestamoPorFechareintegro (PersistenceManager pm,Timestamp Fechareintegro)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicioprestamo () + " WHERE fechaReintegro=?");
		q.setResultClass(Servicioprestamo.class);
		q.setParameters(Fechareintegro);
		return (List<Servicioprestamo>) q.executeList();
	}
	public void actualizarFechareintegro(PersistenceManager pm,Timestamp Fechareintegro,Long idPrestamo)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicioprestamo () + " SET fechaReintegro=? WHERE idPrestamo=?");
		q.setParameters(Fechareintegro,idPrestamo);
		q.executeUnique();
	}
	public Long eliminarServicioprestamoPorConsumo (PersistenceManager pm,Long Consumo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicioprestamo () + " WHERE consumo=?");
		q.setParameters(Consumo);
		return (Long) q.executeUnique();
	}
	public List<Servicioprestamo> darServicioprestamoPorConsumo (PersistenceManager pm,Long Consumo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicioprestamo () + " WHERE consumo=?");
		q.setResultClass(Servicioprestamo.class);
		q.setParameters(Consumo);
		return (List<Servicioprestamo>) q.executeList();
	}
	public void actualizarConsumo(PersistenceManager pm,Long Consumo,Long idPrestamo)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicioprestamo () + " SET consumo=? WHERE idPrestamo=?");
		q.setParameters(Consumo,idPrestamo);
		q.executeUnique();
	}
}
