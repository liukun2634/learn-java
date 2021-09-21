# JVM

## Java内存区域

线程私有:
- 程序计数器 Program Counter Register
- 虚拟机栈 VM Stack 
- 本地方法栈 Native Method Stack

线程共有：
- 堆 Heap 
- 元空间 MetaSpace  
- 直接内存 Direct Memory

其中元空间和直接内存是在本地内存 （Native Memory）中。

堆
 - 新生代 Young Generation
 - 老生代 Old Generation
 - 永生代 Permanent Generation (JDK 8之前)
 
 新生代包括 Eden和 Survivor 
 
 永生代在JDK 8之前是用于存储方法区和运行常量池，JDK 7, JDK 8之后永生代被彻底，方法区和常量池也从堆被移到本地内存的元空间中。  

元空间
主要存储方法区，同时方法区中还包括运行常量池。这里不包括字符串常量池，字符串引用和对象均在堆中。

直接内存

### 对象的创建

1. 类加载检查
2. 分配内存
3. 初始化为零值
4. 设置对象头
5. 调用init 方法

参考：

https://github.com/Snailclimb/JavaGuide/blob/master/docs/java/jvm/Java%E5%86%85%E5%AD%98%E5%8C%BA%E5%9F%9F.md 
