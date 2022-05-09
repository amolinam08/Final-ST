-- Parametros: idCliente, fechaIn, fechafin

SELECT (CUENTA.IDCUENTA, CUENTA.HABITACION)
FROM CUENTA INNER JOIN 
    (SELECT IDHABITACION
    FROM HABITACION
    WHERE CUENTA = c)tabla1 ON tabla1.idHabitacion = CUENTA.HABITACION
    (SELECT CUENTA
    FROM CONSUMO) tabla2 ON tabla2.CUENTA = CUENTA.IDCUENTA
WHERE fecha BETWEEN fechaIn AND fechafin;


-- Parametros: TiempoDeseado, Servicio o habitacion = deseado, fecha1, fecha2

SELECT IDDESEADO
FROM CUENTA INNER JOIN
(SELECT CUENTAID
 FROM CUENTA 
  WHERE SALDO> 15.000.000)mayoromenorI
(SELECT IDHabitacion
From Habitaciones
WHERE OCUPADO> 80)mayoromenorD
Where fecha between fecha1 and fecha2
ORDER BY mayoromenorD, mayoromenorI
