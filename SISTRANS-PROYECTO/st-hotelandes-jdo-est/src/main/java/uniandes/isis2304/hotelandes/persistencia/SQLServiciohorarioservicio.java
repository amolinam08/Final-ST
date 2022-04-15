package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Serviciohorarioservicio;
import java.sql.Timestamp;

class SQLServiciohorarioservicio
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLServiciohorarioservicio (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarServiciohorarioservicio(PersistenceManager pm,Long idServicio,Long idHorarioServicio)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaServiciohorarioservicio () + "(idServicio,idHorarioServicio) values (?,?)");
		q.setParameters(idServicio,idHorarioServicio);
		return (Long) q.executeUnique();
	}
	public Long eliminarServiciohorarioservicioPorId (PersistenceManager pm,Long idServicio,Long idHorarioServicio)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServiciohorarioservicio () + " WHERE idServicio=? and idHorarioServicio=?");
		q.setParameters(idServicio,idHorarioServicio);
		return (Long) q.executeUnique();
	}
	public Serviciohorarioservicio darServiciohorarioservicioPorId (PersistenceManager pm,Long idServicio,Long idHorarioServicio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServiciohorarioservicio() + " WHERE idServicio=? and idHorarioServicio=?");
		q.setResultClass(Serviciohorarioservicio.class);
		q.setParameters(idServicio,idHorarioServicio);
		return (Serviciohorarioservicio) q.executeUnique();
	}
	public List<Serviciohorarioservicio> darServiciohorarioservicios (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServiciohorarioservicio());
		q.setResultClass(Serviciohorarioservicio.class);
		return (List<Serviciohorarioservicio>) q.executeList();
	}
	public Long eliminarServiciohorarioservicioPorIdservicio (PersistenceManager pm,Long Idservicio)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServiciohorarioservicio () + " WHERE idServicio=?");
		q.setParameters(Idservicio);
		return (Long) q.executeUnique();
	}
	public List<Serviciohorarioservicio> darServiciohorarioservicioPorIdservicio (PersistenceManager pm,Long Idservicio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServiciohorarioservicio () + " WHERE idServicio=?");
		q.setResultClass(Serviciohorarioservicio.class);
		q.setParameters(Idservicio);
		return (List<Serviciohorarioservicio>) q.executeList();
	}
	public void actualizarIdservicio(PersistenceManager pm,Long Idservicio,Long idServicio,Long idHorarioServicio)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServiciohorarioservicio () + " SET idServicio=? WHERE idServicio=? and idHorarioServicio=?");
		q.setParameters(Idservicio,idServicio,idHorarioServicio);
		q.executeUnique();
	}
	public Long eliminarServiciohorarioservicioPorIdhorarioservicio (PersistenceManager pm,Long Idhorarioservicio)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServiciohorarioservicio () + " WHERE idHorarioServicio=?");
		q.setParameters(Idhorarioservicio);
		return (Long) q.executeUnique();
	}
	public List<Serviciohorarioservicio> darServiciohorarioservicioPorIdhorarioservicio (PersistenceManager pm,Long Idhorarioservicio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServiciohorarioservicio () + " WHERE idHorarioServicio=?");
		q.setResultClass(Serviciohorarioservicio.class);
		q.setParameters(Idhorarioservicio);
		return (List<Serviciohorarioservicio>) q.executeList();
	}
	public void actualizarIdhorarioservicio(PersistenceManager pm,Long Idhorarioservicio,Long idServicio,Long idHorarioServicio)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServiciohorarioservicio () + " SET idHorarioServicio=? WHERE idServicio=? and idHorarioServicio=?");
		q.setParameters(Idhorarioservicio,idServicio,idHorarioServicio);
		q.executeUnique();
	}
}
