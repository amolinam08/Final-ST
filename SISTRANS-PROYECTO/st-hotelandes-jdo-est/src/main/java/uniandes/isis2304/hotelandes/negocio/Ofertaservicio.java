package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Ofertaservicio implements VOOfertaservicio{
	public Long idOfertaServicio;
	public Double costo;
	public Double duracion;
	public Long servicio;
	
	public Ofertaservicio(){
		this.idOfertaServicio=0L;
		this.costo=0D;
		this.duracion=0D;
		this.servicio=0L;
		}
	
	public Ofertaservicio(Long idOfertaServicio,Double costo,Double duracion,Long servicio){
		this.idOfertaServicio=idOfertaServicio;
		this.costo=costo;
		this.duracion=duracion;
		this.servicio=servicio;
		}
	public Long getIdOfertaServicio(){
		return this.idOfertaServicio;
	}
	public void setIdOfertaServicio(Long idOfertaServicio){
		 this.idOfertaServicio=idOfertaServicio;
	}
	public Double getCosto(){
		return this.costo;
	}
	public void setCosto(Double costo){
		 this.costo=costo;
	}
	public Double getDuracion(){
		return this.duracion;
	}
	public void setDuracion(Double duracion){
		 this.duracion=duracion;
	}
	public Long getServicio(){
		return this.servicio;
	}
	public void setServicio(Long servicio){
		 this.servicio=servicio;
	}
	@Override
	public String toString()
	{
	return "Ofertaservicio [idOfertaServicio=" +idOfertaServicio+ ",costo=" +costo+ ",duracion=" +duracion+ ",servicio=" +servicio+"]";
	}
}