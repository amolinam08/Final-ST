package uniandes.isis2304.hotelandes.negocio;

public class Prenda implements VOPrenda{
	public Long idPrenda;
	public String tipoPrenda;
	public Double costoLavado;
	public Long cliente;
	
	public Prenda(){
		this.idPrenda=0L;
		this.tipoPrenda="";
		this.costoLavado=0D;
		this.cliente=0L;
		}
	
	public Prenda(Long idPrenda,String tipoPrenda,Double costoLavado,Long cliente){
		this.idPrenda=idPrenda;
		this.tipoPrenda=tipoPrenda;
		this.costoLavado=costoLavado;
		this.cliente=cliente;
		}
	public Long getIdPrenda(){
		return this.idPrenda;
	}
	public void setIdPrenda(Long idPrenda){
		 this.idPrenda=idPrenda;
	}
	public String getTipoPrenda(){
		return this.tipoPrenda;
	}
	public void setTipoPrenda(String tipoPrenda){
		 this.tipoPrenda=tipoPrenda;
	}
	public Double getCostoLavado(){
		return this.costoLavado;
	}
	public void setCostoLavado(Double costoLavado){
		 this.costoLavado=costoLavado;
	}
	public Long getCliente(){
		return this.cliente;
	}
	public void setCliente(Long cliente){
		 this.cliente=cliente;
	}
	@Override
	public String toString()
	{
	return "Prenda [idPrenda=" +idPrenda+ ",tipoPrenda=" +tipoPrenda+ ",costoLavado=" +costoLavado+ ",cliente=" +cliente+"]";
	}
}