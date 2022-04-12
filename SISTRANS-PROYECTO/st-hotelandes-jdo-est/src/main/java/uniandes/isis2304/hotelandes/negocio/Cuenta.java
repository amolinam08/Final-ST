package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
public class Cuenta implements VOCuenta{
	public Long idCuenta;
	public Timestamp fechaApertura;
	public Long habitacion;
	
	public Cuenta(){
		this.idCuenta=0L;
		this.fechaApertura=new Timestamp (0);
		this.habitacion=0L;
		}
	
	public Cuenta(Long idCuenta,Timestamp fechaApertura,Long habitacion){
		this.idCuenta=idCuenta;
		this.fechaApertura=fechaApertura;
		this.habitacion=habitacion;
		}
	public Long getIdCuenta(){
		return this.idCuenta;
	}
	public void setIdCuenta(Long idCuenta){
		 this.idCuenta=idCuenta;
	}
	public Timestamp getFechaApertura(){
		return this.fechaApertura;
	}
	public void setFechaApertura(Timestamp fechaApertura){
		 this.fechaApertura=fechaApertura;
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
	return "Cuenta [idCuenta=" +idCuenta+ ",fechaApertura=" +fechaApertura+ ",habitacion=" +habitacion+"]";
	}
}