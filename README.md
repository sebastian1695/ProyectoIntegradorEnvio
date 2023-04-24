# ProyectoIntegradorEnvio
Esta API REST es un microservicio de mensajería en el cual se relacionan los clientes, los empleados, y el envío de paquetes. Mediante este servicio, los usuarios pueden interactuar con la API REST de diferentes maneras. Por un lado, la API REST permite que el usuario se inscriba en la base de datos mediante el uso de ENDPOINTS, así mismo, el usuario puede generar un envío a través del microservicio especificando el peso del paquete. Un Envío se compone de un paquete, una dirección, un número de guía y una persona que recibe el paquete. Así mismo, el envío cuenta con estados de entrega, retraso o no entrega. Únicamente el empleado puede cambiar el estado del envío, por lo cual la API REST cuenta con un servicio de autenticación que le otorga permisos para cambiar ese estado. 

El microservicio hace uso de varias tecnologías, cada una cumple con una función específica. Por un lado, la base de datos se maneja a través de MySQL Workbench, los endpoints son manejados a través de dos servicios: Swagger e Insomnia. Cuando se usa Insomnia, las peticiones se hacen a través del formato Json. Cuando se usa Swagger, las peticiones se generan a través de los campos especificados. 

El proyecto está construido con la versión de '2.7.10' de Spring Boot, opera con la dependencia MAVEN que es compatible con java 11. Además de esta dependencia, el servicio cuenta con tres dependencias importantes: Spring Data JPA, Spring web y JUnit. 


Las rutas para cada uno de los servicios se generan a través de los siguientes # ENDPOINTS:

## ENDPOINTS CLIENTES:

## Crear un cliente 
POST: http://localhost:8080/api/v1/cliente
Los parámetros y formatos de entrada son los siguientes: 

Cedula: formato numérico, números enteros(integer)
Nombre: formato de texto, letras (String)
Apellidos: formato de texto, letras (String)
Celular: formato numérico, números enteros (Integer)
Correo: formato de tecto, letras y simbolos (String)
Dirección: formato de texto, campo alfanumérico (String) 
Ciudad: formato de texto, letras (String) 

Ejemplo de la petición:
"{
“Cedula”:123.
“Nombre”: “Sebastián”,
“Apellidos”: “Rodríguez”,
“Celular”: 310302, 
“Correo”: “csebastianrodriguezc@gmail.com”,
“Direccion”: “cl1-2”,
“Ciudad”: “Bogotá”
}
"
Respuesta de la petición

{
“Cedula”:123,
“Nombre”: “Sebastián”,
“Apellidos”: “Rodríguez”,
“Celular”: 310302, 
“Correo”: “csebastianrodriguezc@gmail.com”,
“Direccion”: “cl1-2”,
“Ciudad”: “Bogotá”
}

O bien, “cliente creado satisfactoriamente”

## Buscar cliente por cédula
GET: http://localhost:8080/api/v1/cliente{cedula}
Los parámetros y formatos de entrada son los siguientes: 

Cedula: formato numérico, números enteros(integer)


Ejemplo de la petición:
GET: http://localhost:8080/api/v1/cliente/123


Respuesta de la petición:

{
“Cedula”:123,
“Nombre”: “Sebastián”,
“Apellidos”: “Rodríguez”,
“Celular”: 310302, 
“Correo”: “csebastianrodriguezc@gmail.com”,
“Direccion”: “cl1-2”,
“Ciudad”: “Bogotá”
}

## Actualizar cliente
PUT: http://localhost:8080/api/v1/cliente{cedula}
Los parámetros y formatos de entrada son los siguientes:
Cedula: formato numérico, números enteros(integer)
Nombre: formato de texto, letras (String)
Apellidos: formato de texto, letras (String)
Celular: formato numérico, números enteros (Integer)
Correo: formato de tecto, letras y simbolos (String)
Dirección: formato de texto, campo alfanumérico (String) 
Ciudad: formato de texto, letras (String) 

Ejemplo de la petición:
PUT: http://localhost:8080/api/v1/cliente/123

Respuesta de la petición:
{
“Cedula”:123,
“Nombre”: “Sebastián”,
“Apellidos”: “Rodríguez”,
“Celular”: 310302, 
“Correo”: “csebastianrodriguezc@gmail.com”,
“Direccion”: “cl1-2”,
“Ciudad”: “Cali”
}
## Borrar cliente
DELETE:http://localhost:8080/api/v1/cliente{cedula}
Los parámetros y formatos de entrada son los siguientes: 
Cedula: formato numérico, números enteros(integer)

Ejemplo de la petición:

	DELETE:http://localhost:8080/api/v1/cliente/123
Respuesta de la petición 
“Cliente eliminado exitosamente” 

## ENDPOINTS EMPLEADOS:

## Crear un empleado 
POST: http://localhost:8080/api/v1/empleado
Los parámetros y formatos de entrada son los siguientes: 

Cedula: formato numérico, números enteros(integer)
Nombre: formato de texto, letras (String)
Apellidos: formato de texto, letras (String)
Celular: formato numérico, números enteros (Integer)
Dirección: formato de texto,letras (String)
Correo: formato de texto, letras y símbolos (String)
Ciudad: formato de texto, letras (String) 
Antigüedad: formato numérico, números enteros (Integer)
Rh: formato alfanumérico, letras y símbolos (String)
Tipo: formato de texto, letras (String)

Ejemplo de la petición:
{
“Cedula”:123.
“Nombre”: “Sebastián”,
“Apellidos”: “Rodríguez”,
“Celular”: 310302, 
“Direccion”: “cl1-2”,
“Correo”: “csebastianrodriguezc@gmail.com”,
“Ciudad”: “Bogotá”,
“Antiguedad”: 4,
“Rh”: “O+”,
“Tipo”: “REPARTIDOR”
}

Respuesta de la petición:

{
“Cedula”:123,
“Nombre”: “Sebastián”,
“Apellidos”: “Rodríguez”,
“Celular”: 310302, 
“Correo”: “csebastianrodriguezc@gmail.com”,
“Direccion”: “cl1-2”,
“Ciudad”: “Bogotá”
“Antigüedad”: 4,
“Rh”: “O+”,
“Tipo”: “REPARTIDOR”
}

O bien, “empleado creado satisfactoriamente”

## Buscar empleado por cédula
GET: http://localhost:8080/api/v1/empleado{cedula}
Los parámetros y formatos de entrada son los siguientes: 

Cedula: formato numérico, números enteros(integer)


Ejemplo de la petición:
GET: http://localhost:8080/api/v1/empleado/123


Respuesta de la petición:


{
“Cedula”:123,
“Nombre”: “Sebastián”,
“Apellidos”: “Rodríguez”,
“Celular”: 310302, 
“Correo”: “csebastianrodriguezc@gmail.com”,
“Direccion”: “cl1-2”,
“Ciudad”: “Bogotá”,
“Antigüedad”: 4,
“Rh”: “O+”,
“Tipo”: “REPARTIDOR”

}

## Actualizar empleado
PUT: http://localhost:8080/api/v1/empleado{cedula}
Los parámetros y formatos de entrada son los siguientes:
Cedula: formato numérico, números enteros(integer)
Nombre: formato de texto, letras (String)
Apellidos: formato de texto, letras (String)
Celular: formato numérico, números enteros (Integer)
Correo: formato de tecto, letras y simbolos (String)
Dirección: formato de texto, campo alfanumérico (String) 
Ciudad: formato de texto, letras (String) 
Antigüedad: formato numérico, números enteros (Integer)
Rh: formato alfanumérico, letras y símbolos (String)
Tipo: formato de texto, letras (String)

Ejemplo de la petición:
PUT: http://localhost:8080/api/v1/empleado/123

Respuesta de la petición:
{
“Cedula”:123,
“Nombre”: “Sebastián”,
“Apellidos”: “Rodríguez”,
“Celular”: 310302, 
“Correo”: “csebastianrodriguezc@gmail.com”,
“Direccion”: “cl1-2”,
“Ciudad”: “Cali”,
Antigüedad”: 4,
“Rh”: “O+”,
“Tipo”: “COORDINADOR”
}

## Borrar empleado
DELETE:http://localhost:8080/api/v1/empleado{cedula}
Los parámetros y formatos de entrada son los siguientes: 
Cedula: formato numérico, números enteros(integer)

Ejemplo de la petición:

	DELETE:http://localhost:8080/api/v1/empleado/123
Respuesta de la petición 
“Empleado eliminado exitosamente” 

## ENDPOINTS ENVÍOS:
## Crear envío
POST: http://localhost:8080/api/v1/envio
Los parámetros y formatos de entrada son los siguientes:

cedula: cedula del cliente (numero entero)
celularRecibe: numero de celular de quien recibe el paquete (cadena de texto)
nombreRecibe: nombre de la persona que recibe el paquete (cadena de texto)
ciudadDestino: ciudad de destino del paquete (cadena de texto)
ciudadOrigen: ciudad de origen del paquete (cadena de texto)
peso: peso en kilogramos del paquete (número decimal)
valorDeclarado: valor en peso declarado del contenido del paquete (número de
Ejemplo de la petición:

POST: http://localhost:8080/api/v1/envio
{
  "cedula": 0,
  "celularRecibe": "string",
  "ciudadDestino": "string",
  "ciudadOrigen": "string",
  "dirDestino": "string",
  "nombreRecibe": "string",
  "peso": 0,
  "valorDeclarado": 0
}

Respuesta de la petición:

{
“numeroGuia”: 1,
“Estado”: “RECIBIDO”
}

## Buscar envío
GET: http://localhost:8080/api/v1/envio/{num-guia}
Los parámetros y formatos de entrada son los siguientes:

numeroGuia: Número guía del pedido(integer) 

Ejemplo de la petición:

GET: http://localhost:8080/api/v1/envio/1

Respuesta de la petición: 
{
“numeroGuia”: 1.
“Cedula”: 123,
“Nombre”: “Sebastián
 "celularRecibe": 31123232,
  "ciudadDestino": "Cali",
  "ciudadOrigen": "Medellín",
  "dirDestino": "cl1-2",
  "nombreRecibe": "Pedro",
  "peso": 2,
  "valorDeclarado": 30000.0,
“valorEnvio”: 30000,0.
}
## Actualizar estado de envío
PUT: http://localhost:8080/api/v1/envio/estado
Los parámetros y formatos de entrada son los siguientes:
Cedula: (empleado) Integer, 
estado : “RECIBIDO, EN_RUTA, ENTREGADO”
numeroGuia: numero de guía, (Integer)

Ejemplo de la petición: 
PUT: http://localhost:8080/api/v1/envio/estado
{
“cedula”: 123,
“Estado”: “RECIBIDO”,
“numeroGuia”: 1
}

Respuesta de la petición 
{
“numeroGuia”: 1,
“Estado”: “ENTREGADO”
}

## Buscar envíos por estado
GET: http://localhost:8080/api/v1/envio/estado/{estado}
Los parámetros y formatos de entrada son los siguientes:

Cedula: formato numérico, números enteros (Integer)

Ejemplo de la petición: 


GET: http://localhost:8080/api/v1/envio/estado/ENTREGADO

Respuesta de la petición:

El programa devolverá la información relacionada con el pedido solicitado, desde la información del envío, hasta la información del cliente y del paquete. 

## DIAGRAMA UML





![Screen Shot 2023-04-24 at 4 12 42 PM](https://user-images.githubusercontent.com/119948037/234118115-88b7ccc7-f31e-4bc9-b420-bc1c02082560.png)

## DIAGRAMA ENTIDAD-RELACIÓN

![Screen Shot 2023-04-24 at 4 13 42 PM](https://user-images.githubusercontent.com/119948037/234118278-16d11900-7d3b-4ef2-9a98-175eba24e815.png)




