package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Tipohabitacion;
import java.sql.Timestamp;

class SQLTipohabitacion
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLTipohabitacion (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarTipohabitacion(PersistenceManager pm,Long idTipoHabitacion,String nombre,String descripcion)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaTipohabitacion () + "(idTipoHabitacion,nombre,descripcion) values (?,?,?)");
		q.setParameters(idTipoHabitacion,nombre,descripcion);
		return (Long) q.executeUnique();
	}
	public Long eliminarTipohabitacionPorId (PersistenceManager pm,Long idTipoHabitacion)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTipohabitacion () + " WHERE idTipoHabitacion=?");
		q.setParameters(idTipoHabitacion);
		return (Long) q.executeUnique();
	}
	public Tipohabitacion darTipohabitacionPorId (PersistenceManager pm,Long idTipoHabitacion)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTipohabitacion() + " WHERE idTipoHabitacion=?");
		q.setResultClass(Tipohabitacion.class);
		q.setParameters(idTipoHabitacion);
		return (Tipohabitacion) q.executeUnique();
	}
	public List<Tipohabitacion> darTipohabitacions (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTipohabitacion());
		q.setResultClass(Tipohabitacion.class);
		return (List<Tipohabitacion>) q.executeList();
	}
}