
/*REQ FUNCIONAL 1*/
INSERT INTO TIPOUSUARIO(
    IDTIPOUSUARIO,
    ROL
  )
VALUES
  (
      1,'ADMINISTRADOR_DATOS'
  );
INSERT INTO TIPOUSUARIO(
    IDTIPOUSUARIO,
    ROL
  )
VALUES
  (
      2,'GERENTE'
  );
INSERT INTO TIPOUSUARIO(
    IDTIPOUSUARIO,
    ROL
  )
VALUES
  (
      3,'CLIENTE'
  );
INSERT INTO TIPOUSUARIO(
    IDTIPOUSUARIO,
    ROL
  )
VALUES
  (
      4,'RECEPCIONISTA'
  );
INSERT INTO TIPOUSUARIO(
    IDTIPOUSUARIO,
    ROL
  )
VALUES
  (
      5,'EMPLEADO'
  );
/*REQ FUNCIONAL 2*/
/*Clientes*/
INSERT INTO USUARIO(
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
      1,'Y','CC','12345678','b.riverah@uniandes.edu.co','Brian Rivera1',15,3,null,'123'
  );
INSERT INTO USUARIO(
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
      2,'Y','CC','12345678','b.riverah@uniandes.edu.co','Brian Rivera2',15,3,1,'123'
  );
INSERT INTO USUARIO(
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
      3,'Y','CC','12345678','b.riverah@uniandes.edu.co','Brian Rivera3',15,3,1,'123'
  );
INSERT INTO USUARIO(
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
      4,'Y','CC','12345678','b.riverah@uniandes.edu.co','Brian Rivera4',15,3,1,'123'
  );
/*Admin datos*/
INSERT INTO USUARIO(
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
      5,'Y','CC','12345678','ADMIN','Brian',null,1,1,'123'
  );

/*Gerente*/
INSERT INTO USUARIO(
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
      6,'Y','CC','12345678','GERENTE','Brian',null,2,null,'123'
  );


/*Empleados*/
INSERT INTO USUARIO(
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
      7,'Y','CC','12345678','EMP1','Brian Rivera1E',null,5,null,'123'
  );
INSERT INTO USUARIO(
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
      8,'Y','CC','12345678','EMP2','Brian Rivera2E',null,5,null,'123'
  );
INSERT INTO USUARIO(
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
      9,'Y','CC','12345678','EMP3','Brian Rivera3E',null,5,null,'123'
  );
INSERT INTO USUARIO(
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
      10,'Y','CC','12345678','EMP4','Brian Rivera4E',null,5,null,'123'
  );
  /*Recepcionista*/
  INSERT INTO USUARIO(
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
      11,'Y','CC','12345678','RECEP','Brian Rivera3Rec',null,4,null,'123'
  );
INSERT INTO USUARIO(
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
      12,'Y','CC','12345678','RECEP','Brian RiveraRec',null,4,null,'123'
  );

/*REQ FUNCIONAL 3*/

INSERT INTO TIPOHABITACION(
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

INSERT INTO TIPOHABITACION(
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
INSERT INTO TIPOHABITACION(
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
INSERT INTO CADENAHOTELERA(
    IDCADENAHOTELERA,
    NOMBRE
  )
VALUES
  (
    1,
    'Hoteles de los Alpes'
  );

INSERT INTO HOTEL(
    IDHOTEL,
    NOMBRE,
    CADENAHOTELERA
  )
VALUES
  (
    1,
    'Hotel de los Alpes',
    1
  );

INSERT INTO HABITACION(
    IDHABITACION,
    CAPACIDAD,
    COSTOALOJ,
    HOTEL,
    TIPOHABITACION
  )
VALUES
  (
    1,
    10,
    20,
    1,
    1
  );

INSERT INTO HABITACION(
    IDHABITACION,
    CAPACIDAD,
    COSTOALOJ,
    HOTEL,
    TIPOHABITACION
  )
VALUES
  (
    2,
    10,
    20,
    1,
    1
  );

INSERT INTO HABITACION(
    IDHABITACION,
    CAPACIDAD,
    COSTOALOJ,
    HOTEL,
    TIPOHABITACION
  )
VALUES
  (
    3,
    10,
    20,
    1,
    1
  );

  INSERT INTO HABITACION(
    IDHABITACION,
    CAPACIDAD,
    COSTOALOJ,
    HOTEL,
    TIPOHABITACION
  )
VALUES
  (
    4,
    10,
    20,
    1,
    2
  );

  INSERT INTO HABITACION(
    IDHABITACION,
    CAPACIDAD,
    COSTOALOJ,
    HOTEL,
    TIPOHABITACION
  )
VALUES
  (
    5,
    10,
    20,
    1,
    2
  );

  INSERT INTO HABITACION(
    IDHABITACION,
    CAPACIDAD,
    COSTOALOJ,
    HOTEL,
    TIPOHABITACION
  )
VALUES
  (
    6,
    10,
    20,
    1,
    2
  );

  INSERT INTO HABITACION(
    IDHABITACION,
    CAPACIDAD,
    COSTOALOJ,
    HOTEL,
    TIPOHABITACION
  )
VALUES
  (
    7,
    10,
    20,
    1,
    3
  );

  INSERT INTO HABITACION(
    IDHABITACION,
    CAPACIDAD,
    COSTOALOJ,
    HOTEL,
    TIPOHABITACION
  )
VALUES
  (
    8,
    10,
    20,
    1,
    3
  );
    INSERT INTO HABITACION(
    IDHABITACION,
    CAPACIDAD,
    COSTOALOJ,
    HOTEL,
    TIPOHABITACION
  )
VALUES
  (
    9,
    10,
    20,
    1,
    3
  );
/*RF5 - REGISTRAR UN SERVICIO DEL HOTEL*/
INSERT INTO TIPOCOBRO(
    IDTIPOCOBRO,
    NOMBRE
  )
VALUES
  (
    1,
    'Incluido Habitacion'
  );
INSERT INTO HORARIOSERVICIO(
    IDHORARIOSERVICIO,
    HORAINICIO,
    DURACION
  )
VALUES
  (
    1,
    to_timestamp('2013-01-01 00:00:00', 'yyyy-mm-dd hh24:mi:ss'),
    30
  );
INSERT INTO SERVICIO(
    IDSERVICIO,
    CAPACIDAD,
    NOMBRE,
    CAPACIDAD_ACTUAL,
    CARTAPRODUCTOS,
    REGISTROCONSUMO,
    HOTEL,
    OFERTASERVICIO,
    TIPOCOBRO,
    ESTILO,
    PROFUNDIDAD
  )
VALUES
  (
    1,
    2,
    'Piscina',
    10,
    null,
    null,
    1,
    null,
    1,
    null,
    50
  );

INSERT INTO SERVICIOHORARIOSERVICIO(
    IDSERVICIO,
    IDHORARIOSERVICIO
  )
VALUES
  (
    1,
    1
  );

commit;