package com.hendyirawan.gggettingstarted.simple;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.gridgain.grid.GridGain;
import org.gridgain.grid.compute.GridComputeJob;
import org.gridgain.grid.compute.GridComputeJobResult;
import org.gridgain.grid.compute.GridComputeTaskSplitAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.FluentIterable;

public class JavaMapReduce {

	private static final Logger log = LoggerFactory
			.getLogger(JavaMapReduce.class);
	
	public static void main(String[] args) throws GridException {
		try (Grid grid = GridGain.start(
				System.getProperty("user.home") + "/gridgain-platform-os-6.1.9-nix/examples/config/example-cache.xml")) {
			final String msg = "Java GridGain MapReduce Something Okay Java GridGain MapReduce Something Okay Java GridGain MapReduce Something Okay Java GridGain MapReduce Something Okay Java GridGain MapReduce Something Okay Java GridGain MapReduce Something Okay Java GridGain MapReduce Something Okay Java GridGain MapReduce Something Okay Java GridGain MapReduce Something Okay Java GridGain MapReduce Something Okay Java GridGain MapReduce Something Okay Java GridGain MapReduce Something Okay Java GridGain MapReduce Something Okay Java GridGain MapReduce Something Okay Java GridGain MapReduce Something Okay Java GridGain MapReduce Something Okay Java GridGain MapReduce Something Okay Java GridGain MapReduce Something Okay Java GridGain MapReduce Something Okay Java GridGain MapReduce Something Okay Java GridGain MapReduce Something Okay Java GridGain MapReduce Something Okay Java GridGain MapReduce Something Okay Java GridGain MapReduce Something Okay Java GridGain MapReduce Something Okay Java GridGain MapReduce Something Okay ";
			int tot = grid.compute().execute(new GridComputeTaskSplitAdapter<String, Integer>() {
				@Override
				protected Collection<? extends GridComputeJob> split(
						int gridSize, String arg) throws GridException {
					String[] words = arg.split(" ");
					return FluentIterable.from(Arrays.asList(words))
						.<GridComputeJob>transform((it) -> new GridComputeJob() {
							@Override
							public Object execute() throws GridException {
								log.info("Length of '{}' is {}", it, it.length());
								return it.length();
							}
							
							@Override
							public void cancel() {
							}
						}).toList();
				}
				
				@Override
				public Integer reduce(List<GridComputeJobResult> results)
						throws GridException {
					int total = 0;
					for (GridComputeJobResult res : results) {
						total += (int) res.getData();
					}
					return total;
				}
			}, msg).get();
			log.info("Tot: {}", tot);
		}
	}

}
