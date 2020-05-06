package subtask1

import java.lang.StringBuilder

class PolynomialConverter {

    // TODO: Complete the following function
    fun convertToStringFrom(numbers: Array<Int>): String? {
        if(numbers.isNullOrEmpty())
            return null
        var size = numbers.size;
        var result = StringBuilder()

        for(i in numbers.indices){
            val power = size - (1+i)
            val number = numbers[i]
            val absolute = kotlin.math.abs(numbers[i])

            if(number!=0){
                if(number>0){
                    if(power == size-1 )
                        result.append("")
                    else
                        result.append(" + ")
                }
                else{
                    if(power == size-1 )
                        result.append("-")
                    else
                        result.append(" - ")
                }
                if(absolute>1)
                    result.append(absolute)
                if(power>1)
                    result.append("x^$power")
                else if(power!=0)
                    result.append("x")
            }

        }
        return result.toString()
    }
}
