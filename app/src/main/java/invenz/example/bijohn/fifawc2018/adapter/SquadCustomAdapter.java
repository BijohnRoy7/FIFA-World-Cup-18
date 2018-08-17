package invenz.example.bijohn.fifawc2018.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bijohn.fifawc2018.R;

public class SquadCustomAdapter extends BaseAdapter {

    private Context context;
    private String[] squad;

    public SquadCustomAdapter(Context context, String[] squad) {
        this.context = context;
        this.squad = squad;
    }

    @Override
    public int getCount() {
        return squad.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView ==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.single_text_squad, parent, false);
        }

        TextView text = convertView.findViewById(R.id.idName_singleSquad);

        if (squad[position].equals("গোলরক্ষক") || squad[position].equals("ডিফেন্ডার") || squad[position].equals("মিডফিল্ডার") ||squad[position].equals("স্ট্রাইকার")){
            text.setText(squad[position]);
            text.setTextSize(24);
        }else {
            text.setText(squad[position]);
            text.setTextSize(18);
        }
        return convertView;
    }
}
