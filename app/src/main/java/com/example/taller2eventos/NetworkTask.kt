import android.os.AsyncTask
import android.content.Context
import android.widget.Toast

class NetworkTask(private val context: Context) : AsyncTask<Void, Int, String>() {

    override fun onPreExecute() {
        super.onPreExecute()
        Toast.makeText(context, "Tarea iniciada", Toast.LENGTH_SHORT).show()
    }

    override fun doInBackground(vararg params: Void?): String {
        for (i in 1..10) {
            Thread.sleep(500) // Simula una operación de red
            publishProgress(i * 10) // Publica el progreso
        }
        return "Tarea completada"
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
        values[0]?.let {
            Toast.makeText(context, "Progreso: $it%", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        Toast.makeText(context, result, Toast.LENGTH_SHORT).show()
    }
}