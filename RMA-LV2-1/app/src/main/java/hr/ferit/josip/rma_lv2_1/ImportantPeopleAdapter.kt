package hr.ferit.josip.rma_lv2_1

import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_person.view.*
import java.util.*


class ImportantPeopleAdapter(
    people: MutableList<ImportantPerson>
): RecyclerView.Adapter<PersonHolder>() {
    private val people: MutableList<ImportantPerson> = mutableListOf()

    init {
        this.people.addAll(people)
    }
    fun refreshData(people: MutableList<ImportantPerson>) {
        this.people.clear()
        this.people.addAll(people)
        this.notifyDataSetChanged()
    }
    override fun getItemCount(): Int = people.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        val personView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_person, parent, false)
        return PersonHolder(personView)
    }
    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        val person = people[position]
        holder.bind(person)
    }
}
class PersonHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(person: ImportantPerson) {
        itemView.itemPersonName.text = person.name
        itemView.itemPersonYears.text = person.years
        itemView.itemPersonDescription.text = person.description
        Picasso.get()
            .load(person.url)
            .fit()
            .error(android.R.drawable.stat_notify_error)
            .into(itemView.itemPersonPicture)
        itemView.itemPersonDescription.movementMethod = ScrollingMovementMethod()
        itemView.itemPersonPicture.setOnClickListener {
            if (person.quotes.size > 1) {
                Toast.makeText(
                    ImportantPeopleApplication.ApplicationContext,
                    person.quotes[Random().nextInt(3)],
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
