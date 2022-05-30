alter SESSION
set
  NLS_DATE_FORMAT = 'DD-MM-YYYY HH24:MI:SS';

/*REQ FUNCIONAL 1*/
INSERT INTO
  TIPOUSUARIO(IDTIPOUSUARIO, ROL)
VALUES
  (1, 'ADMINISTRADOR_DATOS');

INSERT INTO
  TIPOUSUARIO(IDTIPOUSUARIO, ROL)
VALUES
  (2, 'GERENTE');

INSERT into
  TIPOUSUARIO(IDTIPOUSUARIO, ROL)
VALUES
  (3, 'CLIENTE');

INSERT INTO
  TIPOUSUARIO(IDTIPOUSUARIO, ROL)
VALUES
  (4, 'RECEPCIONISTA');

INSERT INTO
  TIPOUSUARIO(IDTIPOUSUARIO, ROL)
VALUES
  (5, 'EMPLEADO');

INSERT INTO
  TIPOUSUARIO(IDTIPOUSUARIO, ROL)
VALUES
  (6, 'ACOMPANANTE');

INSERT INTO
  TIPOUSUARIO(IDTIPOUSUARIO, ROL)
VALUES
  (7, 'ORGANIZADOREVENTOS');

/*REQ FUNCIONAL 2*/
/*Clientes*/
INSERT INTO
  USUARIO(
    IDUSUARIO,
    PAZSALVO,
    TIPODOCUMENTO,
    NUMERODOCUMENTO,
    CORREO,
    NOMBRE,
    CUENTA,
    TIPOUSUARIO,
    ACOMPANANTE,
    CONTRASENA
  )
VALUES
  (
    1,
    'Y',
    'CC',
    '12345678',
    'CLIENTE',
    'Brian Rivera1',
    null,
    3,
    null,
    '123'
  );

INSERT INTO
  USUARIO(
    IDUSUARIO,
    PAZSALVO,
    TIPODOCUMENTO,
    NUMERODOCUMENTO,
    CORREO,
    NOMBRE,
    CUENTA,
    TIPOUSUARIO,
    ACOMPANANTE,
    CONTRASENA
  )
VALUES
  (
    2,
    'Y',
    'CC',
    '12345678',
    'b.riverah@uniandes.edu.co',
    'Brian Rivera2',
    null,
    3,
    1,
    '123'
  );

INSERT INTO
  USUARIO(
    IDUSUARIO,
    PAZSALVO,
    TIPODOCUMENTO,
    NUMERODOCUMENTO,
    CORREO,
    NOMBRE,
    CUENTA,
    TIPOUSUARIO,
    ACOMPANANTE,
    CONTRASENA
  )
VALUES
  (
    3,
    'Y',
    'CC',
    '12345678',
    'b.riverah@uniandes.edu.co',
    'Brian Rivera3',
    null,
    3,
    1,
    '123'
  );

INSERT INTO
  USUARIO(
    IDUSUARIO,
    PAZSALVO,
    TIPODOCUMENTO,
    NUMERODOCUMENTO,
    CORREO,
    NOMBRE,
    CUENTA,
    TIPOUSUARIO,
    ACOMPANANTE,
    CONTRASENA
  )
VALUES
  (
    4,
    'Y',
    'CC',
    '12345678',
    'b.riverah@uniandes.edu.co',
    'Brian Rivera4',
    null,
    3,
    1,
    '123'
  );

/*Admin datos*/
INSERT INTO
  USUARIO(
    IDUSUARIO,
    PAZSALVO,
    TIPODOCUMENTO,
    NUMERODOCUMENTO,
    CORREO,
    NOMBRE,
    CUENTA,
    TIPOUSUARIO,
    ACOMPANANTE,
    CONTRASENA
  )
VALUES
  (
    5,
    'Y',
    'CC',
    '12345678',
    'ADMIN',
    'Brian',
    null,
    1,
    1,
    '123'
  );

/*Gerente*/
INSERT INTO
  USUARIO(
    IDUSUARIO,
    PAZSALVO,
    TIPODOCUMENTO,
    NUMERODOCUMENTO,
    CORREO,
    NOMBRE,
    CUENTA,
    TIPOUSUARIO,
    ACOMPANANTE,
    CONTRASENA
  )
VALUES
  (
    6,
    'Y',
    'CC',
    '12345678',
    'GERENTE',
    'Brian',
    null,
    2,
    null,
    '123'
  );

/*Empleados*/
INSERT INTO
  USUARIO(
    IDUSUARIO,
    PAZSALVO,
    TIPODOCUMENTO,
    NUMERODOCUMENTO,
    CORREO,
    NOMBRE,
    CUENTA,
    TIPOUSUARIO,
    ACOMPANANTE,
    CONTRASENA
  )
VALUES
  (
    7,
    'Y',
    'CC',
    '12345678',
    'EMP1',
    'Brian Rivera1E',
    null,
    5,
    null,
    '123'
  );

INSERT INTO
  USUARIO(
    IDUSUARIO,
    PAZSALVO,
    TIPODOCUMENTO,
    NUMERODOCUMENTO,
    CORREO,
    NOMBRE,
    CUENTA,
    TIPOUSUARIO,
    ACOMPANANTE,
    CONTRASENA
  )
VALUES
  (
    8,
    'Y',
    'CC',
    '12345678',
    'EMP2',
    'Brian Rivera2E',
    null,
    5,
    null,
    '123'
  );

INSERT INTO
  USUARIO(
    IDUSUARIO,
    PAZSALVO,
    TIPODOCUMENTO,
    NUMERODOCUMENTO,
    CORREO,
    NOMBRE,
    CUENTA,
    TIPOUSUARIO,
    ACOMPANANTE,
    CONTRASENA
  )
VALUES
  (
    9,
    'Y',
    'CC',
    '12345678',
    'EMP3',
    'Brian Rivera3E',
    null,
    5,
    null,
    '123'
  );

INSERT INTO
  USUARIO(
    IDUSUARIO,
    PAZSALVO,
    TIPODOCUMENTO,
    NUMERODOCUMENTO,
    CORREO,
    NOMBRE,
    CUENTA,
    TIPOUSUARIO,
    ACOMPANANTE,
    CONTRASENA
  )
VALUES
  (
    10,
    'Y',
    'CC',
    '12345678',
    'EMP4',
    'Brian Rivera4E',
    null,
    5,
    null,
    '123'
  );

/*Recepcionista*/
INSERT INTO
  USUARIO(
    IDUSUARIO,
    PAZSALVO,
    TIPODOCUMENTO,
    NUMERODOCUMENTO,
    CORREO,
    NOMBRE,
    CUENTA,
    TIPOUSUARIO,
    ACOMPANANTE,
    CONTRASENA
  )
VALUES
  (
    11,
    'Y',
    'CC',
    '12345678',
    'RECEP',
    'Brian Rivera3Rec',
    null,
    4,
    null,
    '123'
  );

INSERT INTO
  USUARIO(
    IDUSUARIO,
    PAZSALVO,
    TIPODOCUMENTO,
    NUMERODOCUMENTO,
    CORREO,
    NOMBRE,
    CUENTA,
    TIPOUSUARIO,
    ACOMPANANTE,
    CONTRASENA
  )
VALUES
  (
    12,
    'Y',
    'CC',
    '12345678',
    'RECEP',
    'Brian RiveraRec',
    null,
    4,
    null,
    '123'
  );

/*Administrador de eventos*/
INSERT INTO
  USUARIO (
    IDUSUARIO,
    PAZSALVO,
    TIPODOCUMENTO,
    NUMERODOCUMENTO,
    CORREO,
    NOMBRE,
    CUENTA,
    TIPOUSUARIO,
    ACOMPANANTE,
    CONTRASENA
  )
VALUES
  (
    13,
    NULL,
    'CC',
    '12345678',
    'ADMINEVENTOS',
    'Brian Rivera3Admin',
    null,
    7,
    null,
    '123'
  );

/*REQ FUNCIONAL 3*/
INSERT INTO
  TIPOHABITACION(
    IDTIPOHABITACION,
    NOMBRE,
    DESCRIPCION
  )
VALUES
  (
    1,
    'suite presidencial',
    'una suite presidencial con una cama king size y una cama queen size'
  );

INSERT INTO
  TIPOHABITACION(
    IDTIPOHABITACION,
    NOMBRE,
    DESCRIPCION
  )
VALUES
  (
    2,
    'suite',
    'una suite con una cama king size y una cama queen size'
  );

INSERT INTO
  TIPOHABITACION(
    IDTIPOHABITACION,
    NOMBRE,
    DESCRIPCION
  )
VALUES
  (
    3,
    'familiar',
    'una habitacion familiar con una cama king size y una cama queen size'
  );

/*REQ FUNCIONAL 4*/
INSERT INTO
  CADENAHOTELERA(IDCADENAHOTELERA, NOMBRE)
VALUES
  (1, 'Hoteles de los Alpes');

INSERT INTO
  HOTEL(
    IDHOTEL,
    NOMBRE,
    CADENAHOTELERA
  )
VALUES
  (1, 'Hotel de los Alpes', 1);

INSERT INTO
  HABITACION(
    IDHABITACION,
    CAPACIDAD,
    COSTOALOJ,
    HOTEL,
    TIPOHABITACION,
    ocupado
  )
VALUES
  (1, 10, 20, 1, 1, 'libre');

INSERT INTO
  HABITACION(
    IDHABITACION,
    CAPACIDAD,
    COSTOALOJ,
    HOTEL,
    TIPOHABITACION,
    ocupado
  )
VALUES
  (2, 10, 20, 1, 1, 'libre');

INSERT INTO
  HABITACION(
    IDHABITACION,
    CAPACIDAD,
    COSTOALOJ,
    HOTEL,
    TIPOHABITACION,
    ocupado
  )
VALUES
  (3, 10, 20, 1, 1, 'libre');

INSERT INTO
  HABITACION(
    IDHABITACION,
    CAPACIDAD,
    COSTOALOJ,
    HOTEL,
    TIPOHABITACION,
    ocupado
  )
VALUES
  (4, 10, 20, 1, 2, 'libre');

INSERT INTO
  HABITACION(
    IDHABITACION,
    CAPACIDAD,
    COSTOALOJ,
    HOTEL,
    TIPOHABITACION,
    ocupado
  )
VALUES
  (5, 10, 20, 1, 2, 'libre');

INSERT INTO
  HABITACION(
    IDHABITACION,
    CAPACIDAD,
    COSTOALOJ,
    HOTEL,
    TIPOHABITACION,
    ocupado
  )
VALUES
  (6, 10, 20, 1, 2, 'libre');

INSERT INTO
  HABITACION(
    IDHABITACION,
    CAPACIDAD,
    COSTOALOJ,
    HOTEL,
    TIPOHABITACION,
    ocupado
  )
VALUES
  (7, 10, 20, 1, 3, 'libre');

INSERT INTO
  HABITACION(
    IDHABITACION,
    CAPACIDAD,
    COSTOALOJ,
    HOTEL,
    TIPOHABITACION,
    ocupado
  )
VALUES
  (8, 10, 20, 1, 3, 'libre');

INSERT INTO
  HABITACION(
    IDHABITACION,
    CAPACIDAD,
    COSTOALOJ,
    HOTEL,
    TIPOHABITACION,
    OCUPADO
  )
VALUES
  (9, 10, 20, 1, 3, 'libre');

INSERT INTO
  HABITACION(
    IDHABITACION,
    CAPACIDAD,
    COSTOALOJ,
    HOTEL,
    TIPOHABITACION,
    OCUPADO
  )
VALUES
  (10, 10, 20, 1, 3, 'libre');

INSERT INTO
  HABITACION(
    IDHABITACION,
    CAPACIDAD,
    COSTOALOJ,
    HOTEL,
    TIPOHABITACION,
    OCUPADO
  )
VALUES
  (11, 10, 20, 1, 3, 'libre');

/*RF5 - REGISTRAR UN SERVICIO DEL HOTEL*/
INSERT INTO
  TIPOCOBRO(IDTIPOCOBRO, NOMBRE)
VALUES
  (1, 'Incluido Habitacion');

INSERT INTO
  HORARIOSERVICIO(
    IDHORARIOSERVICIO,
    HORAINICIO,
    DURACION
  )
VALUES
  (
    1,
    to_timestamp('2013-01-01 00:00:00', 'yyyy-mm-dd hh24:mi:ss'),
    3
  );

INSERT INTO
  SERVICIO(
    IDSERVICIO,
    CAPACIDAD,
    NOMBRE,
    CAPACIDAD_ACTUAL,
    CARTAPRODUCTOS,
    REGISTROCONSUMO,
    HOTEL,
    TIPOCOBRO,
    ESTILO,
    PROFUNDIDAD,
    OFERTASERVICIO
  )
VALUES
  (
    1,
    2,
    'Piscina',
    1,
    null,
    null,
    1,
    1,
    null,
    50,
    null
  );

INSERT INTO
  SERVICIO(
    IDSERVICIO,
    CAPACIDAD,
    NOMBRE,
    CAPACIDAD_ACTUAL,
    CARTAPRODUCTOS,
    REGISTROCONSUMO,
    HOTEL,
    TIPOCOBRO,
    ESTILO,
    PROFUNDIDAD,
    OFERTASERVICIO
  )
VALUES
  (
    2,
    2,
    'Gimnasio',
    1,
    null,
    null,
    1,
    1,
    null,
    null,
    null
  );

INSERT INTO
  SERVICIOHORARIOSERVICIO(IDSERVICIO, IDHORARIOSERVICIO)
VALUES
  (1, 1);

INSERT INTO
  TIPOCOBRO(IDTIPOCOBRO, NOMBRE)
VALUES
  (2, 'EFECTIVO');

INSERT INTO
  SERVICIO(
    IDSERVICIO,
    CAPACIDAD,
    NOMBRE,
    CAPACIDAD_ACTUAL,
    CARTAPRODUCTOS,
    REGISTROCONSUMO,
    HOTEL,
    TIPOCOBRO,
    ESTILO,
    PROFUNDIDAD,
    OFERTASERVICIO
  )
VALUES
  (
    3,
    30,
    'Internet',
    12,
    null,
    null,
    1,
    1,
    null,
    null,
    null
  );

INSERT INTO
  ESTILO(IDESTILO, NOMBRE)
VALUES
  (1, 'Jazz');

INSERT INTO
  REGISTROCONSUMO(IDREGISTROCONSUMO)
VALUES
  (1);

INSERT INTO
  REGISTROCONSUMO(IDREGISTROCONSUMO)
VALUES
  (2);

INSERT INTO
  REGISTROCONSUMO(IDREGISTROCONSUMO)
VALUES
  (3);

INSERT INTO
  REGISTROCONSUMO(IDREGISTROCONSUMO)
VALUES
  (4);

INSERT INTO
  REGISTROCONSUMO(IDREGISTROCONSUMO)
VALUES
  (5);

INSERT INTO
  CARTAPRODUCTOS(IDCARTA, NOMBRE)
VALUES
  (
    1,
    'Menu de productos para el Bar'
  );

INSERT INTO
  CARTAPRODUCTOS(IDCARTA, NOMBRE)
VALUES
  (
    2,
    'Menu de productos para el Restaurante'
  );

INSERT INTO
  PRODUCTO(IDPRODUCTO, NOMBRE, COSTO)
VALUES
  (1, 'Bebida1', 20);

INSERT INTO
  PRODUCTO(IDPRODUCTO, NOMBRE, COSTO)
VALUES
  (2, 'Bebida2', 20);

INSERT INTO
  PRODUCTO(IDPRODUCTO, NOMBRE, COSTO)
VALUES
  (3, 'Bebida3', 20);

INSERT INTO
  SERVICIO(
    IDSERVICIO,
    CAPACIDAD,
    NOMBRE,
    CAPACIDAD_ACTUAL,
    CARTAPRODUCTOS,
    REGISTROCONSUMO,
    HOTEL,
    TIPOCOBRO,
    ESTILO,
    PROFUNDIDAD,
    OFERTASERVICIO
  )
VALUES
  (
    4,
    30,
    'Bar',
    0,
    1,
    1,
    1,
    2,
    1,
    null,
    null
  );

INSERT INTO
  SERVICIO(
    IDSERVICIO,
    CAPACIDAD,
    NOMBRE,
    CAPACIDAD_ACTUAL,
    CARTAPRODUCTOS,
    REGISTROCONSUMO,
    HOTEL,
    TIPOCOBRO,
    ESTILO,
    PROFUNDIDAD,
    OFERTASERVICIO
  )
VALUES
  (
    5,
    30,
    'Restaurante',
    0,
    2,
    2,
    1,
    2,
    1,
    null,
    null
  );

INSERT INTO
  SERVICIO(
    IDSERVICIO,
    CAPACIDAD,
    NOMBRE,
    CAPACIDAD_ACTUAL,
    CARTAPRODUCTOS,
    REGISTROCONSUMO,
    HOTEL,
    TIPOCOBRO,
    ESTILO,
    PROFUNDIDAD,
    OFERTASERVICIO
  )
VALUES
  (
    6,
    null,
    'Supermercado',
    0,
    null,
    3,
    1,
    1,
    null,
    null,
    null
  );

INSERT INTO
  CARTAPRODUCTOSPRODUCTOS(IDCARTA, IDPRODUCTO)
VALUES
  (1, 1);

INSERT INTO
  CARTAPRODUCTOSPRODUCTOS(IDCARTA, IDPRODUCTO)
VALUES
  (1, 2);

INSERT INTO
  CARTAPRODUCTOSPRODUCTOS(IDCARTA, IDPRODUCTO)
VALUES
  (1, 3);

INSERT INTO
  CARTAPRODUCTOSPRODUCTOS(IDCARTA, IDPRODUCTO)
VALUES
  (2, 1);

INSERT INTO
  CARTAPRODUCTOSPRODUCTOS(IDCARTA, IDPRODUCTO)
VALUES
  (2, 2);

INSERT INTO
  CARTAPRODUCTOSPRODUCTOS(IDCARTA, IDPRODUCTO)
VALUES
  (2, 3);

INSERT INTO
  SERVICIO(
    IDSERVICIO,
    CAPACIDAD,
    NOMBRE,
    CAPACIDAD_ACTUAL,
    CARTAPRODUCTOS,
    REGISTROCONSUMO,
    HOTEL,
    TIPOCOBRO,
    ESTILO,
    PROFUNDIDAD,
    OFERTASERVICIO
  )
VALUES
  (
    7,
    null,
    'Tienda',
    0,
    null,
    4,
    1,
    1,
    null,
    null,
    null
  );

INSERT INTO
  SERVICIO(
    IDSERVICIO,
    CAPACIDAD,
    NOMBRE,
    CAPACIDAD_ACTUAL,
    CARTAPRODUCTOS,
    REGISTROCONSUMO,
    HOTEL,
    TIPOCOBRO,
    ESTILO,
    PROFUNDIDAD,
    OFERTASERVICIO
  )
VALUES
  (
    8,
    30,
    'SPA',
    0,
    null,
    5,
    1,
    1,
    null,
    null,
    null
  );

INSERT INTO
  SERVICIO(
    IDSERVICIO,
    CAPACIDAD,
    NOMBRE,
    CAPACIDAD_ACTUAL,
    CARTAPRODUCTOS,
    REGISTROCONSUMO,
    HOTEL,
    TIPOCOBRO,
    ESTILO,
    PROFUNDIDAD,
    OFERTASERVICIO
  )
VALUES
  (
    9,
    null,
    'Lavado/planchado/embolada',
    null,
    null,
    null,
    1,
    1,
    null,
    null,
    null
  );

/*Costos adicionales al momento de realizar la reserva del salón se registran.*/
INSERT INTO
  SERVICIO(
    IDSERVICIO,
    CAPACIDAD,
    NOMBRE,
    CAPACIDAD_ACTUAL,
    CARTAPRODUCTOS,
    REGISTROCONSUMO,
    HOTEL,
    TIPOCOBRO,
    ESTILO,
    PROFUNDIDAD,
    OFERTASERVICIO
  )
VALUES
  (
    10,
    10,
    'salon de reunion',
    0,
    null,
    null,
    1,
    1,
    null,
    null,
    null
  );

INSERT INTO
  SERVICIO(
    IDSERVICIO,
    CAPACIDAD,
    NOMBRE,
    CAPACIDAD_ACTUAL,
    CARTAPRODUCTOS,
    REGISTROCONSUMO,
    HOTEL,
    TIPOCOBRO,
    ESTILO,
    PROFUNDIDAD,
    OFERTASERVICIO
  )
VALUES
  (
    11,
    10,
    'salon de conferencia',
    0,
    null,
    null,
    1,
    1,
    null,
    null,
    NULL
  );

/*REQ FUNCIONAL 6*/
INSERT INTO
  PLANCONSUMO(
    IDPLANCONSUMO,
    NOMBRE,
    DESCUENTO,
    DESCRIPCION,
    NOCHES
  )
VALUES
  (
    1,
    'Larga estadía',
    7,
    'genera un descuento (%) en el costo del alojamiento para estadías mayores ocupado 7 noches',
    7
  );

INSERT INTO
  PLANCONSUMO(
    IDPLANCONSUMO,
    NOMBRE,
    DESCUENTO,
    DESCRIPCION,
    NOCHES
  )
VALUES
  (
    2,
    'Tiempo compartido',
    null,
    'las estadías son de 7 noches (sábado ocupado sábado) y tienen un costo total fijo; tiene
    también un porcentaje de descuento en los consumos de bar y restaurante (no necesariamente en
    todos los bares y restaurantes del hotel) y en algunos servicios. Los consumos no incluidos en el plan
    son cargados ocupado la cuenta de la habitación',
    7
  );

INSERT INTO
  PLANCONSUMO(
    IDPLANCONSUMO,
    NOMBRE,
    DESCUENTO,
    DESCRIPCION,
    NOCHES
  )
VALUES
  (
    3,
    'Todo incluido',
    null,
    'un costo fijo total cubre el alojamiento y alimentación completa (desayuno, almuerzo y
    comida). Los menús de los restaurantes tienen identificados los platos que hacen parte de este plan.
    Para los bares, normalmente incluye el consumo de bebidas nacionales (en algunos casos ponen
    límites. Por ejemplo, 3 cervezas diarias).',
    null
  );

INSERT INTO
  PLANCONSUMO(
    IDPLANCONSUMO,
    NOMBRE,
    DESCUENTO,
    DESCRIPCION,
    NOCHES
  )
VALUES
  (
    4,
    'Promociones particulares',
    52,
    'Una descripcion particular xd',
    8
  );

select
  HORAINICIO + duracion / 24
from
  HORARIOSERVICIO;

INSERT INTO
  OFERTASERVICIO(
    IDOFERTASERVICIO,
    NOMBRE,
    COSTO,
    DURACION,
    SERVICIO
  )
VALUES
  (
    1,
    'Masaje',
    10,
    1,
    8
  );

I
INSERT INTO
  CUENTA(
    IDCUENTA,
    FECHAAPERTURA,
    FECHACIERRE
  )
VALUES
  (
    1,
    to_timestamp('2019-01-01', 'YYYY-MM-DD'),
    to_timestamp('2019-12-31', 'YYYY-MM-DD')
  );

INSERT INTO
  PLANCOBRO(
    IDPLANCOBRO,
    DESCRIPCION,
    NOMBRE
  )
VALUES
  (1, 's', 's');

INSERT INTO
  CONVENCION(
    IDCONVENCION,
    FECHAINICIO,
    FECHAFIN,
    NOMBRE,
    CAPACIDADACTUAL,
    CAPACIDADMAXIMA,
    IDHOTEL,
    IDPLANCONSUMO
  )
VALUES
  (
    1,
    to_timestamp('2019-01-01', 'YYYY-MM-DD'),
    to_timestamp('2019-12-31', 'YYYY-MM-DD'),
    'Convencion de prueba',
    0,
    10,
    1,
    1
  );

/*Habitacion con id desde el 9 hasta el 11 son familiar osea tipo de habitación del 1 al 3*/
/*REQ FUNCIONAL 10*/
INSERT INTO
  REGISTROCONSUMO(IDREGISTROCONSUMO)
VALUES
  (101);

INSERT INTO
  CUENTA(
    IDCUENTA,
    FECHAAPERTURA,
    FECHACIERRE,
    HABITACION
  )
VALUES
  (
    1,
    '01-January-2023',
    '02-April-2023',
    1
  );

/*Pruebas req funcional RF15*/
--Habitaciones
INSERT INTO
  HABITACION(
    IDHABITACION,
    CAPACIDAD,
    COSTOALOJ,
    HOTEL,
    TIPOHABITACION,
    ocupado
  )
VALUES
  (30, 10, 20, 1, 1, 'libre');
INSERT INTO
  HABITACION(
    IDHABITACION,
    CAPACIDAD,
    COSTOALOJ,
    HOTEL,
    TIPOHABITACION,
    ocupado
  )
VALUES
  (31, 10, 20, 1, 1, 'ocupada');
--Cuenta
INSERT INTO CUENTA(
    IDCUENTA,
    FECHAAPERTURA,
    FECHACIERRE,
    HABITACION
  )
VALUES
  (
    30,
    TO_TIMESTAMP ('2022-05-28 14:10', 'YYYY-MM-DD HH24:MI'),
    null,
    31
  );

--Cliente
INSERT INTO
  USUARIO(
    IDUSUARIO,
    PAZSALVO,
    TIPODOCUMENTO,
    NUMERODOCUMENTO,
    CORREO,
    NOMBRE,
    CUENTA,
    TIPOUSUARIO,
    ACOMPANANTE,
    CONTRASENA
  )
VALUES
  (
    30,
    'Y',
    'CC',
    '12345678',
    'b.riverah@uniandes.edu.co',
    'Brian Rivera3',
    null,
    3,
    1,
    '123'
  );
--SERVICIO
INSERT INTO
  SERVICIO(
    IDSERVICIO,
    CAPACIDAD,
    NOMBRE,
    CAPACIDAD_ACTUAL,
    CARTAPRODUCTOS,
    REGISTROCONSUMO,
    HOTEL,
    TIPOCOBRO,
    ESTILO,
    PROFUNDIDAD,
    OFERTASERVICIO
  )
VALUES
  (
    30,
    10,
    'salon de conferencia',
    0,
    null,
    null,
    1,
    1,
    null,
    null,
    NULL
  );
INSERT INTO
  SERVICIO(
    IDSERVICIO,
    CAPACIDAD,
    NOMBRE,
    CAPACIDAD_ACTUAL,
    CARTAPRODUCTOS,
    REGISTROCONSUMO,
    HOTEL,
    TIPOCOBRO,
    ESTILO,
    PROFUNDIDAD,
    OFERTASERVICIO
  )
VALUES
  (
    31,
    10,
    'salon de conferencia',
    0,
    null,
    null,
    1,
    1,
    null,
    null,
    NULL
  );
--Reserva
INSERT INTO RESERVA(
    IDRESERVA,
    DIAHORA,
    DURACION,
    ACEPTADA,
    NUMPERSONAS,
    PLANPAGO,
    FECHASALIDA,
    CLIENTE,
    HABITACION,
    OFERTASERVICIO,
    SERVICIO
  )
VALUES
  (
   30,
    TO_TIMESTAMP ('2022-05-28 14:10', 'YYYY-MM-DD HH24:MI'),
    null,
    'N',
    0,
    'efectivo',
    TO_TIMESTAMP ('2022-06-28 14:10', 'YYYY-MM-DD HH24:MI'),
    30,
    NULL,
    null,
    30
  );
  INSERT INTO RESERVA(
    IDRESERVA,
    DIAHORA,
    DURACION,
    ACEPTADA,
    NUMPERSONAS,
    PLANPAGO,
    FECHASALIDA,
    CLIENTE,
    HABITACION,
    OFERTASERVICIO,
    SERVICIO
  )
VALUES
  (
   31,
    TO_TIMESTAMP ('2022-06-29 14:10', 'YYYY-MM-DD HH24:MI'),
    null,
    'N',
    0,
    'efectivo',
    TO_TIMESTAMP ('2022-07-28 14:10', 'YYYY-MM-DD HH24:MI'),
    30,
    NULL,
    null,
    30
  );
--Empleado
INSERT INTO
  USUARIO(
    IDUSUARIO,
    PAZSALVO,
    TIPODOCUMENTO,
    NUMERODOCUMENTO,
    CORREO,
    NOMBRE,
    CUENTA,
    TIPOUSUARIO,
    ACOMPANANTE,
    CONTRASENA
  )
VALUES
  (
    31,
    'Y',
    'CC',
    '12345678',
    'EMP1',
    'Brian Rivera1E',
    null,
    5,
    null,
    '123'
  );
--CONSUMO
INSERT INTO CONSUMO(
    IDCONSUMO,
    FECHA,
    CUENTA,
    REGISTROCONSUMO,
    EMPLEADO,
    PAGADO
  )
VALUES
  (
    30,
    TO_TIMESTAMP ('2022-05-28 14:10', 'YYYY-MM-DD HH24:MI'),
    30,
    1,
    31,
    'si'
  );

INSERT INTO CONSUMO(
    IDCONSUMO,
    FECHA,
    CUENTA,
    REGISTROCONSUMO,
    EMPLEADO,
    PAGADO
  )
VALUES
  (
    31,
    TO_TIMESTAMP ('2022-05-28 14:10', 'YYYY-MM-DD HH24:MI'),
    30,
    1,
    31,
    'si'
  );
  INSERT INTO CONSUMO(
    IDCONSUMO,
    FECHA,
    CUENTA,
    REGISTROCONSUMO,
    EMPLEADO,
    PAGADO
  )
VALUES
  (
    32,
    TO_TIMESTAMP ('2022-05-28 14:10', 'YYYY-MM-DD HH24:MI'),
    30,
    1,
    31,
    'si'
  );
/*Pruebas req funcional RF16*/
commit;