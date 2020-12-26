class Props {
    companion object {
        val OAUTH_CONSUMER_KEY by lazy { envProp("OAUTH_CONSUMER_KEY") }
        val OAUTH_TOKEN by lazy { envProp("OAUTH_TOKEN") }
        val OAUTH_CONSUMER_SECRET by lazy { envProp("OAUTH_CONSUMER_SECRET") }
        val OAUTH_ACCESS_TOKEN_SECRET by lazy { envProp("OAUTH_ACCESS_TOKEN_SECRET") }
        private val envProp: (String) -> String = { s: String -> System.getenv(s).toString().also { println(it) } }
    }
}