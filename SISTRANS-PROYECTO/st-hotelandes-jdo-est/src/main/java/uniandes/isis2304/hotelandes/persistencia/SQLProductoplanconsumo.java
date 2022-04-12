package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Productoplanconsumo;
import java.sql.Timestamp;

class SQLProductoplanconsumo
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLProductoplanconsumo (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarProductoplanconsumo(PersistenceManager pm,Long idProducto,Long idPlanConsumo)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaProductoplanconsumo () + "(idProducto,idPlanConsumo) values (?,?)");
		q.setParameters(idProducto,idPlanConsumo);
		return (Long) q.executeUnique();
	}
	public Long eliminarProductoplanconsumoPorId (PersistenceManager pm,Long idProducto,Long idPlanConsumo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProductoplanconsumo () + " WHERE idProducto=? and idPlanConsumo=?");
		q.setParameters(idProducto,idPlanConsumo);
		return (Long) q.executeUnique();
	}
	public Productoplanconsumo darProductoplanconsumoPorId (PersistenceManager pm,Long idProducto,Long idPlanConsumo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProductoplanconsumo() + " WHERE idProducto=? and idPlanConsumo=?");
		q.setResultClass(Productoplanconsumo.class);
		q.setParameters(idProducto,idPlanConsumo);
		return (Productoplanconsumo) q.executeUnique();
	}
	public List<Productoplanconsumo> darProductoplanconsumos (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProductoplanconsumo());
		q.setResultClass(Productoplanconsumo.class);
		return (List<Productoplanconsumo>) q.executeList();
	}
}