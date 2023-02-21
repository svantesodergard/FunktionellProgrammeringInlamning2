package elfs

class Tomteland {

    //TODO: skapa en datastruktur för att lagra tomtarna och deras relationer i
    val bossToUnderlings = mapOf(
        "Tomten" to listOf("Glader" , "Butter"),
        "Glader" to listOf("Tröger", "Trötter" , "Blyger"),
        "Butter" to listOf("Rådjuret", "Nyckelpigan", "Haren" , "Räven"),
        "Trötter" to listOf("Skumtomten"),
        "Skumtomten" to listOf("Dammråttan"),
        "Räven" to listOf("Gråsuggan" , "Myran"),
        "Myran" to listOf("Bladlusen"),
    )

    fun getUnderlings(currentName: String, l: MutableList<String> = mutableListOf()): List<String> {
        bossToUnderlings[currentName]?.forEach {
            l.add(it)
            l.addAll(getUnderlings(it))
        }
        return l
    }

    fun main() {
        //Exempel på anrop till den rekursiva funktionen getUnderlings,
        // här är tanken att hitta Gladers underlydande
        //listan fylls på successivt när vi rekurserar
        println(getUnderlings("Tomten"))
    }
}
fun main() = Tomteland().main()