import org.junit.Test

class HelloWorldPrinterTests {
    @Test
    fun `should return 'Hello World'`() {
        assert(HelloWorldPrinter().helloWorld() == "Hello World")
    }
}
