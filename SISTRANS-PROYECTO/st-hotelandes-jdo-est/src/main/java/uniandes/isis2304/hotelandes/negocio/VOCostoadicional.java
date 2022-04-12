package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public interface VOCostoadicional
{
	public Long getIdCostoAdicional();
	public String getNombre();
	public Double getCosto();
	public Long getServicio();
	@Override
	public String toString();

}