package com.example.sqlite_mad;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
EditText username, password, re_password;
Button register;
TextView have_account,t1;
DBHelper DB;
@SuppressLint("MissingInflatedId")
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
username = findViewById(R.id.unamesignup);
password = findViewById(R.id.passsignup);
re_password = findViewById(R.id.conpasssignup);
register = findViewById(R.id.register);
have_account = findViewById(R.id.haaccount);
DB=new DBHelper(this);
TextView t1=findViewById(R.id.t1);
register.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
String user = username.getText().toString();
String pass = password.getText().toString();
String repass = re_password.getText().toString();
if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) ||
TextUtils.isEmpty(repass))
//Toast.makeText(MainActivity.this, "All Fields Required", Toast.LENGTH_SHORT).show();
t1.setText("All Fields Required");
else{
if(pass.equals(repass)){
Boolean checkuser = DB.checkusername(user);
if(checkuser==false) {
Boolean insert = DB.insertData(user,pass);
if (insert=true){
//Toast.makeText(MainActivity.this, "Registered succesfully",
Toast.LENGTH_SHORT).show();
t1.setText("All Fields Required");
Intent intent = new
Intent(getApplicationContext(), HomeActivity.class);
startActivity(intent);
}else{
t1.setText("Registration Failed");
}
}else{
//Toast.makeText(MainActivity.this, "User already Exists",
Toast.LENGTH_SHORT).show();
t1.setText("User already Exists");
}
}else{
//Toast.makeText(MainActivity.this, "Passwords are not matching",
Toast.LENGTH_SHORT).show();
t1.setText("Passwords are not matching");
}
}
}
});
have_account.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
Intent intent = new Intent(getApplicationContext(),
                           LoginActivity.class);
startActivity(intent);
  }
});
}
}
