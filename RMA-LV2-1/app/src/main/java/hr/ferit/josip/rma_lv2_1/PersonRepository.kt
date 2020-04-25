package hr.ferit.josip.rma_lv2_1

object PersonRepository{
    val people: MutableList<ImportantPerson>
    init {
        people = retrievePeople()
    }
    private fun retrievePeople(): MutableList<ImportantPerson> {
        return mutableListOf(
            ImportantPerson(
                "https://www.gstatic.com/tv/thumb/persons/614/614_v9_bc.jpg",
                "Bill Gates",
                "1955 - ...",
                "William Henry Gates III is an American business magnate, investor, author, philanthropist, humanitarian, and principal founder of Microsoft Corporation.",
                arrayOf("Bill Gates quote1", "Bill Gates quote2", "Bill Gates quote3")
            ),
            ImportantPerson(
                "https://www.biography.com/.image/t_share/MTY2MzU3OTcxMTUwODQxNTM1/steve-jobs--david-paul-morrisbloomberg-via-getty-images.jpg",
                "Steve Jobs",
                "1955 - 2011",
                "Steven Paul Jobs was an American business magnate and investor. He was the chairman, chief executive officer (CEO), and co-founder of Apple Inc.",
                arrayOf("Steve Jobs quote1", "Steve Jobs quote2", "Steve Jobs quote3")
            ),
            ImportantPerson(
                "https://upload.wikimedia.org/wikipedia/commons/e/ed/Elon_Musk_Royal_Society.jpg",
                "Elon Musk",
                "1971 - ...",
                "Elon Reeve Musk  is a technology entrepreneur, investor, and engineer. He is the founder, CEO, and lead designer of SpaceX; co-founder, CEO, and product architect of Tesla, Inc.",
                arrayOf("Elon Musk quote1", "Elon Musk quote2", "Elon Musk quote3")
            )
        )
    }
    fun add(person: ImportantPerson) = people.add(person)
}