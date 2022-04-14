package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public interface VOReserva
{
	public Long getIdReserva();
	public Timestamp getDiaHora();
	public Double getDuracion();
	public String getAceptada();
	public Long getNumPersonas();
	public String getPlanPago();
	public Timestamp getFechaSalida();
	public Long getCliente();
	public Long getHabitacion();
	public Long getServicio();
	public Long getOfertaServicio();
	@Override
	public String toString();

}