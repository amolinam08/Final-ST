package uniandes.isis2304.hotelandes.negocio;

public class Consumocostoadicional implements VOConsumocostoadicional{
	public Long idConsumo;
	public Long idCostoAdicional;
	
	public Consumocostoadicional(){
		this.idConsumo=0L;
		this.idCostoAdicional=0L;
		}
	
	public Consumocostoadicional(Long idConsumo,Long idCostoAdicional){
		this.idConsumo=idConsumo;
		this.idCostoAdicional=idCostoAdicional;
		}
	public Long getIdConsumo(){
		return this.idConsumo;
	}
	public void setIdConsumo(Long idConsumo){
		 this.idConsumo=idConsumo;
	}
	public Long getIdCostoAdicional(){
		return this.idCostoAdicional;
	}
	public void setIdCostoAdicional(Long idCostoAdicional){
		 this.idCostoAdicional=idCostoAdicional;
	}
	@Override
	public String toString()
	{
	return "Consumocostoadicional [idConsumo=" +idConsumo+ ",idCostoAdicional=" +idCostoAdicional+"]";
	}
}