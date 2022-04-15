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
	public Long adicionarReserva(PersistenceManager pm,Long idReserva,Timestamp diaHora,Double duracion,String aceptada,Long numPersonas,String planPago,Timestamp fechaSalida,Long cliente,Long habitacion,Long servicio,Long ofertaServicio)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaReserva () + "(idReserva,diaHora,duracion,aceptada,numPersonas,planPago,fechaSalida,cliente,habitacion,servicio,ofertaServicio) values (?,?,?,?,?,?,?,?,?,?,?)");
		q.setParameters(idReserva,diaHora,duracion,aceptada,numPersonas,planPago,fechaSalida,cliente,habitacion,servicio,ofertaServicio);
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
	public void actualizarDiahora(PersistenceManager pm,Timestamp Diahora,Long idReserva)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaReserva () + " SET diaHora=? WHERE idReserva=?");
		q.setParameters(Diahora,idReserva);
		q.executeUnique();
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
	public void actualizarDuracion(PersistenceManager pm,Double Duracion,Long idReserva)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaReserva () + " SET duracion=? WHERE idReserva=?");
		q.setParameters(Duracion,idReserva);
		q.executeUnique();
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
	public void actualizarAceptada(PersistenceManager pm,String Aceptada,Long idReserva)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaReserva () + " SET aceptada=? WHERE idReserva=?");
		q.setParameters(Aceptada,idReserva);
		q.executeUnique();
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
	public void actualizarNumpersonas(PersistenceManager pm,Long Numpersonas,Long idReserva)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaReserva () + " SET numPersonas=? WHERE idReserva=?");
		q.setParameters(Numpersonas,idReserva);
		q.executeUnique();
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
	public void actualizarPlanpago(PersistenceManager pm,String Planpago,Long idReserva)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaReserva () + " SET planPago=? WHERE idReserva=?");
		q.setParameters(Planpago,idReserva);
		q.executeUnique();
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
	public void actualizarFechasalida(PersistenceManager pm,Timestamp Fechasalida,Long idReserva)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaReserva () + " SET fechaSalida=? WHERE idReserva=?");
		q.setParameters(Fechasalida,idReserva);
		q.executeUnique();
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
	public void actualizarCliente(PersistenceManager pm,Long Cliente,Long idReserva)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaReserva () + " SET cliente=? WHERE idReserva=?");
		q.setParameters(Cliente,idReserva);
		q.executeUnique();
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
	public void actualizarHabitacion(PersistenceManager pm,Long Habitacion,Long idReserva)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaReserva () + " SET habitacion=? WHERE idReserva=?");
		q.setParameters(Habitacion,idReserva);
		q.executeUnique();
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
	public void actualizarServicio(PersistenceManager pm,Long Servicio,Long idReserva)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaReserva () + " SET servicio=? WHERE idReserva=?");
		q.setParameters(Servicio,idReserva);
		q.executeUnique();
	}
	public Long eliminarReservaPorOfertaservicio (PersistenceManager pm,Long Ofertaservicio)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva () + " WHERE ofertaServicio=?");
		q.setParameters(Ofertaservicio);
		return (Long) q.executeUnique();
	}
	public List<Reserva> darReservaPorOfertaservicio (PersistenceManager pm,Long Ofertaservicio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva () + " WHERE ofertaServicio=?");
		q.setResultClass(Reserva.class);
		q.setParameters(Ofertaservicio);
		return (List<Reserva>) q.executeList();
	}
	public void actualizarOfertaservicio(PersistenceManager pm,Long Ofertaservicio,Long idReserva)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaReserva () + " SET ofertaServicio=? WHERE idReserva=?");
		q.setParameters(Ofertaservicio,idReserva);
		q.executeUnique();
	}
}
