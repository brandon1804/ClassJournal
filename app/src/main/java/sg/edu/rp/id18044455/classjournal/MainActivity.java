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
    ArrayList<String> modulesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lvModules);

        modulesArrayList = new ArrayList<String>();

        modulesArrayList.add("C347");

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, modulesArrayList);

        lv.setAdapter(adapter);

        /*

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent i = new Intent(FirstActivity.this, SecondActivity.class);
                switch( position )
                {
                    case 0:
                        i.putExtra("year","Year 1");
                        break;
                    case 1:
                        i.putExtra("year","Year 2");
                        break;
                    case 2:
                        i.putExtra("year","Year 3");
                        break;
                }
                startActivity(i);
            }
        });
         */
    }
}
