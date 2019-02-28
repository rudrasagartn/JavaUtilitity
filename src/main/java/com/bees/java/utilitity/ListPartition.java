package com.bees.java.utilitity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author rudrasagar.tn
 */
public class ListPartition {

	/**
	 * Java 8 approach with Stream & Lambda expression, Returns collection of
	 * splitted list with each list in collection has size as BATCH_SIZE & last
	 * list size could be less than BATCH_SIZE if input list is uneven wrt
	 * BATCH_SIZE.
	 * 
	 * @param inputList
	 * @param BATCH_SIZE
	 * @return
	 */
	public static Collection<?> split(List<?> inputList, int BATCH_SIZE) {
		final AtomicInteger counter = new AtomicInteger(0);

		final Collection<?> partitioned = inputList.stream()
				.collect(Collectors.groupingBy(it -> counter.getAndIncrement() / BATCH_SIZE)).values();
		return partitioned;
	}

	/**
	 * Traditional approach with for loop & sub list, Returns collection of
	 * splitted list with each list in collection has size as BATCH_SIZE & last
	 * list size could be less than BATCH_SIZE if input list is uneven wrt
	 * BATCH_SIZE.
	 * 
	 * @param inputList
	 * @param BATCH_SIZE
	 * @return
	 */
	public static List<?> split(List<?> inputList, Integer BATCH_SIZE) {
		List<List<?>> partitions = new ArrayList<>();
		for (int i = 0; i < inputList.size(); i += BATCH_SIZE) {
			partitions.add(inputList.subList(i, Math.min(i + BATCH_SIZE, inputList.size())));
		}
		return partitions;
	}
}
