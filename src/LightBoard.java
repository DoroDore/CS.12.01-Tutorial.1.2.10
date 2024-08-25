import java.util.Random;

public class LightBoard {

    private boolean[][] lights;

    public LightBoard(int numRows, int numCols) {
        lights = new boolean[numCols][numRows];
        for (int i = 0; i < lights.length; i++) {
            for (int j = 0; j < lights[i].length; j++) {
                Random rand = new Random();
                if (rand.nextInt(10)+1 < 5) {
                    lights[i][j] = true;
                }
                else {
                    lights[i][j] = false;
                }
            }
        }

    }
    public boolean[][] getLights()
    {
        return lights;
    }
    public void setLights(boolean[][] lights)
    {
        this.lights = lights;
    }
    public boolean evaluateLight(int row, int col) {
        System.out.println("Row: " + row + " Col: " + col);
        int count = 0;

        if (lights[row][col]) {
            System.out.println("Start as True");
            for (int i = 0; i < lights.length; i++) {
                System.out.println("X:" + col + " Y:" + i);
                System.out.println(lights[i][col]);
                if (lights[i][col]) {
                    System.out.println("Add");
                    count++;
                }
            }
            System.out.println("Final Count: " + count);
            if (count % 2 == 0) {
                System.out.println("Returned False");
                return false;
            }
        } else {
            System.out.println("Start as False");
            for (int i = 0; i < lights.length; i++) { // Corrected to iterate over the column
                System.out.println("X:" + col + " Y:" + i);
                if (lights[i][col]) {
                    count++;
                    System.out.println("Count: " + count);
                }
            }
            System.out.println("Final Count: " + count);
            if (count % 3 == 0) {
                System.out.println("Returned true");
                return true;
            }
        }

        return lights[row][col];
    }
}