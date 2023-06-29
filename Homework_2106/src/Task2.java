/**
 * Реализовать рекурсивный алгоритм бинарного поиска. Используйте стратегию "разделяй и властвуй".
 */
public class Task2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 7, 8, 10, 15, 25, 28, 29, 30};
        int target = 15;

        int index = binarySearch(arr, target);
        if (index < 0) {
            System.out.println("Элемент " + target + " не найден");
        } else {
            System.out.println("Элемент " + target + " найден на позиции " + index);
        }
    }

    private static int binarySearch(int[] arr, int target) {
        return binarySearchRecursive(arr, target, 0, arr.length - 1);
    }

    private static int binarySearchRecursive(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1; // Элемент не найден
        }

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearchRecursive(arr, target, low, mid - 1); // Ищем в левой половине
        } else {
            return binarySearchRecursive(arr, target, mid + 1, high); // Ищем в правой половине
        }
    }
}
