package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Hotelusuario implements VOHotelusuario{
	public Long idHotel;
	public Long idUsuario;
	
	public Hotelusuario(){
		this.idHotel=0L;
		this.idUsuario=0L;
		}
	
	public Hotelusuario(Long idHotel,Long idUsuario){
		this.idHotel=idHotel;
		this.idUsuario=idUsuario;
		}
	public Long getIdHotel(){
		return this.idHotel;
	}
	public void setIdHotel(Long idHotel){
		 this.idHotel=idHotel;
	}
	public Long getIdUsuario(){
		return this.idUsuario;
	}
	public void setIdUsuario(Long idUsuario){
		 this.idUsuario=idUsuario;
	}
	@Override
	public String toString()
	{
	return "Hotelusuario [idHotel=" +idHotel+ ",idUsuario=" +idUsuario+"]";
	}
}