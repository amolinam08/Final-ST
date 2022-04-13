package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Productoconsumo implements VOProductoconsumo{
	public Long idProducto;
	public Long idConsumo;
	
	public Productoconsumo(){
		this.idProducto=0L;
		this.idConsumo=0L;
		}
	
	public Productoconsumo(Long idProducto,Long idConsumo){
		this.idProducto=idProducto;
		this.idConsumo=idConsumo;
		}
	public Long getIdProducto(){
		return this.idProducto;
	}
	public void setIdProducto(Long idProducto){
		 this.idProducto=idProducto;
	}
	public Long getIdConsumo(){
		return this.idConsumo;
	}
	public void setIdConsumo(Long idConsumo){
		 this.idConsumo=idConsumo;
	}
	@Override
	public String toString()
	{
	return "Productoconsumo [idProducto=" +idProducto+ ",idConsumo=" +idConsumo+"]";
	}
}