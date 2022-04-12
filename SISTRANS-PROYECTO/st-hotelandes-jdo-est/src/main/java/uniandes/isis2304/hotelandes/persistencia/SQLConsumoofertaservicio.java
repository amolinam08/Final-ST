package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Consumoofertaservicio;
import java.sql.Timestamp;

class SQLConsumoofertaservicio
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLConsumoofertaservicio (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarConsumoofertaservicio(PersistenceManager pm,Long idConsumo,Long idOfertaServicio)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaConsumoofertaservicio () + "(idConsumo,idOfertaServicio) values (?,?)");
		q.setParameters(idConsumo,idOfertaServicio);
		return (Long) q.executeUnique();
	}
	public Long eliminarConsumoofertaservicioPorId (PersistenceManager pm,Long idConsumo,Long idOfertaServicio)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsumoofertaservicio () + " WHERE idConsumo=? and idOfertaServicio=?");
		q.setParameters(idConsumo,idOfertaServicio);
		return (Long) q.executeUnique();
	}
	public Consumoofertaservicio darConsumoofertaservicioPorId (PersistenceManager pm,Long idConsumo,Long idOfertaServicio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumoofertaservicio() + " WHERE idConsumo=? and idOfertaServicio=?");
		q.setResultClass(Consumoofertaservicio.class);
		q.setParameters(idConsumo,idOfertaServicio);
		return (Consumoofertaservicio) q.executeUnique();
	}
	public List<Consumoofertaservicio> darConsumoofertaservicios (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumoofertaservicio());
		q.setResultClass(Consumoofertaservicio.class);
		return (List<Consumoofertaservicio>) q.executeList();
	}
}