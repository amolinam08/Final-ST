package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Habitacion implements VOHabitacion{
	public Long idHabitacion;
	public Long capacidad;
	public Double costoAloj;
	public Long hotel;
	public Long tipoHabitacion;
	public Long cuenta;
	public String ocupado;
	public Long reserva;
	
	public Habitacion(){
		this.idHabitacion=0L;
		this.capacidad=0L;
		this.costoAloj=0D;
		this.hotel=0L;
		this.tipoHabitacion=0L;
		this.cuenta=0L;
		this.ocupado="";
		this.reserva=0L;
		}
	
	public Habitacion(Long idHabitacion,Long capacidad,Double costoAloj,Long hotel,Long tipoHabitacion,Long cuenta,String ocupado,Long reserva){
		this.idHabitacion=idHabitacion;
		this.capacidad=capacidad;
		this.costoAloj=costoAloj;
		this.hotel=hotel;
		this.tipoHabitacion=tipoHabitacion;
		this.cuenta=cuenta;
		this.ocupado=ocupado;
		this.reserva=reserva;
		}
	public Long getIdHabitacion(){
		return this.idHabitacion;
	}
	public void setIdHabitacion(Long idHabitacion){
		 this.idHabitacion=idHabitacion;
	}
	public Long getCapacidad(){
		return this.capacidad;
	}
	public void setCapacidad(Long capacidad){
		 this.capacidad=capacidad;
	}
	public Double getCostoAloj(){
		return this.costoAloj;
	}
	public void setCostoAloj(Double costoAloj){
		 this.costoAloj=costoAloj;
	}
	public Long getHotel(){
		return this.hotel;
	}
	public void setHotel(Long hotel){
		 this.hotel=hotel;
	}
	public Long getTipoHabitacion(){
		return this.tipoHabitacion;
	}
	public void setTipoHabitacion(Long tipoHabitacion){
		 this.tipoHabitacion=tipoHabitacion;
	}
	public Long getCuenta(){
		return this.cuenta;
	}
	public void setCuenta(Long cuenta){
		 this.cuenta=cuenta;
	}
	public String getOcupado(){
		return this.ocupado;
	}
	public void setOcupado(String ocupado){
		 this.ocupado=ocupado;
	}
	public Long getReserva(){
		return this.reserva;
	}
	public void setReserva(Long reserva){
		 this.reserva=reserva;
	}
	@Override
	public String toString()
	{
	return "Habitacion [idHabitacion=" +idHabitacion+ ",capacidad=" +capacidad+ ",costoAloj=" +costoAloj+ ",hotel=" +hotel+ ",tipoHabitacion=" +tipoHabitacion+ ",cuenta=" +cuenta+ ",ocupado=" +ocupado+ ",reserva=" +reserva+"]";
	}
}