package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Producto;
import java.sql.Timestamp;

class SQLProducto
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLProducto (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarProducto(PersistenceManager pm,Long idProducto,String nombre,Double costo,Long consumo)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaProducto () + "(idProducto,nombre,costo,consumo) values (?,?,?,?)");
		q.setParameters(idProducto,nombre,costo,consumo);
		return (Long) q.executeUnique();
	}
	public Long eliminarProductoPorId (PersistenceManager pm,Long idProducto)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProducto () + " WHERE idProducto=?");
		q.setParameters(idProducto);
		return (Long) q.executeUnique();
	}
	public Producto darProductoPorId (PersistenceManager pm,Long idProducto)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProducto() + " WHERE idProducto=?");
		q.setResultClass(Producto.class);
		q.setParameters(idProducto);
		return (Producto) q.executeUnique();
	}
	public List<Producto> darProductos (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProducto());
		q.setResultClass(Producto.class);
		return (List<Producto>) q.executeList();
	}
	public Long eliminarProductoPorNombre (PersistenceManager pm,String Nombre)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProducto () + " WHERE nombre=?");
		q.setParameters(Nombre);
		return (Long) q.executeUnique();
	}
	public List<Producto> darProductoPorNombre (PersistenceManager pm,String Nombre)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProducto () + " WHERE nombre=?");
		q.setResultClass(Producto.class);
		q.setParameters(Nombre);
		return (List<Producto>) q.executeList();
	}
	public void actualizarNombre(PersistenceManager pm,String Nombre,Long idProducto)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaProducto () + " SET nombre=? WHERE idProducto=?");
		q.setParameters(Nombre,idProducto);
		q.executeUnique();
	}
	public Long eliminarProductoPorCosto (PersistenceManager pm,Double Costo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProducto () + " WHERE costo=?");
		q.setParameters(Costo);
		return (Long) q.executeUnique();
	}
	public List<Producto> darProductoPorCosto (PersistenceManager pm,Double Costo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProducto () + " WHERE costo=?");
		q.setResultClass(Producto.class);
		q.setParameters(Costo);
		return (List<Producto>) q.executeList();
	}
	public void actualizarCosto(PersistenceManager pm,Double Costo,Long idProducto)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaProducto () + " SET costo=? WHERE idProducto=?");
		q.setParameters(Costo,idProducto);
		q.executeUnique();
	}
	public Long eliminarProductoPorConsumo (PersistenceManager pm,Long Consumo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProducto () + " WHERE consumo=?");
		q.setParameters(Consumo);
		return (Long) q.executeUnique();
	}
	public List<Producto> darProductoPorConsumo (PersistenceManager pm,Long Consumo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProducto () + " WHERE consumo=?");
		q.setResultClass(Producto.class);
		q.setParameters(Consumo);
		return (List<Producto>) q.executeList();
	}
	public void actualizarConsumo(PersistenceManager pm,Long Consumo,Long idProducto)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaProducto () + " SET consumo=? WHERE idProducto=?");
		q.setParameters(Consumo,idProducto);
		q.executeUnique();
	}
}
