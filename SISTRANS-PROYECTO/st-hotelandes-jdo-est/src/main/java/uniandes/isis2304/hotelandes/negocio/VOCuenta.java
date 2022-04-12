package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public interface VOCuenta
{
	public Long getIdCuenta();
	public Timestamp getFechaApertura();
	public Long getHabitacion();
	@Override
	public String toString();

}