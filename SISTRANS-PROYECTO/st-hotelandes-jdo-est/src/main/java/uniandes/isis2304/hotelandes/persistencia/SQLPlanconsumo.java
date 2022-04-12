package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Planconsumo;
import java.sql.Timestamp;

class SQLPlanconsumo
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLPlanconsumo (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarPlanconsumo(PersistenceManager pm,Long idPlanConsumo,String nombre,Double descuento,String descripcion,Timestamp periodoVigencia1,Timestamp periodoVigencia2,Long tipoPlanConsumo)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaPlanconsumo () + "(idPlanConsumo,nombre,descuento,descripcion,periodoVigencia1,periodoVigencia2,tipoPlanConsumo) values (?,?,?,?,?,?,?)");
		q.setParameters(idPlanConsumo,nombre,descuento,descripcion,periodoVigencia1,periodoVigencia2,tipoPlanConsumo);
		return (Long) q.executeUnique();
	}
	public Long eliminarPlanconsumoPorId (PersistenceManager pm,Long idPlanConsumo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanconsumo () + " WHERE idPlanConsumo=?");
		q.setParameters(idPlanConsumo);
		return (Long) q.executeUnique();
	}
	public Planconsumo darPlanconsumoPorId (PersistenceManager pm,Long idPlanConsumo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanconsumo() + " WHERE idPlanConsumo=?");
		q.setResultClass(Planconsumo.class);
		q.setParameters(idPlanConsumo);
		return (Planconsumo) q.executeUnique();
	}
	public List<Planconsumo> darPlanconsumos (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanconsumo());
		q.setResultClass(Planconsumo.class);
		return (List<Planconsumo>) q.executeList();
	}
}