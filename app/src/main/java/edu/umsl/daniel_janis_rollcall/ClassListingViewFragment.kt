package edu.umsl.daniel_janis_rollcall
import android.annotation.SuppressLint
import android.graphics.ColorSpace
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.graphics.toColor
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.names_item_layout.view.*
import kotlinx.android.synthetic.main.names_listing_fragment.*

class ClassListingViewFragment(): Fragment() {

    var totalStudentsPresent = 0

    var listener: NamesListingViewListener? = null
    interface NamesListingViewListener {
        val names: ArrayList<Names>
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.names_listing_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        namesListingFragmentView.layoutManager = LinearLayoutManager(activity)
        namesListingFragmentView.adapter = NamesAdapter()
    }

    inner class NamesAdapter: RecyclerView.Adapter<NameHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameHolder {
            val inflater = LayoutInflater.from(activity)
            val itemView = inflater.inflate(R.layout.names_item_layout, parent, false)
            return NameHolder(itemView)
        }

        override fun getItemCount(): Int = listener?.names?.size!!.toInt()

        override fun onBindViewHolder(holder: NameHolder, pos: Int) {
            val green = resources.getColor(R.color.selected)
            val red = resources.getColor(R.color.empty)

            val studentPresent = holder.itemView.findViewById<Button>(R.id.button1)
            val studentAbsent = holder.itemView.findViewById<Button>(R.id.button2)
            val studentLate = holder.itemView.findViewById<Button>(R.id.button3)
            val studentUnknown = holder.itemView.findViewById<Button>(R.id.button4)
            studentPresent.setOnClickListener {
                studentPresent.setTextColor(green)
                studentAbsent.setTextColor(red)
                studentLate.setTextColor(red)
                studentUnknown.setTextColor(red)
                listener!!.names[pos].here = 1
                listener!!.names[pos].present = true
                listener!!.names[pos].absent = false
                listener!!.names[pos].late = false
                listener!!.names[pos].unknown = false
                Log.e("DATA", listener!!.names.toString())
            }
            studentAbsent.setOnClickListener {
                studentPresent.setTextColor(red)
                studentAbsent.setTextColor(green)
                studentLate.setTextColor(red)
                studentUnknown.setTextColor(red)
                listener!!.names[pos].here = 0
                listener!!.names[pos].present = false
                listener!!.names[pos].absent = true
                listener!!.names[pos].late = false
                listener!!.names[pos].unknown = false
            }
            studentLate.setOnClickListener {
                studentPresent.setTextColor(red)
                studentAbsent.setTextColor(red)
                studentLate.setTextColor(green)
                studentUnknown.setTextColor(red)
                listener!!.names[pos].here = 0
                listener!!.names[pos].present = false
                listener!!.names[pos].absent = false
                listener!!.names[pos].late = true
                listener!!.names[pos].unknown = false
            }
            studentUnknown.setOnClickListener {
                studentPresent.setTextColor(red)
                studentAbsent.setTextColor(red)
                studentLate.setTextColor(red)
                studentUnknown.setTextColor(green)
                listener!!.names[pos].here = 0
                listener!!.names[pos].present = false
                listener!!.names[pos].absent = false
                listener!!.names[pos].late = false
                listener!!.names[pos].unknown = true
            }

            var totalStudentsPresent = 0
            for ((index, here) in listener?.names!!.withIndex()) {
                totalStudentsPresent += here.here
            }
            println("The totalStudentsPresent is : $totalStudentsPresent")

            listener?.names?.get(pos)?.let {
                holder.bindName(it)
            }
        }
    }

    class NameHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val studentNameView: TextView = itemView.findViewById(R.id.studentName)
        fun bindName(names: Names) {
            studentNameView.text = names.name
        }
    }
}