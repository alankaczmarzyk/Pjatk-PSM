package s22965;


public class Main {

    public static void main(String[] args) {

        CountMatrix countMatrix = new CountMatrix(40, 200,150,50,100);
        countMatrix.count();

        double[] answer = Gaus.solve(countMatrix.getMatrix(), countMatrix.getVector());

        for (int i = 39; i >= 0; i--) {
            for (int j = 39; j >= 0; j--) {
                String look = (answer[40*i+j]+"").replaceAll("\\.",",").replaceAll("-","")+" ";
                System.out.print(look);
            }
            System.out.println();
        }
    }



}
