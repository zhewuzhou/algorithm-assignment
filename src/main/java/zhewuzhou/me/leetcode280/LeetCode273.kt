package zhewuzhou.me.leetcode280

fun numberToWords(num: Int): String {
    if (num == 0) return "Zero"
    val LESS_THAN_20 = arrayOf("", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")
    val TENS = arrayOf("", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")
    val BILLION = 1000000000
    val BILLION_STR = "Billion"
    val MILLION = 1000000
    val MILLION_STR = "Million"
    val THOUSAND = 1000
    val THOUSAND_STR = "Thousand"
    val HUNDRED = 100
    val HUNDRED_STR = "Hundred"
    val TWENTY = 20
    val TEN = 10

    fun convert(num: Int): String {
        return when {
            num < TWENTY -> LESS_THAN_20[num]
            num in TWENTY until HUNDRED -> TENS[num / TEN] +
                if (num % TEN == 0) "" else " " + convert(num % TEN)
            num in HUNDRED until THOUSAND -> LESS_THAN_20[num / HUNDRED] +
                if (num % HUNDRED == 0) " $HUNDRED_STR" else " $HUNDRED_STR " + convert(num % HUNDRED)
            else -> {
                when {
                    num in THOUSAND until MILLION -> convert(num / THOUSAND) +
                        if (num % THOUSAND == 0) " $THOUSAND_STR" else " $THOUSAND_STR " + convert(num % THOUSAND)
                    num in MILLION until BILLION -> convert(num / MILLION) +
                        if (num % MILLION == 0) " $MILLION_STR" else " $MILLION_STR " + convert(num % MILLION)
                    else -> {
                        convert(num / BILLION) +
                            if (num % BILLION == 0) " $BILLION_STR" else " $BILLION_STR " + convert(num % BILLION)
                    }
                }
            }
        }
    }
    return convert(num)
}
