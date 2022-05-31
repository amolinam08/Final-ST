package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Servicio;
import java.sql.Timestamp;

class SQLServicio
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLServicio (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarServicio(PersistenceManager pm,Long idServicio,Long capacidad,String nombre,Long capacidad_actual,Long cartaProductos,Long registroConsumo,Long hotel,Long tipoCobro,Long estilo,Long HorarioServicio,Long ofertaServicio,Double profundidad,Long oferta,Long convencion,String estado)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaServicio () + "(idServicio,capacidad,nombre,capacidad_actual,cartaProductos,registroConsumo,hotel,tipoCobro,estilo,HorarioServicio,ofertaServicio,profundidad,oferta,convencion,estado) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		q.setParameters(idServicio,capacidad,nombre,capacidad_actual,cartaProductos,registroConsumo,hotel,tipoCobro,estilo,HorarioServicio,ofertaServicio,profundidad,oferta,convencion,estado);
		return (Long) q.executeUnique();
	}
	public Long eliminarServicioPorId (PersistenceManager pm,Long idServicio)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE idServicio=?");
		q.setParameters(idServicio);
		return (Long) q.executeUnique();
	}
	public Servicio darServicioPorId (PersistenceManager pm,Long idServicio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio() + " WHERE idServicio=?");
		q.setResultClass(Servicio.class);
		q.setParameters(idServicio);
		return (Servicio) q.executeUnique();
	}
	public List<Servicio> darServicios (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio());
		q.setResultClass(Servicio.class);
		return (List<Servicio>) q.executeList();
	}
	public Long eliminarServicioPorCapacidad (PersistenceManager pm,Long Capacidad)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE capacidad=?");
		q.setParameters(Capacidad);
		return (Long) q.executeUnique();
	}
	public List<Servicio> darServicioPorCapacidad (PersistenceManager pm,Long Capacidad)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE capacidad=?");
		q.setResultClass(Servicio.class);
		q.setParameters(Capacidad);
		return (List<Servicio>) q.executeList();
	}
	public void actualizarCapacidad(PersistenceManager pm,Long Capacidad,Long idServicio)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicio () + " SET capacidad=? WHERE idServicio=?");
		q.setParameters(Capacidad,idServicio);
		q.executeUnique();
	}
	public Long eliminarServicioPorNombre (PersistenceManager pm,String Nombre)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE nombre=?");
		q.setParameters(Nombre);
		return (Long) q.executeUnique();
	}
	public List<Servicio> darServicioPorNombre (PersistenceManager pm,String Nombre)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE nombre=?");
		q.setResultClass(Servicio.class);
		q.setParameters(Nombre);
		return (List<Servicio>) q.executeList();
	}
	public void actualizarNombre(PersistenceManager pm,String Nombre,Long idServicio)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicio () + " SET nombre=? WHERE idServicio=?");
		q.setParameters(Nombre,idServicio);
		q.executeUnique();
	}
	public Long eliminarServicioPorCapacidad_actual (PersistenceManager pm,Long Capacidad_actual)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE capacidad_actual=?");
		q.setParameters(Capacidad_actual);
		return (Long) q.executeUnique();
	}
	public List<Servicio> darServicioPorCapacidad_actual (PersistenceManager pm,Long Capacidad_actual)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE capacidad_actual=?");
		q.setResultClass(Servicio.class);
		q.setParameters(Capacidad_actual);
		return (List<Servicio>) q.executeList();
	}
	public void actualizarCapacidad_actual(PersistenceManager pm,Long Capacidad_actual,Long idServicio)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicio () + " SET capacidad_actual=? WHERE idServicio=?");
		q.setParameters(Capacidad_actual,idServicio);
		q.executeUnique();
	}
	public Long eliminarServicioPorCartaproductos (PersistenceManager pm,Long Cartaproductos)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE cartaProductos=?");
		q.setParameters(Cartaproductos);
		return (Long) q.executeUnique();
	}
	public List<Servicio> darServicioPorCartaproductos (PersistenceManager pm,Long Cartaproductos)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE cartaProductos=?");
		q.setResultClass(Servicio.class);
		q.setParameters(Cartaproductos);
		return (List<Servicio>) q.executeList();
	}
	public void actualizarCartaproductos(PersistenceManager pm,Long Cartaproductos,Long idServicio)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicio () + " SET cartaProductos=? WHERE idServicio=?");
		q.setParameters(Cartaproductos,idServicio);
		q.executeUnique();
	}
	public Long eliminarServicioPorRegistroconsumo (PersistenceManager pm,Long Registroconsumo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE registroConsumo=?");
		q.setParameters(Registroconsumo);
		return (Long) q.executeUnique();
	}
	public List<Servicio> darServicioPorRegistroconsumo (PersistenceManager pm,Long Registroconsumo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE registroConsumo=?");
		q.setResultClass(Servicio.class);
		q.setParameters(Registroconsumo);
		return (List<Servicio>) q.executeList();
	}
	public void actualizarRegistroconsumo(PersistenceManager pm,Long Registroconsumo,Long idServicio)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicio () + " SET registroConsumo=? WHERE idServicio=?");
		q.setParameters(Registroconsumo,idServicio);
		q.executeUnique();
	}
	public Long eliminarServicioPorHotel (PersistenceManager pm,Long Hotel)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE hotel=?");
		q.setParameters(Hotel);
		return (Long) q.executeUnique();
	}
	public List<Servicio> darServicioPorHotel (PersistenceManager pm,Long Hotel)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE hotel=?");
		q.setResultClass(Servicio.class);
		q.setParameters(Hotel);
		return (List<Servicio>) q.executeList();
	}
	public void actualizarHotel(PersistenceManager pm,Long Hotel,Long idServicio)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicio () + " SET hotel=? WHERE idServicio=?");
		q.setParameters(Hotel,idServicio);
		q.executeUnique();
	}
	public Long eliminarServicioPorTipocobro (PersistenceManager pm,Long Tipocobro)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE tipoCobro=?");
		q.setParameters(Tipocobro);
		return (Long) q.executeUnique();
	}
	public List<Servicio> darServicioPorTipocobro (PersistenceManager pm,Long Tipocobro)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE tipoCobro=?");
		q.setResultClass(Servicio.class);
		q.setParameters(Tipocobro);
		return (List<Servicio>) q.executeList();
	}
	public void actualizarTipocobro(PersistenceManager pm,Long Tipocobro,Long idServicio)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicio () + " SET tipoCobro=? WHERE idServicio=?");
		q.setParameters(Tipocobro,idServicio);
		q.executeUnique();
	}
	public Long eliminarServicioPorEstilo (PersistenceManager pm,Long Estilo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE estilo=?");
		q.setParameters(Estilo);
		return (Long) q.executeUnique();
	}
	public List<Servicio> darServicioPorEstilo (PersistenceManager pm,Long Estilo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE estilo=?");
		q.setResultClass(Servicio.class);
		q.setParameters(Estilo);
		return (List<Servicio>) q.executeList();
	}
	public void actualizarEstilo(PersistenceManager pm,Long Estilo,Long idServicio)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicio () + " SET estilo=? WHERE idServicio=?");
		q.setParameters(Estilo,idServicio);
		q.executeUnique();
	}
	public Long eliminarServicioPorHorarioservicio (PersistenceManager pm,Long Horarioservicio)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE HorarioServicio=?");
		q.setParameters(Horarioservicio);
		return (Long) q.executeUnique();
	}
	public List<Servicio> darServicioPorHorarioservicio (PersistenceManager pm,Long Horarioservicio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE HorarioServicio=?");
		q.setResultClass(Servicio.class);
		q.setParameters(Horarioservicio);
		return (List<Servicio>) q.executeList();
	}
	public void actualizarHorarioservicio(PersistenceManager pm,Long Horarioservicio,Long idServicio)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicio () + " SET HorarioServicio=? WHERE idServicio=?");
		q.setParameters(Horarioservicio,idServicio);
		q.executeUnique();
	}
	public Long eliminarServicioPorOfertaservicio (PersistenceManager pm,Long Ofertaservicio)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE ofertaServicio=?");
		q.setParameters(Ofertaservicio);
		return (Long) q.executeUnique();
	}
	public List<Servicio> darServicioPorOfertaservicio (PersistenceManager pm,Long Ofertaservicio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE ofertaServicio=?");
		q.setResultClass(Servicio.class);
		q.setParameters(Ofertaservicio);
		return (List<Servicio>) q.executeList();
	}
	public void actualizarOfertaservicio(PersistenceManager pm,Long Ofertaservicio,Long idServicio)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicio () + " SET ofertaServicio=? WHERE idServicio=?");
		q.setParameters(Ofertaservicio,idServicio);
		q.executeUnique();
	}
	public Long eliminarServicioPorProfundidad (PersistenceManager pm,Double Profundidad)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE profundidad=?");
		q.setParameters(Profundidad);
		return (Long) q.executeUnique();
	}
	public List<Servicio> darServicioPorProfundidad (PersistenceManager pm,Double Profundidad)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE profundidad=?");
		q.setResultClass(Servicio.class);
		q.setParameters(Profundidad);
		return (List<Servicio>) q.executeList();
	}
	public void actualizarProfundidad(PersistenceManager pm,Double Profundidad,Long idServicio)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicio () + " SET profundidad=? WHERE idServicio=?");
		q.setParameters(Profundidad,idServicio);
		q.executeUnique();
	}
	public Long eliminarServicioPorOferta (PersistenceManager pm,Long Oferta)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE oferta=?");
		q.setParameters(Oferta);
		return (Long) q.executeUnique();
	}
	public List<Servicio> darServicioPorOferta (PersistenceManager pm,Long Oferta)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE oferta=?");
		q.setResultClass(Servicio.class);
		q.setParameters(Oferta);
		return (List<Servicio>) q.executeList();
	}
	public void actualizarOferta(PersistenceManager pm,Long Oferta,Long idServicio)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicio () + " SET oferta=? WHERE idServicio=?");
		q.setParameters(Oferta,idServicio);
		q.executeUnique();
	}
	public Long eliminarServicioPorConvencion (PersistenceManager pm,Long Convencion)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE convencion=?");
		q.setParameters(Convencion);
		return (Long) q.executeUnique();
	}
	public List<Servicio> darServicioPorConvencion (PersistenceManager pm,Long Convencion)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE convencion=?");
		q.setResultClass(Servicio.class);
		q.setParameters(Convencion);
		return (List<Servicio>) q.executeList();
	}
	public void actualizarConvencion(PersistenceManager pm,Long Convencion,Long idServicio)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicio () + " SET convencion=? WHERE idServicio=?");
		q.setParameters(Convencion,idServicio);
		q.executeUnique();
	}
	public Long eliminarServicioPorEstado (PersistenceManager pm,String Estado)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE estado=?");
		q.setParameters(Estado);
		return (Long) q.executeUnique();
	}
	public List<Servicio> darServicioPorEstado (PersistenceManager pm,String Estado)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE estado=?");
		q.setResultClass(Servicio.class);
		q.setParameters(Estado);
		return (List<Servicio>) q.executeList();
	}
	public void actualizarEstado(PersistenceManager pm,String Estado,Long idServicio)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicio () + " SET estado=? WHERE idServicio=?");
		q.setParameters(Estado,idServicio);
		q.executeUnique();
	}
	public List<Servicio> ServiciosPocaDemanda(PersistenceManager pm)
	{
		
		Query q = pm.newQuery(SQL, "WITH "+
		"anio"
	 +" AS"
	   +" (SELECT EXTRACT(YEAR"
		 +" FROM (SELECT fecha"
			 +" FROM CONSUMO"
			 +" ORDER BY consumo.fecha desc"
			 +" FETCH FIRST 1 ROWS ONLY)) as anios FROM DUAL)"
	 +" SELECT *"
	 +" FROM SERVICIO"
	 +" WHERE SERVICIO.idservicio"
	 +" IN (SELECT Unique(servicio.idServicio)" 
			 +" from RESERVA,SERVICIO"
			 +" where EXTRACT(YEAR FROM RESERVA.diaHora)=(select * from anio) and RESERVA.SERVICIO=SERVICIO.idServicio"
			 +" group by trunc(RESERVA.diaHora, 'IW'),servicio.idServicio"
			 +" having COUNT(servicio.idServicio)<3)");
		q.setResultClass(Servicio.class);
		return (List<Servicio>) q.executeList();
	}
	
}
