package concurrency.chapterthirteen;

public interface ReadWriteLock {
    Lock readLock();
    Lock writeLock();
}
