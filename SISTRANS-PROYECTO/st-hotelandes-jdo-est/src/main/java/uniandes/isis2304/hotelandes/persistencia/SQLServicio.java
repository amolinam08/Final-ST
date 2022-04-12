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
	public Long adicionarServicio(PersistenceManager pm,Long idServicio,Long capacidad,String nombre,Long capacidad_actual,Long cartaProductos,Long registroConsumo,Long hotel,Long ofertaServicio,Long tipoCobro,Long estilo,Long HorarioServicio)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaServicio () + "(idServicio,capacidad,nombre,capacidad_actual,cartaProductos,registroConsumo,hotel,ofertaServicio,tipoCobro,estilo,HorarioServicio) values (?,?,?,?,?,?,?,?,?,?,?)");
		q.setParameters(idServicio,capacidad,nombre,capacidad_actual,cartaProductos,registroConsumo,hotel,ofertaServicio,tipoCobro,estilo,HorarioServicio);
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
}