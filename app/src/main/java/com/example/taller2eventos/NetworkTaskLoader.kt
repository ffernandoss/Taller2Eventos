import android.content.AsyncTaskLoader
import android.content.Context

class NetworkTaskLoader(context: Context) : AsyncTaskLoader<String>(context) {

    override fun onStartLoading() {
        forceLoad()
    }

    override fun loadInBackground(): String? {
        for (i in 1..10) {
            Thread.sleep(500) // Simula una operación de red
        }
        return "Tarea completada"
    }
}