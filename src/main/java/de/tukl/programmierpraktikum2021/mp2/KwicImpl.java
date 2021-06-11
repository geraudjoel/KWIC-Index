package de.tukl.programmierpraktikum2021.mp2;

import com.googlecode.concurrenttrees.common.KeyValuePair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KwicImpl implements Kwic{
    private final Trie<Book> BookTrie = new TrieMap<>();



    @Override
    public void add(Book book) {
        String working_title = book.title.toLowerCase() + ".";
        String[] words = working_title.split(" ");

        StringBuilder rotation;

        for (int i=0; i < words.length; i++) {
            rotation = new StringBuilder();

            for (int j=0; j < words.length; j++) {
                int shift = j+i;
                if (shift >= words.length)
                    shift = shift - words.length;

                rotation.append(words[shift]).append(" ");
            }
            rotation = new StringBuilder(rotation.substring(0, rotation.length() - 1)); //cut off excess " "

            String first_word = rotation.toString().split(" ",2)[0];
            boolean is_exception = Arrays.asList(Util.exceptions).contains(first_word);

            if (!is_exception) {
                BookTrie.put(rotation.toString(), book);
            }
        }
    }

    @Override
    public List<Book> search(String term) {
        List<Book> results = new ArrayList<>();

        Iterable<KeyValuePair<Book>> found_books = BookTrie.searchKeyPrefix(term.toLowerCase());

        found_books.forEach(bookKeyValuePair -> results.add(bookKeyValuePair.getValue()));

        return results;
    }
}
