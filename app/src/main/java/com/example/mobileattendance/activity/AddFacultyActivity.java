package com.example.mobileattendance.activity;

import com.example.mobileattendance.bean.FacultyBean;
import com.example.mobileattendance.db.DBAdapter;
import com.example.mobileattendance.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddFacultyActivity extends Activity {

	Button registerButton;
	EditText textFirstName;
	EditText textLastName;
	EditText textEmail;
	EditText textContact;
	EditText textAddress;
	EditText textUsername;
	EditText textPassword;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addfaculty);

		textFirstName=(EditText)findViewById(R.id.editTextFirstName);
		textLastName=(EditText)findViewById(R.id.editTextLastName);
		textEmail=(EditText)findViewById(R.id.editTextEmail);
		textContact=(EditText)findViewById(R.id.editTextPhone);
		textAddress=(EditText)findViewById(R.id.editTextaddr);
		textUsername=(EditText)findViewById(R.id.editTextUserName);
		textPassword=(EditText)findViewById(R.id.editTextPassword);
		registerButton=(Button)findViewById(R.id.RegisterButton);

		registerButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				String first_name = textFirstName.getText().toString();
				String last_name = textLastName.getText().toString();
				String email = textEmail.getText().toString();
				String phone_no = textContact.getText().toString();
				String address = textAddress.getText().toString();
				String userName = textUsername.getText().toString();
				String passWord = textPassword.getText().toString();

				if (TextUtils.isEmpty(first_name)) {
					textFirstName.setError("Please Enter Firstname");
				}
				else if (TextUtils.isEmpty(last_name)) {
					textLastName.setError("Please Enter Lastname");
				}
				else if (TextUtils.isEmpty(email)){
				    textEmail.setError("Please Enter Email");
                }
				else if (TextUtils.isEmpty(phone_no)) {
					textContact.setError("Please Enter Phoneno");
				}
				else if (TextUtils.isEmpty(address)) {
					textAddress.setError("Enter Address");
				}	
				else if (TextUtils.isEmpty(userName)) {
					textUsername.setError("Please Enter Username");
				}
				else if (TextUtils.isEmpty(passWord)) {
					textPassword.setError("Enter Password");
				}				
				else {
					FacultyBean facultyBean = new FacultyBean();
					facultyBean.setFaculty_firstname(first_name);
					facultyBean.setFaculty_lastname(last_name);
					facultyBean.setFaculty_email(email);
					facultyBean.setFaculty_mobilenumber(phone_no);
					facultyBean.setFaculty_address(address);
					facultyBean.setFaculty_username(userName);
					facultyBean.setFaculty_password(passWord);
					
					DBAdapter dbAdapter = new DBAdapter(AddFacultyActivity.this);
					dbAdapter.addFaculty(facultyBean);
					
					Intent intent =new Intent(AddFacultyActivity.this,MenuActivity.class);
					startActivity(intent);
					Toast.makeText(getApplicationContext(), "Faculty Added Successfully", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
