import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class KMPSearch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Введите основную строку:");
        String text = sc.nextLine();
        System.out.println("Введите подстроку для поиска:");
        String sample = sc.nextLine();
        System.out.println("Индекс с которого начинается подстрока в строке:");
        System.out.println(Arrays.toString(KMPSearch(text, sample).toArray()));
    }
    static int[] prefixFunction(String sample) {
        int [] values = new int[sample.length()];
        for (int i = 1; i < sample.length(); i++) {
            int j = 0;
            while (i + j < sample.length() && sample.charAt(j) == sample.charAt(i + j)) {
                values[i + j] = Math.max(values[i + j], j + 1);
                j++;
            }
        }
        return values;
    }

    public static ArrayList<Integer> KMPSearch(String text, String sample) {
        ArrayList<Integer> found = new ArrayList<>();
        long start = 0;
        long stop = 0;
        int[] prefixFunc = prefixFunction(sample);

        int i = 0;
        int j = 0;
        start = System.nanoTime();
        while (i < text.length()) {
            if (sample.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == sample.length()) {
                found.add(i - j);
                j = prefixFunc[j - 1];
            } else if (i < text.length() && sample.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = prefixFunc[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
        stop = System.nanoTime();
        System.out.println("KMPSearch: " + (stop-start));
        return found;

    }
}