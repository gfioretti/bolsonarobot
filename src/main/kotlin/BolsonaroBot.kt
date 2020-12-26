import mu.KotlinLogging


val bolsonaroBot = KotlinLogging.logger {}
fun main() {

    bolsonaroBot.info { "Begin execution" }
    bolsonaroBot.info { "Instantiating FileUtils" }

    val fileUtils = FileUtils("/docs/finalList.txt")

    bolsonaroBot.info { "Creating status" }
    val status = Status(word = fileUtils.wordToBePosted).getFinalStatus()

    bolsonaroBot.info { "Instantiating Twitter Client" }
    val twitterClient = TwitterClient()
    twitterClient.updateStatus(status = status)

    fileUtils.saveFileAfterPost()
}
