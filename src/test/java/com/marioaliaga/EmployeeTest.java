package com.marioaliaga;

import com.marioaliaga.modelo.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by maliaga on 6/8/17.
 */
public class EmpleadoTest {

    private static EntityManager manager;
    private static EntityManagerFactory factory;

    public static void main(String ... args){

        factory = Persistence.createEntityManagerFactory("Persistencia");
        manager = factory.createEntityManager();

        Employee e = new Employee(1L, "Aliaga", "Mario", new GregorianCalendar(1979, 11, 7).getTime());

        manager.getTransaction().begin();
        manager.persist(e);
        manager.getTransaction().commit();

        imprimeTodo();

    }

    public static void imprimeTodo(){
        List<Employee> empleadoList = manager.createQuery("FROM Employee").getResultList();

        System.out.println("La cantidad de empleados es : " + empleadoList.size());

        for (Employee e :
                empleadoList) {
            System.out.println(e.toString());
        }
    }
}
