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
	public Long adicionarConsumo(PersistenceManager pm,Long idConsumo,String fecha,Long cuenta,Long registroConsumo,Long empleado)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaConsumo () + "(idConsumo,fecha,cuenta,registroConsumo,empleado) values (?,?,?,?,?)");
		q.setParameters(idConsumo,fecha,cuenta,registroConsumo,empleado);
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
}