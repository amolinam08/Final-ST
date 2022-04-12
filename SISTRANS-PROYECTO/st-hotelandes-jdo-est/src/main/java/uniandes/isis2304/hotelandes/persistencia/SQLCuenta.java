package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Cuenta;
import java.sql.Timestamp;

class SQLCuenta
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLCuenta (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarCuenta(PersistenceManager pm,Long idCuenta,Timestamp fechaApertura,Long habitacion)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaCuenta () + "(idCuenta,fechaApertura,habitacion) values (?,?,?)");
		q.setParameters(idCuenta,fechaApertura,habitacion);
		return (Long) q.executeUnique();
	}
	public Long eliminarCuentaPorId (PersistenceManager pm,Long idCuenta)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCuenta () + " WHERE idCuenta=?");
		q.setParameters(idCuenta);
		return (Long) q.executeUnique();
	}
	public Cuenta darCuentaPorId (PersistenceManager pm,Long idCuenta)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCuenta() + " WHERE idCuenta=?");
		q.setResultClass(Cuenta.class);
		q.setParameters(idCuenta);
		return (Cuenta) q.executeUnique();
	}
	public List<Cuenta> darCuentas (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCuenta());
		q.setResultClass(Cuenta.class);
		return (List<Cuenta>) q.executeList();
	}
}