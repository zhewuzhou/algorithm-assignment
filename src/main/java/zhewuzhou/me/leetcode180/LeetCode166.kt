package zhewuzhou.me.leetcode180


fun fractionToDecimal(numerator: Int, denominator: Int): String {
    if (denominator == 0) return ""

    // If numerator is 0 (=> result = 0) no negative sign in result
    val n = Math.abs(numerator.toLong())
    val d = Math.abs(denominator.toLong())
    val integerPart = (n / d).toString()
    if (n % d == 0L) {
        return calcSign(numerator, denominator) + integerPart
    }
    val decimalPart = StringBuilder()
    var r = n % d

    val history = mutableMapOf<Long, Int>()
    while (r != 0L) {
        if (history.containsKey(r)) {
            decimalPart.insert(history[r]!!, "(")
            decimalPart.append(")")
            break
        }
        history[r] = decimalPart.length
        decimalPart.append((r * 10 / d).toString())
        r = (r * 10) % d
    }
    return "${calcSign(numerator, denominator)}$integerPart.$decimalPart"
}

private fun calcSign(numerator: Int, denominator: Int) =
    when (numerator != 0) {
        true -> if ((numerator < 0).xor(denominator < 0)) "-" else ""
        false -> ""
    }
