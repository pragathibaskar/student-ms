package com.cg.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Result {
	
 private Long id;
 private Long percent;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Long getPercent() {
	return percent;
}
public void setPercent(Long percent) {
	this.percent = percent;
}
@Override
public String toString() {
	return "Result [id=" + id + ", percent=" + percent + "]";
}

 
}
