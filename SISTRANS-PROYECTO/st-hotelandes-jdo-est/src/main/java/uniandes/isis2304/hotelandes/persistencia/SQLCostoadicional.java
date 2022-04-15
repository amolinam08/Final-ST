package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Costoadicional;
import java.sql.Timestamp;

class SQLCostoadicional
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLCostoadicional (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarCostoadicional(PersistenceManager pm,Long idCostoAdicional,String nombre,Double costo,Long servicio)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaCostoadicional () + "(idCostoAdicional,nombre,costo,servicio) values (?,?,?,?)");
		q.setParameters(idCostoAdicional,nombre,costo,servicio);
		return (Long) q.executeUnique();
	}
	public Long eliminarCostoadicionalPorId (PersistenceManager pm,Long idCostoAdicional)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCostoadicional () + " WHERE idCostoAdicional=?");
		q.setParameters(idCostoAdicional);
		return (Long) q.executeUnique();
	}
	public Costoadicional darCostoadicionalPorId (PersistenceManager pm,Long idCostoAdicional)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCostoadicional() + " WHERE idCostoAdicional=?");
		q.setResultClass(Costoadicional.class);
		q.setParameters(idCostoAdicional);
		return (Costoadicional) q.executeUnique();
	}
	public List<Costoadicional> darCostoadicionals (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCostoadicional());
		q.setResultClass(Costoadicional.class);
		return (List<Costoadicional>) q.executeList();
	}
	public Long eliminarCostoadicionalPorNombre (PersistenceManager pm,String Nombre)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCostoadicional () + " WHERE nombre=?");
		q.setParameters(Nombre);
		return (Long) q.executeUnique();
	}
	public List<Costoadicional> darCostoadicionalPorNombre (PersistenceManager pm,String Nombre)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCostoadicional () + " WHERE nombre=?");
		q.setResultClass(Costoadicional.class);
		q.setParameters(Nombre);
		return (List<Costoadicional>) q.executeList();
	}
	public void actualizarNombre(PersistenceManager pm,String Nombre,Long idCostoAdicional)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCostoadicional () + " SET nombre=? WHERE idCostoAdicional=?");
		q.setParameters(Nombre,idCostoAdicional);
		q.executeUnique();
	}
	public Long eliminarCostoadicionalPorCosto (PersistenceManager pm,Double Costo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCostoadicional () + " WHERE costo=?");
		q.setParameters(Costo);
		return (Long) q.executeUnique();
	}
	public List<Costoadicional> darCostoadicionalPorCosto (PersistenceManager pm,Double Costo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCostoadicional () + " WHERE costo=?");
		q.setResultClass(Costoadicional.class);
		q.setParameters(Costo);
		return (List<Costoadicional>) q.executeList();
	}
	public void actualizarCosto(PersistenceManager pm,Double Costo,Long idCostoAdicional)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCostoadicional () + " SET costo=? WHERE idCostoAdicional=?");
		q.setParameters(Costo,idCostoAdicional);
		q.executeUnique();
	}
	public Long eliminarCostoadicionalPorServicio (PersistenceManager pm,Long Servicio)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCostoadicional () + " WHERE servicio=?");
		q.setParameters(Servicio);
		return (Long) q.executeUnique();
	}
	public List<Costoadicional> darCostoadicionalPorServicio (PersistenceManager pm,Long Servicio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCostoadicional () + " WHERE servicio=?");
		q.setResultClass(Costoadicional.class);
		q.setParameters(Servicio);
		return (List<Costoadicional>) q.executeList();
	}
	public void actualizarServicio(PersistenceManager pm,Long Servicio,Long idCostoAdicional)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCostoadicional () + " SET servicio=? WHERE idCostoAdicional=?");
		q.setParameters(Servicio,idCostoAdicional);
		q.executeUnique();
	}
}
