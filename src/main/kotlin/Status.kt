class Status(
    private val word: String
) {
    val isComposed: Boolean = word.contains("-")
    val pronoum: String = definePronoum()

    fun getFinalStatus(): String {
        return "Bolsonaro é $pronoum $word"
    }

    private fun definePronoum(): String {
        val currentWord = if (isComposed) word.split('-')[0] else word
        return if(currentWord.last().toString() == "a") "uma" else "um"
    }
}