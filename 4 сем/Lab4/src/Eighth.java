import java.io.*;
import java.util.*;
public class Eighth {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\dmtr\\IdeaProjects\\4 сем\\Lab4\\Eighth.txt");
        Scanner scanner = new Scanner(file);
        Stack temp = new Stack();
        while (scanner.hasNext()) {
            temp.add(scanner.nextLine());
        }
        try (PrintWriter pw = new PrintWriter("C:\\Users\\dmtr\\IdeaProjects\\4 сем\\Lab4\\Eighth_answer.txt")) {
            {
                for (int i=0;i<=temp.size();++i) {
                    String s ;
                    s = (String) temp.pop();
                    pw.println(s);
                }
                pw.println(temp.pop());
                }
                temp.remove(temp);
        } catch (IOException exc) {
            System.out.println(exc);
        }
    }

}
