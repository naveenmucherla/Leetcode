class Solution {
    public String defangIPaddr(String address) {
        String s1 = address.replace("." , "[.]");
        //System.out.println(s1);
        return s1;
    }
}