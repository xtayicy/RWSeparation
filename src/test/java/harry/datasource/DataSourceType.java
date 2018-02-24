package harry.datasource;

/**
 * 
 * @author harry
 *
 */
public class DataSourceType {
	private static final ThreadLocal<ReadWriteEnum> THREAD_LOCAL = new ThreadLocal<ReadWriteEnum>();
	
	static{
		THREAD_LOCAL.set(ReadWriteEnum.WRITE);
	}
	
	public static void setReadOperation(){
		THREAD_LOCAL.set(ReadWriteEnum.READ);
	}
	
	public static void setWriteOperation(){
		THREAD_LOCAL.set(ReadWriteEnum.WRITE);
	}
	
	public static ReadWriteEnum getOperation(){
		return THREAD_LOCAL.get();
	}
	
	static enum ReadWriteEnum{
		READ,WRITE
	}
}
