package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Consumoconmueble implements VOConsumoconmueble{
	public Long idMueble;
	public Double costo;
	public String usado;
	
	public Consumoconmueble(){
		this.idMueble=0L;
		this.costo=0D;
		this.usado="";
		}
	
	public Consumoconmueble(Long idMueble,Double costo,String usado){
		this.idMueble=idMueble;
		this.costo=costo;
		this.usado=usado;
		}
	public Long getIdMueble(){
		return this.idMueble;
	}
	public void setIdMueble(Long idMueble){
		 this.idMueble=idMueble;
	}
	public Double getCosto(){
		return this.costo;
	}
	public void setCosto(Double costo){
		 this.costo=costo;
	}
	public String getUsado(){
		return this.usado;
	}
	public void setUsado(String usado){
		 this.usado=usado;
	}
	@Override
	public String toString()
	{
	return "Consumoconmueble [idMueble=" +idMueble+ ",costo=" +costo+ ",usado=" +usado+"]";
	}
}