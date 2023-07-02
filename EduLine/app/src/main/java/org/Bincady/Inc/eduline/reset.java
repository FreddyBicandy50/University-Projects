package org.Bincady.Inc.eduline;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class reset extends Activity {
    TextView txt_mail;
    EditText opt_number1,opt_number2,opt_number3,opt_number4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgetpassword_activity);
        txt_mail=findViewById(R.id.text_email);
        opt_number1=findViewById(R.id.otp_n1);
        opt_number2=findViewById(R.id.field_password);
        opt_number3=findViewById(R.id.opt_n3);
        opt_number4=findViewById(R.id.opt_n4);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String email = bundle.getString("email");
            txt_mail.setText(email);
            // Do something with the retrieved data
            // ...
        }

        Style_behavior();
    }
    public void Style_behavior(){
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

    }
    public void edit_mail(View v){
       finish();
    }
    public void resend(View v){
        Toast.makeText(this, "a new OTP has been sent to your email!", Toast.LENGTH_SHORT).show();
    }
    public void reset(View Click_away){
        //CLEARING FOCUSES
        opt_number1.clearFocus();
        opt_number2.clearFocus();
        opt_number3.clearFocus();
        opt_number4.clearFocus();
        //CLOSE THE KEYBOARD
        InputMethodManager inputmethod = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE); // Get the input method
        // Check if the keyboard is currently open in all fields
        if (inputmethod.isAcceptingText()) {
            inputmethod.hideSoftInputFromWindow(opt_number1.getWindowToken(), 0);
            inputmethod.hideSoftInputFromWindow(opt_number2.getWindowToken(), 0);
            inputmethod.hideSoftInputFromWindow(opt_number3.getWindowToken(), 0);
            inputmethod.hideSoftInputFromWindow(opt_number4.getWindowToken(), 0);
        }


    }
}
