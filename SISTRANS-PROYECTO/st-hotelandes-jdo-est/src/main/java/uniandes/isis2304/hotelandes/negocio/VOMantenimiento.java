package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public interface VOMantenimiento
{
	public Long getIdMantenimiento();
	public Timestamp getFechaInicio();
	public Timestamp getFechaFin();
	public String getDescripcion();
	public Long getServicio();
	public Long getHabitacion();
	@Override
	public String toString();

}