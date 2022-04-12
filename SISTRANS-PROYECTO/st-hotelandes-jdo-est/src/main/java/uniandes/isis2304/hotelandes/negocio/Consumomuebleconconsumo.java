package uniandes.isis2304.hotelandes.negocio;

public class Consumomuebleconconsumo implements VOConsumomuebleconconsumo{
	public Long idConsumo;
	public Long idMuebleConConsumo;
	
	public Consumomuebleconconsumo(){
		this.idConsumo=0L;
		this.idMuebleConConsumo=0L;
		}
	
	public Consumomuebleconconsumo(Long idConsumo,Long idMuebleConConsumo){
		this.idConsumo=idConsumo;
		this.idMuebleConConsumo=idMuebleConConsumo;
		}
	public Long getIdConsumo(){
		return this.idConsumo;
	}
	public void setIdConsumo(Long idConsumo){
		 this.idConsumo=idConsumo;
	}
	public Long getIdMuebleConConsumo(){
		return this.idMuebleConConsumo;
	}
	public void setIdMuebleConConsumo(Long idMuebleConConsumo){
		 this.idMuebleConConsumo=idMuebleConConsumo;
	}
	@Override
	public String toString()
	{
	return "Consumomuebleconconsumo [idConsumo=" +idConsumo+ ",idMuebleConConsumo=" +idMuebleConConsumo+"]";
	}
}