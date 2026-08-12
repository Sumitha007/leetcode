
class Solution {
    public double[] convertTemperature(double celsius) {
        double Kelvin = celsius + 273.15;
        double Fahrenhit =celsius * 1.80 + 32.00;
        double[] arr ={Kelvin,Fahrenhit};
        return arr;
    }
}