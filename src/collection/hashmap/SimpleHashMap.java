package collection.hashmap;

import java.util.HashMap;

public class SimpleHashMap<K, V> implements SimpleMap<K, V> {

    /* 1. 内部类 Node  */
    public static class Node<K, V> implements SimpleMap.Entry<K, V> {

        private K key;
        private V value;
        Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }


    /* 2. 成员变量 */

    //默认初始容量
    private static final int DEFAULT_INTI_CAPACITY = 1 << 4;

    //默认扩容系数
    private static final float DEFAULT_LOADER = 0.75f;

    //容量
    private int capacity;

    //扩容系数
    private float loader;

    //table 数组
    private Node<K, V>[] table = null;

    //数组大小
    private int size = 0;


    /* 4. 构造函数  */
    @SuppressWarnings({"unchecked"})
    public SimpleHashMap(int capacity, float loader) {
        this.capacity = capacity;
        this.loader = loader;
        table = (Node<K,V>[])new Node[capacity]; //improve by lazy load
    }

    public SimpleHashMap() {
        this(DEFAULT_INTI_CAPACITY, DEFAULT_LOADER);
    }

    /* 3. 成员方法  */
    @Override
    public V put(K key, V value) {
        return putVal(hash(key), key, value);
    }

    //对key再进行一次hash，防抖动
    final int hash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    //TODO: 
    private V putVal(int hash, K key, V value) {
        return null;
    }


    @Override
    public V get(Object o) {
        return null;
    }
}
