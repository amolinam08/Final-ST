package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Ofertaservicio implements VOOfertaservicio{
	public Long idOfertaServicio;
	public String nombre;
	public Double costo;
	public Double duracion;
	public Long servicio;
	
	public Ofertaservicio(){
		this.idOfertaServicio=0L;
		this.nombre="";
		this.costo=0D;
		this.duracion=0D;
		this.servicio=0L;
		}
	
	public Ofertaservicio(Long idOfertaServicio,String nombre,Double costo,Double duracion,Long servicio){
		this.idOfertaServicio=idOfertaServicio;
		this.nombre=nombre;
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
	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String nombre){
		 this.nombre=nombre;
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
	return "Ofertaservicio [idOfertaServicio=" +idOfertaServicio+ ",nombre=" +nombre+ ",costo=" +costo+ ",duracion=" +duracion+ ",servicio=" +servicio+"]";
	}
}