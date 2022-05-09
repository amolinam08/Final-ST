package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Oferta implements VOOferta{
	public Long idOferta;
	public Double descuento;
	public String descripcion;
	public Long idHabitacion;
	
	public Oferta(){
		this.idOferta=0L;
		this.descuento=0D;
		this.descripcion="";
		this.idHabitacion=0L;
		}
	
	public Oferta(Long idOferta,Double descuento,String descripcion,Long idHabitacion){
		this.idOferta=idOferta;
		this.descuento=descuento;
		this.descripcion=descripcion;
		this.idHabitacion=idHabitacion;
		}
	public Long getIdOferta(){
		return this.idOferta;
	}
	public void setIdOferta(Long idOferta){
		 this.idOferta=idOferta;
	}
	public Double getDescuento(){
		return this.descuento;
	}
	public void setDescuento(Double descuento){
		 this.descuento=descuento;
	}
	public String getDescripcion(){
		return this.descripcion;
	}
	public void setDescripcion(String descripcion){
		 this.descripcion=descripcion;
	}
	public Long getIdHabitacion(){
		return this.idHabitacion;
	}
	public void setIdHabitacion(Long idHabitacion){
		 this.idHabitacion=idHabitacion;
	}
	@Override
	public String toString()
	{
	return "Oferta [idOferta=" +idOferta+ ",descuento=" +descuento+ ",descripcion=" +descripcion+ ",idHabitacion=" +idHabitacion+"]";
	}
}