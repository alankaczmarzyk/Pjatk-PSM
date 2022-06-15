import java.io.IOException;

public class Main {
    public static final double twoPI = 2*Math.PI;

    public static void main(String[] args) throws IOException {
        sinFunc(45);
        sinFunc(730);


    }
    public static void sinFunc(double degree){
        degree = normalAngle(degree);
        degree= checkCases(degree);
        double powerByFactorial=1, seriesSum=0;
        double javaMathSin = Math.sin(degree);

        for (int k = 1; k<11; k++) {
            powerByFactorial = powerByFactorial * (degree/k);

            if (k % 4 == 1)
                seriesSum = seriesSum + powerByFactorial;
            if (k % 4 == 3)
                seriesSum = seriesSum - powerByFactorial;

        }
        System.out.println("Our func: "+seriesSum);
        System.out.println("Java Math.sin: "+javaMathSin);
        double difference = (Math.abs(seriesSum)-Math.abs(javaMathSin));
        System.out.println("Absolute value difference "+difference);
        System.out.println();
    }

    public static double normalAngle(double x) {
        x %= twoPI;
        return (x > 0) ? x : x + twoPI;
    }

    public static double checkCases(double dg){
        if(dg>0 && dg<=Math.PI/2){
                return dg;
        }else if(dg>Math.PI/2 && dg<=Math.PI){
            dg = Math.PI-dg;
            return dg;
        }else if(dg>Math.PI && dg<=3*Math.PI/2){
            dg = dg - Math.PI;
            return dg;
        }else {
            dg = 2*Math.PI - dg;
            return dg;
        }
    }

}
