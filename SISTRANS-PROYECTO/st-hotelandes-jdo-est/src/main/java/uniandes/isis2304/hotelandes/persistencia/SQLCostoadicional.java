package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Costoadicional;
import java.sql.Timestamp;

class SQLCostoadicional
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLCostoadicional (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarCostoadicional(PersistenceManager pm,Long idCostoAdicional,String nombre,Double costo,Long servicio)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaCostoadicional () + "(idCostoAdicional,nombre,costo,servicio) values (?,?,?,?)");
		q.setParameters(idCostoAdicional,nombre,costo,servicio);
		return (Long) q.executeUnique();
	}
	public Long eliminarCostoadicionalPorId (PersistenceManager pm,Long idCostoAdicional)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCostoadicional () + " WHERE idCostoAdicional=?");
		q.setParameters(idCostoAdicional);
		return (Long) q.executeUnique();
	}
	public Costoadicional darCostoadicionalPorId (PersistenceManager pm,Long idCostoAdicional)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCostoadicional() + " WHERE idCostoAdicional=?");
		q.setResultClass(Costoadicional.class);
		q.setParameters(idCostoAdicional);
		return (Costoadicional) q.executeUnique();
	}
	public List<Costoadicional> darCostoadicionals (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCostoadicional());
		q.setResultClass(Costoadicional.class);
		return (List<Costoadicional>) q.executeList();
	}
}