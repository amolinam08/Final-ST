package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public interface VOPlancobro
{
	public Long getIdPlanCobro();
	public String getDescripcion();
	public String getNombre();
	@Override
	public String toString();

}