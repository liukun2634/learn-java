package collection.hashmap;

public class SimpleHashMap<K, V> implements SimpleMap<K, V> {

    /* 1. 内部类 Node  */
    public class Node<K, V> implements SimpleMap.Node<K, V> {

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

    //扩容参数
    private static final float DEFAULT_LOADER = 0.75f;

    //table 数组
    private Node<K, V>[] table = null;

    //数组大小
    private int size = 0;

    /* 3. 成员方法  */

    @Override
    public Node<K, V> put(Object o, Object o2) {
        return null;
    }

    @Override
    public Node<K, V> get(Object o) {
        return null;
    }
}
