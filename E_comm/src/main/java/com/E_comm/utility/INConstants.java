package com.E_comm.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class INConstants {
	public final static String IN = "IN";
	public final static Map<String, String> mapOfINStates = new HashMap<String, String>() {
		{
			put("Andaman & Nicobar", "AN");
			put("Andhra Pradesh", "AP");
			put("Arunachal Pradesh", "AR");
			put("Assam", "AS");
			put("Bihar", "BR");
			put("Chhattisgarh", "CG");
			put("Dadra and Nagar Haveli and Daman and Diu", "DD");
			put("Delhi", "DL");
			put("Goa", "GA");
			put("Chandigarh", "GH");
			put("Gujrat", "GJ");
			put("Haryana", "HR");
			put("Himachal Pradesh", "HP");
			put("Jharkhand", "JH");
			put("Jammu & Kashmir", "JK");
			put("Karnataka", "KA");
			put("Kerela", "KL");
			put("Ladakh", "LA");
			put("Lakshadweep", "LD");
			put("Madhya Pradesh", "MP");
			put("Maharashtra", "MH");
			put("Manipur", "MN");
			put("Meghalaya", "ML");
			put("Mizoram", "MZ");
			put("Nagaland", "NL");
			put("Odisha", "OD");
			put("Punjab", "PB");
			put("Puducherry", "PY");
			put("Rajasthan", "RJ");
			put("Sikkim", "SK");
			put("TamilNadu", "TN");
			put("Telangana", "TS");
			put("Tripura", "TR");
			put("Uttar Pradesh", "UP");
			put("Uttarakhand", "UK");
			put("West Bengal", "WB");
		}
	};

	public static final List<String> listOfINStatesCode = new ArrayList<>(mapOfINStates.keySet());
	public static final List<String> listOfINStatesNames = new ArrayList<>(mapOfINStates.values());
}