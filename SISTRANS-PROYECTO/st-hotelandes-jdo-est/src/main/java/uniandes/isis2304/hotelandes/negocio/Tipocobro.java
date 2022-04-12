package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Tipocobro implements VOTipocobro{
	public Long idTipoCobro;
	public String nombre;
	
	public Tipocobro(){
		this.idTipoCobro=0L;
		this.nombre="";
		}
	
	public Tipocobro(Long idTipoCobro,String nombre){
		this.idTipoCobro=idTipoCobro;
		this.nombre=nombre;
		}
	public Long getIdTipoCobro(){
		return this.idTipoCobro;
	}
	public void setIdTipoCobro(Long idTipoCobro){
		 this.idTipoCobro=idTipoCobro;
	}
	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String nombre){
		 this.nombre=nombre;
	}
	@Override
	public String toString()
	{
	return "Tipocobro [idTipoCobro=" +idTipoCobro+ ",nombre=" +nombre+"]";
	}
}