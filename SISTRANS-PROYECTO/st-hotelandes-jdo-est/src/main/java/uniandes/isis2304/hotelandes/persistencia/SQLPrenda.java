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
}