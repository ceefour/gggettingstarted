package com.hendyirawan.gggettingstarted.simple;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.gridgain.grid.GridGain;
import org.gridgain.grid.lang.GridRunnable;

public class HelloWorld {

	public static void main(String[] args) throws GridException {
		try (Grid grid = GridGain.start(
				System.getProperty("user.home") + "/gridgain-platform-os-6.1.9-nix/examples/config/example-compute.xml")) {
			grid.forRemotes().compute().run( (GridRunnable) () -> System.out.println("Hello remote!") ).get();
			grid.compute().broadcast( (GridRunnable) () -> System.out.println("Hello everyone!") ).get();
		}
	}

}
