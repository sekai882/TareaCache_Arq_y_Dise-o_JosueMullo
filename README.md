# Instrucciones para el profesor – Calculadora de Sueldo

## Contexto
Esta aplicación fue desarrollada cumpliendo las especificaciones de la tarea **ISWZ2202 – Diseño y Arquitectura de Software**:

- Implementación de **caché** para optimizar el cálculo de sueldos y descuentos.
- Implementación del patrón **Proxy** mediante un interceptor que registra todas las peticiones al backend.
- Resolución de problemas de **CORS** para permitir la comunicación entre frontend y backend en desarrollo.
- Desarrollo del **frontend** utilizando React, que consume los endpoints del backend.

---

## Estructura del proyecto

- **Backend**: carpeta `backend-calculadora-sueldo` (**Spring Boot + Java**).  
- **Frontend**: carpeta `frontend-calculadora-sueldo` (**React + Vite**).

---

## Ejecución

### Backend
1. Abrir `backend-calculadora-sueldo` en IntelliJ IDEA.  
2. Ejecutar la clase principal `BackendCalculadoraSueldoApplication.java`.  
3. Mantenerlo corriendo; el backend escucha en **`http://localhost:8080`**.

> ⚠️ **Nota:** Si el frontend se ejecuta en un puerto diferente (por ejemplo, no `5174`), modificar la línea de **@CrossOrigin** en el backend:  
> ```java
> @CrossOrigin(origins = "http://localhost:5174") // cambiar al puerto que corresponda
> ```  
> Luego volver a ejecutar el backend.

### Frontend
1. Abrir `frontend-calculadora-sueldo` en IntelliJ IDEA o cualquier editor compatible.  
2. Abrir la terminal en la carpeta del frontend y ejecutar:
   ```bash
   npm install   # instalar dependencias (solo la primera vez)
   npm run dev   # iniciar servidor de desarrollo
3. Abrir el navegador en http://localhost:5174(u otro si es necesario)  para usar la calculadora.

Funcionamiento

Ingresar el sueldo base en el frontend y presionar Calcular.

El backend calcula el sueldo total aplicando bonos y descuentos.

Si el mismo sueldo se consulta nuevamente, se obtiene la respuesta desde la caché, evitando recalcular.

Todas las peticiones pasan por el proxy (interceptor) que registra la solicitud en la consola.

Notas

Backend y frontend deben ejecutarse simultáneamente para que la aplicación funcione correctamente.

El frontend está configurado para permitir peticiones desde http://localhost:5174 gracias a CORS.

Esta aplicación está preparada para ambientes de desarrollo local, siguiendo la consigna de la tarea.
