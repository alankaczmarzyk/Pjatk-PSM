package s22965;

public class CountMatrix {
    private int size;
    private double[][] matrix;
    private double[] vector;
    private double up;
    private double down;
    private double right;
    private double left;


    public CountMatrix(int size, int up, int left, int down, int right){
        this.matrix = new double[size*size][size*size];
        this.vector = new double[size*size];
        this.size = size;
        this.up = up;
        this.left = left;
        this.down = down;
        this.right = right;
    }

    public void count(){
        int index = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                countUp(i,j,index);
                countDown(i,j,index);
                countRight(i,j,index);
                countLeft(i,j,index);
                matrix[index][index] = -4;
                index++;
            }
        }
    }

    public void countUp(int i, int j, int index){
        if (i == size-1)
            vector[index] += up;
        else
            matrix[index][(i+1)*size + j] = 1;
    }

    public void countDown(int i, int j, int index){
        if (i == 0)
            vector[index] += down;
        else
            matrix[index][(i-1)*size + j] = 1;
    }

    public  void countLeft(int i, int j, int index){
        if (j == size-1)
            vector[index] += left;
        else
            matrix[index][i*size + j + 1] = 1;
    }

    public void countRight(int i, int j, int index){
        if (j == 0)
            vector[index] += right;
        else
            matrix[index][i*size + j - 1] = 1;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public double[] getVector() {
        return vector;
    }
}
