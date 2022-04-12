package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Estilo;
import java.sql.Timestamp;

class SQLEstilo
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLEstilo (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarEstilo(PersistenceManager pm,Long idEstilo,String nombre)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaEstilo () + "(idEstilo,nombre) values (?,?)");
		q.setParameters(idEstilo,nombre);
		return (Long) q.executeUnique();
	}
	public Long eliminarEstiloPorId (PersistenceManager pm,Long idEstilo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaEstilo () + " WHERE idEstilo=?");
		q.setParameters(idEstilo);
		return (Long) q.executeUnique();
	}
	public Estilo darEstiloPorId (PersistenceManager pm,Long idEstilo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaEstilo() + " WHERE idEstilo=?");
		q.setResultClass(Estilo.class);
		q.setParameters(idEstilo);
		return (Estilo) q.executeUnique();
	}
	public List<Estilo> darEstilos (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaEstilo());
		q.setResultClass(Estilo.class);
		return (List<Estilo>) q.executeList();
	}
}