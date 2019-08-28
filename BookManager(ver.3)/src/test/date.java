package test;

import java.text.SimpleDateFormat;
import java.util.Date;

class Date1 {
    public static void main(String[] args) {
        Date today = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyMMddhhmmss");
        String now = date.format(today);
        System.out.println(now);
        // int authornum = Integer.parseInt(now) * 10;
    }
}