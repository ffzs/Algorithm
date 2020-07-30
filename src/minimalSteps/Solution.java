package minimalSteps;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2020/7/29 上午7:59
 */

public class Solution {
    char[][] step;
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int n, m;

    public int minimalSteps(String[] maze) {
        n = maze.length;
        m = maze[0].length();
        step = new char[n][m];

        for (int i = 0; i < n; ++i) {
            step[i] = maze[i].toCharArray();
        }

        List<int[]> stone = new ArrayList<>();
        List<int[]> trap = new ArrayList<>();
        int[] start = new int[2];
        int[] end = new int[2];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (!checkAvailable(i, j)){
                    if (step[i][j] == 'M' || step[i][j] == 'S' || step[i][j] == 'T')
                        return -1;  // 如果不能到达起点，终点，或者陷阱的话直接返回-1
                    else continue;
                }
                switch (step[i][j]) {
                    case 'S': {start = new int[]{i, j}; break;}
                    case 'T': {end = new int[]{i, j}; break;}
                    case 'O': {stone.add(new int[] {i, j}); break;}
                    case 'M': {trap.add(new int[] {i, j}); break;}
                }
            }
        }

        if (trap.size() > 0 && stone.size() == 0) return -1;  // 如果有陷阱，但是石头无法到达直接返回-1

        if (trap.size() == 0) return getDistance(start)[end[0]][end[1]];  // 如果没有陷阱的话，那么直接通过起点到达终点

        List<int[]> stoneNew = new ArrayList<>(stone);
        stoneNew.add(end);
        List<int[]> trapNew = new ArrayList<>(trap);
        trapNew.add(0,start);

        int[][] distanceTable = new int[trapNew.size()][stoneNew.size()];

        for (int i = 0; i < trapNew.size(); i++) {
            int[][] disTable = getDistance(trapNew.get(i));
            for (int j = 0; j < stoneNew.size(); j++) {
                int[] stn = stoneNew.get(j);
                distanceTable[i][j] = disTable[stn[0]][stn[1]];
            }
        }

//        System.out.println(Arrays.deepToString(distanceTable));
        int[][] M2M = new int[trapNew.size()][trapNew.size()];

        for (int i = 0; i < M2M.length; ++i) {
            int[] m12o = distanceTable[i];
            for (int j = i; j < M2M.length; ++j) {
                if (i == j) continue;
                int[] m22o =  distanceTable[j];
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < m12o.length-1; ++k) {
                    if (m12o[k]+m22o[k] > 0 && m12o[k]+m22o[k]<min)
                    min = m12o[k]+m22o[k];
                }
                if (min == Integer.MAX_VALUE) return -1;
                M2M[i][j] = min;
                M2M[j][i] = min;
            }
        }

//        System.out.println(Arrays.deepToString(M2M));

        for (int i = 0; i < M2M.length; i++) {
            if (distanceTable[i][stoneNew.size()-1] == -1) return -1;
        }

        int[][] dp = new int[1<<trap.size()][trap.size()];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        for (int i = 0; i < trap.size(); i++) {
            dp[1<<i][i] = M2M[0][i+1];  // 将S->M加入dp表中
        }

        for (int mask = 1; mask < (1<<trap.size()); mask++) {
            for (int i = 0; i < trap.size(); i++) {
                if ((mask & (1<<i)) != 0) {
                    for (int j = 0; j < trap.size(); j++) {
                        if ((mask & (1<<j)) == 0) {
                            int next = mask | (1<<j);
                            if (dp[next][j] == -1 || dp[next][j] > dp[mask][i] + M2M[i+1][j+1])
                                dp[next][j] = dp[mask][i] + M2M[i+1][j+1];
                        }
                    }
                }
            }
        }

        int res = -1;
        int last = (1<<trap.size()) - 1;
        for (int i = 0; i < trap.size(); i++) {
            if (res == -1 || res > dp[last][i] + distanceTable[i+1][stoneNew.size()-1]) {
                res = dp[last][i] + distanceTable[i+1][stoneNew.size()-1];
            }
        }
        return res;
    }

    private int[][] getDistance (int[] s) {
        int[][] dp = new int[n][m];
        for (int[] ints : dp) Arrays.fill(ints, -1);
        dp[s[0]][s[1]] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{s[0], s[1]});
        while (!queue.isEmpty()) {
            int[] item = queue.poll();
            int i = item[0], j = item[1];
            for (int[] direction : directions) {
                int ii = i + direction[0], jj = j + direction[1];
                if (ii >= 0 && ii < n && jj >= 0 && jj < m && step[ii][jj] != '#' && dp[ii][jj] == -1) {
                    dp[ii][jj] = dp[i][j] + 1;
                    queue.add(new int[]{ii, jj});
                }
            }
        }
        return dp;
    }

    private boolean checkAvailable (int i, int j) {
        for (int[] direction : directions) {
            int ii = direction[0] + i;
            int jj = direction[1] + j;
            if (ii >= 0 && ii < n && jj >= 0 && jj < m && step[ii][jj] != '#') return true;
        }
        return false;
    }
}


class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        String[] maze = {"TMM", "..M", "OOS", "#O.", ".#O", "O##"};
//        String[] maze = {"S#O", "M.T", "M.."};
        System.out.println(solution.minimalSteps(maze));
        System.out.println("2>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(solution2.minimalSteps(maze));
    }
}