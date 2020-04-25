package hr.ferit.josip.rma_lv2_1

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_person.*


class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))
        displayData()
        val mFab = findViewById<FloatingActionButton>(R.id.fab)
        mFab.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddPersonActivity::class.java))
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        (recyclerView.adapter as ImportantPeopleAdapter).refreshData(PersonRepository.people)
    }

    override fun onStop() {
        super.onStop()
    }
    private fun displayData() {
        recyclerView.adapter = ImportantPeopleAdapter(PersonRepository.people)
    }
}
