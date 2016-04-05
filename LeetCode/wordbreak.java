public boolean wordBreak(String s, Set<String> wordDict) {
       if(s==null || s.length()==0) return false;
       boolean [] breakable = new boolean[s.length()+1];
       breakable[0] = true;
       for(int i=0;i<s.length();i++){
           for (int j=0;j<=i;j++){
               if(breakable[j] && wordDict.contains(s.substring(j,i+1))) 
                    breakable[i+1] = true;
           }
       }
       return breakable[s.length()];
    }