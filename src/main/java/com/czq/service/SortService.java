package com.czq.service;
/**
 * @author   czq
 * @Date 2020-06-17 09:59:23    
 */

import java.util.List;
import java.util.Map;

public interface SortService {

	 public Map<String, Object> getSortByType(String type); 
	 
	 public List<Map<String, Object>> speedComparison();
}
