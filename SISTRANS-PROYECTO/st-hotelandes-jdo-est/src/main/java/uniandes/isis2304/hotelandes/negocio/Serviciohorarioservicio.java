package uniandes.isis2304.hotelandes.negocio;

public class Serviciohorarioservicio implements VOServiciohorarioservicio{
	public Long idServicio;
	public Long idHorarioServicio;
	
	public Serviciohorarioservicio(){
		this.idServicio=0L;
		this.idHorarioServicio=0L;
		}
	
	public Serviciohorarioservicio(Long idServicio,Long idHorarioServicio){
		this.idServicio=idServicio;
		this.idHorarioServicio=idHorarioServicio;
		}
	public Long getIdServicio(){
		return this.idServicio;
	}
	public void setIdServicio(Long idServicio){
		 this.idServicio=idServicio;
	}
	public Long getIdHorarioServicio(){
		return this.idHorarioServicio;
	}
	public void setIdHorarioServicio(Long idHorarioServicio){
		 this.idHorarioServicio=idHorarioServicio;
	}
	@Override
	public String toString()
	{
	return "Serviciohorarioservicio [idServicio=" +idServicio+ ",idHorarioServicio=" +idHorarioServicio+"]";
	}
}