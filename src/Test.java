import Utils.FileWRUtils;
import com.alibaba.fastjson.JSON;
import dao.AccountDao;
import entity.Account;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static java.util.Locale.*;


public class Test {

    public static void main(String[] args){
        String timestr="2018-1-1 01:01";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date=new Date();
        try {
            date=simpleDateFormat.parse(timestr);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(date);
        String m=simpleDateFormat.format(date);
        System.out.println(m);

    }


}
