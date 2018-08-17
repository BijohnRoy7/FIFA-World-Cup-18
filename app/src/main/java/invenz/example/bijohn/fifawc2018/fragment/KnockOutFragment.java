package invenz.example.bijohn.fifawc2018.fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import invenz.example.bijohn.fifawc2018.IsInternetConnected;
import invenz.example.bijohn.fifawc2018.SelectedLanguage;
import invenz.example.bijohn.fifawc2018.adapter.ExpandableListCustomAdapter;
import com.example.bijohn.fifawc2018.R;
import invenz.example.bijohn.fifawc2018.model.Match;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * A simple {@link Fragment} subclass.
 */
public class KnockOutFragment extends Fragment {

    private FirebaseFirestore firestore;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressDialog progressDialog;
    private TextView tvConnectNet, tvHeading;
    private LinearLayout linearLayoutHeading;
    private ExpandableListCustomAdapter customAdapter;
    private ExpandableListView expandableListView;
    private List<String> listDataHeader;
    private HashMap<String, List<Match>> listHash;
    private SharedPreferences sharedPreferences1;


    public KnockOutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_knock_out, container, false);
        expandableListView = view.findViewById(R.id.idExListView_knockout);
        tvHeading = view.findViewById(R.id.idHeading_knockOutFrag);

        firestore = FirebaseFirestore.getInstance();
        tvConnectNet = view.findViewById(R.id.idPleaseConnectNet_knock);
        swipeRefreshLayout = view.findViewById(R.id.idSwipeLayout_knock);
        linearLayoutHeading = view.findViewById(R.id.idHeading_knock);

        sharedPreferences1 = getContext().getSharedPreferences("languageSharedPref", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences1.edit();

        listDataHeader= new ArrayList<>();
        listHash = new HashMap<>();



        /*################ WHEN FRAGMENT IS SWIPED DOWN , PAGE WILL REFRESH ##########################*/
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //Toast.makeText(getContext(), "Refreshed", Toast.LENGTH_SHORT).show();
                setUserVisibleHint1(true);
            }
        });

        IsInternetConnected isInternetConnected = new IsInternetConnected();

        if (isInternetConnected.isConnected(getActivity())){

            progressDialog = new ProgressDialog(getContext());
            progressDialog.setTitle("Getting Data");
            progressDialog.setMessage("Please Wait...");
            progressDialog.setCancelable(true);
            progressDialog.show();
        }


        /*########################## If Internet is connected #######################################*/
        if (isInternetConnected.isConnected(getActivity())) {


            /*#################### WHEN ENGLISH LANGUAGE IS SELECTED ###########################*/
            if (SelectedLanguage.lang.equals("english")) {

                tvHeading.setText("KnockOut Matches");

                String[] date = getResources().getStringArray(R.array.knockout_dates_eng);
                for (String matchDate : date) {
                    listDataHeader.add(matchDate);
                }

                firestore.collection("knockOutTeams").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {


                            Map<String, Object> dataMap = new HashMap<>();
                            ArrayList<String> teamList = new ArrayList<>();
                            ArrayList<String> teamListB = new ArrayList<>();


                            //Log.d("ROY", "onComplete: "+task.getResult());

                            for (DocumentSnapshot doc : task.getResult()) {

                                //Log.d("ROY", "onComplete: "+doc.getData());
                                dataMap = doc.getData();
                                //######### adding data into arraylist ###############
                                teamList.add(dataMap.get("name").toString());
                                teamListB.add(dataMap.get("nameE").toString());

                            }

                            Log.d("ROY", "onComplete: " + teamListB);
                            Log.d("ROY", "onComplete: " + teamList);




                            //Set<String> set = new HashSet<>();
                            //Log.d("ROY", "onComplete3: "+sharedPreferences1.getStringSet("teamList",null).size());
                            /////////////////////////////////////


                            String[] teams = new String[teamList.size()];
                            String[] teamBs = new String[teamListB.size()];

                            //############## converting arrylist into array ##################
                            teams = teamList.toArray(teams);
                            teamBs = teamListB.toArray(teamBs);

                            //Log.d("ROY1", "onComplete: "+teams.length);

                            for (int i=0; i<teams.length;i++){
                                editor.putString("teams"+i, teams[i]);
                            }


                            for (int i=0; i<teamBs.length;i++){
                                editor.putString("teamBs"+i, teamBs[i]);
                            }
                            editor.apply();
                            editor.commit();

                            Log.d("ROY1", "onComplete: "+sharedPreferences1.getString("teams5", null));
                            Log.d("ROY1", "onComplete: "+sharedPreferences1.getString("teamBs5", null));

                            //Log.d("ROY", "onComplete: "+dataMap.get("name"));

                            for (int j = 0; j < 32; j++) {
                                //Log.d("ROY222", "onComplete: "+teams[j]);
                                //Log.d("ROY222", "onComplete: "+teamBs[j]);
                            }

                            String[] matchNo = getResources().getStringArray(R.array.knockout_match_e);


                            //30 -16 (2nd round)
                            Match match49 = new Match(teamBs[0], teamBs[1], getResources().getString(R.string.eight_e), getResources().getString(R.string.kazan_Arena_e), matchNo[0], getResources().getIdentifier(teams[0], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[1], "drawable", getContext().getPackageName()));
                            Match match50 = new Match(teamBs[2], teamBs[3], getResources().getString(R.string.twelve_e), getResources().getString(R.string.fisht_Stadium_e), matchNo[1], getResources().getIdentifier(teams[2], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[3], "drawable", getContext().getPackageName()));

                            //1 -17
                            Match match51 = new Match(teamBs[4], teamBs[5], getResources().getString(R.string.eight_e), getResources().getString(R.string.luzhniki_Stadium_e), matchNo[2], getResources().getIdentifier(teams[4], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[5], "drawable", getContext().getPackageName()));
                            Match match52 = new Match(teamBs[6], teamBs[7], getResources().getString(R.string.twelve_e), getResources().getString(R.string.nizhny_Novgorod_Stadium_e), matchNo[3], getResources().getIdentifier(teams[6], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[7], "drawable", getContext().getPackageName()));


                            //2 -18
                            Match match53 = new Match(teamBs[8], teamBs[9], getResources().getString(R.string.eight_e), getResources().getString(R.string.samara_Arena_e), matchNo[4], getResources().getIdentifier(teams[8], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[9], "drawable", getContext().getPackageName()));
                            Match match54 = new Match(teamBs[10], teamBs[11], getResources().getString(R.string.twelve_e), getResources().getString(R.string.rostov_Arena_e), matchNo[5], getResources().getIdentifier(teams[10], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[11], "drawable", getContext().getPackageName()));


                            //3 -19
                            Match match55 = new Match(teamBs[12], teamBs[13], getResources().getString(R.string.eight_e), getResources().getString(R.string.saint_Petersburg_Stadium_e), matchNo[6], getResources().getIdentifier(teams[12], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[13], "drawable", getContext().getPackageName()));
                            Match match56 = new Match(teamBs[14], teamBs[15], getResources().getString(R.string.twelve_e), getResources().getString(R.string.spartak_Stadium_e), matchNo[7], getResources().getIdentifier(teams[14], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[15], "drawable", getContext().getPackageName()));


                            //6 -20 (cuarter)
                            Match match57 = new Match(teamBs[16], teamBs[17], getResources().getString(R.string.eight_e), getResources().getString(R.string.nizhny_Novgorod_Stadium_e), matchNo[8], getResources().getIdentifier(teams[16], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[17], "drawable", getContext().getPackageName()));
                            Match match58 = new Match(teamBs[18], teamBs[19], getResources().getString(R.string.twelve_e), getResources().getString(R.string.kazan_Arena_e), matchNo[9], getResources().getIdentifier(teams[18], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[19], "drawable", getContext().getPackageName()));

                            //7 -21
                            Match match59 = new Match(teamBs[20], teamBs[21], getResources().getString(R.string.eight_e), getResources().getString(R.string.samara_Arena_e), matchNo[10], getResources().getIdentifier(teams[20], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[21], "drawable", getContext().getPackageName()));
                            Match match60 = new Match(teamBs[22], teamBs[23], getResources().getString(R.string.twelve_e), getResources().getString(R.string.fisht_Stadium_e), matchNo[11], getResources().getIdentifier(teams[22], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[23], "drawable", getContext().getPackageName()));


                            //10 -22(semi)
                            Match match61 = new Match(teamBs[24], teamBs[25], getResources().getString(R.string.twelve_e), getResources().getString(R.string.saint_Petersburg_Stadium_e), matchNo[12], getResources().getIdentifier(teams[24], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[25], "drawable", getContext().getPackageName()));

                            //11 -23
                            Match match62 = new Match(teamBs[26], teamBs[27], getResources().getString(R.string.twelve_e), getResources().getString(R.string.luzhniki_Stadium_e), matchNo[13], getResources().getIdentifier(teams[26], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[27], "drawable", getContext().getPackageName()));

                            //14 -24
                            Match match63 = new Match(teamBs[28], teamBs[29], getResources().getString(R.string.eight_e), getResources().getString(R.string.saint_Petersburg_Stadium_e), matchNo[14], getResources().getIdentifier(teams[28], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[29], "drawable", getContext().getPackageName()));

                            //15 -25
                            Match match64 = new Match(teamBs[30], teamBs[31], getResources().getString(R.string.nine_e), getResources().getString(R.string.luzhniki_Stadium_e), matchNo[15], getResources().getIdentifier(teams[30], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[31], "drawable", getContext().getPackageName()));


                            List<Match> matchDay16List = new ArrayList<>();
                            matchDay16List.add(match49);
                            matchDay16List.add(match50);

                            List<Match> matchDay17List = new ArrayList<>();
                            matchDay17List.add(match51);
                            matchDay17List.add(match52);

                            List<Match> matchDay18List = new ArrayList<>();
                            matchDay18List.add(match53);
                            matchDay18List.add(match54);

                            List<Match> matchDay19List = new ArrayList<>();
                            matchDay19List.add(match55);
                            matchDay19List.add(match56);

                            List<Match> matchDay20List = new ArrayList<>();
                            matchDay20List.add(match57);
                            matchDay20List.add(match58);

                            List<Match> matchDay21List = new ArrayList<>();
                            matchDay21List.add(match59);
                            matchDay21List.add(match60);

                            List<Match> matchDay22List = new ArrayList<>();
                            matchDay22List.add(match61);

                            List<Match> matchDay23List = new ArrayList<>();
                            matchDay23List.add(match62);

                            List<Match> matchDay24List = new ArrayList<>();
                            matchDay24List.add(match63);

                            List<Match> matchDay25List = new ArrayList<>();
                            matchDay25List.add(match64);


                            listHash.put(listDataHeader.get(0), matchDay16List);
                            listHash.put(listDataHeader.get(1), matchDay17List);
                            listHash.put(listDataHeader.get(2), matchDay18List);
                            listHash.put(listDataHeader.get(3), matchDay19List);

                            listHash.put(listDataHeader.get(4), matchDay20List);
                            listHash.put(listDataHeader.get(5), matchDay21List);

                            listHash.put(listDataHeader.get(6), matchDay22List);
                            listHash.put(listDataHeader.get(7), matchDay23List);
                            listHash.put(listDataHeader.get(8), matchDay24List);
                            listHash.put(listDataHeader.get(9), matchDay25List);


                            customAdapter = new ExpandableListCustomAdapter(getContext(), listDataHeader, listHash);
                            expandableListView.setAdapter(customAdapter);
                            progressDialog.dismiss();

                        } else {
                            Log.d("ROY", "KnockoutFragment(onComplete): " + task.getException());
                        }

                    }
                });



            } else {

                tvHeading.setText("নকআউট পর্বের সময়সূচী");

                String[] date = getResources().getStringArray(R.array.knockout_dates);
                for (String matchDate : date) {
                    listDataHeader.add(matchDate);
                }

                firestore.collection("knockOutTeams").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {


                            Map<String, Object> dataMap = new HashMap<>();
                            ArrayList<String> teamList = new ArrayList<>();
                            ArrayList<String> teamListB = new ArrayList<>();

                            //Log.d("ROY", "onComplete: "+task.getResult());

                            for (DocumentSnapshot doc : task.getResult()) {

                                //Log.d("ROY", "onComplete: "+doc.getData());
                                dataMap = doc.getData();
                                //######### adding data into arraylist ###############
                                teamList.add(dataMap.get("name").toString());
                                teamListB.add(dataMap.get("nameB").toString());

                            }

                            Log.d("ROY", "onComplete: " + teamListB);
                            Log.d("ROY", "onComplete: " + teamList);

                            Log.d("ROY", "onComplete: " + teamList.size());


                            String[] teams = new String[teamList.size()];
                            String[] teamBs = new String[teamListB.size()];

                            //############## converting arrylist into array ##################
                            teams = teamList.toArray(teams);
                            teamBs = teamListB.toArray(teamBs);


                            //Log.d("ROY", "onComplete: "+dataMap.get("name"));

                            for (int j = 0; j < 32; j++) {
                                //Log.d("ROY222", "onComplete: "+teams[j]);
                                //Log.d("ROY222", "onComplete: "+teamBs[j]);
                            }

                            String[] matchNo = getResources().getStringArray(R.array.knockout_match);


                            //30 -16 (2nd round)
                            Match match49 = new Match(teamBs[0], teamBs[1], getResources().getString(R.string.eight), getResources().getString(R.string.kazan_Arena), matchNo[0], getResources().getIdentifier(teams[0], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[1], "drawable", getContext().getPackageName()));
                            Match match50 = new Match(teamBs[2], teamBs[3], getResources().getString(R.string.twelve), getResources().getString(R.string.fisht_Stadium), matchNo[1], getResources().getIdentifier(teams[2], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[3], "drawable", getContext().getPackageName()));

                            //1 -17
                            Match match51 = new Match(teamBs[4], teamBs[5], getResources().getString(R.string.eight), getResources().getString(R.string.luzhniki_Stadium), matchNo[2], getResources().getIdentifier(teams[4], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[5], "drawable", getContext().getPackageName()));
                            Match match52 = new Match(teamBs[6], teamBs[7], getResources().getString(R.string.twelve), getResources().getString(R.string.nizhny_Novgorod_Stadium), matchNo[3], getResources().getIdentifier(teams[6], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[7], "drawable", getContext().getPackageName()));


                            //2 -18
                            Match match53 = new Match(teamBs[8], teamBs[9], getResources().getString(R.string.eight), getResources().getString(R.string.samara_Arena), matchNo[4], getResources().getIdentifier(teams[8], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[9], "drawable", getContext().getPackageName()));
                            Match match54 = new Match(teamBs[10], teamBs[11], getResources().getString(R.string.twelve), getResources().getString(R.string.rostov_Arena), matchNo[5], getResources().getIdentifier(teams[10], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[11], "drawable", getContext().getPackageName()));


                            //3 -19
                            Match match55 = new Match(teamBs[12], teamBs[13], getResources().getString(R.string.eight), getResources().getString(R.string.saint_Petersburg_Stadium), matchNo[6], getResources().getIdentifier(teams[12], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[13], "drawable", getContext().getPackageName()));
                            Match match56 = new Match(teamBs[14], teamBs[15], getResources().getString(R.string.twelve), getResources().getString(R.string.spartak_Stadium), matchNo[7], getResources().getIdentifier(teams[14], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[15], "drawable", getContext().getPackageName()));


                            //6 -20 (cuarter)
                            Match match57 = new Match(teamBs[16], teamBs[17], getResources().getString(R.string.eight), getResources().getString(R.string.nizhny_Novgorod_Stadium), matchNo[8], getResources().getIdentifier(teams[16], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[17], "drawable", getContext().getPackageName()));
                            Match match58 = new Match(teamBs[18], teamBs[19], getResources().getString(R.string.twelve), getResources().getString(R.string.kazan_Arena), matchNo[9], getResources().getIdentifier(teams[18], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[19], "drawable", getContext().getPackageName()));

                            //7 -21
                            Match match59 = new Match(teamBs[20], teamBs[21], getResources().getString(R.string.eight), getResources().getString(R.string.samara_Arena), matchNo[10], getResources().getIdentifier(teams[20], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[21], "drawable", getContext().getPackageName()));
                            Match match60 = new Match(teamBs[22], teamBs[23], getResources().getString(R.string.twelve), getResources().getString(R.string.fisht_Stadium), matchNo[11], getResources().getIdentifier(teams[22], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[23], "drawable", getContext().getPackageName()));


                            //10 -22(semi)
                            Match match61 = new Match(teamBs[24], teamBs[25], getResources().getString(R.string.twelve), getResources().getString(R.string.saint_Petersburg_Stadium), matchNo[12], getResources().getIdentifier(teams[24], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[25], "drawable", getContext().getPackageName()));

                            //11 -23
                            Match match62 = new Match(teamBs[26], teamBs[27], getResources().getString(R.string.twelve), getResources().getString(R.string.luzhniki_Stadium), matchNo[13], getResources().getIdentifier(teams[26], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[27], "drawable", getContext().getPackageName()));

                            //14 -24
                            Match match63 = new Match(teamBs[28], teamBs[29], getResources().getString(R.string.eight), getResources().getString(R.string.saint_Petersburg_Stadium), matchNo[14], getResources().getIdentifier(teams[28], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[29], "drawable", getContext().getPackageName()));

                            //15 -25
                            Match match64 = new Match(teamBs[30], teamBs[31], getResources().getString(R.string.nine), getResources().getString(R.string.luzhniki_Stadium), matchNo[15], getResources().getIdentifier(teams[30], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[31], "drawable", getContext().getPackageName()));


                            List<Match> matchDay16List = new ArrayList<>();
                            matchDay16List.add(match49);
                            matchDay16List.add(match50);

                            List<Match> matchDay17List = new ArrayList<>();
                            matchDay17List.add(match51);
                            matchDay17List.add(match52);

                            List<Match> matchDay18List = new ArrayList<>();
                            matchDay18List.add(match53);
                            matchDay18List.add(match54);

                            List<Match> matchDay19List = new ArrayList<>();
                            matchDay19List.add(match55);
                            matchDay19List.add(match56);

                            List<Match> matchDay20List = new ArrayList<>();
                            matchDay20List.add(match57);
                            matchDay20List.add(match58);

                            List<Match> matchDay21List = new ArrayList<>();
                            matchDay21List.add(match59);
                            matchDay21List.add(match60);

                            List<Match> matchDay22List = new ArrayList<>();
                            matchDay22List.add(match61);

                            List<Match> matchDay23List = new ArrayList<>();
                            matchDay23List.add(match62);

                            List<Match> matchDay24List = new ArrayList<>();
                            matchDay24List.add(match63);

                            List<Match> matchDay25List = new ArrayList<>();
                            matchDay25List.add(match64);


                            listHash.put(listDataHeader.get(0), matchDay16List);
                            listHash.put(listDataHeader.get(1), matchDay17List);
                            listHash.put(listDataHeader.get(2), matchDay18List);
                            listHash.put(listDataHeader.get(3), matchDay19List);

                            listHash.put(listDataHeader.get(4), matchDay20List);
                            listHash.put(listDataHeader.get(5), matchDay21List);

                            listHash.put(listDataHeader.get(6), matchDay22List);
                            listHash.put(listDataHeader.get(7), matchDay23List);
                            listHash.put(listDataHeader.get(8), matchDay24List);
                            listHash.put(listDataHeader.get(9), matchDay25List);


                            customAdapter = new ExpandableListCustomAdapter(getContext(), listDataHeader, listHash);
                            expandableListView.setAdapter(customAdapter);
                            progressDialog.dismiss();

                        } else {
                            Log.d("ROY", "KnockoutFragment(onComplete): " + task.getException());
                        }

                    }
                });



            }

        }
        else
            {
            /*################### If net is not connected ####################*/
            Toast.makeText(getContext(), "Internet is not connected", Toast.LENGTH_SHORT).show();

            if (SelectedLanguage.lang.equals("english")) {

                tvHeading.setText("KnockOut Matches");

                String[] date = getResources().getStringArray(R.array.knockout_dates_eng);
                for (String matchDate : date) {
                    listDataHeader.add(matchDate);
                }


                //Log.d("ROY", "onCreateView5 (Knockout): "+teamListSet.toString());



                String[] teams = new String[32];
                String[] teamBs = new String[32];

                for (int i=0; i<32; i++){
                    teams[i] = sharedPreferences1.getString("teams"+i, null);
                    teamBs[i] = sharedPreferences1.getString("teamBs"+i, null);
                }

                //############## converting arrylist into array ##################
               /* teams = teamList.toArray(teams);
                teamBs = teamListB.toArray(teamBs);*/
                //Log.d("ROY", "onComplete: "+dataMap.get("name"));

                for (int j = 0; j < 32; j++) {
                    //Log.d("ROY222", "onComplete: "+teams[j]);
                    //Log.d("ROY222", "onComplete: "+teamBs[j]);
                }

                String[] matchNo = getResources().getStringArray(R.array.knockout_match_e);


                //30 -16 (2nd round)
                Match match49 = new Match(teamBs[0], teamBs[1], getResources().getString(R.string.eight_e), getResources().getString(R.string.kazan_Arena_e), matchNo[0], getResources().getIdentifier(teams[0], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[1], "drawable", getContext().getPackageName()));
                Match match50 = new Match(teamBs[2], teamBs[3], getResources().getString(R.string.twelve_e), getResources().getString(R.string.fisht_Stadium_e), matchNo[1], getResources().getIdentifier(teams[2], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[3], "drawable", getContext().getPackageName()));

                //1 -17
                Match match51 = new Match(teamBs[4], teamBs[5], getResources().getString(R.string.eight_e), getResources().getString(R.string.luzhniki_Stadium_e), matchNo[2], getResources().getIdentifier(teams[4], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[5], "drawable", getContext().getPackageName()));
                Match match52 = new Match(teamBs[6], teamBs[7], getResources().getString(R.string.twelve_e), getResources().getString(R.string.nizhny_Novgorod_Stadium_e), matchNo[3], getResources().getIdentifier(teams[6], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[7], "drawable", getContext().getPackageName()));


                //2 -18
                Match match53 = new Match(teamBs[8], teamBs[9], getResources().getString(R.string.eight_e), getResources().getString(R.string.samara_Arena_e), matchNo[4], getResources().getIdentifier(teams[8], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[9], "drawable", getContext().getPackageName()));
                Match match54 = new Match(teamBs[10], teamBs[11], getResources().getString(R.string.twelve_e), getResources().getString(R.string.rostov_Arena_e), matchNo[5], getResources().getIdentifier(teams[10], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[11], "drawable", getContext().getPackageName()));


                //3 -19
                Match match55 = new Match(teamBs[12], teamBs[13], getResources().getString(R.string.eight_e), getResources().getString(R.string.saint_Petersburg_Stadium_e), matchNo[6], getResources().getIdentifier(teams[12], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[13], "drawable", getContext().getPackageName()));
                Match match56 = new Match(teamBs[14], teamBs[15], getResources().getString(R.string.twelve_e), getResources().getString(R.string.spartak_Stadium_e), matchNo[7], getResources().getIdentifier(teams[14], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[15], "drawable", getContext().getPackageName()));


                //6 -20 (cuarter)
                Match match57 = new Match(teamBs[16], teamBs[17], getResources().getString(R.string.eight_e), getResources().getString(R.string.nizhny_Novgorod_Stadium_e), matchNo[8], getResources().getIdentifier(teams[16], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[17], "drawable", getContext().getPackageName()));
                Match match58 = new Match(teamBs[18], teamBs[19], getResources().getString(R.string.twelve_e), getResources().getString(R.string.kazan_Arena_e), matchNo[9], getResources().getIdentifier(teams[18], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[19], "drawable", getContext().getPackageName()));

                //7 -21
                Match match59 = new Match(teamBs[20], teamBs[21], getResources().getString(R.string.eight_e), getResources().getString(R.string.samara_Arena_e), matchNo[10], getResources().getIdentifier(teams[20], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[21], "drawable", getContext().getPackageName()));
                Match match60 = new Match(teamBs[22], teamBs[23], getResources().getString(R.string.twelve_e), getResources().getString(R.string.fisht_Stadium_e), matchNo[11], getResources().getIdentifier(teams[22], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[23], "drawable", getContext().getPackageName()));


                //10 -22(semi)
                Match match61 = new Match(teamBs[24], teamBs[25], getResources().getString(R.string.twelve_e), getResources().getString(R.string.saint_Petersburg_Stadium_e), matchNo[12], getResources().getIdentifier(teams[24], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[25], "drawable", getContext().getPackageName()));

                //11 -23
                Match match62 = new Match(teamBs[26], teamBs[27], getResources().getString(R.string.twelve_e), getResources().getString(R.string.luzhniki_Stadium_e), matchNo[13], getResources().getIdentifier(teams[26], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[27], "drawable", getContext().getPackageName()));

                //14 -24
                Match match63 = new Match(teamBs[28], teamBs[29], getResources().getString(R.string.eight_e), getResources().getString(R.string.saint_Petersburg_Stadium_e), matchNo[14], getResources().getIdentifier(teams[28], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[29], "drawable", getContext().getPackageName()));

                //15 -25
                Match match64 = new Match(teamBs[30], teamBs[31], getResources().getString(R.string.nine_e), getResources().getString(R.string.luzhniki_Stadium_e), matchNo[15], getResources().getIdentifier(teams[30], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[31], "drawable", getContext().getPackageName()));


                List<Match> matchDay16List = new ArrayList<>();
                matchDay16List.add(match49);
                matchDay16List.add(match50);

                List<Match> matchDay17List = new ArrayList<>();
                matchDay17List.add(match51);
                matchDay17List.add(match52);

                List<Match> matchDay18List = new ArrayList<>();
                matchDay18List.add(match53);
                matchDay18List.add(match54);

                List<Match> matchDay19List = new ArrayList<>();
                matchDay19List.add(match55);
                matchDay19List.add(match56);

                List<Match> matchDay20List = new ArrayList<>();
                matchDay20List.add(match57);
                matchDay20List.add(match58);

                List<Match> matchDay21List = new ArrayList<>();
                matchDay21List.add(match59);
                matchDay21List.add(match60);

                List<Match> matchDay22List = new ArrayList<>();
                matchDay22List.add(match61);

                List<Match> matchDay23List = new ArrayList<>();
                matchDay23List.add(match62);

                List<Match> matchDay24List = new ArrayList<>();
                matchDay24List.add(match63);

                List<Match> matchDay25List = new ArrayList<>();
                matchDay25List.add(match64);


                listHash.put(listDataHeader.get(0), matchDay16List);
                listHash.put(listDataHeader.get(1), matchDay17List);
                listHash.put(listDataHeader.get(2), matchDay18List);
                listHash.put(listDataHeader.get(3), matchDay19List);

                listHash.put(listDataHeader.get(4), matchDay20List);
                listHash.put(listDataHeader.get(5), matchDay21List);

                listHash.put(listDataHeader.get(6), matchDay22List);
                listHash.put(listDataHeader.get(7), matchDay23List);
                listHash.put(listDataHeader.get(8), matchDay24List);
                listHash.put(listDataHeader.get(9), matchDay25List);


                customAdapter = new ExpandableListCustomAdapter(getContext(), listDataHeader, listHash);
                expandableListView.setAdapter(customAdapter);
                //progressDialog.dismiss();



            }
            else{


                tvHeading.setText("নকআউট পর্বের সময়সূচী");

                String[] date = getResources().getStringArray(R.array.knockout_dates);
                for (String matchDate : date) {
                    listDataHeader.add(matchDate);

                }


                //############## converting arrylist into array ##################
                String[] teams = new String[32];
                String[] teamBs = new String[32];

                for (int i=0; i<32; i++){
                    teams[i] = sharedPreferences1.getString("teams"+i, null);
                    teamBs[i] = sharedPreferences1.getString("teamBs"+i, null);
                }

                //Log.d("ROY", "onComplete: "+dataMap.get("name"));

                for (int j = 0; j < 32; j++) {
                    //Log.d("ROY222", "onComplete: "+teams[j]);
                    //Log.d("ROY222", "onComplete: "+teamBs[j]);
                }

                String[] matchNo = getResources().getStringArray(R.array.knockout_match);


                //30 -16 (2nd round)
                Match match49 = new Match(teamBs[0], teamBs[1], getResources().getString(R.string.eight), getResources().getString(R.string.kazan_Arena), matchNo[0], getResources().getIdentifier(teams[0], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[1], "drawable", getContext().getPackageName()));
                Match match50 = new Match(teamBs[2], teamBs[3], getResources().getString(R.string.twelve), getResources().getString(R.string.fisht_Stadium), matchNo[1], getResources().getIdentifier(teams[2], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[3], "drawable", getContext().getPackageName()));

                //1 -17
                Match match51 = new Match(teamBs[4], teamBs[5], getResources().getString(R.string.eight), getResources().getString(R.string.luzhniki_Stadium), matchNo[2], getResources().getIdentifier(teams[4], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[5], "drawable", getContext().getPackageName()));
                Match match52 = new Match(teamBs[6], teamBs[7], getResources().getString(R.string.twelve), getResources().getString(R.string.nizhny_Novgorod_Stadium), matchNo[3], getResources().getIdentifier(teams[6], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[7], "drawable", getContext().getPackageName()));


                //2 -18
                Match match53 = new Match(teamBs[8], teamBs[9], getResources().getString(R.string.eight), getResources().getString(R.string.samara_Arena), matchNo[4], getResources().getIdentifier(teams[8], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[9], "drawable", getContext().getPackageName()));
                Match match54 = new Match(teamBs[10], teamBs[11], getResources().getString(R.string.twelve), getResources().getString(R.string.rostov_Arena), matchNo[5], getResources().getIdentifier(teams[10], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[11], "drawable", getContext().getPackageName()));


                //3 -19
                Match match55 = new Match(teamBs[12], teamBs[13], getResources().getString(R.string.eight), getResources().getString(R.string.saint_Petersburg_Stadium), matchNo[6], getResources().getIdentifier(teams[12], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[13], "drawable", getContext().getPackageName()));
                Match match56 = new Match(teamBs[14], teamBs[15], getResources().getString(R.string.twelve), getResources().getString(R.string.spartak_Stadium), matchNo[7], getResources().getIdentifier(teams[14], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[15], "drawable", getContext().getPackageName()));


                //6 -20 (cuarter)
                Match match57 = new Match(teamBs[16], teamBs[17], getResources().getString(R.string.eight), getResources().getString(R.string.nizhny_Novgorod_Stadium), matchNo[8], getResources().getIdentifier(teams[16], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[17], "drawable", getContext().getPackageName()));
                Match match58 = new Match(teamBs[18], teamBs[19], getResources().getString(R.string.twelve), getResources().getString(R.string.kazan_Arena), matchNo[9], getResources().getIdentifier(teams[18], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[19], "drawable", getContext().getPackageName()));

                //7 -21
                Match match59 = new Match(teamBs[20], teamBs[21], getResources().getString(R.string.eight), getResources().getString(R.string.samara_Arena), matchNo[10], getResources().getIdentifier(teams[20], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[21], "drawable", getContext().getPackageName()));
                Match match60 = new Match(teamBs[22], teamBs[23], getResources().getString(R.string.twelve), getResources().getString(R.string.fisht_Stadium), matchNo[11], getResources().getIdentifier(teams[22], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[23], "drawable", getContext().getPackageName()));


                //10 -22(semi)
                Match match61 = new Match(teamBs[24], teamBs[25], getResources().getString(R.string.twelve), getResources().getString(R.string.saint_Petersburg_Stadium), matchNo[12], getResources().getIdentifier(teams[24], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[25], "drawable", getContext().getPackageName()));

                //11 -23
                Match match62 = new Match(teamBs[26], teamBs[27], getResources().getString(R.string.twelve), getResources().getString(R.string.luzhniki_Stadium), matchNo[13], getResources().getIdentifier(teams[26], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[27], "drawable", getContext().getPackageName()));

                //14 -24
                Match match63 = new Match(teamBs[28], teamBs[29], getResources().getString(R.string.eight), getResources().getString(R.string.saint_Petersburg_Stadium), matchNo[14], getResources().getIdentifier(teams[28], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[29], "drawable", getContext().getPackageName()));

                //15 -25
                Match match64 = new Match(teamBs[30], teamBs[31], getResources().getString(R.string.nine), getResources().getString(R.string.luzhniki_Stadium), matchNo[15], getResources().getIdentifier(teams[30], "drawable", getContext().getPackageName()), getResources().getIdentifier(teams[31], "drawable", getContext().getPackageName()));


                List<Match> matchDay16List = new ArrayList<>();
                matchDay16List.add(match49);
                matchDay16List.add(match50);

                List<Match> matchDay17List = new ArrayList<>();
                matchDay17List.add(match51);
                matchDay17List.add(match52);

                List<Match> matchDay18List = new ArrayList<>();
                matchDay18List.add(match53);
                matchDay18List.add(match54);

                List<Match> matchDay19List = new ArrayList<>();
                matchDay19List.add(match55);
                matchDay19List.add(match56);

                List<Match> matchDay20List = new ArrayList<>();
                matchDay20List.add(match57);
                matchDay20List.add(match58);

                List<Match> matchDay21List = new ArrayList<>();
                matchDay21List.add(match59);
                matchDay21List.add(match60);

                List<Match> matchDay22List = new ArrayList<>();
                matchDay22List.add(match61);

                List<Match> matchDay23List = new ArrayList<>();
                matchDay23List.add(match62);

                List<Match> matchDay24List = new ArrayList<>();
                matchDay24List.add(match63);

                List<Match> matchDay25List = new ArrayList<>();
                matchDay25List.add(match64);


                listHash.put(listDataHeader.get(0), matchDay16List);
                listHash.put(listDataHeader.get(1), matchDay17List);
                listHash.put(listDataHeader.get(2), matchDay18List);
                listHash.put(listDataHeader.get(3), matchDay19List);

                listHash.put(listDataHeader.get(4), matchDay20List);
                listHash.put(listDataHeader.get(5), matchDay21List);

                listHash.put(listDataHeader.get(6), matchDay22List);
                listHash.put(listDataHeader.get(7), matchDay23List);
                listHash.put(listDataHeader.get(8), matchDay24List);
                listHash.put(listDataHeader.get(9), matchDay25List);


                customAdapter = new ExpandableListCustomAdapter(getContext(), listDataHeader, listHash);
                expandableListView.setAdapter(customAdapter);




            }

        }
        return view;

    }


    /*@Override
    public void onResume() {
        super.onResume();
        getFragmentManager().beginTransaction().detach(this).attach(this).commit();
    }*/

    /*################# Refresh the fragment when tab is changed ########################*/
    public void setUserVisibleHint1(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }


}
