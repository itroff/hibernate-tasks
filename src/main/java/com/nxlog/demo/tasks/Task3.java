package com.nxlog.demo.tasks;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.nxlog.demo.models.task3.AgentInfoBean;

public class Task3 {
    public static List<AgentInfoBean> processList(String states) {
		final List<AgentInfoBean> agentInfos = Arrays.asList(new AgentInfoBean("12")); // fetchItems();
		List<AgentInfoBean> filteredResults = agentInfos.stream()
				.filter(x -> states.contains(x.getStatus()))
				.collect(Collectors.toCollection(LinkedList::new));
		return filteredResults;
	}
}
