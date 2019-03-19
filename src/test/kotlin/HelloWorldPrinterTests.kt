package uk.co.tombryant.ynab.poller

import org.junit.Test

class HelloWorldPrinterTests {
    @Test
    fun `should return 'Hello World'`() {
        assert(HelloWorldPrinter().helloWorld() == "Hello World")
    }

    @Test
    fun `should say hello to someone`() {
        assert(HelloWorldPrinter().hello("Bob") == "Hello Bob")
    }

    @Test
    fun `should fail`() {
        assert(false)
    }
}
