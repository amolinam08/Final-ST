package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Planconsumo implements VOPlanconsumo{
	public Long idPlanConsumo;
	public String nombre;
	public Double descuento;
	public String descripcion;
	public Timestamp periodoVigencia1;
	public Timestamp periodoVigencia2;
	public Long tipoPlanConsumo;
	
	public Planconsumo(){
		this.idPlanConsumo=0L;
		this.nombre="";
		this.descuento=0D;
		this.descripcion="";
		this.periodoVigencia1=new Timestamp (0);
		this.periodoVigencia2=new Timestamp (0);
		this.tipoPlanConsumo=0L;
		}
	
	public Planconsumo(Long idPlanConsumo,String nombre,Double descuento,String descripcion,Timestamp periodoVigencia1,Timestamp periodoVigencia2,Long tipoPlanConsumo){
		this.idPlanConsumo=idPlanConsumo;
		this.nombre=nombre;
		this.descuento=descuento;
		this.descripcion=descripcion;
		this.periodoVigencia1=periodoVigencia1;
		this.periodoVigencia2=periodoVigencia2;
		this.tipoPlanConsumo=tipoPlanConsumo;
		}
	public Long getIdPlanConsumo(){
		return this.idPlanConsumo;
	}
	public void setIdPlanConsumo(Long idPlanConsumo){
		 this.idPlanConsumo=idPlanConsumo;
	}
	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String nombre){
		 this.nombre=nombre;
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
	public Timestamp getPeriodoVigencia1(){
		return this.periodoVigencia1;
	}
	public void setPeriodoVigencia1(Timestamp periodoVigencia1){
		 this.periodoVigencia1=periodoVigencia1;
	}
	public Timestamp getPeriodoVigencia2(){
		return this.periodoVigencia2;
	}
	public void setPeriodoVigencia2(Timestamp periodoVigencia2){
		 this.periodoVigencia2=periodoVigencia2;
	}
	public Long getTipoPlanConsumo(){
		return this.tipoPlanConsumo;
	}
	public void setTipoPlanConsumo(Long tipoPlanConsumo){
		 this.tipoPlanConsumo=tipoPlanConsumo;
	}
	@Override
	public String toString()
	{
	return "Planconsumo [idPlanConsumo=" +idPlanConsumo+ ",nombre=" +nombre+ ",descuento=" +descuento+ ",descripcion=" +descripcion+ ",periodoVigencia1=" +periodoVigencia1+ ",periodoVigencia2=" +periodoVigencia2+ ",tipoPlanConsumo=" +tipoPlanConsumo+"]";
	}
}