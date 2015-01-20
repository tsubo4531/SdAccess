package com.sdaccess;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button buttonSave = (Button)findViewById(R.id.button1);
		buttonSave.setOnClickListener(new OnClickListener(){
		    @Override
		    public void onClick(View arg0) {
		        try {
			        String filePath = Environment.getExternalStorageDirectory().toString() + "/memo/";
			        File dir = new File(filePath);
			        if(!dir.exists()){
			        	dir.mkdir();
			        }
			        File file = new File(filePath + "memo.txt");
			        if(!file.exists()){
			            file.createNewFile();
			        }
			        FileOutputStream fos;
		            fos = new FileOutputStream(file, true);
		            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		            BufferedWriter bw = new BufferedWriter(osw);
		            String str = ((EditText) findViewById(R.id.editText1)).getText().toString();
		            bw.write(str);
		            bw.flush();
		            bw.close();
		        } catch (Exception e) {
		        }
		    };
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
