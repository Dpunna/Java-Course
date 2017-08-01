import java.util.Arrays;
import java.util.Scanner;


/**
 * Created by dilip on 14/07/17.
 */
public class DescendingArrayMain {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] myIntegers = getIntegers(5);
        int[] sorted = sortIntegers(myIntegers);
        printArray(sorted);
    }


    public static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + ", value was " + array[i]);
        }
    }

    public static int[] getIntegers(int number) {
        int[] values = new int[number];
        System.out.println("Enter " + number + "integer values. \r");
        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }
        return values;
    }


    public static int[] sortIntegers(int[] array) {
//        int[] sortedArray = new int[array.length];
//        for (int i = 0; i < array.length; i++) {
//                sortedArray[i] = array[i];
//            }
            int[] sortedArray = Arrays.copyOf(array, array.length);
            boolean flag = true;
            int temp;
            while (flag) {
                flag = false;
                for (int i = 0; i < sortedArray.length-1; i++) {
                    if (sortedArray[i] < sortedArray[i + 1]) {
                        temp = sortedArray[i];
                        sortedArray[i] = sortedArray[i + 1];
                        sortedArray[i + 1] = temp;
                        flag = true;
                    }
                }
            }
               return sortedArray;
        }

    }





