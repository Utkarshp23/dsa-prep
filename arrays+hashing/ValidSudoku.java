import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("\n=== Checking cell [" + i + "][" + j + "] = '" + board[i][j] + "' ===");
                if (presentInRowOrColumn(board, i, j)) {
                    System.out.println(">>> INVALID: row/column duplicate found at [" + i + "][" + j + "] = '"
                            + board[i][j] + "' — returning false");
                    return false;
                }
                if (presentInCurrentCube(board, i, j)) {
                    System.out.println(">>> INVALID: cube duplicate found at [" + i + "][" + j + "] = '" + board[i][j]
                            + "' — returning false");
                    return false;
                }
            }
        }
        return true;
    }

    public boolean presentInRowOrColumn(char[][] board, int curi, int curj) {
        System.out.println(
                "  [presentInRowOrColumn] checking [" + curi + "][" + curj + "] = '" + board[curi][curj] + "'");
        if (board[curi][curj] == '.') {
            System.out.println("  [presentInRowOrColumn] cell is '.', skipping");
            return false;
        }
        for (int i = 0; i < 9; i++) {
            if (curi != i && board[curi][curj] == board[i][curj]) {
                System.out.println("  [presentInRowOrColumn] COLUMN duplicate: [" + curi + "][" + curj + "]='"
                        + board[curi][curj] + "' matches [" + i + "][" + curj + "]='" + board[i][curj] + "'");
                return true;
            }
            if (curj != i && board[curi][curj] == board[curi][i]) {
                System.out.println("  [presentInRowOrColumn] ROW duplicate: [" + curi + "][" + curj + "]='"
                        + board[curi][curj] + "' matches [" + curi + "][" + i + "]='" + board[curi][i] + "'");
                return true;
            }
        }
        System.out.println("  [presentInRowOrColumn] no row/col duplicate — OK");
        return false;
    }

    public boolean presentInCurrentCube(char[][] board, int curi, int curj) {
        int iStart = 0;
        int iEnd = 0;
        int jStart = 0;
        int jEnd = 0;

        System.out.println(
                "  [presentInCurrentCube] checking [" + curi + "][" + curj + "] = '" + board[curi][curj] + "'");
        if (board[curi][curj] == '.') {
            System.out.println("  [presentInCurrentCube] cell is '.', skipping");
            return false;
        }

        if (curi % 3 == 0) {
            iStart = curi;
            iEnd = curi + 2;
            System.out.println("  [presentInCurrentCube] curi%3==0 → iStart=" + iStart + " iEnd=" + iEnd);
        }
        if (curi % 3 == 1) {
            iStart = curi - 1;
            iEnd = curi + 1;
            System.out.println("  [presentInCurrentCube] curi%3==1 → iStart=" + iStart + " iEnd=" + iEnd);
        }
        if (curi % 3 == 2) {
            iStart = curi - 2;
            iEnd = curi;
            System.out.println("  [presentInCurrentCube] curi%3==2 → iStart=" + iStart + " iEnd=" + iEnd);
        }

        if (curj % 3 == 0) {
            jStart = curj;
            jEnd = curj + 2;
            System.out.println("  [presentInCurrentCube] curj%3==0 → jStart=" + jStart + " jEnd=" + jEnd);
        }
        if (curj % 3 == 1) {
            jStart = curj - 1;
            jEnd = curj + 1;
            System.out.println("  [presentInCurrentCube] curj%3==1 → jStart=" + jStart + " jEnd=" + jEnd);
        }
        if (curj % 3 == 2) {
            jStart = curj - 2;
            jEnd = curj;
            System.out.println("  [presentInCurrentCube] curj%3==2 → jStart=" + jStart + " jEnd=" + jEnd);
        }

        System.out.println("  [presentInCurrentCube] scanning sub-grid rows[" + iStart + ".." + iEnd + "] cols["
                + jStart + ".." + jEnd + "]");
        for (int i = iStart; i <= iEnd; i++) {
            for (int j = jStart; j <= jEnd; j++) {
                System.out.println("    comparing [" + curi + "][" + curj + "]='" + board[curi][curj] + "' vs [" + i
                        + "][" + j + "]='" + board[i][j] + "'  (same cell: " + (curi == i && curj == j) + ")");
                if (curi != i && curj != j && board[curi][curj] == board[i][j]) {
                    System.out.println("  [presentInCurrentCube] CUBE duplicate: [" + curi + "][" + curj + "]='"
                            + board[curi][curj] + "' matches [" + i + "][" + j + "]");
                    return true;
                }
            }
        }

        System.out.println("  [presentInCurrentCube] no cube duplicate — OK");
        return false;
    }

    public boolean isValidSudokuV2(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> cubes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (rows.computeIfAbsent(i, k -> new HashSet<>()).contains(board[i][j])) {
                    return false;
                }
                rows.get(i).add(board[i][j]);
                if (cols.computeIfAbsent(j, k -> new HashSet<>()).contains(board[i][j])) {
                    return false;
                }
                cols.get(j).add(board[i][j]);
                String cubeKey = i / 3 + "," + j / 3;
                if (cubes.computeIfAbsent(cubeKey, k -> new HashSet<>()).contains(board[i][j])) {
                    return false;
                }
                cubes.get(cubeKey).add(board[i][j]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku vs = new ValidSudoku();

        // Valid sudoku — every row, column, and 3x3 box has no duplicates
        char[][] validBoard = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        System.out.println("\n========== VALID BOARD (expected: true) ==========");
        System.out.println("Result: " + vs.isValidSudoku(validBoard));

        // Invalid sudoku — row 4 has two '8's (positions [4][0] and [4][3])
        char[][] invalidBoard = {
                { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '.', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '.', '6', '.', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        System.out.println("\n========== INVALID BOARD (expected: false) ==========");
        System.out.println("Result: " + vs.isValidSudoku(invalidBoard));
    }
}
