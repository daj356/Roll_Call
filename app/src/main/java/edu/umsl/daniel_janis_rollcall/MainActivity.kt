package edu.umsl.daniel_janis_rollcall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.names_item_layout.*
import org.json.JSONArray

class MainActivity : AppCompatActivity() {//}, ClassFragment.GetClassListener {

    private val classes = arrayOf(
        Classes("Web Dev Adv JavaScript", 4011, "Mo/We", 8, 0),
        Classes("Android Apps Fundamentals", 4020, "Tu/Th", 5, 0),
        Classes("Program Translation", 4280, "Tu/Th", 6, 0),
        Classes("Intro to AI", 4300, "Mo/We", 7, 0)
    )

    private lateinit var model: StudentsModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val class1Present = classes[0].presentStudents / classes[0].totalStudents
        val class1Text = classes[0].courseName + '\n' + classes[0].courseNumber + '\n' + classes[0].courseTime + '\n' + classes[0].presentStudents + '/' + classes[0].totalStudents + '(' + class1Present + ')'
        val class2Present = classes[1].presentStudents / classes[1].totalStudents
        val class2Text = classes[1].courseName + '\n' + classes[1].courseNumber + '\n' + classes[1].courseTime + '\n' + classes[1].presentStudents + '/' + classes[1].totalStudents + '(' + class2Present + ')'
        val class3Present = classes[2].presentStudents / classes[2].totalStudents
        val class3Text = classes[2].courseName + '\n' + classes[2].courseNumber + '\n' + classes[2].courseTime + '\n' + classes[2].presentStudents + '/' + classes[2].totalStudents + '(' + class3Present + ')'
        val class4Present = classes[3].presentStudents / classes[3].totalStudents
        val class4Text = classes[3].courseName + '\n' + classes[3].courseNumber + '\n' + classes[3].courseTime + '\n' + classes[3].presentStudents + '/' + classes[3].totalStudents + '(' + class4Present + ')'
        class1Button.text = class1Text
        class2Button.text = class2Text
        class3Button.text = class3Text
        class4Button.text = class4Text

        // model != null, then use "model = ModelHolder.instance.get(StudentsModel::class)"
        // else use "model = StudentsModel()"
        model = ModelHolder.instance.get(StudentsModel::class) ?: StudentsModel()
        ModelHolder.instance.set(model)
        val classFragment = ClassFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(classFragment, "TAG")
        transaction.commit()

        classFragment.listener = classListener

        class1Button.setOnClickListener {
            model.populate1()
            classFragment.getClass()
        }
        class2Button.setOnClickListener {
            model.populate2()
            classFragment.getClass()
        }
        class3Button.setOnClickListener {
            model.populate3()
            classFragment.getClass()
        }
        class4Button.setOnClickListener {
            model.populate4()
            classFragment.getClass()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        ModelHolder.instance.set(model)
    }

    private val classListener = object : ClassFragment.GetClassListener {
        override fun gotClassWith(results: ArrayList<Names>?) {
            Log.e("ACTIVITY", "I received a call!!!!!!")
            // SEND IN JSONdata here!!! ---> WAS model, changed to results
            ModelHolder.instance.set(model)

            val intent = Intent(this@MainActivity, NamesListingActivity::class.java)
            //intent.getBooleanArrayExtra()
            startActivity(intent)
        }

        override fun gotClassFailedWith(error: Error) {

        }
    }
}

