package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Ofertaservicio;
import java.sql.Timestamp;

class SQLOfertaservicio
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLOfertaservicio (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarOfertaservicio(PersistenceManager pm,Long idOfertaServicio,Double costo,Double duracion)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaOfertaservicio () + "(idOfertaServicio,costo,duracion) values (?,?,?)");
		q.setParameters(idOfertaServicio,costo,duracion);
		return (Long) q.executeUnique();
	}
	public Long eliminarOfertaservicioPorId (PersistenceManager pm,Long idOfertaServicio)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOfertaservicio () + " WHERE idOfertaServicio=?");
		q.setParameters(idOfertaServicio);
		return (Long) q.executeUnique();
	}
	public Ofertaservicio darOfertaservicioPorId (PersistenceManager pm,Long idOfertaServicio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOfertaservicio() + " WHERE idOfertaServicio=?");
		q.setResultClass(Ofertaservicio.class);
		q.setParameters(idOfertaServicio);
		return (Ofertaservicio) q.executeUnique();
	}
	public List<Ofertaservicio> darOfertaservicios (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOfertaservicio());
		q.setResultClass(Ofertaservicio.class);
		return (List<Ofertaservicio>) q.executeList();
	}
}