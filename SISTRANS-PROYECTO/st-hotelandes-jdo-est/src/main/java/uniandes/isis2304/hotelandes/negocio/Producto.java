package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Producto implements VOProducto{
	public Long idProducto;
	public String nombre;
	public Double costo;
	public Long consumo;
	
	public Producto(){
		this.idProducto=0L;
		this.nombre="";
		this.costo=0D;
		this.consumo=0L;
		}
	
	public Producto(Long idProducto,String nombre,Double costo,Long consumo){
		this.idProducto=idProducto;
		this.nombre=nombre;
		this.costo=costo;
		this.consumo=consumo;
		}
	public Long getIdProducto(){
		return this.idProducto;
	}
	public void setIdProducto(Long idProducto){
		 this.idProducto=idProducto;
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
	public Long getConsumo(){
		return this.consumo;
	}
	public void setConsumo(Long consumo){
		 this.consumo=consumo;
	}
	@Override
	public String toString()
	{
	return "Producto [idProducto=" +idProducto+ ",nombre=" +nombre+ ",costo=" +costo+ ",consumo=" +consumo+"]";
	}
}