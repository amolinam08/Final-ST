package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public interface VOOfertaservicio
{
	public Long getIdOfertaServicio();
	public String getNombre();
	public Double getCosto();
	public Double getDuracion();
	public Long getServicio();
	@Override
	public String toString();

}