package uniandes.isis2304.hotelandes.negocio;

public class Consumoofertaservicio implements VOConsumoofertaservicio{
	public Long idConsumo;
	public Long idOfertaServicio;
	
	public Consumoofertaservicio(){
		this.idConsumo=0L;
		this.idOfertaServicio=0L;
		}
	
	public Consumoofertaservicio(Long idConsumo,Long idOfertaServicio){
		this.idConsumo=idConsumo;
		this.idOfertaServicio=idOfertaServicio;
		}
	public Long getIdConsumo(){
		return this.idConsumo;
	}
	public void setIdConsumo(Long idConsumo){
		 this.idConsumo=idConsumo;
	}
	public Long getIdOfertaServicio(){
		return this.idOfertaServicio;
	}
	public void setIdOfertaServicio(Long idOfertaServicio){
		 this.idOfertaServicio=idOfertaServicio;
	}
	@Override
	public String toString()
	{
	return "Consumoofertaservicio [idConsumo=" +idConsumo+ ",idOfertaServicio=" +idOfertaServicio+"]";
	}
}