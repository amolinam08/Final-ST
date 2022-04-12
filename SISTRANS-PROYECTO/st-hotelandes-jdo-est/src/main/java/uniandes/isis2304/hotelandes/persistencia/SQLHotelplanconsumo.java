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
}