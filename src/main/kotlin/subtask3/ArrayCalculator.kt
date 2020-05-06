package subtask3

import java.util.Comparator
import kotlin.math.abs

class ArrayCalculator {

    // TODO: Complete the following function
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val tmp = ArrayList<Int>()
        itemsFromArray.filterIsInstanceTo(tmp)
        tmp.filterNot { a -> a != 0 }
        if (tmp.isEmpty()){
            return 0
        }

        var product = 1
        if (tmp.size <= numberOfItems){
            for (i in tmp.indices){
                product *= tmp[i]
            }
            return product
        }else
        {
            tmp.sortWith( Comparator<Int>{o1,o2 -> abs(o2).compareTo(abs(o1)) })
            println(tmp.joinToString ())

            var lastNegInt = 0
            var lastPosInt = 0
            for (i in 0 until numberOfItems){
                product *= tmp[i]
                if (tmp[i] < 0){
                    lastNegInt = tmp[i]
                }else{
                    lastPosInt = tmp[i]
                }
            }
            if (product > 0){
                return product
            }else{
                var nextNegInt = 1
                var nextPosInt = -1
                for (j in numberOfItems until tmp.size){
                    if (tmp[j]<0 && nextNegInt > 0){
                        nextNegInt = tmp[j]
                    }else if (tmp[j] > 0 && nextPosInt < 0){
                        nextPosInt = tmp[j]
                    }else{
                        break
                    }
                }
                if(nextNegInt < 0 && (nextNegInt*lastNegInt > lastPosInt*nextPosInt)){
                    return product/lastPosInt*nextNegInt
                }else{
                    return product/lastNegInt*nextPosInt
                }
            }
        }
    }
}