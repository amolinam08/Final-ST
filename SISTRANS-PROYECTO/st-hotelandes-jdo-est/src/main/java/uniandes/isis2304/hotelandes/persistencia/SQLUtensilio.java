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
	public Long eliminarUtensilioPorEstado (PersistenceManager pm,String Estado)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUtensilio () + " WHERE estado=?");
		q.setParameters(Estado);
		return (Long) q.executeUnique();
	}
	public List<Utensilio> darUtensilioPorEstado (PersistenceManager pm,String Estado)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUtensilio () + " WHERE estado=?");
		q.setResultClass(Utensilio.class);
		q.setParameters(Estado);
		return (List<Utensilio>) q.executeList();
	}
	public void actualizarEstado(PersistenceManager pm,String Estado,Long idUtensilio)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaUtensilio () + " SET estado=? WHERE idUtensilio=?");
		q.setParameters(Estado,idUtensilio);
		q.executeUnique();
	}
	public Long eliminarUtensilioPorEntregado (PersistenceManager pm,String Entregado)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUtensilio () + " WHERE entregado=?");
		q.setParameters(Entregado);
		return (Long) q.executeUnique();
	}
	public List<Utensilio> darUtensilioPorEntregado (PersistenceManager pm,String Entregado)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUtensilio () + " WHERE entregado=?");
		q.setResultClass(Utensilio.class);
		q.setParameters(Entregado);
		return (List<Utensilio>) q.executeList();
	}
	public void actualizarEntregado(PersistenceManager pm,String Entregado,Long idUtensilio)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaUtensilio () + " SET entregado=? WHERE idUtensilio=?");
		q.setParameters(Entregado,idUtensilio);
		q.executeUnique();
	}
}
