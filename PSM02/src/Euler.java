public class Euler {
    double sX;
    double sY;
    double vX;
    double vY;
    double aX;
    double aY;
    double dSx;
    double dSy;
    double dVx;
    double dVy;
    int t;

//    public Euler(double sX, double sY, double vX, double vY, double aX, double aY, double dSx, double dSy, double dVx, double dVy,int t) {
//        this.sX = Math.round(sX * 10000)/ 10000.0;
//        this.sY = Math.round(sY * 10000)/ 10000.0;
//        this.vX = Math.round(vX * 10000)/ 10000.0;
//        this.vY = Math.round(vY * 10000)/ 10000.0;
//        this.aX = Math.round(aX * 10000)/ 10000.0;
//        this.aY = Math.round(aY * 10000)/ 10000.0;
//        this.dSx = Math.round(dSx * 10000)/ 10000.0;
//        this.dSy = Math.round(dSy * 10000)/ 10000.0;
//        this.dVx =Math.round(dVx * 10000)/ 10000.0;
//        this.dVy =Math.round(dVy * 10000)/ 10000.0;
//        this.t = t;
//    }


    public Euler(double sX, double sY, double vX, double vY, double aX, double aY, double dSx, double dSy, double dVx, double dVy, int t) {
        this.sX = sX;
        this.sY = sY;
        this.vX = vX;
        this.vY = vY;
        this.aX = aX;
        this.aY = aY;
        this.dSx = dSx;
        this.dSy = dSy;
        this.dVx = dVx;
        this.dVy = dVy;
        this.t = t;
    }

    @Override
    public String toString() {
        return "t:"+t + " " +sX + ", " + sY + ", " + vX + ", " + aX+", " + aY+", " + dSx + ", " + dSy +", " + dVx+", " + dVy+", ";
    }
}