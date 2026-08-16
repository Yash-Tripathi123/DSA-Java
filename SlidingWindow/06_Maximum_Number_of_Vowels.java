class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int l = 0, r = 0;
        int count = 0, max = 0;

        // First window
        while (r < k) {
            char ch = s.charAt(r);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
            r++;
        }

        max = count;

        // Slide window
        while (r < n) {
            char right = s.charAt(r);
            if (right == 'a' || right == 'e' || right == 'i' || right == 'o' || right == 'u') {
                count++;
            }

            char left = s.charAt(l);
            if (left == 'a' || left == 'e' || left == 'i' || left == 'o' || left == 'u') {
                count--;
            }

            max = Math.max(max, count);
            l++;
            r++;
        }

        return max;
    }
}