package com.czq.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author   czq
 * @Date 2020-05-29 11:43:52    
 */

public class ValidInfo {
    @NotNull(message = "username cannot be null")
    private String name;

    @NotNull(message = "sex cannot be null")
    private String sex;

    @Max(value = 99L)  
    private Integer age;
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "validInfo [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
    
    
}
