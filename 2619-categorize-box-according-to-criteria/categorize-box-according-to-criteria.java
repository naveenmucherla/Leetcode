class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
      long vol =(long) length * width * height;
      boolean b = false , h = false;
      if(length >= 10000 || width >= 10000 || height >= 10000){
        b = true;
      }
      else if(vol >= Math.pow(10,9)){
        b = true;
      }
      if(mass >= 100){
        h = true;
      }

      if(b == true && h == true){
        return "Both";
      }
      else if(b == false && h == true){
        return "Heavy";

      }
      else if(b == true && h == false){
        return "Bulky";
      }
      else
       return "Neither";

    }
}