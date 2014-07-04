package com.hendyirawan.gggettingstarted.simple;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.gridgain.grid.GridGain;
import org.gridgain.grid.dataload.GridDataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoadData {

	private static final Logger log = LoggerFactory
			.getLogger(LoadData.class);
	
	public static void main(String[] args) throws GridException {
		try (Grid grid = GridGain.start(
				System.getProperty("user.home") + "/gridgain-platform-os-6.1.9-nix/examples/config/example-cache.xml")) {
//			GridCache<Integer, YagoRule> cache = grid.cache("partitioned");
			try (GridDataLoader<Integer, YagoRule> loader = grid.dataLoader("partitioned")) {
				loader.addData(1, new YagoRule("a", "b", "c", "d", "e"));
				loader.addData(2, new YagoRule("a", "b", "c", "d", "e"));
				loader.addData(3, new YagoRule("a", "b", "c", "d", "e"));
				loader.addData(4, new YagoRule("a", "b", "c", "d", "e"));
				log.info("Loaded");
			}
		}
	}

}
