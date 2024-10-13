package javaguide.collection.hashmap;

public interface SimpleMap<K, V> {
    static interface Entry<K, V>{
      K getKey();
      V getValue();
    };

    V put(K k, V v);
    V get(K k);
}
