package javaguide.basic;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileTest {
    public static void main(String[] args) {
        String s = "path";
        File file = new File(s);
        file.list();

    }

    public static void readFile(String path){
        File file = new File(path);
        //read file
        try (Scanner scanner = new Scanner(file);){

        } catch (Exception e){

        }
    }

    public static void isMatch(){
        String content = " s ";
        String pattern = ".*?/";

        boolean isMatch = Pattern.matches(pattern, content);



        String line = "This order was placed for QT3000! OK?";
        String pattern2 = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern2);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if(m.find()){
            m.group(0);
        }
    }
}
