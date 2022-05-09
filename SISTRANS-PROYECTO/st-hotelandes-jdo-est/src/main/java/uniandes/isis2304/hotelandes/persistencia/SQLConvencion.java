package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Convencion;
import java.sql.Timestamp;

class SQLConvencion
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLConvencion (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarConvencion(PersistenceManager pm,Long idConvencion,Timestamp fechaInicio,Timestamp fechaFin,String nombre,Long capacidadActual,Long capacidadMaxima,Long idHotel,Long idCuenta,Long idPlanConsumo,Long idPlanCobro)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaConvencion () + "(idConvencion,fechaInicio,fechaFin,nombre,capacidadActual,capacidadMaxima,idHotel,idCuenta,idPlanConsumo,idPlanCobro) values (?,?,?,?,?,?,?,?,?,?)");
		q.setParameters(idConvencion,fechaInicio,fechaFin,nombre,capacidadActual,capacidadMaxima,idHotel,idCuenta,idPlanConsumo,idPlanCobro);
		return (Long) q.executeUnique();
	}
	public Long eliminarConvencionPorId (PersistenceManager pm,Long idConvencion)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConvencion () + " WHERE idConvencion=?");
		q.setParameters(idConvencion);
		return (Long) q.executeUnique();
	}
	public Convencion darConvencionPorId (PersistenceManager pm,Long idConvencion)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConvencion() + " WHERE idConvencion=?");
		q.setResultClass(Convencion.class);
		q.setParameters(idConvencion);
		return (Convencion) q.executeUnique();
	}
	public List<Convencion> darConvencions (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConvencion());
		q.setResultClass(Convencion.class);
		return (List<Convencion>) q.executeList();
	}
	public Long eliminarConvencionPorFechainicio (PersistenceManager pm,Timestamp Fechainicio)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConvencion () + " WHERE fechaInicio=?");
		q.setParameters(Fechainicio);
		return (Long) q.executeUnique();
	}
	public List<Convencion> darConvencionPorFechainicio (PersistenceManager pm,Timestamp Fechainicio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConvencion () + " WHERE fechaInicio=?");
		q.setResultClass(Convencion.class);
		q.setParameters(Fechainicio);
		return (List<Convencion>) q.executeList();
	}
	public void actualizarFechainicio(PersistenceManager pm,Timestamp Fechainicio,Long idConvencion)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaConvencion () + " SET fechaInicio=? WHERE idConvencion=?");
		q.setParameters(Fechainicio,idConvencion);
		q.executeUnique();
	}
	public Long eliminarConvencionPorFechafin (PersistenceManager pm,Timestamp Fechafin)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConvencion () + " WHERE fechaFin=?");
		q.setParameters(Fechafin);
		return (Long) q.executeUnique();
	}
	public List<Convencion> darConvencionPorFechafin (PersistenceManager pm,Timestamp Fechafin)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConvencion () + " WHERE fechaFin=?");
		q.setResultClass(Convencion.class);
		q.setParameters(Fechafin);
		return (List<Convencion>) q.executeList();
	}
	public void actualizarFechafin(PersistenceManager pm,Timestamp Fechafin,Long idConvencion)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaConvencion () + " SET fechaFin=? WHERE idConvencion=?");
		q.setParameters(Fechafin,idConvencion);
		q.executeUnique();
	}
	public Long eliminarConvencionPorNombre (PersistenceManager pm,String Nombre)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConvencion () + " WHERE nombre=?");
		q.setParameters(Nombre);
		return (Long) q.executeUnique();
	}
	public List<Convencion> darConvencionPorNombre (PersistenceManager pm,String Nombre)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConvencion () + " WHERE nombre=?");
		q.setResultClass(Convencion.class);
		q.setParameters(Nombre);
		return (List<Convencion>) q.executeList();
	}
	public void actualizarNombre(PersistenceManager pm,String Nombre,Long idConvencion)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaConvencion () + " SET nombre=? WHERE idConvencion=?");
		q.setParameters(Nombre,idConvencion);
		q.executeUnique();
	}
	public Long eliminarConvencionPorCapacidadactual (PersistenceManager pm,Long Capacidadactual)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConvencion () + " WHERE capacidadActual=?");
		q.setParameters(Capacidadactual);
		return (Long) q.executeUnique();
	}
	public List<Convencion> darConvencionPorCapacidadactual (PersistenceManager pm,Long Capacidadactual)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConvencion () + " WHERE capacidadActual=?");
		q.setResultClass(Convencion.class);
		q.setParameters(Capacidadactual);
		return (List<Convencion>) q.executeList();
	}
	public void actualizarCapacidadactual(PersistenceManager pm,Long Capacidadactual,Long idConvencion)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaConvencion () + " SET capacidadActual=? WHERE idConvencion=?");
		q.setParameters(Capacidadactual,idConvencion);
		q.executeUnique();
	}
	public Long eliminarConvencionPorCapacidadmaxima (PersistenceManager pm,Long Capacidadmaxima)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConvencion () + " WHERE capacidadMaxima=?");
		q.setParameters(Capacidadmaxima);
		return (Long) q.executeUnique();
	}
	public List<Convencion> darConvencionPorCapacidadmaxima (PersistenceManager pm,Long Capacidadmaxima)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConvencion () + " WHERE capacidadMaxima=?");
		q.setResultClass(Convencion.class);
		q.setParameters(Capacidadmaxima);
		return (List<Convencion>) q.executeList();
	}
	public void actualizarCapacidadmaxima(PersistenceManager pm,Long Capacidadmaxima,Long idConvencion)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaConvencion () + " SET capacidadMaxima=? WHERE idConvencion=?");
		q.setParameters(Capacidadmaxima,idConvencion);
		q.executeUnique();
	}
	public Long eliminarConvencionPorIdhotel (PersistenceManager pm,Long Idhotel)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConvencion () + " WHERE idHotel=?");
		q.setParameters(Idhotel);
		return (Long) q.executeUnique();
	}
	public List<Convencion> darConvencionPorIdhotel (PersistenceManager pm,Long Idhotel)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConvencion () + " WHERE idHotel=?");
		q.setResultClass(Convencion.class);
		q.setParameters(Idhotel);
		return (List<Convencion>) q.executeList();
	}
	public void actualizarIdhotel(PersistenceManager pm,Long Idhotel,Long idConvencion)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaConvencion () + " SET idHotel=? WHERE idConvencion=?");
		q.setParameters(Idhotel,idConvencion);
		q.executeUnique();
	}
	public Long eliminarConvencionPorIdcuenta (PersistenceManager pm,Long Idcuenta)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConvencion () + " WHERE idCuenta=?");
		q.setParameters(Idcuenta);
		return (Long) q.executeUnique();
	}
	public List<Convencion> darConvencionPorIdcuenta (PersistenceManager pm,Long Idcuenta)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConvencion () + " WHERE idCuenta=?");
		q.setResultClass(Convencion.class);
		q.setParameters(Idcuenta);
		return (List<Convencion>) q.executeList();
	}
	public void actualizarIdcuenta(PersistenceManager pm,Long Idcuenta,Long idConvencion)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaConvencion () + " SET idCuenta=? WHERE idConvencion=?");
		q.setParameters(Idcuenta,idConvencion);
		q.executeUnique();
	}
	public Long eliminarConvencionPorIdplanconsumo (PersistenceManager pm,Long Idplanconsumo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConvencion () + " WHERE idPlanConsumo=?");
		q.setParameters(Idplanconsumo);
		return (Long) q.executeUnique();
	}
	public List<Convencion> darConvencionPorIdplanconsumo (PersistenceManager pm,Long Idplanconsumo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConvencion () + " WHERE idPlanConsumo=?");
		q.setResultClass(Convencion.class);
		q.setParameters(Idplanconsumo);
		return (List<Convencion>) q.executeList();
	}
	public void actualizarIdplanconsumo(PersistenceManager pm,Long Idplanconsumo,Long idConvencion)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaConvencion () + " SET idPlanConsumo=? WHERE idConvencion=?");
		q.setParameters(Idplanconsumo,idConvencion);
		q.executeUnique();
	}
	public Long eliminarConvencionPorIdplancobro (PersistenceManager pm,Long Idplancobro)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConvencion () + " WHERE idPlanCobro=?");
		q.setParameters(Idplancobro);
		return (Long) q.executeUnique();
	}
	public List<Convencion> darConvencionPorIdplancobro (PersistenceManager pm,Long Idplancobro)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConvencion () + " WHERE idPlanCobro=?");
		q.setResultClass(Convencion.class);
		q.setParameters(Idplancobro);
		return (List<Convencion>) q.executeList();
	}
	public void actualizarIdplancobro(PersistenceManager pm,Long Idplancobro,Long idConvencion)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaConvencion () + " SET idPlanCobro=? WHERE idConvencion=?");
		q.setParameters(Idplancobro,idConvencion);
		q.executeUnique();
	}
}
