package edu.umsl.daniel_janis_rollcall
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.json.JSONArray
import java.lang.Thread.sleep
import kotlin.concurrent.thread

class ClassFragment(): Fragment() {

    var listener: GetClassListener? = null

    interface GetClassListener {
        fun gotClassWith(results: ArrayList<Names>?)
        fun gotClassFailedWith(error: Error)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("TAG", "I'm the fragment!")
        //retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.e("TAG", "onCreateView called")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    fun getClass() {
        // Assume a long running process happens
        // Now talk back to the listener!

        thread {
            sleep(2000)
            listener?.gotClassWith(null)
        }
    }
}