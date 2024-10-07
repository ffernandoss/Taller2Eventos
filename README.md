# Taller 2 Eventos

[https://github.com/ffernandoss/Taller1EventosFInal.git](https://github.com/ffernandoss/Taller2Eventos.git)

Este ejercicio está compuesto por las clases `ActividadPrincipal`, `PantallaConfiguracion` y `PantallaInicio`,`AsyncTask`,`AsyncTaskLoader`

## Clase PantallaInicio

- **Descripción**: Tiene métodos para poner un mensaje de bienvenida personalizado dependiendo de la hora del día, y un botón para ir a la siguiente ventana. Todo esto se encuentra dentro de una columna para que esté todo mejor posicionado.

## Clase ActividadPrincipal

- **Descripción**: Tiene métodos para introducir un nombre en un campo de texto, un botón para guardar ese nombre y un botón para avanzar a la siguiente pantalla si se ha guardado un nombre. Si no hay nombre guardado, sale un mensaje de error y no deja continuar.

## Clase PantallaConfiguracion

- **Descripción**: Tiene una serie de botones para cambiar el fondo de pantalla. El color que se seleccione se queda guardado hasta que se elija otro, y un botón para volver a la `PantallaPrincipal`. También se encuentran dentro de una columna estos elementos.

## Clase NetworkTask

- **Descripción**: Realiza operaciones en segundo plano utilizando `AsyncTask`. Muestra mensajes de progreso y finalización mediante `Toast`.

## Clase NetworkTaskLoader

- **Descripción**: Realiza operaciones en segundo plano utilizando `AsyncTaskLoader`. Simula una operación de red y devuelve el resultado.

## Paquete

- **Ubicación**: Las cinco clases se encuentran dentro del paquete `com.example.taller1eventos`.

## Clases de Test

- **Descripción**: Tanto la pantalla de `ActividadPrincipal` como la de `PantallaConfiguracion` tienen una clase de test para cada una, las cuales se encuentran dentro del paquete `com.example.taller1eventos`.
