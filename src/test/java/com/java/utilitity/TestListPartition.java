package com.java.utilitity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author rudrasagar.tn
 *
 */
@SuppressWarnings("unchecked")
public class TestListPartition {

	private List<String> stringList;
	private List<Integer> integerList;

	@Before
	public void init() {
		stringList = new ArrayList<>();
		integerList = new ArrayList<>();
		for (int i = 1; i <= 17; i++) {
			stringList.add(i + "");
			integerList.add(i);
		}
	}

	@Test
	public void testStringListSizeEquals() {
		Collection<List<String>> lst2 = (Collection<List<String>>) ListPartition.split(stringList, 5);
		assertEquals(lst2.size(), 4);

	}

	@Test
	public void testIntegerListSizeEquals() {

		Collection<List<Integer>> lst2 = (Collection<List<Integer>>) ListPartition.split(integerList, 5);
		assertEquals(lst2.size(), 4);

	}

	@Test
	public void testListSizeNotEquals() {
		List<Integer> lst = null;
		Collection<List<Integer>> lst2 = (Collection<List<Integer>>) ListPartition.split(integerList, 5);
		for (List<Integer> list : lst2) {
			lst = list;
		}
		assertNotEquals(lst.size(), 5);

	}

}
