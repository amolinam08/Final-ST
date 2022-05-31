/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: HotelAndes Uniandes
 * @version 1.0
 * @author 
 * Julio de 2018
 * 
 * Revisado por: Claudia Jiménez, Christian Ariza
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.isis2304.hotelandes.persistencia;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.apache.log4j.Logger;

import uniandes.isis2304.hotelandes.negocio.Cartaproductos;
import uniandes.isis2304.hotelandes.negocio.Cartaproductosproductos;
import uniandes.isis2304.hotelandes.negocio.Consumo;
import uniandes.isis2304.hotelandes.negocio.Consumoproducto;
import uniandes.isis2304.hotelandes.negocio.Convencion;
import uniandes.isis2304.hotelandes.negocio.Convencionreserva;
import uniandes.isis2304.hotelandes.negocio.Cuenta;
import uniandes.isis2304.hotelandes.negocio.Habitacion;
import uniandes.isis2304.hotelandes.negocio.Mantenimiento;
import uniandes.isis2304.hotelandes.negocio.Producto;
import uniandes.isis2304.hotelandes.negocio.Reserva;
import uniandes.isis2304.hotelandes.negocio.Servicio;
import uniandes.isis2304.hotelandes.negocio.Servicioprestamo;
import uniandes.isis2304.hotelandes.negocio.Usuario;
import uniandes.isis2304.hotelandes.negocio.VOReserva;

/**
 * Clase para el manejador de persistencia del proyecto HotelAndes
 * Traduce la información entre objetos Java y tuplas de la base de datos, en
 * ambos sentidos
 * Sigue un patrón SINGLETON (Sólo puede haber UN objeto de esta clase) para
 * comunicarse de manera correcta
 * con la base de datos
 * Se apoya en las clases SQLBar, SQLBebedor, SQLBebida, SQLGustan, SQLSirven,
 * SQLTipoBebida y SQLVisitan, que son
 * las que realizan el acceso a la base de datos
 * 
 * @author
 */
public class PersistenciaHotelAndes {
	/*
	 * ****************************************************************
	 * Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(PersistenciaHotelAndes.class.getName());

	/**
	 * Cadena para indicar el tipo de sentencias que se va a utilizar en una
	 * consulta
	 */
	public final static String SQL = "javax.jdo.query.SQL";

	/*
	 * ****************************************************************
	 * Atributos
	 *****************************************************************/
	/**
	 * Atributo privado que es el único objeto de la clase - Patrón SINGLETON
	 */
	private static PersistenciaHotelAndes instance;

	/**
	 * Fábrica de Manejadores de persistencia, para el manejo correcto de las
	 * transacciones
	 */
	private PersistenceManagerFactory pmf;

	/**
	 * Arreglo de cadenas con los nombres de las tablas de la base de datos, en su
	 * orden:
	 * Secuenciador, tipoBebida, bebida, bar, bebedor, gustan, sirven y visitan
	 */
	private List<String> tablas;
	private SQLCuenta SQLcuenta;
	private SQLUsuario SQLusuario;
	private SQLPrenda SQLprenda;
	private SQLReserva SQLreserva;
	private SQLHabitacion SQLhabitacion;
	private SQLMueble SQLmueble;
	private SQLConsumoconmueble SQLconsumoconmueble;
	private SQLConsumo SQLconsumo;
	private SQLTipohabitacion SQLtipohabitacion;
	private SQLTipousuario SQLtipousuario;
	private SQLHotel SQLhotel;
	private SQLCadenahotelera SQLcadenahotelera;
	private SQLOfertaservicio SQLofertaservicio;
	private SQLRegistroconsumo SQLregistroconsumo;
	private SQLUtensilio SQLutensilio;
	private SQLProducto SQLproducto;
	private SQLServicioprestamo SQLservicioprestamo;
	private SQLServicio SQLservicio;
	private SQLConvencion SQLconvencion;
	private SQLOferta SQLoferta;
	private SQLPlancobro SQLplancobro;
	private SQLCartaproductos SQLcartaproductos;
	private SQLEstilo SQLestilo;
	private SQLHorarioservicio SQLhorarioservicio;
	private SQLCostoadicional SQLcostoadicional;
	private SQLTipocobro SQLtipocobro;
	private SQLPlanconsumo SQLplanconsumo;
	private SQLRestricciones SQLrestricciones;
	private SQLServicioprestamoutensilio SQLservicioprestamoutensilio;
	private SQLProductoplanconsumo SQLproductoplanconsumo;
	private SQLCartaproductosproductos SQLcartaproductosproductos;
	private SQLServiciohorarioservicio SQLserviciohorarioservicio;
	private SQLConsumoofertaservicio SQLconsumoofertaservicio;
	private SQLConsumomuebleconconsumo SQLconsumomuebleconconsumo;
	private SQLPlanconsumoservicio SQLplanconsumoservicio;
	private SQLHotelusuario SQLhotelusuario;
	private SQLPlanconsumorestricciones SQLplanconsumorestricciones;
	private SQLUsuarioplanconsumo SQLusuarioplanconsumo;
	private SQLHotelplanconsumo SQLhotelplanconsumo;
	private SQLConsumocostoadicional SQLconsumocostoadicional;
	private SQLConsumoproducto SQLconsumoproducto;
	private SQLMantenimiento SQLmantenimiento;
	private SQLConvencionreserva SQLconvencionreserva;
	/**
	 * Atributo para el acceso a las sentencias SQL propias a PersistenciaHotelAndes
	 */
	private SQLUtil sqlUtil;

	/*
	 * ****************************************************************
	 * Métodos del MANEJADOR DE PERSISTENCIA
	 *****************************************************************/

	/**
	 * Constructor privado con valores por defecto - Patrón SINGLETON
	 */
	private PersistenciaHotelAndes() {
		pmf = JDOHelper.getPersistenceManagerFactory("HotelAndes");
		crearClasesSQL();
		// Define los nombres por defecto de las tablas de la base de datos
		tablas = new LinkedList<String>();
	}

	/**
	 * Constructor privado, que recibe los nombres de las tablas en un objeto Json -
	 * Patrón SINGLETON
	 * 
	 * @param tableConfig - Objeto Json que contiene los nombres de las tablas y de
	 *                    la unidad de persistencia a manejar
	 */
	private PersistenciaHotelAndes(JsonObject tableConfig) {
		crearClasesSQL();
		tablas = leerNombresTablas(tableConfig);

		String unidadPersistencia = tableConfig.get("unidadPersistencia").getAsString();
		log.trace("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory(unidadPersistencia);
	}

	/**
	 * @return Retorna el único objeto PersistenciaHotelAndes existente - Patrón
	 *         SINGLETON
	 */
	public static PersistenciaHotelAndes getInstance() {
		if (instance == null) {
			instance = new PersistenciaHotelAndes();
		}
		return instance;
	}

	/**
	 * Constructor que toma los nombres de las tablas de la base de datos del objeto
	 * tableConfig
	 * 
	 * @param tableConfig - El objeto JSON con los nombres de las tablas
	 * @return Retorna el único objeto PersistenciaHotelAndes existente - Patrón
	 *         SINGLETON
	 */
	public static PersistenciaHotelAndes getInstance(JsonObject tableConfig) {
		if (instance == null) {
			instance = new PersistenciaHotelAndes(tableConfig);
		}
		return instance;
	}

	/**
	 * Cierra la conexión con la base de datos
	 */
	public void cerrarUnidadPersistencia() {
		pmf.close();
		instance = null;
	}

	/**
	 * Genera una lista con los nombres de las tablas de la base de datos
	 * 
	 * @param tableConfig - El objeto Json con los nombres de las tablas
	 * @return La lista con los nombres del secuenciador y de las tablas
	 */
	private List<String> leerNombresTablas(JsonObject tableConfig) {
		JsonArray nombres = tableConfig.getAsJsonArray("tablas");

		List<String> resp = new LinkedList<String>();
		for (JsonElement nom : nombres) {
			resp.add(nom.getAsString());
		}

		return resp;
	}

	/**
	 * Crea los atributos de clases de apoyo SQL
	 */
	private void crearClasesSQL() {
		sqlUtil = new SQLUtil(this);
		SQLcuenta = new SQLCuenta(this);
		SQLusuario = new SQLUsuario(this);
		SQLprenda = new SQLPrenda(this);
		SQLreserva = new SQLReserva(this);
		SQLhabitacion = new SQLHabitacion(this);
		SQLmueble = new SQLMueble(this);
		SQLconsumoconmueble = new SQLConsumoconmueble(this);
		SQLconsumo = new SQLConsumo(this);
		SQLtipohabitacion = new SQLTipohabitacion(this);
		SQLtipousuario = new SQLTipousuario(this);
		SQLhotel = new SQLHotel(this);
		SQLcadenahotelera = new SQLCadenahotelera(this);
		SQLofertaservicio = new SQLOfertaservicio(this);
		SQLregistroconsumo = new SQLRegistroconsumo(this);
		SQLutensilio = new SQLUtensilio(this);
		SQLproducto = new SQLProducto(this);
		SQLservicioprestamo = new SQLServicioprestamo(this);
		SQLservicio = new SQLServicio(this);
		SQLconvencion = new SQLConvencion(this);
		SQLoferta = new SQLOferta(this);
		SQLplancobro = new SQLPlancobro(this);
		SQLcartaproductos = new SQLCartaproductos(this);
		SQLestilo = new SQLEstilo(this);
		SQLhorarioservicio = new SQLHorarioservicio(this);
		SQLcostoadicional = new SQLCostoadicional(this);
		SQLtipocobro = new SQLTipocobro(this);
		SQLplanconsumo = new SQLPlanconsumo(this);
		SQLrestricciones = new SQLRestricciones(this);
		SQLservicioprestamoutensilio = new SQLServicioprestamoutensilio(this);
		SQLproductoplanconsumo = new SQLProductoplanconsumo(this);
		SQLcartaproductosproductos = new SQLCartaproductosproductos(this);
		SQLserviciohorarioservicio = new SQLServiciohorarioservicio(this);
		SQLconsumoofertaservicio = new SQLConsumoofertaservicio(this);
		SQLconsumomuebleconconsumo = new SQLConsumomuebleconconsumo(this);
		SQLplanconsumoservicio = new SQLPlanconsumoservicio(this);
		SQLhotelusuario = new SQLHotelusuario(this);
		SQLplanconsumorestricciones = new SQLPlanconsumorestricciones(this);
		SQLusuarioplanconsumo = new SQLUsuarioplanconsumo(this);
		SQLhotelplanconsumo = new SQLHotelplanconsumo(this);
		SQLconsumocostoadicional = new SQLConsumocostoadicional(this);
		SQLconsumoproducto = new SQLConsumoproducto(this);
		SQLmantenimiento = new SQLMantenimiento(this);
		SQLconvencionreserva = new SQLConvencionreserva(this);
	}

	/**
	 * @return La cadena de caracteres con el nombre del secuenciador de hotelandes
	 */
	public String darSeqHotelAndes() {
		return tablas.get(0);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de TipoBebida de
	 *         hotelandes
	 */

	public String darTablaCuenta() {
		return tablas.get(8);
	}

	public String darTablaUsuario() {
		return tablas.get(9);
	}

	public String darTablaPrenda() {
		return tablas.get(10);
	}

	public String darTablaReserva() {
		return tablas.get(11);
	}

	public String darTablaHabitacion() {
		return tablas.get(12);
	}

	public String darTablaMueble() {
		return tablas.get(13);
	}

	public String darTablaConsumoconmueble() {
		return tablas.get(14);
	}

	public String darTablaConsumo() {
		return tablas.get(15);
	}

	public String darTablaTipohabitacion() {
		return tablas.get(16);
	}

	public String darTablaTipousuario() {
		return tablas.get(17);
	}

	public String darTablaHotel() {
		return tablas.get(18);
	}

	public String darTablaCadenahotelera() {
		return tablas.get(19);
	}

	public String darTablaOfertaservicio() {
		return tablas.get(20);
	}

	public String darTablaRegistroconsumo() {
		return tablas.get(21);
	}

	public String darTablaUtensilio() {
		return tablas.get(22);
	}

	public String darTablaProducto() {
		return tablas.get(23);
	}

	public String darTablaServicioprestamo() {
		return tablas.get(24);
	}

	public String darTablaServicio() {
		return tablas.get(25);
	}

	public String darTablaConvencion() {
		return tablas.get(26);
	}

	public String darTablaOferta() {
		return tablas.get(27);
	}

	public String darTablaPlancobro() {
		return tablas.get(28);
	}

	public String darTablaCartaproductos() {
		return tablas.get(29);
	}

	public String darTablaEstilo() {
		return tablas.get(30);
	}

	public String darTablaHorarioservicio() {
		return tablas.get(31);
	}

	public String darTablaCostoadicional() {
		return tablas.get(32);
	}

	public String darTablaTipocobro() {
		return tablas.get(33);
	}

	public String darTablaPlanconsumo() {
		return tablas.get(34);
	}

	public String darTablaRestricciones() {
		return tablas.get(35);
	}

	public String darTablaServicioprestamoutensilio() {
		return tablas.get(36);
	}

	public String darTablaProductoplanconsumo() {
		return tablas.get(37);
	}

	public String darTablaCartaproductosproductos() {
		return tablas.get(38);
	}

	public String darTablaServiciohorarioservicio() {
		return tablas.get(39);
	}

	public String darTablaConsumoofertaservicio() {
		return tablas.get(40);
	}

	public String darTablaConsumomuebleconconsumo() {
		return tablas.get(41);
	}

	public String darTablaPlanconsumoservicio() {
		return tablas.get(42);
	}

	public String darTablaHotelusuario() {
		return tablas.get(43);
	}

	public String darTablaPlanconsumorestricciones() {
		return tablas.get(44);
	}

	public String darTablaUsuarioplanconsumo() {
		return tablas.get(45);
	}

	public String darTablaHotelplanconsumo() {
		return tablas.get(46);
	}

	public String darTablaConsumocostoadicional() {
		return tablas.get(47);
	}

	public String darTablaConsumoproducto() {
		return tablas.get(48);
	}

	public String darTablaMantenimiento() {
		return tablas.get(49);
	}

	public String darTablaConvencionreserva() {
		return tablas.get(50);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bebida de
	 *         hotelandes
	 */

	public String darTablaBebida() {
		return tablas.get(2);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bar de
	 *         hotelandes
	 */
	public String darTablaBar() {
		return tablas.get(3);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bebedor de
	 *         hotelandes
	 */
	public String darTablaBebedor() {
		return tablas.get(4);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Gustan de
	 *         hotelandes
	 */
	public String darTablaGustan() {
		return tablas.get(5);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Sirven de
	 *         hotelandes
	 */
	public String darTablaSirven() {
		return tablas.get(6);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de
	 *         hotelandes
	 */
	public String darTablaVisitan() {
		return tablas.get(7);
	}

	/**
	 * Transacción para el generador de secuencia de HotelAndes
	 * Adiciona entradas al log de la aplicación
	 * 
	 * @return El siguiente número del secuenciador de HotelAndes
	 */
	private long nextval() {
		long resp = sqlUtil.nextval(pmf.getPersistenceManager());
		log.trace("Generando secuencia: " + resp);
		return resp;
	}

	public List<Object> iniciarSesion(String nombre, String contraseña) {
		Usuario usuario = null;
		List retorno = new ArrayList<Object>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			usuario = SQLusuario.darPorCorreoContrasena(pm, nombre, contraseña).get(0);
			String Rol = SQLtipousuario.darTipousuarioPorId(pm, usuario.getTipoUsuario()).getROL();
			retorno.add(usuario);
			retorno.add(Rol);
			
			tx.commit();
		} catch (Exception e) {
			log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			e.printStackTrace();
			return retorno;
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return retorno;
	}

	/**
	 * Extrae el mensaje de la exception JDODataStoreException embebido en la
	 * Exception e, que da el detalle específico del problema encontrado
	 * 
	 * @param e - La excepción que ocurrio
	 * @return El mensaje de la excepción JDO
	 */
	private String darDetalleException(Exception e) {
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException")) {
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions()[0].getMessage();
		}
		return resp;
	}

	/*
	 * ****************************************************************
	 * RESERVA DE SALON CONFERENCIA
	 *****************************************************************/
	public Reserva adicionarReservaSalonConferencia(Timestamp diaHora, Long numPersonas, String planPago,
			Double duracion, String cliente, Long salonConferencia) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			List<Reserva> reservas = (List<Reserva>) SQLreserva.darReservas(pm);
			Usuario usuario = SQLusuario.darUsuarioPorNumerodocumento(pm, cliente).get(0);
			if (reservas != null) {
				for (Reserva reserva : reservas) {
					// TODO aquí se colocan las restricciones de que no puede sobrepasar 2 horas y
					// el tiempo de limpieza entre reserva.
					if (reserva.getServicio() != null) {
						if (reserva.getServicio() == salonConferencia) {
							double inicioEnMS = diaHora.getTime();
							double finalEnMS = diaHora.getTime() + (duracion / 3600000);
							double inicioEnMSreserva = reserva.getDiaHora().getTime();
							double finalEnMSReserva = reserva.getDiaHora().getTime()
									+ (reserva.getDuracion() / 3600000);
							if (!((inicioEnMS < inicioEnMSreserva && finalEnMS < inicioEnMSreserva)
									|| (inicioEnMS > finalEnMSReserva && finalEnMS > finalEnMSReserva))) {
								throw new Exception("El cuarto está reservado en ese horario");
							}
						}
					}

				}
			}
			Servicio salon = SQLservicio.darServicioPorId(pm, salonConferencia);
			if (salon.getNombre().equals("salon de conferencia")) {
				if (salon.getCapacidad() < numPersonas) {
					throw new Exception("El numero de personas es mayor a la capacidad del salon");
				}
			} else {
				throw new Exception("El servicio no es de tipo salon de conferencia");
			}
			Long secuenceNext = nextval();
			long tuplasInsertadas = SQLreserva.adicionarReserva(pm, secuenceNext, diaHora, duracion, "N", numPersonas,
					planPago, null, usuario.getIdUsuario(), null, salonConferencia, null);
			tx.commit();
			log.trace("Inserción de reserva de Cliente con id " + secuenceNext + ": " + tuplasInsertadas
					+ " tuplas insertadas");
			return new Reserva(secuenceNext, diaHora, duracion, "N", numPersonas, planPago, null,
					usuario.getIdUsuario(), null, salonConferencia, null);
		} catch (Exception e) {
			// e.printStackTrace();
			log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	/*
	 * ****************************************************************
	 * RESERVA DE SALON DE REUNION
	 *****************************************************************/
	public Reserva adicionarReservaSalonReunion(Timestamp diaHora, Long numPersonas, String planPago, Double duracion,
			String cliente, Long salonReunion) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			List<Reserva> reservas = (List<Reserva>) SQLreserva.darReservas(pm);
			Usuario usuario = SQLusuario.darUsuarioPorNumerodocumento(pm, cliente).get(0);
			if (reservas != null) {
				for (Reserva reserva : reservas) {
					// TODO aquí se colocan las restricciones de que no puede sobrepasar 2 horas y
					// el tiempo de limpieza entre reserva.
					if (reserva.getServicio() != null) {
						if (reserva.getServicio() == salonReunion) {
							double inicioEnMS = diaHora.getTime();
							double finalEnMS = diaHora.getTime() + (duracion / 3600000);
							double inicioEnMSreserva = reserva.getDiaHora().getTime();
							double finalEnMSReserva = reserva.getDiaHora().getTime()
									+ (reserva.getDuracion() / 3600000);
							if (!((inicioEnMS < inicioEnMSreserva && finalEnMS < inicioEnMSreserva)
									|| (inicioEnMS > finalEnMSReserva && finalEnMS > finalEnMSReserva))) {
								throw new Exception("El cuarto está reservado en ese horario");
							}
						}
					}

				}
			}
			Servicio salon = SQLservicio.darServicioPorId(pm, salonReunion);
			if (salon.getNombre().equals("salon de reunion")) {
				if (salon.getCapacidad() < numPersonas) {
					throw new Exception("El numero de personas es mayor a la capacidad del salon");
				}
			} else {
				throw new Exception("El servicio no es de tipo salon de reunion");
			}

			Long secuenceNext = nextval();
			long tuplasInsertadas = SQLreserva.adicionarReserva(pm, secuenceNext, diaHora, duracion, "N", numPersonas,
					planPago, null, usuario.getIdUsuario(), null, salonReunion, null);
			tx.commit();
			log.trace("Inserción de reserva de Cliente con id " + secuenceNext + ": " + tuplasInsertadas
					+ " tuplas insertadas");
			return new Reserva(secuenceNext, diaHora, duracion, "N", numPersonas, planPago, null,
					usuario.getIdUsuario(), null, salonReunion, null);
		} catch (Exception e) {
			// e.printStackTrace();
			log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return null;
	}

	// /* ****************************************************************
	// * RESERVA DE SPA
	// *****************************************************************/
	public Reserva adicionarReservaServicioSPA(Timestamp diaHora, String planPago, Double duracion, String cliente,
			Long servicioSPA) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			List<Reserva> reservas = (List<Reserva>) SQLreserva.darReservas(pm);
			Usuario usuario = SQLusuario.darUsuarioPorNumerodocumento(pm, cliente).get(0);
			if (reservas != null) {
				for (Reserva reserva : reservas) {
					// TODO aquí se colocan las restricciones de que no puede sobrepasar 2 horas y
					// el tiempo de limpieza entre reserva.
					if (reserva.getOfertaServicio() != null) {
						if (reserva.getOfertaServicio() == servicioSPA) {
							double inicioEnMS = diaHora.getTime();
							double finalEnMS = diaHora.getTime() + (duracion / 3600000);
							double inicioEnMSreserva = reserva.getDiaHora().getTime();
							double finalEnMSReserva = reserva.getDiaHora().getTime()
									+ (reserva.getDuracion() / 3600000);
							if (!((inicioEnMS < inicioEnMSreserva && finalEnMS < inicioEnMSreserva)
									|| (inicioEnMS > finalEnMSReserva && finalEnMS > finalEnMSReserva))) {
								throw new Exception("El servicio está reservado en ese horario");
							}
						}
					}
				}
			}

			Long secuenceNext = nextval();
			long tuplasInsertadas = SQLreserva.adicionarReserva(pm, secuenceNext, diaHora, duracion, "N", null,
					planPago, null, usuario.getIdUsuario(), null, null, servicioSPA);
			tx.commit();
			log.trace("Inserción de reserva de Cliente con id " + secuenceNext + ": " + tuplasInsertadas
					+ " tuplas insertadas");
			return new Reserva(secuenceNext, diaHora, duracion, "N", null, planPago, null, usuario.getIdUsuario(), null,
					null, servicioSPA);
		} catch (Exception e) {
			log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return null;
	}

	/*
	 * ****************************************************************
	 * RESERVA DE HABITACION
	 *****************************************************************/

	public Reserva adicionarReservahabitacion(Timestamp diaHora, Long numPersonas, String planPago,
			Timestamp fechaSalida, String cliente, Long habitacion) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			Usuario usuario = SQLusuario.darUsuarioPorNumerodocumento(pm, cliente).get(0);
			List<Reserva> reservas = SQLreserva.darReservas(pm);
			if (reservas != null) {
				for (Reserva reserva : SQLreserva.darReservas(pm)) {
					if (reserva.getHabitacion().equals(habitacion)) {
						Timestamp inicio = reserva.getDiaHora();
						Timestamp fin = reserva.getFechaSalida();
						if (!((diaHora.before(inicio) && fechaSalida.before(inicio))
								|| (diaHora.after(fin) && fechaSalida.after(fin)))) {
							throw new Exception("La habitacion esta reservada en ese horario");
						}
					}
				}
			}
			Long secuenceNext = nextval();
			long tuplasInsertadas = SQLreserva.adicionarReserva(pm, secuenceNext, diaHora, null, "N", numPersonas,
					planPago, fechaSalida, usuario.idUsuario, habitacion, null, null);
			SQLhabitacion.actualizarOcupado(pm, "ocupado", habitacion);

			tx.commit();

			log.trace("Inserción de reserva de Cliente con id : " + usuario.nombre + " con habitación id:" + habitacion
					+ ": " + tuplasInsertadas + " tuplas insertadas");
			return new Reserva(secuenceNext, diaHora, null, "N", numPersonas, planPago, fechaSalida,
					usuario.getIdUsuario(), habitacion, null, null);
		} catch (Exception e) {
			// e.printStackTrace();
			log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	/*
	 * ****************************************************************
	 * Registrar llegada de cliente al hotel
	 *****************************************************************/
	public Reserva registrarLlegadaCliente(Long idReserva, String cliente) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Usuario usuario = SQLusuario.darUsuarioPorNumerodocumento(pm, cliente).get(0);
			Reserva reserva = SQLreserva.darReservaPorId(pm, idReserva);
			if (reserva == null) {
				throw new Exception("La reserva no existe");
			}
			if (reserva.getCliente() != usuario.getIdUsuario()) {
				throw new Exception("El cliente no es el mismo");
			}
			if (reserva.getDiaHora().after(new Timestamp(System.currentTimeMillis()))) {
				throw new Exception("La reserva no está vigente");
			}
			if (reserva.getFechaSalida().before(new Timestamp(System.currentTimeMillis()))) {
				throw new Exception("La reserva ya ha finalizado");
			}

			if (reserva.getAceptada().equals("N")) {
				SQLreserva.actualizarAceptada(pm, "Y", idReserva);
				Long idCuenta;
				Habitacion habitacion = SQLhabitacion.darHabitacionPorId(pm, reserva.getHabitacion());
				idCuenta = nextval();
				SQLcuenta.adicionarCuenta(pm, idCuenta, new Timestamp(System.currentTimeMillis()),
						habitacion.getIdHabitacion());
				SQLusuario.actualizarCuenta(pm, idCuenta, usuario.getIdUsuario());
				SQLhabitacion.actualizarCuenta(pm, idCuenta, reserva.getHabitacion());
				tx.commit();
				return reserva;
			} else {
				throw new Exception("La reserva ya fue registrada");
			}
		} catch (Exception e) {
			log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	public void registrarAcompanante(String tipoDocumento, String numeroDocumento, String correo, String nombre,
			String acompanante, String contrasena, Long reserva) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Reserva reservax = SQLreserva.darReservaPorId(pm, reserva);
			Usuario cliente_de_verdad = SQLusuario.darUsuarioPorNumerodocumento(pm, acompanante).get(0);
			SQLusuario.adicionarUsuario(pm, nextval(), "N", tipoDocumento, numeroDocumento, correo, nombre,
					cliente_de_verdad.getCuenta(), 6L, cliente_de_verdad.getIdUsuario(), contrasena, null,null,null);
			tx.commit();
		} catch (Exception e) {
			log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	/*
	 * ****************************************************************
	 * *
	 * *
	 * Registrar consumo del cliente *
	 * *
	 *****************************************************************/

	public Consumo adicionarConsumoServicio(String cliente_acompanante, Long empleado, Long producto, Long servicio,
			String SiNo) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Usuario cliente = SQLusuario.darUsuarioPorNumerodocumento(pm, cliente_acompanante).get(0);
			Long cuenta = cliente.getCuenta();
			Servicio servicio_de_verdad = SQLservicio.darServicioPorId(pm, servicio);
			Cartaproductos carta = SQLcartaproductos.darCartaproductosPorId(pm, servicio_de_verdad.getCartaProductos());
			Long registro = servicio_de_verdad.getRegistroConsumo();
			Cartaproductosproductos cartaproductosproductos;
			try {
				cartaproductosproductos = SQLcartaproductosproductos.darCartaproductosproductosPorId(pm,
						carta.idCarta, producto);
			} catch (Exception e) {
				cartaproductosproductos = null;
				throw new Exception("La carta no existe");
			}
			if (cartaproductosproductos == null) {
				throw new Exception("El producto no está incluido en la carta");
			}

			Long idConsumo = nextval();
			Consumo consumo;
			if (SiNo.equals("si")) {
				SQLconsumo.adicionarConsumo(pm, idConsumo, new Timestamp(System.currentTimeMillis()), cuenta, registro,
						empleado, "no");
				consumo = new Consumo(idConsumo, new Timestamp(System.currentTimeMillis()), cuenta, registro, empleado,
						"no");
			} else {
				SQLconsumo.adicionarConsumo(pm, idConsumo, new Timestamp(System.currentTimeMillis()), null, registro,
						empleado, "si");
				consumo = new Consumo(idConsumo, new Timestamp(System.currentTimeMillis()), null, registro, empleado,
						"si");

			}
			SQLconsumoproducto.adicionarConsumoproducto(pm, producto, idConsumo);
			tx.commit();
			return consumo;

		} catch (Exception e) {
			log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	/*
	 * ****************************************************************
	 * Registrar salida del cliente *
	 *****************************************************************/
	public List registrarSalidaCliente(Long idReserva, String cliente, Long idEmpleado) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			List retorno = new ArrayList();
			Reserva reserva = SQLreserva.darReservaPorId(pm, idReserva);
			Usuario cliente_de_verdad = SQLusuario.darUsuarioPorNumerodocumento(pm, cliente).get(0);
			Habitacion hab = SQLhabitacion.darHabitacionPorId(pm, reserva.getHabitacion());
			if (hab.getCuenta() != cliente_de_verdad.getCuenta()) {
				throw new Exception("El cliente no es el mismo que la habitación");
			}
			List<Consumo> consumos = SQLconsumo.darConsumoPorCuenta(pm, cliente_de_verdad.getCuenta());
			if (consumos.isEmpty()) {
				throw new Exception("El cliente no tiene consumos");
			}
			if (reserva.aceptada.equals("F")) {
				throw new Exception("La reserva ya fue pagada");
			}
			Double acumulado = 0D;
			List<Producto> productos = new ArrayList<Producto>();
			// TODO falta agregar los consumos por servicio de préstamo, y consumos
			// adicionales.
			for (Consumo consumo : consumos) {
				if (consumo.getPagado().equals("no")) {
					List<Consumoproducto> consumosProductos = SQLconsumoproducto.darConsumoproductoPorIdconsumo(pm,
							consumo.getIdConsumo());

					for (Consumoproducto consumoproducto : consumosProductos) {
						Producto producto = SQLproducto.darProductoPorId(pm, consumoproducto.getIdProducto());
						acumulado += producto.getCosto();
						productos.add(producto);
					}
					SQLconsumo.actualizarPagado(pm, "si", consumo.getIdConsumo());
				}

			}
			acumulado += hab.costoAloj;
			SQLhabitacion.actualizarOcupado(pm, "libre", reserva.getHabitacion());
			SQLusuario.actualizarPazsalvo(pm, "S", cliente_de_verdad.idUsuario);
			SQLreserva.actualizarAceptada(pm, "F", idReserva);
			Double gastosAcumulados = acumulado+cliente_de_verdad.getGastosHotel();
			SQLusuario.actualizarGastoshotel(pm, gastosAcumulados, cliente_de_verdad.getIdUsuario());
			Long estadias=cliente_de_verdad.estadia+1;
			SQLusuario.actualizarEstadia(pm, estadias, cliente_de_verdad.getIdUsuario());
			retorno.add(acumulado);
			retorno.add(productos);
			retorno.add(hab);
			retorno.add(reserva);
			tx.commit();
			return retorno;

		} catch (Exception e) {
			log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

	}

	public List<VOReserva> reservarAlojamientoYServiciosParaUnaConvencion(Long idConvencion, Long planPago,
			List<List<Reserva>> reservas) {
		List<VOReserva> listaReservas = new ArrayList<VOReserva>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			Convencion c = SQLconvencion.darConvencionPorId(pm, idConvencion);
			List<Reserva> reservasHabitacion = reservas.get(0);
			List<Reserva> reservasSpa = reservas.get(1);
			List<Reserva> reservasSalonConferencia = reservas.get(2);
			List<Reserva> reservasSalonReunion = reservas.get(3);
			HashMap<Long, List<Habitacion>> habitacionesNoDisponibles = new HashMap<Long, List<Habitacion>>();
			HashMap<Long, List<Servicio>> ServicioSpaNoDisponible = new HashMap<Long, List<Servicio>>();
			List<Servicio> serviciosSalonConferenciaNoDisponibles = new ArrayList<Servicio>();
			List<Servicio> serviciosSalonReunionNoDisponibles = new ArrayList<Servicio>();

			List<VOReserva> hecha = new ArrayList<VOReserva>();

			Reserva provisional = null;

			if (reservasHabitacion.size() > 0) {
				provisional = reservasHabitacion.get(0);
			}
			if (reservasSpa.size() > 0) {
				Reserva provisional2 = reservasSpa.get(0);
			}
			if (reservasSalonConferencia.size() > 0) {
				Reserva provisional3 = reservasSalonConferencia.get(0);
			}
			if (reservasSalonReunion.size() > 0) {
				Reserva provisional4 = reservasSalonReunion.get(0);
			}

			if (reservas != null) {
				for (Reserva reserva : SQLreserva.darReservas(pm)) {
					Timestamp inicio = reserva.getDiaHora();
					Timestamp fin = reserva.getFechaSalida();
					if (!((provisional.getDiaHora().before(inicio) && provisional.fechaSalida.before(inicio))
							|| (provisional.getDiaHora().after(fin) && provisional.fechaSalida.after(fin)))) {
						if (reserva.habitacion != null) {
							Habitacion habitacion = SQLhabitacion.darHabitacionPorId(pm, reserva.habitacion);
							if (habitacionesNoDisponibles.containsKey(habitacion.getTipoHabitacion())) {
								List<Habitacion> listaHabitaciones = new ArrayList<Habitacion>();
								listaHabitaciones.add(habitacion);
								habitacionesNoDisponibles.put(habitacion.getTipoHabitacion(), listaHabitaciones);
							} else {
								habitacionesNoDisponibles.get(habitacion.getTipoHabitacion()).add(habitacion);
							}
						} else if (reserva.servicio != null) {
							Servicio servicio = SQLservicio.darServicioPorId(pm, reserva.servicio);
							if (servicio.nombre.equals("salon de reunion")) {
								serviciosSalonReunionNoDisponibles.add(servicio);
							} else if (servicio.nombre.equals("salon de conferencia")) {
								serviciosSalonConferenciaNoDisponibles.add(servicio);
							}
						} else if (reserva.getOfertaServicio() != null) {
							Servicio servicio = SQLservicio.darServicioPorId(pm, reserva.getServicio());
							if (!ServicioSpaNoDisponible.containsKey(reserva.getOfertaServicio())) {
								List<Servicio> listaServicios = new ArrayList<Servicio>();
								listaServicios.add(servicio);
								ServicioSpaNoDisponible.put(reserva.getOfertaServicio(), listaServicios);
							} else {
								ServicioSpaNoDisponible.get(reserva.getOfertaServicio()).add(servicio);
							}
						}
					}
				}
			}

			for (Reserva reserva : reservasHabitacion) {
				Long tipoHabitacion = reserva.getHabitacion();
				List<Habitacion> hab = SQLhabitacion.darHabitacionPorTipohabitacion(pm, tipoHabitacion);
				if (habitacionesNoDisponibles.containsKey(tipoHabitacion)) {
					List<Habitacion> listaHabitaciones = habitacionesNoDisponibles.get(tipoHabitacion);
					for (Habitacion habitacion : hab) {
						if (!listaHabitaciones.contains(habitacion)) {
							Long idReserva = nextval();
							Habitacion habitacionx = listaHabitaciones.get(0);
							listaHabitaciones.remove(habitacionx);
							SQLreserva.adicionarReserva(pm, idReserva, reserva.diaHora, reserva.duracion, "N",
									reserva.numPersonas, null, reserva.fechaSalida, null, habitacion.idHabitacion, null,
									null);
							SQLconvencionreserva.adicionarConvencionreserva(pm,
									idConvencion, idReserva);
						}
					}
				}

				else if (hab.size() > 0) {
					Long idReserva = nextval();
					Habitacion habitacion = hab.get(0);
					SQLreserva.adicionarReserva(pm, idReserva, reserva.diaHora, reserva.duracion, "N",
							reserva.numPersonas, null, reserva.fechaSalida, null, habitacion.idHabitacion, null, null);
					SQLconvencionreserva.adicionarConvencionreserva(pm,
							idConvencion, idReserva);
					hecha.add((VOReserva) SQLreserva.darReservaPorId(pm, idReserva));

				} else {
					throw new Exception("No hay más habitaciones disponibles");
				}
			}
			tx.commit();
			return hecha;
		} catch (Exception e) {
			log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

	}

	public void eliminarConvencion(Long idConvencion) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			SQLconvencion.eliminarConvencionPorId(pm, idConvencion);
			tx.commit();
		} catch (Exception e) {
			log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	public Servicio adicionarMantenimientoServicio(Long idServicio, Timestamp diaHoraMantenimientoInicial,
			Timestamp diaHoraMantenimientoFinal, String razon) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Boolean crearNueva = false;
			Servicio servicio = SQLservicio.darServicioPorId(pm, idServicio);
			List<Servicio> servicios = SQLservicio.darServicioPorNombre(pm, servicio.nombre);
			List<Reserva> reservas = SQLreserva.darReservaPorServicio(pm, idServicio);
			SQLservicio.actualizarEstado(pm, "Mantenimiento", idServicio);
			Reserva reservaX = null;
			for (Reserva reserva : reservas) {
				if (reserva.aceptada.equals("N")) {
					if ((reserva.diaHora.before(diaHoraMantenimientoInicial)
							&& reserva.fechaSalida.after(diaHoraMantenimientoFinal))
							|| ((reserva.diaHora.after(diaHoraMantenimientoInicial)
									&& reserva.fechaSalida.before(diaHoraMantenimientoFinal)))
							|| (reserva.diaHora.equals(diaHoraMantenimientoInicial)
									&& reserva.fechaSalida.equals(diaHoraMantenimientoFinal))
							|| (diaHoraMantenimientoInicial.after(reserva.diaHora)
									&& diaHoraMantenimientoInicial.before(reserva.fechaSalida))
							|| (diaHoraMantenimientoFinal.after(reserva.diaHora)
									&& diaHoraMantenimientoFinal.before(reserva.fechaSalida))) {
						crearNueva = true;
						reservaX = reserva;
						break;
					}
				}
			}
			if (crearNueva) {
				Long idReserva = nextval();
				for (Servicio servicio1 : servicios) {
					List<Reserva> reserva = SQLreserva.darReservaPorServicio(pm, servicio1.idServicio);
					Boolean elegible = true;
					for (Reserva reserva1 : reserva) {
						if ((reserva1.diaHora.before(diaHoraMantenimientoInicial)
								&& reserva1.fechaSalida.after(diaHoraMantenimientoFinal))
								|| ((reserva1.diaHora.after(diaHoraMantenimientoInicial)
										&& reserva1.fechaSalida.before(diaHoraMantenimientoFinal)))
								|| (reserva1.diaHora.equals(diaHoraMantenimientoInicial)
										&& reserva1.fechaSalida.equals(diaHoraMantenimientoFinal))
								|| (diaHoraMantenimientoInicial.after(reserva1.diaHora)
										&& diaHoraMantenimientoInicial.before(reserva1.fechaSalida))
								|| (diaHoraMantenimientoFinal.after(reserva1.diaHora)
										&& diaHoraMantenimientoFinal.before(reserva1.fechaSalida))) {
							elegible = false;
							break;
						}
					}
					if (elegible) {
						SQLreserva.adicionarReserva(pm, idReserva, reservaX.diaHora, reservaX.duracion, "N",
								reservaX.numPersonas, reservaX.planPago, reservaX.fechaSalida, reservaX.cliente,
								null, servicio1.idServicio, reservaX.ofertaServicio);
						SQLreserva.eliminarReservaPorId(pm, reservaX.idReserva);
						break;
					}
				}
			}
			Long idMantenimiento = nextval();
			SQLmantenimiento.adicionarMantenimiento(pm,idMantenimiento, diaHoraMantenimientoInicial, diaHoraMantenimientoFinal, razon,
					idServicio,null);
			tx.commit();
			return servicio;
		} catch (Exception e) {
			log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	public Habitacion adicionarMantenimientoHabitacion(Long idHabitacion, Timestamp diaHoraMantenimientoInicial,
			Timestamp diaHoraMantenimientoFinal, String razon) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Boolean crearNueva = false;
			Habitacion habitacion = SQLhabitacion.darHabitacionPorId(pm, idHabitacion);

			List<Habitacion> habitaciones = SQLhabitacion.darHabitacionPorTipohabitacion(pm, habitacion.tipoHabitacion);
			List<Reserva> reservas = SQLreserva.darReservaPorHabitacion(pm, idHabitacion);
			SQLhabitacion.actualizarOcupado(pm, "Mantenimiento", idHabitacion);
			Reserva reservaX = null;
			for (Reserva reserva : reservas) {
				if ((reserva.diaHora.before(diaHoraMantenimientoInicial) && reserva.fechaSalida.after(diaHoraMantenimientoFinal)) || ((reserva.diaHora.after(diaHoraMantenimientoInicial) && reserva.fechaSalida.before(diaHoraMantenimientoFinal))) || (reserva.diaHora.equals(diaHoraMantenimientoInicial) && reserva.fechaSalida.equals(diaHoraMantenimientoFinal)) || (reserva.diaHora.after(diaHoraMantenimientoInicial) && reserva.diaHora.before(diaHoraMantenimientoFinal))|| (reserva.fechaSalida.after(diaHoraMantenimientoInicial) && reserva.fechaSalida.before(diaHoraMantenimientoFinal)))
				{
					crearNueva = true;
					reservaX = reserva;
					break;
				}
			}

			if (crearNueva) {
				Long idReserva = nextval();
				for (Habitacion habitacion1 : habitaciones) {
					List<Reserva> reserva = SQLreserva.darReservaPorHabitacion(pm, habitacion1.idHabitacion);
					Boolean elegible = true;
					for (Reserva reserva1 : reserva) {
						if ((reserva1.diaHora.before(diaHoraMantenimientoInicial)
								&& reserva1.fechaSalida.after(diaHoraMantenimientoFinal))
								|| ((reserva1.diaHora.after(diaHoraMantenimientoInicial)
										&& reserva1.fechaSalida.before(diaHoraMantenimientoFinal)))
								|| (reserva1.diaHora.equals(diaHoraMantenimientoInicial)
										&& reserva1.fechaSalida.equals(diaHoraMantenimientoFinal))
								|| (reserva1.diaHora.after(diaHoraMantenimientoInicial)
										&& reserva1.diaHora.before(diaHoraMantenimientoFinal))
								|| (diaHoraMantenimientoFinal.after(reserva1.diaHora)
										&& diaHoraMantenimientoFinal.before(reserva1.fechaSalida))) {
							elegible = false;

							break;
						}
					}
					if (elegible) {
						SQLreserva.adicionarReserva(pm, idReserva, reservaX.diaHora, reservaX.duracion,
								reservaX.aceptada,
								reservaX.numPersonas, reservaX.planPago, reservaX.fechaSalida, reservaX.cliente, habitacion1.idHabitacion,
								null, reservaX.ofertaServicio);
						SQLreserva.eliminarReservaPorId(pm, reservaX.idReserva);
						if (reservaX.aceptada.equals("S")){
							SQLhabitacion.actualizarCuenta(pm, null, idHabitacion);
							SQLhabitacion.actualizarCuenta(pm, habitacion.cuenta, habitacion1.idHabitacion);
							SQLhabitacion.actualizarOcupado(pm, "Ocupado", habitacion1.idHabitacion);
						}
						break;
					}
				}

			}
			Long idMantenimiento = nextval();
			SQLmantenimiento.adicionarMantenimiento(pm,idMantenimiento, diaHoraMantenimientoInicial, diaHoraMantenimientoFinal, razon,
					null,idHabitacion);
			tx.commit();
			return habitacion;
		} catch (Exception e) {
			log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

	}
	public Mantenimiento eliminarMantenimientoHabitacion(Long idHabitacion){
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Mantenimiento mantenimiento = SQLmantenimiento.darMantenimientoPorHabitacion(pm, idHabitacion).get(0);
			SQLhabitacion.actualizarOcupado(pm, "Libre", idHabitacion);
			tx.commit();
			return mantenimiento;
		} catch (Exception e) {
			log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	public Mantenimiento eliminarMantenimientoServicio(Long idServicio){
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Mantenimiento mantenimiento = SQLmantenimiento.darMantenimientoPorServicio(pm, idServicio).get(0);
			SQLservicio.actualizarEstado(pm, "Libre", idServicio);
			tx.commit();
			return mantenimiento;
		} catch (Exception e) {
			log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	public List<Usuario> REQfuncional7(){
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try {
			tx.begin();
			List<Usuario> usuarios = SQLusuario.encontrarBuenosClientes(pm);
			tx.commit();
			return usuarios;
		} catch (Exception e) {
			log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	public List<Servicio> REQfuncional8(){
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try {
			tx.begin();
			List<Servicio> servicios = SQLservicio.ServiciosPocaDemanda(pm);
			tx.commit();
			return servicios;
		} catch (Exception e) {
			log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			e.printStackTrace();
			return null;
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	public List<Usuario> REQfuncional9(){
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try {
			tx.begin();
			List<Usuario> usuarios = SQLusuario.darUsuarios(pm);
			tx.commit();
			return usuarios;
		} catch (Exception e) {
			log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	public List<Usuario> REQfuncional10(){
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try {
			tx.begin();
			List<Usuario> usuarios = SQLusuario.darUsuarios(pm);
			tx.commit();
			return usuarios;
		} catch (Exception e) {
			log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	/**
	 * Elimina todas las tuplas de todas las tablas de la base de datos de
	 * HotelAndes
	 * Crea y ejecuta las sentencias SQL para cada tabla de la base de datos - EL
	 * ORDEN ES IMPORTANTE
	 * 
	 */
	public long[] limpiarHotelAndes() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			long[] resp = sqlUtil.limpiarHotelAndes(pm);
			tx.commit();
			log.info("Borrada la base de datos");

			return resp;
		} catch (Exception e) {
			// e.printStackTrace();
			log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return new long[] { -1, -1, -1, -1, -1, -1, -1 };
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	

}
