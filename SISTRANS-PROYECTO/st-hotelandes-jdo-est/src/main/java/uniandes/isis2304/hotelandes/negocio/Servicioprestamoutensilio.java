package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Servicioprestamoutensilio implements VOServicioprestamoutensilio{
	public Long idServicioPrestamo;
	public Long idUtensilio;
	
	public Servicioprestamoutensilio(){
		this.idServicioPrestamo=0L;
		this.idUtensilio=0L;
		}
	
	public Servicioprestamoutensilio(Long idServicioPrestamo,Long idUtensilio){
		this.idServicioPrestamo=idServicioPrestamo;
		this.idUtensilio=idUtensilio;
		}
	public Long getIdServicioPrestamo(){
		return this.idServicioPrestamo;
	}
	public void setIdServicioPrestamo(Long idServicioPrestamo){
		 this.idServicioPrestamo=idServicioPrestamo;
	}
	public Long getIdUtensilio(){
		return this.idUtensilio;
	}
	public void setIdUtensilio(Long idUtensilio){
		 this.idUtensilio=idUtensilio;
	}
	@Override
	public String toString()
	{
	return "Servicioprestamoutensilio [idServicioPrestamo=" +idServicioPrestamo+ ",idUtensilio=" +idUtensilio+"]";
	}
}