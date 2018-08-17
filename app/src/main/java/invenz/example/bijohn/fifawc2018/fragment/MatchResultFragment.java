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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import invenz.example.bijohn.fifawc2018.IsInternetConnected;
import invenz.example.bijohn.fifawc2018.SelectedLanguage;
import invenz.example.bijohn.fifawc2018.adapter.MatchResultCustomAdapter;
import com.example.bijohn.fifawc2018.R;
import invenz.example.bijohn.fifawc2018.model.MatchResult;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class MatchResultFragment extends Fragment {

    private ListView listViewResult;
    private TextView tvHeading;
    private List<MatchResult> matchResults;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressDialog progressDialog;
    private MatchResultCustomAdapter matchResultCustomAdapter;
    private FirebaseFirestore firestore;
    private String[] scores = new String[64];
    private String[] detailsResult = new String[63];
    private SharedPreferences sharedPref ;
    private SharedPreferences.Editor editor;

    Map<String, Object> data;

    public MatchResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_match_result, container, false);
        listViewResult = view.findViewById(R.id.idResultList_MatchResult);
        tvHeading = view.findViewById(R.id.idResult_MatchResultFrag);
        swipeRefreshLayout = view.findViewById(R.id.idSwipeLayout_MatchResult);
        firestore = FirebaseFirestore.getInstance();
        sharedPref = getContext().getSharedPreferences("languageSharedPref", Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        IsInternetConnected isInternetConnected = new IsInternetConnected();

        if (isInternetConnected.isConnected(getActivity())){

            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("loading...");
            progressDialog.setCancelable(true);
            progressDialog.show();
        }



        /*################ WHEN FRAGMENT IS SWIPED DOWN , PAGE WILL REFRESH ##########################*/
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //Toast.makeText(getContext(), "Refreshed", Toast.LENGTH_SHORT).show();
                setUserVisibleHint1(true);
            }
        });


        if (isInternetConnected.isConnected(getActivity())) {


            /*################ For English ############################*/
            if (SelectedLanguage.lang.equals("english")) {

                firestore.collection("matches").document("8lJpsFFPP2EOLNAJfkc8").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot documentSnapshot = task.getResult();

                            if (documentSnapshot.exists()) {
                                tvHeading.setText("Match Results");

                                data = documentSnapshot.getData();
                                for (int i = 0; i <= 63; i++) {
                                    scores[i] = (String) data.get(i + 1 + "");
                                    Log.d("ROY", "onComplete: " + scores[i]);
                                    editor.putString("scores"+i, data.get(i + 1 + "").toString());
                                }

                                editor.apply();
                                editor.commit();

                                Log.d("ROY", "onCreateView: 1" + scores[0]);

                                MatchResult match1 = new MatchResult(getResources().getString(R.string.russia_e), getResources().getString(R.string.soudi_arab_e), "Match 1", scores[0]);

                                MatchResult match2 = new MatchResult(getResources().getString(R.string.egypt_e), getResources().getString(R.string.Uruguay_e), "Match 2", scores[1]);
                                MatchResult match3 = new MatchResult(getResources().getString(R.string.Morocco_e), getResources().getString(R.string.Iran_e), "Match 3", scores[2]);
                                MatchResult match4 = new MatchResult(getResources().getString(R.string.Portugal_e), getResources().getString(R.string.Spain_e), "Match 4", scores[3]);

                                //16 - 3
                                MatchResult match5 = new MatchResult(getResources().getString(R.string.France_e), getResources().getString(R.string.Australia_e), "Match 5", scores[4]);
                                MatchResult match6 = new MatchResult(getResources().getString(R.string.Argentina_e), getResources().getString(R.string.Iceland_e), "Match 6", scores[5]);
                                MatchResult match7 = new MatchResult(getResources().getString(R.string.Peru_e), getResources().getString(R.string.Denmark_e), "Match 7", scores[6]);
                                MatchResult match8 = new MatchResult(getResources().getString(R.string.Nigeria_e), getResources().getString(R.string.Croatia_e), "Match 8", scores[7]);

                                //17 - 4
                                MatchResult match9 = new MatchResult(getResources().getString(R.string.Costa_Rica_e), getResources().getString(R.string.Serbia_e), "Match 9", scores[8]);
                                MatchResult match10 = new MatchResult(getResources().getString(R.string.Germany_e), getResources().getString(R.string.Mexico_e), "Match 10", scores[9]);
                                MatchResult match11 = new MatchResult(getResources().getString(R.string.Brazil_e), getResources().getString(R.string.Switzerland_e), "Match 11", scores[10]);

                                //18 - 5
                                MatchResult match12 = new MatchResult(getResources().getString(R.string.Sweden_e), getResources().getString(R.string.Korea_Republic_e), "Match 12", scores[11]);
                                MatchResult match13 = new MatchResult(getResources().getString(R.string.Belgium_e), getResources().getString(R.string.Panama_e), "Match 13", scores[12]);
                                MatchResult match14 = new MatchResult(getResources().getString(R.string.England_e), getResources().getString(R.string.Tunisia_e), "Match 14", scores[13]);

                                //19 - 6
                                MatchResult match15 = new MatchResult(getResources().getString(R.string.Poland_e), getResources().getString(R.string.Senegal_e), "Match 15", scores[14]);
                                MatchResult match16 = new MatchResult(getResources().getString(R.string.Colombia_e), getResources().getString(R.string.Japan_e), "Match 16", scores[15]);
                                MatchResult match17 = new MatchResult(getResources().getString(R.string.russia_e), getResources().getString(R.string.egypt_e), "Match 17", scores[16]);

                                //20 - 7
                                MatchResult match18 = new MatchResult(getResources().getString(R.string.Portugal_e), getResources().getString(R.string.Morocco_e), "Match 18", scores[17]);
                                MatchResult match19 = new MatchResult(getResources().getString(R.string.Uruguay_e), getResources().getString(R.string.soudi_arab_e), "Match 19", scores[18]);
                                MatchResult match20 = new MatchResult(getResources().getString(R.string.Spain_e), getResources().getString(R.string.Iran_e), "Match 20", scores[19]);

                                //21 - 8
                                MatchResult match21 = new MatchResult(getResources().getString(R.string.France_e), getResources().getString(R.string.Peru_e), "Match 21", scores[20]);
                                MatchResult match22 = new MatchResult(getResources().getString(R.string.Denmark_e), getResources().getString(R.string.Australia_e), "Match 22", scores[21]);
                                MatchResult match23 = new MatchResult(getResources().getString(R.string.Argentina_e), getResources().getString(R.string.Croatia_e), "Match 23", scores[22]);

                                //22 - 9
                                MatchResult match24 = new MatchResult(getResources().getString(R.string.Brazil_e), getResources().getString(R.string.Costa_Rica_e), "Match 24", scores[23]);
                                MatchResult match25 = new MatchResult(getResources().getString(R.string.Nigeria_e), getResources().getString(R.string.Iceland_e), "Match 25", scores[24]);
                                MatchResult match26 = new MatchResult(getResources().getString(R.string.Serbia_e), getResources().getString(R.string.Switzerland_e), "Match 26", scores[25]);

                                //23 - 10
                                MatchResult match27 = new MatchResult(getResources().getString(R.string.Belgium_e), getResources().getString(R.string.Tunisia_e), "Match 27", scores[26]);
                                MatchResult match28 = new MatchResult(getResources().getString(R.string.Germany_e), getResources().getString(R.string.Sweden_e), "Match 28", scores[27]);
                                MatchResult match29 = new MatchResult(getResources().getString(R.string.Korea_Republic_e), getResources().getString(R.string.Mexico_e), "Match 29", scores[28]);

                                //24 - 11
                                MatchResult match30 = new MatchResult(getResources().getString(R.string.England_e), getResources().getString(R.string.Panama_e), "Match 30", scores[29]);
                                MatchResult match31 = new MatchResult(getResources().getString(R.string.Japan_e), getResources().getString(R.string.Senegal_e), "Match 31", scores[30]);
                                MatchResult match32 = new MatchResult(getResources().getString(R.string.Poland_e), getResources().getString(R.string.Colombia_e), "Match 32", scores[31]);

                                //25 - 12
                                MatchResult match33 = new MatchResult(getResources().getString(R.string.soudi_arab_e), getResources().getString(R.string.egypt_e), "Match 33", scores[32]);
                                MatchResult match34 = new MatchResult(getResources().getString(R.string.Uruguay_e), getResources().getString(R.string.russia_e), "Match 34", scores[33]);
                                MatchResult match35 = new MatchResult(getResources().getString(R.string.Portugal_e), getResources().getString(R.string.Iran_e), "Match 35", scores[34]);
                                MatchResult match36 = new MatchResult(getResources().getString(R.string.Spain_e), getResources().getString(R.string.Morocco_e), "Match 36", scores[35]);

                                //26 - 13
                                MatchResult match37 = new MatchResult(getResources().getString(R.string.Australia_e), getResources().getString(R.string.Peru_e), "Match 37", scores[36]);
                                MatchResult match38 = new MatchResult(getResources().getString(R.string.France_e), getResources().getString(R.string.Denmark_e), "Match 38", scores[37]);
                                MatchResult match39 = new MatchResult(getResources().getString(R.string.Iceland_e), getResources().getString(R.string.Croatia_e), "Match 39", scores[38]);
                                MatchResult match40 = new MatchResult(getResources().getString(R.string.Argentina_e), getResources().getString(R.string.Nigeria_e), "Match 40", scores[39]);

                                //27 - 14
                                MatchResult match41 = new MatchResult(getResources().getString(R.string.Germany_e), getResources().getString(R.string.Korea_Republic_e), "Match 41", scores[40]);
                                MatchResult match42 = new MatchResult(getResources().getString(R.string.Mexico_e), getResources().getString(R.string.Sweden_e), "Match 42", scores[41]);
                                MatchResult match43 = new MatchResult(getResources().getString(R.string.Switzerland_e), getResources().getString(R.string.Costa_Rica_e), "Match 43", scores[42]);
                                MatchResult match44 = new MatchResult(getResources().getString(R.string.Brazil_e), getResources().getString(R.string.Serbia_e), "Match 44", scores[43]);

                                //28 - 15
                                MatchResult match45 = new MatchResult(getResources().getString(R.string.Japan_e), getResources().getString(R.string.Poland_e), "Match 45", scores[44]);
                                MatchResult match46 = new MatchResult(getResources().getString(R.string.Senegal_e), getResources().getString(R.string.Colombia_e), "Match 46", scores[45]);
                                MatchResult match47 = new MatchResult(getResources().getString(R.string.England_e), getResources().getString(R.string.Belgium_e), "Match 47", scores[46]);
                                MatchResult match48 = new MatchResult(getResources().getString(R.string.Panama_e), getResources().getString(R.string.Tunisia_e), "Match 48", scores[47]);


                                matchResults = new ArrayList<>();
                                matchResults.add(match1);
                                matchResults.add(match2);
                                matchResults.add(match3);
                                matchResults.add(match4);
                                matchResults.add(match5);
                                matchResults.add(match6);
                                matchResults.add(match7);
                                matchResults.add(match8);
                                matchResults.add(match9);
                                matchResults.add(match10);
                                matchResults.add(match11);
                                matchResults.add(match12);
                                matchResults.add(match13);
                                matchResults.add(match14);
                                matchResults.add(match15);
                                matchResults.add(match16);
                                matchResults.add(match17);
                                matchResults.add(match18);
                                matchResults.add(match19);
                                matchResults.add(match20);
                                matchResults.add(match21);
                                matchResults.add(match22);
                                matchResults.add(match23);
                                matchResults.add(match24);
                                matchResults.add(match25);
                                matchResults.add(match26);
                                matchResults.add(match27);
                                matchResults.add(match28);
                                matchResults.add(match29);
                                matchResults.add(match30);
                                matchResults.add(match31);
                                matchResults.add(match32);
                                matchResults.add(match33);
                                matchResults.add(match34);
                                matchResults.add(match35);
                                matchResults.add(match36);
                                matchResults.add(match37);
                                matchResults.add(match38);
                                matchResults.add(match39);
                                matchResults.add(match40);
                                matchResults.add(match41);
                                matchResults.add(match42);
                                matchResults.add(match43);
                                matchResults.add(match44);
                                matchResults.add(match45);
                                matchResults.add(match46);
                                matchResults.add(match47);
                                matchResults.add(match48);


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

                                            Log.d("ROY", "onComplete: " + teamList.size());


                                            String[] teams = new String[teamList.size()];
                                            String[] teamBs = new String[teamListB.size()];



                                            //############## converting arrylist into array ##################


                                            progressDialog.dismiss();

                                            teams = teamList.toArray(teams);
                                            teamBs = teamListB.toArray(teamBs);

                                            for (int i=0; i<teams.length;i++){
                                                editor.putString("teamsResult"+i, teams[i] );
                                                editor.putString("teamBsResult"+i, teamBs[i] );
                                            }
                                            editor.apply();
                                            editor.commit();

                                            //Log.d("ROY", "onComplete: "+dataMap.get("name"));


                                            //30 -16
                                            MatchResult match49 = new MatchResult(teamBs[0], teamBs[1], "Match 49", scores[48]);
                                            MatchResult match50 = new MatchResult(teamBs[2], teamBs[3], "Match 50", scores[49]);

                                            //1 -17
                                            MatchResult match51 = new MatchResult(teamBs[4], teamBs[5], "Match 51", scores[50]);
                                            MatchResult match52 = new MatchResult(teamBs[6], teamBs[7], "Match 52", scores[51]);


                                            //2 -18
                                            MatchResult match53 = new MatchResult(teamBs[8], teamBs[9], "Match 53", scores[52]);
                                            MatchResult match54 = new MatchResult(teamBs[10], teamBs[11], "Match 54", scores[53]);


                                            //3 -19
                                            MatchResult match55 = new MatchResult(teamBs[12], teamBs[13], "Match 55", scores[54]);
                                            MatchResult match56 = new MatchResult(teamBs[14], teamBs[15], "Match 56", scores[55]);


                                            //6 -20 (cuarter)
                                            MatchResult match57 = new MatchResult(teamBs[16], teamBs[17], "Match 57", scores[56]);
                                            MatchResult match58 = new MatchResult(teamBs[18], teamBs[19], "Match 58", scores[57]);

                                            //7 -21
                                            MatchResult match59 = new MatchResult(teamBs[20], teamBs[21], "Match 59", scores[58]);
                                            MatchResult match60 = new MatchResult(teamBs[22], teamBs[23], "Match 60", scores[59]);


                                            //10 -22(semi)
                                            MatchResult match61 = new MatchResult(teamBs[24], teamBs[25], "Match 61", scores[60]);

                                            //11 -23
                                            MatchResult match62 = new MatchResult(teamBs[26], teamBs[27], "Match 62", scores[61]);

                                            //14 -24
                                            MatchResult match63 = new MatchResult(teamBs[28], teamBs[29], "Match 63", scores[62]);

                                            //15 -25
                                            MatchResult match64 = new MatchResult(teamBs[30], teamBs[31], "Match 64", scores[63]);


                                            matchResults.add(match49);
                                            matchResults.add(match50);
                                            matchResults.add(match51);
                                            matchResults.add(match52);
                                            matchResults.add(match53);
                                            matchResults.add(match54);
                                            matchResults.add(match55);
                                            matchResults.add(match56);
                                            matchResults.add(match57);
                                            matchResults.add(match58);
                                            matchResults.add(match59);
                                            matchResults.add(match60);
                                            matchResults.add(match61);
                                            matchResults.add(match62);
                                            matchResults.add(match63);
                                            matchResults.add(match64);


                                            matchResultCustomAdapter = new MatchResultCustomAdapter(getContext(), matchResults);
                                            listViewResult.setAdapter(matchResultCustomAdapter);
                                        } else {
                                            Log.d("ROY", "KnockoutFragment(onComplete): " + task.getException());
                                        }
                                    }
                                });

                            }
                        } else {
                            Log.d("ROY", "get failed with ", task.getException());
                        }
                    }
                });


            }
            /*################## For Bangla ###################################*/
            else {

                firestore.collection("matches").document("IOdfO6MZSJmuvJNi73UN").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot documentSnapshot = task.getResult();
                            if (documentSnapshot.exists()) {

                                tvHeading.setText("ফলাফল");

                                data = documentSnapshot.getData();
                                //Log.d("ROY", "onComplete: "+documentSnapshot.getData());
                                for (int i = 0; i <= 63; i++) {
                                    scores[i] = (String) data.get(i + 1 + "");
                                    Log.d("ROY", "onComplete: " + scores[i]);
                                    editor.putString("scores1"+i, data.get(i + 1 + "").toString());
                                }

                                Log.d("ROY", "onCreateView: 1" + scores[0]);

                                MatchResult match1 = new MatchResult(getResources().getString(R.string.russia), getResources().getString(R.string.soudi_arab), "ম্যাচ ১", scores[0]);

                                MatchResult match2 = new MatchResult(getResources().getString(R.string.egypt), getResources().getString(R.string.Uruguay), "ম্যাচ ২", scores[1]);
                                MatchResult match3 = new MatchResult(getResources().getString(R.string.Morocco), getResources().getString(R.string.Iran), "ম্যাচ ৩", scores[2]);
                                MatchResult match4 = new MatchResult(getResources().getString(R.string.Portugal), getResources().getString(R.string.Spain), "ম্যাচ ৪", scores[3]);

                                //16 - 3
                                MatchResult match5 = new MatchResult(getResources().getString(R.string.France), getResources().getString(R.string.Australia), "ম্যাচ ৫", scores[4]);
                                MatchResult match6 = new MatchResult(getResources().getString(R.string.Argentina), getResources().getString(R.string.Iceland), "ম্যাচ ৬", scores[5]);
                                MatchResult match7 = new MatchResult(getResources().getString(R.string.Peru), getResources().getString(R.string.Denmark), "ম্যাচ ৭", scores[6]);
                                MatchResult match8 = new MatchResult(getResources().getString(R.string.Nigeria), getResources().getString(R.string.Croatia), "ম্যাচ ৮", scores[7]);

                                //17 - 4
                                MatchResult match9 = new MatchResult(getResources().getString(R.string.Costa_Rica), getResources().getString(R.string.Serbia), "ম্যাচ ৯", scores[8]);
                                MatchResult match10 = new MatchResult(getResources().getString(R.string.Germany), getResources().getString(R.string.Mexico), "ম্যাচ ১০", scores[9]);
                                MatchResult match11 = new MatchResult(getResources().getString(R.string.Brazil), getResources().getString(R.string.Switzerland), "ম্যাচ ১১", scores[10]);

                                //18 - 5
                                MatchResult match12 = new MatchResult(getResources().getString(R.string.Sweden), getResources().getString(R.string.Korea_Republic), "ম্যাচ ১২", scores[11]);
                                MatchResult match13 = new MatchResult(getResources().getString(R.string.Belgium), getResources().getString(R.string.Panama), "ম্যাচ ১৩", scores[12]);
                                MatchResult match14 = new MatchResult(getResources().getString(R.string.England), getResources().getString(R.string.Tunisia), "ম্যাচ ১৪", scores[13]);

                                //19 - 6
                                MatchResult match15 = new MatchResult(getResources().getString(R.string.Poland), getResources().getString(R.string.Senegal), "ম্যাচ ১৫", scores[14]);
                                MatchResult match16 = new MatchResult(getResources().getString(R.string.Colombia), getResources().getString(R.string.Japan), "ম্যাচ ১৬", scores[15]);
                                MatchResult match17 = new MatchResult(getResources().getString(R.string.russia), getResources().getString(R.string.egypt), "ম্যাচ ১৭", scores[16]);

                                //20 - 7
                                MatchResult match18 = new MatchResult(getResources().getString(R.string.Portugal), getResources().getString(R.string.Morocco), "ম্যাচ ১৮", scores[17]);
                                MatchResult match19 = new MatchResult(getResources().getString(R.string.Uruguay), getResources().getString(R.string.soudi_arab), "ম্যাচ ১৯", scores[18]);
                                MatchResult match20 = new MatchResult(getResources().getString(R.string.Spain), getResources().getString(R.string.Iran), "ম্যাচ ২০", scores[19]);

                                //21 - 8
                                MatchResult match21 = new MatchResult(getResources().getString(R.string.France), getResources().getString(R.string.Peru), "ম্যাচ ২১", scores[20]);
                                MatchResult match22 = new MatchResult(getResources().getString(R.string.Denmark), getResources().getString(R.string.Australia), "ম্যাচ ২২", scores[21]);
                                MatchResult match23 = new MatchResult(getResources().getString(R.string.Argentina), getResources().getString(R.string.Croatia), "ম্যাচ ২৩", scores[22]);

                                //22 - 9
                                MatchResult match24 = new MatchResult(getResources().getString(R.string.Brazil), getResources().getString(R.string.Costa_Rica), "ম্যাচ ২৪", scores[23]);
                                MatchResult match25 = new MatchResult(getResources().getString(R.string.Nigeria), getResources().getString(R.string.Iceland), "ম্যাচ ২৫", scores[24]);
                                MatchResult match26 = new MatchResult(getResources().getString(R.string.Serbia), getResources().getString(R.string.Switzerland), "ম্যাচ ২৬", scores[25]);

                                //23 - 10
                                MatchResult match27 = new MatchResult(getResources().getString(R.string.Belgium), getResources().getString(R.string.Tunisia), "ম্যাচ ২৭", scores[26]);
                                MatchResult match28 = new MatchResult(getResources().getString(R.string.Germany), getResources().getString(R.string.Sweden), "ম্যাচ ২৮", scores[27]);
                                MatchResult match29 = new MatchResult(getResources().getString(R.string.Korea_Republic), getResources().getString(R.string.Mexico), "ম্যাচ ২৯", scores[28]);

                                //24 - 11
                                MatchResult match30 = new MatchResult(getResources().getString(R.string.England), getResources().getString(R.string.Panama), "ম্যাচ ৩০", scores[29]);
                                MatchResult match31 = new MatchResult(getResources().getString(R.string.Japan), getResources().getString(R.string.Senegal), "ম্যাচ ৩১", scores[30]);
                                MatchResult match32 = new MatchResult(getResources().getString(R.string.Poland), getResources().getString(R.string.Colombia), "ম্যাচ ৩২", scores[31]);

                                //25 - 12
                                MatchResult match33 = new MatchResult(getResources().getString(R.string.soudi_arab), getResources().getString(R.string.egypt), "ম্যাচ ৩৩", scores[32]);
                                MatchResult match34 = new MatchResult(getResources().getString(R.string.Uruguay), getResources().getString(R.string.russia), "ম্যাচ ৩৪", scores[33]);
                                MatchResult match35 = new MatchResult(getResources().getString(R.string.Portugal), getResources().getString(R.string.Iran), "ম্যাচ ৩৫", scores[34]);
                                MatchResult match36 = new MatchResult(getResources().getString(R.string.Spain), getResources().getString(R.string.Morocco), "ম্যাচ ৩৬", scores[35]);

                                //26 - 13
                                MatchResult match37 = new MatchResult(getResources().getString(R.string.Australia), getResources().getString(R.string.Peru), "ম্যাচ ৩৭", scores[36]);
                                MatchResult match38 = new MatchResult(getResources().getString(R.string.France), getResources().getString(R.string.Denmark), "ম্যাচ ৩৮", scores[37]);
                                MatchResult match39 = new MatchResult(getResources().getString(R.string.Iceland), getResources().getString(R.string.Croatia), "ম্যাচ ৩৯", scores[38]);
                                MatchResult match40 = new MatchResult(getResources().getString(R.string.Argentina), getResources().getString(R.string.Nigeria), "ম্যাচ ৪০", scores[39]);

                                //27 - 14
                                MatchResult match41 = new MatchResult(getResources().getString(R.string.Germany), getResources().getString(R.string.Korea_Republic), "ম্যাচ ৪১", scores[40]);
                                MatchResult match42 = new MatchResult(getResources().getString(R.string.Mexico), getResources().getString(R.string.Sweden), "ম্যাচ ৪২", scores[41]);
                                MatchResult match43 = new MatchResult(getResources().getString(R.string.Switzerland), getResources().getString(R.string.Costa_Rica), "ম্যাচ ৪৩", scores[42]);
                                MatchResult match44 = new MatchResult(getResources().getString(R.string.Brazil), getResources().getString(R.string.Serbia), "ম্যাচ ৪৪", scores[43]);

                                //28 - 15
                                MatchResult match45 = new MatchResult(getResources().getString(R.string.Japan), getResources().getString(R.string.Poland), "ম্যাচ ৪৫", scores[44]);
                                MatchResult match46 = new MatchResult(getResources().getString(R.string.Senegal), getResources().getString(R.string.Colombia), "ম্যাচ ৪৬", scores[45]);
                                MatchResult match47 = new MatchResult(getResources().getString(R.string.England), getResources().getString(R.string.Belgium), "ম্যাচ ৪৭", scores[46]);
                                MatchResult match48 = new MatchResult(getResources().getString(R.string.Panama), getResources().getString(R.string.Tunisia), "ম্যাচ ৪৮", scores[47]);

                                matchResults = new ArrayList<>();
                                matchResults.add(match1);
                                matchResults.add(match2);
                                matchResults.add(match3);
                                matchResults.add(match4);
                                matchResults.add(match5);
                                matchResults.add(match6);
                                matchResults.add(match7);
                                matchResults.add(match8);
                                matchResults.add(match9);
                                matchResults.add(match10);
                                matchResults.add(match11);
                                matchResults.add(match12);
                                matchResults.add(match13);
                                matchResults.add(match14);
                                matchResults.add(match15);
                                matchResults.add(match16);
                                matchResults.add(match17);
                                matchResults.add(match18);
                                matchResults.add(match19);
                                matchResults.add(match20);
                                matchResults.add(match21);
                                matchResults.add(match22);
                                matchResults.add(match23);
                                matchResults.add(match24);
                                matchResults.add(match25);
                                matchResults.add(match26);
                                matchResults.add(match27);
                                matchResults.add(match28);
                                matchResults.add(match29);
                                matchResults.add(match30);
                                matchResults.add(match31);
                                matchResults.add(match32);
                                matchResults.add(match33);
                                matchResults.add(match34);
                                matchResults.add(match35);
                                matchResults.add(match36);
                                matchResults.add(match37);
                                matchResults.add(match38);
                                matchResults.add(match39);
                                matchResults.add(match40);
                                matchResults.add(match41);
                                matchResults.add(match42);
                                matchResults.add(match43);
                                matchResults.add(match44);
                                matchResults.add(match45);
                                matchResults.add(match46);
                                matchResults.add(match47);
                                matchResults.add(match48);


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

                                            for (int i=0; i<teams.length;i++){
                                                editor.putString("teamsResult1"+i, teams[i] );
                                                editor.putString("teamBsResult1"+i, teamBs[i] );
                                            }
                                            editor.apply();
                                            editor.commit();


                                            //Log.d("ROY", "onComplete: "+dataMap.get("name"));


                                            //30 -16
                                            MatchResult match49 = new MatchResult(teamBs[0], teamBs[1], "ম্যাচ ৪৯", scores[48]);
                                            MatchResult match50 = new MatchResult(teamBs[2], teamBs[3], "ম্যাচ ৫০", scores[49]);

                                            //1 -17
                                            MatchResult match51 = new MatchResult(teamBs[4], teamBs[5], "ম্যাচ ৫১", scores[50]);
                                            MatchResult match52 = new MatchResult(teamBs[6], teamBs[7], "ম্যাচ ৫২", scores[51]);


                                            //2 -18
                                            MatchResult match53 = new MatchResult(teamBs[8], teamBs[9], "ম্যাচ ৫৩", scores[52]);
                                            MatchResult match54 = new MatchResult(teamBs[10], teamBs[11], "ম্যাচ ৫৪", scores[53]);


                                            //3 -19
                                            MatchResult match55 = new MatchResult(teamBs[12], teamBs[13], "ম্যাচ ৫৫", scores[54]);
                                            MatchResult match56 = new MatchResult(teamBs[14], teamBs[15], "ম্যাচ ৫৬", scores[55]);


                                            //6 -20 (cuarter)
                                            MatchResult match57 = new MatchResult(teamBs[16], teamBs[17], "ম্যাচ ৫৭", scores[56]);
                                            MatchResult match58 = new MatchResult(teamBs[18], teamBs[19], "ম্যাচ ৫৮", scores[57]);

                                            //7 -21
                                            MatchResult match59 = new MatchResult(teamBs[20], teamBs[21], "ম্যাচ ৫৯", scores[58]);
                                            MatchResult match60 = new MatchResult(teamBs[22], teamBs[23], "ম্যাচ ৬০", scores[59]);


                                            //10 -22(semi)
                                            MatchResult match61 = new MatchResult(teamBs[24], teamBs[25], "ম্যাচ ৬১", scores[60]);

                                            //11 -23
                                            MatchResult match62 = new MatchResult(teamBs[26], teamBs[27], "ম্যাচ ৬২", scores[61]);

                                            //14 -24
                                            MatchResult match63 = new MatchResult(teamBs[28], teamBs[29], "ম্যাচ ৬৩", scores[62]);

                                            //15 -25
                                            MatchResult match64 = new MatchResult(teamBs[30], teamBs[31], "ম্যাচ ৬৪", scores[63]);


                                            matchResults.add(match49);
                                            matchResults.add(match50);
                                            matchResults.add(match51);
                                            matchResults.add(match52);
                                            matchResults.add(match53);
                                            matchResults.add(match54);
                                            matchResults.add(match55);
                                            matchResults.add(match56);
                                            matchResults.add(match57);
                                            matchResults.add(match58);
                                            matchResults.add(match59);
                                            matchResults.add(match60);
                                            matchResults.add(match61);
                                            matchResults.add(match62);
                                            matchResults.add(match63);
                                            matchResults.add(match64);


                                            matchResultCustomAdapter = new MatchResultCustomAdapter(getContext(), matchResults);
                                            listViewResult.setAdapter(matchResultCustomAdapter);

                                            progressDialog.dismiss();


                                        } else {
                                            Log.d("ROY", "KnockoutFragment(onComplete): " + task.getException());
                                        }
                                    }
                                });

                            }
                        } else {
                            Log.d("ROY", "get failed with ", task.getException());
                        }
                    }
                });

            }
        }else {

            /*####################### If internet is not connected ##################################*/
            Toast.makeText(getContext(), "Internet is not connected", Toast.LENGTH_SHORT).show();

            if (SelectedLanguage.lang.equals("english")) {

                tvHeading.setText("Match Results");
                for (int i = 0; i <= 63; i++) {
                    scores[i] = sharedPref.getString("scores"+i, null);
                }

                MatchResult match1 = new MatchResult(getResources().getString(R.string.russia_e), getResources().getString(R.string.soudi_arab_e), "Match 1", scores[0]);

                MatchResult match2 = new MatchResult(getResources().getString(R.string.egypt_e), getResources().getString(R.string.Uruguay_e), "Match 2", scores[1]);
                MatchResult match3 = new MatchResult(getResources().getString(R.string.Morocco_e), getResources().getString(R.string.Iran_e), "Match 3", scores[2]);
                MatchResult match4 = new MatchResult(getResources().getString(R.string.Portugal_e), getResources().getString(R.string.Spain_e), "Match 4", scores[3]);

                //16 - 3
                MatchResult match5 = new MatchResult(getResources().getString(R.string.France_e), getResources().getString(R.string.Australia_e), "Match 5", scores[4]);
                MatchResult match6 = new MatchResult(getResources().getString(R.string.Argentina_e), getResources().getString(R.string.Iceland_e), "Match 6", scores[5]);
                MatchResult match7 = new MatchResult(getResources().getString(R.string.Peru_e), getResources().getString(R.string.Denmark_e), "Match 7", scores[6]);
                MatchResult match8 = new MatchResult(getResources().getString(R.string.Nigeria_e), getResources().getString(R.string.Croatia_e), "Match 8", scores[7]);

                //17 - 4
                MatchResult match9 = new MatchResult(getResources().getString(R.string.Costa_Rica_e), getResources().getString(R.string.Serbia_e), "Match 9", scores[8]);
                MatchResult match10 = new MatchResult(getResources().getString(R.string.Germany_e), getResources().getString(R.string.Mexico_e), "Match 10", scores[9]);
                MatchResult match11 = new MatchResult(getResources().getString(R.string.Brazil_e), getResources().getString(R.string.Switzerland_e), "Match 11", scores[10]);

                //18 - 5
                MatchResult match12 = new MatchResult(getResources().getString(R.string.Sweden_e), getResources().getString(R.string.Korea_Republic_e), "Match 12", scores[11]);
                MatchResult match13 = new MatchResult(getResources().getString(R.string.Belgium_e), getResources().getString(R.string.Panama_e), "Match 13", scores[12]);
                MatchResult match14 = new MatchResult(getResources().getString(R.string.England_e), getResources().getString(R.string.Tunisia_e), "Match 14", scores[13]);

                //19 - 6
                MatchResult match15 = new MatchResult(getResources().getString(R.string.Poland_e), getResources().getString(R.string.Senegal_e), "Match 15", scores[14]);
                MatchResult match16 = new MatchResult(getResources().getString(R.string.Colombia_e), getResources().getString(R.string.Japan_e), "Match 16", scores[15]);
                MatchResult match17 = new MatchResult(getResources().getString(R.string.russia_e), getResources().getString(R.string.egypt_e), "Match 17", scores[16]);

                //20 - 7
                MatchResult match18 = new MatchResult(getResources().getString(R.string.Portugal_e), getResources().getString(R.string.Morocco_e), "Match 18", scores[17]);
                MatchResult match19 = new MatchResult(getResources().getString(R.string.Uruguay_e), getResources().getString(R.string.soudi_arab_e), "Match 19", scores[18]);
                MatchResult match20 = new MatchResult(getResources().getString(R.string.Spain_e), getResources().getString(R.string.Iran_e), "Match 20", scores[19]);

                //21 - 8
                MatchResult match21 = new MatchResult(getResources().getString(R.string.France_e), getResources().getString(R.string.Peru_e), "Match 21", scores[20]);
                MatchResult match22 = new MatchResult(getResources().getString(R.string.Denmark_e), getResources().getString(R.string.Australia_e), "Match 22", scores[21]);
                MatchResult match23 = new MatchResult(getResources().getString(R.string.Argentina_e), getResources().getString(R.string.Croatia_e), "Match 23", scores[22]);

                //22 - 9
                MatchResult match24 = new MatchResult(getResources().getString(R.string.Brazil_e), getResources().getString(R.string.Costa_Rica_e), "Match 24", scores[23]);
                MatchResult match25 = new MatchResult(getResources().getString(R.string.Nigeria_e), getResources().getString(R.string.Iceland_e), "Match 25", scores[24]);
                MatchResult match26 = new MatchResult(getResources().getString(R.string.Serbia_e), getResources().getString(R.string.Switzerland_e), "Match 26", scores[25]);

                //23 - 10
                MatchResult match27 = new MatchResult(getResources().getString(R.string.Belgium_e), getResources().getString(R.string.Tunisia_e), "Match 27", scores[26]);
                MatchResult match28 = new MatchResult(getResources().getString(R.string.Germany_e), getResources().getString(R.string.Sweden_e), "Match 28", scores[27]);
                MatchResult match29 = new MatchResult(getResources().getString(R.string.Korea_Republic_e), getResources().getString(R.string.Mexico_e), "Match 29", scores[28]);

                //24 - 11
                MatchResult match30 = new MatchResult(getResources().getString(R.string.England_e), getResources().getString(R.string.Panama_e), "Match 30", scores[29]);
                MatchResult match31 = new MatchResult(getResources().getString(R.string.Japan_e), getResources().getString(R.string.Senegal_e), "Match 31", scores[30]);
                MatchResult match32 = new MatchResult(getResources().getString(R.string.Poland_e), getResources().getString(R.string.Colombia_e), "Match 32", scores[31]);

                //25 - 12
                MatchResult match33 = new MatchResult(getResources().getString(R.string.soudi_arab_e), getResources().getString(R.string.egypt_e), "Match 33", scores[32]);
                MatchResult match34 = new MatchResult(getResources().getString(R.string.Uruguay_e), getResources().getString(R.string.russia_e), "Match 34", scores[33]);
                MatchResult match35 = new MatchResult(getResources().getString(R.string.Portugal_e), getResources().getString(R.string.Iran_e), "Match 35", scores[34]);
                MatchResult match36 = new MatchResult(getResources().getString(R.string.Spain_e), getResources().getString(R.string.Morocco_e), "Match 36", scores[35]);

                //26 - 13
                MatchResult match37 = new MatchResult(getResources().getString(R.string.Australia_e), getResources().getString(R.string.Peru_e), "Match 37", scores[36]);
                MatchResult match38 = new MatchResult(getResources().getString(R.string.France_e), getResources().getString(R.string.Denmark_e), "Match 38", scores[37]);
                MatchResult match39 = new MatchResult(getResources().getString(R.string.Iceland_e), getResources().getString(R.string.Croatia_e), "Match 39", scores[38]);
                MatchResult match40 = new MatchResult(getResources().getString(R.string.Argentina_e), getResources().getString(R.string.Nigeria_e), "Match 40", scores[39]);

                //27 - 14
                MatchResult match41 = new MatchResult(getResources().getString(R.string.Germany_e), getResources().getString(R.string.Korea_Republic_e), "Match 41", scores[40]);
                MatchResult match42 = new MatchResult(getResources().getString(R.string.Mexico_e), getResources().getString(R.string.Sweden_e), "Match 42", scores[41]);
                MatchResult match43 = new MatchResult(getResources().getString(R.string.Switzerland_e), getResources().getString(R.string.Costa_Rica_e), "Match 43", scores[42]);
                MatchResult match44 = new MatchResult(getResources().getString(R.string.Brazil_e), getResources().getString(R.string.Serbia_e), "Match 44", scores[43]);

                //28 - 15
                MatchResult match45 = new MatchResult(getResources().getString(R.string.Japan_e), getResources().getString(R.string.Poland_e), "Match 45", scores[44]);
                MatchResult match46 = new MatchResult(getResources().getString(R.string.Senegal_e), getResources().getString(R.string.Colombia_e), "Match 46", scores[45]);
                MatchResult match47 = new MatchResult(getResources().getString(R.string.England_e), getResources().getString(R.string.Belgium_e), "Match 47", scores[46]);
                MatchResult match48 = new MatchResult(getResources().getString(R.string.Panama_e), getResources().getString(R.string.Tunisia_e), "Match 48", scores[47]);


                matchResults = new ArrayList<>();
                matchResults.add(match1);
                matchResults.add(match2);
                matchResults.add(match3);
                matchResults.add(match4);
                matchResults.add(match5);
                matchResults.add(match6);
                matchResults.add(match7);
                matchResults.add(match8);
                matchResults.add(match9);
                matchResults.add(match10);
                matchResults.add(match11);
                matchResults.add(match12);
                matchResults.add(match13);
                matchResults.add(match14);
                matchResults.add(match15);
                matchResults.add(match16);
                matchResults.add(match17);
                matchResults.add(match18);
                matchResults.add(match19);
                matchResults.add(match20);
                matchResults.add(match21);
                matchResults.add(match22);
                matchResults.add(match23);
                matchResults.add(match24);
                matchResults.add(match25);
                matchResults.add(match26);
                matchResults.add(match27);
                matchResults.add(match28);
                matchResults.add(match29);
                matchResults.add(match30);
                matchResults.add(match31);
                matchResults.add(match32);
                matchResults.add(match33);
                matchResults.add(match34);
                matchResults.add(match35);
                matchResults.add(match36);
                matchResults.add(match37);
                matchResults.add(match38);
                matchResults.add(match39);
                matchResults.add(match40);
                matchResults.add(match41);
                matchResults.add(match42);
                matchResults.add(match43);
                matchResults.add(match44);
                matchResults.add(match45);
                matchResults.add(match46);
                matchResults.add(match47);
                matchResults.add(match48);



                String[] teams = new String[32];
                String[] teamBs = new String[32];

                for (int i=0; i<teams.length;i++){
                    teams[i] = sharedPref.getString("teamsResult"+i, null );
                    teamBs[i] = sharedPref.getString("teamBsResult"+i, null );
                }
                //Log.d("ROY", "onComplete: "+dataMap.get("name"));


                //30 -16
                MatchResult match49 = new MatchResult(teamBs[0], teamBs[1], "Match 49", scores[48]);
                MatchResult match50 = new MatchResult(teamBs[2], teamBs[3], "Match 50", scores[49]);

                //1 -17
                MatchResult match51 = new MatchResult(teamBs[4], teamBs[5], "Match 51", scores[50]);
                MatchResult match52 = new MatchResult(teamBs[6], teamBs[7], "Match 52", scores[51]);


                //2 -18
                MatchResult match53 = new MatchResult(teamBs[8], teamBs[9], "Match 53", scores[52]);
                MatchResult match54 = new MatchResult(teamBs[10], teamBs[11], "Match 54", scores[53]);


                //3 -19
                MatchResult match55 = new MatchResult(teamBs[12], teamBs[13], "Match 55", scores[54]);
                MatchResult match56 = new MatchResult(teamBs[14], teamBs[15], "Match 56", scores[55]);


                //6 -20 (cuarter)
                MatchResult match57 = new MatchResult(teamBs[16], teamBs[17], "Match 57", scores[56]);
                MatchResult match58 = new MatchResult(teamBs[18], teamBs[19], "Match 58", scores[57]);

                //7 -21
                MatchResult match59 = new MatchResult(teamBs[20], teamBs[21], "Match 59", scores[58]);
                MatchResult match60 = new MatchResult(teamBs[22], teamBs[23], "Match 60", scores[59]);


                //10 -22(semi)
                MatchResult match61 = new MatchResult(teamBs[24], teamBs[25], "Match 61", scores[60]);

                //11 -23
                MatchResult match62 = new MatchResult(teamBs[26], teamBs[27], "Match 62", scores[61]);

                //14 -24
                MatchResult match63 = new MatchResult(teamBs[28], teamBs[29], "Match 63", scores[62]);

                //15 -25
                MatchResult match64 = new MatchResult(teamBs[30], teamBs[31], "Match 64", scores[63]);


                matchResults.add(match49);
                matchResults.add(match50);
                matchResults.add(match51);
                matchResults.add(match52);
                matchResults.add(match53);
                matchResults.add(match54);
                matchResults.add(match55);
                matchResults.add(match56);
                matchResults.add(match57);
                matchResults.add(match58);
                matchResults.add(match59);
                matchResults.add(match60);
                matchResults.add(match61);
                matchResults.add(match62);
                matchResults.add(match63);
                matchResults.add(match64);


                matchResultCustomAdapter = new MatchResultCustomAdapter(getContext(), matchResults);
                listViewResult.setAdapter(matchResultCustomAdapter);



            }else {

                tvHeading.setText("ফলাফল");
                for (int i = 0; i <= 63; i++) {
                    scores[i] = sharedPref.getString("scores1"+i, null);
                }

                MatchResult match1 = new MatchResult(getResources().getString(R.string.russia), getResources().getString(R.string.soudi_arab), "ম্যাচ ১", scores[0]);

                MatchResult match2 = new MatchResult(getResources().getString(R.string.egypt), getResources().getString(R.string.Uruguay), "ম্যাচ ২", scores[1]);
                MatchResult match3 = new MatchResult(getResources().getString(R.string.Morocco), getResources().getString(R.string.Iran), "ম্যাচ ৩", scores[2]);
                MatchResult match4 = new MatchResult(getResources().getString(R.string.Portugal), getResources().getString(R.string.Spain), "ম্যাচ ৪", scores[3]);

                //16 - 3
                MatchResult match5 = new MatchResult(getResources().getString(R.string.France), getResources().getString(R.string.Australia), "ম্যাচ ৫", scores[4]);
                MatchResult match6 = new MatchResult(getResources().getString(R.string.Argentina), getResources().getString(R.string.Iceland), "ম্যাচ ৬", scores[5]);
                MatchResult match7 = new MatchResult(getResources().getString(R.string.Peru), getResources().getString(R.string.Denmark), "ম্যাচ ৭", scores[6]);
                MatchResult match8 = new MatchResult(getResources().getString(R.string.Nigeria), getResources().getString(R.string.Croatia), "ম্যাচ ৮", scores[7]);

                //17 - 4
                MatchResult match9 = new MatchResult(getResources().getString(R.string.Costa_Rica), getResources().getString(R.string.Serbia), "ম্যাচ ৯", scores[8]);
                MatchResult match10 = new MatchResult(getResources().getString(R.string.Germany), getResources().getString(R.string.Mexico), "ম্যাচ ১০", scores[9]);
                MatchResult match11 = new MatchResult(getResources().getString(R.string.Brazil), getResources().getString(R.string.Switzerland), "ম্যাচ ১১", scores[10]);

                //18 - 5
                MatchResult match12 = new MatchResult(getResources().getString(R.string.Sweden), getResources().getString(R.string.Korea_Republic), "ম্যাচ ১২", scores[11]);
                MatchResult match13 = new MatchResult(getResources().getString(R.string.Belgium), getResources().getString(R.string.Panama), "ম্যাচ ১৩", scores[12]);
                MatchResult match14 = new MatchResult(getResources().getString(R.string.England), getResources().getString(R.string.Tunisia), "ম্যাচ ১৪", scores[13]);

                //19 - 6
                MatchResult match15 = new MatchResult(getResources().getString(R.string.Poland), getResources().getString(R.string.Senegal), "ম্যাচ ১৫", scores[14]);
                MatchResult match16 = new MatchResult(getResources().getString(R.string.Colombia), getResources().getString(R.string.Japan), "ম্যাচ ১৬", scores[15]);
                MatchResult match17 = new MatchResult(getResources().getString(R.string.russia), getResources().getString(R.string.egypt), "ম্যাচ ১৭", scores[16]);

                //20 - 7
                MatchResult match18 = new MatchResult(getResources().getString(R.string.Portugal), getResources().getString(R.string.Morocco), "ম্যাচ ১৮", scores[17]);
                MatchResult match19 = new MatchResult(getResources().getString(R.string.Uruguay), getResources().getString(R.string.soudi_arab), "ম্যাচ ১৯", scores[18]);
                MatchResult match20 = new MatchResult(getResources().getString(R.string.Spain), getResources().getString(R.string.Iran), "ম্যাচ ২০", scores[19]);

                //21 - 8
                MatchResult match21 = new MatchResult(getResources().getString(R.string.France), getResources().getString(R.string.Peru), "ম্যাচ ২১", scores[20]);
                MatchResult match22 = new MatchResult(getResources().getString(R.string.Denmark), getResources().getString(R.string.Australia), "ম্যাচ ২২", scores[21]);
                MatchResult match23 = new MatchResult(getResources().getString(R.string.Argentina), getResources().getString(R.string.Croatia), "ম্যাচ ২৩", scores[22]);

                //22 - 9
                MatchResult match24 = new MatchResult(getResources().getString(R.string.Brazil), getResources().getString(R.string.Costa_Rica), "ম্যাচ ২৪", scores[23]);
                MatchResult match25 = new MatchResult(getResources().getString(R.string.Nigeria), getResources().getString(R.string.Iceland), "ম্যাচ ২৫", scores[24]);
                MatchResult match26 = new MatchResult(getResources().getString(R.string.Serbia), getResources().getString(R.string.Switzerland), "ম্যাচ ২৬", scores[25]);

                //23 - 10
                MatchResult match27 = new MatchResult(getResources().getString(R.string.Belgium), getResources().getString(R.string.Tunisia), "ম্যাচ ২৭", scores[26]);
                MatchResult match28 = new MatchResult(getResources().getString(R.string.Germany), getResources().getString(R.string.Sweden), "ম্যাচ ২৮", scores[27]);
                MatchResult match29 = new MatchResult(getResources().getString(R.string.Korea_Republic), getResources().getString(R.string.Mexico), "ম্যাচ ২৯", scores[28]);

                //24 - 11
                MatchResult match30 = new MatchResult(getResources().getString(R.string.England), getResources().getString(R.string.Panama), "ম্যাচ ৩০", scores[29]);
                MatchResult match31 = new MatchResult(getResources().getString(R.string.Japan), getResources().getString(R.string.Senegal), "ম্যাচ ৩১", scores[30]);
                MatchResult match32 = new MatchResult(getResources().getString(R.string.Poland), getResources().getString(R.string.Colombia), "ম্যাচ ৩২", scores[31]);

                //25 - 12
                MatchResult match33 = new MatchResult(getResources().getString(R.string.soudi_arab), getResources().getString(R.string.egypt), "ম্যাচ ৩৩", scores[32]);
                MatchResult match34 = new MatchResult(getResources().getString(R.string.Uruguay), getResources().getString(R.string.russia), "ম্যাচ ৩৪", scores[33]);
                MatchResult match35 = new MatchResult(getResources().getString(R.string.Portugal), getResources().getString(R.string.Iran), "ম্যাচ ৩৫", scores[34]);
                MatchResult match36 = new MatchResult(getResources().getString(R.string.Spain), getResources().getString(R.string.Morocco), "ম্যাচ ৩৬", scores[35]);

                //26 - 13
                MatchResult match37 = new MatchResult(getResources().getString(R.string.Australia), getResources().getString(R.string.Peru), "ম্যাচ ৩৭", scores[36]);
                MatchResult match38 = new MatchResult(getResources().getString(R.string.France), getResources().getString(R.string.Denmark), "ম্যাচ ৩৮", scores[37]);
                MatchResult match39 = new MatchResult(getResources().getString(R.string.Iceland), getResources().getString(R.string.Croatia), "ম্যাচ ৩৯", scores[38]);
                MatchResult match40 = new MatchResult(getResources().getString(R.string.Argentina), getResources().getString(R.string.Nigeria), "ম্যাচ ৪০", scores[39]);

                //27 - 14
                MatchResult match41 = new MatchResult(getResources().getString(R.string.Germany), getResources().getString(R.string.Korea_Republic), "ম্যাচ ৪১", scores[40]);
                MatchResult match42 = new MatchResult(getResources().getString(R.string.Mexico), getResources().getString(R.string.Sweden), "ম্যাচ ৪২", scores[41]);
                MatchResult match43 = new MatchResult(getResources().getString(R.string.Switzerland), getResources().getString(R.string.Costa_Rica), "ম্যাচ ৪৩", scores[42]);
                MatchResult match44 = new MatchResult(getResources().getString(R.string.Brazil), getResources().getString(R.string.Serbia), "ম্যাচ ৪৪", scores[43]);

                //28 - 15
                MatchResult match45 = new MatchResult(getResources().getString(R.string.Japan), getResources().getString(R.string.Poland), "ম্যাচ ৪৫", scores[44]);
                MatchResult match46 = new MatchResult(getResources().getString(R.string.Senegal), getResources().getString(R.string.Colombia), "ম্যাচ ৪৬", scores[45]);
                MatchResult match47 = new MatchResult(getResources().getString(R.string.England), getResources().getString(R.string.Belgium), "ম্যাচ ৪৭", scores[46]);
                MatchResult match48 = new MatchResult(getResources().getString(R.string.Panama), getResources().getString(R.string.Tunisia), "ম্যাচ ৪৮", scores[47]);

                matchResults = new ArrayList<>();
                matchResults.add(match1);
                matchResults.add(match2);
                matchResults.add(match3);
                matchResults.add(match4);
                matchResults.add(match5);
                matchResults.add(match6);
                matchResults.add(match7);
                matchResults.add(match8);
                matchResults.add(match9);
                matchResults.add(match10);
                matchResults.add(match11);
                matchResults.add(match12);
                matchResults.add(match13);
                matchResults.add(match14);
                matchResults.add(match15);
                matchResults.add(match16);
                matchResults.add(match17);
                matchResults.add(match18);
                matchResults.add(match19);
                matchResults.add(match20);
                matchResults.add(match21);
                matchResults.add(match22);
                matchResults.add(match23);
                matchResults.add(match24);
                matchResults.add(match25);
                matchResults.add(match26);
                matchResults.add(match27);
                matchResults.add(match28);
                matchResults.add(match29);
                matchResults.add(match30);
                matchResults.add(match31);
                matchResults.add(match32);
                matchResults.add(match33);
                matchResults.add(match34);
                matchResults.add(match35);
                matchResults.add(match36);
                matchResults.add(match37);
                matchResults.add(match38);
                matchResults.add(match39);
                matchResults.add(match40);
                matchResults.add(match41);
                matchResults.add(match42);
                matchResults.add(match43);
                matchResults.add(match44);
                matchResults.add(match45);
                matchResults.add(match46);
                matchResults.add(match47);
                matchResults.add(match48);




                String[] teams = new String[32];
                String[] teamBs = new String[32];

                for (int i=0; i<teams.length;i++){
                    teams[i] = sharedPref.getString("teamsResult1"+i, null );
                    teamBs[i] = sharedPref.getString("teamBsResult1"+i, null );
                }



                //30 -16
                MatchResult match49 = new MatchResult(teamBs[0], teamBs[1], "ম্যাচ ৪৯", scores[48]);
                MatchResult match50 = new MatchResult(teamBs[2], teamBs[3], "ম্যাচ ৫০", scores[49]);

                //1 -17
                MatchResult match51 = new MatchResult(teamBs[4], teamBs[5], "ম্যাচ ৫১", scores[50]);
                MatchResult match52 = new MatchResult(teamBs[6], teamBs[7], "ম্যাচ ৫২", scores[51]);


                //2 -18
                MatchResult match53 = new MatchResult(teamBs[8], teamBs[9], "ম্যাচ ৫৩", scores[52]);
                MatchResult match54 = new MatchResult(teamBs[10], teamBs[11], "ম্যাচ ৫৪", scores[53]);


                //3 -19
                MatchResult match55 = new MatchResult(teamBs[12], teamBs[13], "ম্যাচ ৫৫", scores[54]);
                MatchResult match56 = new MatchResult(teamBs[14], teamBs[15], "ম্যাচ ৫৬", scores[55]);


                //6 -20 (cuarter)
                MatchResult match57 = new MatchResult(teamBs[16], teamBs[17], "ম্যাচ ৫৭", scores[56]);
                MatchResult match58 = new MatchResult(teamBs[18], teamBs[19], "ম্যাচ ৫৮", scores[57]);

                //7 -21
                MatchResult match59 = new MatchResult(teamBs[20], teamBs[21], "ম্যাচ ৫৯", scores[58]);
                MatchResult match60 = new MatchResult(teamBs[22], teamBs[23], "ম্যাচ ৬০", scores[59]);


                //10 -22(semi)
                MatchResult match61 = new MatchResult(teamBs[24], teamBs[25], "ম্যাচ ৬১", scores[60]);

                //11 -23
                MatchResult match62 = new MatchResult(teamBs[26], teamBs[27], "ম্যাচ ৬২", scores[61]);

                //14 -24
                MatchResult match63 = new MatchResult(teamBs[28], teamBs[29], "ম্যাচ ৬৩", scores[62]);

                //15 -25
                MatchResult match64 = new MatchResult(teamBs[30], teamBs[31], "ম্যাচ ৬৪", scores[63]);


                matchResults.add(match49);
                matchResults.add(match50);
                matchResults.add(match51);
                matchResults.add(match52);
                matchResults.add(match53);
                matchResults.add(match54);
                matchResults.add(match55);
                matchResults.add(match56);
                matchResults.add(match57);
                matchResults.add(match58);
                matchResults.add(match59);
                matchResults.add(match60);
                matchResults.add(match61);
                matchResults.add(match62);
                matchResults.add(match63);
                matchResults.add(match64);


                matchResultCustomAdapter = new MatchResultCustomAdapter(getContext(), matchResults);
                listViewResult.setAdapter(matchResultCustomAdapter);



            }

        }


        listViewResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getContext(), "Position: "+position, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    /*################# Refresh the fragment when tab is changed ########################*/
    public void setUserVisibleHint1(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }



}
