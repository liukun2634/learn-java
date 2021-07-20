package concurrencyinpractice.chapterthirteen;

public interface ReadWriteLock {
    Lock readLock();
    Lock writeLock();
}
