package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Consumo implements VOConsumo{
	public Long idConsumo;
	public String fecha;
	public Long cuenta;
	public Long registroConsumo;
	public Long empleado;
	
	public Consumo(){
		this.idConsumo=0L;
		this.fecha="";
		this.cuenta=0L;
		this.registroConsumo=0L;
		this.empleado=0L;
		}
	
	public Consumo(Long idConsumo,String fecha,Long cuenta,Long registroConsumo,Long empleado){
		this.idConsumo=idConsumo;
		this.fecha=fecha;
		this.cuenta=cuenta;
		this.registroConsumo=registroConsumo;
		this.empleado=empleado;
		}
	public Long getIdConsumo(){
		return this.idConsumo;
	}
	public void setIdConsumo(Long idConsumo){
		 this.idConsumo=idConsumo;
	}
	public String getFecha(){
		return this.fecha;
	}
	public void setFecha(String fecha){
		 this.fecha=fecha;
	}
	public Long getCuenta(){
		return this.cuenta;
	}
	public void setCuenta(Long cuenta){
		 this.cuenta=cuenta;
	}
	public Long getRegistroConsumo(){
		return this.registroConsumo;
	}
	public void setRegistroConsumo(Long registroConsumo){
		 this.registroConsumo=registroConsumo;
	}
	public Long getEmpleado(){
		return this.empleado;
	}
	public void setEmpleado(Long empleado){
		 this.empleado=empleado;
	}
	@Override
	public String toString()
	{
	return "Consumo [idConsumo=" +idConsumo+ ",fecha=" +fecha+ ",cuenta=" +cuenta+ ",registroConsumo=" +registroConsumo+ ",empleado=" +empleado+"]";
	}
}