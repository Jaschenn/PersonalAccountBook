package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class FileWRUtils {
    static String filename;
    static Object object;
    public static void JfileWriter(){
        String[] fields=FieldUtils.getFiledName(object);
        int arrNumber = fields.length;
        String data="";
        for (int i=0;i<arrNumber;i++){
            data=data+FieldUtils.getFieldValueByName(fields[i],object)+" ";
        }
        data+="\n";
        System.out.println(data);

        try {
            FileWriter fileWriter = new FileWriter(filename,true);
            fileWriter.write(data);
            fileWriter.flush();
            fileWriter.close();



        }catch (Exception e){
            e.getMessage();
        }finally {


        }

    }

    public static void JfileWriter(ArrayList arrayList){
        for (int i=0;i<arrayList.size();i++){
            object=arrayList.get(i);
            JfileWriter();
        }

    }

    public static Object[] JfileReader(){
        /*
        * 书写目的：从文件中读取数据，然后加载到数据库中。
        * 数据库使用了hibernate，只需要传入对象。
        * 所以从文件中读取出来的东西，应该直接返回一个对象数组，方便操作
        * 实现：
        * 读取文件每一行
        * 根据指定类的属性去new class  ## 要求：类有构造函数
        * 将class加载到list中
        *
        * */
        Object[] objects=null;
        BufferedReader bufferedReader = null;
        String line=null;
        String[] values;
        try{
         //   bufferedReader=new BufferedReader(new FileReader(filename));
          //  while ((line=bufferedReader.readLine())!=null){

           //     values=line.trim().split(" ");  //从文件中读取的信息，每一行是一个对象的全部属性
                /*
                *
                * 以下内容需要重新写
                * */
//
//                Class clazz = object.getClass();
//                Field[] fs = object.getClass().getDeclaredFields();//获取所有的属性
//
//                Constructor[] cs = object.getClass().getConstructors();//获取所有的自己声明的构造函数
//                Object[] paraments={"asd",2,"sda"};
//                Object o = cs[1].newInstance(paraments);
//                System.out.println("000  -=="+o.toString());
//
//                Class c = (Class)cs[0].newInstance();
//                System.out.println(c.toString());
//
//
//
//
//                for (Constructor constructor:cs
//                     ) {
//                    System.out.println(constructor.toString());
//                }
//                System.out.println("========");
//
//                for (Field field:fs
//                     ) {
//                    Class fieldType = field.getType();
//                    String typeName = fieldType.getName();
//                    String fieldName =field.getName();
//                    System.out.println(typeName+" "+fieldName);
//                }





        //    }


        }catch (Exception e){

        }

        return objects;
    }

    public static String getFilename() {
        return filename;
    }

    public static void setFilename(String filename) {
        FileWRUtils.filename = filename;
    }

    public static Object getObject() {
        return object;
    }

    public static void setObject(Object object) {
        FileWRUtils.object = object;
    }
}
