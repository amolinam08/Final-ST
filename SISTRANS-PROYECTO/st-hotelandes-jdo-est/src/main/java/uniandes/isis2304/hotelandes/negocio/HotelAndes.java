/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: HotelAndes Uniandes
 * @version 1.0
 * @author Germán Bravo
 * Julio de 2018
 * 
 * Revisado por: Claudia Jiménez, Christian Ariza
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.isis2304.hotelandes.negocio;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.JsonObject;

import org.apache.log4j.Logger;

import uniandes.isis2304.hotelandes.persistencia.PersistenciaHotelAndes;

/**
 * Clase principal del negocio
 * Sarisface todos los requerimientos funcionales del negocio
 *
 * @author Germán Bravo
 */
public class HotelAndes 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */

	private static Logger log = Logger.getLogger(HotelAndes.class.getName());
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia
	 */
	private PersistenciaHotelAndes pp;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * El constructor por defecto
	 */
	public HotelAndes ()
	{
		pp = PersistenciaHotelAndes.getInstance ();
	}
	
	/**
	 * El constructor qye recibe los nombres de las tablas en tableConfig
	 * @param tableConfig - Objeto Json con los nombres de las tablas y de la unidad de persistencia
	 */
	public HotelAndes (JsonObject tableConfig)
	{
		pp = PersistenciaHotelAndes.getInstance (tableConfig);
	}
	
	/**
	 * Cierra la conexión con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia ()
	{
		pp.cerrarUnidadPersistencia ();
	}
	
	public Reserva adicionarReservahabitacion(Timestamp diaHora,Long numPersonas,String planPago,Timestamp fechaSalida,String cliente,Long habitacion)
	{
		log.info ("Adicionando : Reservahabitacion" + habitacion + " al cliente con numero de cédula" + cliente);
		Reserva reservaHabitacion = pp.adicionarReservahabitacion(diaHora,numPersonas,planPago,fechaSalida,cliente,habitacion);
		log.info ("Se adicionó la Reserva de la habitación" + reservaHabitacion.getHabitacion()+" con cliente: "+reservaHabitacion.getCliente());
		return reservaHabitacion;
	}

	public List iniciarSesion(String nombreUsuario, String contraseña){
		log.info ("Iniciando sesión del usuario: " + nombreUsuario);
		List info = pp.iniciarSesion(nombreUsuario, contraseña);
		log.info ("Se retornó la información del usuario "+nombreUsuario);
		return info;
	}
	/* ****************************************************************
	 * 			RESERVA DE SALON CONFERENCIA
	 *****************************************************************/
	public Reserva adicionarReservaSalonConferencia(Timestamp diaHora,Long numPersonas,String planPago,Double duracion,String cliente,Long salonConferencia)
	{
		log.info ("Adicionando : ReservaSalonConferencia" + salonConferencia + " al cliente con numero de cédula" + cliente);
		Reserva reservaSalonConferencia = pp.adicionarReservaSalonConferencia(diaHora,numPersonas,planPago,duracion,cliente,salonConferencia);
		log.info ("Se adicionó la Reserva de la Salón de Conferencia" + reservaSalonConferencia.getServicio()+" con cliente: "+reservaSalonConferencia.getCliente());
		return reservaSalonConferencia;
	}
	
		
	/* ****************************************************************
	 * 			RESERVA DE SALON DE REUNION
	 *****************************************************************/
	public Reserva adicionarReservaSalonReunion(Timestamp diaHora,Long numPersonas,String planPago,Double duracion,String cliente,Long salonReunion)
	{
		log.info ("Adicionando : ReservaSalonReunion" + salonReunion + " al cliente con numero de cédula" + cliente);
		Reserva reservaSalonReunion = pp.adicionarReservaSalonReunion(diaHora,numPersonas,planPago,duracion,cliente,salonReunion);
		log.info ("Se adicionó la Reserva de la Salón de Reunión" + reservaSalonReunion.getServicio()+" con cliente: "+reservaSalonReunion.getCliente());
		return reservaSalonReunion;
	}
	/* ****************************************************************
	 * 			RESERVA DE SPA
	 *****************************************************************/
	public Reserva adicionarReservaServicioSPA(Timestamp diaHora,String planPago,Double duracion,String cliente,Long servicioSPA)
	{
		log.info ("Adicionando : ReservaServicioSPA" + servicioSPA + " al cliente con numero de cédula" + cliente);
		Reserva reservaServicioSPA = pp.adicionarReservaServicioSPA(diaHora,planPago,duracion,cliente,servicioSPA);
		log.info ("Se adicionó la Reserva de la Salón de Reunión" + reservaServicioSPA.getServicio()+" con cliente: "+reservaServicioSPA.getCliente());
		return reservaServicioSPA;
	}
	/*
	
	/* ****************************************************************
	 * 			RESIGRAR LLEGADA DE CLIENTE
	 *****************************************************************/
	public Reserva registrarLlegadaCliente(Long numeroReserva,String cliente)
	{
		log.info("Registrando llegada del cliente con numero de cédula" + cliente);
		Reserva reserva = pp.registrarLlegadaCliente(numeroReserva, cliente);
		
		log.info("Se registró la llegada del cliente con numero de cédula" + reserva.getCliente());
		return reserva;
	}
	//Registrar acompañante del cliente anterior :v
	public void registrarAcompanante(String tipoDocumento,String numeroDocumento,String correo,String nombre,String acompanante,String contrasena,Long reserva)
	{
		log.info("Registrando acompañante del cliente con numero de cédula" + acompanante);
		pp.registrarAcompanante(tipoDocumento,numeroDocumento,correo,nombre,acompanante,contrasena,reserva);
		log.info("Se registró el acompañante del cliente con numero de cédula" + acompanante);
	}

	public Consumo adicionarConsumoServicio(String cliente_acompanante, Long empleado, Long producto, Long servicio,
			String SiNo) {
		log.info("Adicionando un consumo del servicio " + servicio + " al cliente con numero de cédula"
				+ cliente_acompanante);
		Consumo consumo = pp.adicionarConsumoServicio(cliente_acompanante, empleado, producto, servicio, SiNo);
		if (SiNo.equals("Si")) {
			log.info("Se adicionó el consumo del servicio al registro " + consumo.getRegistroConsumo()
					+ " y a la cuenta con id" + consumo.getCuenta());
		} else {
			log.info("Se adicionó el consumo del servicio al registro " + consumo.getRegistroConsumo()
					+ " del servicio con id" + servicio);
		}
		return consumo;
	}

	public List registrarSalidaCliente(Long idReserva,String cliente ,Long idEmpleado)
	{
		log.info("Registrando salida del cliente con numero de cédula" + cliente);
		List reserva=pp.registrarSalidaCliente(idReserva,cliente , idEmpleado);
		log.info("Se registró la salida del cliente con numero de cédula" + cliente);
		return reserva;
	}
	
	/* ****************************************************************
						Métodos  para eventos
	*****************************************************************/
	public List<VOReserva> reservarAlojamientoYServiciosParaUnaConvencion(Long idConvencion, Long planPago,
			List<List<Reserva>> reservas) {
		log.info("Reservando alojamiento y servicios para una convencion");
		List<VOReserva> resp = pp.reservarAlojamientoYServiciosParaUnaConvencion(idConvencion, planPago, reservas);
		log.info("Reservando alojamiento y servicios para una convencion: Listo!");
		return resp;
	}
	/* ****************************************************************
						Métodos  para mantenimientos
	*****************************************************************/
	public VOServicio adicionarMantenimientoServicio(Long idServicio,Timestamp diaHoraMantenimientoInicial,Timestamp diaHoraMantenimientoFinal,String razon){
		log.info("Adicionando un mantenimiento al servicio " + idServicio);
		VOServicio resp = pp.adicionarMantenimientoServicio(idServicio, diaHoraMantenimientoInicial, diaHoraMantenimientoFinal, razon);
		log.info("Se adicionó el mantenimiento al servicio " + resp.getIdServicio());
		return resp;
		
	}
	public VOHabitacion adicionarMantenimientoHabitacion(Long idHabitacion, Timestamp diaHoraMantenimientoInicial,Timestamp diaHoraMantenimientoFinal,String razon)
	{
		log.info("Adicionando un mantenimiento a la habitacion " + idHabitacion);
		VOHabitacion resp = pp.adicionarMantenimientoHabitacion(idHabitacion, diaHoraMantenimientoInicial, diaHoraMantenimientoFinal, razon);
		log.info("Se adicionó el mantenimiento a la habitacion " + resp.getIdHabitacion());
		return resp;
		
	}
	public Mantenimiento eliminarMantenimientoServicio(Long Servicio)
	{
		log.info("Eliminando un mantenimiento al servicio " + Servicio);
		Mantenimiento resp = pp.eliminarMantenimientoServicio(Servicio);
		log.info("Se eliminó el mantenimiento al servicio " + resp.getServicio());
		return resp;
	}
	public Mantenimiento eliminarMantenimientoHabitacion(Long Habitacion)
	{
		log.info("Eliminando un mantenimiento a la habitacion " + Habitacion);
		Mantenimiento resp = pp.eliminarMantenimientoHabitacion(Habitacion);
		log.info("Se eliminó el mantenimiento a la habitacion " + resp.getHabitacion());
		return resp;
	}
	public long [] limpiarHotelAndes ()
	{
		log.info("Limpiando la BD de HotelAndes");
		long[] borrrados = pp.limpiarHotelAndes();
		log.info("Limpiando la BD de HotelAndes: Listo!");
		return borrrados;
	}
}
