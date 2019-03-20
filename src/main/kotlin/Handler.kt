package uk.co.tombryant.ynab.poller

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import uk.co.tombryant.ynab.poller.ynab.YNABClient

open class Handler : RequestHandler<Any, String> {
    private val wiredHandler: WiredHandler

    init {
        val configProvider = AmazonSecureConfigProvider()
        wiredHandler = WiredHandler(
            configProvider,
            YNABClient(configProvider.ynabPersonalAccessToken)
        )
    }

    override fun handleRequest(input: Any, context: Context?): String {
        return wiredHandler.handleRequest(input, context)
    }
}
