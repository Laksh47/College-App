package com.example.mynotify;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends Activity {
	dbcontrol d=new dbcontrol(this);
	EditText e1;
	TextView t2,t3,t4,t5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display);
		e1=(EditText)findViewById(R.id.editText1);
		t2=(TextView)findViewById(R.id.textView2);
		t3=(TextView)findViewById(R.id.textView3);
		t4=(TextView)findViewById(R.id.textView4);
		t5=(TextView)findViewById(R.id.textView5);		
		e1.setText("");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display, menu);
		return true;
	}

	public void display(View clicked)
	{
		int id;
		//System.out.print("ID :"+id);
		if(e1.getText().toString().length()!=0)
		{
			id=Integer.parseInt(e1.getText().toString());
			rep r=d.getrep(id);
			if(r!=null)
			{
				t2.setText("Sname:"+r.name);
				t3.setText("Dept:"+r.dept);
				t4.setText("Post:"+r.position);
				t5.setText("E-mail:"+r.phnum);
			}
			else
				Toast.makeText(DisplayActivity.this,"No such records",Toast.LENGTH_LONG).show();
		}
		else
			Toast.makeText(DisplayActivity.this,"Enter ID first",Toast.LENGTH_LONG).show();
	}
}
