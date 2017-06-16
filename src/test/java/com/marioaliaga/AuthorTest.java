package com.marioaliaga;

import com.marioaliaga.modelo.Author;
import com.marioaliaga.modelo.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by maliaga on 6/15/17.
 */
public class AuthorTest {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("Persistencia");

    public static void main(String... args) {

        createData();
        printAll();

    }

    private static void createData() {

        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        Author author1 = new Author(1l, "Pablo Peréz", "Expañola");
        Author author2 = new Author(2l, "Elena Gómez", "Mexicana");
        Author author3 = new Author(3l, "Miguel López", "Chileno");

        manager.persist(author1);
        manager.persist(author2);
        manager.persist(author3);

        manager.persist(new Book(1l, "Programar en Java es fácil", author2));
        manager.persist(new Book(2l, "Como vestirse con estilo", author3));
        manager.persist(new Book(3l, "Cómo cocinar sin quemar al cocina", author1));
        manager.persist(new Book(4l, "Programar cobol es muy entretenido", author2));
        manager.persist(new Book(5l, "Programar cobol no es muy entretenido", author2));

        manager.getTransaction().commit();
        manager.close();

    }

    private static void printAll() {
        EntityManager manager = factory.createEntityManager();

        Author author = manager.find(Author.class, 2L);
        List<Book> authorList = author.getBookList();
        System.out.println(author);

        for (Book book : authorList
                ) {
            System.out.println("* " + book.toString());
        }


        manager.close();
    }
}
