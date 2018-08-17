package invenz.example.bijohn.fifawc2018.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import invenz.example.bijohn.fifawc2018.SelectedLanguage;
import invenz.example.bijohn.fifawc2018.adapter.ExpandableListCustomAdapter;
import com.example.bijohn.fifawc2018.R;
import invenz.example.bijohn.fifawc2018.model.Match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FixtureFragment extends Fragment {


    private ExpandableListCustomAdapter customAdapter;
    private ExpandableListView expandableListView;
    private TextView headingText;
    private List<String> listDataHeader;
    private HashMap<String, List<Match>> listHash;

    private String[] date, matchNo;

    private Integer flag = R.drawable.logo1;
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




    public FixtureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_fixture, container, false);

        expandableListView = myView.findViewById(R.id.idExListView);
        headingText = myView.findViewById(R.id.idFixtureHeading);

        if (SelectedLanguage.lang.equals("english")){
            headingText.setText("Group Stage Matches");
        }else {
            headingText.setText("গ্রুপপর্বের সময়সূচী");
        }


        initData();
        customAdapter = new ExpandableListCustomAdapter(getContext(), listDataHeader, listHash);
        expandableListView.setAdapter(customAdapter);


        return myView;
    }




    /*############ MY METHOD #################*/
    private void initData() {

        //getResources().getStringArray()

        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        if (SelectedLanguage.lang.equals("english")){
            matchNo = getResources().getStringArray(R.array.match_num_eng);
            date = getResources().getStringArray(R.array.date_eng);

            for (String matchDate: date){
                listDataHeader.add(matchDate);
            }



            //14 -1
            Match match1 = new Match(getResources().getString(R.string.russia_e), getResources().getString(R.string.soudi_arab_e), getResources().getString(R.string.nine_e), getResources().getString(R.string.luzhniki_Stadium_e),matchNo[0], russia, soudi_arab);

            //15 - 2
            Match match2 = new Match(getResources().getString(R.string.egypt_e), getResources().getString(R.string.Uruguay_e),getResources().getString(R.string.six_e),getResources().getString(R.string.ekaterinburg_Arena_e),matchNo[1], egypt, uruguya);
            Match match3 = new Match(getResources().getString(R.string.Morocco_e), getResources().getString(R.string.Iran_e), getResources().getString(R.string.nine_e),getResources().getString(R.string.saint_Petersburg_Stadium_e), matchNo[2],morocco, iran);
            Match match4 = new Match(getResources().getString(R.string.Portugal_e), getResources().getString(R.string.Spain_e), getResources().getString(R.string.twelve_e),getResources().getString(R.string.fisht_Stadium_e),matchNo[3],portugal, spain);

            //16 - 3
            Match match5 = new Match(getResources().getString(R.string.France_e), getResources().getString(R.string.Australia_e),getResources().getString(R.string.four_e),getResources().getString(R.string.kazan_Arena_e),matchNo[4], france, australia);
            Match match6 = new Match(getResources().getString(R.string.Argentina_e), getResources().getString(R.string.Iceland_e),getResources().getString(R.string.seven_e),getResources().getString(R.string.spartak_Stadium_e),matchNo[5], argentina, iceland);
            Match match7 = new Match(getResources().getString(R.string.Peru_e), getResources().getString(R.string.Denmark_e),getResources().getString(R.string.ten_e),getResources().getString(R.string.mordovia_Arena_e),matchNo[6], peru, denmark);
            Match match8 = new Match(getResources().getString(R.string.Nigeria_e), getResources().getString(R.string.Croatia_e),getResources().getString(R.string.one_e),getResources().getString(R.string.kaliningrad_Stadium_e),matchNo[7], nigeria, croatia);

            //17 - 4
            Match match9 = new Match(getResources().getString(R.string.Costa_Rica_e), getResources().getString(R.string.Serbia_e),getResources().getString(R.string.six_e),getResources().getString(R.string.samara_Arena_e),matchNo[8], costa, serbia);
            Match match10 = new Match(getResources().getString(R.string.Germany_e), getResources().getString(R.string.Mexico_e),getResources().getString(R.string.nine_e),getResources().getString(R.string.luzhniki_Stadium_e),matchNo[9],germany, mexico);
            Match match11 = new Match(getResources().getString(R.string.Brazil_e), getResources().getString(R.string.Switzerland_e),getResources().getString(R.string.twelve_e),getResources().getString(R.string.rostov_Arena_e),matchNo[10],brazil, switzerland);

            //18 - 5
            Match match12 = new Match(getResources().getString(R.string.Sweden_e), getResources().getString(R.string.Korea_Republic_e),getResources().getString(R.string.six_e), getResources().getString(R.string.nizhny_Novgorod_Stadium_e),matchNo[11], sweden, korea);
            Match match13 = new Match(getResources().getString(R.string.Belgium_e), getResources().getString(R.string.Panama_e),getResources().getString(R.string.nine_e),getResources().getString(R.string.fisht_Stadium_e),matchNo[12],belgium, panama);
            Match match14 = new Match(getResources().getString(R.string.England_e), getResources().getString(R.string.Tunisia_e),getResources().getString(R.string.twelve_e),getResources().getString(R.string.volgograd_Stadium_e),matchNo[13], england, tunisia);

            //19 - 6
            Match match15 = new Match(getResources().getString(R.string.Poland_e), getResources().getString(R.string.Senegal_e),getResources().getString(R.string.six_e),getResources().getString(R.string.spartak_Stadium_e),matchNo[14], poland, senegal);
            Match match16 = new Match(getResources().getString(R.string.Colombia_e), getResources().getString(R.string.Japan_e),getResources().getString(R.string.nine_e),getResources().getString(R.string.mordovia_Arena_e),matchNo[15], colombia, japan);
            Match match17 = new Match(getResources().getString(R.string.russia_e), getResources().getString(R.string.egypt_e),getResources().getString(R.string.twelve_e),getResources().getString(R.string.saint_Petersburg_Stadium_e),matchNo[16],russia, egypt);

            //20 - 7
            Match match18 = new Match(getResources().getString(R.string.Portugal_e), getResources().getString(R.string.Morocco_e),getResources().getString(R.string.six_e),getResources().getString(R.string.luzhniki_Stadium_e),matchNo[17],portugal, morocco);
            Match match19 = new Match(getResources().getString(R.string.Uruguay_e), getResources().getString(R.string.soudi_arab_e),getResources().getString(R.string.nine_e),getResources().getString(R.string.rostov_Arena_e),matchNo[18],uruguya, soudi_arab);
            Match match20 = new Match(getResources().getString(R.string.Spain_e), getResources().getString(R.string.Iran_e),getResources().getString(R.string.twelve_e),getResources().getString(R.string.kazan_Arena_e),matchNo[19],spain, iran);

            //21 - 8
            Match match21 = new Match(getResources().getString(R.string.Denmark_e), getResources().getString(R.string.Australia_e),getResources().getString(R.string.six_e),getResources().getString(R.string.samara_Arena_e),matchNo[21], denmark, australia);
            Match match22 = new Match(getResources().getString(R.string.France_e), getResources().getString(R.string.Peru_e),getResources().getString(R.string.nine_e),getResources().getString(R.string.ekaterinburg_Arena_e),matchNo[20],france, peru);
            Match match23 = new Match(getResources().getString(R.string.Argentina_e), getResources().getString(R.string.Croatia_e),getResources().getString(R.string.twelve_e),getResources().getString(R.string.nizhny_Novgorod_Stadium_e),matchNo[22],argentina, croatia);

            //22 - 9
            Match match24 = new Match(getResources().getString(R.string.Brazil_e), getResources().getString(R.string.Costa_Rica_e),getResources().getString(R.string.six_e),getResources().getString(R.string.saint_Petersburg_Stadium_e),matchNo[23], brazil, costa);
            Match match25 = new Match(getResources().getString(R.string.Nigeria_e), getResources().getString(R.string.Iceland_e),getResources().getString(R.string.nine_e),getResources().getString(R.string.volgograd_Stadium_e),matchNo[24], nigeria, iceland);
            Match match26 = new Match(getResources().getString(R.string.Serbia_e), getResources().getString(R.string.Switzerland_e),getResources().getString(R.string.twelve_e),getResources().getString(R.string.kaliningrad_Stadium_e),matchNo[25], serbia, switzerland);

            //23 - 10
            Match match27 = new Match(getResources().getString(R.string.Belgium_e), getResources().getString(R.string.Tunisia_e),getResources().getString(R.string.six_e),getResources().getString(R.string.spartak_Stadium_e),matchNo[26], belgium, tunisia);
            Match match29 = new Match(getResources().getString(R.string.Germany_e), getResources().getString(R.string.Sweden_e),getResources().getString(R.string.twelve_e),getResources().getString(R.string.fisht_Stadium_e),matchNo[27],germany, sweden);
            Match match28 = new Match(getResources().getString(R.string.Korea_Republic_e), getResources().getString(R.string.Mexico_e),getResources().getString(R.string.nine_e),getResources().getString(R.string.rostov_Arena_e),matchNo[28], korea, mexico);

            //24 - 11
            Match match30 = new Match(getResources().getString(R.string.England_e), getResources().getString(R.string.Panama_e),getResources().getString(R.string.six_e),getResources().getString(R.string.nizhny_Novgorod_Stadium_e),matchNo[29], england, panama);
            Match match31 = new Match(getResources().getString(R.string.Japan_e), getResources().getString(R.string.Senegal_e),getResources().getString(R.string.nine_e),getResources().getString(R.string.ekaterinburg_Arena_e),matchNo[30], japan, senegal);
            Match match32 = new Match(getResources().getString(R.string.Poland_e), getResources().getString(R.string.Colombia_e),getResources().getString(R.string.twelve_e),getResources().getString(R.string.kazan_Arena_e),matchNo[31], poland, colombia);

            //25 - 12
            Match match33 = new Match(getResources().getString(R.string.soudi_arab_e), getResources().getString(R.string.egypt_e),getResources().getString(R.string.eight_e),getResources().getString(R.string.volgograd_Stadium_e),matchNo[32], soudi_arab, egypt);
            Match match34 = new Match(getResources().getString(R.string.Uruguay_e), getResources().getString(R.string.russia_e),getResources().getString(R.string.eight_e),getResources().getString(R.string.samara_Arena_e),matchNo[33], uruguya, russia);
            Match match35 = new Match(getResources().getString(R.string.Portugal_e), getResources().getString(R.string.Iran_e),getResources().getString(R.string.twelve_e),getResources().getString(R.string.mordovia_Arena_e),matchNo[34], portugal, iran);
            Match match36 = new Match(getResources().getString(R.string.Spain_e), getResources().getString(R.string.Morocco_e),getResources().getString(R.string.twelve_e),getResources().getString(R.string.kaliningrad_Stadium_e),matchNo[35], spain, morocco);

            //26 - 13
            Match match37 = new Match(getResources().getString(R.string.Australia_e), getResources().getString(R.string.Peru_e),getResources().getString(R.string.eight_e),getResources().getString(R.string.fisht_Stadium_e),matchNo[36], australia, peru);
            Match match38 = new Match(getResources().getString(R.string.France_e), getResources().getString(R.string.Denmark_e),getResources().getString(R.string.eight_e),getResources().getString(R.string.luzhniki_Stadium_e),matchNo[37], france, croatia);
            Match match39 = new Match(getResources().getString(R.string.Iceland_e), getResources().getString(R.string.Croatia_e),getResources().getString(R.string.twelve_e),getResources().getString(R.string.rostov_Arena_e),matchNo[38], iceland, croatia);
            Match match40 = new Match(getResources().getString(R.string.Argentina_e), getResources().getString(R.string.Nigeria_e),getResources().getString(R.string.twelve_e),getResources().getString(R.string.saint_Petersburg_Stadium_e),matchNo[39], argentina, nigeria);

            //27 - 14
            Match match41 = new Match(getResources().getString(R.string.Germany_e), getResources().getString(R.string.Korea_Republic_e),getResources().getString(R.string.eight_e),getResources().getString(R.string.kazan_Arena_e),matchNo[40], germany, korea);
            Match match42 = new Match(getResources().getString(R.string.Mexico_e), getResources().getString(R.string.Sweden_e),getResources().getString(R.string.eight_e),getResources().getString(R.string.ekaterinburg_Arena_e),matchNo[41],mexico, sweden);
            Match match43 = new Match(getResources().getString(R.string.Switzerland_e), getResources().getString(R.string.Costa_Rica_e),getResources().getString(R.string.twelve_e),getResources().getString(R.string.nizhny_Novgorod_Stadium_e),matchNo[42], switzerland, costa);
            Match match44 = new Match(getResources().getString(R.string.Brazil_e), getResources().getString(R.string.Serbia_e),getResources().getString(R.string.twelve_e),getResources().getString(R.string.spartak_Stadium_e),matchNo[43], brazil, serbia);

            //28 - 15
            Match match45 = new Match(getResources().getString(R.string.Japan_e), getResources().getString(R.string.Poland_e),getResources().getString(R.string.eight_e),getResources().getString(R.string.volgograd_Stadium_e),matchNo[44], japan, poland);
            Match match46 = new Match(getResources().getString(R.string.Senegal_e), getResources().getString(R.string.Colombia_e),getResources().getString(R.string.eight_e),getResources().getString(R.string.samara_Arena_e),matchNo[45], senegal, colombia);
            Match match47 = new Match(getResources().getString(R.string.England_e), getResources().getString(R.string.Belgium_e),getResources().getString(R.string.twelve_e),getResources().getString(R.string.kaliningrad_Stadium_e),matchNo[46], england, belgium);
            Match match48 = new Match(getResources().getString(R.string.Panama_e), getResources().getString(R.string.Tunisia_e),getResources().getString(R.string.twelve_e),getResources().getString(R.string.mordovia_Arena_e),matchNo[47], panama, tunisia);




            List<Match> matchDayOneList = new ArrayList<>();
            matchDayOneList.add(match1);

            List<Match> matchDayTwoList = new ArrayList<>();
            matchDayTwoList.add(match2);
            matchDayTwoList.add(match3);
            matchDayTwoList.add(match4);

            List<Match> matchDayThreeList = new ArrayList<>();
            matchDayThreeList.add(match5);
            matchDayThreeList.add(match6);
            matchDayThreeList.add(match7);
            matchDayThreeList.add(match8);


            List<Match> matchDayFourList = new ArrayList<>();
            matchDayFourList.add(match9);
            matchDayFourList.add(match10);
            matchDayFourList.add(match11);

            List<Match> matchDayFiveList = new ArrayList<>();
            matchDayFiveList.add(match12);
            matchDayFiveList.add(match13);
            matchDayFiveList.add(match14);

            List<Match> matchDaySixList = new ArrayList<>();
            matchDaySixList.add(match15);
            matchDaySixList.add(match16);
            matchDaySixList.add(match17);

            List<Match> matchDaySevenList = new ArrayList<>();
            matchDaySevenList.add(match18);
            matchDaySevenList.add(match19);
            matchDaySevenList.add(match20);


            List<Match> matchDay8List = new ArrayList<>();
            matchDay8List.add(match21);
            matchDay8List.add(match22);
            matchDay8List.add(match23);

            List<Match> matchDay9List = new ArrayList<>();
            matchDay9List.add(match24);
            matchDay9List.add(match25);
            matchDay9List.add(match26);

            List<Match> matchDay10List = new ArrayList<>();
            matchDay10List.add(match27);
            matchDay10List.add(match28);
            matchDay10List.add(match29);

            List<Match> matchDay11List = new ArrayList<>();
            matchDay11List.add(match30);
            matchDay11List.add(match31);
            matchDay11List.add(match32);

            List<Match> matchDay12List = new ArrayList<>();
            matchDay12List.add(match33);
            matchDay12List.add(match34);
            matchDay12List.add(match35);
            matchDay12List.add(match36);

            List<Match> matchDay13List = new ArrayList<>();
            matchDay13List.add(match37);
            matchDay13List.add(match38);
            matchDay13List.add(match39);
            matchDay13List.add(match40);

            List<Match> matchDay14List = new ArrayList<>();
            matchDay14List.add(match41);
            matchDay14List.add(match42);
            matchDay14List.add(match43);
            matchDay14List.add(match44);

            List<Match> matchDay15List = new ArrayList<>();
            matchDay15List.add(match45);
            matchDay15List.add(match46);
            matchDay15List.add(match47);
            matchDay15List.add(match48);



            listHash.put(listDataHeader.get(0),matchDayOneList);
            listHash.put(listDataHeader.get(1),matchDayTwoList);
            listHash.put(listDataHeader.get(2),matchDayThreeList);
            listHash.put(listDataHeader.get(3),matchDayFourList);
            listHash.put(listDataHeader.get(4),matchDayFiveList);
            listHash.put(listDataHeader.get(5),matchDaySixList);
            listHash.put(listDataHeader.get(6),matchDaySevenList);
            listHash.put(listDataHeader.get(7),matchDay8List);
            listHash.put(listDataHeader.get(8),matchDay9List);
            listHash.put(listDataHeader.get(9),matchDay10List);
            listHash.put(listDataHeader.get(10),matchDay11List);
            listHash.put(listDataHeader.get(11),matchDay12List);
            listHash.put(listDataHeader.get(12),matchDay13List);
            listHash.put(listDataHeader.get(13),matchDay14List);
            listHash.put(listDataHeader.get(14),matchDay15List);



        }else {
            matchNo = getResources().getStringArray(R.array.match_num);
            date = getResources().getStringArray(R.array.date);


            for (String matchDate: date){
                listDataHeader.add(matchDate);
            }

            //14 -1
            Match match1 = new Match(getResources().getString(R.string.russia), getResources().getString(R.string.soudi_arab), getResources().getString(R.string.nine), getResources().getString(R.string.luzhniki_Stadium),matchNo[0], russia, soudi_arab);

            //15 - 2
            Match match2 = new Match(getResources().getString(R.string.egypt), getResources().getString(R.string.Uruguay),getResources().getString(R.string.six),getResources().getString(R.string.ekaterinburg_Arena),matchNo[1], egypt, uruguya);
            Match match3 = new Match(getResources().getString(R.string.Morocco), getResources().getString(R.string.Iran), getResources().getString(R.string.nine),getResources().getString(R.string.saint_Petersburg_Stadium), matchNo[2],morocco, iran);
            Match match4 = new Match(getResources().getString(R.string.Portugal), getResources().getString(R.string.Spain), getResources().getString(R.string.twelve),getResources().getString(R.string.fisht_Stadium),matchNo[3],portugal, spain);

            //16 - 3
            Match match5 = new Match(getResources().getString(R.string.France), getResources().getString(R.string.Australia),getResources().getString(R.string.four),getResources().getString(R.string.kazan_Arena),matchNo[4], france, australia);
            Match match6 = new Match(getResources().getString(R.string.Argentina), getResources().getString(R.string.Iceland),getResources().getString(R.string.seven),getResources().getString(R.string.spartak_Stadium),matchNo[5], argentina, iceland);
            Match match7 = new Match(getResources().getString(R.string.Peru), getResources().getString(R.string.Denmark),getResources().getString(R.string.ten),getResources().getString(R.string.mordovia_Arena),matchNo[6], peru, denmark);
            Match match8 = new Match(getResources().getString(R.string.Nigeria), getResources().getString(R.string.Croatia),getResources().getString(R.string.one),getResources().getString(R.string.kaliningrad_Stadium),matchNo[7], nigeria, croatia);

            //17 - 4
            Match match9 = new Match(getResources().getString(R.string.Costa_Rica), getResources().getString(R.string.Serbia),getResources().getString(R.string.six),getResources().getString(R.string.samara_Arena),matchNo[8], costa, serbia);
            Match match10 = new Match(getResources().getString(R.string.Germany), getResources().getString(R.string.Mexico),getResources().getString(R.string.nine),getResources().getString(R.string.luzhniki_Stadium),matchNo[9],germany, mexico);
            Match match11 = new Match(getResources().getString(R.string.Brazil), getResources().getString(R.string.Switzerland),getResources().getString(R.string.twelve),getResources().getString(R.string.rostov_Arena),matchNo[10],brazil, switzerland);

            //18 - 5
            Match match12 = new Match(getResources().getString(R.string.Sweden), getResources().getString(R.string.Korea_Republic),getResources().getString(R.string.six), getResources().getString(R.string.nizhny_Novgorod_Stadium),matchNo[11], sweden, korea);
            Match match13 = new Match(getResources().getString(R.string.Belgium), getResources().getString(R.string.Panama),getResources().getString(R.string.nine),getResources().getString(R.string.fisht_Stadium),matchNo[12],belgium, panama);
            Match match14 = new Match(getResources().getString(R.string.England), getResources().getString(R.string.Tunisia),getResources().getString(R.string.twelve),getResources().getString(R.string.volgograd_Stadium),matchNo[13], england, tunisia);

            //19 - 6
            Match match15 = new Match(getResources().getString(R.string.Poland), getResources().getString(R.string.Senegal),getResources().getString(R.string.six),getResources().getString(R.string.spartak_Stadium),matchNo[14], poland, senegal);
            Match match16 = new Match(getResources().getString(R.string.Colombia), getResources().getString(R.string.Japan),getResources().getString(R.string.nine),getResources().getString(R.string.mordovia_Arena),matchNo[15], colombia, japan);
            Match match17 = new Match(getResources().getString(R.string.russia), getResources().getString(R.string.egypt),getResources().getString(R.string.twelve),getResources().getString(R.string.saint_Petersburg_Stadium),matchNo[16],russia, egypt);

            //20 - 7
            Match match18 = new Match(getResources().getString(R.string.Portugal), getResources().getString(R.string.Morocco),getResources().getString(R.string.six),getResources().getString(R.string.luzhniki_Stadium),matchNo[17],portugal, morocco);
            Match match19 = new Match(getResources().getString(R.string.Uruguay), getResources().getString(R.string.soudi_arab),getResources().getString(R.string.nine),getResources().getString(R.string.rostov_Arena),matchNo[18],uruguya, soudi_arab);
            Match match20 = new Match(getResources().getString(R.string.Spain), getResources().getString(R.string.Iran),getResources().getString(R.string.twelve),getResources().getString(R.string.kazan_Arena),matchNo[19],spain, iran);

            //21 - 8
            Match match22 = new Match(getResources().getString(R.string.France), getResources().getString(R.string.Peru),getResources().getString(R.string.nine),getResources().getString(R.string.ekaterinburg_Arena),matchNo[20],france, peru);
            Match match21 = new Match(getResources().getString(R.string.Denmark), getResources().getString(R.string.Australia),getResources().getString(R.string.six),getResources().getString(R.string.samara_Arena),matchNo[21], denmark, australia);
            Match match23 = new Match(getResources().getString(R.string.Argentina), getResources().getString(R.string.Croatia),getResources().getString(R.string.twelve),getResources().getString(R.string.nizhny_Novgorod_Stadium),matchNo[22],argentina, croatia);

            //22 - 9
            Match match24 = new Match(getResources().getString(R.string.Brazil), getResources().getString(R.string.Costa_Rica),getResources().getString(R.string.six),getResources().getString(R.string.saint_Petersburg_Stadium),matchNo[23], brazil, costa);
            Match match25 = new Match(getResources().getString(R.string.Nigeria), getResources().getString(R.string.Iceland),getResources().getString(R.string.nine),getResources().getString(R.string.volgograd_Stadium),matchNo[24], nigeria, iceland);
            Match match26 = new Match(getResources().getString(R.string.Serbia), getResources().getString(R.string.Switzerland),getResources().getString(R.string.twelve),getResources().getString(R.string.kaliningrad_Stadium),matchNo[25], serbia, switzerland);

            //23 - 10
            Match match27 = new Match(getResources().getString(R.string.Belgium), getResources().getString(R.string.Tunisia),getResources().getString(R.string.six),getResources().getString(R.string.spartak_Stadium),matchNo[26], belgium, tunisia);
            Match match28 = new Match(getResources().getString(R.string.Korea_Republic), getResources().getString(R.string.Mexico),getResources().getString(R.string.nine),getResources().getString(R.string.rostov_Arena),matchNo[28], korea, mexico);
            Match match29 = new Match(getResources().getString(R.string.Germany), getResources().getString(R.string.Sweden),getResources().getString(R.string.twelve),getResources().getString(R.string.fisht_Stadium),matchNo[27],germany, sweden);

            //24 - 11
            Match match30 = new Match(getResources().getString(R.string.England), getResources().getString(R.string.Panama),getResources().getString(R.string.six),getResources().getString(R.string.nizhny_Novgorod_Stadium),matchNo[29], england, panama);
            Match match31 = new Match(getResources().getString(R.string.Japan), getResources().getString(R.string.Senegal),getResources().getString(R.string.nine),getResources().getString(R.string.ekaterinburg_Arena),matchNo[30], japan, senegal);
            Match match32 = new Match(getResources().getString(R.string.Poland), getResources().getString(R.string.Colombia),getResources().getString(R.string.twelve),getResources().getString(R.string.kazan_Arena),matchNo[31], poland, colombia);

            //25 - 12
            Match match33 = new Match(getResources().getString(R.string.soudi_arab), getResources().getString(R.string.egypt),getResources().getString(R.string.eight),getResources().getString(R.string.volgograd_Stadium),matchNo[32], soudi_arab, egypt);
            Match match34 = new Match(getResources().getString(R.string.Uruguay), getResources().getString(R.string.russia),getResources().getString(R.string.eight),getResources().getString(R.string.samara_Arena),matchNo[33], uruguya, russia);
            Match match35 = new Match(getResources().getString(R.string.Portugal), getResources().getString(R.string.Iran),getResources().getString(R.string.twelve),getResources().getString(R.string.mordovia_Arena),matchNo[34], portugal, iran);
            Match match36 = new Match(getResources().getString(R.string.Spain), getResources().getString(R.string.Morocco),getResources().getString(R.string.twelve),getResources().getString(R.string.kaliningrad_Stadium),matchNo[35], spain, morocco);

            //26 - 13
            Match match37 = new Match(getResources().getString(R.string.Australia), getResources().getString(R.string.Peru),getResources().getString(R.string.eight),getResources().getString(R.string.fisht_Stadium),matchNo[36], australia, peru);
            Match match38 = new Match(getResources().getString(R.string.France), getResources().getString(R.string.Denmark),getResources().getString(R.string.eight),getResources().getString(R.string.luzhniki_Stadium),matchNo[37], france, croatia);
            Match match39 = new Match(getResources().getString(R.string.Iceland), getResources().getString(R.string.Croatia),getResources().getString(R.string.twelve),getResources().getString(R.string.rostov_Arena),matchNo[38], iceland, croatia);
            Match match40 = new Match(getResources().getString(R.string.Argentina), getResources().getString(R.string.Nigeria),getResources().getString(R.string.twelve),getResources().getString(R.string.saint_Petersburg_Stadium),matchNo[39], argentina, nigeria);

            //27 - 14
            Match match41 = new Match(getResources().getString(R.string.Germany), getResources().getString(R.string.Korea_Republic),getResources().getString(R.string.eight),getResources().getString(R.string.kazan_Arena),matchNo[40], germany, korea);
            Match match42 = new Match(getResources().getString(R.string.Mexico), getResources().getString(R.string.Sweden),getResources().getString(R.string.eight),getResources().getString(R.string.ekaterinburg_Arena),matchNo[41],mexico, sweden);
            Match match43 = new Match(getResources().getString(R.string.Switzerland), getResources().getString(R.string.Costa_Rica),getResources().getString(R.string.twelve),getResources().getString(R.string.nizhny_Novgorod_Stadium),matchNo[42], switzerland, costa);
            Match match44 = new Match(getResources().getString(R.string.Brazil), getResources().getString(R.string.Serbia),getResources().getString(R.string.twelve),getResources().getString(R.string.spartak_Stadium),matchNo[43], brazil, serbia);

            //28 - 15
            Match match45 = new Match(getResources().getString(R.string.Japan), getResources().getString(R.string.Poland),getResources().getString(R.string.eight),getResources().getString(R.string.volgograd_Stadium),matchNo[44], japan, poland);
            Match match46 = new Match(getResources().getString(R.string.Senegal), getResources().getString(R.string.Colombia),getResources().getString(R.string.eight),getResources().getString(R.string.samara_Arena),matchNo[45], senegal, colombia);
            Match match47 = new Match(getResources().getString(R.string.England), getResources().getString(R.string.Belgium),getResources().getString(R.string.twelve),getResources().getString(R.string.kaliningrad_Stadium),matchNo[46], england, belgium);
            Match match48 = new Match(getResources().getString(R.string.Panama), getResources().getString(R.string.Tunisia),getResources().getString(R.string.twelve),getResources().getString(R.string.mordovia_Arena),matchNo[47], panama, tunisia);



            List<Match> matchDayOneList = new ArrayList<>();
            matchDayOneList.add(match1);

            List<Match> matchDayTwoList = new ArrayList<>();
            matchDayTwoList.add(match2);
            matchDayTwoList.add(match3);
            matchDayTwoList.add(match4);

            List<Match> matchDayThreeList = new ArrayList<>();
            matchDayThreeList.add(match5);
            matchDayThreeList.add(match6);
            matchDayThreeList.add(match7);
            matchDayThreeList.add(match8);


            List<Match> matchDayFourList = new ArrayList<>();
            matchDayFourList.add(match9);
            matchDayFourList.add(match10);
            matchDayFourList.add(match11);

            List<Match> matchDayFiveList = new ArrayList<>();
            matchDayFiveList.add(match12);
            matchDayFiveList.add(match13);
            matchDayFiveList.add(match14);

            List<Match> matchDaySixList = new ArrayList<>();
            matchDaySixList.add(match15);
            matchDaySixList.add(match16);
            matchDaySixList.add(match17);

            List<Match> matchDaySevenList = new ArrayList<>();
            matchDaySevenList.add(match18);
            matchDaySevenList.add(match19);
            matchDaySevenList.add(match20);


            List<Match> matchDay8List = new ArrayList<>();
            matchDay8List.add(match21);
            matchDay8List.add(match22);
            matchDay8List.add(match23);

            List<Match> matchDay9List = new ArrayList<>();
            matchDay9List.add(match24);
            matchDay9List.add(match25);
            matchDay9List.add(match26);

            List<Match> matchDay10List = new ArrayList<>();
            matchDay10List.add(match27);
            matchDay10List.add(match28);
            matchDay10List.add(match29);

            List<Match> matchDay11List = new ArrayList<>();
            matchDay11List.add(match30);
            matchDay11List.add(match31);
            matchDay11List.add(match32);

            List<Match> matchDay12List = new ArrayList<>();
            matchDay12List.add(match33);
            matchDay12List.add(match34);
            matchDay12List.add(match35);
            matchDay12List.add(match36);

            List<Match> matchDay13List = new ArrayList<>();
            matchDay13List.add(match37);
            matchDay13List.add(match38);
            matchDay13List.add(match39);
            matchDay13List.add(match40);

            List<Match> matchDay14List = new ArrayList<>();
            matchDay14List.add(match41);
            matchDay14List.add(match42);
            matchDay14List.add(match43);
            matchDay14List.add(match44);

            List<Match> matchDay15List = new ArrayList<>();
            matchDay15List.add(match45);
            matchDay15List.add(match46);
            matchDay15List.add(match47);
            matchDay15List.add(match48);



            listHash.put(listDataHeader.get(0),matchDayOneList);
            listHash.put(listDataHeader.get(1),matchDayTwoList);
            listHash.put(listDataHeader.get(2),matchDayThreeList);
            listHash.put(listDataHeader.get(3),matchDayFourList);
            listHash.put(listDataHeader.get(4),matchDayFiveList);
            listHash.put(listDataHeader.get(5),matchDaySixList);
            listHash.put(listDataHeader.get(6),matchDaySevenList);
            listHash.put(listDataHeader.get(7),matchDay8List);
            listHash.put(listDataHeader.get(8),matchDay9List);
            listHash.put(listDataHeader.get(9),matchDay10List);
            listHash.put(listDataHeader.get(10),matchDay11List);
            listHash.put(listDataHeader.get(11),matchDay12List);
            listHash.put(listDataHeader.get(12),matchDay13List);
            listHash.put(listDataHeader.get(13),matchDay14List);
            listHash.put(listDataHeader.get(14),matchDay15List);
        }



    }


}
