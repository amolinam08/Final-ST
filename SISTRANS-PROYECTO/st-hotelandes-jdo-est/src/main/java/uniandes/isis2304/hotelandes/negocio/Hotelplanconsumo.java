package uniandes.isis2304.hotelandes.negocio;

public class Hotelplanconsumo implements VOHotelplanconsumo{
	public Long idHotel;
	public Long idPlanConsumo;
	
	public Hotelplanconsumo(){
		this.idHotel=0L;
		this.idPlanConsumo=0L;
		}
	
	public Hotelplanconsumo(Long idHotel,Long idPlanConsumo){
		this.idHotel=idHotel;
		this.idPlanConsumo=idPlanConsumo;
		}
	public Long getIdHotel(){
		return this.idHotel;
	}
	public void setIdHotel(Long idHotel){
		 this.idHotel=idHotel;
	}
	public Long getIdPlanConsumo(){
		return this.idPlanConsumo;
	}
	public void setIdPlanConsumo(Long idPlanConsumo){
		 this.idPlanConsumo=idPlanConsumo;
	}
	@Override
	public String toString()
	{
	return "Hotelplanconsumo [idHotel=" +idHotel+ ",idPlanConsumo=" +idPlanConsumo+"]";
	}
}