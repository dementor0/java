import java.util.Scanner;

public class Fibonachy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер масива:");
        String n1 = scanner.nextLine();
        System.out.println("Введите минимальное число масива:");
        String min_lim1 = scanner.nextLine();
        System.out.println("Введите максимальное число масива:");
        String max_lim1 = scanner.nextLine();
        if (n1.equals(""))
            n1 = "50";
        if (min_lim1.equals(""))
            min_lim1 = "-250";
        if (max_lim1.equals(""))
            max_lim1 = "1013";
        int n = Integer.parseInt(n1);
        int min_lim = Integer.parseInt(min_lim1);
        int max_lim = Integer.parseInt(max_lim1);
        int[] arr = new int[n];
        System.out.println("Исходный массив:");
        for (int i = 0; i < n; i++) {
            arr[i] = (int) ((Math.random() * (max_lim - min_lim)) + min_lim);
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < n; i++) {
                if (arr[i] < arr[i - 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = tmp;
                    needIteration = true;
                }
            }
        }
        System.out.println("Отсортированный массив:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        System.out.println("Введите элемент для поиска:");
        int item = scanner.nextInt();
        System.out.println();
        FibonachySearch F = new FibonachySearch();
        int index = F.search(arr,item);
        System.out.println("Индекс найденного элемента:");
        System.out.println(index);
    }
    public static class FibonachySearch {
        private int i;
        private int p;
        private int q;
        private boolean stop = false;
        private void init(int[] arr){
            stop = false;
            int k = 0;
            int n = arr.length;
            for(; getFibonachyNumber(k+1) < n+1;){
                k +=1;
            }
            int m = getFibonachyNumber(k+1)-(n+1);
            i = getFibonachyNumber(k) - m;
            p = getFibonachyNumber(k-1);
            q = getFibonachyNumber(k-2);
        }

        public int getFibonachyNumber(int k){
            int firstNumber = 0;
            int secondNumber = 1;
            for (int i = 0;i<k;i++){
                int temp = secondNumber;
                secondNumber += firstNumber;
                firstNumber = temp;
            }
            return firstNumber;
        }

        private void upIndex(){
            if (p==1)
                stop = true;
            i = i + q;
            p = p - q;
            q = q - p;
        }

        private void downIndex(){
            if (q==0)
                stop = true;
            i = i - q;
            int temp = q;
            q = p - q;
            p = temp;
        }

        public int search(int[] arr,int element){
            init(arr);
            int n = arr.length;
            int resIn = -1;
            for (; !stop;){
                if (i < 0){
                    upIndex();
                }
                else if (i>=n){
                    downIndex();
                }
                else if (arr[i]==element){
                    resIn = i;
                    break;
                }
                else if (element <arr[i]){
                    downIndex();
                }
                else if (element > arr[i])
                {
                    upIndex();
                }
            }
           return resIn;
        }
    }

}
