package hm.binkley.math

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class MatrixTest {
    @Test
    fun `useless placeholder run`() {
        Matrix().doNothing(true)
    }

    @Test
    fun `also useless placeholder run`() {
        assertThrows<UnsupportedOperationException> {
            Matrix().doNothing(false)
        }
    }
}
