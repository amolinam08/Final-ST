package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Mantenimiento implements VOMantenimiento{
	public Long idMantenimiento;
	public Timestamp fechaInicio;
	public Timestamp fechaFin;
	public String descripcion;
	public Long servicio;
	public Long habitacion;
	
	public Mantenimiento(){
		this.idMantenimiento=0L;
		this.fechaInicio=new Timestamp (0);
		this.fechaFin=new Timestamp (0);
		this.descripcion="";
		this.servicio=0L;
		this.habitacion=0L;
		}
	
	public Mantenimiento(Long idMantenimiento,Timestamp fechaInicio,Timestamp fechaFin,String descripcion,Long servicio,Long habitacion){
		this.idMantenimiento=idMantenimiento;
		this.fechaInicio=fechaInicio;
		this.fechaFin=fechaFin;
		this.descripcion=descripcion;
		this.servicio=servicio;
		this.habitacion=habitacion;
		}
	public Long getIdMantenimiento(){
		return this.idMantenimiento;
	}
	public void setIdMantenimiento(Long idMantenimiento){
		 this.idMantenimiento=idMantenimiento;
	}
	public Timestamp getFechaInicio(){
		return this.fechaInicio;
	}
	public void setFechaInicio(Timestamp fechaInicio){
		 this.fechaInicio=fechaInicio;
	}
	public Timestamp getFechaFin(){
		return this.fechaFin;
	}
	public void setFechaFin(Timestamp fechaFin){
		 this.fechaFin=fechaFin;
	}
	public String getDescripcion(){
		return this.descripcion;
	}
	public void setDescripcion(String descripcion){
		 this.descripcion=descripcion;
	}
	public Long getServicio(){
		return this.servicio;
	}
	public void setServicio(Long servicio){
		 this.servicio=servicio;
	}
	public Long getHabitacion(){
		return this.habitacion;
	}
	public void setHabitacion(Long habitacion){
		 this.habitacion=habitacion;
	}
	@Override
	public String toString()
	{
	return "Mantenimiento [idMantenimiento=" +idMantenimiento+ ",fechaInicio=" +fechaInicio+ ",fechaFin=" +fechaFin+ ",descripcion=" +descripcion+ ",servicio=" +servicio+ ",habitacion=" +habitacion+"]";
	}
}