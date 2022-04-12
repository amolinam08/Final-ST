package uniandes.isis2304.hotelandes.negocio;

public class Planconsumoservicio implements VOPlanconsumoservicio{
	public Long idPlanConsumo;
	public Long idServicio;
	
	public Planconsumoservicio(){
		this.idPlanConsumo=0L;
		this.idServicio=0L;
		}
	
	public Planconsumoservicio(Long idPlanConsumo,Long idServicio){
		this.idPlanConsumo=idPlanConsumo;
		this.idServicio=idServicio;
		}
	public Long getIdPlanConsumo(){
		return this.idPlanConsumo;
	}
	public void setIdPlanConsumo(Long idPlanConsumo){
		 this.idPlanConsumo=idPlanConsumo;
	}
	public Long getIdServicio(){
		return this.idServicio;
	}
	public void setIdServicio(Long idServicio){
		 this.idServicio=idServicio;
	}
	@Override
	public String toString()
	{
	return "Planconsumoservicio [idPlanConsumo=" +idPlanConsumo+ ",idServicio=" +idServicio+"]";
	}
}