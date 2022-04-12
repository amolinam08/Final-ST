package uniandes.isis2304.hotelandes.negocio;

public class Planconsumorestricciones implements VOPlanconsumorestricciones{
	public Long idPlanConsumo;
	public Long idRestriccion;
	
	public Planconsumorestricciones(){
		this.idPlanConsumo=0L;
		this.idRestriccion=0L;
		}
	
	public Planconsumorestricciones(Long idPlanConsumo,Long idRestriccion){
		this.idPlanConsumo=idPlanConsumo;
		this.idRestriccion=idRestriccion;
		}
	public Long getIdPlanConsumo(){
		return this.idPlanConsumo;
	}
	public void setIdPlanConsumo(Long idPlanConsumo){
		 this.idPlanConsumo=idPlanConsumo;
	}
	public Long getIdRestriccion(){
		return this.idRestriccion;
	}
	public void setIdRestriccion(Long idRestriccion){
		 this.idRestriccion=idRestriccion;
	}
	@Override
	public String toString()
	{
	return "Planconsumorestricciones [idPlanConsumo=" +idPlanConsumo+ ",idRestriccion=" +idRestriccion+"]";
	}
}