// JAVA code for finding the GCD of 
// two floating numbers.
import java.io.*;
 
class GreatestCommonDenominator {
     
    // Recursive function to return gcd 
    // of a and b
    static double gcd(double a, double b)
    {
        if (a < b)
            return gcd(b, a);
      
        // base case
        if (Math.abs(b) < 0.001)
            return a;
      
        else
            return (gcd(b, a - 
                   Math.floor(a / b) * b));
    }
      
    // Driver Function.
    public static void main(String args[])
    {
        double a = args.length >= 1 ? Double.parseDouble(args[0]) : 64.0;
        double b = args.length >= 2 ? Double.parseDouble(args[1]) : 100;
        System.out.printf("%.1f\n" ,gcd(a, b));
    }
}
 
/*This code is contributed by Nikita Tiwari.*/