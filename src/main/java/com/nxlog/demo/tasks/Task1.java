package com.nxlog.demo.tasks;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Task1 {

    
	// product version in the format "<major_version>.<minor_version>.<build_number>"
	public static boolean isCurrentVersionHigherOrEqual(String agentVersion, String currentAgentVersion) {
        boolean result = false;
		Pattern pattern = Pattern.compile("\\d+.\\d+.\\d+");
        if (pattern.matcher(agentVersion).matches() &&  pattern.matcher(currentAgentVersion).matches()) {
			int[] _agentVersion = Arrays.stream(agentVersion.split("\\.")).mapToInt(Integer::parseInt).toArray();
			int[] _currentAgentVersion = Arrays.stream(currentAgentVersion.split("\\.")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < _agentVersion.length; i++) {
                if (_currentAgentVersion[i] > _agentVersion[i]) {
                    return true;
                }
            }

			result = IntStream.range(0, _agentVersion.length)
			.mapToObj(i -> _agentVersion[i] == _currentAgentVersion[i])
			.allMatch(x -> x == true);
        }

        return result;
    }
    
}
