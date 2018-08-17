package invenz.example.bijohn.fifawc2018.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bijohn.fifawc2018.R;
import invenz.example.bijohn.fifawc2018.SelectedLanguage;
import invenz.example.bijohn.fifawc2018.adapter.GroupCustomAdapter;
import invenz.example.bijohn.fifawc2018.model.Group;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class GroupFragment extends Fragment {

    private ListView listViewGroup;
    private GroupCustomAdapter groupCustomAdapter;
    private List<Group> groupList ;
    private TextView tvHeading;


    private Integer australia = R.drawable.australia;
    private Integer argentina = R.drawable.argentina;
    private Integer brazil = R.drawable.brazil;
    private Integer belgium = R.drawable.belgium;
    private Integer colombia = R.drawable.colombia;
    private Integer costa = R.drawable.costa;
    private Integer croatia = R.drawable.croatia;
    private Integer colombiaa = R.drawable.colombia;
    private Integer denmark = R.drawable.denmark;
    private Integer egypt = R.drawable.egypt;
    private Integer england = R.drawable.england;
    private Integer france = R.drawable.france;
    private Integer germany = R.drawable.germany;
    private Integer iceland = R.drawable.iceland;
    private Integer iran = R.drawable.iran;
    private Integer japan = R.drawable.japan;
    private Integer mexico = R.drawable.mexico;
    private Integer morocco = R.drawable.morocco;
    private Integer nigeria = R.drawable.nigeria;
    private Integer panama = R.drawable.panama;
    private Integer peru = R.drawable.peru;
    private Integer poland = R.drawable.poland;
    private Integer portugal = R.drawable.portugal;
    private Integer russia = R.drawable.russia;
    private Integer senegal = R.drawable.senegal;
    private Integer serbia = R.drawable.serbia;
    private Integer soudi_arab = R.drawable.soudi_arab;
    private Integer spain = R.drawable.spain;
    private Integer sweden = R.drawable.sweden;
    private Integer switzerland = R.drawable.switzerland;
    private Integer tunisia = R.drawable.tunisia;
    private Integer uruguya = R.drawable.uruguya;
    private Integer korea = R.drawable.korea;



    public GroupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_group, container, false);
        listViewGroup = view.findViewById(R.id.idGroupTable);
        tvHeading = view.findViewById(R.id.idGroupHeading);

        if (SelectedLanguage.lang.equals("english")){
            tvHeading.setText("Group Tables");

            Group groupA = new Group(getResources().getString(R.string.russia_e),getResources().getString(R.string.soudi_arab_e),getResources().getString(R.string.egypt_e),getResources().getString(R.string.Uruguay_e), "Group - A", russia, soudi_arab, egypt, uruguya);
            Group groupB = new Group(getResources().getString(R.string.Portugal_e),getResources().getString(R.string.Spain_e),getResources().getString(R.string.Morocco_e),getResources().getString(R.string.Iran_e), "Group - B", portugal, spain, morocco, iran);
            Group groupC = new Group(getResources().getString(R.string.France_e),getResources().getString(R.string.Australia_e),getResources().getString(R.string.Peru_e),getResources().getString(R.string.Denmark_e), "Group - C", france, australia, peru, denmark);
            Group groupD = new Group(getResources().getString(R.string.Argentina_e),getResources().getString(R.string.Iceland_e),getResources().getString(R.string.Croatia_e),getResources().getString(R.string.Nigeria_e), "Group - D", argentina, iceland, croatia, nigeria);

            Group groupE = new Group(getResources().getString(R.string.Brazil_e),getResources().getString(R.string.Switzerland_e),getResources().getString(R.string.Costa_Rica_e),getResources().getString(R.string.Serbia_e), "Group - E", brazil, switzerland, costa, serbia);
            Group groupF = new Group(getResources().getString(R.string.Germany_e),getResources().getString(R.string.Mexico_e),getResources().getString(R.string.Sweden_e),getResources().getString(R.string.Korea_Republic_e), "Group - F", germany, mexico, sweden, korea);
            Group groupG = new Group(getResources().getString(R.string.Belgium_e),getResources().getString(R.string.Panama_e),getResources().getString(R.string.Tunisia_e),getResources().getString(R.string.England_e), "Group - G", belgium, panama, tunisia, england);
            Group groupH = new Group(getResources().getString(R.string.Poland_e),getResources().getString(R.string.Senegal_e),getResources().getString(R.string.Colombia_e),getResources().getString(R.string.Japan_e), "Group - H", poland, senegal, colombia, japan);

            groupList = new ArrayList<>();
            groupList.add(groupA);
            groupList.add(groupB);
            groupList.add(groupC);
            groupList.add(groupD);
            groupList.add(groupE);
            groupList.add(groupF);
            groupList.add(groupG);
            groupList.add(groupH);


            groupCustomAdapter = new GroupCustomAdapter(getContext(), groupList);
            listViewGroup.setAdapter(groupCustomAdapter);



            return view;
        }else {

            tvHeading.setText("গ্রুপ টেবিল");

            Group groupA = new Group(getResources().getString(R.string.russia),getResources().getString(R.string.soudi_arab),getResources().getString(R.string.egypt),getResources().getString(R.string.Uruguay), "গ্রুপ - এ", russia, soudi_arab, egypt, uruguya);
            Group groupB = new Group(getResources().getString(R.string.Portugal),getResources().getString(R.string.Spain),getResources().getString(R.string.Morocco),getResources().getString(R.string.Iran), "গ্রুপ - বি", portugal, spain, morocco, iran);
            Group groupC = new Group(getResources().getString(R.string.France),getResources().getString(R.string.Australia),getResources().getString(R.string.Peru),getResources().getString(R.string.Denmark), "গ্রুপ - সি", france, australia, peru, denmark);
            Group groupD = new Group(getResources().getString(R.string.Argentina),getResources().getString(R.string.Iceland),getResources().getString(R.string.Croatia),getResources().getString(R.string.Nigeria), "গ্রুপ - ডি", argentina, iceland, croatia, nigeria);

            Group groupE = new Group(getResources().getString(R.string.Brazil),getResources().getString(R.string.Switzerland),getResources().getString(R.string.Costa_Rica),getResources().getString(R.string.Serbia), "গ্রুপ - ই", brazil, switzerland, costa, serbia);
            Group groupF = new Group(getResources().getString(R.string.Germany),getResources().getString(R.string.Mexico),getResources().getString(R.string.Sweden),getResources().getString(R.string.Korea_Republic), "গ্রুপ - এফ", germany, mexico, sweden, korea);
            Group groupG = new Group(getResources().getString(R.string.Belgium),getResources().getString(R.string.Panama),getResources().getString(R.string.Tunisia),getResources().getString(R.string.England), "গ্রুপ - জি", belgium, panama, tunisia, england);
            Group groupH = new Group(getResources().getString(R.string.Poland),getResources().getString(R.string.Senegal),getResources().getString(R.string.Colombia),getResources().getString(R.string.Japan), "গ্রুপ - এইচ", poland, senegal, colombia, japan);

            groupList = new ArrayList<>();
            groupList.add(groupA);
            groupList.add(groupB);
            groupList.add(groupC);
            groupList.add(groupD);
            groupList.add(groupE);
            groupList.add(groupF);
            groupList.add(groupG);
            groupList.add(groupH);


            groupCustomAdapter = new GroupCustomAdapter(getContext(), groupList);
            listViewGroup.setAdapter(groupCustomAdapter);



            return view;
        }



    }

}
