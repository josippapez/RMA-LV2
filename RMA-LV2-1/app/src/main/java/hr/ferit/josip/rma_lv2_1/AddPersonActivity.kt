package hr.ferit.josip.rma_lv2_1

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.add_person_activity.*
import java.util.*


class AddPersonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_person_activity)
        buttonAdd.setOnClickListener {
            if (name.text.toString() != "" || pictureUrl.text.toString() != "") {
                PersonRepository.add(
                    ImportantPerson(
                        pictureUrl.text.toString(),
                        name.text.toString(),
                        years.text.toString(),
                        description.text.toString(),
                        arrayOf("")
                    )
                )
                finish()
            } else {
                Toast.makeText(
                    ImportantPeopleApplication.ApplicationContext,
                    "Please enter name and picture URL atleast",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

}
