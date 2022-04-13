package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public interface VOPlanconsumo
{
	public Long getIdPlanConsumo();
	public String getNombre();
	public Double getDescuento();
	public String getDescripcion();
	public Timestamp getPeriodoVigencia1();
	public Timestamp getPeriodoVigencia2();
	@Override
	public String toString();

}