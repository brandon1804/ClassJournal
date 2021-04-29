package sg.edu.rp.id18044455.classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    Button btnEmail;
    ArrayList<DailyCA> dailyCA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnEmail = (Button) findViewById(R.id.btnEmail);
        Intent i = getIntent();
        String module = i.getStringExtra("module");
        getSupportActionBar().setTitle("Info for " + module);

        dailyCA = new ArrayList<DailyCA>();

        btnEmail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {

                Intent email = new Intent(Intent.ACTION_SEND);

                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "Grades");
                email.putExtra(Intent.EXTRA_TEXT,
                //        editTextMessage.getText());
                email.setType("message/rfc822"));
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));

            }});

    }
}