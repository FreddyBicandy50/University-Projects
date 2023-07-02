package org.Bincady.Inc.eduline;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class otprequest extends Activity {
    EditText input_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getemail_activity);
        input_email=findViewById(R.id.field_email);
        Style_behavior();
    }
    public void Style_behavior(){
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
    }
    public void sendcode(View forget_password_btn){
        boolean flag=false;
        StringBuilder domain= new StringBuilder();
        String check=input_email.getText().toString();
        if (!check.equals("")){
            for (int i=0;i<input_email.getText().toString().length();i++) {
                if (check.charAt(i)=='@') flag=true;
                if(flag) domain.append(check.charAt(i));
            }
            if(domain.toString().equals("@eastwoodstudent.com")) {
                Intent otp_page = new Intent(this, reset.class);
                Bundle bundle = new Bundle();
                bundle.putString("email", input_email.getText().toString());
                otp_page.putExtras(bundle);
                startActivity(otp_page);
                return;
            }
        }
        Toast.makeText(this, "Invalid email!", Toast.LENGTH_SHORT).show();
        input_email.setBackground(getDrawable(R.drawable.edit_notvalid));
    }
    public void reset(View Click_away){
        //CLEARING FOCUSES
        input_email.clearFocus();
        //CLOSE THE KEYBOARD
        InputMethodManager inputmethod = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE); // Get the input method
        // Check if the keyboard is currently open in all fields
        if (inputmethod.isAcceptingText()) inputmethod.hideSoftInputFromWindow(input_email.getWindowToken(), 0);

    }
}
