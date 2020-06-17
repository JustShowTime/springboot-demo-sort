package com.czq.controller.result;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author czq
 * @Date 2020-05-29 11:08:18
 */
public class ResultHelper {

	private static final String MSG = "msg";

	private static final String ITEM_SINGLE = "itemSingle";

	private static final String ITEM_LIST = "itemList";

	private static final String ITEM_COUNT = "itemCount";

	public static ResponseEntity<Map<String, ?>> success() {
		return new ResponseEntity<Map<String, ?>>(HttpStatus.OK);
	}

	public static ResponseEntity<Map<String, ?>> successMap(Map<String, ?> map) {
		return new ResponseEntity<Map<String, ?>>(map, HttpStatus.OK);
	}

	public static ResponseEntity<Map<String, ?>> successMsg(String msg) {
		Map<String, ?> map = Collections.singletonMap(MSG, msg);
		return successMap(map);
	}

	public static ResponseEntity<Map<String, ?>> successItemSingle(Object itemSingle) {
		Map<String, ?> map = Collections.singletonMap(ITEM_SINGLE, itemSingle);
		return successMap(map);
	}

	public static ResponseEntity<Map<String, ?>> successItemList(List<?> itemList) {
		Map<String, ?> map = Collections.singletonMap(ITEM_LIST, itemList);
		return successMap(map);
	}

	public static ResponseEntity<Map<String, ?>> successItemList(List<?> itemList, int count) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(ITEM_LIST, itemList);
		map.put(ITEM_COUNT, count);
		return successMap(map);
	}

	public static ResponseEntity<Map<String, ?>> errorMsg(HttpStatus httpStatus, String msg) {
		Map<String, ?> map = Collections.singletonMap(MSG, msg);
		return new ResponseEntity<Map<String, ?>>(map, httpStatus);
	}

}
