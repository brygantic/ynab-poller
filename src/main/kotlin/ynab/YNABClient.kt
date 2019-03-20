package uk.co.tombryant.ynab.poller.ynab

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.Parameters
import com.github.kittinunf.fuel.jackson.responseObject
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class YNABClient(
    private val personalAccessToken: String
) {
    private val baseAddress = "https://api.youneedabudget.com/v1"

    fun getBudget(budgetId: String): Wrapper<BudgetWrapper> = get("budgets/$budgetId")

    fun getTransactions(budgetId: String, sinceDate: LocalDate? = null): Wrapper<TransactionsWrapper> {
        val sinceDateString = sinceDate?.format(DateTimeFormatter.ISO_DATE)
        val params = sinceDateString?.let { listOf("since_date" to sinceDateString) }
        return get("budgets/$budgetId/transactions", params)
    }

    private inline fun <reified T: Any> get(path: String, parameters: Parameters? = null): T {
        return Fuel
            .get("$baseAddress/$path", parameters)
            .appendHeader("Authorization", "Bearer $personalAccessToken")
            .responseObject<T>()
            .third
            .get()
    }
}
