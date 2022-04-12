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
}