package uniandes.isis2304.hotelandes.negocio;

public class Restricciones implements VORestricciones{
	public Long idRestriccion;
	public Long cantidad;
	public Long producto;
	
	public Restricciones(){
		this.idRestriccion=0L;
		this.cantidad=0L;
		this.producto=0L;
		}
	
	public Restricciones(Long idRestriccion,Long cantidad,Long producto){
		this.idRestriccion=idRestriccion;
		this.cantidad=cantidad;
		this.producto=producto;
		}
	public Long getIdRestriccion(){
		return this.idRestriccion;
	}
	public void setIdRestriccion(Long idRestriccion){
		 this.idRestriccion=idRestriccion;
	}
	public Long getCantidad(){
		return this.cantidad;
	}
	public void setCantidad(Long cantidad){
		 this.cantidad=cantidad;
	}
	public Long getProducto(){
		return this.producto;
	}
	public void setProducto(Long producto){
		 this.producto=producto;
	}
	@Override
	public String toString()
	{
	return "Restricciones [idRestriccion=" +idRestriccion+ ",cantidad=" +cantidad+ ",producto=" +producto+"]";
	}
}