CREATE TABLE Cuenta(
    idCuenta NUMBER,	
    fechaApertura TIMESTAMP NOT NULL,  	
    fechaCierre TIMESTAMP,
    habitacion NUMBER
);

CREATE TABLE Usuario(
    idUsuario NUMBER,
    pazSalvo CHAR,


    tipoDocumento VARCHAR2(256) NOT NULL,
    numeroDocumento VARCHAR2(256) NOT NULL,	
    correo  VARCHAR2(256) NOT NULL,	
    nombre  VARCHAR2(256) NOT NULL, 	
    cuenta NUMBER,
    tipoUsuario NUMBER NOT NULL,
    acompanante NUMBER,
    contrasena VARCHAR2(256) NOT NULL
);


CREATE TABLE Prenda(
    idPrenda NUMBER,		
    tipoPrenda VARCHAR2(256) NOT NULL,	
    costoLavado FLOAT NOT NULL,
    cliente NUMBER NOT NULL
);


CREATE TABLE Reserva(
    idReserva NUMBER,	
    diaHora	TIMESTAMP NOT NULL,
    duracion FLOAT ,	
    aceptada CHAR NOT NULL,
    numPersonas	NUMBER,
    planPago VARCHAR2(256) NOT NULL,
    fechaSalida	TIMESTAMP,
    cliente	NUMBER NOT NULL,
    habitacion	NUMBER NOT NULL,
    ofertaServicio	NUMBER,
    servicio NUMBER
);


CREATE TABLE Habitacion(
idHabitacion NUMBER,
capacidad NUMBER NOT NULL,
costoAloj FLOAT NOT NULL,	
hotel NUMBER NOT NULL, 
tipoHabitacion NUMBER NOT NULL
);

CREATE TABLE Mueble(
    idMueble NUMBER,
    tipoMueble VARCHAR2(256) NOT NULL,
    costoMueble FLOAT NOT NULL,
    habitacion NUMBER NOT NULL
);

CREATE TABLE ConsumoConMueble(
    idMueble NUMBER,	
    costo FLOAT NOT NULL,
    usado CHAR NOT NULL
);
CREATE TABLE Consumo(
    idConsumo NUMBER,	
    fecha CHAR NOT NULL,	
    cuenta	NUMBER,
    registroConsumo NUMBER,	
    empleado NUMBER NOT NULL
);


CREATE TABLE TipoHabitacion(
    idTipoHabitacion NUMBER,	 
    nombre VARCHAR2(256) NOT NULL,
    descripcion VARCHAR2(256) NOT NULL

);
CREATE TABLE TipoUsuario(
    idTipoUsuario NUMBER,	
    ROL VARCHAR2(256) NOT NULL
	

);
CREATE TABLE Hotel(
    idHotel NUMBER,
    nombre VARCHAR2(256) NOT NULL,	
    CadenaHotelera NUMBER NOT NULL
		

);
CREATE TABLE CadenaHotelera(
    idCadenaHotelera NUMBER,
    nombre VARCHAR2(256) NOT NULL

);
CREATE TABLE OfertaServicio(
idOfertaServicio NUMBER,	
costo FLOAT NOT NULL,	
duracion FLOAT NOT NULL
);
CREATE TABLE RegistroConsumo(
idRegistroConsumo NUMBER
);

CREATE TABLE Utensilio(
    idUtensilio NUMBER,	
    estado VARCHAR2(256) NOT NULL,	
    entregado CHAR NOT NULL
);

CREATE TABLE Producto(
    idProducto NUMBER,	
    nombre VARCHAR2(256) NOT NULL,	 
    costo FLOAT NOT NULL,
    consumo NUMBER
);

CREATE TABLE ServicioPrestamo(
    idPrestamo NUMBER,	 
    fechaPrestamo TIMESTAMP NOT NULL,	
    fechaReintegro TIMESTAMP,	
    consumo NUMBER
);

CREATE TABLE Servicio(
    idServicio NUMBER,	 
    capacidad NUMBER NOT NULL,
    nombre VARCHAR2(256) NOT NULL,	 
    capacidad_actual NUMBER NOT NULL,
    cartaProductos NUMBER,	
    registroConsumo NUMBER,
    hotel NUMBER NOT NULL,
    ofertaServicio NUMBER,	
    tipoCobro NUMBER NOT NULL,	
    estilo NUMBER ,	
    profundidad FLOAT
);
CREATE TABLE CartaProductos(
    idCarta NUMBER,	
    nombre VARCHAR2(256) NOT NULL
);
CREATE TABLE Estilo(
    idEstilo NUMBER,
    nombre VARCHAR2(256) NOT NULL
);
CREATE TABLE HorarioServicio(
    idHorarioServicio NUMBER,	
    horaInicio TIMESTAMP NOT NULL,	
    duracion FLOAT NOT NULL
);
CREATE TABLE CostoAdicional(
    idCostoAdicional NUMBER,	
    nombre VARCHAR2(256) NOT NULL,	
    costo FLOAT	NOT NULL,
    servicio NUMBER
);
CREATE TABLE TipoCobro(
    idTipoCobro NUMBER,	
    nombre VARCHAR2(256)
);

CREATE TABLE PlanConsumo(
    idPlanConsumo NUMBER,	
    nombre VARCHAR2(256) NOT NULL,
    descuento FLOAT,	
    descripcion VARCHAR2(256) NOT NULL,
    periodoVigencia1 TIMESTAMP,	
    periodoVigencia2 TIMESTAMP,	
    tipoPlanConsumo NUMBER NOT NULL
);
CREATE TABLE TipoPlanConsumo(
    idTipoPlanConsumo NUMBER,	
    nombre VARCHAR2(256) NOT NULL
);
CREATE TABLE Restricciones(
    idRestriccion NUMBER,	
    cantidad NUMBER NOT NULL,	
    producto NUMBER
);
CREATE TABLE ServicioPrestamoUtensilio(
    idServicioPrestamo NUMBER,	
    idUtensilio NUMBER
);
CREATE TABLE ProductoPlanConsumo(
    idProducto NUMBER,
    idPlanConsumo NUMBER
);
CREATE TABLE CartaProductosProductos(
    idCarta NUMBER,	
    idProducto NUMBER
);
CREATE TABLE ServicioHorarioServicio(
    idServicio NUMBER,	
    idHorarioServicio NUMBER
);  
CREATE TABLE ConsumoOfertaServicio(
    idConsumo NUMBER,	 
    idOfertaServicio NUMBER
);

CREATE TABLE ConsumoMuebleConConsumo(
    idConsumo NUMBER,	
    idMuebleConConsumo NUMBER
);

CREATE TABLE PlanConsumoServicio(
    idPlanConsumo NUMBER,	
    idServicio NUMBER
);
CREATE TABLE HotelUsuario(
    idHotel NUMBER,
    idUsuario NUMBER
);

CREATE TABLE PlanConsumoRestricciones(
    idPlanConsumo NUMBER,	
    idRestriccion NUMBER
);
CREATE TABLE UsuarioPlanConsumo(
    idUsuario NUMBER,	
    idPlanConsumo NUMBER
);

CREATE TABLE HotelPlanConsumo(
    idHotel NUMBER,	
    idPlanConsumo NUMBER
);
CREATE TABLE ConsumoCostoAdicional(
    idConsumo NUMBER,	
    idCostoAdicional NUMBER
);
commit;

/*PRIMARY KEY TABLAS*/

ALTER TABLE Habitacion ADD CONSTRAINT Habitacion_PK PRIMARY KEY (idHabitacion);
ALTER TABLE USUARIO ADD CONSTRAINT USUARIO_PK PRIMARY KEY (idUsuario);
ALTER TABLE Mueble ADD CONSTRAINT Mueble_PK PRIMARY KEY (idMueble);
ALTER TABLE ConsumoConMueble ADD CONSTRAINT ConsumoConMueble_PK PRIMARY KEY (idMueble);
ALTER TABLE Consumo ADD CONSTRAINT Consumo_PK PRIMARY KEY (idConsumo);
ALTER TABLE TipoHabitacion ADD CONSTRAINT TipoHabitacion_PK PRIMARY KEY (idTipoHabitacion);
ALTER TABLE TipoUsuario ADD CONSTRAINT TipoUsuario_PK PRIMARY KEY (idTipoUsuario);
ALTER TABLE Hotel ADD CONSTRAINT Hotel_PK PRIMARY KEY (idHotel);
ALTER TABLE CadenaHotelera ADD CONSTRAINT CadenaHotelera_PK PRIMARY KEY (idCadenaHotelera);
ALTER TABLE OfertaServicio ADD CONSTRAINT OfertaServicio_PK PRIMARY KEY (idOfertaServicio);
ALTER TABLE RegistroConsumo ADD CONSTRAINT RegistroConsumo_PK PRIMARY KEY (idRegistroConsumo);
ALTER TABLE Utensilio ADD CONSTRAINT Utensilio_PK PRIMARY KEY (idUtensilio);
ALTER TABLE Producto ADD CONSTRAINT Producto_PK PRIMARY KEY (idProducto);
ALTER TABLE ServicioPrestamo ADD CONSTRAINT ServicioPrestamo_PK PRIMARY KEY (idPrestamo);
ALTER TABLE Servicio ADD CONSTRAINT Servicio_PK PRIMARY KEY (idServicio);
ALTER TABLE CartaProductos ADD CONSTRAINT CartaProductos_PK PRIMARY KEY (idCarta);
ALTER TABLE Estilo ADD CONSTRAINT Estilo_PK PRIMARY KEY (idEstilo);
ALTER TABLE HorarioServicio ADD CONSTRAINT HorarioServicio_PK PRIMARY KEY (idHorarioServicio);
ALTER TABLE CostoAdicional ADD CONSTRAINT CostoAdicional_PK PRIMARY KEY (idCostoAdicional);
ALTER TABLE TipoCobro ADD CONSTRAINT TipoCobro_PK PRIMARY KEY (idTipoCobro);
ALTER TABLE PlanConsumo ADD CONSTRAINT PlanConsumo_PK PRIMARY KEY (idPlanConsumo);
ALTER TABLE TipoPlanConsumo ADD CONSTRAINT TipoPlanConsumo_PK PRIMARY KEY (idTipoPlanConsumo);
ALTER TABLE Restricciones ADD CONSTRAINT Restricciones_PK PRIMARY KEY (idRestriccion);
ALTER TABLE ServicioPrestamoUtensilio ADD CONSTRAINT ServicioPrestamoUtensilio_PK PRIMARY KEY (idServicioPrestamo, idUtensilio);
ALTER TABLE ProductoPlanConsumo ADD CONSTRAINT ProductoPlanConsumo_PK PRIMARY KEY (idProducto, idPlanConsumo);
ALTER TABLE CartaProductosProductos ADD CONSTRAINT CartaProductosProductos_PK PRIMARY KEY (idCarta, idProducto);
ALTER TABLE ServicioHorarioServicio ADD CONSTRAINT ServicioHorarioServicio_PK PRIMARY KEY (idServicio, idHorarioServicio);
ALTER TABLE ConsumoOfertaServicio ADD CONSTRAINT ConsumoOfertaServicio_PK PRIMARY KEY (idConsumo, idOfertaServicio);
ALTER TABLE ConsumoMuebleConConsumo ADD CONSTRAINT ConsumoMuebleConConsumo_PK PRIMARY KEY (idConsumo, idMuebleConConsumo);
ALTER TABLE PlanConsumoServicio ADD CONSTRAINT PlanConsumoServicio_PK PRIMARY KEY (idPlanConsumo, idServicio);
ALTER TABLE HotelUsuario ADD CONSTRAINT HotelUsuario_PK PRIMARY KEY (idHotel, idUsuario);
ALTER TABLE PlanConsumoRestricciones ADD CONSTRAINT PlanConsumoRestricciones_PK PRIMARY KEY (idPlanConsumo, idRestriccion);
ALTER TABLE UsuarioPlanConsumo ADD CONSTRAINT UsuarioPlanConsumo_PK PRIMARY KEY (idUsuario, idPlanConsumo);
ALTER TABLE HotelPlanConsumo ADD CONSTRAINT HotelPlanConsumo_PK PRIMARY KEY (idHotel, idPlanConsumo);
ALTER TABLE ConsumoCostoAdicional ADD CONSTRAINT ConsumoCostoAdicional_PK PRIMARY KEY (idConsumo, idCostoAdicional);
ALTER TABLE CUENTA ADD CONSTRAINT CUENTA_PK PRIMARY KEY (idCuenta);
ALTER TABLE PRENDA ADD CONSTRAINT PRENDA_PK PRIMARY KEY (idPrenda);
ALTER TABLE RESERVA ADD CONSTRAINT RESERVA_PK PRIMARY KEY (idReserva);


/*FOREIGN KEY ConsumoConMueble*/
ALTER TABLE ConsumoConMueble ADD CONSTRAINT ConsumoConMueble_idMueble_FK FOREIGN KEY  (idMueble) REFERENCES Mueble(idMueble);
/*FOREIGN KEY USUARIO*/
ALTER TABLE Usuario ADD CONSTRAINT Usuario_TipoUsuario_FK FOREIGN KEY (tipoUsuario) REFERENCES TipoUsuario(idTipoUsuario);
/*FOREIGN KEY PRENDA*/
ALTER TABLE PRENDA ADD CONSTRAINT PRENDA_cliente_FK FOREIGN KEY  (cliente) REFERENCES Usuario(idUsuario);
/*FOREIGN KEY CUENTA*/
ALTER TABLE CUENTA ADD CONSTRAINT CUENTA_habitacion_FK FOREIGN KEY  (habitacion) REFERENCES Habitacion(idHabitacion);
/*FOREIGN KEY CONSUMO*/
ALTER TABLE Consumo ADD CONSTRAINT Consumo_registroConsumo_FK FOREIGN KEY  (registroConsumo) REFERENCES RegistroConsumo(idRegistroConsumo);
ALTER TABLE Consumo ADD CONSTRAINT Consumo_empleado_FK FOREIGN KEY  (empleado) REFERENCES Usuario(idUsuario);
ALTER TABLE Consumo ADD CONSTRAINT Consumo_cuenta_FK FOREIGN KEY  (cuenta) REFERENCES CUENTA(IDCUENTA);
/*FOREIGN KEY RESERVA*/
ALTER TABLE Reserva ADD CONSTRAINT Reserva_cliente_FK FOREIGN KEY  (cliente) REFERENCES Usuario(idUsuario);
ALTER TABLE Reserva ADD CONSTRAINT Reserva_habitacion_FK FOREIGN KEY  (habitacion) REFERENCES Habitacion(idHabitacion);
ALTER TABLE Reserva ADD CONSTRAINT Reserva_ofertaServicio_FK FOREIGN KEY  (ofertaServicio) REFERENCES OfertaServicio(idOfertaServicio);
ALTER TABLE Reserva ADD CONSTRAINT Reserva_servicio_FK FOREIGN KEY  (servicio) REFERENCES Servicio(idServicio);
/*FOREIGN KEY HABITACION*/
ALTER TABLE Habitacion ADD CONSTRAINT Habitacion_tipoHabitacion_FK FOREIGN KEY  (tipoHabitacion) REFERENCES TipoHabitacion(idTipoHabitacion);
ALTER TABLE Habitacion ADD CONSTRAINT Habitacion_hotel_FK FOREIGN KEY  (hotel) REFERENCES Hotel(idHotel);
/*FOREIGN KEY MUEBLE*/
ALTER TABLE Mueble ADD CONSTRAINT Mueble_habitacion_FK FOREIGN KEY  (habitacion) REFERENCES Habitacion(idHabitacion);
/*FOREIGN KEY HOTEL*/
ALTER TABLE Hotel ADD CONSTRAINT Hotel_cadenaHotelera_FK FOREIGN KEY  (cadenaHotelera) REFERENCES CadenaHotelera(idCadenaHotelera);
/*FOREIGN KEY UTENSILIO*/
ALTER TABLE Utensilio ADD CONSTRAINT Utensilio_idUtensilio_FK FOREIGN KEY  (idUtensilio) REFERENCES Producto(idProducto);
ALTER TABLE Utensilio ADD check (estado IN ('Dañado', 'En buen estado', 'Nuevo', 'usado','medio usado','destruido'));
/*FOREIGN KEY PRODUCTO*/
ALTER TABLE Producto ADD CONSTRAINT Producto_consumo_FK FOREIGN KEY  (consumo) REFERENCES Consumo(idConsumo);
/*FOREIGN KEY SERVICIOPRESTAMO*/
ALTER TABLE ServicioPrestamo ADD CONSTRAINT ServicioPrestamo_consumo_FK FOREIGN KEY  (consumo) REFERENCES Consumo(idConsumo);
/*FOREIGN KEY SERVICIO*/
ALTER TABLE Servicio ADD CONSTRAINT Servicio_cartaProductos_FK FOREIGN KEY  (cartaProductos) REFERENCES CartaProductos(idCarta);
ALTER TABLE Servicio ADD CONSTRAINT Servicio_estilo_FK FOREIGN KEY  (estilo) REFERENCES Estilo(idEstilo);
ALTER TABLE Servicio ADD CONSTRAINT Servicio_tipoCobro_FK FOREIGN KEY  (tipoCobro) REFERENCES TipoCobro(idTipoCobro);
ALTER TABLE Servicio ADD CONSTRAINT Servicio_ofertaServicio_FK FOREIGN KEY  (ofertaServicio) REFERENCES OfertaServicio(idOfertaServicio);
ALTER TABLE Servicio ADD CONSTRAINT Servicio_hotel_FK FOREIGN KEY  (hotel) REFERENCES Hotel(idHotel);
ALTER TABLE servicio ADD CONSTRAINT servicio_registroConsumo_FK FOREIGN KEY  (registroConsumo) references RegistroConsumo(idRegistroConsumo);
/*FOREIGN KEY COSTOADICIONAL*/
ALTER TABLE COSTOADICIONAL ADD CONSTRAINT COSTOADICIONAL_servicio_FK FOREIGN KEY  (servicio) references Servicio(idServicio);
/*FOREIGN KEY PLANCONSUMO*/
ALTER TABLE PLANCONSUMO ADD CONSTRAINT PLANCONSUMO_tipoPlanConsumo_FK FOREIGN KEY  (tipoPlanConsumo) references TipoPlanConsumo(idTipoPlanConsumo);
/*FOREIGN KEY RESTRICCIONES*/
ALTER TABLE RESTRICCIONES ADD CONSTRAINT RESTRICCIONES_producto_FK FOREIGN KEY  (producto) references Producto(idProducto);
/*FOREIGN KEY SERVICIOPRESTAMOUTENSILIO*/
ALTER TABLE SERVICIOPRESTAMOUTENSILIO ADD CONSTRAINT SERVICIOPRESTAMOUTENSILIO_idServicioPrestamo_FK FOREIGN KEY  (idServicioPrestamo) references ServicioPrestamo(idPrestamo);
ALTER TABLE SERVICIOPRESTAMOUTENSILIO ADD CONSTRAINT SERVICIOPRESTAMOUTENSILIO_idUtensilio_FK FOREIGN KEY  (idUtensilio) references Utensilio(idUtensilio);
/*FOREIGN KEY PRODUCTOPLANCONSUMO*/
ALTER TABLE PRODUCTOPLANCONSUMO ADD CONSTRAINT PRODUCTOPLANCONSUMO_idProducto_FK FOREIGN KEY  (idProducto) references Producto(idProducto);
ALTER TABLE PRODUCTOPLANCONSUMO ADD CONSTRAINT PRODUCTOPLANCONSUMO_idPlanConsumo_FK FOREIGN KEY  (idPlanConsumo) references PlanConsumo(idPlanConsumo);
/*FOREIGN KEY CARTAPRODUCTOSPRODUCTOS*/
ALTER TABLE CARTAPRODUCTOSPRODUCTOS ADD CONSTRAINT CARTAPRODUCTOSPRODUCTOS_idCarta_FK FOREIGN KEY  (idCarta) references CartaProductos(idCarta);
ALTER TABLE CARTAPRODUCTOSPRODUCTOS ADD CONSTRAINT CARTAPRODUCTOSPRODUCTOS_idProducto_FK FOREIGN KEY  (idProducto) references Producto(idProducto);
/*FOREIGN KEY SERVICIOHORARIOSERVICIO*/
ALTER TABLE SERVICIOHORARIOSERVICIO ADD CONSTRAINT SERVICIOHORARIOSERVICIO_idServicio_FK FOREIGN KEY  (idServicio) references Servicio(idServicio);
ALTER TABLE SERVICIOHORARIOSERVICIO ADD CONSTRAINT SERVICIOHORARIOSERVICIO_idHorarioServicio_FK FOREIGN KEY  (idHorarioServicio) references HorarioServicio(idHorarioServicio);
/*FOREIGN KEY CONSUMOOFERTASERVICIO*/
ALTER TABLE CONSUMOOFERTASERVICIO ADD CONSTRAINT CONSUMOOFERTASERVICIO_idConsumo_FK FOREIGN KEY  (idConsumo) references Consumo(idConsumo);
ALTER TABLE CONSUMOOFERTASERVICIO ADD CONSTRAINT CONSUMOOFERTASERVICIO_idOfertaServicio_FK FOREIGN KEY  (idOfertaServicio) references OfertaServicio(idOfertaServicio);
/*FOREIGN KEY CONSUMOMUEBLECONCONSUMO*/
ALTER TABLE CONSUMOMUEBLECONCONSUMO ADD CONSTRAINT CONSUMOMUEBLECONCONSUMO_idConsumo_FK FOREIGN KEY  (idConsumo) references Consumo(idConsumo);
ALTER TABLE CONSUMOMUEBLECONCONSUMO ADD CONSTRAINT CONSUMOMUEBLECONCONSUMO_idMuebleConConsumo_FK FOREIGN KEY  (idMuebleConConsumo) references Mueble(idMueble);
/*FOREIGN KEY PLANCONSUMOSERVICIO*/
ALTER TABLE PLANCONSUMOSERVICIO ADD CONSTRAINT PLANCONSUMOSERVICIO_idPlanConsumo_FK FOREIGN KEY  (idPlanConsumo) references PlanConsumo(idPlanConsumo);
ALTER TABLE PLANCONSUMOSERVICIO ADD CONSTRAINT PLANCONSUMOSERVICIO_idServicio_FK FOREIGN KEY  (idServicio) references Servicio(idServicio);
/*FOREIGN KEY HOTELUSUARIO*/
ALTER TABLE HOTELUSUARIO ADD CONSTRAINT HOTELUSUARIO_idHotel_FK FOREIGN KEY  (idHotel) references Hotel(idHotel);
ALTER TABLE HOTELUSUARIO ADD CONSTRAINT HOTELUSUARIO_idUsuario_FK FOREIGN KEY  (idUsuario) references Usuario(idUsuario);
/*FOREIGN KEY PLANCONSUMORESTRICCIONES*/
ALTER TABLE PLANCONSUMORESTRICCIONES ADD CONSTRAINT PLANCONSUMORESTRICCIONES_idPlanConsumo_FK FOREIGN KEY  (idPlanConsumo) references PlanConsumo(idPlanConsumo);
ALTER TABLE PLANCONSUMORESTRICCIONES ADD CONSTRAINT PLANCONSUMORESTRICCIONES_idRestriccion_FK FOREIGN KEY  (idRestriccion) references Restricciones(idRestriccion);
/*FOREIGN KEY USUARIOPLANCONSUMO*/
ALTER TABLE USUARIOPLANCONSUMO ADD CONSTRAINT USUARIOPLANCONSUMO_idUsuario_FK FOREIGN KEY  (idUsuario) references Usuario(idUsuario);
ALTER TABLE USUARIOPLANCONSUMO ADD CONSTRAINT USUARIOPLANCONSUMO_idPlanConsumo_FK FOREIGN KEY  (idPlanConsumo) references PlanConsumo(idPlanConsumo);
/*FOREIGN KEY HOTELPLANCONSUMO*/
ALTER TABLE HOTELPLANCONSUMO ADD CONSTRAINT HOTELPLANCONSUMO_idHotel_FK FOREIGN KEY  (idHotel) references Hotel(idHotel);
ALTER TABLE HOTELPLANCONSUMO ADD CONSTRAINT HOTELPLANCONSUMO_idPlanConsumo_FK FOREIGN KEY  (idPlanConsumo) references PlanConsumo(idPlanConsumo);
/*FOREIGN KEY CONSUMOCOSTOADICIONAL*/
ALTER TABLE CONSUMOCOSTOADICIONAL ADD CONSTRAINT CONSUMOCOSTOADICIONAL_idConsumo_FK FOREIGN KEY  (idConsumo) references Consumo(idConsumo);
ALTER TABLE CONSUMOCOSTOADICIONAL ADD CONSTRAINT CONSUMOCOSTOADICIONAL_idCostoAdicional_FK FOREIGN KEY  (idCostoAdicional) references CostoAdicional(idCostoAdicional);
commit;



 





