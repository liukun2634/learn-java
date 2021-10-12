package javaguide.LRU;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    class Node{
        int k, v;
        Node l, r;
        Node(int k_, int v_){
            k = k_;
            v = v_;
        }
    }

    int n;
    Node head, tail;
    Map<Integer, Node> map;
    //初始化
    LRU(int capcity){
        n = capcity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.r = tail;
        tail.l = head;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            //如果存在，就更新后返回
            refresh(node);
            return node.v;
        }
        return -1;
    }

    public void put(int key, int value){
        //1. 存在，就更新
        if(map.containsKey(key)){
            Node node = map.get(key);
            refresh(node);
            node.v = value;
            return;
        }

        //2. 不存在，就插入
        //如果超过capacity 就清除最末尾元素
        if(map.size() == n) {
            Node del = tail.l;
            map.remove(del.k);
            delete(del);
        }
        Node node = new Node(key, value);
        map.put(key, node);
        refresh(node);
    }

    //双向链表操作： 先删除节点，再放到头部
    void refresh(Node node){
        delete(node);
        node.r = head.r;
        node.l = head;
        head.r.l = node;
        head.r = node;
    }

    //双向链表操作：删除
    void delete(Node node){
        if(node.l != null) {
            Node left = node.l;
            left.r = node.r;
            node.r.l = left;
        }

    }

}
