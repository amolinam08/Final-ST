package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Oferta;
import java.sql.Timestamp;

class SQLOferta
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLOferta (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarOferta(PersistenceManager pm,Long idOferta,Double descuento,String descripcion,Long idHabitacion)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaOferta () + "(idOferta,descuento,descripcion,idHabitacion) values (?,?,?,?)");
		q.setParameters(idOferta,descuento,descripcion,idHabitacion);
		return (Long) q.executeUnique();
	}
	public Long eliminarOfertaPorId (PersistenceManager pm,Long idOferta)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOferta () + " WHERE idOferta=?");
		q.setParameters(idOferta);
		return (Long) q.executeUnique();
	}
	public Oferta darOfertaPorId (PersistenceManager pm,Long idOferta)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOferta() + " WHERE idOferta=?");
		q.setResultClass(Oferta.class);
		q.setParameters(idOferta);
		return (Oferta) q.executeUnique();
	}
	public List<Oferta> darOfertas (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOferta());
		q.setResultClass(Oferta.class);
		return (List<Oferta>) q.executeList();
	}
	public Long eliminarOfertaPorDescuento (PersistenceManager pm,Double Descuento)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOferta () + " WHERE descuento=?");
		q.setParameters(Descuento);
		return (Long) q.executeUnique();
	}
	public List<Oferta> darOfertaPorDescuento (PersistenceManager pm,Double Descuento)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOferta () + " WHERE descuento=?");
		q.setResultClass(Oferta.class);
		q.setParameters(Descuento);
		return (List<Oferta>) q.executeList();
	}
	public void actualizarDescuento(PersistenceManager pm,Double Descuento,Long idOferta)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaOferta () + " SET descuento=? WHERE idOferta=?");
		q.setParameters(Descuento,idOferta);
		q.executeUnique();
	}
	public Long eliminarOfertaPorDescripcion (PersistenceManager pm,String Descripcion)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOferta () + " WHERE descripcion=?");
		q.setParameters(Descripcion);
		return (Long) q.executeUnique();
	}
	public List<Oferta> darOfertaPorDescripcion (PersistenceManager pm,String Descripcion)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOferta () + " WHERE descripcion=?");
		q.setResultClass(Oferta.class);
		q.setParameters(Descripcion);
		return (List<Oferta>) q.executeList();
	}
	public void actualizarDescripcion(PersistenceManager pm,String Descripcion,Long idOferta)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaOferta () + " SET descripcion=? WHERE idOferta=?");
		q.setParameters(Descripcion,idOferta);
		q.executeUnique();
	}
	public Long eliminarOfertaPorIdhabitacion (PersistenceManager pm,Long Idhabitacion)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOferta () + " WHERE idHabitacion=?");
		q.setParameters(Idhabitacion);
		return (Long) q.executeUnique();
	}
	public List<Oferta> darOfertaPorIdhabitacion (PersistenceManager pm,Long Idhabitacion)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOferta () + " WHERE idHabitacion=?");
		q.setResultClass(Oferta.class);
		q.setParameters(Idhabitacion);
		return (List<Oferta>) q.executeList();
	}
	public void actualizarIdhabitacion(PersistenceManager pm,Long Idhabitacion,Long idOferta)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaOferta () + " SET idHabitacion=? WHERE idOferta=?");
		q.setParameters(Idhabitacion,idOferta);
		q.executeUnique();
	}
}
