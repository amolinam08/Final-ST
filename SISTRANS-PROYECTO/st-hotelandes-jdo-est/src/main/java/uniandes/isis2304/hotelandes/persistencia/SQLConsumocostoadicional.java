package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Consumocostoadicional;
import java.sql.Timestamp;

class SQLConsumocostoadicional
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLConsumocostoadicional (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarConsumocostoadicional(PersistenceManager pm,Long idConsumo,Long idCostoAdicional)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaConsumocostoadicional () + "(idConsumo,idCostoAdicional) values (?,?)");
		q.setParameters(idConsumo,idCostoAdicional);
		return (Long) q.executeUnique();
	}
	public Long eliminarConsumocostoadicionalPorId (PersistenceManager pm,Long idConsumo,Long idCostoAdicional)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsumocostoadicional () + " WHERE idConsumo=? and idCostoAdicional=?");
		q.setParameters(idConsumo,idCostoAdicional);
		return (Long) q.executeUnique();
	}
	public Consumocostoadicional darConsumocostoadicionalPorId (PersistenceManager pm,Long idConsumo,Long idCostoAdicional)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumocostoadicional() + " WHERE idConsumo=? and idCostoAdicional=?");
		q.setResultClass(Consumocostoadicional.class);
		q.setParameters(idConsumo,idCostoAdicional);
		return (Consumocostoadicional) q.executeUnique();
	}
	public List<Consumocostoadicional> darConsumocostoadicionals (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumocostoadicional());
		q.setResultClass(Consumocostoadicional.class);
		return (List<Consumocostoadicional>) q.executeList();
	}
	public Long eliminarConsumocostoadicionalPorIdconsumo (PersistenceManager pm,Long Idconsumo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsumocostoadicional () + " WHERE idConsumo=?");
		q.setParameters(Idconsumo);
		return (Long) q.executeUnique();
	}
	public List<Consumocostoadicional> darConsumocostoadicionalPorIdconsumo (PersistenceManager pm,Long Idconsumo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumocostoadicional () + " WHERE idConsumo=?");
		q.setResultClass(Consumocostoadicional.class);
		q.setParameters(Idconsumo);
		return (List<Consumocostoadicional>) q.executeList();
	}
	public Long eliminarConsumocostoadicionalPorIdcostoadicional (PersistenceManager pm,Long Idcostoadicional)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsumocostoadicional () + " WHERE idCostoAdicional=?");
		q.setParameters(Idcostoadicional);
		return (Long) q.executeUnique();
	}
	public List<Consumocostoadicional> darConsumocostoadicionalPorIdcostoadicional (PersistenceManager pm,Long Idcostoadicional)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumocostoadicional () + " WHERE idCostoAdicional=?");
		q.setResultClass(Consumocostoadicional.class);
		q.setParameters(Idcostoadicional);
		return (List<Consumocostoadicional>) q.executeList();
	}
}