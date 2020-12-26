import mu.KotlinLogging
import twitter4j.TwitterFactory
import twitter4j.conf.ConfigurationBuilder

val twitterClientLogger = KotlinLogging.logger {}
class TwitterClient {
    private val config = ConfigurationBuilder()
        .setDebugEnabled(true)
        .setOAuthConsumerKey(Props.OAUTH_CONSUMER_KEY)
        .setOAuthConsumerSecret(Props.OAUTH_CONSUMER_SECRET)
        .setOAuthAccessToken(Props.OAUTH_TOKEN)
        .setOAuthAccessTokenSecret(Props.OAUTH_ACCESS_TOKEN_SECRET)
        .build()
    private val twitterInstance = TwitterFactory(config).instance

    fun updateStatus(status: String) {
        twitterInstance
            .apply {
                twitterClientLogger.info { "Posting status: $status" }
                kotlin
                    .runCatching { updateStatus(status) }
                    .onSuccess { twitterClientLogger.info { "Post was successful." } }
                    .onFailure {
                        twitterClientLogger.error { "Post failed" }
                        twitterClientLogger.error { it.message }
                        throw it
                    }
            }
            .also {
                twitterClientLogger.info { "Asserting posting status" }
                assert(it.userTimeline.first().text == status)
                twitterClientLogger.info { "Post was successful." }
            }
    }
}