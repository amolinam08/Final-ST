package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Plancobro;
import java.sql.Timestamp;

class SQLPlancobro
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLPlancobro (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarPlancobro(PersistenceManager pm,Long idPlanCobro,String descripcion,String nombre)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaPlancobro () + "(idPlanCobro,descripcion,nombre) values (?,?,?)");
		q.setParameters(idPlanCobro,descripcion,nombre);
		return (Long) q.executeUnique();
	}
	public Long eliminarPlancobroPorId (PersistenceManager pm,Long idPlanCobro)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlancobro () + " WHERE idPlanCobro=?");
		q.setParameters(idPlanCobro);
		return (Long) q.executeUnique();
	}
	public Plancobro darPlancobroPorId (PersistenceManager pm,Long idPlanCobro)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlancobro() + " WHERE idPlanCobro=?");
		q.setResultClass(Plancobro.class);
		q.setParameters(idPlanCobro);
		return (Plancobro) q.executeUnique();
	}
	public List<Plancobro> darPlancobros (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlancobro());
		q.setResultClass(Plancobro.class);
		return (List<Plancobro>) q.executeList();
	}
	public Long eliminarPlancobroPorDescripcion (PersistenceManager pm,String Descripcion)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlancobro () + " WHERE descripcion=?");
		q.setParameters(Descripcion);
		return (Long) q.executeUnique();
	}
	public List<Plancobro> darPlancobroPorDescripcion (PersistenceManager pm,String Descripcion)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlancobro () + " WHERE descripcion=?");
		q.setResultClass(Plancobro.class);
		q.setParameters(Descripcion);
		return (List<Plancobro>) q.executeList();
	}
	public void actualizarDescripcion(PersistenceManager pm,String Descripcion,Long idPlanCobro)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaPlancobro () + " SET descripcion=? WHERE idPlanCobro=?");
		q.setParameters(Descripcion,idPlanCobro);
		q.executeUnique();
	}
	public Long eliminarPlancobroPorNombre (PersistenceManager pm,String Nombre)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlancobro () + " WHERE nombre=?");
		q.setParameters(Nombre);
		return (Long) q.executeUnique();
	}
	public List<Plancobro> darPlancobroPorNombre (PersistenceManager pm,String Nombre)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlancobro () + " WHERE nombre=?");
		q.setResultClass(Plancobro.class);
		q.setParameters(Nombre);
		return (List<Plancobro>) q.executeList();
	}
	public void actualizarNombre(PersistenceManager pm,String Nombre,Long idPlanCobro)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaPlancobro () + " SET nombre=? WHERE idPlanCobro=?");
		q.setParameters(Nombre,idPlanCobro);
		q.executeUnique();
	}
}
