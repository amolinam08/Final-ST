package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public interface VOUtensilio
{
	public Long getIdUtensilio();
	public String getEstado();
	public String getEntregado();
	@Override
	public String toString();

}