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

