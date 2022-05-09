package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public interface VOConvencion
{
	public Long getIdConvencion();
	public Timestamp getFechaInicio();
	public Timestamp getFechaFin();
	public String getNombre();
	public Long getCapacidadActual();
	public Long getCapacidadMaxima();
	public Long getIdHotel();
	public Long getIdCuenta();
	public Long getIdPlanConsumo();
	public Long getIdPlanCobro();
	@Override
	public String toString();

}