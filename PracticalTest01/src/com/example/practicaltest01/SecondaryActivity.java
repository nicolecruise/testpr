package com.example.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondaryActivity extends Activity {
	
	protected ButtonClickListener bcl = new ButtonClickListener();
	
	protected class ButtonClickListener implements View.OnClickListener {
		@Override
		public void onClick(View view) {
			switch(view.getId()) {
				case R.id.buttonOk:
					setResult(RESULT_OK, new Intent());
					break;
				case R.id.buttonCanceled:
					setResult(RESULT_CANCELED, new Intent());
					break;
			}
			finish();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_secondary);
		
		TextView noOfClicksTv = (TextView)findViewById(R.id.textView1);
		Intent intent = getIntent();
		String noOfClicks = intent.getStringExtra("noOfClicks");
		noOfClicksTv.setText(noOfClicks);
		
		Button buttonOk = (Button)findViewById(R.id.buttonOk);
		buttonOk.setOnClickListener(bcl);
		Button buttonCancel = (Button)findViewById(R.id.buttonCanceled);
		buttonCancel.setOnClickListener(bcl);
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
