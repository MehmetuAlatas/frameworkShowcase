package utilities;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
public class DateUtils {

        // MMMM dd, yyy  --> February 17, 2019
        public static String todaysDate(){
            String today = new SimpleDateFormat("MMMM dd, yyy").format(new Date());
            return today;
        }
        // MM-dd-yy     --> 02-17-19
        public static String todaysDate2(){
            String today = new SimpleDateFormat("MM-dd-yy").format(new Date());
            return today;
        }
        // dd-MM-yy    --> 17-02-19
        public static String todaysDate3(){
            String today = new SimpleDateFormat("dd-MM-yy").format(new Date());
            return today;
        }
        // yyyy-MM-dd hh:mm:ss   --> 2019-02-17 03:45:11
        public static String todaysDate4(){
            String today = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
            return today;
        }

//    public static void main(String[] args) {
//        System.out.println(getDate());
//    }


    public static String getDate(){
        LocalDateTime dateObj = LocalDateTime.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return dateObj.format(formatDate);
    }
}
