import java.util.*;

public class TaskFirstSecond {
    public static void main(String[] args) {
        int[] array = generateRandomArray(10, -15, 15);
        int[] oddNumbers = getOddNumbers(array);
        int[] evenNumbers = getEvenNumbers(array);
        int[] zeroNumbers = getZero(array);
        int[] frequencyNumber = getFrequentNumber(array);
        int[] arrayAddition = getArrayAddition(oddNumbers, zeroNumbers, evenNumbers);

        System.out.println("Исходный массив случайных чисел: ");
        printArray(array);

        System.out.println("\nПереупорядоченный массив:");
        printArray(arrayAddition);

        System.out.println("\nНаиболее часто встречающееся число: ");
        printArray(frequencyNumber);
    }

    //Метод для генерация массива случайных чисел
    public static int[] generateRandomArray(int size, int min, int max) {
        int[] array = new int[size];
        Random random = new Random();
            for (int i = 0; i < size; i++) {
                array[i] = random.nextInt(max - min + 1) + min;
            }
            return  array;
    }

    // Метод для вывода массива на экран
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Метод для нахождения нечетных чисел в заданном массиве
    public static int[] getOddNumbers(int[] array) {
        Arrays.sort(array);
        ArrayList<Integer> oddList = new ArrayList<>();

        for (int oddNnumber : array) {
            if (oddNnumber % 2 != 0 && oddNnumber != 0) {
                oddList.add(oddNnumber);
            }
        }

        int[] oddNumbers = new int[oddList.size()];
        for (int i = 0; i < oddList.size(); i++) {
            oddNumbers[i] = oddList.get(i);
        }
        return oddNumbers;
    }

    // Метод для нахождения четных чисел в заданном массиве
    public static int[] getEvenNumbers(int[] array) {
        Arrays.sort(array);
        ArrayList<Integer> evenList = new ArrayList<>();

        for (int evenNumber : array) {
            if (evenNumber % 2 == 0 && evenNumber != 0) {
                evenList.add(evenNumber);
            }
        }

        int[] evenNumbers = new int[evenList.size()];
        for (int i = 0; i < evenList.size(); i++) {
            evenNumbers[i] = evenList.get(i);
        }

        // Сортировка полученного массива четных чисел в обратном порядке (>)
        int length = evenNumbers.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = evenNumbers[i];
            evenNumbers[i] = evenNumbers[length - 1 - i];
            evenNumbers[length - 1 - i] = temp;
        }
        return evenNumbers;
    }

    // Метод для нахождения нулей в заданном массиве
    public static int[] getZero(int[] array) {
        ArrayList<Integer> zeroList = new ArrayList<>();

        for (int zeroNumber : array) {
            if (zeroNumber == 0) {
                zeroList.add(zeroNumber);
            }
        }

        int[] zeroNumbers = new int[zeroList.size()];
        for (int i = 0; i < zeroList.size(); i++) {
            zeroNumbers[i] = zeroList.get(i);
        }
        return zeroNumbers;
    }

    // Метод соединяющий несколько массивов в один
    public static int[] getArrayAddition(int[]... arrays) {
        int totalCount = 0;
        for (int[] array: arrays) {
            totalCount += array.length;
        }

        int[] arrayAddition = new int[totalCount];
        int index = 0;
        for (int[] array : arrays) {
            for (int num : array) {
                arrayAddition[index++] = num;
            }
        }
        return arrayAddition;
    }

    // Метод для нахождения дубликотов в массиве
    public static int[] getFrequentNumber(int[] array) {
        Map<Integer, Integer> name = new HashMap<>();
        for (int num : array) {
                name.put(num, name.getOrDefault(num, 0) + 1);
        }

        List<Integer> countNumbers = new ArrayList<>();
        for (int i : name.keySet()) {
            if (name.get(i) > 1) {
                countNumbers.add(i);
            }
        }

        int[] dublicatesNumbers = new int[countNumbers.size()];
        for (int j = 0; j < countNumbers.size(); j++) {
            dublicatesNumbers[j] = countNumbers.get(j);
        }
        return dublicatesNumbers;
    }
}
