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
}