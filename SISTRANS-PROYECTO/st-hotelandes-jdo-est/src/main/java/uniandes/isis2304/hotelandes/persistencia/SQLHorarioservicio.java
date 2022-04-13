package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Horarioservicio;
import java.sql.Timestamp;

class SQLHorarioservicio
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLHorarioservicio (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarHorarioservicio(PersistenceManager pm,Long idHorarioServicio,Timestamp horaInicio,Double duracion)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaHorarioservicio () + "(idHorarioServicio,horaInicio,duracion) values (?,?,?)");
		q.setParameters(idHorarioServicio,horaInicio,duracion);
		return (Long) q.executeUnique();
	}
	public Long eliminarHorarioservicioPorId (PersistenceManager pm,Long idHorarioServicio)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHorarioservicio () + " WHERE idHorarioServicio=?");
		q.setParameters(idHorarioServicio);
		return (Long) q.executeUnique();
	}
	public Horarioservicio darHorarioservicioPorId (PersistenceManager pm,Long idHorarioServicio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHorarioservicio() + " WHERE idHorarioServicio=?");
		q.setResultClass(Horarioservicio.class);
		q.setParameters(idHorarioServicio);
		return (Horarioservicio) q.executeUnique();
	}
	public List<Horarioservicio> darHorarioservicios (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHorarioservicio());
		q.setResultClass(Horarioservicio.class);
		return (List<Horarioservicio>) q.executeList();
	}
	public Long eliminarHorarioservicioPorHorainicio (PersistenceManager pm,Timestamp Horainicio)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHorarioservicio () + " WHERE horaInicio=?");
		q.setParameters(Horainicio);
		return (Long) q.executeUnique();
	}
	public List<Horarioservicio> darHorarioservicioPorHorainicio (PersistenceManager pm,Timestamp Horainicio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHorarioservicio () + " WHERE horaInicio=?");
		q.setResultClass(Horarioservicio.class);
		q.setParameters(Horainicio);
		return (List<Horarioservicio>) q.executeList();
	}
	public Long eliminarHorarioservicioPorDuracion (PersistenceManager pm,Double Duracion)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHorarioservicio () + " WHERE duracion=?");
		q.setParameters(Duracion);
		return (Long) q.executeUnique();
	}
	public List<Horarioservicio> darHorarioservicioPorDuracion (PersistenceManager pm,Double Duracion)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHorarioservicio () + " WHERE duracion=?");
		q.setResultClass(Horarioservicio.class);
		q.setParameters(Duracion);
		return (List<Horarioservicio>) q.executeList();
	}
}