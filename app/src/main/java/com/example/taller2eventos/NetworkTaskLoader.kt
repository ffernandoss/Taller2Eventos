import android.content.AsyncTaskLoader
import android.content.Context

// Clase NetworkTaskLoader que extiende AsyncTaskLoader para realizar operaciones en segundo plano
class NetworkTaskLoader(context: Context) : AsyncTaskLoader<String>(context) {

    // Método que se ejecuta cuando se inicia la carga
    override fun onStartLoading() {
        forceLoad() // Fuerza la carga de datos
    }

    // Método que realiza la tarea en segundo plano
    override fun loadInBackground(): String? {
        // Simula una operación de red con un bucle
        for (i in 1..10) {
            Thread.sleep(500) // Pausa de 500 milisegundos
        }
        return "Tarea completada" // Devuelve el resultado de la tarea
    }
}