package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public interface VOMueble
{
	public Long getIdMueble();
	public String getTipoMueble();
	public Double getCostoMueble();
	public Long getHabitacion();
	@Override
	public String toString();

}