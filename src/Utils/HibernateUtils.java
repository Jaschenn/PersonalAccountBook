package Utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    static Configuration configuration=null;
    static SessionFactory sessionFactory=null;
    static {

        configuration=new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();


    }
    //提供方法返回sessionFactory
    public static SessionFactory getSessionFactory(){

        return sessionFactory;
    }


}
