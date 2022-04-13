package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public interface VOServicio
{
	public Long getIdServicio();
	public Long getCapacidad();
	public String getNombre();
	public Long getCapacidad_actual();
	public Long getCartaProductos();
	public Long getRegistroConsumo();
	public Long getHotel();
	public Long getTipoCobro();
	public Long getEstilo();
	public Long getHorarioServicio();
	@Override
	public String toString();

}