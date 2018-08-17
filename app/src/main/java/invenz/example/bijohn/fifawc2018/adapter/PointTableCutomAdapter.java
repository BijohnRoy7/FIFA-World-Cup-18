package invenz.example.bijohn.fifawc2018.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bijohn.fifawc2018.R;
import invenz.example.bijohn.fifawc2018.SelectedLanguage;
import invenz.example.bijohn.fifawc2018.model.PointTable;

import java.util.List;

public class PointTableCutomAdapter extends BaseAdapter{

    private Context context;
    private List<List<PointTable>> listOfPointTableLists;

    public PointTableCutomAdapter(Context context, List<List<PointTable>> listOfPointTableLists) {
        this.context = context;
        this.listOfPointTableLists = listOfPointTableLists;


    }

    @Override
    public int getCount() {
        //Log.d("ROY1", "getCount: "+listOfPointTableLists.size());
        return listOfPointTableLists.size();
    }

    @Override
    public Object getItem(int position) {
        Log.d("ROY", "getItem: YYY: "+listOfPointTableLists.get(position));
        return listOfPointTableLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.single_point_table, parent, false);
        }

        Log.d("ROY123", "getView: "+listOfPointTableLists.get(position));

        List<PointTable> singlePointTableList = listOfPointTableLists.get(position);



        TextView tv1 = convertView.findViewById(R.id.id1_PT);
        TextView tv2 = convertView.findViewById(R.id.id2_PT);
        TextView tv3 = convertView.findViewById(R.id.id3_PT);
        TextView tv4 = convertView.findViewById(R.id.id4_PT);

        TextView tvMatchP = convertView.findViewById(R.id.idMatch_PT);
        TextView tvWin = convertView.findViewById(R.id.idWin_PT);
        TextView tvLost = convertView.findViewById(R.id.idLost_PT);
        TextView tvDraw = convertView.findViewById(R.id.idDraw_PT);
        TextView tvGoalDif = convertView.findViewById(R.id.idGD_PT);
        TextView tvPointsG = convertView.findViewById(R.id.idPts_PT);


        PointTable team1 = singlePointTableList.get(0);
        PointTable team2 = singlePointTableList.get(1);
        PointTable team3 = singlePointTableList.get(2);
        PointTable team4 = singlePointTableList.get(3);


        TextView tvGroupName = convertView.findViewById(R.id.idGroupName_group);

        /*#################### English Language #############################*/
        if (SelectedLanguage.lang.equals("english")){

            tv1.setText("1");
            tv2.setText("2");
            tv3.setText("3");
            tv4.setText("4");

            tvMatchP.setText("Mp");
            tvWin.setText("W");
            tvLost.setText("L");
            tvDraw.setText("D");
            tvGoalDif.setText("Gd");
            tvPointsG.setText("Pts");

            if (position==0){
                tvGroupName.setText("Group A");
            }
            if (position==1){
                tvGroupName.setText("Group B");
            }
            if (position==2){
                tvGroupName.setText("Group C");
            }
            if (position==3){
                tvGroupName.setText("Group D");
            }
            if (position==4){
                tvGroupName.setText("Group E");
            }
            if (position==5){
                tvGroupName.setText("Group F");
            }
            if (position==6){
                tvGroupName.setText("Group G");
            }
            if (position==7){
                tvGroupName.setText("Group H");
            }

        }
        /*########################### Bangla Language ###################################*/
        else
        {
            if (position==0){
                tvGroupName.setText("গ্রুপ এ");
            }
            if (position==1){
                tvGroupName.setText("গ্রুপ বি");
            }
            if (position==2){
                tvGroupName.setText("গ্রুপ সি");
            }
            if (position==3){
                tvGroupName.setText("গ্রুপ ডি");
            }
            if (position==4){
                tvGroupName.setText("গ্রুপ ই");
            }
            if (position==5){
                tvGroupName.setText("গ্রুপ এফ");
            }
            if (position==6){
                tvGroupName.setText("গ্রুপ জি");
            }
            if (position==7){
                tvGroupName.setText("গ্রুপ এইচ");
            }

        }



        //team1
        TextView tvTeamname1 = convertView.findViewById(R.id.idTeam1_pointTable);
        TextView tvMatchPlayed1 = convertView.findViewById(R.id.idMatchPlayed_PointTable);
        TextView tvMatchWon1 = convertView.findViewById(R.id.idMatchWin_PointTable);
        TextView tvMatchLost1 = convertView.findViewById(R.id.idMatchLost_PointTable);
        TextView tvMatchDrawn1 = convertView.findViewById(R.id.idDrawnPlayed_PointTable);
        TextView tvGoalDif1 = convertView.findViewById(R.id.idGoalDiff_PointTable);
        TextView tvPoints1 = convertView.findViewById(R.id.idMatchPoints_PointTable);

        tvTeamname1.setText(team1.getName());
        tvMatchPlayed1.setText(team1.getMp());
        tvMatchWon1.setText(team1.getW());
        tvMatchLost1.setText(team1.getL());
        tvMatchDrawn1.setText(team1.getD());
        tvGoalDif1.setText(team1.getGdBangla());
        tvPoints1.setText(team1.getPtsBangla());


        tvMatchPlayed1.setTextSize(14);
        tvMatchWon1.setTextSize(14);
        tvMatchLost1.setTextSize(14);
        tvMatchDrawn1.setTextSize(14);
        tvGoalDif1.setTextSize(14);
        tvPoints1.setTextSize(14);

        //team2
        TextView tvTeamname2 = convertView.findViewById(R.id.idTeam2_pointTable);
        TextView tvMatchPlayed2 = convertView.findViewById(R.id.id2MatchPlayed_PointTable);
        TextView tvMatchWon2 = convertView.findViewById(R.id.id2MatchWin_PointTable);
        TextView tvMatchLost2 = convertView.findViewById(R.id.id2MatchLost_PointTable);
        TextView tvMatchDrawn2 = convertView.findViewById(R.id.id2DrawnPlayed_PointTable);
        TextView tvGoalDif2 = convertView.findViewById(R.id.id2GoalDiff_PointTable);
        TextView tvPoints2 = convertView.findViewById(R.id.id2MatchPoints_PointTable);

        tvTeamname2.setText(team2.getName());
        tvMatchPlayed2.setText(team2.getMp());
        tvMatchWon2.setText(team2.getW());
        tvMatchLost2.setText(team2.getL());
        tvMatchDrawn2.setText(team2.getD());
        tvGoalDif2.setText(team2.getGdBangla());
        tvPoints2.setText(team2.getPtsBangla());

        tvMatchPlayed2.setTextSize(14);
        tvMatchWon2.setTextSize(14);
        tvMatchLost2.setTextSize(14);
        tvMatchDrawn2.setTextSize(14);
        tvGoalDif2.setTextSize(14);
        tvPoints2.setTextSize(14);


        //team3
        TextView tvTeamname3 = convertView.findViewById(R.id.idTeam3_pointTable);
        TextView tvMatchPlayed3 = convertView.findViewById(R.id.id3MatchPlayed_PointTable);
        TextView tvMatchWon3 = convertView.findViewById(R.id.id3MatchWin_PointTable);
        TextView tvMatchLost3 = convertView.findViewById(R.id.id3MatchLost_PointTable);
        TextView tvMatchDrawn3 = convertView.findViewById(R.id.id3DrawnPlayed_PointTable);
        TextView tvGoalDif3 = convertView.findViewById(R.id.id3GoalDiff_PointTable);
        TextView tvPoints3 = convertView.findViewById(R.id.id3MatchPoints_PointTable);

        tvTeamname3.setText(team3.getName());
        tvMatchPlayed3.setText(team3.getMp());
        tvMatchWon3.setText(team3.getW());
        tvMatchLost3.setText(team3.getL());
        tvMatchDrawn3.setText(team3.getD());
        tvGoalDif3.setText(team3.getGdBangla());
        tvPoints3.setText(team3.getPtsBangla());

        tvMatchPlayed3.setTextSize(14);
        tvMatchWon3.setTextSize(14);
        tvMatchLost3.setTextSize(14);
        tvMatchDrawn3.setTextSize(14);
        tvGoalDif3.setTextSize(14);
        tvPoints3.setTextSize(14);



        //team3
        TextView tvTeamname4 = convertView.findViewById(R.id.idTeam4_pointTable);
        TextView tvMatchPlayed4 = convertView.findViewById(R.id.id4MatchPlayed_PointTable);
        TextView tvMatchWon4 = convertView.findViewById(R.id.id4MatchWin_PointTable);
        TextView tvMatchLost4 = convertView.findViewById(R.id.id4MatchLost_PointTable);
        TextView tvMatchDrawn4 = convertView.findViewById(R.id.id4DrawnPlayed_PointTable);
        TextView tvGoalDif4 = convertView.findViewById(R.id.id4GoalDiff_PointTable);
        TextView tvPoints4 = convertView.findViewById(R.id.id4MatchPoints_PointTable);

        tvTeamname4.setText(team4.getName());
        tvMatchPlayed4.setText(team4.getMp());
        tvMatchWon4.setText(team4.getW());
        tvMatchLost4.setText(team4.getL());
        tvMatchDrawn4.setText(team4.getD());
        tvGoalDif4.setText(team4.getGdBangla());
        tvPoints4.setText(team4.getPtsBangla());

        tvMatchPlayed4.setTextSize(14);
        tvMatchWon4.setTextSize(14);
        tvMatchLost4.setTextSize(14);
        tvMatchDrawn4.setTextSize(14);
        tvGoalDif4.setTextSize(14);
        tvPoints4.setTextSize(14);


        return convertView;
    }
}
