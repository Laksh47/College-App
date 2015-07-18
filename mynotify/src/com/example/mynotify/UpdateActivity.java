package com.example.mynotify;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends Activity {

	dbcontrol d=new dbcontrol(this);
	EditText e1,e2,e3,e4,e5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update);
		e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		e3=(EditText)findViewById(R.id.editText3);
		e4=(EditText)findViewById(R.id.editText4);
		e5=(EditText)findViewById(R.id.editText5);
		clear();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.update, menu);
		return true;
	}
	
	public void update(View v)
	{
		String name,position,dept,phnum;
		int id;
		if(e1.getText().toString().length()!=0 && e2.getText().length()!=0 && e3.getText().length()!=0 && e4.getText().length()!=0 &&e5.getText().length()!=0)
		{
			id=Integer.parseInt(e1.getText().toString());
			name=e2.getText().toString();
			dept=e3.getText().toString();
			position=e4.getText().toString();
			phnum=e5.getText().toString();
			rep r=new rep(id,name,position,dept,phnum);
			int i=d.update(r);
			if(i!=0 && i!=-1)
				Toast.makeText(UpdateActivity.this,"Success",Toast.LENGTH_LONG).show();
			else
				Toast.makeText(UpdateActivity.this,"Updation failed",Toast.LENGTH_LONG).show();
			clear();
		}
		else
			Toast.makeText(UpdateActivity.this,"Enter field values first!",Toast.LENGTH_LONG).show();
	}

	void clear(){
		e1.setText("");
		e2.setText("");
		e3.setText("");
		e4.setText("");
		e5.setText("");
	}
}
