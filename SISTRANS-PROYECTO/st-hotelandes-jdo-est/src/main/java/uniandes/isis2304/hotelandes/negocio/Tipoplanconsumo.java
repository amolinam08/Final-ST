package uniandes.isis2304.hotelandes.negocio;

public class Tipoplanconsumo implements VOTipoplanconsumo{
	public Long idTipoPlanConsumo;
	public String nombre;
	
	public Tipoplanconsumo(){
		this.idTipoPlanConsumo=0L;
		this.nombre="";
		}
	
	public Tipoplanconsumo(Long idTipoPlanConsumo,String nombre){
		this.idTipoPlanConsumo=idTipoPlanConsumo;
		this.nombre=nombre;
		}
	public Long getIdTipoPlanConsumo(){
		return this.idTipoPlanConsumo;
	}
	public void setIdTipoPlanConsumo(Long idTipoPlanConsumo){
		 this.idTipoPlanConsumo=idTipoPlanConsumo;
	}
	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String nombre){
		 this.nombre=nombre;
	}
	@Override
	public String toString()
	{
	return "Tipoplanconsumo [idTipoPlanConsumo=" +idTipoPlanConsumo+ ",nombre=" +nombre+"]";
	}
}