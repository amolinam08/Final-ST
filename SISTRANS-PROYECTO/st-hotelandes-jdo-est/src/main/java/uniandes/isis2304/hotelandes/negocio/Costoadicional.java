package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Costoadicional implements VOCostoadicional{
	public Long idCostoAdicional;
	public String nombre;
	public Double costo;
	public Long servicio;
	
	public Costoadicional(){
		this.idCostoAdicional=0L;
		this.nombre="";
		this.costo=0D;
		this.servicio=0L;
		}
	
	public Costoadicional(Long idCostoAdicional,String nombre,Double costo,Long servicio){
		this.idCostoAdicional=idCostoAdicional;
		this.nombre=nombre;
		this.costo=costo;
		this.servicio=servicio;
		}
	public Long getIdCostoAdicional(){
		return this.idCostoAdicional;
	}
	public void setIdCostoAdicional(Long idCostoAdicional){
		 this.idCostoAdicional=idCostoAdicional;
	}
	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String nombre){
		 this.nombre=nombre;
	}
	public Double getCosto(){
		return this.costo;
	}
	public void setCosto(Double costo){
		 this.costo=costo;
	}
	public Long getServicio(){
		return this.servicio;
	}
	public void setServicio(Long servicio){
		 this.servicio=servicio;
	}
	@Override
	public String toString()
	{
	return "Costoadicional [idCostoAdicional=" +idCostoAdicional+ ",nombre=" +nombre+ ",costo=" +costo+ ",servicio=" +servicio+"]";
	}
}