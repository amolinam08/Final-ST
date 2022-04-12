package uniandes.isis2304.hotelandes.negocio;

public class Tipohabitacion implements VOTipohabitacion{
	public Long idTipoHabitacion;
	public String nombre;
	
	public Tipohabitacion(){
		this.idTipoHabitacion=0L;
		this.nombre="";
		}
	
	public Tipohabitacion(Long idTipoHabitacion,String nombre){
		this.idTipoHabitacion=idTipoHabitacion;
		this.nombre=nombre;
		}
	public Long getIdTipoHabitacion(){
		return this.idTipoHabitacion;
	}
	public void setIdTipoHabitacion(Long idTipoHabitacion){
		 this.idTipoHabitacion=idTipoHabitacion;
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
	return "Tipohabitacion [idTipoHabitacion=" +idTipoHabitacion+ ",nombre=" +nombre+"]";
	}
}