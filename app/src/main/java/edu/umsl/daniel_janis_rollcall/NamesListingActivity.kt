package edu.umsl.daniel_janis_rollcall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class NamesListingActivity(): AppCompatActivity() {

    private lateinit var viewFragment: ClassListingViewFragment
    private var model: StudentsModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_names_listing)

        model = ModelHolder.instance.get(StudentsModel::class)

        viewFragment = ClassListingViewFragment()
        viewFragment.listener = viewListener

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragmentContainer, viewFragment)
        transaction.commit()
    }

    private val viewListener = object: ClassListingViewFragment.NamesListingViewListener {
        override val names: ArrayList<Names>
            get() = model?.names ?: arrayListOf()
    }
}