package uniandes.isis2304.hotelandes.persistencia;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Tipousuario;
import java.sql.Timestamp;

class SQLTipousuario
{

    private final static String SQL = PersistenciaHotelAndes.SQL;
    private PersistenciaHotelAndes pp;
    public SQLTipousuario (PersistenciaHotelAndes pp){
		this.pp = pp;
	}
	public Long adicionarTipousuario(PersistenceManager pm,Long idTipoUsuario,String ROL)
	{
		Query q = pm.newQuery(SQL, "INSERT IntO " + pp.darTablaTipousuario () + "(idTipoUsuario,ROL) values (?,?)");
		q.setParameters(idTipoUsuario,ROL);
		return (Long) q.executeUnique();
	}
	public Long eliminarTipousuarioPorId (PersistenceManager pm,Long idTipoUsuario)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTipousuario () + " WHERE idTipoUsuario=?");
		q.setParameters(idTipoUsuario);
		return (Long) q.executeUnique();
	}
	public Tipousuario darTipousuarioPorId (PersistenceManager pm,Long idTipoUsuario)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTipousuario() + " WHERE idTipoUsuario=?");
		q.setResultClass(Tipousuario.class);
		q.setParameters(idTipoUsuario);
		return (Tipousuario) q.executeUnique();
	}
	public List<Tipousuario> darTipousuarios (PersistenceManager pm)	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTipousuario());
		q.setResultClass(Tipousuario.class);
		return (List<Tipousuario>) q.executeList();
	}
	public Long eliminarTipousuarioPorRol (PersistenceManager pm,String Rol)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTipousuario () + " WHERE ROL=?");
		q.setParameters(Rol);
		return (Long) q.executeUnique();
	}
	public List<Tipousuario> darTipousuarioPorRol (PersistenceManager pm,String Rol)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTipousuario () + " WHERE ROL=?");
		q.setResultClass(Tipousuario.class);
		q.setParameters(Rol);
		return (List<Tipousuario>) q.executeList();
	}
	public void actualizarRol(PersistenceManager pm,String Rol,Long idTipoUsuario)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaTipousuario () + " SET ROL=? WHERE idTipoUsuario=?");
		q.setParameters(Rol,idTipoUsuario);
		q.executeUnique();
	}
}
