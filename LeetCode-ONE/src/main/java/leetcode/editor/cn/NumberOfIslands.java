package leetcode.editor.cn;

//Java: 岛屿数量(number-of-islands)

//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 2023 👎 0

class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numIslands(char[][] grid) {
            int count = 0;

            int m = grid.length, n = grid[0].length;

            for (int col = 0; col < m; col++) {
                for (int row = 0; row < n; row++) {
                    if (grid[col][row] == '1') {
                        count++;
                        dfs(grid, col, row);
                    }
                }
            }
            return count;
        }

        private void dfs(char[][] grid, int i, int j) {

            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
                return;
            }

            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            grid[i][j] = '0';
            for (int[] dir : dirs) {
                int col = dir[0], row = dir[1];
                dfs(grid, i + col, j + row);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

