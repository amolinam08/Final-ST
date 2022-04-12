package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public interface VOHotel
{
	public Long getIdHotel();
	public String getNombre();
	public Long getCadenaHotelera();
	@Override
	public String toString();

}