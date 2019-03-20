package uk.co.tombryant.ynab.poller

import java.nio.ByteBuffer
import java.nio.charset.Charset

import com.amazonaws.util.Base64
import com.amazonaws.services.kms.AWSKMSClientBuilder
import com.amazonaws.services.kms.model.DecryptRequest

class AmazonSecureConfigProvider : ConfigProvider {
    override val twilioAccountSsid: String
    override val twilioAuthToken: String
    override val senderPhoneNumber: String
    override val recipientPhoneNumber: String
    override val ynabPersonalAccessToken: String
    override val ynabBudgetId: String

    init {
        twilioAccountSsid = getEncryptedValue("TwilioAccountSSID")
        twilioAuthToken = getEncryptedValue("TwilioAuthToken")
        senderPhoneNumber = getEncryptedValue("SenderPhoneNumber")
        recipientPhoneNumber = getEncryptedValue("RecipientPhoneNumber")
        ynabPersonalAccessToken = getEncryptedValue("YNABPersonalAccessToken")
        ynabBudgetId = getEncryptedValue("YNABBudgetId")
    }

    private fun getEncryptedValue(key: String): String {
        val encryptedKey = Base64.decode(System.getenv(key))

        val client = AWSKMSClientBuilder.defaultClient()

        val request = DecryptRequest()
            .withCiphertextBlob(ByteBuffer.wrap(encryptedKey))

        val plainTextKey = client.decrypt(request).plaintext
        return String(plainTextKey.array(), Charset.forName("UTF-8"))
    }
}
