package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public interface VOTipohabitacion
{
	public Long getIdTipoHabitacion();
	public String getNombre();
	public String getDescripcion();
	@Override
	public String toString();

}