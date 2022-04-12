package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public interface VOPrenda
{
	public Long getIdPrenda();
	public String getTipoPrenda();
	public Double getCostoLavado();
	public Long getCliente();
	@Override
	public String toString();

}