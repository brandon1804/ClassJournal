package sg.edu.rp.id18044455.classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class WeekAdapter extends ArrayAdapter<DailyCA> {

    // Create ArrayList of objects
    private ArrayList<DailyCA> weekList;
    // To hold the context object
    private Context context;
    // Create the UI objects to hold the UI elements in row layout
    private TextView tvWeek;
    private TextView tvGrade;
    // Create the image object to show the image
    private ImageView ivDg;

    public WeekAdapter(Context context, int resource,
                                 ArrayList<DailyCA> objects) {
        super(context, resource, objects);
        // Store the ArrayList of objects passed to this adapter
        weekList = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }
    // getView() is called every time for every row
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //  Change R.layout.rowxyz if file is rowxyz.xml .
        View rowView = inflater.inflate(R.layout.row, parent,
                false);
        // Get the TextView object
        tvWeek = rowView.findViewById(R.id.tvWeek);
        tvGrade = rowView.findViewById(R.id.tvGrade);
        // Get the ImageView
        ivDg = rowView.findViewById(R.id.ivDg);
        // Parameter "pos" is the index of the
        //  row ListView is requesting.
        //  We get back the object at the same index.
        DailyCA currentCA = weekList.get(position);
        tvWeek.setText("week " + String.valueOf(position + 1));
        // Set the TextView to show the object info
        tvGrade.setText(currentCA.getDgGrade());
        // Set the ImageView to show the image
        ivDg.setImageResource(R.drawable.dg);
        // Return this row that is being populated.
        return rowView;
    }
}
