package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Prenda;
import java.sql.Timestamp;

class SQLPrenda
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLPrenda (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarPrenda(PersistenceManager pm,Long idPrenda,String tipoPrenda,Double costoLavado,Long cliente)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaPrenda () + "(idPrenda,tipoPrenda,costoLavado,cliente) values (?,?,?,?)");
		q.setParameters(idPrenda,tipoPrenda,costoLavado,cliente);
		return (Long) q.executeUnique();
	}
	public Long eliminarPrendaPorId (PersistenceManager pm,Long idPrenda)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPrenda () + " WHERE idPrenda=?");
		q.setParameters(idPrenda);
		return (Long) q.executeUnique();
	}
	public Prenda darPrendaPorId (PersistenceManager pm,Long idPrenda)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPrenda() + " WHERE idPrenda=?");
		q.setResultClass(Prenda.class);
		q.setParameters(idPrenda);
		return (Prenda) q.executeUnique();
	}
	public List<Prenda> darPrendas (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPrenda());
		q.setResultClass(Prenda.class);
		return (List<Prenda>) q.executeList();
	}
	public Long eliminarPrendaPorTipoprenda (PersistenceManager pm,String Tipoprenda)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPrenda () + " WHERE tipoPrenda=?");
		q.setParameters(Tipoprenda);
		return (Long) q.executeUnique();
	}
	public List<Prenda> darPrendaPorTipoprenda (PersistenceManager pm,String Tipoprenda)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPrenda () + " WHERE tipoPrenda=?");
		q.setResultClass(Prenda.class);
		q.setParameters(Tipoprenda);
		return (List<Prenda>) q.executeList();
	}
	public void actualizarTipoprenda(PersistenceManager pm,String Tipoprenda,Long idPrenda)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaPrenda () + " SET tipoPrenda=? WHERE idPrenda=?");
		q.setParameters(Tipoprenda,idPrenda);
		q.executeUnique();
	}
	public Long eliminarPrendaPorCostolavado (PersistenceManager pm,Double Costolavado)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPrenda () + " WHERE costoLavado=?");
		q.setParameters(Costolavado);
		return (Long) q.executeUnique();
	}
	public List<Prenda> darPrendaPorCostolavado (PersistenceManager pm,Double Costolavado)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPrenda () + " WHERE costoLavado=?");
		q.setResultClass(Prenda.class);
		q.setParameters(Costolavado);
		return (List<Prenda>) q.executeList();
	}
	public void actualizarCostolavado(PersistenceManager pm,Double Costolavado,Long idPrenda)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaPrenda () + " SET costoLavado=? WHERE idPrenda=?");
		q.setParameters(Costolavado,idPrenda);
		q.executeUnique();
	}
	public Long eliminarPrendaPorCliente (PersistenceManager pm,Long Cliente)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPrenda () + " WHERE cliente=?");
		q.setParameters(Cliente);
		return (Long) q.executeUnique();
	}
	public List<Prenda> darPrendaPorCliente (PersistenceManager pm,Long Cliente)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPrenda () + " WHERE cliente=?");
		q.setResultClass(Prenda.class);
		q.setParameters(Cliente);
		return (List<Prenda>) q.executeList();
	}
	public void actualizarCliente(PersistenceManager pm,Long Cliente,Long idPrenda)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaPrenda () + " SET cliente=? WHERE idPrenda=?");
		q.setParameters(Cliente,idPrenda);
		q.executeUnique();
	}
}
