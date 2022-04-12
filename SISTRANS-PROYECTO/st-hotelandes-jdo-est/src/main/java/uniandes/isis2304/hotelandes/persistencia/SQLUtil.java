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

import java.beans.Statement;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

        
        Connection con=null;
		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "BRAITO", "123");
			try {
				PreparedStatement ps = con.prepareStatement(
						"BEGIN FOR c IN (SELECT c.owner, c.table_name, c.constraint_name FROM user_constraints c, user_tables t WHERE c.table_name = t.table_name AND c.status = \'ENABLED\' AND NOT (t.iot_type IS NOT NULL AND c.constraint_type = \'R\') ORDER BY c.constraint_type DESC) LOOP dbms_utility.exec_ddl_statement(\'alter table \"\' || c.owner || \'\".\"\' || c.table_name || \'\" disable constraint \' || c.constraint_name); END LOOP; END; ");
						ps.executeQuery();
						con.prepareStatement("commit").executeQuery().close();
						con.close();	
						ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//Obtener la cantidad de tuplas en cada tabla
		Query hCuenta=pm.newQuery(SQL,"DELETE FROM CUENTA");
		Query hUsuario=pm.newQuery(SQL,"DELETE FROM USUARIO");
		Query hPrenda=pm.newQuery(SQL,"DELETE FROM PRENDA");
		Query hReserva=pm.newQuery(SQL,"DELETE FROM RESERVA");
		Query hHabitacion=pm.newQuery(SQL,"DELETE FROM HABITACION");
		Query hMueble=pm.newQuery(SQL,"DELETE FROM MUEBLE");
		Query hConsumoconmueble=pm.newQuery(SQL,"DELETE FROM CONSUMOCONMUEBLE");
		Query hConsumo=pm.newQuery(SQL,"DELETE FROM CONSUMO");
		Query hTipohabitacion=pm.newQuery(SQL,"DELETE FROM TIPOHABITACION");
		Query hTipousuario=pm.newQuery(SQL,"DELETE FROM TIPOUSUARIO");
		Query hHotel=pm.newQuery(SQL,"DELETE FROM HOTEL");
		Query hCadenahotelera=pm.newQuery(SQL,"DELETE FROM CADENAHOTELERA");
		Query hOfertaservicio=pm.newQuery(SQL,"DELETE FROM OFERTASERVICIO");
		Query hRegistroconsumo=pm.newQuery(SQL,"DELETE FROM REGISTROCONSUMO");
		Query hUtensilio=pm.newQuery(SQL,"DELETE FROM UTENSILIO");
		Query hProducto=pm.newQuery(SQL,"DELETE FROM PRODUCTO");
		Query hServicioprestamo=pm.newQuery(SQL,"DELETE FROM SERVICIOPRESTAMO");
		Query hServicio=pm.newQuery(SQL,"DELETE FROM SERVICIO");
		Query hCartaproductos=pm.newQuery(SQL,"DELETE FROM CARTAPRODUCTOS");
		Query hEstilo=pm.newQuery(SQL,"DELETE FROM ESTILO");
		Query hHorarioservicio=pm.newQuery(SQL,"DELETE FROM HORARIOSERVICIO");
		Query hCostoadicional=pm.newQuery(SQL,"DELETE FROM COSTOADICIONAL");
		Query hTipocobro=pm.newQuery(SQL,"DELETE FROM TIPOCOBRO");
		Query hPlanconsumo=pm.newQuery(SQL,"DELETE FROM PLANCONSUMO");
		Query hTipoplanconsumo=pm.newQuery(SQL,"DELETE FROM TIPOPLANCONSUMO");
		Query hRestricciones=pm.newQuery(SQL,"DELETE FROM RESTRICCIONES");
		Query hServicioprestamoutensilio=pm.newQuery(SQL,"DELETE FROM SERVICIOPRESTAMOUTENSILIO");
		Query hProductoplanconsumo=pm.newQuery(SQL,"DELETE FROM PRODUCTOPLANCONSUMO");
		Query hCartaproductosproductos=pm.newQuery(SQL,"DELETE FROM CARTAPRODUCTOSPRODUCTOS");
		Query hServiciohorarioservicio=pm.newQuery(SQL,"DELETE FROM SERVICIOHORARIOSERVICIO");
		Query hConsumoofertaservicio=pm.newQuery(SQL,"DELETE FROM CONSUMOOFERTASERVICIO");
		Query hConsumomuebleconconsumo=pm.newQuery(SQL,"DELETE FROM CONSUMOMUEBLECONCONSUMO");
		Query hPlanconsumoservicio=pm.newQuery(SQL,"DELETE FROM PLANCONSUMOSERVICIO");
		Query hHotelusuario=pm.newQuery(SQL,"DELETE FROM HOTELUSUARIO");
		Query hPlanconsumorestricciones=pm.newQuery(SQL,"DELETE FROM PLANCONSUMORESTRICCIONES");
		Query hUsuarioplanconsumo=pm.newQuery(SQL,"DELETE FROM USUARIOPLANCONSUMO");
		Query hHotelplanconsumo=pm.newQuery(SQL,"DELETE FROM HOTELPLANCONSUMO");
		Query hConsumocostoadicional=pm.newQuery(SQL,"DELETE FROM CONSUMOCOSTOADICIONAL");
		
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
		long ConsumocostoadicionalEliminados = Long.valueOf(hConsumocostoadicional.executeUnique().toString());
		
		
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
