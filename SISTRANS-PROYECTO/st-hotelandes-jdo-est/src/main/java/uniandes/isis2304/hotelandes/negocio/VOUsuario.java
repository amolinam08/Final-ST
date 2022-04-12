package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public interface VOUsuario
{
	public Long getIdUsuario();
	public String getPazSalvo();
	public String getTipoDocumento();
	public String getNumeroDocumento();
	public String getCorreo();
	public String getNombre();
	public Long getCuenta();
	public Long getTipoUsuario();
	public Long getAcompanante();
	public String getContrasena();
	@Override
	public String toString();

}