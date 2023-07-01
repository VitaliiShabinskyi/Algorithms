import java.util.Stack;

public class Iterative {
    public static void moveDisk(int source, int destination) {
        System.out.println(source + " -> " + destination);
    }

    public static void solveTowerOfHanoi(int n, int source, int helper, int destination) {
        if (n % 2 == 0) {
            // Если количество дисков четное, меняем местами промежуточный и целевой стержни
            int temp = helper;
            helper = destination;
            destination = temp;
        }

        int totalMovesRequired = (int) Math.pow(2, n) - 1;

        for (int move = 1; move <= totalMovesRequired; move++) {
            if (move % 3 == 1) {
                moveDisk(source, destination);
            } else if (move % 3 == 2) {
                moveDisk(source, helper);
            } else if (move % 3 == 0) {
                moveDisk(helper, destination);
            }
        }
    }

    public static void main(String[] args) {
        int n = 3; // Количество дисков

        int source = 1;
        int helper = 2;
        int destination = 3;

        solveTowerOfHanoi(n, source, helper, destination);
    }

}
