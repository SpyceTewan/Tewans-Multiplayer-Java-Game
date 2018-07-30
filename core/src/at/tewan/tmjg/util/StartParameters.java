package at.tewan.tmjg.util;

import java.util.ArrayList;
import java.util.Arrays;

public class StartParameters {
	
	public static ArrayList<String> START_ARGS;
	
	public static void init(String[] args) {
		StartParameters.START_ARGS = new ArrayList<String>(Arrays.asList(args));
	}
}
