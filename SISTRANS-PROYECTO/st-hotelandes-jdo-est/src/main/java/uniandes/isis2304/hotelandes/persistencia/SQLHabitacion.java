package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Habitacion;
import java.sql.Timestamp;

class SQLHabitacion
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLHabitacion (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarHabitacion(PersistenceManager pm,Long idHabitacion,Long capacidad,Double costoAloj,Long hotel,Long tipoHabitacion)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaHabitacion () + "(idHabitacion,capacidad,costoAloj,hotel,tipoHabitacion) values (?,?,?,?,?)");
		q.setParameters(idHabitacion,capacidad,costoAloj,hotel,tipoHabitacion);
		return (Long) q.executeUnique();
	}
	public Long eliminarHabitacionPorId (PersistenceManager pm,Long idHabitacion)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHabitacion () + " WHERE idHabitacion=?");
		q.setParameters(idHabitacion);
		return (Long) q.executeUnique();
	}
	public Habitacion darHabitacionPorId (PersistenceManager pm,Long idHabitacion)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHabitacion() + " WHERE idHabitacion=?");
		q.setResultClass(Habitacion.class);
		q.setParameters(idHabitacion);
		return (Habitacion) q.executeUnique();
	}
	public List<Habitacion> darHabitacions (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHabitacion());
		q.setResultClass(Habitacion.class);
		return (List<Habitacion>) q.executeList();
	}
	public Long eliminarHabitacionPorCapacidad (PersistenceManager pm,Long Capacidad)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHabitacion () + " WHERE capacidad=?");
		q.setParameters(Capacidad);
		return (Long) q.executeUnique();
	}
	public List<Habitacion> darHabitacionPorCapacidad (PersistenceManager pm,Long Capacidad)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHabitacion () + " WHERE capacidad=?");
		q.setResultClass(Habitacion.class);
		q.setParameters(Capacidad);
		return (List<Habitacion>) q.executeList();
	}
	public void actualizarCapacidad(PersistenceManager pm,Long Capacidad,Long idHabitacion)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaHabitacion () + " SET capacidad=? WHERE idHabitacion=?");
		q.setParameters(Capacidad,idHabitacion);
		q.executeUnique();
	}
	public Long eliminarHabitacionPorCostoaloj (PersistenceManager pm,Double Costoaloj)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHabitacion () + " WHERE costoAloj=?");
		q.setParameters(Costoaloj);
		return (Long) q.executeUnique();
	}
	public List<Habitacion> darHabitacionPorCostoaloj (PersistenceManager pm,Double Costoaloj)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHabitacion () + " WHERE costoAloj=?");
		q.setResultClass(Habitacion.class);
		q.setParameters(Costoaloj);
		return (List<Habitacion>) q.executeList();
	}
	public void actualizarCostoaloj(PersistenceManager pm,Double Costoaloj,Long idHabitacion)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaHabitacion () + " SET costoAloj=? WHERE idHabitacion=?");
		q.setParameters(Costoaloj,idHabitacion);
		q.executeUnique();
	}
	public Long eliminarHabitacionPorHotel (PersistenceManager pm,Long Hotel)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHabitacion () + " WHERE hotel=?");
		q.setParameters(Hotel);
		return (Long) q.executeUnique();
	}
	public List<Habitacion> darHabitacionPorHotel (PersistenceManager pm,Long Hotel)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHabitacion () + " WHERE hotel=?");
		q.setResultClass(Habitacion.class);
		q.setParameters(Hotel);
		return (List<Habitacion>) q.executeList();
	}
	public void actualizarHotel(PersistenceManager pm,Long Hotel,Long idHabitacion)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaHabitacion () + " SET hotel=? WHERE idHabitacion=?");
		q.setParameters(Hotel,idHabitacion);
		q.executeUnique();
	}
	public Long eliminarHabitacionPorTipohabitacion (PersistenceManager pm,Long Tipohabitacion)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHabitacion () + " WHERE tipoHabitacion=?");
		q.setParameters(Tipohabitacion);
		return (Long) q.executeUnique();
	}
	public List<Habitacion> darHabitacionPorTipohabitacion (PersistenceManager pm,Long Tipohabitacion)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHabitacion () + " WHERE tipoHabitacion=?");
		q.setResultClass(Habitacion.class);
		q.setParameters(Tipohabitacion);
		return (List<Habitacion>) q.executeList();
	}
	public void actualizarTipohabitacion(PersistenceManager pm,Long Tipohabitacion,Long idHabitacion)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaHabitacion () + " SET tipoHabitacion=? WHERE idHabitacion=?");
		q.setParameters(Tipohabitacion,idHabitacion);
		q.executeUnique();
	}
}
