package harry.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock {
	public static void main(String[] args) throws InterruptedException {
		ReadWriteLock lock=new ReentrantReadWriteLock();
		final Lock rLock = lock.readLock();
		final Lock wLock = lock.writeLock();
		
		new Thread(){
			public void run() {
				rLock.lock();
				try {
					System.out.println("Thread A 获取读锁");
					Thread.sleep(8000);
					System.out.println("Thread A 释放读锁");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rLock.unlock();
			};
		}.start();
		
		new Thread(){
			public void run() {
				rLock.lock();
				try {
					System.out.println("Thread C 获取读锁");
					Thread.sleep(8000);
					System.out.println("Thread C 释放读锁");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rLock.unlock();
			};
		}.start();
		Thread.sleep(100);
		
		new Thread(){
			public void run() {
				wLock.lock();
				try {
					System.out.println("Thread B 获取写锁");
					Thread.sleep(5000);
					System.out.println("Thread B 释放写锁");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				wLock.unlock();
			};
		}.start();
		
	}
}
