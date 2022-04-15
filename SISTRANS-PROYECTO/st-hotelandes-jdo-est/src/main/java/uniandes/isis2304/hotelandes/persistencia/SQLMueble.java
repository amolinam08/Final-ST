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
	public Long eliminarMueblePorTipomueble (PersistenceManager pm,String Tipomueble)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMueble () + " WHERE tipoMueble=?");
		q.setParameters(Tipomueble);
		return (Long) q.executeUnique();
	}
	public List<Mueble> darMueblePorTipomueble (PersistenceManager pm,String Tipomueble)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMueble () + " WHERE tipoMueble=?");
		q.setResultClass(Mueble.class);
		q.setParameters(Tipomueble);
		return (List<Mueble>) q.executeList();
	}
	public void actualizarTipomueble(PersistenceManager pm,String Tipomueble,Long idMueble)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaMueble () + " SET tipoMueble=? WHERE idMueble=?");
		q.setParameters(Tipomueble,idMueble);
		q.executeUnique();
	}
	public Long eliminarMueblePorCostomueble (PersistenceManager pm,Double Costomueble)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMueble () + " WHERE costoMueble=?");
		q.setParameters(Costomueble);
		return (Long) q.executeUnique();
	}
	public List<Mueble> darMueblePorCostomueble (PersistenceManager pm,Double Costomueble)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMueble () + " WHERE costoMueble=?");
		q.setResultClass(Mueble.class);
		q.setParameters(Costomueble);
		return (List<Mueble>) q.executeList();
	}
	public void actualizarCostomueble(PersistenceManager pm,Double Costomueble,Long idMueble)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaMueble () + " SET costoMueble=? WHERE idMueble=?");
		q.setParameters(Costomueble,idMueble);
		q.executeUnique();
	}
	public Long eliminarMueblePorHabitacion (PersistenceManager pm,Long Habitacion)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMueble () + " WHERE habitacion=?");
		q.setParameters(Habitacion);
		return (Long) q.executeUnique();
	}
	public List<Mueble> darMueblePorHabitacion (PersistenceManager pm,Long Habitacion)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMueble () + " WHERE habitacion=?");
		q.setResultClass(Mueble.class);
		q.setParameters(Habitacion);
		return (List<Mueble>) q.executeList();
	}
	public void actualizarHabitacion(PersistenceManager pm,Long Habitacion,Long idMueble)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaMueble () + " SET habitacion=? WHERE idMueble=?");
		q.setParameters(Habitacion,idMueble);
		q.executeUnique();
	}
}