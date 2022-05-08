package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Consumo implements VOConsumo{
	public Long idConsumo;
	public Timestamp fecha;
	public Long cuenta;
	public Long registroConsumo;
	public Long empleado;
	public String pagado;
	
	public Consumo(){
		this.idConsumo=0L;
		this.fecha=new Timestamp (0);
		this.cuenta=0L;
		this.registroConsumo=0L;
		this.empleado=0L;
		this.pagado="";
		}
	
	public Consumo(Long idConsumo,Timestamp fecha,Long cuenta,Long registroConsumo,Long empleado,String pagado){
		this.idConsumo=idConsumo;
		this.fecha=fecha;
		this.cuenta=cuenta;
		this.registroConsumo=registroConsumo;
		this.empleado=empleado;
		this.pagado=pagado;
		}
	public Long getIdConsumo(){
		return this.idConsumo;
	}
	public void setIdConsumo(Long idConsumo){
		 this.idConsumo=idConsumo;
	}
	public Timestamp getFecha(){
		return this.fecha;
	}
	public void setFecha(Timestamp fecha){
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
	public String getPagado(){
		return this.pagado;
	}
	public void setPagado(String pagado){
		 this.pagado=pagado;
	}
	@Override
	public String toString()
	{
	return "Consumo [idConsumo=" +idConsumo+ ",fecha=" +fecha+ ",cuenta=" +cuenta+ ",registroConsumo=" +registroConsumo+ ",empleado=" +empleado+ ",pagado=" +pagado+"]";
	}
}