package javaguide.concurrency.basic;

//线程安全的Singleton
public class Singleton {

    //volatile 在这里是为了避免 new Singleton() 出现指令重排
    //new Singleton() 包括3步:
    //1. 为 uniqueInstance 分配内存空间
    //2. 初始化 uniqueInstance
    //3. 将 uniqueInstance 指向分配的内存地址
    private volatile Singleton uniqueInstance;

    //令constructor为private
    private Singleton() {}

    //返回 Singleton
    public Singleton getUniqueInstance() {
        //第一次判断，减少生成后获取锁的时间
        if(uniqueInstance == null) {
            //锁的是类，因为保证整个类只有一个实例对象
            synchronized (Singleton.class) {
                //第二次判断
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

}
