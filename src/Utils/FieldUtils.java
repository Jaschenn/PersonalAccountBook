package Utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FieldUtils {
    public static String[] getFiledName(Object object){
        Field[] fields=object.getClass().getDeclaredFields();
        String[] fieldsNames=new String[fields.length];
        for (int i=0;i<fields.length;i++){

            fieldsNames[i]=fields[i].getName();
        }
        return fieldsNames;
    }
    /*
     * 根据属性名获取值,需要一个属性名，还有一个对象
     * */
    public static Object getFieldValueByName(String fieldName,Object object){
        try{
            String firstLetter = fieldName.substring(0,1).toUpperCase();
            String getter = "get"+firstLetter+fieldName.substring(1);
            Method method = object.getClass().getMethod(getter,new Class[]{});
            Object value = method.invoke(object,new Object[]{});
            return value;
        }catch (Exception e){
            return null;
        }
    }
}
