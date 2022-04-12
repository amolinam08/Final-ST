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
	public Long adicionarReserva(PersistenceManager pm,Long idReserva,Timestamp diaHora,Double duracion,String aceptada,Long numPersonas,String planPago,Timestamp fechaSalida,Long cliente,Long habitacion,Long servicio,Double profunidad)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaReserva () + "(idReserva,diaHora,duracion,aceptada,numPersonas,planPago,fechaSalida,cliente,habitacion,servicio,profunidad) values (?,?,?,?,?,?,?,?,?,?,?)");
		q.setParameters(idReserva,diaHora,duracion,aceptada,numPersonas,planPago,fechaSalida,cliente,habitacion,servicio,profunidad);
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
}