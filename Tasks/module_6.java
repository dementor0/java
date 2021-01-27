package Tasks;

import java.util.ArrayList;
import java.util.Arrays;

public class module_6{

    public static void main(String[] args) {
        Task01(3);
        Task02("Apple");
        Task03("rgb(0,,0)");
        Task04("https://edabit.com?a=1&b=2&a=2");
        Task05("Why You Will Probably Pay More for Your Christmas Tree This Year");
        Task06(4);
        Task07("abcda");
        Task08(12);
        Task09("6 * 4 = 24");
        Task10(11);

    }

    public static void Task01(int n){
        System.out.println();
        System.out.println("@Task 1@");
        System.out.println("For n - " + n + "\nBell numbers: " + bell(n));
    }

    public static int bell(int n) {
        int[][] bellTriangle = new int[n+1][n+1];
        bellTriangle[0][0] = 1;

        for (int i=1; i<=n; i++) {
            bellTriangle[i][0] = bellTriangle[i-1][i-1];

            for (int j=1; j<=i; j++) {
                bellTriangle[i][j] = bellTriangle[i-1][j-1] + bellTriangle[i][j-1];
            }
        }

        return bellTriangle[n][0];
    }

    public static void Task02(String str){
        System.out.println();
        System.out.println("@Task 2@");
        System.out.println("For sentence - " + str + "\nTranslated sentence -  " + translateSentence(str));
    }

    public static String translateWord(String word) {
        String result = word;

        if (String.valueOf(result.charAt(0)).toLowerCase().matches("[aeiouy]")) { // если 1 гласная
            result += "yay";
        } else {
            result = result.toLowerCase();
            String newWord = result.split("[aeiouy]")[0];   //разделяем по гласной букве
            result = result.replaceFirst(newWord,"") + newWord + "ay"; //переставляет
            result = String.valueOf(result.charAt(0)).toUpperCase() + result.substring(1);
        }

        return result;
    }

    public static String translateSentence(String str) {
        char lastSymb = str.charAt(str.length()-1);
        String[] tokens = str.split(" ");
        str = "";
        for (int i = 0; i < tokens.length; i++){
            str += translateWord(tokens[i]);
        }
        return (String.join(" ", tokens)+ lastSymb);
    }

    public static void Task03(String str){
        System.out.println();
        System.out.println("@Task 3@");
        System.out.println("Is the string " + str + " an rgb format - " + validColor(str));
    }

    public static boolean validColor(String str) {
        if (!str.startsWith("rgb") && !str.startsWith("rgba")) {
            return false;
        }

        String[] numbers = str.split("\\(")[1].split(","); // подстрока из чисел
        numbers[numbers.length - 1] = numbers[numbers.length - 1].substring(0, numbers[numbers.length - 1].length() - 1);// убирает последнюю скобку

        if (str.startsWith("rgb") && !str.startsWith("rgba")) {
            if (str.contains(".")) {  // в ргб не может быть не целых
                return false;
            }

            for (int i = 0; i < numbers.length; i ++) {
                if (numbers[i].trim().equals("")) {   // если нет числа
                    return false;
                }

                int num = Integer.parseInt(numbers[i].trim());

                if (!(num >= 0 && num <= 255)) {    //для проверки ргб
                    return false;
                }
            }
        } else {
            for (int i = 0; i < numbers.length - 1; i ++) {   // первые 3 элемента
                if (numbers[i].trim().equals("")) {
                    return false;
                }

                int num = Integer.parseInt(numbers[i].trim());

                if (!(num >= 0 && num <= 255)) {
                    return false;
                }
            }

            if (numbers[3].trim().equals("")) return false; // проверка последнего на пустоту

            double num = Double.parseDouble(numbers[3].trim());

            return num >= 0 && num <= 1;   // проверка на дробь
        }

        return true;
    }

    public static void Task04(String str){
        System.out.println();
        System.out.println("@Task 4@");
        System.out.println("For URL" + str + "\nResult - " + stripUrlParams(str));
    }

    public static String stripUrlParams(String url, String ...paramsToStrip) {
        String str = "";

        if (!url.contains("?"))
            return url;
        else {
            str = url.substring(url.indexOf("?") + 1);
            url = url.substring(0, url.indexOf("?") + 1);
        }

        char[] params = str.toCharArray();
        StringBuilder print = new StringBuilder();

        for (char param : params) { // рассматривает каждый символ
            if (Character.isLetter(param)) // буква ли?
                if (!(print.toString().contains(String.valueOf(param)))) { // не соджерижтся ли символ в строке?
                    if (paramsToStrip.length > 0) { // если есть значение 2
                        for (String arg : paramsToStrip) {
                            if (!(arg.contains(String.valueOf(param))))
                                print.append(str, str.lastIndexOf(param), str.lastIndexOf(param) + 3).append("&"); //записывает буквы и вставляет &
                        }
                    }
                    else
                        print.append(str, str.lastIndexOf(param), str.lastIndexOf(param) + 3).append("&"); // если нет 2-ой строки
                }
        }

        return url + print.substring(0, print.length()-1);
    }

    public static void Task05(String str){
        System.out.println();
        System.out.println("@Task 5@");
        System.out.println("For str" + str + "\nResult - " + getHashTags(str).toString());
    }


    public static ArrayList<String> getHashTags(String str){
        String[] tokens = str.toLowerCase().split(" ");// разбивает на слова
        ArrayList<String> hashtags = new ArrayList<>();

        while (hashtags.size() < 3) {  //если нет 3 самых длинных слов
            double maxLength = Double.NEGATIVE_INFINITY;
            String word = "";
            int idx = 0;

            try {
                for (int i = 0; i < tokens.length; i++) {
                    if (tokens[i].length() > maxLength) { // слово с масимальной длинной
                        maxLength = tokens[i].length();
                        word = tokens[i];
                        idx = i;
                    }
                }

                if (String.valueOf(word.charAt(word.length() - 1)).matches("[!?.,;:]")) { // если слово содержит запятую
                    hashtags.add("#" + word.substring(0, word.length() - 1));
                } else {
                    hashtags.add("#" + word);
                }
                tokens[idx] = "";
            } catch (StringIndexOutOfBoundsException e) {
                return hashtags;
            }
        }

        return hashtags;
    }
    public static void Task06(int n){
        System.out.println();
        System.out.println("@Task 6@");
        System.out.println("For str" + n + "\nResult - " + ulam(n));
    }

    public static int ulam (int n){
        int[] arr = new int[n];
        arr[0]=1;
        arr[1]=2;
        int len=2, next=3;

        while (next < Integer.MAX_VALUE && len < n){
            int count = 0;

            for (int i = 0; i < len; i++){
                for (int j = len-1; j > i; j--){
                    if (arr[i] + arr[j] == next && arr[i] != arr[j]) // находим следующеее число из суммы других
                        count++;
                    else if (count > 1)                             // но суммму которую можно составить только из 2 цифр
                        break;
                }

                if (count > 1)
                    break;
            }
            if (count == 1) {
                arr[len] = next;
                len++;
            }
            next++;
        }
        return arr[n-1];
    }
    public static void Task07(String str){
        System.out.println();
        System.out.println("@Task 7@");
        System.out.println("For str" + str + "\nResult - " + longestNonrepeatingSubstring(str));
    }

    public static String longestNonrepeatingSubstring(String str){
        String substr = "";
        char [] chars = str.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char c : chars) {
            if (!builder.toString().contains(String.valueOf(c))) // если не содержит то записываем
                builder.append(c);
            else {
                if (builder.length() > substr.length()) {
                    substr = builder.toString();           // макисмальная подстрока
                }
                builder = new StringBuilder("" + c);
            }
        }

        str = builder.toString();

        if (str.length() > substr.length())
            substr = str;

        return substr;
    }
    public static void Task08(int num) {
        System.out.println();
        System.out.println("@Task 8@");
        System.out.println("For str" + num + "\nResult - " + convertToRoman(num));
    }

    public static String convertToRoman (int num){
        StringBuilder roman = new StringBuilder();

        if (num < 1 || num > 3999)
            return "Введите число поменьше. ";

        while (num >= 1000) {
            roman.append("M");
            num -= 1000;
        }

        while (num >= 900) {
            roman.append("CM");
            num -= 900;
        }

        while (num >= 500) {
            roman.append("D");
            num -= 500;
        }

        while (num >= 400) {
            roman.append("CD");
            num -= 400;
        }

        while (num >= 100) {
            roman.append("C");
            num -= 100;
        }

        while (num >= 90) {
            roman.append("XC");
            num -= 90;
        }

        while (num >= 50) {
            roman.append("L");
            num -= 50;
        }

        while (num >= 40) {
            roman.append("XL");
            num -= 40;
        }

        while (num >= 10) {
            roman.append("X");
            num -= 10;
        }

        while (num >= 9) {
            roman.append("IX");
            num -= 9;
        }

        while (num >= 5) {
            roman.append("V");
            num -= 5;
        }

        while (num >= 4) {
            roman.append("IV");
            num -= 4;
        }

        while (num >= 1) {
            roman.append("I");
            num -= 1;
        }

        return roman.toString();
    }
    public static void Task09(String str){
        System.out.println();
        System.out.println("@Task 9@");
        System.out.println("For str" + str + "\nResult - " + formula(str));
    }

    public static boolean formula(String formula){
        String[] tokens = formula.split(" ");
        int ans = 0;
        int expectedResult = 0;

        if (!Character.isDigit(tokens[0].charAt(0))) return false;
        else ans = Integer.parseInt(tokens[0]);

        int i = 1;

        while (!tokens[i].equals("=")) {
            if (tokens[i].equals("+")){
                ans += Integer.parseInt(tokens[i + 1]);
            }
            if (tokens[i].equals("-")){
                ans -= Integer.parseInt(tokens[i + 1]);
            }
            if (tokens[i].equals("*")){
                ans *= Integer.parseInt(tokens[i + 1]);
            }
            if (tokens[i].equals("/")){
                ans /= Integer.parseInt(tokens[i + 1]);
            }

            i += 2;
        }

        i = formula.indexOf('=');
        String check = formula.substring(i + 1);

        if (check.contains("=")) return false;
        else expectedResult = Integer.parseInt(tokens[tokens.length - 1]);

        return ans == expectedResult;
    }
    public static void Task10(int num) {
        System.out.println();
        System.out.println("@Task 10@");
        System.out.println("For str" + num + "\nResult - " + palindromedescendant(num));
    }

    public static boolean palindromedescendant(int num){
        boolean isDescendant = false;
        StringBuffer buffer1 =new StringBuffer(num);
        StringBuffer buffer2 =new StringBuffer(num);

        if (buffer1.length() % 2 != 0)
            return false;
        else {
            while (!isDescendant){
                if(buffer1 != buffer1.reverse()){
                    for(int i = 0; i < buffer1.length(); i += 2){
                        int a = Integer.parseInt(String.valueOf(buffer1.charAt(i)));
                        int b = Integer.parseInt(String.valueOf(buffer1.charAt(i + 1)));
                        buffer2.append(a + b);
                    }
                }
                else
                    isDescendant = true;
            }
        }

        return isDescendant;
    }
}