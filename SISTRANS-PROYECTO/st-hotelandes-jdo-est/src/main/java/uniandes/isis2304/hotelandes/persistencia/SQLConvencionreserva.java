package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Convencionreserva;
import java.sql.Timestamp;

class SQLConvencionreserva
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLConvencionreserva (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarConvencionreserva(PersistenceManager pm,Long idConvencion,Long idReserva)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaConvencionreserva () + "(idConvencion,idReserva) values (?,?)");
		q.setParameters(idConvencion,idReserva);
		return (Long) q.executeUnique();
	}
	public Long eliminarConvencionreservaPorId (PersistenceManager pm,Long idConvencion,Long idReserva)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConvencionreserva () + " WHERE idConvencion=? and idReserva=?");
		q.setParameters(idConvencion,idReserva);
		return (Long) q.executeUnique();
	}
	public Convencionreserva darConvencionreservaPorId (PersistenceManager pm,Long idConvencion,Long idReserva)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConvencionreserva() + " WHERE idConvencion=? and idReserva=?");
		q.setResultClass(Convencionreserva.class);
		q.setParameters(idConvencion,idReserva);
		return (Convencionreserva) q.executeUnique();
	}
	public List<Convencionreserva> darConvencionreservas (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConvencionreserva());
		q.setResultClass(Convencionreserva.class);
		return (List<Convencionreserva>) q.executeList();
	}
	public Long eliminarConvencionreservaPorIdconvencion (PersistenceManager pm,Long Idconvencion)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConvencionreserva () + " WHERE idConvencion=?");
		q.setParameters(Idconvencion);
		return (Long) q.executeUnique();
	}
	public List<Convencionreserva> darConvencionreservaPorIdconvencion (PersistenceManager pm,Long Idconvencion)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConvencionreserva () + " WHERE idConvencion=?");
		q.setResultClass(Convencionreserva.class);
		q.setParameters(Idconvencion);
		return (List<Convencionreserva>) q.executeList();
	}
	public void actualizarIdconvencion(PersistenceManager pm,Long Idconvencion,Long idConvencion,Long idReserva)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaConvencionreserva () + " SET idConvencion=? WHERE idConvencion=? and idReserva=?");
		q.setParameters(Idconvencion,idConvencion,idReserva);
		q.executeUnique();
	}
	public Long eliminarConvencionreservaPorIdreserva (PersistenceManager pm,Long Idreserva)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConvencionreserva () + " WHERE idReserva=?");
		q.setParameters(Idreserva);
		return (Long) q.executeUnique();
	}
	public List<Convencionreserva> darConvencionreservaPorIdreserva (PersistenceManager pm,Long Idreserva)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConvencionreserva () + " WHERE idReserva=?");
		q.setResultClass(Convencionreserva.class);
		q.setParameters(Idreserva);
		return (List<Convencionreserva>) q.executeList();
	}
	public void actualizarIdreserva(PersistenceManager pm,Long Idreserva,Long idConvencion,Long idReserva)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaConvencionreserva () + " SET idReserva=? WHERE idConvencion=? and idReserva=?");
		q.setParameters(Idreserva,idConvencion,idReserva);
		q.executeUnique();
	}
}
