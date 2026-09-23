class Solution {
    public String defangIPaddr(String address) {
        String s1 = address.replace("." , "[.]");
        System.out.println(s1);
       
        /*char[] chars = new chars[address.length()];
        for(char c : chars){
            if(c == '.'){
                c = '[.]';
            }
            System.out.println(c);
        }
        return s;
        */
        return s1;
    }
}