package com.inmobi.sdk.test.helper;

import java.util.HashMap;
import java.util.Map;

public class TestCaseListData {
	
	private Integer testcaseCount;
	


	private Integer testcaseIndex;

	
	private Map<Integer, TestCaseData> testcaseMap;
	
	public TestCaseListData() {
		testcaseIndex=0;
		testcaseCount=0;
		testcaseMap = new HashMap<Integer, TestCaseData>();
	}
	
	public Integer getTestcaseCount() {
		return testcaseCount;
	}


	public void setTestcaseCount(Integer testcaseCount) {
		this.testcaseCount = testcaseCount;
	}


	public Integer getTestcaseIndex() {
		return testcaseIndex;
	}


	public void setTestcaseIndex(Integer testcaseIndex) {
		this.testcaseIndex = testcaseIndex;
	}
	
	
	
	public void addIntoTestcaseListDataMap( TestCaseData testCaseData) {
		
		testcaseMap.put(testcaseIndex, testCaseData);
		testcaseCount++;
		testcaseIndex++;
	}
	
	
	
	public TestCaseData getTestcaseDataFromMap( ) {
		return testcaseMap.get(testcaseIndex++);
	}
	
	public void resetIndex() {
		testcaseIndex = 0;
	}
	
	public TestCaseData getTestcaseDataFromMap(Integer index) {
		return testcaseMap.get(index);
	}

	
}
