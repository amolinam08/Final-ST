package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Planconsumorestricciones;
import java.sql.Timestamp;

class SQLPlanconsumorestricciones
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLPlanconsumorestricciones (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarPlanconsumorestricciones(PersistenceManager pm,Long idPlanConsumo,Long idRestriccion)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaPlanconsumorestricciones () + "(idPlanConsumo,idRestriccion) values (?,?)");
		q.setParameters(idPlanConsumo,idRestriccion);
		return (Long) q.executeUnique();
	}
	public Long eliminarPlanconsumorestriccionesPorId (PersistenceManager pm,Long idPlanConsumo,Long idRestriccion)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanconsumorestricciones () + " WHERE idPlanConsumo=? and idRestriccion=?");
		q.setParameters(idPlanConsumo,idRestriccion);
		return (Long) q.executeUnique();
	}
	public Planconsumorestricciones darPlanconsumorestriccionesPorId (PersistenceManager pm,Long idPlanConsumo,Long idRestriccion)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanconsumorestricciones() + " WHERE idPlanConsumo=? and idRestriccion=?");
		q.setResultClass(Planconsumorestricciones.class);
		q.setParameters(idPlanConsumo,idRestriccion);
		return (Planconsumorestricciones) q.executeUnique();
	}
	public List<Planconsumorestricciones> darPlanconsumorestriccioness (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanconsumorestricciones());
		q.setResultClass(Planconsumorestricciones.class);
		return (List<Planconsumorestricciones>) q.executeList();
	}
}