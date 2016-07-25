package com.bjsxt.registeration.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Created by  Mark L Tao on 2016/7/25 17:04.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
