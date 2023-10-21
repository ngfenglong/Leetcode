package validsudoku

func isValidSudoku(board [][]byte) bool {
	n := len(board)

	for i := 0; i < n; i++ {
		if !isValidCheck(i, 0, i, n-1, board) {
			return false
		}
		if !isValidCheck(0, i, n-1, i, board) {
			return false
		}
	}

	for startRow := 0; startRow < n; startRow += 3 {
		for startCol := 0; startCol < n; startCol += 3 {
			if !isValidCheck(startRow, startCol, startRow+2, startCol+2, board) {
				return false
			}
		}
	}

	return true
}

func isValidCheck(startRow, startCol, endRow, endCol int, board [][]byte) bool {
	check := make([]int, 9)

	for i := startRow; i <= endRow; i++ {
		for j := startCol; j <= endCol; j++ {
			b := board[i][j]
			if b != '.' {
				if check[b-'1'] >= 1 {
					return false
				}
				check[b-'1']++
			}
		}
	}

	return true
}
