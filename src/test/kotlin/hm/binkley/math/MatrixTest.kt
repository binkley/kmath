package hm.binkley.math

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test

internal class MatrixTest {
    @Test
    fun `should initialize with zeroes`() {
        val m = IntMatrix2x2.zero()
        for (i in 0 until 2)
            for (j in 0 until 2)
                m[i, j] shouldBe 0

        IntMatrix2x2() shouldBe IntMatrix2x2.zero()
    }

    @Test
    fun `should complain for bad order`() {
        shouldNotThrow<ArithmeticException> {
            Matrix(order = 1, defaultValue = 0)
        }
        shouldThrow<ArithmeticException> {
            Matrix(order = 0, defaultValue = 0)
        }
    }

    @Test
    fun `should have correct order`() {
        IntMatrix2x2().order shouldBe 2
    }

    @Test
    fun `should equate`() {
        (IntMatrix2x2() == IntMatrix2x2()).shouldBeTrue()
        IntMatrix2x2().equals(3).shouldBeFalse()
    }

    @Test
    fun `should hash`() {
        IntMatrix2x2().hashCode() shouldNotBe 0

        val m = IntMatrix2x2()
        m[0, 0] = 3

        m.hashCode() shouldBe m.hashCode()
        m.hashCode() shouldNotBe IntMatrix2x2.zero().hashCode()
    }

    @Test
    fun `should pretty print`() {
        IntMatrix2x2.zero().toString() shouldBe """
            [0, 0
             0, 0]
        """.trimIndent()
    }

    @Test
    fun `should mutate`() {
        val m = IntMatrix2x2()
        m[0, 0] = 3

        m[0, 0] shouldBe 3
        m shouldNotBe IntMatrix2x2.zero()
    }
}
