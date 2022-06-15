import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        double dt = 0.01;
        double gx = 0;
        double gy = -10;
        double mass = 1;
        double q = 0.2;

        LinkedList<Euler> basicEuler = new LinkedList<>();
        LinkedList<Euler> proEuler = new LinkedList<>();

        double sX = 0;
        double sY = 0;
        double vX = 10;
        double vY = 10;
        double aX = 0;
        double aY = -10;
        double dSx = dt * vX;
        double dSy = dt * vY;
        double dVx = dt * aX;
        double dVy = dt * aY;

        int t = 1;

        double sX2 = 0;
        double sY2 = 0;
        double vX2 = 10;
        double vY2 = 10;
        double aX2 = gx;
        double aY2 = gy;
        double vX3 = dt * aX2 / 2 + vX2;
        double vY3 = dt * aY2 / 2 + vY2;
        double dVx2 = gx * dt;
        double dVy2 = gy * dt;
        double dSx2 = vX3 * dt;
        double dSy2 = vY3 * dt;


        for (double i = 0; i < 2; i += dt) {
            sX += dSx;
            sY += dSy;
            aX = (mass * gx - q * vX) / mass;
            aY = (mass * gy - q * vY) / mass;
            dSx = dt * vX;
            dSy = dt * vY;
            dVx = dt * aX;
            dVy = dt * aY;
            vX += dVx;
            vY += dVy;

            sX2 += dSx2;
            sY2 += dSy2;
            vX2 += dVx2;
            vY2 += dVy2;
            aX2 = gx;
            aY2 = gy;
            vX3 = dt * aX2 / 2 + vX2;
            vY3 = dt * aY2 / 2 + vY2;
            dVx2 = gx * dt;
            dVy2 = gy * dt;
            dSx2 = vX3 * dt;
            dSy2 = vY3 * dt;

            proEuler.add(new Euler(sX2, sY2, vX2, vY2, aX2, aY2, dSx2, dSy2, dVx2, dVy2, t));
            basicEuler.add(new Euler(sX, sY, vX, vY, aX, aY, dSx, dSy, dVx, dVy, t));
            t++;
        }

        //proEuler.forEach(System.out::println);
        basicEuler.forEach(System.out::println);

    }


}