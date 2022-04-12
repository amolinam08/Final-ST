package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public interface VOHorarioservicio
{
	public Long getIdHorarioServicio();
	public Timestamp getHoraInicio();
	public Double getDuracion();
	@Override
	public String toString();

}