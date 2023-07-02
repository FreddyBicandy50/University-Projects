package org.Bincady.Inc.eduline;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import org.w3c.dom.Text;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class main extends AppCompatActivity {
    GifImageView home,calendar,user;
    GifDrawable home_animator,calendar_animator,logout_animator;
    WebView event_Viewer;
    String id,first,middle,last,address,email;
    TextView title,student_name,student_gradenid,student_email;
    ConstraintLayout home_layout;
    ScrollView calendar_layout;
    Spinner spinnerWeekdays;
    String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    int defaultPosition = 0;
    String SelectedWeekday;
    ImageView timesep;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        style_behavior();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getString("student_id");
            first = bundle.getString("firstname");
            middle = bundle.getString("middlename");
            last = bundle.getString("lastname");
            address = bundle.getString("address");
            email = bundle.getString("email");

            student_name.setText(first+" "+middle+" "+last);
            student_gradenid.setText("address:"+address+"\n\nGrade 8A"+" | ID:"+id);
            student_email.setText(email);
        }
        spinnerWeekdays.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SelectedWeekday = parent.getItemAtPosition(position).toString();
                spinnerWeekdays.setSelection(position);
                week();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle case when nothing is selected
            }
        });

    }
    public void style_behavior(){
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        //image
        timesep=findViewById(R.id.timeseprator);
        //spinner
        spinnerWeekdays = findViewById(R.id.weekdays);
        adapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, weekdays);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerWeekdays.setAdapter(adapter);
        spinnerWeekdays.setSelection(defaultPosition);
        week();

        //Layout
        home_layout=findViewById(R.id.layout1);
        calendar_layout=findViewById(R.id.layout2);
        //TextView
        title=findViewById(R.id.text_header);
        student_name=findViewById(R.id.text_studentname);
        student_gradenid=findViewById(R.id.text_grade);
        student_email=findViewById(R.id.text_emailview);
        //GifView
        home=findViewById(R.id.icon_home);
        calendar=findViewById(R.id.icon_calendar);
        user=findViewById(R.id.icon_user);

        //WebView
        event_Viewer = findViewById(R.id.event_calendar);

        home_animator = (GifDrawable) home.getDrawable();
        calendar_animator = (GifDrawable) calendar.getDrawable();
        logout_animator = (GifDrawable) user.getDrawable();

        home_animator.start();
        calendar_animator.stop();
        logout_animator.stop();


        event_Viewer.setWebViewClient(new WebViewClient());
        event_Viewer.getSettings().setJavaScriptEnabled(true);
        event_Viewer.getSettings().setDomStorageEnabled(true);
        event_Viewer.getSettings().setDatabaseEnabled(true);

        event_Viewer.loadUrl("https://freddybicandy.notion.site/Academic-Calendar-3a41290613254412b8264402bd062609");


    }
    public void home(View v){
        title.setText("EduLine");
        home_animator.reset();
        home_animator.setLoopCount(1);

        home_animator.start();
        home_layout.setVisibility(View.VISIBLE);
        timesep.setVisibility(View.GONE);
        calendar_layout.setVisibility(View.GONE);

    }
    public void signout(View v){
        logout_animator.reset();
        logout_animator.setLoopCount(1);
        logout_animator.start();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to sign out?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      close();

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();

    }
    public void close(){
        dbHandler db=new dbHandler(main.this);
        db.reset();
        Intent i=new Intent(this,Login.class);
        startActivity(i);
        finish();
    }
 public void timetable(View v){
        title.setText("TimeTable");
        calendar_animator.reset();
        calendar_animator.setLoopCount(1);
        calendar_animator.start();

        home_layout.setVisibility(View.GONE);
        calendar_layout.setVisibility(View.VISIBLE);
        timesep.setVisibility(View.VISIBLE);

    }
    public void attendance(View v){
        Intent i=new Intent(this,attendance.class);
        startActivity(i);
    }
    public void assignments(View v){
        Intent i=new Intent(this,assignments.class);
        startActivity(i);
    }
public void week(){
    String[] Monday = {"ICT", "Science", "Physics", "Math", "History","English","Geography","Arts"};
    String[] Tuesday = {"Mindfulness", "Physical Education", "Performance Arts", "French", "Arabic","Biology","Chemistry","History"};
    String[] Wednesday = {"Math", "ICT", "Science", "French", "Geography","Biology","Arabic","Arts"};
    String[] Thursday = {"Geography", "Arabic", "History", "Biology", "French","Performance Arts","Geography","Arts"};
    String[] Friday = {"Math", "ICT", "Science", "Math", "History","English ","Geography","Arts"};
    Button p1=findViewById(R.id.p1);
    Button p2=findViewById(R.id.p2);
    Button p3=findViewById(R.id.p3);
    Button p4=findViewById(R.id.p4);
    Button p5=findViewById(R.id.p5);
    Button p6=findViewById(R.id.p6);
    Button p7=findViewById(R.id.p7);
    Button p8=findViewById(R.id.p8);

    if(spinnerWeekdays.getSelectedItemPosition()==0){
        p1.setText("  "+Monday[0]);
        p2.setText("  "+Monday[1]);
        p3.setText("  "+Monday[2]);
        p4.setText("  "+Monday[3]);
        p5.setText("  "+Monday[4]);
        p6.setText("  "+Monday[5]);
        p7.setText("  "+Monday[6]);
        p8.setText("  "+Monday[7]);
    } else if(spinnerWeekdays.getSelectedItemPosition()==1){
        p1.setText("  "+Tuesday[0]);
        p2.setText("  "+Tuesday[1]);
        p3.setText("  "+Tuesday[2]);
        p4.setText("  "+Tuesday[3]);
        p5.setText("  "+Tuesday[4]);
        p6.setText("  "+Tuesday[5]);
        p7.setText("  "+Tuesday[6]);
        p8.setText("  "+Tuesday[7]);
    }else if(spinnerWeekdays.getSelectedItemPosition()==2){
        p1.setText("  "+Wednesday[0]);
        p2.setText("  "+Wednesday[1]);
        p3.setText("  "+Wednesday[2]);
        p4.setText("  "+Wednesday[3]);
        p5.setText("  "+Wednesday[4]);
        p6.setText("  "+Wednesday[5]);
        p7.setText("  "+Wednesday[6]);
        p8.setText("  "+Wednesday[7]);
    }else if(spinnerWeekdays.getSelectedItemPosition()==3){
        p1.setText("  "+Thursday[0]);
        p2.setText("  "+Thursday[1]);
        p3.setText("  "+Thursday[2]);
        p4.setText("  "+Thursday[3]);
        p5.setText("  "+Thursday[4]);
        p6.setText("  "+Thursday[5]);
        p7.setText("  "+Thursday[6]);
        p8.setText("  "+Thursday[7]);
    }else if(spinnerWeekdays.getSelectedItemPosition()==4){
        p1.setText("  "+Friday[0]);
        p2.setText("  "+Friday[1]);
        p3.setText("  "+Friday[2]);
        p4.setText("  "+Friday[3]);
        p5.setText("  "+Friday[4]);
        p6.setText("  "+Friday[5]);
        p7.setText("  "+Friday[6]);
        p8.setText("  "+Friday[7]);
    }
}

    @Override
    public void onBackPressed() {
        // Handle back button press if needed
    }
}
