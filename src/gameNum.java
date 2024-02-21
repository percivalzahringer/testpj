import java.util.*;

public class gameNum {
    public static void main(String[] args) {
        Scanner sanner = new Scanner(System.in);
        Map<String, int[]> map = new HashMap<>();
        Random random = new Random();
        int sizeArray = 3;

        System.out.println("Введите кол-во игроков");
        int countPlayers = sanner.nextInt();
        sanner.nextLine(); //отчистка буфера

        System.out.println("Введите кол-во бросков кубика");
        int countRoll = sanner.nextInt();
        sanner.nextLine();//отчистка буфера

        for (int i = 0; i< countPlayers; i++) {
            System.out.println("Введите имя игрока");
            String key = sanner.nextLine();

            int[] array = new int[sizeArray];
            System.out.println("Введите последовательности ");
            for (int j = 0; j < sizeArray; j++) {
                array[j] = sanner.nextInt();
            }
            sanner.nextLine(); //отчистка буфера

            map.put(key, array);
        }
        System.out.println("Результаты\n");
        for(Map.Entry<String, int[]> entry : map.entrySet()) {
            System.out.print("Игрок " + entry.getKey() + "\nВыбранные последовательности: ");
            int score = 0;
            int[] value = entry.getValue();
            for (int num : value) {
                System.out.print(num + " ");
            }
            for (int i = 0; i < countRoll; i++) {
                int first = random.nextInt(6) + 1;
                int second = random.nextInt(6) + 1;
                int third = random.nextInt(6) + 1;
                if (first == value[0] && second == value[1] && third == value[2]){
                    score++;
                }
            }
            System.out.println("\nНабрал " + score + " очков.\n");
        }
        System.out.println();
    }
//    public static Map<Integer, String> getNamePlayer (Scanner scanner) {
//        Map<Integer, String> playersNames = new HashMap<>();
//        int id = 1;
//
//        while (true) {
//            System.out.println("(Help - посмотреть команды)");
//            String name = scanner.nextLine();
//
//            if (name.equals("Help")) {
//                System.out.println("(Exit - для завершения ввода имен)");
//                System.out.println("(Show - отобразить введеный список имен)");
//                continue;
//            }
//
//            if (name.equals("Exit")) {
//                break;
//            }
//
//            if (name.equals("Show")){
//                for (Map.Entry<Integer, String> entry : playersNames.entrySet()) {
//                    System.out.println(entry.getKey() + " " + entry.getValue());
//                }
//                continue;
//            }
//
//            playersNames.put(id, name);
//            id++;
//            System.out.println("Имя " + name + " успешно добавленно.");
//        }
//
//        for (Map.Entry<Integer, String> entry : playersNames.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
//        return playersNames;
//    }
//---------------------------------------------------------------------------------------
}
