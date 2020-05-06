package subtask4

import java.lang.Math.floor
import java.lang.Math.sqrt


class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        return decompose( number - 1, number * number)
    }

    private fun decompose(n: Int, prod: Int): Array<Int>? {
        for (i in n downTo 1) {
            var balance = prod - i * i
            if (balance == 0) {
                return arrayOf(i)
            }

            if (balance < 0) {
                return null
            }

            var root = floor( sqrt(balance.toDouble()) ).toInt()

            if (root >= i) {
                root = i - 1
            }

            var res = decompose(root, balance)

            if (res != null) {
                return res + arrayOf(i)
            }
        }
        return null
    }
}