package com.java.utilitity;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author rudrasagar.tn
 */
public class ListPartition {

	/**
	 * Returns collection of splitted list with each list in collection has size
	 * as BATCH_SIZE & last list size could be less than BATCH_SIZE if input
	 * list is uneven wrt BATCH_SIZE.
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

}
