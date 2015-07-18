package com.example.mynotify;
import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends Activity {

	private final String tceBlog = "http://tce.edu/";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mymenu, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId())
		{
			case R.id.item1:
							goToActivity(AboutActivity.class);
							break;
			case R.id.item2:
							goToActivity(SigActivity.class);
							break;
			case R.id.item3:
							Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tceBlog));
							PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
							@SuppressWarnings("deprecation")
							Notification noti = new Notification.Builder(this)
							.setTicker("We are just a click away...!")
							.setContentTitle("Need More Info?")
							.setContentText("Just click here")
							.setSmallIcon(R.drawable.tce_logo)
							.setContentIntent(pIntent).getNotification();
							noti.flags=Notification.FLAG_AUTO_CANCEL;
							NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
							notificationManager.notify(0, noti);
							break;
		}
		return false;		
	}
	
	private void goToActivity(Class<? extends Activity> activityClass)
	{
		Intent newActivity=new Intent(MainActivity.this,activityClass);
		startActivity(newActivity);
	}
	
	public void depart(View ClickedButton)
	{
		goToActivity(DeptActivity.class);
	}

	public void about(View ClickedButton)
	{
		goToActivity(RepActivity.class);
	}
	
	//@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void contact(View ClickedButton)
	{
		Button b=(Button)findViewById(R.id.button2);
		PopupMenu popupMenu = new PopupMenu(this, b);
		popupMenu.getMenuInflater().inflate(R.menu.main,popupMenu.getMenu());
		final String phn="College office number is: +91 452 2482240";
		final String email="Principal Email-ID is:principal@tce.edu";
		popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
	     public boolean onMenuItemClick(MenuItem item) {
	     if(item.getTitle().equals("phone no"))
	    	 Toast.makeText(MainActivity.this,phn,Toast.LENGTH_LONG).show();
	     else
	    	 Toast.makeText(MainActivity.this,email,Toast.LENGTH_LONG).show(); 
	      return true;
	     }
	    });
		popupMenu.show();
	}

}
