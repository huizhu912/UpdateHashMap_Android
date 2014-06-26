package com.example.updatehashmap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	int id;
	Map<Integer, Integer> map; // hashmap of button IDs and indices
	Map<Integer, String> testMap;
	Backend be;
	
	TextView tv;
	Button button0;
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button button5;
	Button button6;
	Button button7;
	Button button8;
	Button button9;
	
	int[] btIdList = {R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button0 = (Button)findViewById(R.id.button1);
		button1 = (Button)findViewById(R.id.button2);
		button2 = (Button)findViewById(R.id.button3);
		button3 = (Button)findViewById(R.id.button4);
		button4 = (Button)findViewById(R.id.button5);
		button5 = (Button)findViewById(R.id.button6);
		button6 = (Button)findViewById(R.id.button7);
		button7 = (Button)findViewById(R.id.button8);
		button8 = (Button)findViewById(R.id.button9);
		
		
		testMap = new HashMap<Integer, String>();
		testMap.put(R.id.button1, button0.getText().toString());
		testMap.put(R.id.button2, button1.getText().toString());
		testMap.put(R.id.button3, button2.getText().toString());
		testMap.put(R.id.button4, button3.getText().toString());
		testMap.put(R.id.button5, button4.getText().toString());
		testMap.put(R.id.button6, button5.getText().toString());
		testMap.put(R.id.button7, button6.getText().toString());
		testMap.put(R.id.button8, button7.getText().toString());
		testMap.put(R.id.button9, button8.getText().toString());
		
		setListener(button0);
		setListener(button1);
		setListener(button2);
		setListener(button3);
		setListener(button4);
		setListener(button5);
		setListener(button6);
		setListener(button7);
		setListener(button8);
		
		tv = (TextView)findViewById(R.id.textView1);
		be = new Backend();
		
	}
	
	protected void printMessage(String msg){
		tv = (TextView)findViewById(R.id.textView1);
		tv.setText(msg);
	}
	
	protected String getTestMapString(Map<Integer, String> testmap){
		String s = "";
		for(int key: testmap.keySet()){
			s = s + key + " => " + testmap.get(key) + "; ";
		}

		return s;
	}
	
	protected void setListener(Button bt){
		
		bt.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				id = v.getId(); 
				if ((((Button)v).getText().toString()).equals("-")){
					((Button)v).setText("X");
					testMap.put(id, "X");
					tv.setText(getTestMapString(testMap));
				}
				
				// App crashed here
				be.updateTestMap(btIdList, testMap);
	
			}
		});
  }
}