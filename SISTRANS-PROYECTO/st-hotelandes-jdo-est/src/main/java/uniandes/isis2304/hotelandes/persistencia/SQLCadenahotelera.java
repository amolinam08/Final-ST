package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Cadenahotelera;
import java.sql.Timestamp;

class SQLCadenahotelera
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLCadenahotelera (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarCadenahotelera(PersistenceManager pm,Long idCadenaHotelera,String nombre)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaCadenahotelera () + "(idCadenaHotelera,nombre) values (?,?)");
		q.setParameters(idCadenaHotelera,nombre);
		return (Long) q.executeUnique();
	}
	public Long eliminarCadenahoteleraPorId (PersistenceManager pm,Long idCadenaHotelera)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCadenahotelera () + " WHERE idCadenaHotelera=?");
		q.setParameters(idCadenaHotelera);
		return (Long) q.executeUnique();
	}
	public Cadenahotelera darCadenahoteleraPorId (PersistenceManager pm,Long idCadenaHotelera)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCadenahotelera() + " WHERE idCadenaHotelera=?");
		q.setResultClass(Cadenahotelera.class);
		q.setParameters(idCadenaHotelera);
		return (Cadenahotelera) q.executeUnique();
	}
	public List<Cadenahotelera> darCadenahoteleras (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCadenahotelera());
		q.setResultClass(Cadenahotelera.class);
		return (List<Cadenahotelera>) q.executeList();
	}
	public Long eliminarCadenahoteleraPorNombre (PersistenceManager pm,String Nombre)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCadenahotelera () + " WHERE nombre=?");
		q.setParameters(Nombre);
		return (Long) q.executeUnique();
	}
	public List<Cadenahotelera> darCadenahoteleraPorNombre (PersistenceManager pm,String Nombre)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCadenahotelera () + " WHERE nombre=?");
		q.setResultClass(Cadenahotelera.class);
		q.setParameters(Nombre);
		return (List<Cadenahotelera>) q.executeList();
	}
}