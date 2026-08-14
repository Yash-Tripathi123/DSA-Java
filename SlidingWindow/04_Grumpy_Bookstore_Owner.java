class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int n = customers.length;
        int l = 0, r = 0;

        int base = 0;
        int gain = 0;

        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                base += customers[i];
            }
        }

        while (r < minutes) {
            if (grumpy[r] == 1) {
                gain += customers[r];
            }
            r++;
        }

        int maxGain = gain;
        while (r < n) {

        if (grumpy[r] == 1)
        gain += customers[r];

        if (grumpy[l] == 1)
        gain -= customers[l];//important sabko minus nhi krna hai 

        maxGain = Math.max(maxGain, gain);
        r++;
        l++;
        }
        return maxGain + base;

    }
}