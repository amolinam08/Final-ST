package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Servicio implements VOServicio{
	public Long idServicio;
	public Long capacidad;
	public String nombre;
	public Long capacidad_actual;
	public Long cartaProductos;
	public Long registroConsumo;
	public Long hotel;
	public Long tipoCobro;
	public Long estilo;
	public Long HorarioServicio;
	public Long ofertaServicio;
	public Double profundidad;
	
	public Servicio(){
		this.idServicio=0L;
		this.capacidad=0L;
		this.nombre="";
		this.capacidad_actual=0L;
		this.cartaProductos=0L;
		this.registroConsumo=0L;
		this.hotel=0L;
		this.tipoCobro=0L;
		this.estilo=0L;
		this.HorarioServicio=0L;
		this.ofertaServicio=0L;
		this.profundidad=0D;
		}
	
	public Servicio(Long idServicio,Long capacidad,String nombre,Long capacidad_actual,Long cartaProductos,Long registroConsumo,Long hotel,Long tipoCobro,Long estilo,Long HorarioServicio,Long ofertaServicio,Double profundidad){
		this.idServicio=idServicio;
		this.capacidad=capacidad;
		this.nombre=nombre;
		this.capacidad_actual=capacidad_actual;
		this.cartaProductos=cartaProductos;
		this.registroConsumo=registroConsumo;
		this.hotel=hotel;
		this.tipoCobro=tipoCobro;
		this.estilo=estilo;
		this.HorarioServicio=HorarioServicio;
		this.ofertaServicio=ofertaServicio;
		this.profundidad=profundidad;
		}
	public Long getIdServicio(){
		return this.idServicio;
	}
	public void setIdServicio(Long idServicio){
		 this.idServicio=idServicio;
	}
	public Long getCapacidad(){
		return this.capacidad;
	}
	public void setCapacidad(Long capacidad){
		 this.capacidad=capacidad;
	}
	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String nombre){
		 this.nombre=nombre;
	}
	public Long getCapacidad_actual(){
		return this.capacidad_actual;
	}
	public void setCapacidad_actual(Long capacidad_actual){
		 this.capacidad_actual=capacidad_actual;
	}
	public Long getCartaProductos(){
		return this.cartaProductos;
	}
	public void setCartaProductos(Long cartaProductos){
		 this.cartaProductos=cartaProductos;
	}
	public Long getRegistroConsumo(){
		return this.registroConsumo;
	}
	public void setRegistroConsumo(Long registroConsumo){
		 this.registroConsumo=registroConsumo;
	}
	public Long getHotel(){
		return this.hotel;
	}
	public void setHotel(Long hotel){
		 this.hotel=hotel;
	}
	public Long getTipoCobro(){
		return this.tipoCobro;
	}
	public void setTipoCobro(Long tipoCobro){
		 this.tipoCobro=tipoCobro;
	}
	public Long getEstilo(){
		return this.estilo;
	}
	public void setEstilo(Long estilo){
		 this.estilo=estilo;
	}
	public Long getHorarioServicio(){
		return this.HorarioServicio;
	}
	public void setHorarioServicio(Long HorarioServicio){
		 this.HorarioServicio=HorarioServicio;
	}
	public Long getOfertaServicio(){
		return this.ofertaServicio;
	}
	public void setOfertaServicio(Long ofertaServicio){
		 this.ofertaServicio=ofertaServicio;
	}
	public Double getProfundidad(){
		return this.profundidad;
	}
	public void setProfundidad(Double profundidad){
		 this.profundidad=profundidad;
	}
	@Override
	public String toString()
	{
	return "Servicio [idServicio=" +idServicio+ ",capacidad=" +capacidad+ ",nombre=" +nombre+ ",capacidad_actual=" +capacidad_actual+ ",cartaProductos=" +cartaProductos+ ",registroConsumo=" +registroConsumo+ ",hotel=" +hotel+ ",tipoCobro=" +tipoCobro+ ",estilo=" +estilo+ ",HorarioServicio=" +HorarioServicio+ ",ofertaServicio=" +ofertaServicio+ ",profundidad=" +profundidad+"]";
	}
}