public class Lab2 
{
    // вивід ялинки
    public void printTree(int levels) {
        for (int i = 1; i <= levels; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    // створення і вивід масиву +3
    public void createAndPrintArray(int rows, int cols) 
    {
        int[][] array = new int[rows][cols];
        int value = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = value;
                value += 3;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) 
    {
        Lab2 lab = new Lab2();
        
        // Вивід ялинки з 6 рівнів
        lab.printTree(8);

        System.out.println();

        // Вивід масиву 3 на 4
        lab.createAndPrintArray(3, 4);
    }
}

