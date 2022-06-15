package s22965;

import java.util.Scanner;

public class Gaus {
    private static final double EPSILON = 1e-10;
     int n;
     int N;
    double A[][];
    double B[];


    public static double[] solve(double[][] A, double[] B)
    {
        int n =  A.length;
        int N = B.length;

        for (int p = 0; p < n; p++)
        {


            int max = p;
            for (int i = p + 1; i < N; i++)
            {
                if (Math.abs(A[i][p]) > Math.abs(A[max][p]))
                {
                    max = i;
                }
            }
            double[] temp = A[p]; A[p] = A[max]; A[max] = temp;
            double   t    = B[p]; B[p] = B[max]; B[max] = t;


            if (Math.abs(A[p][p]) <= EPSILON) {
                throw new RuntimeException("Matrix is singular or nearly singular");
            }


            for (int i = p + 1; i < N; i++) {
                double alpha = A[i][p] / A[p][p];
                B[i] -= alpha * B[p];
                for (int j = p; j < n; j++) {
                    A[i][j] -= alpha * A[p][j];
                }
            }
        }


        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--)
        {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++)
            {
                sum += A[i][j] * x[j];
            }
            x[i] = (B[i] - sum) / A[i][i];
        }

        System.out.println("the values of unknowns are:-");
        for (int i = 0; i < n; i++)
            System.out.println("x" + i + "  " +x[i]);

        return x;
    }



    public  void input()
    {

        double k;
        Scanner s=new Scanner(System.in);
        System.out.println("enter no of equations ");
        N = s.nextInt();

        A = new double[N][];
        System.out.println("enter no of unknowns");
        n=s.nextInt();
        for(int l=0;l<N;l++){
            A[l]= new double[n];
        }
        System.out.println("enter the co-efficient of equations");
        for(int i=0;i<N;i++){
            System.out.println("enter the co-efficient of  equation  "+ (i+1));
            for(int j=0;j<n;j++){
                k=s.nextDouble();
                A[i][j]=k;
            }}
        B = new double[N];

        System.out.println("enter the RHS side of equations");
        for(int i=0;i<N;i++){
            System.out.println("enter the RHS of  equation  "+ (i+1));

            k=s.nextDouble();
            B[i]=k;
        }
    }


}
