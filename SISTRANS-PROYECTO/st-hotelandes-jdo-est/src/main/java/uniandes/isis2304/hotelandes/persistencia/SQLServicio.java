package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Servicio;
import java.sql.Timestamp;

class SQLServicio
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLServicio (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarServicio(PersistenceManager pm,Long idServicio,Long capacidad,String nombre,Long capacidad_actual,Long cartaProductos,Long registroConsumo,Long hotel,Long tipoCobro,Long estilo,Long HorarioServicio)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaServicio () + "(idServicio,capacidad,nombre,capacidad_actual,cartaProductos,registroConsumo,hotel,tipoCobro,estilo,HorarioServicio) values (?,?,?,?,?,?,?,?,?,?)");
		q.setParameters(idServicio,capacidad,nombre,capacidad_actual,cartaProductos,registroConsumo,hotel,tipoCobro,estilo,HorarioServicio);
		return (Long) q.executeUnique();
	}
	public Long eliminarServicioPorId (PersistenceManager pm,Long idServicio)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE idServicio=?");
		q.setParameters(idServicio);
		return (Long) q.executeUnique();
	}
	public Servicio darServicioPorId (PersistenceManager pm,Long idServicio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio() + " WHERE idServicio=?");
		q.setResultClass(Servicio.class);
		q.setParameters(idServicio);
		return (Servicio) q.executeUnique();
	}
	public List<Servicio> darServicios (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio());
		q.setResultClass(Servicio.class);
		return (List<Servicio>) q.executeList();
	}
	public Long eliminarServicioPorCapacidad (PersistenceManager pm,Long Capacidad)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE capacidad=?");
		q.setParameters(Capacidad);
		return (Long) q.executeUnique();
	}
	public List<Servicio> darServicioPorCapacidad (PersistenceManager pm,Long Capacidad)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE capacidad=?");
		q.setResultClass(Servicio.class);
		q.setParameters(Capacidad);
		return (List<Servicio>) q.executeList();
	}
	public Long eliminarServicioPorNombre (PersistenceManager pm,String Nombre)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE nombre=?");
		q.setParameters(Nombre);
		return (Long) q.executeUnique();
	}
	public List<Servicio> darServicioPorNombre (PersistenceManager pm,String Nombre)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE nombre=?");
		q.setResultClass(Servicio.class);
		q.setParameters(Nombre);
		return (List<Servicio>) q.executeList();
	}
	public Long eliminarServicioPorCapacidad_actual (PersistenceManager pm,Long Capacidad_actual)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE capacidad_actual=?");
		q.setParameters(Capacidad_actual);
		return (Long) q.executeUnique();
	}
	public List<Servicio> darServicioPorCapacidad_actual (PersistenceManager pm,Long Capacidad_actual)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE capacidad_actual=?");
		q.setResultClass(Servicio.class);
		q.setParameters(Capacidad_actual);
		return (List<Servicio>) q.executeList();
	}
	public Long eliminarServicioPorCartaproductos (PersistenceManager pm,Long Cartaproductos)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE cartaProductos=?");
		q.setParameters(Cartaproductos);
		return (Long) q.executeUnique();
	}
	public List<Servicio> darServicioPorCartaproductos (PersistenceManager pm,Long Cartaproductos)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE cartaProductos=?");
		q.setResultClass(Servicio.class);
		q.setParameters(Cartaproductos);
		return (List<Servicio>) q.executeList();
	}
	public Long eliminarServicioPorRegistroconsumo (PersistenceManager pm,Long Registroconsumo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE registroConsumo=?");
		q.setParameters(Registroconsumo);
		return (Long) q.executeUnique();
	}
	public List<Servicio> darServicioPorRegistroconsumo (PersistenceManager pm,Long Registroconsumo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE registroConsumo=?");
		q.setResultClass(Servicio.class);
		q.setParameters(Registroconsumo);
		return (List<Servicio>) q.executeList();
	}
	public Long eliminarServicioPorHotel (PersistenceManager pm,Long Hotel)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE hotel=?");
		q.setParameters(Hotel);
		return (Long) q.executeUnique();
	}
	public List<Servicio> darServicioPorHotel (PersistenceManager pm,Long Hotel)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE hotel=?");
		q.setResultClass(Servicio.class);
		q.setParameters(Hotel);
		return (List<Servicio>) q.executeList();
	}
	public Long eliminarServicioPorTipocobro (PersistenceManager pm,Long Tipocobro)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE tipoCobro=?");
		q.setParameters(Tipocobro);
		return (Long) q.executeUnique();
	}
	public List<Servicio> darServicioPorTipocobro (PersistenceManager pm,Long Tipocobro)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE tipoCobro=?");
		q.setResultClass(Servicio.class);
		q.setParameters(Tipocobro);
		return (List<Servicio>) q.executeList();
	}
	public Long eliminarServicioPorEstilo (PersistenceManager pm,Long Estilo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE estilo=?");
		q.setParameters(Estilo);
		return (Long) q.executeUnique();
	}
	public List<Servicio> darServicioPorEstilo (PersistenceManager pm,Long Estilo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE estilo=?");
		q.setResultClass(Servicio.class);
		q.setParameters(Estilo);
		return (List<Servicio>) q.executeList();
	}
	public Long eliminarServicioPorHorarioservicio (PersistenceManager pm,Long Horarioservicio)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE HorarioServicio=?");
		q.setParameters(Horarioservicio);
		return (Long) q.executeUnique();
	}
	public List<Servicio> darServicioPorHorarioservicio (PersistenceManager pm,Long Horarioservicio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE HorarioServicio=?");
		q.setResultClass(Servicio.class);
		q.setParameters(Horarioservicio);
		return (List<Servicio>) q.executeList();
	}
}