package uniandes.isis2304.hotelandes.negocio;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
public class Horarioservicio implements VOHorarioservicio{
	public Long idHorarioServicio;
	public Timestamp horaInicio;
	public Double duracion;
	
	public Horarioservicio(){
		this.idHorarioServicio=0L;
		this.horaInicio=new Timestamp (0);
		this.duracion=0D;
		}
	
	public Horarioservicio(Long idHorarioServicio,Timestamp horaInicio,Double duracion){
		this.idHorarioServicio=idHorarioServicio;
		this.horaInicio=horaInicio;
		this.duracion=duracion;
		}
	public Long getIdHorarioServicio(){
		return this.idHorarioServicio;
	}
	public void setIdHorarioServicio(Long idHorarioServicio){
		 this.idHorarioServicio=idHorarioServicio;
	}
	public Timestamp getHoraInicio(){
		return this.horaInicio;
	}
	public void setHoraInicio(Timestamp horaInicio){
		 this.horaInicio=horaInicio;
	}
	public Double getDuracion(){
		return this.duracion;
	}
	public void setDuracion(Double duracion){
		 this.duracion=duracion;
	}
	@Override
	public String toString()
	{
	return "Horarioservicio [idHorarioServicio=" +idHorarioServicio+ ",horaInicio=" +horaInicio+ ",duracion=" +duracion+"]";
	}
}