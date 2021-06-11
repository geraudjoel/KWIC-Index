package de.tukl.programmierpraktikum2021.mp2;

import com.googlecode.concurrenttrees.common.KeyValuePair;
import com.googlecode.concurrenttrees.radix.ConcurrentRadixTree;
import com.googlecode.concurrenttrees.radix.node.concrete.DefaultCharArrayNodeFactory;

public class TrieMap<V> implements Trie<V>{
    private final ConcurrentRadixTree<V> Trie= new ConcurrentRadixTree<>(new DefaultCharArrayNodeFactory());

    /*public TrieMap() {
        this.Trie = new ConcurrentRadixTree<>(new DefaultCharArrayNodeFactory());
    }*/

    @Override
    public V get(String key) {
        return this.Trie.getValueForExactKey(key);
    }

    @Override
    public void put(String key, V value) {
        this.Trie.put(key, value);
    }

    @Override
    public void remove(String key) {
        this.Trie.remove(key);
    }

    @Override
    public int size() {
        return this.Trie.size();
    }

    @Override
    public Iterable<KeyValuePair<V>> searchKeyPrefix(String prefix) {
        return this.Trie.getKeyValuePairsForKeysStartingWith(prefix);
    }
}
