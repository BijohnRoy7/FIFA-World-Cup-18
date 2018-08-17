package invenz.example.bijohn.fifawc2018.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bijohn.fifawc2018.R;
import invenz.example.bijohn.fifawc2018.model.Group;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class GroupCustomAdapter extends BaseAdapter {

    private Context context;
    private List<Group> groups;

    private String teamName;
    private Dialog dialogSquad;
    private ListView listViewSquad;
    private SquadCustomAdapter squadCustomAdapter;

    public GroupCustomAdapter(Context context, List<Group> groups) {
        this.context = context;
        this.groups = groups;
    }

    @Override
    public int getCount() {
        return groups.size();
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
    public View getView(int position, View convertView, final ViewGroup parent) {

        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.single_group,parent,false);
        }

        Group group = groups.get(position);
        final TextView tvTeam1 = convertView.findViewById(R.id.idTeam1_group);
        final TextView tvTeam2 = convertView.findViewById(R.id.idTeam2_group);
        final TextView tvTeam3 = convertView.findViewById(R.id.idTeam3_group);
        final TextView tvTeam4 = convertView.findViewById(R.id.idTeam4_group);
        TextView tvGrpName = convertView.findViewById(R.id.idGroupName_group);

        CircleImageView team1Img = convertView.findViewById(R.id.idTeam1Img_group);
        CircleImageView team2Img = convertView.findViewById(R.id.idTeam2Img_group);
        CircleImageView team3Img = convertView.findViewById(R.id.idTeam3Img_group);
        CircleImageView team4Img = convertView.findViewById(R.id.idTeam4Img_group);

        tvTeam1.setText(group.getTeam1());
        tvTeam2.setText(group.getTeam2());
        tvTeam3.setText(group.getTeam3());
        tvTeam4.setText(group.getTeam4());
        tvGrpName.setText(group.getGroupName());

        team1Img.setImageResource(group.getTeam1Img());
        team2Img.setImageResource(group.getTeam2Img());
        team3Img.setImageResource(group.getTeam3Img());
        team4Img.setImageResource(group.getTeam4Img());


        /*###################### ON CLICK LISTENER FOR SUB ITEMS ########################*/

        dialogSquad = new Dialog(context);
        Window window = dialogSquad.getWindow();
        //window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        window.setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        dialogSquad.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        //WHEN 1ST TEAM IS CLICKED
        tvTeam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, ""+tvTeam1.getText().toString(), Toast.LENGTH_SHORT).show();


                if (tvTeam1.getText().toString().equals("রাশিয়া")){
                    teamName = "rus";
                }

                if (tvTeam1.getText().toString().equals("পর্তুগাল")){
                    teamName = "por";
                }

                if (tvTeam1.getText().toString().equals("ফ্রান্স")){
                    teamName = "fra";
                }

                if (tvTeam1.getText().toString().equals("আর্জেন্টিনা")){
                    teamName = "arg";
                }

                if (tvTeam1.getText().toString().equals("ব্রাজিল")){
                    teamName = "brazil";
                }

                if (tvTeam1.getText().toString().equals("জার্মানি")){
                    teamName = "ger";
                }

                if (tvTeam1.getText().toString().equals("বেলজিয়াম")){
                    teamName = "bel";
                }

                if (tvTeam1.getText().toString().equals("পোল্যান্ড")){
                    teamName = "pol";
                }

                //For english names
                if (tvTeam1.getText().toString().equals("Russia")){
                    teamName = "rus_e";
                }

                if (tvTeam1.getText().toString().equals("Portugal")){
                    teamName = "por_e";
                }

                if (tvTeam1.getText().toString().equals("France")){
                    teamName = "fra_e";
                }

                if (tvTeam1.getText().toString().equals("Argentina")){
                    teamName = "arg_e";
                }

                if (tvTeam1.getText().toString().equals("Brazil")){
                    teamName = "brazil_e";
                }

                if (tvTeam1.getText().toString().equals("Germany")){
                    teamName = "ger_e";
                }

                if (tvTeam1.getText().toString().equals("Belgium")){
                    teamName = "bel_e";
                }

                if (tvTeam1.getText().toString().equals("Poland")){
                    teamName = "pol_e";
                }

                //Log.d("ROY", "onClick1(GroupCustomAdapter): "+teamName);

                int mystring = context.getResources().getIdentifier(teamName,"array",context.getPackageName());
                String[] team = context.getResources().getStringArray(mystring);

                //Toast.makeText(context, ""+mystring, Toast.LENGTH_SHORT).show();
                //Toast.makeText(context, ""+team[0], Toast.LENGTH_SHORT).show();

                /*################# CREATING DIALOG #########################*/
                dialogSquad.setContentView(R.layout.squad_dialog);

                TextView teamNameInSquadDialog = dialogSquad.findViewById(R.id.idTeamName_squadDialog);
                TextView crossInSquadDialog = dialogSquad.findViewById(R.id.idCross_squadDialog);

                teamNameInSquadDialog.setText(tvTeam1.getText().toString());

                //WHEN CROSS BUTTON IS CLICKED
                crossInSquadDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogSquad.dismiss();
                    }
                });

                dialogSquad.show();

                //Showing squad in listview
                listViewSquad = dialogSquad.findViewById(R.id.idSquadListView_squadDialog);
                squadCustomAdapter = new SquadCustomAdapter(context, team);
                listViewSquad.setAdapter(squadCustomAdapter);


                /*########################################*/


            }
        });




        //WHEN 2ND TEAM IS CLICKED
        tvTeam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, ""+tvTeam2.getText().toString(), Toast.LENGTH_SHORT).show();

                if (tvTeam2.getText().toString().equals("সৌদি আরব")){
                    teamName = "sou";
                }

                if (tvTeam2.getText().toString().equals("স্পেন")){
                    teamName = "esp";
                }

                if (tvTeam2.getText().toString().equals("অস্ট্রেলিয়া")){
                    teamName = "aus";
                }

                if (tvTeam2.getText().toString().equals("আইসল্যান্ড")){
                    teamName = "ice";
                }

                if (tvTeam2.getText().toString().equals("সুইজারল্যান্ড")){
                    teamName = "swit";
                }

                if (tvTeam2.getText().toString().equals("মেক্সিকো")){
                    teamName = "mex";
                }

                if (tvTeam2.getText().toString().equals("পানামা")){
                    teamName = "pan";
                }

                if (tvTeam2.getText().toString().equals("সেনেগাল")){
                    teamName = "sen";
                }


                //English
                if (tvTeam2.getText().toString().equals("Soudi Arab")){
                    teamName = "sou_e";
                }

                if (tvTeam2.getText().toString().equals("Spain")){
                    teamName = "esp_e";
                }

                if (tvTeam2.getText().toString().equals("Australia")){
                    teamName = "aus_e";
                }

                if (tvTeam2.getText().toString().equals("Iceland")){
                    teamName = "ice_e";
                }

                if (tvTeam2.getText().toString().equals("Switzerland")){
                    teamName = "swit_e";
                }

                if (tvTeam2.getText().toString().equals("Mexico")){
                    teamName = "mex_e";
                }

                if (tvTeam2.getText().toString().equals("Panama")){
                    teamName = "pan_e";
                }

                if (tvTeam2.getText().toString().equals("Senegal")){
                    teamName = "sen_e";
                }

                int mystring = context.getResources().getIdentifier(teamName,"array",context.getPackageName());
                String[] team = context.getResources().getStringArray(mystring);

                //Toast.makeText(context, ""+mystring, Toast.LENGTH_SHORT).show();
                //Toast.makeText(context, ""+team[0], Toast.LENGTH_SHORT).show();


                /*################# CREATING DIALOG #########################*/
                dialogSquad.setContentView(R.layout.squad_dialog);

                TextView teamNameInSquadDialog = dialogSquad.findViewById(R.id.idTeamName_squadDialog);
                TextView crossInSquadDialog = dialogSquad.findViewById(R.id.idCross_squadDialog);

                teamNameInSquadDialog.setText(tvTeam2.getText().toString());

                //WHEN CROSS BUTTON IS CLICKED
                crossInSquadDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogSquad.dismiss();
                    }
                });

                dialogSquad.show();

                //Showing squad in listview
                listViewSquad = dialogSquad.findViewById(R.id.idSquadListView_squadDialog);
                squadCustomAdapter = new SquadCustomAdapter(context, team);
                listViewSquad.setAdapter(squadCustomAdapter);

            }
        });


        //WHEN 3RD TEAM IS CLICKED
        tvTeam3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, ""+tvTeam3.getText().toString(), Toast.LENGTH_SHORT).show();

                if (tvTeam3.getText().toString().equals("মিসর")){
                    teamName = "egp";
                }

                if (tvTeam3.getText().toString().equals("মরক্কো")){
                    teamName = "moro";
                }

                if (tvTeam3.getText().toString().equals("পেরু")){
                    teamName = "per";
                }

                if (tvTeam3.getText().toString().equals("ক্রোয়েশিয়া")){
                    teamName = "cro";
                }

                if (tvTeam3.getText().toString().equals("কোস্টারিকা")){
                    teamName = "cos";
                }

                if (tvTeam3.getText().toString().equals("সুইডেন")){
                    teamName = "swi";
                }

                if (tvTeam3.getText().toString().equals("তিউনিসিয়া")){
                    teamName = "tun";
                }

                if (tvTeam3.getText().toString().equals("কলোম্বিয়া")){
                    teamName = "col";
                }

                //eng
                if (tvTeam3.getText().toString().equals("Egypt")){
                    teamName = "egp_e";
                }

                if (tvTeam3.getText().toString().equals("Morocco")){
                    teamName = "moro_e";
                }

                if (tvTeam3.getText().toString().equals("Peru")){
                    teamName = "per_e";
                }

                if (tvTeam3.getText().toString().equals("Croatia")){
                    teamName = "cro_e";
                }

                if (tvTeam3.getText().toString().equals("Costa Rica")){
                    teamName = "cos_e";
                }

                if (tvTeam3.getText().toString().equals("Sweden")){
                    teamName = "swi_e";
                }

                if (tvTeam3.getText().toString().equals("Tunisia")){
                    teamName = "tun_e";
                }

                if (tvTeam3.getText().toString().equals("Colombia")){
                    teamName = "col_e";
                }


                int mystring = context.getResources().getIdentifier(teamName,"array",context.getPackageName());
                String[] team = context.getResources().getStringArray(mystring);

                //Toast.makeText(context, ""+mystring, Toast.LENGTH_SHORT).show();
                //Toast.makeText(context, ""+team[0], Toast.LENGTH_SHORT).show();


                /*################# CREATING DIALOG #########################*/
                dialogSquad.setContentView(R.layout.squad_dialog);

                TextView teamNameInSquadDialog = dialogSquad.findViewById(R.id.idTeamName_squadDialog);
                TextView crossInSquadDialog = dialogSquad.findViewById(R.id.idCross_squadDialog);

                teamNameInSquadDialog.setText(tvTeam3.getText().toString());

                //WHEN CROSS BUTTON IS CLICKED
                crossInSquadDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogSquad.dismiss();
                    }
                });

                dialogSquad.show();

                //Showing squad in listview
                listViewSquad = dialogSquad.findViewById(R.id.idSquadListView_squadDialog);
                squadCustomAdapter = new SquadCustomAdapter(context, team);
                listViewSquad.setAdapter(squadCustomAdapter);

            }
        });



        //WHEN 4TH TEAM IS CLICKED
        tvTeam4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, ""+tvTeam4.getText().toString(), Toast.LENGTH_SHORT).show();

                if (tvTeam4.getText().toString().equals("উরুগুয়ে")){
                    teamName = "uru";
                }

                if (tvTeam4.getText().toString().equals("ইরান")){
                    teamName = "ira";
                }

                if (tvTeam4.getText().toString().equals("ডেনমার্ক")){
                    teamName = "den";
                }

                if (tvTeam4.getText().toString().equals("নাইজেরিয়া")){
                    teamName = "nig";
                }

                if (tvTeam4.getText().toString().equals("সার্বিয়া")){
                    teamName = "ser";
                }

                if (tvTeam4.getText().toString().equals("দঃ কোরিয়া")){
                    teamName = "kor";
                }

                if (tvTeam4.getText().toString().equals("ইংল্যান্ড")){
                    teamName = "eng";
                }

                if (tvTeam4.getText().toString().equals("জাপান")){
                    teamName = "jap";
                }

                //eng

                if (tvTeam4.getText().toString().equals("Uruguay")){
                    teamName = "uru_e";
                }

                if (tvTeam4.getText().toString().equals("Iran")){
                    teamName = "ira_e";
                }

                if (tvTeam4.getText().toString().equals("Denmark")){
                    teamName = "den_e";
                }

                if (tvTeam4.getText().toString().equals("Nigeria")){
                    teamName = "nig_e";
                }

                if (tvTeam4.getText().toString().equals("Serbia")){
                    teamName = "ser_e";
                }

                if (tvTeam4.getText().toString().equals("Korea Republic")){
                    teamName = "kor_e";
                }

                if (tvTeam4.getText().toString().equals("England")){
                    teamName = "eng_e";
                }

                if (tvTeam4.getText().toString().equals("Japan")){
                    teamName = "jap_e";
                }


                int mystring = context.getResources().getIdentifier(teamName,"array",context.getPackageName());
                String[] team = context.getResources().getStringArray(mystring);

                //Toast.makeText(context, ""+mystring, Toast.LENGTH_SHORT).show();
                //Toast.makeText(context, ""+team[0], Toast.LENGTH_SHORT).show();


                /*################# CREATING DIALOG #########################*/
                dialogSquad.setContentView(R.layout.squad_dialog);

                TextView teamNameInSquadDialog = dialogSquad.findViewById(R.id.idTeamName_squadDialog);
                TextView crossInSquadDialog = dialogSquad.findViewById(R.id.idCross_squadDialog);

                teamNameInSquadDialog.setText(tvTeam4.getText().toString());

                //WHEN CROSS BUTTON IS CLICKED
                crossInSquadDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogSquad.dismiss();
                    }
                });

                dialogSquad.show();

                //Showing squad in listview
                listViewSquad = dialogSquad.findViewById(R.id.idSquadListView_squadDialog);
                squadCustomAdapter = new SquadCustomAdapter(context, team);
                listViewSquad.setAdapter(squadCustomAdapter);
            }
        });


        return convertView;
    }
}
