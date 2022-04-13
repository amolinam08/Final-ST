package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Productoconsumo;
import java.sql.Timestamp;

class SQLProductoconsumo
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLProductoconsumo (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarProductoconsumo(PersistenceManager pm,Long idProducto,Long idConsumo)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaProductoconsumo () + "(idProducto,idConsumo) values (?,?)");
		q.setParameters(idProducto,idConsumo);
		return (Long) q.executeUnique();
	}
	public Long eliminarProductoconsumoPorId (PersistenceManager pm,Long idProducto,Long idConsumo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProductoconsumo () + " WHERE idProducto=? and idConsumo=?");
		q.setParameters(idProducto,idConsumo);
		return (Long) q.executeUnique();
	}
	public Productoconsumo darProductoconsumoPorId (PersistenceManager pm,Long idProducto,Long idConsumo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProductoconsumo() + " WHERE idProducto=? and idConsumo=?");
		q.setResultClass(Productoconsumo.class);
		q.setParameters(idProducto,idConsumo);
		return (Productoconsumo) q.executeUnique();
	}
	public List<Productoconsumo> darProductoconsumos (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProductoconsumo());
		q.setResultClass(Productoconsumo.class);
		return (List<Productoconsumo>) q.executeList();
	}
	public Long eliminarProductoconsumoPorIdproducto (PersistenceManager pm,Long Idproducto)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProductoconsumo () + " WHERE idProducto=?");
		q.setParameters(Idproducto);
		return (Long) q.executeUnique();
	}
	public List<Productoconsumo> darProductoconsumoPorIdproducto (PersistenceManager pm,Long Idproducto)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProductoconsumo () + " WHERE idProducto=?");
		q.setResultClass(Productoconsumo.class);
		q.setParameters(Idproducto);
		return (List<Productoconsumo>) q.executeList();
	}
	public Long eliminarProductoconsumoPorIdconsumo (PersistenceManager pm,Long Idconsumo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProductoconsumo () + " WHERE idConsumo=?");
		q.setParameters(Idconsumo);
		return (Long) q.executeUnique();
	}
	public List<Productoconsumo> darProductoconsumoPorIdconsumo (PersistenceManager pm,Long Idconsumo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProductoconsumo () + " WHERE idConsumo=?");
		q.setResultClass(Productoconsumo.class);
		q.setParameters(Idconsumo);
		return (List<Productoconsumo>) q.executeList();
	}
}