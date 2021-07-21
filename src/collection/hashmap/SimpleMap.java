package collection.hashmap;

public interface SimpleMap<K, V> {
    public interface Node<K, V>{
      K getKey();
      V getValue();
    };

    Node<K,V> put(K k, V v);
    Node<K,V> get(K k);
}
