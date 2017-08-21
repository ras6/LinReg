/*A Simple Linear Regression*/

import java.util.ArrayList;
import java.util.Scanner;


public class LinReg 
{
    void calLinReg()
    {
       Scanner scan =new Scanner(System.in);
        int n=0,l;
        ArrayList<Double>x,y;
        x=new ArrayList<Double>();
        y=new ArrayList<Double>();
        double sx =0.0,sy=0.0,sx2=0.0;
        System.out.println("Enter number of pairs of real numbers:");
        l = scan.nextInt();
        do {          
                x.add(scan.nextDouble());
                y.add(scan.nextDouble());
                sx  += x.get(n);
                sx2 += x.get(n) * x.get(n);
                sy  += y.get(n);
            n++;
                l--;
        } while (l!=0);
        
        double xb =sx/n,yb=sx/n;
        double xx=0.0,yy=0.0,xy=0.0;
        for (int i = 0; i < n; i++) {
            xx+= (x.get(i) - xb) * (x.get(i) - xb);
            yy+= (y.get(i) - yb) * (y.get(i) - yb);
            xy+= (x.get(i) - xb) * (y.get(i) - yb);
        }
            
        double b1 =xy/xx,b2 =yb-(b1*xb);
        System.out.println("y   = " + b1 + " * x + " + b2);
        double r = 0.0;      
        double ss = 0.0;      
        for (int i = 0; i < n; i++) {
            double fit = b1*x.get(i) + b2;
            r += (fit - y.get(i)) * (fit - y.get(i));
            ss += (fit - yb) * (fit - yb);
        }
        double r2=ss/yy,sv=r/(n-2),sv1=sv/xx,sv2=((sv/n) + xb*xb*sv1);
        System.out.println("Coefficent of Determination:"+r2);
        System.out.println("Standard Error of Beta1:"+Math.sqrt(sv1));
        System.out.println("Standard Error of Beta2:"+Math.sqrt(sv2));
        sv2=sv*sx2/(n*xx);
        System.out.println("Standard Error of Beta2:"+Math.sqrt(sv2));
        
        System.out.println("Total Sum of Squares:"+yy+"\nSum of the Squared Residuals:"+r+"\nSum of Squares Regression:"+ss);
      
    }
}
