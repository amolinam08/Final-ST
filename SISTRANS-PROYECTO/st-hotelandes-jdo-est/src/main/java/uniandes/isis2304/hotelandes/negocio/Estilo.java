package uniandes.isis2304.hotelandes.negocio;

public class Estilo implements VOEstilo{
	public Long idEstilo;
	public String nombre;
	
	public Estilo(){
		this.idEstilo=0L;
		this.nombre="";
		}
	
	public Estilo(Long idEstilo,String nombre){
		this.idEstilo=idEstilo;
		this.nombre=nombre;
		}
	public Long getIdEstilo(){
		return this.idEstilo;
	}
	public void setIdEstilo(Long idEstilo){
		 this.idEstilo=idEstilo;
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
	return "Estilo [idEstilo=" +idEstilo+ ",nombre=" +nombre+"]";
	}
}