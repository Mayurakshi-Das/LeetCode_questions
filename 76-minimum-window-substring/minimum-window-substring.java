class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> mp=new HashMap<>();
        
        int minLen=Integer.MAX_VALUE;
        int low=-1;

        int reqChars=t.length();
        int i=0;

        for(int k=0; k<t.length(); k++){
            char c=t.charAt(k);
            mp.put(c, mp.getOrDefault(c, 0)+1);
        }

        for(int j=0; j<s.length(); j++){
            char ch=s.charAt(j);
            if(mp.containsKey(ch)){
                // decrement reqChars only if current window has less no of ch than required
                if(mp.get(ch)>0) reqChars--;
                mp.put(ch, mp.get(ch)-1);
            }

            // if reqChars = 0 -> shrink till you find a new valid window (len <  minLen)
            while(reqChars==0){
                // before shrinking, update length
                if(j-i+1 < minLen){
                    minLen=j-i+1;
                    low=i;
                }

                // increase freq of char at i in mp, if present
                char c = s.charAt(i);
                if(mp.containsKey(c)){
                    mp.put(c, mp.get(c)+1);
                    // after increasing freq, check if window has less/more/exact no of required c chars
                    // increment reqChars only if freq(char c)>0 -> window less less chars than req 
                    if(mp.get(c)>0) reqChars++;
                }                
                i++;
            }
        }

        return minLen==Integer.MAX_VALUE? "" : s.substring(low, low+minLen);
    }
}