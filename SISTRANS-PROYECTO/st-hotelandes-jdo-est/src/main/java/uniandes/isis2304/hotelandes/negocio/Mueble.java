package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Mueble implements VOMueble{
	public Long idMueble;
	public String tipoMueble;
	public Double costoMueble;
	public Long habitacion;
	
	public Mueble(){
		this.idMueble=0L;
		this.tipoMueble="";
		this.costoMueble=0D;
		this.habitacion=0L;
		}
	
	public Mueble(Long idMueble,String tipoMueble,Double costoMueble,Long habitacion){
		this.idMueble=idMueble;
		this.tipoMueble=tipoMueble;
		this.costoMueble=costoMueble;
		this.habitacion=habitacion;
		}
	public Long getIdMueble(){
		return this.idMueble;
	}
	public void setIdMueble(Long idMueble){
		 this.idMueble=idMueble;
	}
	public String getTipoMueble(){
		return this.tipoMueble;
	}
	public void setTipoMueble(String tipoMueble){
		 this.tipoMueble=tipoMueble;
	}
	public Double getCostoMueble(){
		return this.costoMueble;
	}
	public void setCostoMueble(Double costoMueble){
		 this.costoMueble=costoMueble;
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
	return "Mueble [idMueble=" +idMueble+ ",tipoMueble=" +tipoMueble+ ",costoMueble=" +costoMueble+ ",habitacion=" +habitacion+"]";
	}
}