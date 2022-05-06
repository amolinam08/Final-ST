package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public interface VOConsumo
{
	public Long getIdConsumo();
	public Timestamp getFecha();
	public Long getCuenta();
	public Long getRegistroConsumo();
	public Long getEmpleado();
	@Override
	public String toString();

}