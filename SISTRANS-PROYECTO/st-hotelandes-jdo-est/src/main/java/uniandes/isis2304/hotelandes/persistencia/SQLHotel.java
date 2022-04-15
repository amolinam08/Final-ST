package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Hotel;
import java.sql.Timestamp;

class SQLHotel
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLHotel (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarHotel(PersistenceManager pm,Long idHotel,String nombre,Long CadenaHotelera)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaHotel () + "(idHotel,nombre,CadenaHotelera) values (?,?,?)");
		q.setParameters(idHotel,nombre,CadenaHotelera);
		return (Long) q.executeUnique();
	}
	public Long eliminarHotelPorId (PersistenceManager pm,Long idHotel)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHotel () + " WHERE idHotel=?");
		q.setParameters(idHotel);
		return (Long) q.executeUnique();
	}
	public Hotel darHotelPorId (PersistenceManager pm,Long idHotel)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotel() + " WHERE idHotel=?");
		q.setResultClass(Hotel.class);
		q.setParameters(idHotel);
		return (Hotel) q.executeUnique();
	}
	public List<Hotel> darHotels (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotel());
		q.setResultClass(Hotel.class);
		return (List<Hotel>) q.executeList();
	}
	public Long eliminarHotelPorNombre (PersistenceManager pm,String Nombre)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHotel () + " WHERE nombre=?");
		q.setParameters(Nombre);
		return (Long) q.executeUnique();
	}
	public List<Hotel> darHotelPorNombre (PersistenceManager pm,String Nombre)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotel () + " WHERE nombre=?");
		q.setResultClass(Hotel.class);
		q.setParameters(Nombre);
		return (List<Hotel>) q.executeList();
	}
	public void actualizarNombre(PersistenceManager pm,String Nombre,Long idHotel)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaHotel () + " SET nombre=? WHERE idHotel=?");
		q.setParameters(Nombre,idHotel);
		q.executeUnique();
	}
	public Long eliminarHotelPorCadenahotelera (PersistenceManager pm,Long Cadenahotelera)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHotel () + " WHERE CadenaHotelera=?");
		q.setParameters(Cadenahotelera);
		return (Long) q.executeUnique();
	}
	public List<Hotel> darHotelPorCadenahotelera (PersistenceManager pm,Long Cadenahotelera)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotel () + " WHERE CadenaHotelera=?");
		q.setResultClass(Hotel.class);
		q.setParameters(Cadenahotelera);
		return (List<Hotel>) q.executeList();
	}
	public void actualizarCadenahotelera(PersistenceManager pm,Long Cadenahotelera,Long idHotel)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaHotel () + " SET CadenaHotelera=? WHERE idHotel=?");
		q.setParameters(Cadenahotelera,idHotel);
		q.executeUnique();
	}
}
