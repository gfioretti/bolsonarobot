import mu.KotlinLogging
import java.io.File

val fileUtilsLogger = KotlinLogging.logger {}
class FileUtils(
    pathToFile: String
) {
    private val file = File("${System.getProperty("user.dir")}$pathToFile")
    private val listOfWords = file.readLines()
    val wordToBePosted = listOfWords.first()

    fun saveFileAfterPost() {
        fileUtilsLogger.info { "Preparing to remove word $wordToBePosted and save new file." }
        file.apply {
            this.bufferedWriter().use { out ->
                listOfWords.drop(1).forEach { out.write(it + "\n") }
            }
        }
        fileUtilsLogger.info { "Done." }
    }
}