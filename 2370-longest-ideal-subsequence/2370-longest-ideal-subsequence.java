class Solution {
    public int longestIdealString(String s, int k) {
     int ans = 0;
        int n = s.length();
        int [] dp = new int [150];
        for(int curr = 0; curr <n;curr++){
            int currMaxLen = 0, i = s.charAt(curr);
            for(int j = i - k;j<=i+k;++j)
                currMaxLen = Math.max(currMaxLen, dp[j] +1);
            ans = Math.max(ans, dp[i] = currMaxLen);
        }
        return ans;
    }
}