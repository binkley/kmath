package hm.binkley.math

import java.util.Objects.hash

open class Matrix<T>(
    val order: Int,
    defaultValue: T,
    private val values: MutableList<MutableList<T>> =
        (ArrayList<MutableList<T>>(order)).apply {
            repeat(order) {
                add(
                    ArrayList<T>(order).apply {
                        repeat(order) {
                            add(defaultValue)
                        }
                    }
                )
            }
        },
) {
    init {
        // TODO: Is there any math sense to an order-0 matrix?
        if (1 > order) throw ArithmeticException("Bad matrix order: $order")
    }

    operator fun get(i: Int, j: Int) = values[i][j]
    operator fun set(i: Int, j: Int, value: T) {
        values[i][j] = value
    }

    override fun equals(other: Any?): Boolean = this === other ||
        other is Matrix<*> &&
        order == other.order &&
        null == values.asSequence().filterIndexed { i, it ->
        it != other.values[i]
    }.firstOrNull()

    override fun hashCode(): Int = hash(values)

    override fun toString(): String = values.joinToString("\n ", "[", "]") {
        it.joinToString(", ")
    }
}

open class Matrix2x2<T>(
    defaultValue: T,
) : Matrix<T>(2, defaultValue)

open class IntMatrix2x2 : Matrix2x2<Int>(0) {
    companion object {
        fun zero() = IntMatrix2x2()
    }
}
