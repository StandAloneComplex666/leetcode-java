class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> charCount = new HashMap<Character,Integer>();
        for( char c : s.toCharArray() ) charCount.put( c, 1+charCount.getOrDefault( c, 0 ) );
        List<Character> list = new ArrayList( charCount.keySet() );
        list.sort( (c1, c2) ->  charCount.get(c1) - charCount.get(c2) );
        int index = s.length();
        char[] output = new char[index];
        for( char c : list ) for( int i=charCount.get( c ); i>0; i-- ) output[--index]=c;
        return new String( output );
    }
}