package com.czq.controller;

import java.util.Map;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.czq.controller.result.ResultHelper;
import com.czq.service.impl.SortServiceImpl;

/**
 * 常用的排序
 * 
 * @author czq
 * @Date 2020-05-29 10:11:06
 */
@RestController
@RequestMapping(value = "/sort")
@Validated
public class SortController {

	@Autowired
	public SortServiceImpl sortServiceImpl;

	@RequestMapping(value = "/{type}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, ?>> getSortByType(
			@NotNull(message = "type 不能为空") @PathVariable("type") String type) {
		return ResultHelper.successItemSingle(sortServiceImpl.getSortByType(type));
	}

	@RequestMapping(value = "/speedComparison", method = RequestMethod.GET)
	public ResponseEntity<Map<String, ?>> speedComparison() {
		return ResultHelper.successItemSingle(sortServiceImpl.speedComparison());
	}

}
