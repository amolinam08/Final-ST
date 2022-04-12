package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Tipohabitacion implements VOTipohabitacion{
	public Long idTipoHabitacion;
	public String nombre;
	public String descripcion;
	
	public Tipohabitacion(){
		this.idTipoHabitacion=0L;
		this.nombre="";
		this.descripcion="";
		}
	
	public Tipohabitacion(Long idTipoHabitacion,String nombre,String descripcion){
		this.idTipoHabitacion=idTipoHabitacion;
		this.nombre=nombre;
		this.descripcion=descripcion;
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
	public String getDescripcion(){
		return this.descripcion;
	}
	public void setDescripcion(String descripcion){
		 this.descripcion=descripcion;
	}
	@Override
	public String toString()
	{
	return "Tipohabitacion [idTipoHabitacion=" +idTipoHabitacion+ ",nombre=" +nombre+ ",descripcion=" +descripcion+"]";
	}
}