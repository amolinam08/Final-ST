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
	public Long adicionarPlanconsumo(PersistenceManager pm,Long idPlanConsumo,String nombre,Double descuento,String descripcion,Timestamp periodoVigencia1,Timestamp periodoVigencia2)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaPlanconsumo () + "(idPlanConsumo,nombre,descuento,descripcion,periodoVigencia1,periodoVigencia2) values (?,?,?,?,?,?)");
		q.setParameters(idPlanConsumo,nombre,descuento,descripcion,periodoVigencia1,periodoVigencia2);
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
	public Long eliminarPlanconsumoPorNombre (PersistenceManager pm,String Nombre)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanconsumo () + " WHERE nombre=?");
		q.setParameters(Nombre);
		return (Long) q.executeUnique();
	}
	public List<Planconsumo> darPlanconsumoPorNombre (PersistenceManager pm,String Nombre)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanconsumo () + " WHERE nombre=?");
		q.setResultClass(Planconsumo.class);
		q.setParameters(Nombre);
		return (List<Planconsumo>) q.executeList();
	}
	public Long eliminarPlanconsumoPorDescuento (PersistenceManager pm,Double Descuento)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanconsumo () + " WHERE descuento=?");
		q.setParameters(Descuento);
		return (Long) q.executeUnique();
	}
	public List<Planconsumo> darPlanconsumoPorDescuento (PersistenceManager pm,Double Descuento)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanconsumo () + " WHERE descuento=?");
		q.setResultClass(Planconsumo.class);
		q.setParameters(Descuento);
		return (List<Planconsumo>) q.executeList();
	}
	public Long eliminarPlanconsumoPorDescripcion (PersistenceManager pm,String Descripcion)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanconsumo () + " WHERE descripcion=?");
		q.setParameters(Descripcion);
		return (Long) q.executeUnique();
	}
	public List<Planconsumo> darPlanconsumoPorDescripcion (PersistenceManager pm,String Descripcion)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanconsumo () + " WHERE descripcion=?");
		q.setResultClass(Planconsumo.class);
		q.setParameters(Descripcion);
		return (List<Planconsumo>) q.executeList();
	}
	public Long eliminarPlanconsumoPorPeriodovigencia1 (PersistenceManager pm,Timestamp Periodovigencia1)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanconsumo () + " WHERE periodoVigencia1=?");
		q.setParameters(Periodovigencia1);
		return (Long) q.executeUnique();
	}
	public List<Planconsumo> darPlanconsumoPorPeriodovigencia1 (PersistenceManager pm,Timestamp Periodovigencia1)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanconsumo () + " WHERE periodoVigencia1=?");
		q.setResultClass(Planconsumo.class);
		q.setParameters(Periodovigencia1);
		return (List<Planconsumo>) q.executeList();
	}
	public Long eliminarPlanconsumoPorPeriodovigencia2 (PersistenceManager pm,Timestamp Periodovigencia2)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanconsumo () + " WHERE periodoVigencia2=?");
		q.setParameters(Periodovigencia2);
		return (Long) q.executeUnique();
	}
	public List<Planconsumo> darPlanconsumoPorPeriodovigencia2 (PersistenceManager pm,Timestamp Periodovigencia2)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanconsumo () + " WHERE periodoVigencia2=?");
		q.setResultClass(Planconsumo.class);
		q.setParameters(Periodovigencia2);
		return (List<Planconsumo>) q.executeList();
	}
}