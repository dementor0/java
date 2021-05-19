import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main_chains {
    public static void main( String args[] )
    {
        HashTable_chains table=new HashTable_chains(7);

        try
        {
            File file = new File("C:\\Users\\dmtr\\IdeaProjects\\4 сем\\Lab2\\input.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext())
            {
                table.addElement(scanner.next());
            }
            scanner.close();

        }

        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        table.printHashTable();
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите слово для поиска: ");
        String answer = sc.nextLine();
        if(table.findElement(answer))
        {
            System.out.print("Такое слово есть.");
        }
        else
            System.out.print("Такого слова нету.");

    }
}
