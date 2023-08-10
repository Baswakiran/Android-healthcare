package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edusername, edemail, edpassword, edConfirmPassword;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edusername = findViewById(R.id.editTextRegUsername);
        edemail = findViewById(R.id.editTextRegEmail);
        edpassword = findViewById(R.id.editTextRegPassword);
        edConfirmPassword = findViewById(R.id.editTextRegConfirmPassword);
        btn = findViewById(R.id.button);
        tv = findViewById(R.id.textViewExistingAccount);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=edusername.getText().toString();
                String email=edemail.getText().toString();
                String password=edpassword.getText().toString();
                String confirm=edConfirmPassword.getText().toString();
                Database db=new Database(getApplicationContext(),"healthcare",null,1);
                if(username.length()==0 || email.length()==0 || password.length()==0 || confirm.length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Please fill all the details",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(password.compareTo(confirm)==0)
                    {
                        if(isvalid(password))
                        {
                            db.register(username,email,password);
                            Toast.makeText(getApplicationContext(),"Record Inserted",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Password must contain at least 8 characters,having numbers,letters and special symbols",Toast.LENGTH_SHORT).show();
                        }

                    }else {
                        Toast.makeText(getApplicationContext(),"Password and Confirm password didn't match",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public static boolean isvalid(String passwordhere)
    {
        int f1=0,f2=0,f3=0;
        if(passwordhere.length()<8)
        {
            return false;
        }
        else{
            for(int p=0;p<passwordhere.length();p++)
            {
                if(Character.isLetter(passwordhere.charAt(p)))
                    f1=1;
            }
        }
        for(int q=0;q<passwordhere.length();q++)
        {
            if(Character.isDigit(passwordhere.charAt(q)))
                f2=1;
        }
        for(int r=0;r<passwordhere.length();r++)
        {
            char c=passwordhere.charAt(r);
            if(c>=33&&c<=46||c==64)
            {
                f3=1;
            }
        }
        if(f1==1&&f2==1&&f3==1)
            return true;
        return false;
    }
}