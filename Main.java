public class Main {
    public static void main(String[] args) {
        int N = 20,
            L = 15,
            max = 0,
            adaptability;
        Encoding current, maxS;

        EncodingCollection collection = new EncodingCollection(L);
        maxS = collection.asList().get(0);

        for(int i = 0; i <= N; i++) {
            current = collection.getRandom();
            adaptability = current.getAdaptability().square(L);

            System.out.println("\nШаг: " + i);
            System.out.println("Выбран Si: (" + current.getPosition() + ") " + current.toString(L) + ", ее приспособленность: " + adaptability);
            System.out.println("Текущий max: " + max + ", текущий maxS: (" + maxS.getValue() + ") " + maxS.toString(L));
            if (max < adaptability) {
                System.out.println("Найден лучший max: " + max + " < " + adaptability + ", лучшая кодировка: (" + current.getPosition() + ") " + current.toString(L));
                max = adaptability;
                maxS = current;
            }
        }
    }
}
