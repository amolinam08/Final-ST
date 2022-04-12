package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Usuario implements VOUsuario{
	public Long idUsuario;
	public String pazSalvo;
	public String tipoDocumento;
	public String numeroDocumento;
	public String correo;
	public String nombre;
	public Long cuenta;
	public Long tipoUsuario;
	public Long acompanante;
	public String contrasena;
	
	public Usuario(){
		this.idUsuario=0L;
		this.pazSalvo="";
		this.tipoDocumento="";
		this.numeroDocumento="";
		this.correo="";
		this.nombre="";
		this.cuenta=0L;
		this.tipoUsuario=0L;
		this.acompanante=0L;
		this.contrasena="";
		}
	
	public Usuario(Long idUsuario,String pazSalvo,String tipoDocumento,String numeroDocumento,String correo,String nombre,Long cuenta,Long tipoUsuario,Long acompanante,String contrasena){
		this.idUsuario=idUsuario;
		this.pazSalvo=pazSalvo;
		this.tipoDocumento=tipoDocumento;
		this.numeroDocumento=numeroDocumento;
		this.correo=correo;
		this.nombre=nombre;
		this.cuenta=cuenta;
		this.tipoUsuario=tipoUsuario;
		this.acompanante=acompanante;
		this.contrasena=contrasena;
		}
	public Long getIdUsuario(){
		return this.idUsuario;
	}
	public void setIdUsuario(Long idUsuario){
		 this.idUsuario=idUsuario;
	}
	public String getPazSalvo(){
		return this.pazSalvo;
	}
	public void setPazSalvo(String pazSalvo){
		 this.pazSalvo=pazSalvo;
	}
	public String getTipoDocumento(){
		return this.tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento){
		 this.tipoDocumento=tipoDocumento;
	}
	public String getNumeroDocumento(){
		return this.numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento){
		 this.numeroDocumento=numeroDocumento;
	}
	public String getCorreo(){
		return this.correo;
	}
	public void setCorreo(String correo){
		 this.correo=correo;
	}
	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String nombre){
		 this.nombre=nombre;
	}
	public Long getCuenta(){
		return this.cuenta;
	}
	public void setCuenta(Long cuenta){
		 this.cuenta=cuenta;
	}
	public Long getTipoUsuario(){
		return this.tipoUsuario;
	}
	public void setTipoUsuario(Long tipoUsuario){
		 this.tipoUsuario=tipoUsuario;
	}
	public Long getAcompanante(){
		return this.acompanante;
	}
	public void setAcompanante(Long acompanante){
		 this.acompanante=acompanante;
	}
	public String getContrasena(){
		return this.contrasena;
	}
	public void setContrasena(String contrasena){
		 this.contrasena=contrasena;
	}
	@Override
	public String toString()
	{
	return "Usuario [idUsuario=" +idUsuario+ ",pazSalvo=" +pazSalvo+ ",tipoDocumento=" +tipoDocumento+ ",numeroDocumento=" +numeroDocumento+ ",correo=" +correo+ ",nombre=" +nombre+ ",cuenta=" +cuenta+ ",tipoUsuario=" +tipoUsuario+ ",acompanante=" +acompanante+ ",contrasena=" +contrasena+"]";
	}
}