class Solution {
    public int maximumSwap(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        int maxIndex = chars.length - 1;
        int x = 0, y = 0;
        for (int i = chars.length - 2; i >= 0; i--) {
            if (chars[maxIndex] == chars[i]) continue;

            if (chars[maxIndex] < chars[i]) {
                maxIndex = i;
            } else {
                x = maxIndex;
                y = i;
            }
        }

        char temp = chars[x];
        chars[x] = chars[y];
        chars[y] = temp;

        return Integer.valueOf(new String(chars));
    }
}