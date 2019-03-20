package uk.co.tombryant.ynab.poller.ynab

data class Wrapper<T>(val data: T)

data class BudgetWrapper(val budget: Budget, val serverKnowledge: Int)
data class TransactionsWrapper(val transactions: List<Transaction>, val serverKnowledge: Int)

data class Budget(
    val id: String?,
    val name: String?,
    val lastModifiedOn: String?,
    val dateFormat: DateFormat?,
    val currencyFormat: CurrencyFormat?,
    val accounts: List<Account>?,
    val payees: List<Payee>?,
    val payeeLocations: List<PayeeLocation>?,
    val categoryGroups: List<CategoryGroup>?,
    val months: List<Month>?,
    val transactions: List<Transaction>?,
    val subtransactions: List<Subtransaction>?,
    val scheduledTransactions: List<ScheduledTransaction>?,
    val scheduledSubtransactions: List<ScheduledSubtransaction>?
)

data class DateFormat(val format: String)

data class CurrencyFormat(
    val isoCode: String?,
    val exampleFormat: String?,
    val decimialDigits: Int?,
    val decimalSeparator: String?,
    val symbolFirst: Boolean?,
    val groupSeparator: String?,
    val currencySymbol: String?,
    val displaySymbol: Boolean?,
    val categories: List<Category>?
)

data class Account(
    val id: String?,
    val name: String?,
    val type: String?,
    val onBudget: Boolean?,
    val closed: Boolean?,
    val note: String?,
    val balance: Int?,
    val clearedBalance: Int?,
    val unclearedBalance: Int?,
    val transferPayeeId: String?,
    val deleted: Boolean
)

data class Payee(
    val id: String?,
    val name: String?,
    val transferAccountId: String?,
    val deleted: Boolean
)

data class PayeeLocation(
    val id: String?,
    val payeeId: String?,
    val latitude: String?,
    val longitude: String?,
    val deleted: Boolean
)

data class CategoryGroup(
    val id: String?,
    val name: String?,
    val hidden: Boolean?,
    val deleted: Boolean
)

data class Category(
    val id: String?,
    val categoryGroupId: String?,
    val name: String?,
    val hidden: Boolean?,
    val originalCategoryGroupId: String?,
    val note: String?,
    val budgeted: Int?,
    val activity: Int?,
    val balance: Int?,
    val goalType: String?,
    val goalCreationMonth: String?,
    val goalTarget: Int?,
    val goalTargetMonth: String?,
    val goalPercentageComplete: Int?,
    val deleted: Boolean
)

data class Month(
    val month: String?,
    val note: String?,
    val income: Int?,
    val budgeted: Int?,
    val activity: Int?,
    val toBeBudgeted: Int?,
    val ageOfMoney: Int?,
    val deleted: Boolean?,
    val categories: List<Category>?
)

data class Transaction(
    val id: String?,
    val date: String?,
    val amount: Int?,
    val memo: String?,
    val cleared: String?,
    val approved: Boolean?,
    val flagColor: String?,
    val accountId: String?,
    val payeeId: String?,
    val categoryId: String?,
    val transferAccountId: String?,
    val transferTransactionId: String?,
    val matchedTransactionId: String?,
    val importId: String?,
    val deleted: Boolean
)

data class Subtransaction(
    val id: String?,
    val transactionId: String?,
    val amount: Int?,
    val memo: String?,
    val payeeId: String?,
    val categoryId: String?,
    val transferAccountId: String?,
    val deleted: Boolean
)

data class ScheduledTransaction(
    val id: String?,
    val dateFirst: String?,
    val dateNext: String?,
    val frequency: String?,
    val amount: Int?,
    val memo: String?,
    val flagColor: String?,
    val accountId: String?,
    val payeeId: String?,
    val categoryId: String?,
    val transferAccountId: String?,
    val deleted: Boolean
)

data class ScheduledSubtransaction(
    val id: String?,
    val scheduledTransactionId: String?,
    val amount: Int?,
    val memo: String?,
    val payeeId: String?,
    val categoryId: String?,
    val transferAccountId: String?,
    val deleted: Boolean
)