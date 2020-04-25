package hr.ferit.josip.rma_lv2_1

data class ImportantPerson (
    val url: String,
    val name: String,
    val years: String,
    val description: String,
    val quotes : Array<String>
    ){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ImportantPerson

        if (url != other.url) return false
        if (name != other.name) return false
        if (years != other.years) return false
        if (description != other.description) return false
        if (!quotes.contentEquals(other.quotes)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = url.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + years.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + quotes.contentHashCode()
        return result
    }
}