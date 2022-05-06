package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Consumoproducto;
import java.sql.Timestamp;

class SQLConsumoproducto
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLConsumoproducto (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarConsumoproducto(PersistenceManager pm,Long idProducto,Long idConsumo)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaConsumoproducto () + "(idProducto,idConsumo) values (?,?)");
		q.setParameters(idProducto,idConsumo);
		return (Long) q.executeUnique();
	}
	public Long eliminarConsumoproductoPorId (PersistenceManager pm,Long idProducto,Long idConsumo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsumoproducto () + " WHERE idProducto=? and idConsumo=?");
		q.setParameters(idProducto,idConsumo);
		return (Long) q.executeUnique();
	}
	public Consumoproducto darConsumoproductoPorId (PersistenceManager pm,Long idProducto,Long idConsumo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumoproducto() + " WHERE idProducto=? and idConsumo=?");
		q.setResultClass(Consumoproducto.class);
		q.setParameters(idProducto,idConsumo);
		return (Consumoproducto) q.executeUnique();
	}
	public List<Consumoproducto> darConsumoproductos (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumoproducto());
		q.setResultClass(Consumoproducto.class);
		return (List<Consumoproducto>) q.executeList();
	}
	public Long eliminarConsumoproductoPorIdproducto (PersistenceManager pm,Long Idproducto)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsumoproducto () + " WHERE idProducto=?");
		q.setParameters(Idproducto);
		return (Long) q.executeUnique();
	}
	public List<Consumoproducto> darConsumoproductoPorIdproducto (PersistenceManager pm,Long Idproducto)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumoproducto () + " WHERE idProducto=?");
		q.setResultClass(Consumoproducto.class);
		q.setParameters(Idproducto);
		return (List<Consumoproducto>) q.executeList();
	}
	public void actualizarIdproducto(PersistenceManager pm,Long Idproducto,Long idProducto,Long idConsumo)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaConsumoproducto () + " SET idProducto=? WHERE idProducto=? and idConsumo=?");
		q.setParameters(Idproducto,idProducto,idConsumo);
		q.executeUnique();
	}
	public Long eliminarConsumoproductoPorIdconsumo (PersistenceManager pm,Long Idconsumo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsumoproducto () + " WHERE idConsumo=?");
		q.setParameters(Idconsumo);
		return (Long) q.executeUnique();
	}
	public List<Consumoproducto> darConsumoproductoPorIdconsumo (PersistenceManager pm,Long Idconsumo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumoproducto () + " WHERE idConsumo=?");
		q.setResultClass(Consumoproducto.class);
		q.setParameters(Idconsumo);
		return (List<Consumoproducto>) q.executeList();
	}
	public void actualizarIdconsumo(PersistenceManager pm,Long Idconsumo,Long idProducto,Long idConsumo)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaConsumoproducto () + " SET idConsumo=? WHERE idProducto=? and idConsumo=?");
		q.setParameters(Idconsumo,idProducto,idConsumo);
		q.executeUnique();
	}
}
