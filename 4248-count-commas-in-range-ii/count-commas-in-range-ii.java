class Solution {
    public long countCommas(long n) {
       long output = 0 ;
       for(long i = 1000 ; i <=n ; i *= 1000){
          output += (n - i + 1);
          if(i > Long.MAX_VALUE / 1000)
           break;
       }

       return output;
    }
}