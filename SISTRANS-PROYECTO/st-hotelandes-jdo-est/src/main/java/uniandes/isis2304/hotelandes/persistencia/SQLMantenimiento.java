package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Mantenimiento;
import java.sql.Timestamp;

class SQLMantenimiento
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLMantenimiento (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarMantenimiento(PersistenceManager pm,Long idMantenimiento,Timestamp fechaInicio,Timestamp fechaFin,String descripcion,Long servicio,Long habitacion)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaMantenimiento () + "(idMantenimiento,fechaInicio,fechaFin,descripcion,servicio,habitacion) values (?,?,?,?,?,?)");
		q.setParameters(idMantenimiento,fechaInicio,fechaFin,descripcion,servicio,habitacion);
		return (Long) q.executeUnique();
	}
	public Long eliminarMantenimientoPorId (PersistenceManager pm,Long idMantenimiento)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMantenimiento () + " WHERE idMantenimiento=?");
		q.setParameters(idMantenimiento);
		return (Long) q.executeUnique();
	}
	public Mantenimiento darMantenimientoPorId (PersistenceManager pm,Long idMantenimiento)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMantenimiento() + " WHERE idMantenimiento=?");
		q.setResultClass(Mantenimiento.class);
		q.setParameters(idMantenimiento);
		return (Mantenimiento) q.executeUnique();
	}
	public List<Mantenimiento> darMantenimientos (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMantenimiento());
		q.setResultClass(Mantenimiento.class);
		return (List<Mantenimiento>) q.executeList();
	}
	public Long eliminarMantenimientoPorFechainicio (PersistenceManager pm,Timestamp Fechainicio)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMantenimiento () + " WHERE fechaInicio=?");
		q.setParameters(Fechainicio);
		return (Long) q.executeUnique();
	}
	public List<Mantenimiento> darMantenimientoPorFechainicio (PersistenceManager pm,Timestamp Fechainicio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMantenimiento () + " WHERE fechaInicio=?");
		q.setResultClass(Mantenimiento.class);
		q.setParameters(Fechainicio);
		return (List<Mantenimiento>) q.executeList();
	}
	public void actualizarFechainicio(PersistenceManager pm,Timestamp Fechainicio,Long idMantenimiento)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaMantenimiento () + " SET fechaInicio=? WHERE idMantenimiento=?");
		q.setParameters(Fechainicio,idMantenimiento);
		q.executeUnique();
	}
	public Long eliminarMantenimientoPorFechafin (PersistenceManager pm,Timestamp Fechafin)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMantenimiento () + " WHERE fechaFin=?");
		q.setParameters(Fechafin);
		return (Long) q.executeUnique();
	}
	public List<Mantenimiento> darMantenimientoPorFechafin (PersistenceManager pm,Timestamp Fechafin)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMantenimiento () + " WHERE fechaFin=?");
		q.setResultClass(Mantenimiento.class);
		q.setParameters(Fechafin);
		return (List<Mantenimiento>) q.executeList();
	}
	public void actualizarFechafin(PersistenceManager pm,Timestamp Fechafin,Long idMantenimiento)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaMantenimiento () + " SET fechaFin=? WHERE idMantenimiento=?");
		q.setParameters(Fechafin,idMantenimiento);
		q.executeUnique();
	}
	public Long eliminarMantenimientoPorDescripcion (PersistenceManager pm,String Descripcion)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMantenimiento () + " WHERE descripcion=?");
		q.setParameters(Descripcion);
		return (Long) q.executeUnique();
	}
	public List<Mantenimiento> darMantenimientoPorDescripcion (PersistenceManager pm,String Descripcion)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMantenimiento () + " WHERE descripcion=?");
		q.setResultClass(Mantenimiento.class);
		q.setParameters(Descripcion);
		return (List<Mantenimiento>) q.executeList();
	}
	public void actualizarDescripcion(PersistenceManager pm,String Descripcion,Long idMantenimiento)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaMantenimiento () + " SET descripcion=? WHERE idMantenimiento=?");
		q.setParameters(Descripcion,idMantenimiento);
		q.executeUnique();
	}
	public Long eliminarMantenimientoPorServicio (PersistenceManager pm,Long Servicio)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMantenimiento () + " WHERE servicio=?");
		q.setParameters(Servicio);
		return (Long) q.executeUnique();
	}
	public List<Mantenimiento> darMantenimientoPorServicio (PersistenceManager pm,Long Servicio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMantenimiento () + " WHERE servicio=?");
		q.setResultClass(Mantenimiento.class);
		q.setParameters(Servicio);
		return (List<Mantenimiento>) q.executeList();
	}
	public void actualizarServicio(PersistenceManager pm,Long Servicio,Long idMantenimiento)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaMantenimiento () + " SET servicio=? WHERE idMantenimiento=?");
		q.setParameters(Servicio,idMantenimiento);
		q.executeUnique();
	}
	public Long eliminarMantenimientoPorHabitacion (PersistenceManager pm,Long Habitacion)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMantenimiento () + " WHERE habitacion=?");
		q.setParameters(Habitacion);
		return (Long) q.executeUnique();
	}
	public List<Mantenimiento> darMantenimientoPorHabitacion (PersistenceManager pm,Long Habitacion)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMantenimiento () + " WHERE habitacion=?");
		q.setResultClass(Mantenimiento.class);
		q.setParameters(Habitacion);
		return (List<Mantenimiento>) q.executeList();
	}
	public void actualizarHabitacion(PersistenceManager pm,Long Habitacion,Long idMantenimiento)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaMantenimiento () + " SET habitacion=? WHERE idMantenimiento=?");
		q.setParameters(Habitacion,idMantenimiento);
		q.executeUnique();
	}
}
