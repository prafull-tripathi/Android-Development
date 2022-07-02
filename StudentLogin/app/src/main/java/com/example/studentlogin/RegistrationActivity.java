package com.example.studentlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    EditText username, password, repassword;
    Button signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        DBHelper DB=new DBHelper(this);
        initWidhits();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("") || pass.equals("") || repass.equals("")){
                    Toast.makeText(RegistrationActivity.this,"Fill all the details",Toast.LENGTH_SHORT).show();
                }
                else{
                    if (pass.equals(repass)){
                        Boolean checkUser=DB.checkusername(user);
                        if(checkUser==false){
                            Boolean insert=DB.insertData(user,pass);
                            if(insert==true){
                                Toast.makeText(RegistrationActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(RegistrationActivity.this,Dashboard.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(RegistrationActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(RegistrationActivity.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(RegistrationActivity.this,MainActivity.class);
                            startActivity(intent);
                        }
                    }else{
                        Toast.makeText(RegistrationActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                        repassword.setText("");
                    }
                }
            }
        });

    }

    private void initWidhits() {
        username=findViewById(R.id.txtusername1);
        password=findViewById(R.id.txtpassword1);
        repassword=findViewById(R.id.txtRepassword);
        signup=findViewById(R.id.btnsignUp);
    }
}