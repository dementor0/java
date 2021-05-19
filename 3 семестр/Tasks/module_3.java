package Tasks;
import java.util.Scanner;
import java.util.ArrayList;

public class module_3 {
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
    public static void Task01(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите коэффициенты для уравнения");
        float a = sc.nextInt();
        float b =  sc.nextInt();
        float c =  sc.nextInt();
        System.out.println(Ur(a,b,c));
    }
    public static int Ur(float a,float b, float c){
        int k = 0;
        float discr = b * b - 4 * a * c;
        if (discr < 0){
            return k = 0;
        }
        else if (discr ==0){
            return k = 1;
        }
        else if (discr > 0){
            return k = 2;
        }
        return 0;
    }
    public static void Task02(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку");
        String l = sc.nextLine();
        char [] str = l.toCharArray();
        System.out.println("Позиция второго вхождения: " + Pos(l));
    }
    public static int Pos(String l){
        for (int i=0; i<l.length(); i++){
            int first = l.indexOf("zip");
            int second = 0;
            second = l.indexOf("zip", first + 1);
            if (second!=0)
                return second;
        }
        return -1;
    }
    public static void Task03() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число");
        int a = sc.nextInt();
        System.out.println("Число свовершенное? - " + Sov(a));
    }
    public static boolean Sov(int a){
        int sum=0;
        for (int i=1; i<a; i++){
            if (a%i==0){
                sum = sum +i;
            }
        }
        if (sum==a)
            return true;
        return false;
    }
    public static void Task04() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку");
        String len = sc.nextLine();
        System.out.println(str(len));
    }
    public static String str(String len) {
        if (len.length() < 2) {
            return "несовместимо";
        }
        else if (len.charAt(0) == len.charAt(len.length())){
            return "два - это пара";
        }
        int n= len.length();
        char[] t = len.toCharArray();
        char b = t[0];
        t[0]=t[n-1];
        t[n-1]=b;
        String len1 = new String(t);
        return len1;
    } public static void Task05() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку");
        String s = sc.nextLine();
        System.out.println(Kod(s));
    }
    public static boolean Kod(String s){
        return s.matches("#[0-9a-fA-F]+");
    }
    public static void Task06() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите массив 1:");
        String s = sc.nextLine();
        char[] c = s.toCharArray();
        System.out.println("Введите массив 2:");
        String s1 = sc.nextLine();
        char[] c1 = s1.toCharArray();
        System.out.println(SR(c,c1));
    }
    public static boolean SR(char c[],char c1[]){
        int a,b=0;
        ArrayList<Integer> arr1 = new ArrayList<>();
        for(int i:c ){
            if (!arr1.contains(i)) {
                arr1.add(i);
            }
        }
        if (arr1.size()==1){
            a = 0;
        } else {
            a= arr1.size();
        }
        ArrayList<Integer> arr2 = new ArrayList<>();
        for(int i:c1 ){
            if (!arr2.contains(i)) {
                arr2.add(i);
            }
        }
        if (arr2.size()==1){
            b = 0;
        }
        else {
            b= arr2.size();
        }
        return a == b;
    }
    public static void Task07() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число");
        int a = sc.nextInt();
        System.out.println("Число Капрекара? - " + Kaprekar(a));
    }
    public static boolean Kaprekar(int a) {
        if (a== 1){
            return true;
        }
        int b = a * a;
        int bLength= 0;
        while (b != 0)
        {
            bLength++;
            b /= 10;
        }
        b = a * a;
        for (int i = 1; i < bLength; i++)
        {
            int number = (int) Math.pow(10, i);

            int sum = b / number + a% number;
            if (sum == a) {
                return true;
            }
        }
        return false;
    }
    public static void Task08() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку");
        String s = sc.nextLine();
        System.out.println(Zero(s));
    }
    public static String Zero(String s){
        int b= 0;
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                c++;
                if (c > b) {
                    b = c;
                }

            }
            else {
                c = 0;
            }
        }
        StringBuilder s1 = new StringBuilder("");
        for (int i = 0; i< b; i++) {
            s1.insert(i, '0');
        }
        return new String(s1);
    }
    public static void Task09() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число");
        int a = sc.nextInt();
        System.out.println(nextPrime(a));
    }
    public static int nextPrime(int a){
        boolean h = true;
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                h = false;
                break;
            }
        }
        if (h==true) {
            return a;
        }
        while (!h) {
            a++;
            h = true;
            for (int i = 2; i < a; i++) {
                if (a % i == 0) {
                    h = false;
                    break;
                }
            }
        }
        return a;
    }
    public static void Task10() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ребра");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        System.out.println(rightTriangle(x,y,z));
    }
    public static boolean rightTriangle (int x, int y,int z){
        return x * x + y * y == z * z || x * x + z * z == y * y || y * y + z * z == x * x;
    }
}
