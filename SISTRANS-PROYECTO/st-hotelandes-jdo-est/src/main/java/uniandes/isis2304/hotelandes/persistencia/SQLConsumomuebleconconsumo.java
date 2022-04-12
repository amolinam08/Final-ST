package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Consumomuebleconconsumo;
import java.sql.Timestamp;

class SQLConsumomuebleconconsumo
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLConsumomuebleconconsumo (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarConsumomuebleconconsumo(PersistenceManager pm,Long idConsumo,Long idMuebleConConsumo)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaConsumomuebleconconsumo () + "(idConsumo,idMuebleConConsumo) values (?,?)");
		q.setParameters(idConsumo,idMuebleConConsumo);
		return (Long) q.executeUnique();
	}
	public Long eliminarConsumomuebleconconsumoPorId (PersistenceManager pm,Long idConsumo,Long idMuebleConConsumo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsumomuebleconconsumo () + " WHERE idConsumo=? and idMuebleConConsumo=?");
		q.setParameters(idConsumo,idMuebleConConsumo);
		return (Long) q.executeUnique();
	}
	public Consumomuebleconconsumo darConsumomuebleconconsumoPorId (PersistenceManager pm,Long idConsumo,Long idMuebleConConsumo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumomuebleconconsumo() + " WHERE idConsumo=? and idMuebleConConsumo=?");
		q.setResultClass(Consumomuebleconconsumo.class);
		q.setParameters(idConsumo,idMuebleConConsumo);
		return (Consumomuebleconconsumo) q.executeUnique();
	}
	public List<Consumomuebleconconsumo> darConsumomuebleconconsumos (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumomuebleconconsumo());
		q.setResultClass(Consumomuebleconconsumo.class);
		return (List<Consumomuebleconconsumo>) q.executeList();
	}
}