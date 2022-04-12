package uniandes.isis2304.hotelandes.negocio;

public class Usuarioplanconsumo implements VOUsuarioplanconsumo{
	public Long idUsuario;
	public Long idPlanConsumo;
	
	public Usuarioplanconsumo(){
		this.idUsuario=0L;
		this.idPlanConsumo=0L;
		}
	
	public Usuarioplanconsumo(Long idUsuario,Long idPlanConsumo){
		this.idUsuario=idUsuario;
		this.idPlanConsumo=idPlanConsumo;
		}
	public Long getIdUsuario(){
		return this.idUsuario;
	}
	public void setIdUsuario(Long idUsuario){
		 this.idUsuario=idUsuario;
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
	return "Usuarioplanconsumo [idUsuario=" +idUsuario+ ",idPlanConsumo=" +idPlanConsumo+"]";
	}
}