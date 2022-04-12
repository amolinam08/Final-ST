package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public interface VOConsumoconmueble
{
	public Long getIdMueble();
	public Double getCosto();
	public String getUsado();
	@Override
	public String toString();

}