package invenz.example.bijohn.fifawc2018.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import invenz.example.bijohn.fifawc2018.IsInternetConnected;
import invenz.example.bijohn.fifawc2018.SelectedLanguage;
import invenz.example.bijohn.fifawc2018.adapter.PointTableCutomAdapter;
import com.example.bijohn.fifawc2018.R;
import invenz.example.bijohn.fifawc2018.model.PointTable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class PointTableFragment extends Fragment {

    private ListView listViewPointTable;
    private FirebaseFirestore firestore;
    private SwipeRefreshLayout swipeRefreshLayout, swipeRefreshLayout1;
    private ProgressDialog progressDialog;
    private TextView tvHeading, tvNetNeeded;
    private LinearLayout headTextLinearLayout, mainLayout, mainLayout2;


    private Map<Integer, PointTable> map1;
    private List<PointTable> pointTablesA, pointTablesB, pointTablesC, pointTablesD, pointTablesE, pointTablesF, pointTablesG, pointTablesH, allPointTables;
    private List<List<PointTable>> listOfPointTableLists;
    private PointTableCutomAdapter pointTableCutomAdapter;
    int i = 1;


    public PointTableFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_point_table, container, false);
        listViewPointTable = view.findViewById(R.id.idPointTableList_PointTable);
        tvHeading = view.findViewById(R.id.idHeading_pointTableFrag);
        listOfPointTableLists = new ArrayList<>();
        swipeRefreshLayout = view.findViewById(R.id.idSwipeLayout_PointTable);
        swipeRefreshLayout1 = view.findViewById(R.id.idSwipeLayout1_PointTable);
        headTextLinearLayout = view.findViewById(R.id.idHeadLayout_pointFrag);
        mainLayout = view.findViewById(R.id.idMainLayout_pointfrag);
        mainLayout2 = view.findViewById(R.id.idMainLayout2_pointfrag);
        tvNetNeeded = view.findViewById(R.id.idNetRequired_pointFrag);


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

        swipeRefreshLayout1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //Toast.makeText(getContext(), "Refreshed", Toast.LENGTH_SHORT).show();
                setUserVisibleHint1(true);
            }
        });


        /*######################*/
        firestore = FirebaseFirestore.getInstance();

        map1 = new HashMap<>();
        pointTablesA = new ArrayList<>();
        pointTablesB = new ArrayList<>();
        pointTablesC = new ArrayList<>();
        pointTablesD = new ArrayList<>();
        pointTablesE = new ArrayList<>();
        pointTablesF = new ArrayList<>();
        pointTablesG = new ArrayList<>();
        pointTablesH = new ArrayList<>();


        if (isInternetConnected.isConnected(getActivity())) {


            if (SelectedLanguage.lang.equals("english")) {
                /*######################*/
                firestore.collection("pointTable").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (DocumentSnapshot document : task.getResult()) {

                                        tvHeading.setText("Standings");
                                        Log.d("ROY", document.getId() + " => " + document.getData());

                                        Map<String, Object> map = document.getData();

                                        //a
                                        if (map.get("name").equals("russia") || map.get("name").equals("soudi_arab") || map.get("name").equals("egypt") || map.get("name").equals("Uruguay")) {

                                            int mystring = getResources().getIdentifier(map.get("name").toString() + "_e", "string", getContext().getPackageName());
                                            String teamName = getResources().getString(mystring);

                                            pointTablesA.add(new PointTable(teamName, map.get("mpE").toString(), map.get("wE").toString(), map.get("lE").toString(), map.get("dE").toString(), map.get("gd").toString(), map.get("pts").toString(), Integer.parseInt(map.get("gd").toString()), Integer.parseInt(map.get("pts").toString())));
                                        }

                                        //b
                                        if (map.get("name").equals("Portugal") || map.get("name").equals("Spain") || map.get("name").equals("Morocco") || map.get("name").equals("Iran")) {
                                            int mystring = getResources().getIdentifier(map.get("name").toString() + "_e", "string", getContext().getPackageName());
                                            String teamName = getResources().getString(mystring);

                                            pointTablesB.add(new PointTable(teamName, map.get("mpE").toString(), map.get("wE").toString(), map.get("lE").toString(), map.get("dE").toString(), map.get("gd").toString(), map.get("pts").toString(), Integer.parseInt(map.get("gd").toString()), Integer.parseInt(map.get("pts").toString())));
                                        }

                                        //c
                                        if (map.get("name").equals("France") || map.get("name").equals("Australia") || map.get("name").equals("Peru") || map.get("name").equals("Denmark")) {
                                            int mystring = getResources().getIdentifier(map.get("name").toString() + "_e", "string", getContext().getPackageName());
                                            String teamName = getResources().getString(mystring);
                                            pointTablesC.add(new PointTable(teamName, map.get("mpE").toString(), map.get("wE").toString(), map.get("lE").toString(), map.get("dE").toString(), map.get("gd").toString(), map.get("pts").toString(), Integer.parseInt(map.get("gd").toString()), Integer.parseInt(map.get("pts").toString())));
                                        }

                                        //d
                                        if (map.get("name").equals("Argentina") || map.get("name").equals("Iceland") || map.get("name").equals("Croatia") || map.get("name").equals("Nigeria")) {
                                            int mystring = getResources().getIdentifier(map.get("name").toString() + "_e", "string", getContext().getPackageName());
                                            String teamName = getResources().getString(mystring);
                                            pointTablesD.add(new PointTable(teamName, map.get("mpE").toString(), map.get("wE").toString(), map.get("lE").toString(), map.get("dE").toString(), map.get("gd").toString(), map.get("pts").toString(), Integer.parseInt(map.get("gd").toString()), Integer.parseInt(map.get("pts").toString())));
                                        }

                                        //e
                                        if (map.get("name").equals("Brazil") || map.get("name").equals("Switzerland") || map.get("name").equals("Costa_Rica") || map.get("name").equals("Serbia")) {
                                            int mystring = getResources().getIdentifier(map.get("name").toString() + "_e", "string", getContext().getPackageName());
                                            String teamName = getResources().getString(mystring);
                                            pointTablesE.add(new PointTable(teamName, map.get("mpE").toString(), map.get("wE").toString(), map.get("lE").toString(), map.get("dE").toString(), map.get("gd").toString(), map.get("pts").toString(), Integer.parseInt(map.get("gd").toString()), Integer.parseInt(map.get("pts").toString())));
                                        }

                                        //f
                                        if (map.get("name").equals("Germany") || map.get("name").equals("Mexico") || map.get("name").equals("Sweden") || map.get("name").equals("Korea_Republic")) {
                                            int mystring = getResources().getIdentifier(map.get("name").toString() + "_e", "string", getContext().getPackageName());
                                            String teamName = getResources().getString(mystring);
                                            pointTablesF.add(new PointTable(teamName, map.get("mpE").toString(), map.get("wE").toString(), map.get("lE").toString(), map.get("dE").toString(), map.get("gd").toString(), map.get("pts").toString(), Integer.parseInt(map.get("gd").toString()), Integer.parseInt(map.get("pts").toString())));
                                        }

                                        //g
                                        if (map.get("name").equals("Belgium") || map.get("name").equals("Panama") || map.get("name").equals("Tunisia") || map.get("name").equals("England")) {
                                            int mystring = getResources().getIdentifier(map.get("name").toString() + "_e", "string", getContext().getPackageName());
                                            String teamName = getResources().getString(mystring);
                                            pointTablesG.add(new PointTable(teamName, map.get("mpE").toString(), map.get("wE").toString(), map.get("lE").toString(), map.get("dE").toString(), map.get("gd").toString(), map.get("pts").toString(), Integer.parseInt(map.get("gd").toString()), Integer.parseInt(map.get("pts").toString())));
                                        }

                                        //h
                                        if (map.get("name").equals("Poland") || map.get("name").equals("Senegal") || map.get("name").equals("Colombia") || map.get("name").equals("Japan")) {
                                            int mystring = getResources().getIdentifier(map.get("name").toString() + "_e", "string", getContext().getPackageName());
                                            String teamName = getResources().getString(mystring);
                                            pointTablesH.add(new PointTable(teamName, map.get("mpE").toString(), map.get("wE").toString(), map.get("lE").toString(), map.get("dE").toString(), map.get("gd").toString(), map.get("pts").toString(), Integer.parseInt(map.get("gd").toString()), Integer.parseInt(map.get("pts").toString())));
                                        }
                                    }

                                    List<PointTable> pointTableListA = sortPointTable(pointTablesA);
                                    List<PointTable> pointTableListB = sortPointTable(pointTablesB);
                                    List<PointTable> pointTableListC = sortPointTable(pointTablesC);
                                    List<PointTable> pointTableListD = sortPointTable(pointTablesD);
                                    List<PointTable> pointTableListE = sortPointTable(pointTablesE);
                                    List<PointTable> pointTableListF = sortPointTable(pointTablesF);
                                    List<PointTable> pointTableListG = sortPointTable(pointTablesG);
                                    List<PointTable> pointTableListH = sortPointTable(pointTablesH);

                                    Iterator<PointTable> it = pointTableListA.iterator();
                                    while (it.hasNext()) {
                                        PointTable p = it.next();
                                        Log.d("LOG", "JOHN " + p.getName() + " : " + p.getGd() + " : " + p.getPts());
                                    }

                                    listOfPointTableLists.add(pointTableListA);

                                    listOfPointTableLists.add(pointTableListB);
                                    listOfPointTableLists.add(pointTableListC);
                                    listOfPointTableLists.add(pointTableListD);
                                    listOfPointTableLists.add(pointTableListE);
                                    listOfPointTableLists.add(pointTableListF);
                                    listOfPointTableLists.add(pointTableListG);
                                    listOfPointTableLists.add(pointTableListH);

                                    pointTableCutomAdapter = new PointTableCutomAdapter(getContext(), listOfPointTableLists);
                                    listViewPointTable.setAdapter(pointTableCutomAdapter);
                                    pointTableCutomAdapter.notifyDataSetChanged();

                                    progressDialog.dismiss();


                                } else {
                                    Log.d("ROY", "error getting documents: ", task.getException());
                                }
                            }
                        });
                /*######################*/

                /*##############################################*/
            } else {
                /*######################*/
                firestore.collection("pointTable").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {

                                    tvHeading.setText("পয়েন্ট টেবিল");

                                    for (DocumentSnapshot document : task.getResult()) {
                                        Log.d("ROY", document.getId() + " => " + document.getData());

                                        Map<String, Object> map = document.getData();

                                        //a
                                        if (map.get("name").equals("russia") || map.get("name").equals("soudi_arab") || map.get("name").equals("egypt") || map.get("name").equals("Uruguay")) {

                                            int mystring = getResources().getIdentifier(map.get("name").toString(), "string", getContext().getPackageName());
                                            String teamName = getResources().getString(mystring);

                                            pointTablesA.add(new PointTable(teamName, map.get("mp").toString(), map.get("w").toString(), map.get("l").toString(), map.get("d").toString(), map.get("gdB").toString(), map.get("ptsB").toString(), Integer.parseInt(map.get("gd").toString()), Integer.parseInt(map.get("pts").toString())));
                                        }

                                        //b
                                        if (map.get("name").equals("Portugal") || map.get("name").equals("Spain") || map.get("name").equals("Morocco") || map.get("name").equals("Iran")) {
                                            int mystring = getResources().getIdentifier(map.get("name").toString(), "string", getContext().getPackageName());
                                            String teamName = getResources().getString(mystring);

                                            pointTablesB.add(new PointTable(teamName, map.get("mp").toString(), map.get("w").toString(), map.get("l").toString(), map.get("d").toString(), map.get("gdB").toString(), map.get("ptsB").toString(), Integer.parseInt(map.get("gd").toString()), Integer.parseInt(map.get("pts").toString())));
                                        }

                                        //c
                                        if (map.get("name").equals("France") || map.get("name").equals("Australia") || map.get("name").equals("Peru") || map.get("name").equals("Denmark")) {
                                            int mystring = getResources().getIdentifier(map.get("name").toString(), "string", getContext().getPackageName());
                                            String teamName = getResources().getString(mystring);
                                            pointTablesC.add(new PointTable(teamName, map.get("mp").toString(), map.get("w").toString(), map.get("l").toString(), map.get("d").toString(), map.get("gdB").toString(), map.get("ptsB").toString(), Integer.parseInt(map.get("gd").toString()), Integer.parseInt(map.get("pts").toString())));
                                        }

                                        //d
                                        if (map.get("name").equals("Argentina") || map.get("name").equals("Iceland") || map.get("name").equals("Croatia") || map.get("name").equals("Nigeria")) {
                                            int mystring = getResources().getIdentifier(map.get("name").toString(), "string", getContext().getPackageName());
                                            String teamName = getResources().getString(mystring);
                                            pointTablesD.add(new PointTable(teamName, map.get("mp").toString(), map.get("w").toString(), map.get("l").toString(), map.get("d").toString(), map.get("gdB").toString(), map.get("ptsB").toString(), Integer.parseInt(map.get("gd").toString()), Integer.parseInt(map.get("pts").toString())));
                                        }

                                        //e
                                        if (map.get("name").equals("Brazil") || map.get("name").equals("Switzerland") || map.get("name").equals("Costa_Rica") || map.get("name").equals("Serbia")) {
                                            int mystring = getResources().getIdentifier(map.get("name").toString(), "string", getContext().getPackageName());
                                            String teamName = getResources().getString(mystring);
                                            pointTablesE.add(new PointTable(teamName, map.get("mp").toString(), map.get("w").toString(), map.get("l").toString(), map.get("d").toString(), map.get("gdB").toString(), map.get("ptsB").toString(), Integer.parseInt(map.get("gd").toString()), Integer.parseInt(map.get("pts").toString())));
                                        }

                                        //f
                                        if (map.get("name").equals("Germany") || map.get("name").equals("Mexico") || map.get("name").equals("Sweden") || map.get("name").equals("Korea_Republic")) {
                                            int mystring = getResources().getIdentifier(map.get("name").toString(), "string", getContext().getPackageName());
                                            String teamName = getResources().getString(mystring);
                                            pointTablesF.add(new PointTable(teamName, map.get("mp").toString(), map.get("w").toString(), map.get("l").toString(), map.get("d").toString(), map.get("gdB").toString(), map.get("ptsB").toString(), Integer.parseInt(map.get("gd").toString()), Integer.parseInt(map.get("pts").toString())));
                                        }

                                        //g
                                        if (map.get("name").equals("Belgium") || map.get("name").equals("Panama") || map.get("name").equals("Tunisia") || map.get("name").equals("England")) {
                                            int mystring = getResources().getIdentifier(map.get("name").toString(), "string", getContext().getPackageName());
                                            String teamName = getResources().getString(mystring);
                                            pointTablesG.add(new PointTable(teamName, map.get("mp").toString(), map.get("w").toString(), map.get("l").toString(), map.get("d").toString(), map.get("gdB").toString(), map.get("ptsB").toString(), Integer.parseInt(map.get("gd").toString()), Integer.parseInt(map.get("pts").toString())));
                                        }

                                        //h
                                        if (map.get("name").equals("Poland") || map.get("name").equals("Senegal") || map.get("name").equals("Colombia") || map.get("name").equals("Japan")) {
                                            int mystring = getResources().getIdentifier(map.get("name").toString(), "string", getContext().getPackageName());
                                            String teamName = getResources().getString(mystring);
                                            pointTablesH.add(new PointTable(teamName, map.get("mp").toString(), map.get("w").toString(), map.get("l").toString(), map.get("d").toString(), map.get("gdB").toString(), map.get("ptsB").toString(), Integer.parseInt(map.get("gd").toString()), Integer.parseInt(map.get("pts").toString())));
                                        }
                                    }

                                    List<PointTable> pointTableListA = sortPointTable(pointTablesA);
                                    List<PointTable> pointTableListB = sortPointTable(pointTablesB);
                                    List<PointTable> pointTableListC = sortPointTable(pointTablesC);
                                    List<PointTable> pointTableListD = sortPointTable(pointTablesD);
                                    List<PointTable> pointTableListE = sortPointTable(pointTablesE);
                                    List<PointTable> pointTableListF = sortPointTable(pointTablesF);
                                    List<PointTable> pointTableListG = sortPointTable(pointTablesG);
                                    List<PointTable> pointTableListH = sortPointTable(pointTablesH);

                                    Iterator<PointTable> it = pointTableListA.iterator();
                                    while (it.hasNext()) {
                                        PointTable p = it.next();
                                        Log.d("LOG", "JOHN " + p.getName() + " : " + p.getGd() + " : " + p.getPts());
                                    }

                                    listOfPointTableLists.add(pointTableListA);

                                    listOfPointTableLists.add(pointTableListB);
                                    listOfPointTableLists.add(pointTableListC);
                                    listOfPointTableLists.add(pointTableListD);
                                    listOfPointTableLists.add(pointTableListE);
                                    listOfPointTableLists.add(pointTableListF);
                                    listOfPointTableLists.add(pointTableListG);
                                    listOfPointTableLists.add(pointTableListH);

                                    pointTableCutomAdapter = new PointTableCutomAdapter(getContext(), listOfPointTableLists);
                                    listViewPointTable.setAdapter(pointTableCutomAdapter);
                                    pointTableCutomAdapter.notifyDataSetChanged();

                                    progressDialog.dismiss();


                                } else {
                                    Log.d("ROY", "error getting documents: ", task.getException());
                                }
                            }
                        });
                /*######################*/


                /*##############################################*/
            }
        }else {
            Toast.makeText(getContext(), "Internet Required", Toast.LENGTH_SHORT).show();
            headTextLinearLayout.setVisibility(View.GONE);
            headTextLinearLayout.setVisibility(View.INVISIBLE);
            tvNetNeeded.setVisibility(View.VISIBLE);
            mainLayout2.setVisibility(View.VISIBLE);
        }
        return view;
    }


    /*################# Refresh the fragment when tab is changed ########################*/
    public void setUserVisibleHint1(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }

    //#########################################
    //adding all the point tables in a single list
    private void getAllPointTable(List<PointTable> pointTableList) {

        Iterator<PointTable> it = pointTableList.iterator();
        while (it.hasNext()){
            PointTable pointTable = it.next();
            allPointTables.add(pointTable);
        }

    }


    //sorting arraylist
    private List<PointTable> sortPointTable(List<PointTable> pointTables) {

        Collections.sort(pointTables, new Comparator<PointTable>() {
            @Override
            public int compare(PointTable p1, PointTable p2) {
                int a = Integer.valueOf(p1.getPts()).compareTo(p2.getPts());

                if(p1.getPts() == p2.getPts()) {

                    return Integer.valueOf(p1.getGd()).compareTo(p2.getGd());
                }
                return a;
            }
        });

        Collections.reverse(pointTables);
        Iterator<PointTable> it = pointTables.iterator();
        while (it.hasNext()){
            PointTable p = it.next();
            Log.d("LOG", "onComplete:point table(reverse) "+p.getName()+" : "+p.getMp()+" : "+p.getW()+" : "+p.getL()+" : "+p.getD()+" : "+p.getGd()+" : "+p.getPts());
        }

        return pointTables;
    }
    //#########################################

}
