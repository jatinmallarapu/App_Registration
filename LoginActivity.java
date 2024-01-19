package com.example.sqlite_mad;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class LoginActivity extends AppCompatActivity {
EditText username, password;
Button signin;
DBHelper DB;
TextView t2;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_login);
username=findViewById(R.id.unamesignin);
password=findViewById(R.id.passsignin);
signin = findViewById(R.id.signinin);
DB=new DBHelper(this);
t2=findViewById(R.id.t2);
signin.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
String user=username.getText().toString();
String pass=password.getText().toString();
if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
//Toast.makeText(LoginActivity.this, "All Fields are required",
Toast.LENGTH_SHORT).show();
t2.setText("All Fields are required");
else {
Boolean
checkuserpass=DB.checkusernamepassword(user,pass);
if (checkuserpass==true) {
//Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
t2.setText("Login Successful");
Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
startActivity(intent);
}else{
//Toast.makeText(LoginActivity.this, "Login Failed",Toast.LENGTH_SHORT).show();
t2.setText("Login Failed");
}
}
}
});
}
}
