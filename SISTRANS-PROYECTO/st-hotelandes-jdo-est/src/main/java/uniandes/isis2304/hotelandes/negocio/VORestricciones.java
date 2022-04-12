package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public interface VORestricciones
{
	public Long getIdRestriccion();
	public Long getCantidad();
	public Long getProducto();
	@Override
	public String toString();

}