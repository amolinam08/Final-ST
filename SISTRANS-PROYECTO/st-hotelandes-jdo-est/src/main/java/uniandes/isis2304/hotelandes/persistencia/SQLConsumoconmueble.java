package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Consumoconmueble;
import java.sql.Timestamp;

class SQLConsumoconmueble
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLConsumoconmueble (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarConsumoconmueble(PersistenceManager pm,Long idMueble,Double costo,String usado)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaConsumoconmueble () + "(idMueble,costo,usado) values (?,?,?)");
		q.setParameters(idMueble,costo,usado);
		return (Long) q.executeUnique();
	}
	public Long eliminarConsumoconmueblePorId (PersistenceManager pm,Long idMueble)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsumoconmueble () + " WHERE idMueble=?");
		q.setParameters(idMueble);
		return (Long) q.executeUnique();
	}
	public Consumoconmueble darConsumoconmueblePorId (PersistenceManager pm,Long idMueble)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumoconmueble() + " WHERE idMueble=?");
		q.setResultClass(Consumoconmueble.class);
		q.setParameters(idMueble);
		return (Consumoconmueble) q.executeUnique();
	}
	public List<Consumoconmueble> darConsumoconmuebles (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumoconmueble());
		q.setResultClass(Consumoconmueble.class);
		return (List<Consumoconmueble>) q.executeList();
	}
}