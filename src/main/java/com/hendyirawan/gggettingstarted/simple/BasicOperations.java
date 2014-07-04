package com.hendyirawan.gggettingstarted.simple;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.gridgain.grid.GridGain;
import org.gridgain.grid.cache.GridCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicOperations {

	private static final Logger log = LoggerFactory
			.getLogger(BasicOperations.class);
	
	public static void main(String[] args) throws GridException {
		try (Grid grid = GridGain.start(
				System.getProperty("user.home") + "/gridgain-platform-os-6.1.9-nix/examples/config/example-cache.xml")) {
			GridCache<Integer, String> cache = grid.cache("partitioned");
			String oldVal = cache.put(1, "1");
			boolean success = cache.putx(2, "2");
			boolean success2 = cache.putxIfAbsent(3, "3");
			log.info("Current 3 value = {}", cache.get(3));
			cache.transform(3, (it) -> it + "-transformed");
			log.info("Transformed 3 value = {}", cache.get(3));
		}
	}

}
