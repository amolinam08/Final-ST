package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Restricciones;
import java.sql.Timestamp;

class SQLRestricciones
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLRestricciones (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarRestricciones(PersistenceManager pm,Long idRestriccion,Long cantidad,Long producto)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaRestricciones () + "(idRestriccion,cantidad,producto) values (?,?,?)");
		q.setParameters(idRestriccion,cantidad,producto);
		return (Long) q.executeUnique();
	}
	public Long eliminarRestriccionesPorId (PersistenceManager pm,Long idRestriccion)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaRestricciones () + " WHERE idRestriccion=?");
		q.setParameters(idRestriccion);
		return (Long) q.executeUnique();
	}
	public Restricciones darRestriccionesPorId (PersistenceManager pm,Long idRestriccion)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaRestricciones() + " WHERE idRestriccion=?");
		q.setResultClass(Restricciones.class);
		q.setParameters(idRestriccion);
		return (Restricciones) q.executeUnique();
	}
	public List<Restricciones> darRestriccioness (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaRestricciones());
		q.setResultClass(Restricciones.class);
		return (List<Restricciones>) q.executeList();
	}
}