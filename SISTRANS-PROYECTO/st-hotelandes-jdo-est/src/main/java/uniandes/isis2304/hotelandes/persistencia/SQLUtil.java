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

package uniandes.isis2304.hotelandes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de HotelAndes
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 * @author Germán Bravo
 */
class SQLUtil
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaHotelAndes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaHotelAndes pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLUtil (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para obtener un nuevo número de secuencia
	 * @param pm - El manejador de persistencia
	 * @return El número de secuencia generado
	 */
	public long nextval (PersistenceManager pm)
	{
        Query q = pm.newQuery(SQL, "SELECT "+ pp.darSeqHotelAndes () + ".nextval FROM DUAL");
        q.setResultClass(Long.class);
        long resp = (long) q.executeUnique();
        return resp;
	}

	/**
	 * Crea y ejecuta las sentencias SQL para cada tabla de la base de datos - EL ORDEN ES IMPORTANTE 
	 * @param pm - El manejador de persistencia
	 * @return Un arreglo con 7 números que indican el número de tuplas borradas en las tablas GUSTAN, SIRVEN, VISITAN, BEBIDA,
	 * TIPOBEBIDA, BEBEDOR y BAR, respectivamente
	 */
	public long [] limpiarHotelAndes (PersistenceManager pm)
	{
		//Obtener la cantidad de tuplas en cada tabla
		Query hCuenta=pm.newQuery(SQL,"SELECT COUNT(*) FROM CUENTA");
		Query hUsuario=pm.newQuery(SQL,"SELECT COUNT(*) FROM USUARIO");
		Query hPrenda=pm.newQuery(SQL,"SELECT COUNT(*) FROM PRENDA");
		Query hReserva=pm.newQuery(SQL,"SELECT COUNT(*) FROM RESERVA");
		Query hHabitacion=pm.newQuery(SQL,"SELECT COUNT(*) FROM HABITACION");
		Query hMueble=pm.newQuery(SQL,"SELECT COUNT(*) FROM MUEBLE");
		Query hConsumoconmueble=pm.newQuery(SQL,"SELECT COUNT(*) FROM CONSUMOCONMUEBLE");
		Query hConsumo=pm.newQuery(SQL,"SELECT COUNT(*) FROM CONSUMO");
		Query hTipohabitacion=pm.newQuery(SQL,"SELECT COUNT(*) FROM TIPOHABITACION");
		Query hTipousuario=pm.newQuery(SQL,"SELECT COUNT(*) FROM TIPOUSUARIO");
		Query hHotel=pm.newQuery(SQL,"SELECT COUNT(*) FROM HOTEL");
		Query hCadenahotelera=pm.newQuery(SQL,"SELECT COUNT(*) FROM CADENAHOTELERA");
		Query hOfertaservicio=pm.newQuery(SQL,"SELECT COUNT(*) FROM OFERTASERVICIO");
		Query hRegistroconsumo=pm.newQuery(SQL,"SELECT COUNT(*) FROM REGISTROCONSUMO");
		Query hUtensilio=pm.newQuery(SQL,"SELECT COUNT(*) FROM UTENSILIO");
		Query hProducto=pm.newQuery(SQL,"SELECT COUNT(*) FROM PRODUCTO");
		Query hServicioprestamo=pm.newQuery(SQL,"SELECT COUNT(*) FROM SERVICIOPRESTAMO");
		Query hServicio=pm.newQuery(SQL,"SELECT COUNT(*) FROM SERVICIO");
		Query hCartaproductos=pm.newQuery(SQL,"SELECT COUNT(*) FROM CARTAPRODUCTOS");
		Query hEstilo=pm.newQuery(SQL,"SELECT COUNT(*) FROM ESTILO");
		Query hHorarioservicio=pm.newQuery(SQL,"SELECT COUNT(*) FROM HORARIOSERVICIO");
		Query hCostoadicional=pm.newQuery(SQL,"SELECT COUNT(*) FROM COSTOADICIONAL");
		Query hTipocobro=pm.newQuery(SQL,"SELECT COUNT(*) FROM TIPOCOBRO");
		Query hPlanconsumo=pm.newQuery(SQL,"SELECT COUNT(*) FROM PLANCONSUMO");
		Query hTipoplanconsumo=pm.newQuery(SQL,"SELECT COUNT(*) FROM TIPOPLANCONSUMO");
		Query hRestricciones=pm.newQuery(SQL,"SELECT COUNT(*) FROM RESTRICCIONES");
		Query hServicioprestamoutensilio=pm.newQuery(SQL,"SELECT COUNT(*) FROM SERVICIOPRESTAMOUTENSILIO");
		Query hProductoplanconsumo=pm.newQuery(SQL,"SELECT COUNT(*) FROM PRODUCTOPLANCONSUMO");
		Query hCartaproductosproductos=pm.newQuery(SQL,"SELECT COUNT(*) FROM CARTAPRODUCTOSPRODUCTOS");
		Query hServiciohorarioservicio=pm.newQuery(SQL,"SELECT COUNT(*) FROM SERVICIOHORARIOSERVICIO");
		Query hConsumoofertaservicio=pm.newQuery(SQL,"SELECT COUNT(*) FROM CONSUMOOFERTASERVICIO");
		Query hConsumomuebleconconsumo=pm.newQuery(SQL,"SELECT COUNT(*) FROM CONSUMOMUEBLECONCONSUMO");
		Query hPlanconsumoservicio=pm.newQuery(SQL,"SELECT COUNT(*) FROM PLANCONSUMOSERVICIO");
		Query hHotelusuario=pm.newQuery(SQL,"SELECT COUNT(*) FROM HOTELUSUARIO");
		Query hPlanconsumorestricciones=pm.newQuery(SQL,"SELECT COUNT(*) FROM PLANCONSUMORESTRICCIONES");
		Query hUsuarioplanconsumo=pm.newQuery(SQL,"SELECT COUNT(*) FROM USUARIOPLANCONSUMO");
		Query hHotelplanconsumo=pm.newQuery(SQL,"SELECT COUNT(*) FROM HOTELPLANCONSUMO");
		Query hConsumocostoadicional = pm.newQuery(SQL, "SELECT COUNT(*) FROM CONSUMOCOSTOADICIONAL");
		
		long CuentaEliminados = Long.valueOf(hCuenta.executeUnique().toString());
		long UsuarioEliminados= Long.valueOf(hUsuario.executeUnique().toString());
		long PrendaEliminados= Long.valueOf(hPrenda.executeUnique().toString());
		long ReservaEliminados= Long.valueOf(hReserva.executeUnique().toString());
		long HabitacionEliminados= Long.valueOf(hHabitacion.executeUnique().toString());
		long MuebleEliminados= Long.valueOf(hMueble.executeUnique().toString());
		long ConsumoconmuebleEliminados= Long.valueOf(hConsumoconmueble.executeUnique().toString());
		long ConsumoEliminados= Long.valueOf(hConsumo.executeUnique().toString());
		long TipohabitacionEliminados= Long.valueOf(hTipohabitacion.executeUnique().toString());
		long TipousuarioEliminados= Long.valueOf(hTipousuario.executeUnique().toString());
		long HotelEliminados= Long.valueOf(hHotel.executeUnique().toString());
		long CadenahoteleraEliminados= Long.valueOf(hCadenahotelera.executeUnique().toString());
		long OfertaservicioEliminados= Long.valueOf(hOfertaservicio.executeUnique().toString());
		long RegistroconsumoEliminados= Long.valueOf(hRegistroconsumo.executeUnique().toString());
		long UtensilioEliminados= Long.valueOf(hUtensilio.executeUnique().toString());
		long ProductoEliminados= Long.valueOf(hProducto.executeUnique().toString());
		long ServicioprestamoEliminados= Long.valueOf(hServicioprestamo.executeUnique().toString());
		long ServicioEliminados= Long.valueOf(hServicio.executeUnique().toString());
		long CartaproductosEliminados= Long.valueOf(hCartaproductos.executeUnique().toString());
		long EstiloEliminados= Long.valueOf(hEstilo.executeUnique().toString());
		long HorarioservicioEliminados= Long.valueOf(hHorarioservicio.executeUnique().toString());
		long CostoadicionalEliminados= Long.valueOf(hCostoadicional.executeUnique().toString());
		long TipocobroEliminados= Long.valueOf(hTipocobro.executeUnique().toString());
		long PlanconsumoEliminados= Long.valueOf(hPlanconsumo.executeUnique().toString());
		long TipoplanconsumoEliminados= Long.valueOf(hTipoplanconsumo.executeUnique().toString());
		long RestriccionesEliminados= Long.valueOf(hRestricciones.executeUnique().toString());
		long ServicioprestamoutensilioEliminados= Long.valueOf(hServicioprestamoutensilio.executeUnique().toString());
		long ProductoplanconsumoEliminados= Long.valueOf(hProductoplanconsumo.executeUnique().toString());
		long CartaproductosproductosEliminados= Long.valueOf(hCartaproductosproductos.executeUnique().toString());
		long ServiciohorarioservicioEliminados= Long.valueOf(hServiciohorarioservicio.executeUnique().toString());
		long ConsumoofertaservicioEliminados= Long.valueOf(hConsumoofertaservicio.executeUnique().toString());
		long ConsumomuebleconconsumoEliminados= Long.valueOf(hConsumomuebleconconsumo.executeUnique().toString());
		long PlanconsumoservicioEliminados= Long.valueOf(hPlanconsumoservicio.executeUnique().toString());
		long HotelusuarioEliminados= Long.valueOf(hHotelusuario.executeUnique().toString());
		long PlanconsumorestriccionesEliminados= Long.valueOf(hPlanconsumorestricciones.executeUnique().toString());
		long UsuarioplanconsumoEliminados= Long.valueOf(hUsuarioplanconsumo.executeUnique().toString());
		long HotelplanconsumoEliminados= Long.valueOf(hHotelplanconsumo.executeUnique().toString());
		long ConsumocostoadicionalEliminados= Long.valueOf(hConsumocostoadicional.executeUnique().toString());

		Query qCuenta=pm.newQuery(SQL,"truncate table CUENTA");
		Query qUsuario=pm.newQuery(SQL,"truncate table USUARIO");
		Query qPrenda=pm.newQuery(SQL,"truncate table PRENDA");
		Query qReserva=pm.newQuery(SQL,"truncate table RESERVA");
		Query qHabitacion=pm.newQuery(SQL,"truncate table HABITACION");
		Query qMueble=pm.newQuery(SQL,"truncate table MUEBLE");
		Query qConsumoconmueble=pm.newQuery(SQL,"truncate table CONSUMOCONMUEBLE");
		Query qConsumo=pm.newQuery(SQL,"truncate table CONSUMO");
		Query qTipohabitacion=pm.newQuery(SQL,"truncate table TIPOHABITACION");
		Query qTipousuario=pm.newQuery(SQL,"truncate table TIPOUSUARIO");
		Query qHotel=pm.newQuery(SQL,"truncate table HOTEL");
		Query qCadenahotelera=pm.newQuery(SQL,"truncate table CADENAHOTELERA");
		Query qOfertaservicio=pm.newQuery(SQL,"truncate table OFERTASERVICIO");
		Query qRegistroconsumo=pm.newQuery(SQL,"truncate table REGISTROCONSUMO");
		Query qUtensilio=pm.newQuery(SQL,"truncate table UTENSILIO");
		Query qProducto=pm.newQuery(SQL,"truncate table PRODUCTO");
		Query qServicioprestamo=pm.newQuery(SQL,"truncate table SERVICIOPRESTAMO");
		Query qServicio=pm.newQuery(SQL,"truncate table SERVICIO");
		Query qCartaproductos=pm.newQuery(SQL,"truncate table CARTAPRODUCTOS");
		Query qEstilo=pm.newQuery(SQL,"truncate table ESTILO");
		Query qHorarioservicio=pm.newQuery(SQL,"truncate table HORARIOSERVICIO");
		Query qCostoadicional=pm.newQuery(SQL,"truncate table COSTOADICIONAL");
		Query qTipocobro=pm.newQuery(SQL,"truncate table TIPOCOBRO");
		Query qPlanconsumo=pm.newQuery(SQL,"truncate table PLANCONSUMO");
		Query qTipoplanconsumo=pm.newQuery(SQL,"truncate table TIPOPLANCONSUMO");
		Query qRestricciones=pm.newQuery(SQL,"truncate table RESTRICCIONES");
		Query qServicioprestamoutensilio=pm.newQuery(SQL,"truncate table SERVICIOPRESTAMOUTENSILIO");
		Query qProductoplanconsumo=pm.newQuery(SQL,"truncate table PRODUCTOPLANCONSUMO");
		Query qCartaproductosproductos=pm.newQuery(SQL,"truncate table CARTAPRODUCTOSPRODUCTOS");
		Query qServiciohorarioservicio=pm.newQuery(SQL,"truncate table SERVICIOHORARIOSERVICIO");
		Query qConsumoofertaservicio=pm.newQuery(SQL,"truncate table CONSUMOOFERTASERVICIO");
		Query qConsumomuebleconconsumo=pm.newQuery(SQL,"truncate table CONSUMOMUEBLECONCONSUMO");
		Query qPlanconsumoservicio=pm.newQuery(SQL,"truncate table PLANCONSUMOSERVICIO");
		Query qHotelusuario=pm.newQuery(SQL,"truncate table HOTELUSUARIO");
		Query qPlanconsumorestricciones=pm.newQuery(SQL,"truncate table PLANCONSUMORESTRICCIONES");
		Query qUsuarioplanconsumo=pm.newQuery(SQL,"truncate table USUARIOPLANCONSUMO");
		Query qHotelplanconsumo=pm.newQuery(SQL,"truncate table HOTELPLANCONSUMO");
		Query qConsumocostoadicional=pm.newQuery(SQL,"truncate table CONSUMOCOSTOADICIONAL");

		qCuenta.executeUnique();
		qUsuario.executeUnique();
		qPrenda.executeUnique();
		qReserva.executeUnique();
		qHabitacion.executeUnique();
		qMueble.executeUnique();
		qConsumoconmueble.executeUnique();
		qConsumo.executeUnique();
		qTipohabitacion.executeUnique();
		qTipousuario.executeUnique();
		qHotel.executeUnique();
		qCadenahotelera.executeUnique();
		qOfertaservicio.executeUnique();
		qRegistroconsumo.executeUnique();
		qUtensilio.executeUnique();
		qProducto.executeUnique();
		qServicioprestamo.executeUnique();
		qServicio.executeUnique();
		qCartaproductos.executeUnique();
		qEstilo.executeUnique();
		qHorarioservicio.executeUnique();
		qCostoadicional.executeUnique();
		qTipocobro.executeUnique();
		qPlanconsumo.executeUnique();
		qTipoplanconsumo.executeUnique();
		qRestricciones.executeUnique();
		qServicioprestamoutensilio.executeUnique();
		qProductoplanconsumo.executeUnique();
		qCartaproductosproductos.executeUnique();
		qServiciohorarioservicio.executeUnique();
		qConsumoofertaservicio.executeUnique();
		qConsumomuebleconconsumo.executeUnique();
		qPlanconsumoservicio.executeUnique();
		qHotelusuario.executeUnique();
		qPlanconsumorestricciones.executeUnique();
		qUsuarioplanconsumo.executeUnique();
		qHotelplanconsumo.executeUnique();
		qConsumocostoadicional.executeUnique();
		return new long[] {
			CuentaEliminados,
			UsuarioEliminados,
			PrendaEliminados,
			ReservaEliminados,
			HabitacionEliminados,
			MuebleEliminados,
			ConsumoconmuebleEliminados,
			ConsumoEliminados,
			TipohabitacionEliminados,
			TipousuarioEliminados,
			HotelEliminados,
			CadenahoteleraEliminados,
			OfertaservicioEliminados,
			RegistroconsumoEliminados,
			UtensilioEliminados,
			ProductoEliminados,
			ServicioprestamoEliminados,
			ServicioEliminados,
			CartaproductosEliminados,
			EstiloEliminados,
			HorarioservicioEliminados,
			CostoadicionalEliminados,
			TipocobroEliminados,
			PlanconsumoEliminados,
			TipoplanconsumoEliminados,
			RestriccionesEliminados,
			ServicioprestamoutensilioEliminados,
			ProductoplanconsumoEliminados,
			CartaproductosproductosEliminados,
			ServiciohorarioservicioEliminados,
			ConsumoofertaservicioEliminados,
			ConsumomuebleconconsumoEliminados,
			PlanconsumoservicioEliminados,
			HotelusuarioEliminados,
			PlanconsumorestriccionesEliminados,
			UsuarioplanconsumoEliminados,
			HotelplanconsumoEliminados,
			ConsumocostoadicionalEliminados
		};
	}

}
