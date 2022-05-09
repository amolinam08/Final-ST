package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public interface VOOferta
{
	public Long getIdOferta();
	public Double getDescuento();
	public String getDescripcion();
	public Long getIdHabitacion();
	@Override
	public String toString();

}