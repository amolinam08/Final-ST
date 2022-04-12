package uniandes.isis2304.hotelandes.negocio;

public class Utensilio implements VOUtensilio{
	public Long idUtensilio;
	public String estado;
	public String entregado;
	
	public Utensilio(){
		this.idUtensilio=0L;
		this.estado="";
		this.entregado="";
		}
	
	public Utensilio(Long idUtensilio,String estado,String entregado){
		this.idUtensilio=idUtensilio;
		this.estado=estado;
		this.entregado=entregado;
		}
	public Long getIdUtensilio(){
		return this.idUtensilio;
	}
	public void setIdUtensilio(Long idUtensilio){
		 this.idUtensilio=idUtensilio;
	}
	public String getEstado(){
		return this.estado;
	}
	public void setEstado(String estado){
		 this.estado=estado;
	}
	public String getEntregado(){
		return this.entregado;
	}
	public void setEntregado(String entregado){
		 this.entregado=entregado;
	}
	@Override
	public String toString()
	{
	return "Utensilio [idUtensilio=" +idUtensilio+ ",estado=" +estado+ ",entregado=" +entregado+"]";
	}
}