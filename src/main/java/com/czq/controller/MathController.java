package com.czq.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import com.czq.controller.result.ResultHelper;

/**
 * @author czq
 * @Date 2020-06-12 11:42:10
 */

@Api(description = "管理员操作")
@Controller
@RequestMapping("/math")
public class MathController {

	@ApiOperation("指数函数")
	@RequestMapping(method = RequestMethod.GET, value = "/xn")
	public ResponseEntity<Map<String, ?>> pow(@RequestParam("n") Double n, @RequestParam("limit") int limit)
			throws Exception {

		List<Object> result = new ArrayList<Object>();

		for (int i = 1; i <= limit; i++) {
			List<Object> list = new ArrayList<Object>();

			list.add(i);
			list.add(Math.pow(i, n));
			result.add(list);
		}
		return ResultHelper.successItemList(result);
	}

	@ApiOperation("对数函数")
	@RequestMapping(method = RequestMethod.GET, value = "/log")
	public ResponseEntity<Map<String, ?>> ln(
			@ApiParam(name = "n", value = "对数的的底,底数要求大于0且不等于1", required = true) @RequestParam("n") Double n,
			@RequestParam("limit") int limit) throws Exception {

		List<Object> result = new ArrayList<Object>();

		if (n == 10) {
			for (int i = 1; i <= limit; i++) {
				List<Object> list = new ArrayList<Object>();

				list.add(i);
				list.add(Math.log10(i));
				result.add(list);
			}
		} else {
			Double bottom = Math.log(n);
			for (int i = 1; i <= limit; i++) {
				List<Object> list = new ArrayList<Object>();

				list.add(i);
				list.add(Math.log(i) / bottom);
				result.add(list);
			}
		}

		return ResultHelper.successItemList(result);
	}

	@ApiOperation("自然对数函数")
	@RequestMapping(method = RequestMethod.GET, value = "/ln")
	public ResponseEntity<Map<String, ?>> ln(@RequestParam("limit") int limit) throws Exception {

		List<Object> result = new ArrayList<Object>();

		for (int i = 1; i <= limit; i++) {
			List<Object> list = new ArrayList<Object>();

			list.add(i);
			list.add(Math.log(i));
			result.add(list);
		}
		return ResultHelper.successItemList(result);
	}

	public static void main(String[] args) {
		int n = 6800;
		System.out.println("n2复杂度: " + Math.pow(n, 2));
		System.out.println("n2时间: " + Math.pow(n, 2) * 1000 / Math.pow(10, 9));
		System.out.println("n2复杂度: " + n);
		System.out.println("n2时间: " + n * 1000 / Math.pow(10, 9));
	}

}
