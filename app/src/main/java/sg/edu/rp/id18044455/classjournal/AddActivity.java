package sg.edu.rp.id18044455.classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    TextView tvWeek;
    RadioGroup rGrade;
    Button btnSubmit;
    String moduleCode;
    Integer week;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Intent i = getIntent();
        moduleCode = i.getStringExtra("moduleCode");
        week = i.getIntExtra("week", 0);
        getSupportActionBar().setTitle("Add data for Week " + week);

        tvWeek = findViewById(R.id.tvWeek);
        rGrade = findViewById(R.id.rGrade);
        btnSubmit = findViewById(R.id.btnSubmit);

        tvWeek.setText("Week " + String.valueOf(week));


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String grade = "";
                if (rGrade.getCheckedRadioButtonId() == -1){
                    Toast.makeText(AddActivity.this, "Please select a daily grade", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (rGrade.getCheckedRadioButtonId() == R.id.radioButtonA){
                        grade = "A";
                    }
                    else if (rGrade.getCheckedRadioButtonId() == R.id.radioButtonB){
                        grade = "B";
                    }
                    else if (rGrade.getCheckedRadioButtonId() == R.id.radioButtonC){
                        grade = "C";
                    }
                    else if (rGrade.getCheckedRadioButtonId() == R.id.radioButtonD){
                        grade = "D";
                    }
                    else if (rGrade.getCheckedRadioButtonId() == R.id.radioButtonF){
                        grade = "C";
                    }
                    else if (rGrade.getCheckedRadioButtonId() == R.id.radioButtonX){
                        grade = "D";
                    }

                    Intent i = new Intent();
                    DailyCA newDailyCA = new DailyCA(grade, moduleCode, week);
                    i.putExtra("newDailyCA", newDailyCA);
                    setResult(RESULT_OK, i);
                    finish();

                }//end of validation

            }
        });



    }//end of onCreate

}//end of class