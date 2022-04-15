package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Hotelplanconsumo;
import java.sql.Timestamp;

class SQLHotelplanconsumo
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLHotelplanconsumo (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarHotelplanconsumo(PersistenceManager pm,Long idHotel,Long idPlanConsumo)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaHotelplanconsumo () + "(idHotel,idPlanConsumo) values (?,?)");
		q.setParameters(idHotel,idPlanConsumo);
		return (Long) q.executeUnique();
	}
	public Long eliminarHotelplanconsumoPorId (PersistenceManager pm,Long idHotel,Long idPlanConsumo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHotelplanconsumo () + " WHERE idHotel=? and idPlanConsumo=?");
		q.setParameters(idHotel,idPlanConsumo);
		return (Long) q.executeUnique();
	}
	public Hotelplanconsumo darHotelplanconsumoPorId (PersistenceManager pm,Long idHotel,Long idPlanConsumo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotelplanconsumo() + " WHERE idHotel=? and idPlanConsumo=?");
		q.setResultClass(Hotelplanconsumo.class);
		q.setParameters(idHotel,idPlanConsumo);
		return (Hotelplanconsumo) q.executeUnique();
	}
	public List<Hotelplanconsumo> darHotelplanconsumos (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotelplanconsumo());
		q.setResultClass(Hotelplanconsumo.class);
		return (List<Hotelplanconsumo>) q.executeList();
	}
	public Long eliminarHotelplanconsumoPorIdhotel (PersistenceManager pm,Long Idhotel)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHotelplanconsumo () + " WHERE idHotel=?");
		q.setParameters(Idhotel);
		return (Long) q.executeUnique();
	}
	public List<Hotelplanconsumo> darHotelplanconsumoPorIdhotel (PersistenceManager pm,Long Idhotel)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotelplanconsumo () + " WHERE idHotel=?");
		q.setResultClass(Hotelplanconsumo.class);
		q.setParameters(Idhotel);
		return (List<Hotelplanconsumo>) q.executeList();
	}
	public void actualizarIdhotel(PersistenceManager pm,Long Idhotel,Long idHotel,Long idPlanConsumo)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaHotelplanconsumo () + " SET idHotel=? WHERE idHotel=? and idPlanConsumo=?");
		q.setParameters(Idhotel,idHotel,idPlanConsumo);
		q.executeUnique();
	}
	public Long eliminarHotelplanconsumoPorIdplanconsumo (PersistenceManager pm,Long Idplanconsumo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHotelplanconsumo () + " WHERE idPlanConsumo=?");
		q.setParameters(Idplanconsumo);
		return (Long) q.executeUnique();
	}
	public List<Hotelplanconsumo> darHotelplanconsumoPorIdplanconsumo (PersistenceManager pm,Long Idplanconsumo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotelplanconsumo () + " WHERE idPlanConsumo=?");
		q.setResultClass(Hotelplanconsumo.class);
		q.setParameters(Idplanconsumo);
		return (List<Hotelplanconsumo>) q.executeList();
	}
	public void actualizarIdplanconsumo(PersistenceManager pm,Long Idplanconsumo,Long idHotel,Long idPlanConsumo)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaHotelplanconsumo () + " SET idPlanConsumo=? WHERE idHotel=? and idPlanConsumo=?");
		q.setParameters(Idplanconsumo,idHotel,idPlanConsumo);
		q.executeUnique();
	}
}
