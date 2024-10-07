import android.os.AsyncTask
import android.content.Context
import android.widget.Toast

// Clase NetworkTask que extiende AsyncTask para realizar operaciones en segundo plano
class NetworkTask(private val context: Context) : AsyncTask<Void, Int, String>() {

    // Método que se ejecuta antes de iniciar la tarea en segundo plano
    override fun onPreExecute() {
        super.onPreExecute()
        // Muestra un mensaje Toast indicando que la tarea ha iniciado
        Toast.makeText(context, "Tarea iniciada", Toast.LENGTH_SHORT).show()
    }

    // Método que realiza la tarea en segundo plano
    override fun doInBackground(vararg params: Void?): String {
        // Simula una operación de red con un bucle
        for (i in 1..10) {
            Thread.sleep(500) // Pausa de 500 milisegundos
            publishProgress(i * 10) // Publica el progreso de la tarea
        }
        return "Tarea completada" // Devuelve el resultado de la tarea
    }

    // Método que se ejecuta cuando se publica el progreso de la tarea
    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
        // Muestra un mensaje Toast con el progreso actual
        values[0]?.let {
            Toast.makeText(context, "Progreso: $it%", Toast.LENGTH_SHORT).show()
        }
    }

    // Método que se ejecuta cuando la tarea en segundo plano ha finalizado
    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        // Muestra un mensaje Toast con el resultado de la tarea
        Toast.makeText(context, result, Toast.LENGTH_SHORT).show()
    }
}