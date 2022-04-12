package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Usuarioplanconsumo;
import java.sql.Timestamp;

class SQLUsuarioplanconsumo
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLUsuarioplanconsumo (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarUsuarioplanconsumo(PersistenceManager pm,Long idUsuario,Long idPlanConsumo)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaUsuarioplanconsumo () + "(idUsuario,idPlanConsumo) values (?,?)");
		q.setParameters(idUsuario,idPlanConsumo);
		return (Long) q.executeUnique();
	}
	public Long eliminarUsuarioplanconsumoPorId (PersistenceManager pm,Long idUsuario,Long idPlanConsumo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUsuarioplanconsumo () + " WHERE idUsuario=? and idPlanConsumo=?");
		q.setParameters(idUsuario,idPlanConsumo);
		return (Long) q.executeUnique();
	}
	public Usuarioplanconsumo darUsuarioplanconsumoPorId (PersistenceManager pm,Long idUsuario,Long idPlanConsumo)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuarioplanconsumo() + " WHERE idUsuario=? and idPlanConsumo=?");
		q.setResultClass(Usuarioplanconsumo.class);
		q.setParameters(idUsuario,idPlanConsumo);
		return (Usuarioplanconsumo) q.executeUnique();
	}
	public List<Usuarioplanconsumo> darUsuarioplanconsumos (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuarioplanconsumo());
		q.setResultClass(Usuarioplanconsumo.class);
		return (List<Usuarioplanconsumo>) q.executeList();
	}
}