package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Tipousuario implements VOTipousuario{
	public Long idTipoUsuario;
	public String ROL;
	
	public Tipousuario(){
		this.idTipoUsuario=0L;
		this.ROL="";
		}
	
	public Tipousuario(Long idTipoUsuario,String ROL){
		this.idTipoUsuario=idTipoUsuario;
		this.ROL=ROL;
		}
	public Long getIdTipoUsuario(){
		return this.idTipoUsuario;
	}
	public void setIdTipoUsuario(Long idTipoUsuario){
		 this.idTipoUsuario=idTipoUsuario;
	}
	public String getROL(){
		return this.ROL;
	}
	public void setROL(String ROL){
		 this.ROL=ROL;
	}
	@Override
	public String toString()
	{
	return "Tipousuario [idTipoUsuario=" +idTipoUsuario+ ",ROL=" +ROL+"]";
	}
}