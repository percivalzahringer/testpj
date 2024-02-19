import java.util.*;

public class TaskThird {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество бросков кубика:");
        int numThrows = scanner.nextInt();

        System.out.println("(Игрок 1) Введите свою последовательность (через пробел):");
        int[] player1Sequence = readSequence(scanner);
        System.out.println("(Игрок 2) Введите свою последовательность (через пробел):");
        int[] player2Sequence = readSequence(scanner);

        int player1Score = playGame(numThrows, player1Sequence);
        int player2Score = playGame(numThrows, player2Sequence);

        System.out.println("Игрок 1 \nВыбранные последовательности:" + Arrays.toString(player1Sequence) + "\nОчки:" + player1Score);
        System.out.println("\nИгрок 2 \nВыбранные последовательности:" + Arrays.toString(player2Sequence) + "\nОчки:" + player2Score);
    }

    public static int[] readSequence (Scanner scanner) {
        int[] sequence = new int[3];
        for (int i = 0; i < 3; i++) {
            sequence[i] = scanner.nextInt();
        }
        return sequence;
    }

    public static int playGame(int numThrows, int[] sequence) {
        Random random = new Random();
        int score = 0;
        for (int i = 0; i < numThrows; i++) {
            int first = random.nextInt(6) + 1;
            int second = random.nextInt(6) + 1;
            int third = random.nextInt(6) + 1;
            if (first == sequence[0] && second == sequence[1] && third == sequence[2]) {
                score++;
            }
        }
        return score;
    }
}
