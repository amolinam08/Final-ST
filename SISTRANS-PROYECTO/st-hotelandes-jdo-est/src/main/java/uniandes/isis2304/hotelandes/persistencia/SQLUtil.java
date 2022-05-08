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
	public long [] limpiarHotelAndes (PersistenceManager pm)
	{

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
		Query hreserva=pm.newQuery(SQL,"delete from reserva");
		Query hofertaservicio=pm.newQuery(SQL,"delete from ofertaservicio");
		Query hservicio=pm.newQuery(SQL,"delete from servicio");
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

		
		long consumoproductoEliminados=Long.valueOf(hconsumoproducto.executeUnique().toString());
		long consumocostoadicionalEliminados=Long.valueOf(hconsumocostoadicional.executeUnique().toString());
		long hotelplanconsumoEliminados=Long.valueOf(hhotelplanconsumo.executeUnique().toString());
		long usuarioplanconsumoEliminados=Long.valueOf(husuarioplanconsumo.executeUnique().toString());
		long planconsumorestriccionesEliminados=Long.valueOf(hplanconsumorestricciones.executeUnique().toString());
		long hotelusuarioEliminados=Long.valueOf(hhotelusuario.executeUnique().toString());
		long planconsumoservicioEliminados=Long.valueOf(hplanconsumoservicio.executeUnique().toString());
		long consumomuebleconconsumoEliminados=Long.valueOf(hconsumomuebleconconsumo.executeUnique().toString());
		long consumoofertaservicioEliminados=Long.valueOf(hconsumoofertaservicio.executeUnique().toString());
		long serviciohorarioservicioEliminados=Long.valueOf(hserviciohorarioservicio.executeUnique().toString());
		long cartaproductosproductosEliminados=Long.valueOf(hcartaproductosproductos.executeUnique().toString());
		long productoplanconsumoEliminados=Long.valueOf(hproductoplanconsumo.executeUnique().toString());
		long servicioprestamoutensilioEliminados=Long.valueOf(hservicioprestamoutensilio.executeUnique().toString());
		long restriccionesEliminados=Long.valueOf(hrestricciones.executeUnique().toString());
		long costoadicionalEliminados=Long.valueOf(hcostoadicional.executeUnique().toString());
		long reservaEliminados=Long.valueOf(hreserva.executeUnique().toString());
		long ofertaservicioEliminados=Long.valueOf(hofertaservicio.executeUnique().toString());
		long servicioEliminados=Long.valueOf(hservicio.executeUnique().toString());
		long servicioprestamoEliminados=Long.valueOf(hservicioprestamo.executeUnique().toString());
		long utensilioEliminados=Long.valueOf(hutensilio.executeUnique().toString());
		long consumoconmuebleEliminados=Long.valueOf(hconsumoconmueble.executeUnique().toString());
		long muebleEliminados=Long.valueOf(hmueble.executeUnique().toString());
		long consumoEliminados=Long.valueOf(hconsumo.executeUnique().toString());
		long cuentaEliminados=Long.valueOf(hcuenta.executeUnique().toString());
		long prendaEliminados=Long.valueOf(hprenda.executeUnique().toString());
		long usuarioEliminados=Long.valueOf(husuario.executeUnique().toString());
		long habitacionEliminados=Long.valueOf(hhabitacion.executeUnique().toString());
		long hotelEliminados=Long.valueOf(hhotel.executeUnique().toString());
		long planconsumoEliminados=Long.valueOf(hplanconsumo.executeUnique().toString());
		long tipocobroEliminados=Long.valueOf(htipocobro.executeUnique().toString());
		long horarioservicioEliminados=Long.valueOf(hhorarioservicio.executeUnique().toString());
		long estiloEliminados=Long.valueOf(hestilo.executeUnique().toString());
		long cartaproductosEliminados=Long.valueOf(hcartaproductos.executeUnique().toString());
		long productoEliminados=Long.valueOf(hproducto.executeUnique().toString());
		long registroconsumoEliminados=Long.valueOf(hregistroconsumo.executeUnique().toString());
		long cadenahoteleraEliminados=Long.valueOf(hcadenahotelera.executeUnique().toString());
		long tipousuarioEliminados=Long.valueOf(htipousuario.executeUnique().toString());
		long tipohabitacionEliminados=Long.valueOf(htipohabitacion.executeUnique().toString());

		
		
		
		

		
		
		return new long[] {
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
			reservaEliminados,
			ofertaservicioEliminados,
			servicioEliminados,
			servicioprestamoEliminados,
			utensilioEliminados,
			consumoconmuebleEliminados,
			muebleEliminados,
			consumoEliminados,
			cuentaEliminados,
			prendaEliminados,
			usuarioEliminados,
			habitacionEliminados,
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
