package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Convencionreserva implements VOConvencionreserva{
	public Long idConvencion;
	public Long idReserva;
	
	public Convencionreserva(){
		this.idConvencion=0L;
		this.idReserva=0L;
		}
	
	public Convencionreserva(Long idConvencion,Long idReserva){
		this.idConvencion=idConvencion;
		this.idReserva=idReserva;
		}
	public Long getIdConvencion(){
		return this.idConvencion;
	}
	public void setIdConvencion(Long idConvencion){
		 this.idConvencion=idConvencion;
	}
	public Long getIdReserva(){
		return this.idReserva;
	}
	public void setIdReserva(Long idReserva){
		 this.idReserva=idReserva;
	}
	@Override
	public String toString()
	{
	return "Convencionreserva [idConvencion=" +idConvencion+ ",idReserva=" +idReserva+"]";
	}
}