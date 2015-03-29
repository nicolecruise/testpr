package com.example.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PracticalTest01MainActivity extends Activity {

	private final static int SECONDARY_REQUEST_CODE = 2015;
	
	protected EditText left, right;
	protected Button leftButton,rightButton;
    
    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    
    protected class ButtonClickListener implements Button.OnClickListener {
    
    @Override
    public void onClick(View view) {
    	
    	switch(view.getId()) {
	    	case R.id.button1:
	    		Intent intent = new Intent(PracticalTest01MainActivity.this, SecondaryActivity.class);
	    		intent.putExtra("noOfClicks", String.valueOf(Integer.parseInt(left.getText().toString()) + Integer.parseInt(right.getText().toString())));
	    		startActivityForResult(intent, SECONDARY_REQUEST_CODE);
	    		break;
	        case R.id.button2:
	          //leftButtonClickedNumber++;
	          left.setText(String.valueOf(Integer.parseInt(left.getText().toString())+1));
	          break;
	          
	        case R.id.button3:
	         //rightButtonClickedNumber++;
	          right.setText(String.valueOf(Integer.parseInt(left.getText().toString())+1));
	          break;
          
          
      }
    }
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	switch(requestCode) {
    	case SECONDARY_REQUEST_CODE:
    		Toast.makeText(this, "Activity returned with result "+resultCode, Toast.LENGTH_LONG).show();
    		break;
    	}
    }
    	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);
        
        left = (EditText)findViewById(R.id.editText1);
        right = (EditText)findViewById(R.id.editText2);
        
        Button navigateButton = (Button)findViewById(R.id.button1);
        navigateButton.setOnClickListener(buttonClickListener);
        
        leftButton = (Button)findViewById(R.id.button2);
        leftButton.setOnClickListener(buttonClickListener);
        
        rightButton = (Button)findViewById(R.id.button3);
        rightButton.setOnClickListener(buttonClickListener);  
        	
        
        //aici fac if-ul ....
        if (savedInstanceState != null) {
        	left.setText(String.valueOf(savedInstanceState.getInt("leftClicks", 0)));
        	right.setText(String.valueOf(savedInstanceState.getInt("rightCliks", 0)));
        }
        
        
        
        }
 
    //salvez starea
    @Override
    protected void onSaveInstanceState(Bundle state){
    	
    	state.putInt("leftCliks", Integer.parseInt(left.getText().toString()));
    	state.putInt("rightCliks", Integer.parseInt(right.getText().toString()));
   
    }
    
    
    
    
        
 

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_main, menu);
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
