package com.example.mynotify;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class RepActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rep);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rep, menu);
		return true;
	}
	
	private void goToActivity(Class<? extends Activity> activityClass)
	{
		Intent newActivity=new Intent(RepActivity.this,activityClass);
		startActivity(newActivity);
	}
	
	public void insert(View ClickedButton)
	{
		goToActivity(InsertActivity.class);
	}
	
	public void delete(View ClickedButton)
	{
		goToActivity(DeleteActivity.class);
	}
	
	public void update(View ClickedButton)
	{
		goToActivity(UpdateActivity.class);
	}
	
	public void display(View ClickedButton)
	{
		goToActivity(DisplayActivity.class);
	}


}
