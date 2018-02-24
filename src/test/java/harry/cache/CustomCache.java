package harry.cache;

import java.util.HashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author harry
 *
 */
public class CustomCache implements Cache {
	private static Logger logger = LoggerFactory.getLogger(CustomCache.class);
	private HashMap<Object, Object> caheManager = new HashMap<Object, Object>();
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	private String regin = "";

	public CustomCache(String namespace) {
		logger.info("创建命名空间 cache 分区" + namespace);
		this.regin = namespace;
	}

	@Override
	public String getId() {
		return regin;
	}

	@Override
	public void putObject(Object key, Object value) {
		logger.info("存储  key:" + key + ",值：" + value);
		caheManager.put(key, value);
	}

	@Override
	public Object getObject(Object key) {
		logger.info("获取 key:" + key);

		return caheManager.get(key);
	}

	@Override
	public Object removeObject(Object key) {
		logger.info("删除 key:" + key);

		return caheManager.remove(key);
	}

	@Override
	public void clear() {
		logger.info("清除所有");
		caheManager.clear();
	}

	@Override
	public int getSize() {
		return caheManager.size();
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		return lock;
	}

}
