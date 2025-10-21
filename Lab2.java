public class Lab2 
{
    public static void main(String[] args) 
    {
        int lvl = 3;
        int rows = 3;
        int cols = 4;
        Lab2 lab = new Lab2();
        
        // Вивід ялинки з 6 рівнів
        lab.printTree(lvl);

        System.out.println();

        // Вивід масиву 3 на 4
        lab.createAndPrintArray(rows, cols);
    }
    // вивід ялинки
    public void printTree(int levels) 
    {
        for (int i = 1; i <= levels; i++) 
        {
            for (int j = 0; j < levels - i; j++) 
            {
                System.out.print(" ");
            }
            for (int k = 0; k < (2 * i - 1); k++) 
            {
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
}