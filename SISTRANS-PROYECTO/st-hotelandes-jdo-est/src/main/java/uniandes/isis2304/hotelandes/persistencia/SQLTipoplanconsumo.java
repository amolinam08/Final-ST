package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Tipoplanconsumo;
import java.sql.Timestamp;

class SQLTipoplanconsumo
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLTipoplanconsumo (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarTipoplanconsumo(PersistenceManager pm,Long idTipoPlanConsumo,String nombre)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaTipoplanconsumo () + "(idTipoPlanConsumo,nombre) values (?,?)");
		q.setParameters(idTipoPlanConsumo,nombre);
		return (Long) q.executeUnique();
	}
	public Long eliminarTipoplanconsumoPorId (PersistenceManager pm,Long idTipoPlanConsumo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTipoplanconsumo () + " WHERE idTipoPlanConsumo=?");
		q.setParameters(idTipoPlanConsumo);
		return (Long) q.executeUnique();
	}
	public Tipoplanconsumo darTipoplanconsumoPorId (PersistenceManager pm,Long idTipoPlanConsumo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTipoplanconsumo() + " WHERE idTipoPlanConsumo=?");
		q.setResultClass(Tipoplanconsumo.class);
		q.setParameters(idTipoPlanConsumo);
		return (Tipoplanconsumo) q.executeUnique();
	}
	public List<Tipoplanconsumo> darTipoplanconsumos (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTipoplanconsumo());
		q.setResultClass(Tipoplanconsumo.class);
		return (List<Tipoplanconsumo>) q.executeList();
	}
}