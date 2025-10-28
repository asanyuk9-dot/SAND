
// Імпорт класу Scanner для зчитування вводу користувача
//для введення з клавіатури
import java.util.Scanner; 
public class Lab3 
{
    public static void main(String[] args) 
    {
        GameBoard board = new GameBoard();
        Player player1 = new Player("Гравець 1", 'X');
        Player player2 = new Player("Гравець 2", 'O');
        Player currentPlayer = player1;
        while (true) //Поточний стан ігрового поля.
        {
            board.printBoard();
            currentPlayer.printInfo();
            int[] move = currentPlayer.makeMove();

            if (!board.setMove(move[0], move[1], currentPlayer.getSymbol())) 
            {
                System.out.println("Некоректний хід. Спробуйте ще раз.");
                continue;
            }
            if (board.checkWin(currentPlayer.getSymbol())) 
            {
                board.printBoard();
                System.out.println("Вітаємо з перемігою! " + currentPlayer.getName());
                break;
            }
            if (board.isFull()) 
            {
                board.printBoard();
                System.out.println("Нічия!");
                break;
            }
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }
}

class GameBoard 
{
    private char[][] field;//зберігає стан ігрового поля
    //створення ігрового поля
    public GameBoard() {
        field = new char[3][3];
        for (int i=0; i<3; i++) 
        {
            for (int j=0; j<3; j++) 
            {
                field[i][j] = ' ';
            }
        }
    }
    // Вивід ігрового поля на екран 
    // текучий стан ігрового поля
    public void printBoard() 
    {
        System.out.println();
        System.out.println("Поточний стан ігрового поля:");
        for (int i = 0; i < 3; i++) 
        {
        // Вивід рядка з символами  
            for (int j = 0; j < 3; j++) 
            {
                System.out.print(field[i][j]);
                if (j < 2) System.out.print("  | "); // вертикальні роздільники між комірками
            }
            System.out.println();
            if (i < 2) 
            {
                System.out.println("------------"); // горизонтальні лінії між рядками
            }
    }
    System.out.println();
    }
    // Зміна стану ігрового поля (ставимо фігуру на поле)
    public boolean setMove(int row, int col, char symbol) 
    {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && field[row][col] == ' ') 
        {
            field[row][col] = symbol;
            return true;
        }
        return false;
    }
    //Перевірка чи є переможець
    public boolean checkWin(char symbol) 
    {
        // Перевірка рядків
        for (int i=0; i<3; i++) {
            if (field[i][0] == symbol && field[i][1] == symbol && field[i][2] == symbol) 
            {
                return true;
            }
        }
        // Перевірка стовпців
        for (int j=0; j<3; j++) {
            if (field[0][j] == symbol && field[1][j] == symbol && field[2][j] == symbol) 
            {
                return true;
            }
        }
        // Перевірка діагоналей
        if (field[0][0] == symbol && field[1][1] == symbol && field[2][2] == symbol) 
        {
            return true;
        }
        if (field[0][2] == symbol && field[1][1] == symbol && field[2][0] == symbol) 
        {
            return true;
        }
        return false;
    }
    //Перевірка чи заповнене поле
    public boolean isFull() 
    {
        for (int i=0; i<3; i++) 
        {
            for (int j=0; j<3; j++) 
            {
                if (field[i][j] == ' ') 
                {
                    return false;
                }
            }
        }
        return true;
    }
}

class Player 
{
    private String name;
    private char symbol;
    private Scanner scanner;
    // Конструктор гравця
    public Player(String name, char symbol) 
    {
        this.name = name;
        this.symbol = symbol;
        scanner = new Scanner(System.in);
    }
    // Отримання імені гравця
    public String getName() 
    {
        return name;
    }
    // Отримання символу гравця
    public char getSymbol() 
    {
        return symbol;
    }
    // Зчитування ходу гравця
    public int[] makeMove() 
    {
        System.out.println(name + ", введіть номер рядка та стовпця (в діапазоні 1-3): ");
        int row = scanner.nextInt()-1;
        int col = scanner.nextInt()-1;
        return new int[] { row, col };
    }
    // Вивід інформації про гравця
    public void printInfo() 
    {
        System.out.println("Гравець: " + name + " (" + symbol + ")");
    }
}