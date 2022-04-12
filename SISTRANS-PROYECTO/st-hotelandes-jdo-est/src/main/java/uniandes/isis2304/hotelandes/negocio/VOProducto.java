package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public interface VOProducto
{
	public Long getIdProducto();
	public String getNombre();
	public Double getCosto();
	public Long getConsumo();
	@Override
	public String toString();

}