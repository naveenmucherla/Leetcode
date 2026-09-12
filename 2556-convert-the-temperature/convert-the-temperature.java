class Solution {
    public double[] convertTemperature(double celsius) {
        double[] arr = new double[2];
        double kal = celsius + 273.15;
        double far = celsius * 1.80 + 32.00;
        
        arr[0] = kal;
        arr[1] = far;

        return arr;
        
    }
}