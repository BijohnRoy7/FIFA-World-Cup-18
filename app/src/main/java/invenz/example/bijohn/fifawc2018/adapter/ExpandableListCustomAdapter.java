package invenz.example.bijohn.fifawc2018.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.bijohn.fifawc2018.R;
import invenz.example.bijohn.fifawc2018.SelectedLanguage;
import invenz.example.bijohn.fifawc2018.model.Match;

import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ExpandableListCustomAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listDataHeader;
    private HashMap<String, List<Match>> listHashmap;

    public ExpandableListCustomAdapter(Context context, List<String> listDataHeader, HashMap<String, List<Match>> listHashmap) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listHashmap = listHashmap;
    }

    @Override
    public int getGroupCount() {
        return listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listHashmap.get(listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listHashmap.get(listDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    /*############ SHOwING THE HEADER ##################*/
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String headerTitle = (String) getGroup(groupPosition);

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_group, null);
        }


            TextView listHeader = convertView.findViewById(R.id.idGroupHeader);
            listHeader.setText(headerTitle);

        return convertView;
    }


    /*#################### SHOWING THE CHILDREN ####################*/
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        Match match = (Match) getChild(groupPosition, childPosition);
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        if (SelectedLanguage.lang.equals("english")){
            TextView tvVirsus = convertView.findViewById(R.id.idVirsus_listItem);
            tvVirsus.setText("Vs");
        }

        TextView tvTeam1 = convertView.findViewById(R.id.idTeam1);
        TextView tvTeam2 = convertView.findViewById(R.id.idTeam2);
        TextView tvTime = convertView.findViewById(R.id.idTime);
        TextView tvStadium = convertView.findViewById(R.id.idStadium);
        TextView tvMatchNo = convertView.findViewById(R.id.idMatchNo);

        CircleImageView team1Img = convertView.findViewById(R.id.idTeam1Img);
        CircleImageView team2Img = convertView.findViewById(R.id.idTeam2Img);

        team1Img.setImageResource(match.getTeam1Img());
        team2Img.setImageResource(match.getTeam2Img());


        tvMatchNo.setText(match.getMatchNo());
        tvTeam1.setText(match.getTeam1());
        tvTeam2.setText(match.getTeam2());
        tvTime.setText(match.getTime());
        tvStadium.setText(match.getStadium());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }



}
