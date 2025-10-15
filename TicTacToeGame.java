
    import java.util.Scanner;

class GameBoard {
    private char[][] board;

    public GameBoard() {
        board = new char[3][3];
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int i=0; i<3; i++) {
            System.out.print("| ");
            for (int j=0; j<3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean setMove(int row, int col, char symbol) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    public boolean checkWin(char symbol) {
        // Перевірка рядків
        for (int i=0; i<3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
        }
        // Перевірка стовпців
        for (int j=0; j<3; j++) {
            if (board[0][j] == symbol && board[1][j] == symbol && board[2][j] == symbol) {
                return true;
            }
        }
        // Перевірка діагоналей
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}

class Player {
    private String name;
    private char symbol;
    private Scanner scanner;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        scanner = new Scanner(System.in);
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public int[] makeMove() {
        System.out.println(name + ", введіть номер рядка та стовпця (в діапазоні 0-2): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new int[] { row, col };
    }

    public void printInfo() {
        System.out.println("Гравець: " + name + " (" + symbol + ")");
    }
}

public class TicTacToeGame {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();

        Player player1 = new Player("Гравець 1", 'X');
        Player player2 = new Player("Гравець 2", 'O');

        Player currentPlayer = player1;

        while (true) {
            board.printBoard();
            currentPlayer.printInfo();

            int[] move = currentPlayer.makeMove();

            if (!board.setMove(move[0], move[1], currentPlayer.getSymbol())) {
                System.out.println("Некоректний хід. Спробуйте ще раз.");
                continue;
            }

            if (board.checkWin(currentPlayer.getSymbol())) {
                board.printBoard();
                System.out.println("Вітаємо з перемігою! " + currentPlayer.getName());
                break;
            }

            if (board.isFull()) {
                board.printBoard();
                System.out.println("Нічия!");
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }
}

