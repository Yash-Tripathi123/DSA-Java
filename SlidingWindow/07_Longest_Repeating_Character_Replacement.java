class Solution {
    public int characterReplacement(String s, int k) {
        int freq[] = new int[26];
        int l=0;
        int maxFreq = 0;
        int ans = 0;

        for(int right = 0; right<s.length(); right++){
            freq[s.charAt(right)-'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right)-'A']);

            while( (right-l+1) - maxFreq >k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            ans = Math.max(ans, right-l+1);
        }
        return ans;
    }
}