package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Cartaproductosproductos implements VOCartaproductosproductos{
	public Long idCarta;
	public Long idProducto;
	
	public Cartaproductosproductos(){
		this.idCarta=0L;
		this.idProducto=0L;
		}
	
	public Cartaproductosproductos(Long idCarta,Long idProducto){
		this.idCarta=idCarta;
		this.idProducto=idProducto;
		}
	public Long getIdCarta(){
		return this.idCarta;
	}
	public void setIdCarta(Long idCarta){
		 this.idCarta=idCarta;
	}
	public Long getIdProducto(){
		return this.idProducto;
	}
	public void setIdProducto(Long idProducto){
		 this.idProducto=idProducto;
	}
	@Override
	public String toString()
	{
	return "Cartaproductosproductos [idCarta=" +idCarta+ ",idProducto=" +idProducto+"]";
	}
}