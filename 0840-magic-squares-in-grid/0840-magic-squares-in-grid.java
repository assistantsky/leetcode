class Solution {
    private int rows;
    private int cols;
    private int[][] grid;

    
    public int numMagicSquaresInside(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        this.grid = grid;
        int count = 0;
      
        
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                count += checkMagicSquare(i, j);
            }
        }
        return count;
    }

    
    private int checkMagicSquare(int i, int j) {
        
        if (i + 3 > rows || j + 3 > cols) {
            return 0;
        }

        
        int[] frequency = new int[16];
        int[] rowSum = new int[3];
        int[] colSum = new int[3];
        int diagonalSum = 0, antiDiagonalSum = 0;
        for (int x = i; x < i + 3; ++x) {
            for (int y = j; y < j + 3; ++y) {
                int value = grid[x][y];
               
                if (value < 1 || value > 9 || ++frequency[value] > 1) {
                    return 0;
                }
                rowSum[x - i] += value;
                colSum[y - j] += value;
               
                if (x - i == y - j) {
                    diagonalSum += value;
                }
                
                if (x - i + y - j == 2) {
                    antiDiagonalSum += value;
                }
            }
        }

       
        if (diagonalSum != antiDiagonalSum) {
            return 0;
        }

       
        for (int k = 0; k < 3; ++k) {
            if (rowSum[k] != diagonalSum || colSum[k] != diagonalSum) {
                return 0;
            }
        }

        
        return 1;
    }
}
