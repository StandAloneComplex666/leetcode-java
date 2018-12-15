public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if(words == null || words.length == 0 || word1 == null || word2 == null)
            return 0;
        int minDistance = Integer.MAX_VALUE, word1Index = -1, word2Index = -1;
        boolean isWord1EqualsWord2 = word1.equals(word2);
        
        for(int i = 0; i < words.length; i++) {
            if(isWord1EqualsWord2) {
                if(words[i].equals(word1)) {
                    if(word1Index >= 0)
                        minDistance = Math.min(minDistance, i - word1Index);
                    word1Index = i;
                }
            } else {
                if(words[i].equals(word1))
                    word1Index = i;
                if(words[i].equals(word2))
                    word2Index = i;
                if(word1Index >= 0 && word2Index >= 0)
                    minDistance = Math.min(minDistance, Math.abs(word2Index - word1Index));    
            }
        }
        
        return minDistance;
    }
}