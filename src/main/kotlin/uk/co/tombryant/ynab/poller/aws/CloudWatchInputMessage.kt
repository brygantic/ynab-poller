package uk.co.tombryant.ynab.poller.aws

data class CloudWatchInputMessage(
    val version: String? = null,
    val id: String? = null,
    val detailType: String? = null,
    val source: String? = null,
    val account: String? = null,
    val time: String? = null,
    val region: String? = null,
    val resources: List<String>? = null,
    val detail: Any? = null
)
