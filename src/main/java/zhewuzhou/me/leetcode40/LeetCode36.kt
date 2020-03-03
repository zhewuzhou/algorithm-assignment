package zhewuzhou.me.leetcode40

fun isValidSudoku(board: Array<CharArray>): Boolean =
    validColumns(board) && validBlock(board) && validRows(board)

fun validRows(board: Array<CharArray>): Boolean =
    board.all { row ->
        val nonEmptyChars = row.filter { it != '.' }
        nonEmptyChars.size == nonEmptyChars.distinct().size
    }

fun validColumns(board: Array<CharArray>): Boolean =
    (0..8)
        .map { column -> (0..8).map { row -> board[row][column] } }
        .all { column ->
            val nonEmptyChars = column.filter { it != '.' }
            nonEmptyChars.size == nonEmptyChars.distinct().size
        }

fun validBlock(board: Array<CharArray>): Boolean =
    (0..8).map { index ->
        val rowFactor = index / 3
        val columnFactor = index % 3
        ((0 + 3 * rowFactor)..(2 + 3 * rowFactor))
            .flatMap { row ->
                ((0 + 3 * columnFactor)..(2 + 3 * columnFactor))
                    .map { column ->
                        board[row][column]
                    }
            }
    }.all { block ->
        println(block)
        val nonEmptyChars = block.filter { it != '.' }
        nonEmptyChars.size == nonEmptyChars.distinct().size
    }

fun solveSudoku(board: Array<CharArray>) {
    if (board.isEmpty()) return
    solve(board)
}

fun solve(board: Array<CharArray>): Boolean {
    for (i in board.indices) {
        for (j in board[0].indices) {
            if (board[i][j] == '.') {
                var possibleValue = '1'
                while (possibleValue <= '9') {
                    if (isValid(board, i, j, possibleValue)) {
                        board[i][j] = possibleValue
                        if (solve(board)) return true
                        else board[i][j] = '.'
                    }
                    possibleValue++
                }
                return false
            }
        }
    }
    return true
}

private fun isValid(board: Array<CharArray>, row: Int, col: Int, c: Char): Boolean {
    val allBlock = ((0 + 3 * (row / 3))..(2 + 3 * (row / 3)))
        .flatMap { r ->
            ((0 + 3 * (col / 3))..(2 + 3 * (col / 3)))
                .map { c -> board[r][c] }
        }
    return !allBlock.contains(c) &&
        !board[row].contains(c) &&
        !(0..8).map { board[it][col] }.contains(c)
}

