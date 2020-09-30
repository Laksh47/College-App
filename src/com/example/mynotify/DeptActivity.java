package com.example.mynotify;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
//import android.widget.TextView;
import android.widget.Toast;

public class DeptActivity extends Activity implements DialogInterface.OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dept);
		//alert();
		ListView lview=(ListView)findViewById(R.id.listView1);
		registerForContextMenu(lview);
	}
	
	
	public void alert(View clickedbutton)
	{
		AlertDialog ad = new AlertDialog.Builder(this)
					.setMessage("Wanna see our\nplacement results now?")
					.setIcon(R.drawable.ic_launcher)
					.setTitle("See also")
					.setPositiveButton("Yes", this)
					.setNegativeButton("No", this)
					.setNeutralButton("Cancel", this)
					.setCancelable(false)
					.create();
		ad.show();

	}
	
	@Override
		  public void onCreateContextMenu(ContextMenu menu, View v,
		          ContextMenuInfo menuInfo) {
		      super.onCreateContextMenu(menu, v, menuInfo);
		      AdapterContextMenuInfo aInfo = (AdapterContextMenuInfo) menuInfo;
		      String[] menuItems = getResources().getStringArray(R.array.deps);
		      String[] cmenu = getResources().getStringArray(R.array.cmenu);		      
		      menu.setHeaderTitle(menuItems[aInfo.position]);
		      for (int i = 0; i<cmenu.length; i++) {
		    	  menu.add(Menu.NONE, i, i, cmenu[i]);
		      }
		     // getMenuInflater.inflate(R.array.cmenu,menu);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
		String[] year = getResources().getStringArray(R.array.year);
		String[] domain=getResources().getStringArray(R.array.domain);
		String[] menuItems = getResources().getStringArray(R.array.deps);
		String[] cmenu = getResources().getStringArray(R.array.cmenu);
		int menuItemIndex = item.getItemId();
		String dept=menuItems[info.position];
		String area=domain[info.position];
		String dyear=year[info.position];
		String cmenuitem=cmenu[menuItemIndex];
		if(cmenuitem.equals("About the field"))
			Toast.makeText(DeptActivity.this,dept+" concentrates on "+area,Toast.LENGTH_LONG).show();
		else
			Toast.makeText(DeptActivity.this,dept+" founded on "+dyear,Toast.LENGTH_LONG).show();
		return true;
  }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dept, menu);
		return true;
	}
	@Override
	public void onClick(DialogInterface arg0, int which) {
		// TODO Auto-generated method stub
		switch(which){
					case DialogInterface.BUTTON_POSITIVE: // yes
						goToActivity(PlacedActivity.class);
						break;
					case DialogInterface.BUTTON_NEGATIVE: // no
						Toast.makeText(DeptActivity.this,"you can visit our site later to see that",Toast.LENGTH_LONG).show();
						break;		
					default:
						Toast.makeText(DeptActivity.this,"you can visit our site later to see that",Toast.LENGTH_LONG).show();
						break;
		}
	}
	
	private void goToActivity(Class<? extends Activity> activityClass)
	{
		Intent newActivity=new Intent(DeptActivity.this,activityClass);
		startActivity(newActivity);
	}
}

/*lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                        long id) {

    // We know the View is a TextView so we can cast it
    TextView clickedView = (TextView) view;

    Toast.makeText(DeptActivity.this, "Item with id ["+id+"] - Position ["+position+"] - Dept ["+clickedView.getText()+"]", Toast.LENGTH_SHORT).show();

}

});*/