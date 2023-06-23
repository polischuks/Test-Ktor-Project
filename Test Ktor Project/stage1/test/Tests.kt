import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.hyperskill.hstest.dynamic.DynamicTest
import org.hyperskill.hstest.stage.StageTest
import org.hyperskill.hstest.testcase.CheckResult

class Test : StageTest<Any>()  {

    @DynamicTest
    fun test1() : CheckResult {
        var result: CheckResult = CheckResult.correct()
        testApplication {
            val response = client.get("/")
            if (response.status != HttpStatusCode.OK) {
                result = CheckResult.wrong("You status code was not OK, you status code was ${response.status}")
                return@testApplication
            }
            if (response.bodyAsText() != "Hello World!")
                result = CheckResult.wrong("You body text was not Hello world!")
                return@testApplication
        }
        return result
    }
}