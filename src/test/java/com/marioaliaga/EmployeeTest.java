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
public class EmployeeTest {

    private static EntityManagerFactory factory  = Persistence.createEntityManagerFactory("Persistencia");

    public static void main(String ... args){

       EntityManager manager = factory.createEntityManager();

        insertInitial();
        printAll();

        manager.getTransaction().begin();
        Employee e = manager.find(Employee.class, 1L);
        e.setNombre("RAFAEL");
        e.setApellidos("ALIAGA");
        manager.getTransaction().commit();

        printAll();
        manager.close();

    }

    private static void insertInitial() {
        EntityManager manager = factory.createEntityManager();

        Employee e = new Employee(1L, "Aliaga", "Mario", new GregorianCalendar(1979, 11, 7).getTime());

        manager.getTransaction().begin();
        manager.persist(e);
        manager.getTransaction().commit();
        manager.close();

    }

    public static void printAll(){
        EntityManager manager = factory.createEntityManager();

        List<Employee> employeeList = manager.createQuery("FROM Employee").getResultList();

        System.out.println("La cantidad de empleados es : " + employeeList.size());

        for (Employee e :
                employeeList) {
            System.out.println(e.toString());
        }

        manager.close();
    }
}
