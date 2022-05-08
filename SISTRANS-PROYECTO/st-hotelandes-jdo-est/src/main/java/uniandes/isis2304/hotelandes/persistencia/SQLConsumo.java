package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Consumo;
import java.sql.Timestamp;

class SQLConsumo
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLConsumo (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarConsumo(PersistenceManager pm,Long idConsumo,Timestamp fecha,Long cuenta,Long registroConsumo,Long empleado,String pagado)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaConsumo () + "(idConsumo,fecha,cuenta,registroConsumo,empleado,pagado) values (?,?,?,?,?,?)");
		q.setParameters(idConsumo,fecha,cuenta,registroConsumo,empleado,pagado);
		return (Long) q.executeUnique();
	}
	public Long eliminarConsumoPorId (PersistenceManager pm,Long idConsumo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsumo () + " WHERE idConsumo=?");
		q.setParameters(idConsumo);
		return (Long) q.executeUnique();
	}
	public Consumo darConsumoPorId (PersistenceManager pm,Long idConsumo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumo() + " WHERE idConsumo=?");
		q.setResultClass(Consumo.class);
		q.setParameters(idConsumo);
		return (Consumo) q.executeUnique();
	}
	public List<Consumo> darConsumos (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumo());
		q.setResultClass(Consumo.class);
		return (List<Consumo>) q.executeList();
	}
	public Long eliminarConsumoPorFecha (PersistenceManager pm,Timestamp Fecha)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsumo () + " WHERE fecha=?");
		q.setParameters(Fecha);
		return (Long) q.executeUnique();
	}
	public List<Consumo> darConsumoPorFecha (PersistenceManager pm,Timestamp Fecha)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumo () + " WHERE fecha=?");
		q.setResultClass(Consumo.class);
		q.setParameters(Fecha);
		return (List<Consumo>) q.executeList();
	}
	public void actualizarFecha(PersistenceManager pm,Timestamp Fecha,Long idConsumo)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaConsumo () + " SET fecha=? WHERE idConsumo=?");
		q.setParameters(Fecha,idConsumo);
		q.executeUnique();
	}
	public Long eliminarConsumoPorCuenta (PersistenceManager pm,Long Cuenta)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsumo () + " WHERE cuenta=?");
		q.setParameters(Cuenta);
		return (Long) q.executeUnique();
	}
	public List<Consumo> darConsumoPorCuenta (PersistenceManager pm,Long Cuenta)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumo () + " WHERE cuenta=?");
		q.setResultClass(Consumo.class);
		q.setParameters(Cuenta);
		return (List<Consumo>) q.executeList();
	}
	public void actualizarCuenta(PersistenceManager pm,Long Cuenta,Long idConsumo)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaConsumo () + " SET cuenta=? WHERE idConsumo=?");
		q.setParameters(Cuenta,idConsumo);
		q.executeUnique();
	}
	public Long eliminarConsumoPorRegistroconsumo (PersistenceManager pm,Long Registroconsumo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsumo () + " WHERE registroConsumo=?");
		q.setParameters(Registroconsumo);
		return (Long) q.executeUnique();
	}
	public List<Consumo> darConsumoPorRegistroconsumo (PersistenceManager pm,Long Registroconsumo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumo () + " WHERE registroConsumo=?");
		q.setResultClass(Consumo.class);
		q.setParameters(Registroconsumo);
		return (List<Consumo>) q.executeList();
	}
	public void actualizarRegistroconsumo(PersistenceManager pm,Long Registroconsumo,Long idConsumo)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaConsumo () + " SET registroConsumo=? WHERE idConsumo=?");
		q.setParameters(Registroconsumo,idConsumo);
		q.executeUnique();
	}
	public Long eliminarConsumoPorEmpleado (PersistenceManager pm,Long Empleado)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsumo () + " WHERE empleado=?");
		q.setParameters(Empleado);
		return (Long) q.executeUnique();
	}
	public List<Consumo> darConsumoPorEmpleado (PersistenceManager pm,Long Empleado)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumo () + " WHERE empleado=?");
		q.setResultClass(Consumo.class);
		q.setParameters(Empleado);
		return (List<Consumo>) q.executeList();
	}
	public void actualizarEmpleado(PersistenceManager pm,Long Empleado,Long idConsumo)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaConsumo () + " SET empleado=? WHERE idConsumo=?");
		q.setParameters(Empleado,idConsumo);
		q.executeUnique();
	}
	public Long eliminarConsumoPorPagado (PersistenceManager pm,String Pagado)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsumo () + " WHERE pagado=?");
		q.setParameters(Pagado);
		return (Long) q.executeUnique();
	}
	public List<Consumo> darConsumoPorPagado (PersistenceManager pm,String Pagado)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumo () + " WHERE pagado=?");
		q.setResultClass(Consumo.class);
		q.setParameters(Pagado);
		return (List<Consumo>) q.executeList();
	}
	public void actualizarPagado(PersistenceManager pm,String Pagado,Long idConsumo)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaConsumo () + " SET pagado=? WHERE idConsumo=?");
		q.setParameters(Pagado,idConsumo);
		q.executeUnique();
	}
}
