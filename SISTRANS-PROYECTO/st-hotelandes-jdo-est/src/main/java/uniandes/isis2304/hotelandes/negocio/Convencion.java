package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Convencion implements VOConvencion{
	public Long idConvencion;
	public Timestamp fechaInicio;
	public Timestamp fechaFin;
	public String nombre;
	public Long capacidadActual;
	public Long capacidadMaxima;
	public Long idHotel;
	public Long idCuenta;
	public Long idPlanConsumo;
	public Long idPlanCobro;
	
	public Convencion(){
		this.idConvencion=0L;
		this.fechaInicio=new Timestamp (0);
		this.fechaFin=new Timestamp (0);
		this.nombre="";
		this.capacidadActual=0L;
		this.capacidadMaxima=0L;
		this.idHotel=0L;
		this.idCuenta=0L;
		this.idPlanConsumo=0L;
		this.idPlanCobro=0L;
		}
	
	public Convencion(Long idConvencion,Timestamp fechaInicio,Timestamp fechaFin,String nombre,Long capacidadActual,Long capacidadMaxima,Long idHotel,Long idCuenta,Long idPlanConsumo,Long idPlanCobro){
		this.idConvencion=idConvencion;
		this.fechaInicio=fechaInicio;
		this.fechaFin=fechaFin;
		this.nombre=nombre;
		this.capacidadActual=capacidadActual;
		this.capacidadMaxima=capacidadMaxima;
		this.idHotel=idHotel;
		this.idCuenta=idCuenta;
		this.idPlanConsumo=idPlanConsumo;
		this.idPlanCobro=idPlanCobro;
		}
	public Long getIdConvencion(){
		return this.idConvencion;
	}
	public void setIdConvencion(Long idConvencion){
		 this.idConvencion=idConvencion;
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
	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String nombre){
		 this.nombre=nombre;
	}
	public Long getCapacidadActual(){
		return this.capacidadActual;
	}
	public void setCapacidadActual(Long capacidadActual){
		 this.capacidadActual=capacidadActual;
	}
	public Long getCapacidadMaxima(){
		return this.capacidadMaxima;
	}
	public void setCapacidadMaxima(Long capacidadMaxima){
		 this.capacidadMaxima=capacidadMaxima;
	}
	public Long getIdHotel(){
		return this.idHotel;
	}
	public void setIdHotel(Long idHotel){
		 this.idHotel=idHotel;
	}
	public Long getIdCuenta(){
		return this.idCuenta;
	}
	public void setIdCuenta(Long idCuenta){
		 this.idCuenta=idCuenta;
	}
	public Long getIdPlanConsumo(){
		return this.idPlanConsumo;
	}
	public void setIdPlanConsumo(Long idPlanConsumo){
		 this.idPlanConsumo=idPlanConsumo;
	}
	public Long getIdPlanCobro(){
		return this.idPlanCobro;
	}
	public void setIdPlanCobro(Long idPlanCobro){
		 this.idPlanCobro=idPlanCobro;
	}
	@Override
	public String toString()
	{
	return "Convencion [idConvencion=" +idConvencion+ ",fechaInicio=" +fechaInicio+ ",fechaFin=" +fechaFin+ ",nombre=" +nombre+ ",capacidadActual=" +capacidadActual+ ",capacidadMaxima=" +capacidadMaxima+ ",idHotel=" +idHotel+ ",idCuenta=" +idCuenta+ ",idPlanConsumo=" +idPlanConsumo+ ",idPlanCobro=" +idPlanCobro+"]";
	}
}