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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	//TODO aquí pueden haber errores.
	public long [] limpiarHotelAndes (PersistenceManager pm)
	{
		Query SECUENCIA = pm.newQuery(SQL, "DROP SEQUENCE HotelAndes_sequence" );
		SECUENCIA.executeUnique();
		Query SECUENCIA2 = pm.newQuery(SQL, "CREATE SEQUENCE HotelAndes_sequence START WITH 1 INCREMENT BY 1 NOMAXVALUE");
		SECUENCIA2.executeUnique();
		Query hmantenimiento = pm.newQuery(SQL, "DELETE FROM MANTENIMIENTO");
		Query hconsumoproducto=pm.newQuery(SQL,"delete from consumoproducto");
		Query hconsumocostoadicional=pm.newQuery(SQL,"delete from consumocostoadicional");
		Query hhotelplanconsumo=pm.newQuery(SQL,"delete from hotelplanconsumo");
		Query husuarioplanconsumo=pm.newQuery(SQL,"delete from usuarioplanconsumo");
		Query hplanconsumorestricciones=pm.newQuery(SQL,"delete from planconsumorestricciones");
		Query hhotelusuario=pm.newQuery(SQL,"delete from hotelusuario");
		Query hplanconsumoservicio=pm.newQuery(SQL,"delete from planconsumoservicio");
		Query hconsumomuebleconconsumo=pm.newQuery(SQL,"delete from consumomuebleconconsumo");
		Query hconsumoofertaservicio=pm.newQuery(SQL,"delete from consumoofertaservicio");
		Query hserviciohorarioservicio=pm.newQuery(SQL,"delete from serviciohorarioservicio");
		Query hcartaproductosproductos=pm.newQuery(SQL,"delete from cartaproductosproductos");
		Query hproductoplanconsumo=pm.newQuery(SQL,"delete from productoplanconsumo");
		Query hservicioprestamoutensilio=pm.newQuery(SQL,"delete from servicioprestamoutensilio");
		Query hrestricciones=pm.newQuery(SQL,"delete from restricciones");
		Query hcostoadicional=pm.newQuery(SQL,"delete from costoadicional");
		Query hconvencionReservas=pm.newQuery(SQL,"delete from convencionReserva");
		Query hreserva=pm.newQuery(SQL,"delete from reserva");
		Query hofertaservicio=pm.newQuery(SQL,"delete from ofertaservicio");
		Query hconvencion=pm.newQuery(SQL, "delete from CONVENCION");
		Query hoferta=pm.newQuery(SQL, "delete from OFERTA");
		Query hplancobro=pm.newQuery(SQL,"delete from PLANCOBRO");
		Query hservicio=pm.newQuery(SQL, "delete from SERVICIO");
		Query hservicioprestamo=pm.newQuery(SQL,"delete from servicioprestamo");
		Query hutensilio=pm.newQuery(SQL,"delete from utensilio");
		Query hconsumoconmueble=pm.newQuery(SQL,"delete from consumoconmueble");
		Query hmueble=pm.newQuery(SQL,"delete from mueble");
		Query hconsumo=pm.newQuery(SQL,"delete from consumo");
		Query hcuenta=pm.newQuery(SQL,"delete from cuenta");
		Query hprenda=pm.newQuery(SQL,"delete from prenda");
		Query husuario=pm.newQuery(SQL,"delete from usuario");
		Query hhabitacion=pm.newQuery(SQL,"delete from habitacion");
		Query hhotel=pm.newQuery(SQL,"delete from hotel");
		Query hplanconsumo=pm.newQuery(SQL,"delete from planconsumo");
		Query htipocobro=pm.newQuery(SQL,"delete from tipocobro");
		Query hhorarioservicio=pm.newQuery(SQL,"delete from horarioservicio");
		Query hestilo=pm.newQuery(SQL,"delete from estilo");
		Query hcartaproductos=pm.newQuery(SQL,"delete from cartaproductos");
		Query hproducto=pm.newQuery(SQL,"delete from producto");
		Query hregistroconsumo=pm.newQuery(SQL,"delete from registroconsumo");
		Query hcadenahotelera=pm.newQuery(SQL,"delete from cadenahotelera");
		Query htipousuario=pm.newQuery(SQL,"delete from tipousuario");
		Query htipohabitacion=pm.newQuery(SQL,"delete from tipohabitacion");

		Long mantenimientoEliminados=Long.valueOf(hmantenimiento.executeUnique().toString());
		Long consumoproductoEliminados=Long.valueOf(hconsumoproducto.executeUnique().toString());
		Long consumocostoadicionalEliminados=Long.valueOf(hconsumocostoadicional.executeUnique().toString());
		Long hotelplanconsumoEliminados=Long.valueOf(hhotelplanconsumo.executeUnique().toString());
		Long usuarioplanconsumoEliminados=Long.valueOf(husuarioplanconsumo.executeUnique().toString());
		Long planconsumorestriccionesEliminados=Long.valueOf(hplanconsumorestricciones.executeUnique().toString());
		Long hotelusuarioEliminados=Long.valueOf(hhotelusuario.executeUnique().toString());
		Long planconsumoservicioEliminados=Long.valueOf(hplanconsumoservicio.executeUnique().toString());
		Long consumomuebleconconsumoEliminados=Long.valueOf(hconsumomuebleconconsumo.executeUnique().toString());
		Long consumoofertaservicioEliminados=Long.valueOf(hconsumoofertaservicio.executeUnique().toString());
		Long serviciohorarioservicioEliminados=Long.valueOf(hserviciohorarioservicio.executeUnique().toString());
		Long cartaproductosproductosEliminados=Long.valueOf(hcartaproductosproductos.executeUnique().toString());
		Long productoplanconsumoEliminados=Long.valueOf(hproductoplanconsumo.executeUnique().toString());
		Long servicioprestamoutensilioEliminados=Long.valueOf(hservicioprestamoutensilio.executeUnique().toString());
		Long restriccionesEliminados=Long.valueOf(hrestricciones.executeUnique().toString());
		Long costoadicionalEliminados=Long.valueOf(hcostoadicional.executeUnique().toString());
		Long convencionReservasEliminados=Long.valueOf(hconvencionReservas.executeUnique().toString());
		Long reservaEliminados=Long.valueOf(hreserva.executeUnique().toString());
		Long ofertaservicioEliminados=Long.valueOf(hofertaservicio.executeUnique().toString());
		Long convencionEliminados=Long.valueOf(hconvencion.executeUnique().toString());
		Long ofertaEliminados=Long.valueOf(hoferta.executeUnique().toString());
		Long plancobroEliminados=Long.valueOf(hplancobro.executeUnique().toString());
		Long servicioEliminados=Long.valueOf(hservicio.executeUnique().toString());
		Long servicioprestamoEliminados=Long.valueOf(hservicioprestamo.executeUnique().toString());
		Long utensilioEliminados=Long.valueOf(hutensilio.executeUnique().toString());
		Long consumoconmuebleEliminados=Long.valueOf(hconsumoconmueble.executeUnique().toString());
		Long muebleEliminados=Long.valueOf(hmueble.executeUnique().toString());
		Long consumoEliminados=Long.valueOf(hconsumo.executeUnique().toString());
		Long habitacionEliminados=Long.valueOf(hhabitacion.executeUnique().toString());
		Long prendaEliminados=Long.valueOf(hprenda.executeUnique().toString());
		Long usuarioEliminados=Long.valueOf(husuario.executeUnique().toString());
		Long cuentaEliminados=Long.valueOf(hcuenta.executeUnique().toString());
		Long hotelEliminados=Long.valueOf(hhotel.executeUnique().toString());
		Long planconsumoEliminados=Long.valueOf(hplanconsumo.executeUnique().toString());
		Long tipocobroEliminados=Long.valueOf(htipocobro.executeUnique().toString());
		Long horarioservicioEliminados=Long.valueOf(hhorarioservicio.executeUnique().toString());
		Long estiloEliminados=Long.valueOf(hestilo.executeUnique().toString());
		Long cartaproductosEliminados=Long.valueOf(hcartaproductos.executeUnique().toString());
		Long productoEliminados=Long.valueOf(hproducto.executeUnique().toString());
		Long registroconsumoEliminados=Long.valueOf(hregistroconsumo.executeUnique().toString());
		Long cadenahoteleraEliminados=Long.valueOf(hcadenahotelera.executeUnique().toString());
		Long tipousuarioEliminados=Long.valueOf(htipousuario.executeUnique().toString());
		Long tipohabitacionEliminados=Long.valueOf(htipohabitacion.executeUnique().toString());
		
		return new long[] {
			mantenimientoEliminados,
			consumoproductoEliminados,
			consumocostoadicionalEliminados,
			hotelplanconsumoEliminados,
			usuarioplanconsumoEliminados,
			planconsumorestriccionesEliminados,
			hotelusuarioEliminados,
			planconsumoservicioEliminados,
			consumomuebleconconsumoEliminados,
			consumoofertaservicioEliminados,
			serviciohorarioservicioEliminados,
			cartaproductosproductosEliminados,
			productoplanconsumoEliminados,
			servicioprestamoutensilioEliminados,
			restriccionesEliminados,
			costoadicionalEliminados,
			convencionReservasEliminados,
			reservaEliminados,
			ofertaservicioEliminados,
			convencionEliminados,
			ofertaEliminados,
			plancobroEliminados,
			servicioEliminados,
			servicioprestamoEliminados,
			utensilioEliminados,
			consumoconmuebleEliminados,
			muebleEliminados,
			consumoEliminados,
			cuentaEliminados,
			prendaEliminados,
			usuarioEliminados,
			habitacionEliminados ,
			hotelEliminados,
			planconsumoEliminados,
			tipocobroEliminados,
			horarioservicioEliminados,
			estiloEliminados,
			cartaproductosEliminados,
			productoEliminados,
			registroconsumoEliminados,
			cadenahoteleraEliminados,
			tipousuarioEliminados,
			tipohabitacionEliminados
		};
	}

}
