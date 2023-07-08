import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//2) Дана json-строка (можно сохранить в файл и читать из файла)
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//Пример вывода:
//Студент Иванов получил 5 по предмету Математика.
//Студент Петрова получил 4 по предмету Информатика.
//Студент Краснов получил 5 по предмету Физика.

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        try{
            String path = "D:\\IJ Projects\\GB\\untitled\\src\\main\\java\\Data.txt";
            FileReader fr = new FileReader(path);
            Scanner scan = new Scanner(fr);
            StringBuilder builder = new StringBuilder();
            int i = 1;
            String buff = "";
            while (scan.hasNextLine()) {
                buff = scan.nextLine();
                buff = buff.replace("[","");
                buff = buff.replace("]","");
                buff = buff.replaceAll("[{}\"]", "");
                buff = buff.replace("фамилия:","Студент ");
                buff = buff.replace(",оценка:"," получил ");
                buff = buff.replace(",предмет:"," по предмету ");
                buff = buff.replace(",","");
                StringBuilder sb = new StringBuilder(buff);
                sb.append(".");

                System.out.println(sb);
                i++;
            }
            fr.close();
        } catch (IOException e) {
            System.out.println("There is an exeption!");

        }
    }
//    public String reading()
}
