package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Planconsumoservicio;
import java.sql.Timestamp;

class SQLPlanconsumoservicio
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLPlanconsumoservicio (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarPlanconsumoservicio(PersistenceManager pm,Long idPlanConsumo,Long idServicio)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaPlanconsumoservicio () + "(idPlanConsumo,idServicio) values (?,?)");
		q.setParameters(idPlanConsumo,idServicio);
		return (Long) q.executeUnique();
	}
	public Long eliminarPlanconsumoservicioPorId (PersistenceManager pm,Long idPlanConsumo,Long idServicio)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanconsumoservicio () + " WHERE idPlanConsumo=? and idServicio=?");
		q.setParameters(idPlanConsumo,idServicio);
		return (Long) q.executeUnique();
	}
	public Planconsumoservicio darPlanconsumoservicioPorId (PersistenceManager pm,Long idPlanConsumo,Long idServicio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanconsumoservicio() + " WHERE idPlanConsumo=? and idServicio=?");
		q.setResultClass(Planconsumoservicio.class);
		q.setParameters(idPlanConsumo,idServicio);
		return (Planconsumoservicio) q.executeUnique();
	}
	public List<Planconsumoservicio> darPlanconsumoservicios (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanconsumoservicio());
		q.setResultClass(Planconsumoservicio.class);
		return (List<Planconsumoservicio>) q.executeList();
	}
	public Long eliminarPlanconsumoservicioPorIdplanconsumo (PersistenceManager pm,Long Idplanconsumo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanconsumoservicio () + " WHERE idPlanConsumo=?");
		q.setParameters(Idplanconsumo);
		return (Long) q.executeUnique();
	}
	public List<Planconsumoservicio> darPlanconsumoservicioPorIdplanconsumo (PersistenceManager pm,Long Idplanconsumo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanconsumoservicio () + " WHERE idPlanConsumo=?");
		q.setResultClass(Planconsumoservicio.class);
		q.setParameters(Idplanconsumo);
		return (List<Planconsumoservicio>) q.executeList();
	}
	public void actualizarIdplanconsumo(PersistenceManager pm,Long Idplanconsumo,Long idPlanConsumo,Long idServicio)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaPlanconsumoservicio () + " SET idPlanConsumo=? WHERE idPlanConsumo=? and idServicio=?");
		q.setParameters(Idplanconsumo,idPlanConsumo,idServicio);
		q.executeUnique();
	}
	public Long eliminarPlanconsumoservicioPorIdservicio (PersistenceManager pm,Long Idservicio)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanconsumoservicio () + " WHERE idServicio=?");
		q.setParameters(Idservicio);
		return (Long) q.executeUnique();
	}
	public List<Planconsumoservicio> darPlanconsumoservicioPorIdservicio (PersistenceManager pm,Long Idservicio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanconsumoservicio () + " WHERE idServicio=?");
		q.setResultClass(Planconsumoservicio.class);
		q.setParameters(Idservicio);
		return (List<Planconsumoservicio>) q.executeList();
	}
	public void actualizarIdservicio(PersistenceManager pm,Long Idservicio,Long idPlanConsumo,Long idServicio)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaPlanconsumoservicio () + " SET idServicio=? WHERE idPlanConsumo=? and idServicio=?");
		q.setParameters(Idservicio,idPlanConsumo,idServicio);
		q.executeUnique();
	}
}
