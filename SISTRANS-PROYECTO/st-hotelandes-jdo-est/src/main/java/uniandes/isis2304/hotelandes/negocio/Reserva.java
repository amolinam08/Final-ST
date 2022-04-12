package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Reserva implements VOReserva{
	public Long idReserva;
	public Timestamp diaHora;
	public Double duracion;
	public String aceptada;
	public Long numPersonas;
	public String planPago;
	public Timestamp fechaSalida;
	public Long cliente;
	public Long habitacion;
	public Long servicio;
	public Double profunidad;
	
	public Reserva(){
		this.idReserva=0L;
		this.diaHora=new Timestamp (0);
		this.duracion=0D;
		this.aceptada="";
		this.numPersonas=0L;
		this.planPago="";
		this.fechaSalida=new Timestamp (0);
		this.cliente=0L;
		this.habitacion=0L;
		this.servicio=0L;
		this.profunidad=0D;
		}
	
	public Reserva(Long idReserva,Timestamp diaHora,Double duracion,String aceptada,Long numPersonas,String planPago,Timestamp fechaSalida,Long cliente,Long habitacion,Long servicio,Double profunidad){
		this.idReserva=idReserva;
		this.diaHora=diaHora;
		this.duracion=duracion;
		this.aceptada=aceptada;
		this.numPersonas=numPersonas;
		this.planPago=planPago;
		this.fechaSalida=fechaSalida;
		this.cliente=cliente;
		this.habitacion=habitacion;
		this.servicio=servicio;
		this.profunidad=profunidad;
		}
	public Long getIdReserva(){
		return this.idReserva;
	}
	public void setIdReserva(Long idReserva){
		 this.idReserva=idReserva;
	}
	public Timestamp getDiaHora(){
		return this.diaHora;
	}
	public void setDiaHora(Timestamp diaHora){
		 this.diaHora=diaHora;
	}
	public Double getDuracion(){
		return this.duracion;
	}
	public void setDuracion(Double duracion){
		 this.duracion=duracion;
	}
	public String getAceptada(){
		return this.aceptada;
	}
	public void setAceptada(String aceptada){
		 this.aceptada=aceptada;
	}
	public Long getNumPersonas(){
		return this.numPersonas;
	}
	public void setNumPersonas(Long numPersonas){
		 this.numPersonas=numPersonas;
	}
	public String getPlanPago(){
		return this.planPago;
	}
	public void setPlanPago(String planPago){
		 this.planPago=planPago;
	}
	public Timestamp getFechaSalida(){
		return this.fechaSalida;
	}
	public void setFechaSalida(Timestamp fechaSalida){
		 this.fechaSalida=fechaSalida;
	}
	public Long getCliente(){
		return this.cliente;
	}
	public void setCliente(Long cliente){
		 this.cliente=cliente;
	}
	public Long getHabitacion(){
		return this.habitacion;
	}
	public void setHabitacion(Long habitacion){
		 this.habitacion=habitacion;
	}
	public Long getServicio(){
		return this.servicio;
	}
	public void setServicio(Long servicio){
		 this.servicio=servicio;
	}
	public Double getProfunidad(){
		return this.profunidad;
	}
	public void setProfunidad(Double profunidad){
		 this.profunidad=profunidad;
	}
	@Override
	public String toString()
	{
	return "Reserva [idReserva=" +idReserva+ ",diaHora=" +diaHora+ ",duracion=" +duracion+ ",aceptada=" +aceptada+ ",numPersonas=" +numPersonas+ ",planPago=" +planPago+ ",fechaSalida=" +fechaSalida+ ",cliente=" +cliente+ ",habitacion=" +habitacion+ ",servicio=" +servicio+ ",profunidad=" +profunidad+"]";
	}
}