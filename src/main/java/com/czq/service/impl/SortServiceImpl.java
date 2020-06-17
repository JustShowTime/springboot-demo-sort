package com.czq.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.czq.service.SortService;
import com.czq.util.SortUtil;

/**
 * @author czq
 * @Date 2020-06-17 10:05:09
 */
@Service
public class SortServiceImpl implements SortService {

	@Override
	public Map<String, Object> getSortByType(String type) {

		return getSortByType(type, getArr());
	}

	@Override
	public List<Map<String, Object>> speedComparison() {

		return speedComparison(getArr());
	}

	private  Map<String, Object> getSortByType(String type, int[] arr) {
		Map<String, Object> map = new HashMap<String, Object>();
		ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(arr).boxed().collect(Collectors.toList());
		long start = System.currentTimeMillis();
		int[] result = null;
		List<Integer> resultList = new ArrayList<Integer>();
		if (type.equals("bubble")) {
			result = SortUtil.BubbleSort(arr);
		} else if (type.equals("count")) {
			result = SortUtil.CountingSort(arr);
		} else if (type.equals("quick")) {
			result = SortUtil.QuickSort(arr, 1, arr.length/2);
		} else if (type.equals("heap")) {
			result = SortUtil.HeapSort(arr);
		} else if (type.equals("insert")) {
			result = SortUtil.InsertionSort(arr);
		} else if (type.equals("merge")) {
			result = SortUtil.MergeSort(arr);
		} else if (type.equals("shell")) {
			SortUtil.ShellSort(arr);
		} else if (type.equals("bucket")) {
			resultList = SortUtil.BucketSort(list, list.size() / 5);
			long end = System.currentTimeMillis();
			map.put(type + "耗时： " + (end - start), resultList);
			return map;
		} else {
			map.put(type + "只能为bubble,quick,count,heap,insert,merge,bucket,shell ", 0);
			return map;
		}
		long end = System.currentTimeMillis();
		map.put(type + "耗时： " + (end - start), result);
		return map;
	}
	
	
	private  Map<String, Object> getSortByTypeOnlyTime(String type, int[] arr) {
		Map<String, Object> map = new HashMap<String, Object>();
		ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(arr).boxed().collect(Collectors.toList());
		long start = System.currentTimeMillis();
		if (type.equals("bubble")) {
			SortUtil.BubbleSort(arr);
		} else if (type.equals("count")) {
			SortUtil.CountingSort(arr);
		} else if (type.equals("quick")) {
			SortUtil.QuickSort(arr, 1, arr.length/2);
		} else if (type.equals("heap")) {
			SortUtil.HeapSort(arr);
		} else if (type.equals("insert")) {
			SortUtil.InsertionSort(arr);
		} else if (type.equals("merge")) {
			SortUtil.MergeSort(arr);
		} else if (type.equals("shell")) {
			SortUtil.ShellSort(arr);
		} else if (type.equals("bucket")) {
			SortUtil.BucketSort(list,  2);
		} else {
			map.put(type + "只能为bubble,quick,count,heap,insert,merge,bucket,shell ", 0);
			return map;
		}
		long end = System.currentTimeMillis();
		map.put(type + "耗时： ", (end - start));
		return map;
	}

	private List<Map<String, Object>> speedComparison(int[] arr) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//		list.add(getSortByTypeOnlyTime("bubble", arr));
		list.add(getSortByTypeOnlyTime("count", arr));
		list.add(getSortByTypeOnlyTime("quick", arr));
		list.add(getSortByTypeOnlyTime("heap", arr));
		list.add(getSortByTypeOnlyTime("insert", arr));
		list.add(getSortByTypeOnlyTime("merge", arr));
		list.add(getSortByTypeOnlyTime("bucket", arr));
		list.add(getSortByTypeOnlyTime("shell", arr));
		return list;
	}

	private int[] getArr() {
		int[] arr = new int[100000];
		for (int i = 0; i < 100000; i++) {
			arr[i] = (int) (Math.random() * 100000);
		}
		return arr;
	}

}
