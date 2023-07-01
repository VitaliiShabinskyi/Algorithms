import java.util.Stack;

public class Recursive {
    public static void move(int n, int source, int destination, int helper) {
        if (n > 0) {
            move(n - 1, source, helper, destination);

            System.out.println(source + " -> " + destination);

            move(n - 1, helper, destination, source);
        }
    }

    public static void main(String[] args) {
        int n = 3; // Количество дисков

        int source = 1;
        int helper = 2;
        int destination = 3;

        move(n, source, destination, helper);
    }

}
