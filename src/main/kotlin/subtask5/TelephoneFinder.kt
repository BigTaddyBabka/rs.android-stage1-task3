package subtask5

import kotlin.reflect.KClass

class TelephoneFinder {

    // TODO: Complete the following function
    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        val phoneMap = mapOf<Int, IntArray>(
            1 to intArrayOf(2,4),
            2 to intArrayOf(1,3,5),
            3 to intArrayOf(2,6),
            4 to intArrayOf(1,5,7),
            5 to intArrayOf(2,4,6,8),
            6 to intArrayOf(3,5,9),
            7 to intArrayOf(4,8),
            8 to intArrayOf(0,5,7,9),
            9 to intArrayOf(6,8),
            0 to intArrayOf(8))

        var results = ArrayList<String>()
        for (i in number.indices){
            if (!number[i].isDigit()){
                return null
            }
            val nmb = number[i].toInt()-48

            val vals: IntArray? = phoneMap.getValue(nmb)

            if (vals != null) {

                for (j in vals.indices){

                    if (number.length == 1){
                        results.add(vals[j].toString())
                    }else {
                        val sb = StringBuilder()
                        sb.append(number.substring(0, i))
                        sb.append(vals[j])
                        sb.append(number.substring(i + 1))
                        results.add(sb.toString())
                    }
                }
            }
        }
        return results.toTypedArray()
    }
}