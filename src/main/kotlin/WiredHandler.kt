package uk.co.tombryant.ynab.poller

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.twilio.Twilio
import com.twilio.rest.api.v2010.account.Message
import com.twilio.type.PhoneNumber
import uk.co.tombryant.ynab.poller.ynab.YNABClient
import java.time.LocalDate

class WiredHandler(
    private val configProvider: ConfigProvider,
    private val ynabClient: YNABClient
) : RequestHandler<Any, String> {
    init {
        Twilio.init(
            configProvider.twilioAccountSsid,
            configProvider.twilioAuthToken
        )
    }

    override fun handleRequest(input: Any, context: Context?): String {
        val today = LocalDate.now()
        val oneWeekAgo = today.minusDays(6)

        val transactions = ynabClient
            .getTransactions(configProvider.ynabBudgetId, sinceDate = oneWeekAgo)
            .data
            .transactions

        val numTransactions = transactions.size
        val totalValue = transactions
            .mapNotNull { it.amount }
            .sum()
            .let { "£${it / 1000.0}" }

        val message = "You have made $numTransactions transactions in the last week, to the sum of $totalValue."

        sendMessage(
            configProvider.recipientPhoneNumber,
            configProvider.senderPhoneNumber,
            message
        )
        return input.toString()
    }

    private fun sendMessage(to: String, from: String, message: String): Message {
        return Message.creator(
            PhoneNumber(to),
            PhoneNumber(from),
            message
        ).create()
    }
}
