package com.example.updatehashmap;

import java.util.Map;

import android.widget.Button;

public class Backend extends MainActivity{
	
	protected void updateTestMap(Map<Integer, String> testmap){
		Button bt;
		
		for (int key : testmap.keySet()){
			bt = (Button)findViewById(key);
			testmap.put(key, bt.getText().toString());
		}
	}
}
