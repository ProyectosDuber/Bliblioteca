/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Duber
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    public static Session sesion;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void save(Object objeto) {
        try {
            Transaction transaccion = sesion.getTransaction();
            transaccion.begin();
            sesion.save(objeto);
            transaccion.commit();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static void update(Object objeto) {
        try {
            Transaction transaccion = sesion.getTransaction();
            transaccion.begin();
            sesion.update(objeto);
            transaccion.commit();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static List Query(String query) {
        try {
            Query q = sesion.createQuery(query);
            return q.list();
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static List QuerySQL(String query) {
        try {
            Query q = sesion.createSQLQuery(query);
            return q.list();
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static Object QueryUnicod(String query) {
        try {
            Query q = sesion.createQuery(query);
            return q.uniqueResult();
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static Object QuerySQLUnicod(String query) {
        try {
            Query q = sesion.createSQLQuery(query);
            return q.uniqueResult();
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}
