package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Mueble;
import java.sql.Timestamp;

class SQLMueble
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLMueble (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarMueble(PersistenceManager pm,Long idMueble,String tipoMueble,Double costoMueble,Long habitacion)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaMueble () + "(idMueble,tipoMueble,costoMueble,habitacion) values (?,?,?,?)");
		q.setParameters(idMueble,tipoMueble,costoMueble,habitacion);
		return (Long) q.executeUnique();
	}
	public Long eliminarMueblePorId (PersistenceManager pm,Long idMueble)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMueble () + " WHERE idMueble=?");
		q.setParameters(idMueble);
		return (Long) q.executeUnique();
	}
	public Mueble darMueblePorId (PersistenceManager pm,Long idMueble)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMueble() + " WHERE idMueble=?");
		q.setResultClass(Mueble.class);
		q.setParameters(idMueble);
		return (Mueble) q.executeUnique();
	}
	public List<Mueble> darMuebles (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMueble());
		q.setResultClass(Mueble.class);
		return (List<Mueble>) q.executeList();
	}
}