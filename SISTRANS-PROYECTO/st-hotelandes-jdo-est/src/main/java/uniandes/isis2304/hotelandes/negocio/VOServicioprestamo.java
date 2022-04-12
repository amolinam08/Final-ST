package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public interface VOServicioprestamo
{
	public Long getIdPrestamo();
	public Timestamp getFechaPrestamo();
	public Timestamp getFechaReintegro();
	public Long getConsumo();
	@Override
	public String toString();

}