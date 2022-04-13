package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Cartaproductosproductos;
import java.sql.Timestamp;

class SQLCartaproductosproductos
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLCartaproductosproductos (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarCartaproductosproductos(PersistenceManager pm,Long idCarta,Long idProducto)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaCartaproductosproductos () + "(idCarta,idProducto) values (?,?)");
		q.setParameters(idCarta,idProducto);
		return (Long) q.executeUnique();
	}
	public Long eliminarCartaproductosproductosPorId (PersistenceManager pm,Long idCarta,Long idProducto)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCartaproductosproductos () + " WHERE idCarta=? and idProducto=?");
		q.setParameters(idCarta,idProducto);
		return (Long) q.executeUnique();
	}
	public Cartaproductosproductos darCartaproductosproductosPorId (PersistenceManager pm,Long idCarta,Long idProducto)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCartaproductosproductos() + " WHERE idCarta=? and idProducto=?");
		q.setResultClass(Cartaproductosproductos.class);
		q.setParameters(idCarta,idProducto);
		return (Cartaproductosproductos) q.executeUnique();
	}
	public List<Cartaproductosproductos> darCartaproductosproductoss (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCartaproductosproductos());
		q.setResultClass(Cartaproductosproductos.class);
		return (List<Cartaproductosproductos>) q.executeList();
	}
	public Long eliminarCartaproductosproductosPorIdcarta (PersistenceManager pm,Long Idcarta)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCartaproductosproductos () + " WHERE idCarta=?");
		q.setParameters(Idcarta);
		return (Long) q.executeUnique();
	}
	public List<Cartaproductosproductos> darCartaproductosproductosPorIdcarta (PersistenceManager pm,Long Idcarta)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCartaproductosproductos () + " WHERE idCarta=?");
		q.setResultClass(Cartaproductosproductos.class);
		q.setParameters(Idcarta);
		return (List<Cartaproductosproductos>) q.executeList();
	}
	public Long eliminarCartaproductosproductosPorIdproducto (PersistenceManager pm,Long Idproducto)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCartaproductosproductos () + " WHERE idProducto=?");
		q.setParameters(Idproducto);
		return (Long) q.executeUnique();
	}
	public List<Cartaproductosproductos> darCartaproductosproductosPorIdproducto (PersistenceManager pm,Long Idproducto)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCartaproductosproductos () + " WHERE idProducto=?");
		q.setResultClass(Cartaproductosproductos.class);
		q.setParameters(Idproducto);
		return (List<Cartaproductosproductos>) q.executeList();
	}
}