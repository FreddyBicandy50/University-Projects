package org.Bincady.Inc.eduline;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class signup extends Activity {
    boolean conn,credentials,foundschool,foundstudent,exist,is_showpassword=false;
    EditText input_email,input_id,input_code,input_password;
    ToggleButton tgl_show_password;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        Style_behavior();
    }
    public void Style_behavior(){
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        builder= new AlertDialog.Builder(this);
        input_id=findViewById(R.id.field_studentid);
        input_code=findViewById(R.id.field_schoolcode);
        input_email=findViewById(R.id.field_email);
        input_password=findViewById(R.id.field_password);
        tgl_show_password=findViewById(R.id.show_password);
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

    public void sign_in(View v){
        finish();
    }
    public void sign_up(View v){
        //check student id and school code and password
        if(input_id.getText().toString().length()==0 ){
            input_id.setBackground(getDrawable(R.drawable.edit_notvalid));
            return;
        }else{input_id.setBackground(getDrawable(R.drawable.edit_text));}

        if(input_code.getText().toString().length()==0 ){
            input_code.setBackground(getDrawable(R.drawable.edit_notvalid));
            return;
        }else{input_code.setBackground(getDrawable(R.drawable.edit_text));}

        //check email
        boolean flag=false;
        StringBuilder domain= new StringBuilder();
        String check=input_email.getText().toString();
        if (input_email.getText().toString().length()>0){

            for (int i=0;i<input_email.getText().toString().length();i++) {
                if (check.charAt(i)=='@') flag=true;
                if(flag) domain.append(check.charAt(i));
            }

            if(domain.toString().equals("@eastwoodstudent.com")) {
                /*
                Intent otp_page = new Intent(this, reset.class);
                Bundle bundle = new Bundle();
                bundle.putString("email", input_email.getText().toString());
                otp_page.putExtras(bundle);
                startActivity(otp_page);*/
                input_email.setBackground(getDrawable(R.drawable.edit_text));
            }else{
                Toast.makeText(this, "Invalid email!", Toast.LENGTH_SHORT).show();
                input_email.setBackground(getDrawable(R.drawable.edit_notvalid));
                return;
            }
        }else{
            input_email.setBackground(getDrawable(R.drawable.edit_notvalid));
            return;
        }
        if(input_password.getText().toString().length()==0){
            input_password.setBackground(getDrawable(R.drawable.edit_notvalid));
            return;
        }else{input_password.setBackground(getDrawable(R.drawable.edit_text));}

        new Async().execute();

    }


    class Async extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                String connectionString = "jdbc:mysql://192.168.1.109:3306/EduLine";
                Connection connection = DriverManager.getConnection(connectionString, "fredy", "Freddyby@1120338#7");
                Statement statement = connection.createStatement();
                boolean isConnected = connection.isValid(5); // 5 is the timeout in seconds
                if (isConnected) {
                    conn = true;
                    long code = Integer.parseInt(input_code.getText().toString());
                    String query = "SELECT * FROM `schools` WHERE school_id=" + code;
                    ResultSet school = statement.executeQuery(query);
                    if (school.next()) {
                        foundschool = true;
                        long id = Long.parseLong(input_id.getText().toString());
                        query = "SELECT * FROM `students` WHERE student_id=" + id;
                        ResultSet info = statement.executeQuery(query);
                        if (info.next()) {
                            foundstudent = true;
                            String email = input_email.getText().toString();
                            String password = input_password.getText().toString();
                            if (info.getString(6).equals(email) && info.getString(7).equals(password)) {
                                credentials = true;
                                query = "SELECT * FROM `app` WHERE student_id=" + id;
                                ResultSet app = statement.executeQuery(query);
                                if (!app.next()) {
                                    exist = false;
                                    String INSERT = "INSERT INTO `app`(`student_id`, `school_code`) VALUES ('id','code')";
                                    INSERT = INSERT.replace("'id'", "'" + id + "'");
                                    INSERT = INSERT.replace("'code'", "'" + code + "'");
                                    statement.execute(INSERT);
                                } else exist = true;
                            } else credentials = false;
                        } else foundstudent = false;
                    } else foundschool = false;
                } else conn = false;

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if(conn)
                if(foundschool){
                    if(foundstudent) {
                        if (credentials) {
                            if (!exist) {
                                builder.setMessage("Signed up successfully!\n you can now login using your student id="+input_id.getText().toString()+"\nand email password="+input_password.getText().toString())
                                        .setTitle("Success");
                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        finish();
                                    }
                                });
                                builder.setCancelable(false);
                                AlertDialog dialog = builder.create();
                                dialog.show();
                            }else {
                                builder.setMessage("Already a member!\n you can now login using your student id="+input_id.getText().toString()+"\nand email password="+input_password.getText().toString())
                                        .setTitle("Can't Sign Up");
                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        finish();
                                    }
                                });
                                builder.setCancelable(false);
                                AlertDialog dialog = builder.create();
                                dialog.show();
                            }
                        } else {
                            Toast.makeText(signup.this, "invalid email or password", Toast.LENGTH_SHORT).show();
                            input_email.setBackground(getDrawable(R.drawable.edit_notvalid));
                            input_password.setBackground(getDrawable(R.drawable.edit_notvalid));
                        }
                    }else {
                        Toast.makeText(signup.this, "invalid student id", Toast.LENGTH_SHORT).show();
                        input_id.setBackground(getDrawable(R.drawable.edit_notvalid));
                    }
                }else {
                    Toast.makeText(signup.this, "school code not valid", Toast.LENGTH_SHORT).show();
                    input_code.setBackground(getDrawable(R.drawable.edit_notvalid));
                }
            else Toast.makeText(signup.this, "Check your internet connection", Toast.LENGTH_SHORT).show();

            super.onPostExecute(aVoid);
        }

    }

    public void reset(View Click_away){

        input_id.clearFocus();
        input_code.clearFocus();
        input_email.clearFocus();
        input_password.clearFocus();

        InputMethodManager inputmethod = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputmethod.isAcceptingText()) {
            inputmethod.hideSoftInputFromWindow(input_id.getWindowToken(), 0);
            inputmethod.hideSoftInputFromWindow(input_code.getWindowToken(), 0);
            inputmethod.hideSoftInputFromWindow(input_email.getWindowToken(), 0);
            inputmethod.hideSoftInputFromWindow(input_password.getWindowToken(), 0);
        }
    }
}
