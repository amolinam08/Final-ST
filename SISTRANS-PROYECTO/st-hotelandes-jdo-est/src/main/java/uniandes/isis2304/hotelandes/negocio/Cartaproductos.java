package uniandes.isis2304.hotelandes.negocio;

public class Cartaproductos implements VOCartaproductos{
	public Long idCarta;
	public String nombre;
	
	public Cartaproductos(){
		this.idCarta=0L;
		this.nombre="";
		}
	
	public Cartaproductos(Long idCarta,String nombre){
		this.idCarta=idCarta;
		this.nombre=nombre;
		}
	public Long getIdCarta(){
		return this.idCarta;
	}
	public void setIdCarta(Long idCarta){
		 this.idCarta=idCarta;
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
	return "Cartaproductos [idCarta=" +idCarta+ ",nombre=" +nombre+"]";
	}
}