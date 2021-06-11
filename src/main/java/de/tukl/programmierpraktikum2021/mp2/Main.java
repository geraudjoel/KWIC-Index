package de.tukl.programmierpraktikum2021.mp2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        KwicImpl KWCI_Index = new KwicImpl();

        Arrays.stream(Util.books).forEach(KWCI_Index::add);
       /* for (Book book : Util.books) {
            KWCI_Index.add(book);
        }*/

        System.out.println("Geben sie Suchbegriffe ein:");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        //String line = buffer.readLine ();

        List<Book> results = KWCI_Index.search(buffer.readLine());

        results.forEach(book ->System.out.println(book.author + ". " + book.title + ". " + book.year + ".") );

        /*for (Book result : results) {
            System.out.println(result.author + ". " + result.title + ". " + result.year + ".");
        }*/
    }
}
