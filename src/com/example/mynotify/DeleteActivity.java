package com.example.mynotify;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends Activity {

	dbcontrol d=new dbcontrol(this);
	EditText e1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_delete);
		e1=(EditText)findViewById(R.id.editText1);
		e1.setText("");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.delete, menu);
		return true;
	}
	
	public void delete(View v)
	{
		int id;
		//System.out.print("ID :"+id);
		if(e1.getText().toString().length()!=0)
		{
			id=Integer.parseInt(e1.getText().toString());
			int i;
			i=d.delete(id);
			if(i>0)
				Toast.makeText(DeleteActivity.this,"Success",Toast.LENGTH_LONG).show();
			else
				Toast.makeText(DeleteActivity.this,"Deletion failed",Toast.LENGTH_LONG).show();
		}
		else
			Toast.makeText(DeleteActivity.this,"Enter ID first",Toast.LENGTH_LONG).show();
	}

}
