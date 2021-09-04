package org.faang.codinginterview;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterSubListInsideList {

    static List<Developer> developerList = new ArrayList<>();

    public static void main(String[] args) {
        Developer developer1 = new Developer();
        developer1.setId(1);
        String book1 = "Hello Java";
        String book2 = "Hello Python fundamentals";
        List<String> bookList1 = new ArrayList<>();
        bookList1.add(book1);
        bookList1.add(book2);
        developer1.setBooks(bookList1);

        Developer developer2 = new Developer();
        developer1.setId(1);
        String book11 = "Hello XML";
        String book22 = "Hello Zero to Hero Python";
        String book33 = "Hello Docker";
        List<String> bookList2 = new ArrayList<>();
        bookList2.add(book11);
        bookList2.add(book22);
        bookList2.add(book33);
        developer2.setBooks(bookList2);
        
        developerList.add(developer1);
        developerList.add(developer2);

        developerList.stream().flatMap(developer -> developer.getBooks().stream())
                        .filter(c -> filterBooks(c))
                                .collect(Collectors.toList()).forEach(d -> System.out.println(d));

    }

    static boolean filterBooks(String books){
        return !books.contains("Python");
    }
}

class  Developer{
    int id;
    List<String> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", books=" + books +
                '}';
    }
}