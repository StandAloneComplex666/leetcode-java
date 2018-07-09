class Solution {
    public int matrixScore(int[][] A) {
        int sum = 0;

        for(int[] arr : A)
            if(arr[0] == 0)
                for(int i = 0; i < arr.length; i++)
                    arr[i] = 1 - arr[i];
        int height = A.length;
        int width = A[0].length;

        for(int i = 0; i < width; i++) {
            int sumOf1 = 0;
            for(int j = 0; j < height; j++)
                if(A[j][i] == 1)
                    sumOf1++;
            if(sumOf1 < height - sumOf1)
                sumOf1 = height - sumOf1;
            sum += sumOf1 * Math.pow(2, width-1-i);
        }

        return sum;
    }
}