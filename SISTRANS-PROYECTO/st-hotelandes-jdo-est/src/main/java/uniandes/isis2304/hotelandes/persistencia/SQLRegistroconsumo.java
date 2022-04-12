package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Registroconsumo;
import java.sql.Timestamp;

class SQLRegistroconsumo
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLRegistroconsumo (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarRegistroconsumo(PersistenceManager pm,Long idRegistroConsumo)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaRegistroconsumo () + "(idRegistroConsumo) values (?)");
		q.setParameters(idRegistroConsumo);
		return (Long) q.executeUnique();
	}
	public Long eliminarRegistroconsumoPorId (PersistenceManager pm,Long idRegistroConsumo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaRegistroconsumo () + " WHERE idRegistroConsumo=?");
		q.setParameters(idRegistroConsumo);
		return (Long) q.executeUnique();
	}
	public Registroconsumo darRegistroconsumoPorId (PersistenceManager pm,Long idRegistroConsumo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaRegistroconsumo() + " WHERE idRegistroConsumo=?");
		q.setResultClass(Registroconsumo.class);
		q.setParameters(idRegistroConsumo);
		return (Registroconsumo) q.executeUnique();
	}
	public List<Registroconsumo> darRegistroconsumos (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaRegistroconsumo());
		q.setResultClass(Registroconsumo.class);
		return (List<Registroconsumo>) q.executeList();
	}
}