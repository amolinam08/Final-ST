package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Utensilio;
import java.sql.Timestamp;

class SQLUtensilio
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLUtensilio (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarUtensilio(PersistenceManager pm,Long idUtensilio,String estado,String entregado)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaUtensilio () + "(idUtensilio,estado,entregado) values (?,?,?)");
		q.setParameters(idUtensilio,estado,entregado);
		return (Long) q.executeUnique();
	}
	public Long eliminarUtensilioPorId (PersistenceManager pm,Long idUtensilio)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUtensilio () + " WHERE idUtensilio=?");
		q.setParameters(idUtensilio);
		return (Long) q.executeUnique();
	}
	public Utensilio darUtensilioPorId (PersistenceManager pm,Long idUtensilio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUtensilio() + " WHERE idUtensilio=?");
		q.setResultClass(Utensilio.class);
		q.setParameters(idUtensilio);
		return (Utensilio) q.executeUnique();
	}
	public List<Utensilio> darUtensilios (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUtensilio());
		q.setResultClass(Utensilio.class);
		return (List<Utensilio>) q.executeList();
	}
}