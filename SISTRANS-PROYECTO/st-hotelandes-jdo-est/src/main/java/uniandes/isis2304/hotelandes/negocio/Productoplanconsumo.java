package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Productoplanconsumo implements VOProductoplanconsumo{
	public Long idProducto;
	public Long idPlanConsumo;
	
	public Productoplanconsumo(){
		this.idProducto=0L;
		this.idPlanConsumo=0L;
		}
	
	public Productoplanconsumo(Long idProducto,Long idPlanConsumo){
		this.idProducto=idProducto;
		this.idPlanConsumo=idPlanConsumo;
		}
	public Long getIdProducto(){
		return this.idProducto;
	}
	public void setIdProducto(Long idProducto){
		 this.idProducto=idProducto;
	}
	public Long getIdPlanConsumo(){
		return this.idPlanConsumo;
	}
	public void setIdPlanConsumo(Long idPlanConsumo){
		 this.idPlanConsumo=idPlanConsumo;
	}
	@Override
	public String toString()
	{
	return "Productoplanconsumo [idProducto=" +idProducto+ ",idPlanConsumo=" +idPlanConsumo+"]";
	}
}