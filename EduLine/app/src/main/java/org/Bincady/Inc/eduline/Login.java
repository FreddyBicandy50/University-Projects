package org.Bincady.Inc.eduline;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;

public class Login extends AppCompatActivity {
    ToggleButton tgl_show_password;
    CheckBox save;
    boolean available,connected,credentials=false,exist,is_showpassword=false;
    TextView txt_signup,txt_id,txt_password;
    EditText input_id,input_password;
    dbHandler db;
    GifImageView loading;
    ResultSet info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        Style_behavior();

        available=autoLogin();
        if(available) {
            input_id.setFocusable(false);
            input_password.setFocusable(false);
            input_id.setClickable(false);
            input_password.setClickable(false);

            input_id.setBackground(getDrawable(R.drawable.edittext_disabled));
            input_password.setBackground(getDrawable(R.drawable.edittext_disabled));
            on_login(save);
        }
    }

    public void Style_behavior(){
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        db = new dbHandler(Login.this);
        //Toggle
        tgl_show_password=findViewById(R.id.icon_password);
        //gif
        loading=findViewById(R.id.loading_gif);
        //TextView
        txt_signup=findViewById(R.id.text_signup_link);
        txt_id=findViewById(R.id.text_id_hint);
        txt_password=findViewById(R.id.text_password_hint);
        //EditText
        input_id=findViewById(R.id.field_id);
        input_password=findViewById(R.id.field_password);
        //Checkbox
        save=findViewById(R.id.remember_user);
        //Style
        input_id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable values) {
                //if text input has values
                if (values.length() != 0)txt_id.animate().translationY(-txt_id.getHeight() * 1.2f);
                else txt_id.animate().translationY(txt_id.getHeight() * 0f);//move down
            }
        });

        input_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable values) {
                //if text input has values
                if (values.length() != 0)txt_password.animate().translationY(-txt_password.getHeight() * 1.2f);
                else txt_password.animate().translationY(txt_password.getHeight() * 0f);//move down
            }
        });
    }


    public void password_toggle(View icon){
        //if icon is clicked
        if (!is_showpassword) {
            //set password box text to clear
            input_password.setTransformationMethod(null);
            //change statement and logo to hide password
            tgl_show_password.setBackgroundResource(R.drawable.icon_hide_password);
            is_showpassword = true;
        } else {
            //set password to hash
            input_password.setTransformationMethod(new PasswordTransformationMethod());
            //change statement and logo to show password
            tgl_show_password.setBackgroundResource(R.drawable.icon_show_password);
            is_showpassword= false;
        }
    }

    public void sign_up(View sign_up_btn){
        Intent signup_page=new Intent(this,signup.class);
        startActivity(signup_page);
    }

    public void forget_password(View forget_password){
        Intent otp_page=new Intent(this,otprequest.class);
        startActivity(otp_page);
    }

    public void on_login(View login_btn){
        if(!available){
            if(input_id.getText().toString().length()==0 ){
                input_id.setBackground(getDrawable(R.drawable.edit_notvalid));
                Toast.makeText(this, "Enter Student id", Toast.LENGTH_SHORT).show();
                return;
            }else{input_id.setBackground(getDrawable(R.drawable.edit_text));}

            if(input_password.getText().toString().length()==0 ){
                input_password.setBackground(getDrawable(R.drawable.edit_notvalid));
                Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show();
                return;
            }else{input_password.setBackground(getDrawable(R.drawable.edit_text));}
        }

        loading.setVisibility(View.VISIBLE);
        new Login.Async().execute();

    }
    class Async extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                String connectionString = "jdbc:mysql://192.168.1.109:3306/EduLine";
                Connection connection = DriverManager.getConnection(connectionString, "fredy", "Freddyby@1120338#7");
                Statement statement = connection.createStatement();
                long id=Long.parseLong(input_id.getText().toString());
                String password=input_password.getText().toString();
                boolean Connection = connection.isValid(5); // 5 is the timeout in seconds
                if (Connection) {
                    connected = true;
                    String query = "SELECT * FROM `app` WHERE student_id="+id;
                    ResultSet student_id = statement.executeQuery(query);
                    if (student_id.next()) {
                        exist = true;
                        query = "SELECT * FROM `students` WHERE student_id="+id;
                        info = statement.executeQuery(query);
                        credentials= info.next() && info.getString(7).equals(password);

                    }else exist=false;
                }else connected=false;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if(connected){
                if (exist) {
                    if(credentials) {
                        if(save.isChecked()) db.insert(input_id.getText().toString(),input_password.getText().toString());
                        try {
                            main();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else{
                        input_password.setBackground(getDrawable(R.drawable.edit_notvalid));
                        Toast.makeText(Login.this, "incorrect password!", Toast.LENGTH_SHORT).show();
                        loading.setVisibility(View.GONE);
                    }
                }else{
                    input_id.setBackground(getDrawable(R.drawable.edit_notvalid));
                    Toast.makeText(Login.this, "user id not found", Toast.LENGTH_SHORT).show();
                    loading.setVisibility(View.GONE);

                }
            }else Toast.makeText(Login.this, "Check your internet connection", Toast.LENGTH_SHORT).show();

            super.onPostExecute(aVoid);
        }

    }
    public boolean autoLogin(){
        List <String> info= new ArrayList<>();
        info=db.read();
        if(!info.isEmpty()){
            input_id.setText(info.get(0));
            input_password.setText(info.get(1));
            return true;
        }

        return false;
    }
    public void main() throws SQLException {
        Intent main=new Intent(this,main.class);
        Bundle data=new Bundle();

        data.putString("student_id", info.getString(1));
        data.putString("firstname", info.getString(2));
        data.putString("middlename", info.getString(3));
        data.putString("lastname", info.getString(4));
        data.putString("address", info.getString(5));
        data.putString("email", info.getString(6));
        main.putExtras(data);
        startActivity(main);
        finish();
    }

    public void reset(View Click_away){
        //CLEARING FOCUSES
        input_id.clearFocus();
        input_password.clearFocus();

        //CLOSE THE KEYBOARD
        InputMethodManager inputmethod = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE); // Get the input method
        // Check if the keyboard is currently open in all fields
        if (inputmethod.isAcceptingText()) {
            inputmethod.hideSoftInputFromWindow(input_id.getWindowToken(), 0);
            inputmethod.hideSoftInputFromWindow(input_password.getWindowToken(), 0);
        }


    }
}