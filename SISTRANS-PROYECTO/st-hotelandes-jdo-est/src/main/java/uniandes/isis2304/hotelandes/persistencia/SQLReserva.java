package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Reserva;
import java.sql.Timestamp;

class SQLReserva
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLReserva (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarReserva(PersistenceManager pm,Long idReserva,Timestamp diaHora,Double duracion,String aceptada,Long numPersonas,String planPago,Timestamp fechaSalida,Long cliente,Long habitacion,Long servicio)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaReserva () + "(idReserva,diaHora,duracion,aceptada,numPersonas,planPago,fechaSalida,cliente,habitacion,servicio) values (?,?,?,?,?,?,?,?,?,?)");
		q.setParameters(idReserva,diaHora,duracion,aceptada,numPersonas,planPago,fechaSalida,cliente,habitacion,servicio);
		return (Long) q.executeUnique();
	}
	public Long eliminarReservaPorId (PersistenceManager pm,Long idReserva)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva () + " WHERE idReserva=?");
		q.setParameters(idReserva);
		return (Long) q.executeUnique();
	}
	public Reserva darReservaPorId (PersistenceManager pm,Long idReserva)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva() + " WHERE idReserva=?");
		q.setResultClass(Reserva.class);
		q.setParameters(idReserva);
		return (Reserva) q.executeUnique();
	}
	public List<Reserva> darReservas (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva());
		q.setResultClass(Reserva.class);
		return (List<Reserva>) q.executeList();
	}
	public Long eliminarReservaPorDiahora (PersistenceManager pm,Timestamp Diahora)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva () + " WHERE diaHora=?");
		q.setParameters(Diahora);
		return (Long) q.executeUnique();
	}
	public List<Reserva> darReservaPorDiahora (PersistenceManager pm,Timestamp Diahora)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva () + " WHERE diaHora=?");
		q.setResultClass(Reserva.class);
		q.setParameters(Diahora);
		return (List<Reserva>) q.executeList();
	}
	public Long eliminarReservaPorDuracion (PersistenceManager pm,Double Duracion)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva () + " WHERE duracion=?");
		q.setParameters(Duracion);
		return (Long) q.executeUnique();
	}
	public List<Reserva> darReservaPorDuracion (PersistenceManager pm,Double Duracion)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva () + " WHERE duracion=?");
		q.setResultClass(Reserva.class);
		q.setParameters(Duracion);
		return (List<Reserva>) q.executeList();
	}
	public Long eliminarReservaPorAceptada (PersistenceManager pm,String Aceptada)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva () + " WHERE aceptada=?");
		q.setParameters(Aceptada);
		return (Long) q.executeUnique();
	}
	public List<Reserva> darReservaPorAceptada (PersistenceManager pm,String Aceptada)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva () + " WHERE aceptada=?");
		q.setResultClass(Reserva.class);
		q.setParameters(Aceptada);
		return (List<Reserva>) q.executeList();
	}
	public Long eliminarReservaPorNumpersonas (PersistenceManager pm,Long Numpersonas)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva () + " WHERE numPersonas=?");
		q.setParameters(Numpersonas);
		return (Long) q.executeUnique();
	}
	public List<Reserva> darReservaPorNumpersonas (PersistenceManager pm,Long Numpersonas)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva () + " WHERE numPersonas=?");
		q.setResultClass(Reserva.class);
		q.setParameters(Numpersonas);
		return (List<Reserva>) q.executeList();
	}
	public Long eliminarReservaPorPlanpago (PersistenceManager pm,String Planpago)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva () + " WHERE planPago=?");
		q.setParameters(Planpago);
		return (Long) q.executeUnique();
	}
	public List<Reserva> darReservaPorPlanpago (PersistenceManager pm,String Planpago)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva () + " WHERE planPago=?");
		q.setResultClass(Reserva.class);
		q.setParameters(Planpago);
		return (List<Reserva>) q.executeList();
	}
	public Long eliminarReservaPorFechasalida (PersistenceManager pm,Timestamp Fechasalida)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva () + " WHERE fechaSalida=?");
		q.setParameters(Fechasalida);
		return (Long) q.executeUnique();
	}
	public List<Reserva> darReservaPorFechasalida (PersistenceManager pm,Timestamp Fechasalida)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva () + " WHERE fechaSalida=?");
		q.setResultClass(Reserva.class);
		q.setParameters(Fechasalida);
		return (List<Reserva>) q.executeList();
	}
	public Long eliminarReservaPorCliente (PersistenceManager pm,Long Cliente)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva () + " WHERE cliente=?");
		q.setParameters(Cliente);
		return (Long) q.executeUnique();
	}
	public List<Reserva> darReservaPorCliente (PersistenceManager pm,Long Cliente)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva () + " WHERE cliente=?");
		q.setResultClass(Reserva.class);
		q.setParameters(Cliente);
		return (List<Reserva>) q.executeList();
	}
	public Long eliminarReservaPorHabitacion (PersistenceManager pm,Long Habitacion)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva () + " WHERE habitacion=?");
		q.setParameters(Habitacion);
		return (Long) q.executeUnique();
	}
	public List<Reserva> darReservaPorHabitacion (PersistenceManager pm,Long Habitacion)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva () + " WHERE habitacion=?");
		q.setResultClass(Reserva.class);
		q.setParameters(Habitacion);
		return (List<Reserva>) q.executeList();
	}
	public Long eliminarReservaPorServicio (PersistenceManager pm,Long Servicio)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva () + " WHERE servicio=?");
		q.setParameters(Servicio);
		return (Long) q.executeUnique();
	}
	public List<Reserva> darReservaPorServicio (PersistenceManager pm,Long Servicio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva () + " WHERE servicio=?");
		q.setResultClass(Reserva.class);
		q.setParameters(Servicio);
		return (List<Reserva>) q.executeList();
	}
}