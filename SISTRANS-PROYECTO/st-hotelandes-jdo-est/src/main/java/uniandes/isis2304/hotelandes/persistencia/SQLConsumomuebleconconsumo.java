package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Consumomuebleconconsumo;
import java.sql.Timestamp;

class SQLConsumomuebleconconsumo
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLConsumomuebleconconsumo (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarConsumomuebleconconsumo(PersistenceManager pm,Long idConsumo,Long idMuebleConConsumo)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaConsumomuebleconconsumo () + "(idConsumo,idMuebleConConsumo) values (?,?)");
		q.setParameters(idConsumo,idMuebleConConsumo);
		return (Long) q.executeUnique();
	}
	public Long eliminarConsumomuebleconconsumoPorId (PersistenceManager pm,Long idConsumo,Long idMuebleConConsumo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsumomuebleconconsumo () + " WHERE idConsumo=? and idMuebleConConsumo=?");
		q.setParameters(idConsumo,idMuebleConConsumo);
		return (Long) q.executeUnique();
	}
	public Consumomuebleconconsumo darConsumomuebleconconsumoPorId (PersistenceManager pm,Long idConsumo,Long idMuebleConConsumo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumomuebleconconsumo() + " WHERE idConsumo=? and idMuebleConConsumo=?");
		q.setResultClass(Consumomuebleconconsumo.class);
		q.setParameters(idConsumo,idMuebleConConsumo);
		return (Consumomuebleconconsumo) q.executeUnique();
	}
	public List<Consumomuebleconconsumo> darConsumomuebleconconsumos (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumomuebleconconsumo());
		q.setResultClass(Consumomuebleconconsumo.class);
		return (List<Consumomuebleconconsumo>) q.executeList();
	}
	public Long eliminarConsumomuebleconconsumoPorIdconsumo (PersistenceManager pm,Long Idconsumo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsumomuebleconconsumo () + " WHERE idConsumo=?");
		q.setParameters(Idconsumo);
		return (Long) q.executeUnique();
	}
	public List<Consumomuebleconconsumo> darConsumomuebleconconsumoPorIdconsumo (PersistenceManager pm,Long Idconsumo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumomuebleconconsumo () + " WHERE idConsumo=?");
		q.setResultClass(Consumomuebleconconsumo.class);
		q.setParameters(Idconsumo);
		return (List<Consumomuebleconconsumo>) q.executeList();
	}
	public void actualizarIdconsumo(PersistenceManager pm,Long Idconsumo,Long idConsumo,Long idMuebleConConsumo)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaConsumomuebleconconsumo () + " SET idConsumo=? WHERE idConsumo=? and idMuebleConConsumo=?");
		q.setParameters(Idconsumo,idConsumo,idMuebleConConsumo);
		q.executeUnique();
	}
	public Long eliminarConsumomuebleconconsumoPorIdmuebleconconsumo (PersistenceManager pm,Long Idmuebleconconsumo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsumomuebleconconsumo () + " WHERE idMuebleConConsumo=?");
		q.setParameters(Idmuebleconconsumo);
		return (Long) q.executeUnique();
	}
	public List<Consumomuebleconconsumo> darConsumomuebleconconsumoPorIdmuebleconconsumo (PersistenceManager pm,Long Idmuebleconconsumo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumomuebleconconsumo () + " WHERE idMuebleConConsumo=?");
		q.setResultClass(Consumomuebleconconsumo.class);
		q.setParameters(Idmuebleconconsumo);
		return (List<Consumomuebleconconsumo>) q.executeList();
	}
	public void actualizarIdmuebleconconsumo(PersistenceManager pm,Long Idmuebleconconsumo,Long idConsumo,Long idMuebleConConsumo)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaConsumomuebleconconsumo () + " SET idMuebleConConsumo=? WHERE idConsumo=? and idMuebleConConsumo=?");
		q.setParameters(Idmuebleconconsumo,idConsumo,idMuebleConConsumo);
		q.executeUnique();
	}
}
