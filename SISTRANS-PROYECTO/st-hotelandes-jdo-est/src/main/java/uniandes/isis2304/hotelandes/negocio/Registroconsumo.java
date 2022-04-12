package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Registroconsumo implements VORegistroconsumo{
	public Long idRegistroConsumo;
	
	public Registroconsumo(){
		this.idRegistroConsumo=0L;
		}
	
	public Registroconsumo(Long idRegistroConsumo){
		this.idRegistroConsumo=idRegistroConsumo;
		}
	public Long getIdRegistroConsumo(){
		return this.idRegistroConsumo;
	}
	public void setIdRegistroConsumo(Long idRegistroConsumo){
		 this.idRegistroConsumo=idRegistroConsumo;
	}
	@Override
	public String toString()
	{
	return "Registroconsumo [idRegistroConsumo=" +idRegistroConsumo+"]";
	}
}