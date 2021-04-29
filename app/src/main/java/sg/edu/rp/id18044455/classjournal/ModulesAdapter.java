package sg.edu.rp.id18044455.classjournal;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class ModulesAdapter extends ArrayAdapter<Module> {


    private ArrayList<Module> modulesList;
    private Context context;
    private TextView tvModuleCode;
    private TextView tvModuleName;


    public ModulesAdapter(Context context, int resource,
                       ArrayList<Module> objects) {
        super(context, resource, objects);

        modulesList = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.mainactivityrow, parent,
                false);

        tvModuleCode = rowView.findViewById(R.id.tvModuleCode);
        tvModuleName = rowView.findViewById(R.id.tvModuleName);

        Module currentModule = modulesList.get(position);

        tvModuleCode.setText(currentModule.getModuleCode());
        tvModuleName.setText(currentModule.getModuleName());

        return rowView;
    }
}

