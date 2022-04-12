package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Cadenahotelera implements VOCadenahotelera{
	public Long idCadenaHotelera;
	public String nombre;
	
	public Cadenahotelera(){
		this.idCadenaHotelera=0L;
		this.nombre="";
		}
	
	public Cadenahotelera(Long idCadenaHotelera,String nombre){
		this.idCadenaHotelera=idCadenaHotelera;
		this.nombre=nombre;
		}
	public Long getIdCadenaHotelera(){
		return this.idCadenaHotelera;
	}
	public void setIdCadenaHotelera(Long idCadenaHotelera){
		 this.idCadenaHotelera=idCadenaHotelera;
	}
	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String nombre){
		 this.nombre=nombre;
	}
	@Override
	public String toString()
	{
	return "Cadenahotelera [idCadenaHotelera=" +idCadenaHotelera+ ",nombre=" +nombre+"]";
	}
}