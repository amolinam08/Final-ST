package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Tipocobro;
import java.sql.Timestamp;

class SQLTipocobro
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLTipocobro (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarTipocobro(PersistenceManager pm,Long idTipoCobro,String nombre)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaTipocobro () + "(idTipoCobro,nombre) values (?,?)");
		q.setParameters(idTipoCobro,nombre);
		return (Long) q.executeUnique();
	}
	public Long eliminarTipocobroPorId (PersistenceManager pm,Long idTipoCobro)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTipocobro () + " WHERE idTipoCobro=?");
		q.setParameters(idTipoCobro);
		return (Long) q.executeUnique();
	}
	public Tipocobro darTipocobroPorId (PersistenceManager pm,Long idTipoCobro)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTipocobro() + " WHERE idTipoCobro=?");
		q.setResultClass(Tipocobro.class);
		q.setParameters(idTipoCobro);
		return (Tipocobro) q.executeUnique();
	}
	public List<Tipocobro> darTipocobros (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTipocobro());
		q.setResultClass(Tipocobro.class);
		return (List<Tipocobro>) q.executeList();
	}
	public Long eliminarTipocobroPorNombre (PersistenceManager pm,String Nombre)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTipocobro () + " WHERE nombre=?");
		q.setParameters(Nombre);
		return (Long) q.executeUnique();
	}
	public List<Tipocobro> darTipocobroPorNombre (PersistenceManager pm,String Nombre)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTipocobro () + " WHERE nombre=?");
		q.setResultClass(Tipocobro.class);
		q.setParameters(Nombre);
		return (List<Tipocobro>) q.executeList();
	}
}