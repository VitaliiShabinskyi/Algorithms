import java.util.Arrays;

/**
 * Имея два отсортированных массива размера m и n соответственно, вам нужно найти элемент,
 * который будет находиться на k-й позиции в конечном отсортированном массиве.
 * Массив 1 - 100 112 256 349 770
 * Массив 2 - 72 86 113 119 265 445 892
 * к = 7
 * Вывод : 256
 * Окончательный отсортированный массив -
 * 72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
 * 7-й элемент этого массива равен 256.
 * Массивы приведены для примера. Алгоритм должен работать и на других массивах.
 */
public class Task1 {
    public static void main(String[] args) {
        int[] arr1 = {100, 112, 256, 349, 770};
        int[] arr2 = {72, 86, 113, 119, 265, 445, 892};
        int k = 7;

        System.out.println(k + "-й элемент = " + findElement(arr1, arr2, k));

    }

    private static int findElement(int[] arr1, int[] arr2, int k) {
        int[] mergeArray = mergeArrays(arr1, arr2, k);
        if (k >= 1 && k <= mergeArray.length) {
            return mergeArray[k - 1];
        } else {
            return -1;
        }
    }
    private static int[] mergeArrays(int[] arr1, int[] arr2, int x) {
        int[] mergeArray = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                mergeArray[k++] = arr1[i++];
            } else {
                mergeArray[k++] = arr2[j++];
            }
            // возвращаем массив, если дошли до k-й позиции (остальная часть массива нас не интересует)
            if (k == x) {
                return mergeArray;
            }
        }

        while (i < arr1.length) {
            if (k == x) {
                return mergeArray;
            }
            mergeArray[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            if (k == x) {
                return mergeArray;
            }
            mergeArray[k++] = arr2[j++];
        }
        return mergeArray;
    }
}
