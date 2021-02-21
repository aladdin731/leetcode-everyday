public class LC_79 {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[n][m];
                    if(helper(board, word, visited, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if(index == word.length()) {
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j] || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean res =  helper(board, word, visited, i, j + 1, index + 1) ||
                helper(board, word, visited, i, j - 1, index + 1) ||
                helper(board, word, visited, i + 1, j, index + 1) ||
                helper(board, word, visited, i - 1, j, index + 1);
        visited[i][j] = false;
        return res;
    }
}
