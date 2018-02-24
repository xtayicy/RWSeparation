package harry.datasource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import harry.datasource.DataSourceType.ReadWriteEnum;

/**
 * 
 * @author harry
 *
 */
public class ReadWriteDataSource extends AbstractRoutingDataSource {
	private static Logger logger = LoggerFactory.getLogger(ReadWriteDataSource.class);
	private static List<String> readDataSources = new ArrayList<String>();
	static {
		readDataSources.add("slaveDataSource1");
		readDataSources.add("slaveDataSource2");
	}

	@Override
	protected Object determineCurrentLookupKey() {
		ReadWriteEnum operation = DataSourceType.getOperation();
		logger.info(operation == ReadWriteEnum.READ ? "读操作" : "写操作");

		if (operation == ReadWriteEnum.READ) {
			Random random = new Random();
			int index = random.nextInt(readDataSources.size());
			String datasource = readDataSources.get(index);
			logger.info("应用 读：" + datasource);
			
			return datasource;
		} else {
			return "NONE";
		}
	}
}
