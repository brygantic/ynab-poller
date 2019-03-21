package uk.co.tombryant.ynab.poller.aws

data class CloudWatchInputMessage(
    val version: String?,
    val id: String?,
    val detailType: String?,
    val source: String?,
    val account: String?,
    val time: String?,
    val region: String?,
    val resources: List<String>?,
    val detail: Any?
)
