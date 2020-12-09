package Tasks;
import java.util.Scanner;
import java.util.ArrayList;

public class module_4 {
    public static void main(String[] args) {
        Task01();
        Task02();
        Task03();
        Task04();
        Task05();
        Task06();
        Task07();
        Task08();
        Task09();
        Task10();
    }

    public static void Task01() {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Введите кол-во слов");
        int n = sc.nextInt();
        System.out.println("Введите кол-во символов");
        int k = sc1.nextInt();
        System.out.println("Введите строку");
        String s = sc2.nextLine();
        System.out.println(Sp(n, k, s));
    }

    public static String Sp(int n, int k, String s) {
        String[] t = s.split(" "); // Запихивает слова в массив строк ориентируясь на пробелы
        s = "";
        String f = "";
        for (int i = 0; i < n; i++) {
            if (s.length() + t[i].length() > k) {
                f = f.trim() + "\r\n" + t[i] + " ";
                s = t[i];
            } else {
                f += t[i] + " ";
                s += t[i];
            }
        }
        return f.trim(); //Удаляет пробелы в начале и в конце строки
    }

    public static void Task02() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку");
        String s = sc.nextLine();
        System.out.println("Ответ: " + Split(s));
    }

    public static String[] Split(String s) {
        ArrayList<String> list = new ArrayList<String>();
        int f = 0;
        int i = 0;
        while (s.length() > 0) {
            if (s.charAt(i) == '(') f++;
            else f--;
            if (f == 0) {
                list.add(s.substring(0, i + 1)); //Выделяет подстроку ориентируясь на индекс от 0 до i+1
                s = s.substring(i + 1);
                i = 0;
                continue;
            }
            i++;
        }
        return list.toArray(new String[list.size()]);
    }

    public static void Task03() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку");
        String s = sc.nextLine();
        System.out.println("SnakeCase:" + Case1(s));
        System.out.println("CamelCase:" + Case2(s));
    }

    public static String Case1(String s) {
        return s.replaceAll("([A-Z])", "_$0").toLowerCase();
    }

    public static String Case2(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '_')
                s = s.substring(0, i) + s.substring(i + 1, i + 2).toUpperCase() + s.substring(i + 2, s.length());
        }
        return s;
    }

    public static void Task04() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите данные");
        double[] w = new double[4];
        for (int i = 0; i < 4; i++) {
            w[i] = sc.nextDouble();
        }

        System.out.println("Заработано: " + overTime(w));
    }

    public static String overTime(double[] w) {
        double sum = 0;
        if (17 - w[0] >= 0)
            sum += (17 - w[0]) * w[2];
        if (w[1] - 17 >= 0)
            sum += (w[1] - 17) * w[2] * w[3];
        return ('$' + String.valueOf(sum)); //Преобразовывает в дабл
    }

    public static void Task05() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку");
        String c = sc.nextLine();
        String[] s = c.split(" ");
        System.out.println("Ответ: " + BMI(s));
    }

    public static String BMI(String[] s) {
        double ves = Double.parseDouble(s[0].split(" ")[0]);
        double rost = Double.parseDouble(s[2].split(" ")[0]);
        String o = " ";
        if (s[1].contains("pounds")) // Содержит ли слово?
            ves = ves * 0.45;
        if (s[3].contains("inches"))
            rost *= 0.0254;
        double b = Math.round((ves / (rost * rost)) * 10.0) / 10.0;
        if (b < 18.5)
            o = Math.round(b) + " Underweight";
        if (b >= 18.5 && b <= 24.9)
            o = Math.round(b) + " Normal weight";
        if (b > 25)
            o = Math.round(b) + " Overweight";
        return o;
    }

    public static void Task06() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число");
        int a = sc.nextInt();
        System.out.println(bugger(a));
    }

    public static int bugger(int a) {
        int count = 0;
        while (a > 9) {
            int chnum = 1;
            while (a > 0) {
                chnum *= a % 10;
                a /= 10;
            }
            a = chnum;
            count++;
        }
        return count;
    }

    public static void Task07() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку");
        String l = sc.nextLine();
        System.out.println(REP(l));
    }

    public static String REP(String l) {
        int count = 1;
        char let = l.charAt(0);
        String newStr = "";
        for (int i = 1; i < l.length(); i++) {
            if (l.charAt(i) != let) {
                if (count != 1)
                    newStr += let + "*" + count;
                else
                    newStr += let;
                let = l.charAt(i);
                count = 1;
            } else
                count++;
        }
        if (count != 1)
            newStr += let + "*" + count;
        else
            newStr += let;
        return newStr;
    }

    public static void Task08() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку");
        String l = sc.nextLine();
        String s = sc.nextLine();
        System.out.println(doesRhyme(l, s));
    }

    public static boolean doesRhyme(String l, String s) {
        l = s.substring(s.lastIndexOf(" ") + 1);
        s = s.substring(s.lastIndexOf(" ") + 1);
        String let = "aeiouyAEIOUY";
        String res1 = "", res2 = "";
        for (int i = 0; i < l.length(); i++) {
            if (let.indexOf(l.charAt(i)) != -1)
                res1 += l.charAt(i);
        }
        for (int i = 0; i < s.length(); i++) {
            if (let.indexOf(s.charAt(i)) != -1)
                res2 += s.charAt(i);
        }
        if (res1.toLowerCase().equals(res2.toLowerCase())) return true;
        else
            return false;
    }

    public static void Task09() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите числа");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(trouble(a, b));
    }

    public static boolean trouble(long a, long b) {
        String aa = Long.toString(a);
        String bb = Long.toString(b);
        int num = 0;
        for (int i = 2; i < aa.length(); i++) {
            if (aa.charAt(i) == aa.charAt(i - 1) && aa.charAt(i) == aa.charAt(i - 2))
                num = aa.charAt(i);
        }
        for (int i = 0; i < bb.length(); i++) {
            if (bb.charAt(i) == num && bb.charAt(i + 1) == num)
                return true;
        }
        return false;
    }
    public static void Task10() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите числа");
        String s = sc.nextLine();
        String l = sc.nextLine();
        System.out.println(countUniqueBooks(s, l));
    }
    public static int countUniqueBooks(String s, String l){
        String new_s = "";
        int counter = 0;
        int index = 0;
        for (int i = 0; i<s.length(); i++)
            if (s.charAt(i) == l.charAt(0))
                counter++;
        for (int i = 0; i<counter/2; i++) {
            index = s.indexOf(l, index);
            int nextIndex = s.indexOf(l, index + 1);
            new_s += s.substring(index+1, nextIndex);
            index = s.indexOf(l, nextIndex + 1);
        }
        counter = 0;
        boolean[] isItThere = new boolean[Character.MAX_VALUE];
        for (int i = 0; i < new_s.length(); i++) {
            isItThere[new_s.charAt(i)] = true;
        }
        for (int i = 0; i < isItThere.length; i++) {
            if (isItThere[i]){
                counter++;
            }
        }
        return counter;

    }
}

