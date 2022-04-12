package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
public class Servicioprestamo implements VOServicioprestamo{
	public Long idPrestamo;
	public Timestamp fechaPrestamo;
	public Timestamp fechaReintegro;
	public Long consumo;
	
	public Servicioprestamo(){
		this.idPrestamo=0L;
		this.fechaPrestamo=new Timestamp (0);
		this.fechaReintegro=new Timestamp (0);
		this.consumo=0L;
		}
	
	public Servicioprestamo(Long idPrestamo,Timestamp fechaPrestamo,Timestamp fechaReintegro,Long consumo){
		this.idPrestamo=idPrestamo;
		this.fechaPrestamo=fechaPrestamo;
		this.fechaReintegro=fechaReintegro;
		this.consumo=consumo;
		}
	public Long getIdPrestamo(){
		return this.idPrestamo;
	}
	public void setIdPrestamo(Long idPrestamo){
		 this.idPrestamo=idPrestamo;
	}
	public Timestamp getFechaPrestamo(){
		return this.fechaPrestamo;
	}
	public void setFechaPrestamo(Timestamp fechaPrestamo){
		 this.fechaPrestamo=fechaPrestamo;
	}
	public Timestamp getFechaReintegro(){
		return this.fechaReintegro;
	}
	public void setFechaReintegro(Timestamp fechaReintegro){
		 this.fechaReintegro=fechaReintegro;
	}
	public Long getConsumo(){
		return this.consumo;
	}
	public void setConsumo(Long consumo){
		 this.consumo=consumo;
	}
	@Override
	public String toString()
	{
	return "Servicioprestamo [idPrestamo=" +idPrestamo+ ",fechaPrestamo=" +fechaPrestamo+ ",fechaReintegro=" +fechaReintegro+ ",consumo=" +consumo+"]";
	}
}