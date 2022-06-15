import java.util.Arrays;
import java.util.Scanner;

public class TheGameOfLife {
    private static int[] living = new int[10];
    private static int[] dying = new int[10];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Rozmiar siatki:");
        int netSize = scanner.nextInt();
        System.out.println("Zasady dla życia:");
        String live = scanner.next();
        System.out.println("Zasady dla umierania:");
        String die = scanner.next();

        for(char c : live.toCharArray()){
            int i = Integer.parseInt(String.valueOf(c));
            if(i <= 9) living[i] = 1;
        }
        for(char c : die.toCharArray()){
            int j = Integer.parseInt(String.valueOf(c));
            if(j <= 9) dying[j] = 1;
        }
        int[][] field = new int[netSize][netSize];
        int[][] newField = new int[netSize][netSize];
        field[15][15] = 1;
        System.out.println("Pierwsza iteracja");
        String input = scanner.nextLine();
        int maximumSize = netSize - 1;
        System.out.println(field[maximumSize][maximumSize]);

        while(!input.equals("e")) {
            for(int i = 0 ; i <= maximumSize ; i++){
                for(int j = 0 ; j <= maximumSize ; j++){
                    if(field[i][j] != 0) System.out.print(field[i][j] + " ");
                    else System.out.print("  ");
                }
                System.out.println();
            }

            for(int x = 0 ; x <= maximumSize ; x++){
                for(int y = 0 ; y <= maximumSize ; y++){
                    int neighboursValue = 0;
                    int currX, currY;

                    if(x == 0 && y == maximumSize){
                        neighboursValue += field[maximumSize][y - 1];
                        neighboursValue += field[x][y - 1];
                        neighboursValue += field[x + 1][y - 1];
                        neighboursValue += field[x + 1][y];
                        neighboursValue += field[x + 1][0];
                        neighboursValue += field[x][0];
                        neighboursValue += field[maximumSize][0];
                        neighboursValue += field[maximumSize][y];
                    }else if(x == maximumSize && y == 0){
                        neighboursValue += field[x - 1][maximumSize];
                        neighboursValue += field[x][maximumSize];
                        neighboursValue += field[0][maximumSize];
                        neighboursValue += field[0][y];
                        neighboursValue += field[0][y + 1];
                        neighboursValue += field[x][y + 1];
                        neighboursValue += field[x - 1][y + 1];
                        neighboursValue += field[x - 1][y];
                    } else if(x == 0 || y == 0) {
                        currX = (x - 1 < 0) ? maximumSize : x - 1;
                        currY = (y - 1 < 0) ? maximumSize : y - 1;
                        neighboursValue += field[currX][currY];
                        currX = x;
                        currY = (y - 1 < 0) ? maximumSize : y - 1;
                        neighboursValue += field[currX][currY];
                        currX = x + 1;
                        currY = (y - 1 < 0) ? maximumSize : y - 1;
                        neighboursValue += field[currX][currY];
                        currX = x + 1;
                        currY = y;
                        neighboursValue += field[currX][currY];
                        currX = x + 1;
                        currY = y + 1;
                        neighboursValue += field[currX][currY];
                        currX = x;
                        currY = y + 1;
                        neighboursValue += field[currX][currY];
                        currX = (x - 1 < 0) ? maximumSize : x - 1;
                        currY = y + 1;
                        neighboursValue += field[currX][currY];
                        currX = (x - 1 < 0) ? maximumSize : x - 1;
                        currY = y;
                        neighboursValue += field[currX][currY];
                    } else if(x == maximumSize || y == maximumSize) {
                        currX = x - 1;
                        currY = y - 1;
                        neighboursValue += field[currX][currY];
                        currX = x;
                        currY = y - 1;
                        neighboursValue += field[currX][currY];
                        currX = (x + 1 > maximumSize) ? 0 : x + 1;
                        currY = y - 1;
                        neighboursValue += field[currX][currY];
                        currX = (x + 1 > maximumSize) ? 0 : x + 1;
                        currY = y;
                        neighboursValue += field[currX][currY];
                        currX = (x + 1 > maximumSize) ? 0 : x + 1;
                        currY = (y + 1 > maximumSize) ? 0 : y + 1;
                        neighboursValue += field[currX][currY];
                        currX = x;
                        currY = (y + 1 > maximumSize) ? 0 : y + 1;
                        neighboursValue += field[currX][currY];
                        currX = x - 1;
                        currY = (y + 1 > maximumSize) ? 0 : y + 1;
                        neighboursValue += field[currX][currY];
                        currX = x - 1;
                        currY = y;
                        neighboursValue += field[currX][currY];
                    } else {
                        neighboursValue += field[x - 1][y - 1];
                        neighboursValue += field[x][y - 1];
                        neighboursValue += field[x + 1][y - 1];
                        neighboursValue += field[x + 1][y];
                        neighboursValue += field[x + 1][y + 1];
                        neighboursValue += field[x][y + 1];
                        neighboursValue += field[x - 1][y + 1];
                        neighboursValue += field[x - 1][y];
                    }
                    if(field[x][y] == 1){
                        if(living[neighboursValue] > 0) newField[x][y] = 1;
                        else newField[x][y] = 0;
                    }else {
                        if(dying[neighboursValue] > 0) newField[x][y] = 1;
                        else newField[x][y] = 0;
                    }
                }
            }
            field = Arrays.stream(newField).map(int[]::clone).toArray(int[][]::new);
            input = scanner.nextLine();
        }
     }
    }
