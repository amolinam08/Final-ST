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
	public Long eliminarRestriccionesPorCantidad (PersistenceManager pm,Long Cantidad)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaRestricciones () + " WHERE cantidad=?");
		q.setParameters(Cantidad);
		return (Long) q.executeUnique();
	}
	public List<Restricciones> darRestriccionesPorCantidad (PersistenceManager pm,Long Cantidad)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaRestricciones () + " WHERE cantidad=?");
		q.setResultClass(Restricciones.class);
		q.setParameters(Cantidad);
		return (List<Restricciones>) q.executeList();
	}
	public void actualizarCantidad(PersistenceManager pm,Long Cantidad,Long idRestriccion)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaRestricciones () + " SET cantidad=? WHERE idRestriccion=?");
		q.setParameters(Cantidad,idRestriccion);
		q.executeUnique();
	}
	public Long eliminarRestriccionesPorProducto (PersistenceManager pm,Long Producto)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaRestricciones () + " WHERE producto=?");
		q.setParameters(Producto);
		return (Long) q.executeUnique();
	}
	public List<Restricciones> darRestriccionesPorProducto (PersistenceManager pm,Long Producto)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaRestricciones () + " WHERE producto=?");
		q.setResultClass(Restricciones.class);
		q.setParameters(Producto);
		return (List<Restricciones>) q.executeList();
	}
	public void actualizarProducto(PersistenceManager pm,Long Producto,Long idRestriccion)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaRestricciones () + " SET producto=? WHERE idRestriccion=?");
		q.setParameters(Producto,idRestriccion);
		q.executeUnique();
	}
}
