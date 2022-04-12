package uniandes.isis2304.hotelandes.negocio;

public class Ofertaservicio implements VOOfertaservicio{
	public Long idOfertaServicio;
	public Double costo;
	public Double duracion;
	
	public Ofertaservicio(){
		this.idOfertaServicio=0L;
		this.costo=0D;
		this.duracion=0D;
		}
	
	public Ofertaservicio(Long idOfertaServicio,Double costo,Double duracion){
		this.idOfertaServicio=idOfertaServicio;
		this.costo=costo;
		this.duracion=duracion;
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
	@Override
	public String toString()
	{
	return "Ofertaservicio [idOfertaServicio=" +idOfertaServicio+ ",costo=" +costo+ ",duracion=" +duracion+"]";
	}
}