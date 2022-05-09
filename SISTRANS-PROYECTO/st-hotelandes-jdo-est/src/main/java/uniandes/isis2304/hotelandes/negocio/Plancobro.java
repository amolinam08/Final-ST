package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Plancobro implements VOPlancobro{
	public Long idPlanCobro;
	public String descripcion;
	public String nombre;
	
	public Plancobro(){
		this.idPlanCobro=0L;
		this.descripcion="";
		this.nombre="";
		}
	
	public Plancobro(Long idPlanCobro,String descripcion,String nombre){
		this.idPlanCobro=idPlanCobro;
		this.descripcion=descripcion;
		this.nombre=nombre;
		}
	public Long getIdPlanCobro(){
		return this.idPlanCobro;
	}
	public void setIdPlanCobro(Long idPlanCobro){
		 this.idPlanCobro=idPlanCobro;
	}
	public String getDescripcion(){
		return this.descripcion;
	}
	public void setDescripcion(String descripcion){
		 this.descripcion=descripcion;
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
	return "Plancobro [idPlanCobro=" +idPlanCobro+ ",descripcion=" +descripcion+ ",nombre=" +nombre+"]";
	}
}