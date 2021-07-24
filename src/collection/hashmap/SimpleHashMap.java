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
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    //扩容系数
    private float loadFactor;

    //table 数组
    private Node<K, V>[] table = null;

    //map 大小
    private int size = 0;

    /* 4. 构造函数  */
    @SuppressWarnings({"unchecked"})
    public SimpleHashMap(float loadFactor) {
        this.loadFactor = loadFactor;
        table = (Node<K, V>[]) new Node[DEFAULT_INTI_CAPACITY]; //Could be improved by lazy load
    }

    public SimpleHashMap() {
        this(DEFAULT_LOAD_FACTOR);
    }

    /* 3. 成员方法  */
    @Override
    public V put(K key, V value) {
        //当前table的长度
        int n = table.length;
        //将hash值映射到table的index
        int index = hash(key) & (n - 1);

        //如果节点为null，表示没有冲突, 可直接插入新节点
        if (table[index] == null) {
            table[index] = new Node<>(key, value, null);
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
                    p = p.next; //跳出循环
                }
                p = p.next;
            }
        }

        //如果超过扩容限制
        if (++size > n * loadFactor) {
            resize();
        }


        return null;
    }

    //对key进行一次hash，
    private int hash(K key) {
        if (key == null) return 0;
        int h = key.hashCode();
        h = h ^ h >>> 16;   // 防抖动
        return h;
    }

    //resize, 返回resize 之后的table
    private Node<K, V>[] resize() {
        Node<K, V>[] oldTable = table;
        int oldCapacity = table.length;
        int newCapacity = oldCapacity << 1;
        Node<K, V>[] newTable = (Node<K, V>[]) new Node[newCapacity];
        table = newTable;

        //遍历old table
        for (int i = 0; i < oldCapacity; i++) {
            Node<K, V> e = oldTable[i];
            if (e != null) {
                //清理
                oldTable[i] = null;

                if (e.next == null) {
                    //如果只有一个节点
                    int index = hash(e.key) & (newCapacity - 1);
                    newTable[index] = e;
                } else {
                    //如果是链表的话，需要重新rehash
                    //但因为扩容是两倍，rehash的结果只会是在当前位置，或者增加一倍capcity的位置
                    Node<K, V> loHead = null, loTail = null;
                    Node<K, V> hiHead = null, hiTail = null;
                    while(e != null) {
                        int hash = hash(e.key) & (newCapacity - 1);
                        //仍用老索引
                        if((hash & oldCapacity) == 0) {
                            if( loHead == null) {
                                loHead = e;
                                loTail = e;
                            } else {
                                loTail.next = e;
                                loTail = loTail.next;
                            }
                        } else { //使用新索引
                            if( hiHead == null) {
                                hiHead = e;
                                hiTail = e;
                            } else {
                                hiTail.next = e;
                                hiTail = hiTail.next;
                            }
                        }
                        e = e.next;
                    }
                    if(loTail != null) {
                        loTail.next = null;
                        table[i] = loHead;
                    }
                    if (hiTail != null) {
                        hiTail.next = null;
                        table[i + oldCapacity] = hiHead;
                    }
                }
            }
        }
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

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return table.length;
    }

    //Test SimpleHashMap
    public static void main(String[] args) {

        //Test address conflict and replace
        SimpleHashMap<String, String> map = new SimpleHashMap<>(0.5f);
        map.put("1", "Bob");
        map.put("2", "Mary");
        map.put("3", "Carrie");
        map.put("4", "James");
        map.put("5", "Alice");
        map.put("5", "Perry");

        System.out.println("***** Test put and get **** ");
        System.out.println("Get 1: " + map.get("1"));
        System.out.println("Get 2: " + map.get("2"));
        System.out.println("Get 3: " + map.get("3"));
        System.out.println("Get 4: " + map.get("4"));
        System.out.println("Get 5: " + map.get("5"));

        //Test resize
        System.out.println("*********************** ");
        System.out.println("***** Test resize  **** ");
        map.put("16", "Bob");
        System.out.println("After insert 16, map capacity: " + map.getCapacity() + " size: " + map.getSize());
        map.put("17", "Mary");
        System.out.println("After insert 17, map capacity: " + map.getCapacity() + " size: " + map.getSize());
        map.put("18", "Carrie");
        System.out.println("After insert 18, map capacity: " + map.getCapacity() + " size: " + map.getSize());
        map.put("19", "James");
        System.out.println("After insert 19, map capacity: " + map.getCapacity() + " size: " + map.getSize());
        map.put("20", "Alice");
        System.out.println("After insert 20, map capacity: " + map.getCapacity() + " size: " + map.getSize());
        map.put("21", "Perry");
        System.out.println("After insert 21, map capacity: " + map.getCapacity() + " size: " + map.getSize());
        System.out.println("Get 16: " + map.get("16"));
        System.out.println("Get 17: " + map.get("17"));
        System.out.println("Get 18: " + map.get("18"));
        System.out.println("Get 19: " + map.get("19"));
        System.out.println("Get 20: " + map.get("20"));
        System.out.println("Get 21: " + map.get("21"));
    }
}
