class Solution {
    int[][] dp;
    int len_s, len_t;

    public int numDistinct(String s, String t) {
        len_s = s.length();
        len_t = t.length();
        dp = new int[len_s][len_t];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(s, t, 0, 0);
    }

    public int solve(String s, String t, int i, int j) {

        if (j == len_t) return 1;
        if (i == len_s) return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int take = 0;

        if (s.charAt(i) == t.charAt(j)) {
            take = solve(s, t, i + 1, j + 1);
        }

        int skip = solve(s, t, i + 1, j);

        return dp[i][j] = take + skip;
    }
}
