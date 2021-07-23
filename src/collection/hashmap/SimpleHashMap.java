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

    //map 大小
    private int size = 0;

    /* 4. 构造函数  */
    @SuppressWarnings({"unchecked"})
    public SimpleHashMap(int capacity, float loader) {
        this.capacity = capacity;
        this.loader = loader;
        table = (Node<K, V>[]) new Node[capacity]; //Could be improved by lazy load
    }

    public SimpleHashMap() {
        this(DEFAULT_INTI_CAPACITY, DEFAULT_LOADER);
    }

    /* 3. 成员方法  */
    @Override
    public V put(K key, V value) {
        //当前table的长度
        int n = resize().length;
        //将hash值映射到table的index
        int index = hash(key) & (n - 1);

        //如果节点为null，表示没有冲突, 可直接插入新节点
        if (table[index] == null) {
            table[index] = new Node<>(key, value, null);
            size++;
        }
        //如果节点不为null，表示存在冲突,
        else {
            Node<K, V> p = table[index];
            //遍历看链表是否已经存在当前key
            while (p != null) {
                if (key.equals(p.key)) {
                    V oldValue = p.value;
                    p.value = value;
                    return oldValue;
                }
                //如果链表中不存在，就在最后插入新节点
                if (p.next == null) {
                    p.next = new Node<K, V>(key, value, null);
                    return null;
                }
                p = p.next;
            }
        }
        return null;
    }

    //对key再进行一次hash，防抖动
    private int hash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    //resize, 返回resize 之后的table
    private Node<K, V>[] resize() {
        //TODO: IMPLEMENT
        //if need resize()
        return table;
    }


    @Override
    public V get(K key) {
        int n = table.length;
        int index = hash(key) & (n - 1);
        //index 没有对应值，直接返回null
        if (table[index] == null) return null;

        //否则遍历链表
        Node<K, V> p = table[index];
        while (p != null) {
            if (key.equals(p.key)) {
                return p.value;
            }
            p = p.next;
        }

        //并没有在链表中找到
        return null;
    }

    //Test SimpleHashMap
    public static void main(String[] args) {

        //Test address conflict and replace
        SimpleHashMap<String, String> map = new SimpleHashMap<>(4,2);
        map.put("1","Bob");
        map.put("2","Mary");
        map.put("3","Carrie");
        map.put("4","James");
        map.put("5","Alice");
        map.put("5", "Perry");

        System.out.println("Get 1: " + map.get("1"));
        System.out.println("Get 2: " + map.get("2"));
        System.out.println("Get 3: " + map.get("3"));
        System.out.println("Get 4: " + map.get("4"));
        System.out.println("Get 5: " + map.get("5"));

    }
}
