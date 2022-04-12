package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Cartaproductos;
import java.sql.Timestamp;

class SQLCartaproductos
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLCartaproductos (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarCartaproductos(PersistenceManager pm,Long idCarta,String nombre)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaCartaproductos () + "(idCarta,nombre) values (?,?)");
		q.setParameters(idCarta,nombre);
		return (Long) q.executeUnique();
	}
	public Long eliminarCartaproductosPorId (PersistenceManager pm,Long idCarta)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCartaproductos () + " WHERE idCarta=?");
		q.setParameters(idCarta);
		return (Long) q.executeUnique();
	}
	public Cartaproductos darCartaproductosPorId (PersistenceManager pm,Long idCarta)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCartaproductos() + " WHERE idCarta=?");
		q.setResultClass(Cartaproductos.class);
		q.setParameters(idCarta);
		return (Cartaproductos) q.executeUnique();
	}
	public List<Cartaproductos> darCartaproductoss (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCartaproductos());
		q.setResultClass(Cartaproductos.class);
		return (List<Cartaproductos>) q.executeList();
	}
}