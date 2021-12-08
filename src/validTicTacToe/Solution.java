package validTicTacToe;

/**
 * @author: ffzs
 * @Date: 2021/12/9 上午7:24
 * 2. cx - co = 0 || 1
 * 3. 如果有三个相连的情况： x, x-o = 1; o x - o = 0;
 */
public class Solution {

    public boolean validTicTacToe(String[] board) {
        int cx = 0, co = 0;
        char[][] bd = new char[3][3];
        for (int i = 0; i < 3; i++) {
            bd[i] = board[i].toCharArray();
            for (char c : bd[i]) {
                if (c == 'X') cx ++;
                else if (c == 'O') co ++;
            }
        }
        if (co > cx || cx - co > 1) return false;
        if (isWin(bd, 'X') && co != cx -1) return false;
        return !isWin(bd, 'O') || co == cx;
    }

    private boolean isWin (char[][] bd, char aim) {
        if (bd[0][0] == aim) {
            if (helper(bd, 0, 0, 0, 1, aim) || helper(bd, 0, 0, 1, 1, aim) || helper(bd, 0, 0, 1, 0, aim)) return true;
        }

        if (bd[2][2] == aim) {
            if (helper(bd, 2, 2, -1, 0, aim) || helper(bd, 2, 2, 0, -1, aim)) return true;
        }

        return helper(bd, 2, 0, -1, 1, aim);
    }

    private boolean helper(char[][] bd, int x, int y, int ox, int oy, char aim) {
        for (char i = 0; i < 3; i++) {
            if (bd[x][y] != aim) return false;
            x += ox;
            y += oy;
        }
        return true;
    }

}
