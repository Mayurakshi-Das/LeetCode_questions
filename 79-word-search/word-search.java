class Solution {
    public boolean exist(char[][] board, String word) {
        char[] letters = word.toCharArray();
        
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == letters[0]) {
                    board[i][j] = '*';
                    boolean wordFound = isWordInBoard(1, i, j, letters, board);
                    
                    
                    if (wordFound == true)
                        return true;
                    
                    
                    backtrack(0, i, j, wordFound, letters, board);
                }
            }
        }
        
        
        return false;
    }
    
    
    public boolean isWordInBoard(int curIdx, int i, int j, char[] letters, char[][] board) {
        if (curIdx == letters.length)
            return true;
        
        
        boolean wordFound = false;
        
        
        if (i + 1 < board.length && board[i + 1][j] == letters[curIdx]) {
            board[i + 1][j] = '*';
            wordFound |= isWordInBoard(curIdx + 1, i + 1, j, letters, board);
            backtrack(curIdx, i + 1, j, wordFound, letters, board);
        }
        
        
        if (!wordFound && i - 1 >= 0 && board[i - 1][j] == letters[curIdx]) {
            board[i - 1][j] = '*';
            wordFound |= isWordInBoard(curIdx + 1, i - 1, j, letters, board);
            backtrack(curIdx, i - 1, j, wordFound, letters, board);
        }
        
        
        if (!wordFound && j + 1 < board[0].length && board[i][j + 1] == letters[curIdx]) {
            board[i][j + 1] = '*';
            wordFound |= isWordInBoard(curIdx + 1, i, j + 1, letters, board);
            backtrack(curIdx, i, j + 1, wordFound, letters, board);
        }
        
        
        if (!wordFound && j - 1 >= 0 && board[i][j - 1] == letters[curIdx]) {
            board[i][j - 1] = '*';
            wordFound |= isWordInBoard(curIdx + 1, i, j - 1, letters, board);
            backtrack(curIdx, i, j - 1, wordFound, letters, board);
        }
        
        
        return wordFound;
    }
    
    
    public void backtrack(int curIdx, int i, int j, boolean wordFound, char[] letters, char[][] board) {
        if (!wordFound) {
            board[i][j] = letters[curIdx];
        }
    }
}