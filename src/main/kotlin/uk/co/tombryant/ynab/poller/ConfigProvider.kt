package uk.co.tombryant.ynab.poller

interface ConfigProvider {
    val twilioAccountSsid: String
    val twilioAuthToken: String
    val senderPhoneNumber: String
    val recipientPhoneNumber: String
    val ynabPersonalAccessToken: String
    val ynabBudgetId: String
}
