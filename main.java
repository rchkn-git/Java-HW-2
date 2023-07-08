import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


//Задание
//1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса,
//используя StringBuilder или String. Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

public class main {
    public static void main(String[] args) {
        char[] chars = null;

        try{
            File file = new File("file");
            String[] inputStringArray = {"name:Ivanov", "country:Russia", "city:Moscow", "age:null"};
            for(int i = 0; i < inputStringArray.length; i++){
                inputStringArray[i] = inputStringArray[i].replace(":", " for ");
            }
            FileWriter writer = new FileWriter(file);
            writer.write("select * from students where");
            for(int i = 0; i < inputStringArray.length; i++){
                if (i != inputStringArray.length - 1){
                    writer.write(" " + inputStringArray[i] + " AND");
                }
                else {
                    writer.write(" " + inputStringArray[i]);
                }
            }
            writer.close();

            FileReader reader = new FileReader(file);
            chars = new char[(int) file.length()];
            reader.read(chars, 0, (int) file.length());
        } catch (IOException e) {
            System.out.println("There is an exeption!");
        }
        System.out.println(Arrays.toString(chars));
    }
}
