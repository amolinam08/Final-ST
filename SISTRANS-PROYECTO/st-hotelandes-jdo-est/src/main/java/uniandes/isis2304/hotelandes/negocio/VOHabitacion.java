package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public interface VOHabitacion
{
	public Long getIdHabitacion();
	public Long getCapacidad();
	public Double getCostoAloj();
	public Long getHotel();
	public Long getTipoHabitacion();
	public Long getCuenta();
	public String getOcupado();
	@Override
	public String toString();

}