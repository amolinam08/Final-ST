package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Hotel implements VOHotel{
	public Long idHotel;
	public String nombre;
	public Long CadenaHotelera;
	
	public Hotel(){
		this.idHotel=0L;
		this.nombre="";
		this.CadenaHotelera=0L;
		}
	
	public Hotel(Long idHotel,String nombre,Long CadenaHotelera){
		this.idHotel=idHotel;
		this.nombre=nombre;
		this.CadenaHotelera=CadenaHotelera;
		}
	public Long getIdHotel(){
		return this.idHotel;
	}
	public void setIdHotel(Long idHotel){
		 this.idHotel=idHotel;
	}
	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String nombre){
		 this.nombre=nombre;
	}
	public Long getCadenaHotelera(){
		return this.CadenaHotelera;
	}
	public void setCadenaHotelera(Long CadenaHotelera){
		 this.CadenaHotelera=CadenaHotelera;
	}
	@Override
	public String toString()
	{
	return "Hotel [idHotel=" +idHotel+ ",nombre=" +nombre+ ",CadenaHotelera=" +CadenaHotelera+"]";
	}
}