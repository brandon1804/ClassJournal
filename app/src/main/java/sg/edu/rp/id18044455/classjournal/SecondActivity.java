package sg.edu.rp.id18044455.classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ListView lvGrade;
    int requestCodeForModule = 1;
    String text = "";
    String module, moduleURL;
    Button btnAdd;
    Button btnInfo;
    Button btnEmail;
    ArrayAdapter aa;
    ArrayList<DailyCA> dailyCAList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        lvGrade = findViewById(R.id.lvGrade);
        btnEmail = findViewById(R.id.btnEmail);
        btnInfo = findViewById(R.id.btnInfo);
        btnAdd = findViewById(R.id.btnAdd);

        Intent i = getIntent();
        module = i.getStringExtra("module");
        moduleURL = i.getStringExtra("moduleURL");
        getSupportActionBar().setTitle("Info for " + module);

        dailyCAList = new ArrayList<>();
        dailyCAList.add(new DailyCA("A",  "C347", 1));

        aa = new WeekAdapter(this, R.layout.row, dailyCAList);
        lvGrade.setAdapter(aa);

        btnEmail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                text = "";
                for (int i = 0; i < dailyCAList.size(); i++) {
                    text += "Week " + (i + 1) + " : DG:" + dailyCAList.get(i).getDgGrade() + "\n";
                }

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "Grades");
                email.putExtra(Intent.EXTRA_TEXT,text);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));

            }});


        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent infoIntent = new Intent(Intent.ACTION_VIEW);
                infoIntent.setData(Uri.parse(moduleURL));
                startActivity(infoIntent);
            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(SecondActivity.this, AddActivity.class);
                i.putExtra("week", dailyCAList.size() + 1);
                i.putExtra("moduleCode", module);
                startActivityForResult(i, requestCodeForModule);
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if (data != null) {
                if(requestCode == requestCodeForModule){
                    dailyCAList.add((DailyCA)data.getSerializableExtra("newDailyCA"));
                    aa.notifyDataSetChanged();
                }
            }
        }
    }
    // End of onActivityResult
}