package sg.edu.rp.id18044455.classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Module> modulesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lvModules);

        modulesArrayList = new ArrayList<Module>();

        modulesArrayList.add(new Module("C302", "Web Services", "https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C300"));
        modulesArrayList.add(new Module("C347", "Android Programming II", "https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C346"));

        ModulesAdapter adapter =  new ModulesAdapter(this, R.layout.mainactivityrow, modulesArrayList);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("module",modulesArrayList.get(position).getModuleCode());
                i.putExtra("moduleURL",modulesArrayList.get(position).getUrl());
                startActivity(i);
            }
        });
    }
}
