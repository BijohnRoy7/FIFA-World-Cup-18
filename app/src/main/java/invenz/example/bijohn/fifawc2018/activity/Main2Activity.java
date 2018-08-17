package invenz.example.bijohn.fifawc2018.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bijohn.fifawc2018.R;

import invenz.example.bijohn.fifawc2018.IsInternetConnected;
import invenz.example.bijohn.fifawc2018.MySharedPreference;
import invenz.example.bijohn.fifawc2018.SelectedLanguage;
import invenz.example.bijohn.fifawc2018.Splash1Activity;
import invenz.example.bijohn.fifawc2018.fragment.FixtureFragment;
import invenz.example.bijohn.fifawc2018.fragment.GroupFragment;
import invenz.example.bijohn.fifawc2018.fragment.KnockOutFragment;
import invenz.example.bijohn.fifawc2018.fragment.MatchResultFragment;
import invenz.example.bijohn.fifawc2018.fragment.PointTableFragment;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TextView btYes, btNo;
    private Dialog dialogBack;
    private Toolbar toolbar;
    private Dialog selectLanguageDialog;

    private TextView btSelect;
    private RadioButton rbEnglishLang, rbBanglaLang;
    private IsInternetConnected isInternetConnected ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabs);
        isInternetConnected = new IsInternetConnected();

        //action bar
        toolbar = findViewById(R.id.idAppActionBar);
        setSupportActionBar(toolbar);


/*
        dialogBack = new Dialog(Main2Activity.this);
        dialogBack.setContentView(R.layout.back_pressed_dialog);
        dialogBack.setCancelable(false);
        dialogBack.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_PANEL);

        btYes = dialogBack.findViewById(R.id.idYes_backPresse);
        btNo = dialogBack.findViewById(R.id.idNo_backPresse);*/

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setUpTab();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();


       // Object a = getMenuInflater().inflate(R.menu.menu, menu);

        if (SelectedLanguage.lang.equals("english")){
            inflater.inflate(R.menu.menu, menu);
            getSupportActionBar().setTitle("FIFA World Cup 2018");
        }else {
            inflater.inflate(R.menu.menu_bangla, menu);
            getSupportActionBar().setTitle("বিশ্বকাপ ফুটবল ২০১৮");
        }
        return super.onCreateOptionsMenu(menu);
    }



    /*################## WHEN AN OPTION FROM TOOLBAR OF ACTION BAR IS SELECTED ###########################*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            //WHEN CHANGE LANGUAGE OPTIO IS SELECTED
            case R.id.actionBarChangeLang:

                /*########################################*/
                selectLanguageDialog = new Dialog(Main2Activity.this);
                selectLanguageDialog.setContentView(R.layout.select_language_dialog);

                TextView tvEng = selectLanguageDialog.findViewById(R.id.idLanguageTextEng);
                TextView tvBan = selectLanguageDialog.findViewById(R.id.idLanguageTextBang);

                rbEnglishLang = selectLanguageDialog.findViewById(R.id.idEnglish_selectLang);
                rbBanglaLang = selectLanguageDialog.findViewById(R.id.idBangla_selectLang);
                btSelect = selectLanguageDialog.findViewById(R.id.idSelectButton_select_Lang);

                tvEng.setText("Change Your Language");
                tvBan.setText("ভাষা পরিবর্তন করুন");

                Window window = selectLanguageDialog.getWindow();
                window.setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                //window.setLayout(800, 900);
                selectLanguageDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                selectLanguageDialog.setCancelable(false);
                selectLanguageDialog.show();

                //dialog ends


                btSelect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (rbEnglishLang.isChecked()){

                            //If English Language is selected
                            SelectedLanguage.lang = "english";
                            selectLanguageDialog.dismiss();
                            //Toast.makeText(Splash1Activity.this, ""+SelectedLanguage.lang, Toast.LENGTH_SHORT).show();

                            //setting shared preference
                            MySharedPreference mySharedPreference = new MySharedPreference();
                            mySharedPreference.getMySharedPref("english", Main2Activity.this);

                            startActivity(new Intent(Main2Activity.this, Main2Activity.class));
                            finish();

                        }else if (rbBanglaLang.isChecked()){

                            //If Bangla Language is selected
                            SelectedLanguage.lang = "bangla";
                            selectLanguageDialog.dismiss();
                            //Toast.makeText(Splash1Activity.this, ""+SelectedLanguage.lang, Toast.LENGTH_SHORT).show();

                            //setting shared preference
                            MySharedPreference mySharedPreference = new MySharedPreference();
                            mySharedPreference.getMySharedPref("bangla", Main2Activity.this);


                            startActivity(new Intent(Main2Activity.this, Main2Activity.class));
                            finish();

                        }else {
                            Toast.makeText(Main2Activity.this, "Please select a language", Toast.LENGTH_SHORT).show();
                        }


                    }
                });

                break;

            //WHEN EXIT OPTION IS SELECTED
            case R.id.actionBarExit:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    /*
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "BackPressed", Toast.LENGTH_SHORT).show();


        dialogBack.show();

        btYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBack.dismiss();
                finish();
            }
        });
        btNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBack.dismiss();
            }
        });


    }*/

    private void setUpTab() {

        if (SelectedLanguage.lang.equals("english")){
            View view1 = LayoutInflater.from(this).inflate(R.layout.single_tab, null);
            TextView tabOne = view1.findViewById(R.id.idTab) ;
            tabOne.setText("Group Stage");
            tabLayout.getTabAt(0).setCustomView(tabOne);

            View view2 = LayoutInflater.from(this).inflate(R.layout.single_tab, null);
            TextView tabTwo = view2.findViewById(R.id.idTab);
            tabTwo.setText("KnockOut Stage");
            tabLayout.getTabAt(1).setCustomView(tabTwo);

            View view3 = LayoutInflater.from(this).inflate(R.layout.single_tab, null);
            TextView tabThree = view3.findViewById(R.id.idTab);
            tabThree.setText("Group Table");
            tabLayout.getTabAt(2).setCustomView(tabThree);

            View view4 = LayoutInflater.from(this).inflate(R.layout.single_tab, null);
            TextView tabFour = view4.findViewById(R.id.idTab);
            tabFour.setText("Results");
            tabLayout.getTabAt(3).setCustomView(tabFour);

            View view5 = LayoutInflater.from(this).inflate(R.layout.single_tab, null);
            TextView tabFive = view5.findViewById(R.id.idTab);
            tabFive.setText("Point Table");
            tabLayout.getTabAt(4).setCustomView(tabFive);
        }
        else
            {
            View view1 = LayoutInflater.from(this).inflate(R.layout.single_tab, null);
            TextView tabOne = view1.findViewById(R.id.idTab) ;
            tabOne.setText("গ্রুপ পর্ব");
            tabLayout.getTabAt(0).setCustomView(tabOne);

            View view2 = LayoutInflater.from(this).inflate(R.layout.single_tab, null);
            TextView tabTwo = view2.findViewById(R.id.idTab);
            tabTwo.setText("নকআউট পর্ব");
            tabLayout.getTabAt(1).setCustomView(tabTwo);

            View view3 = LayoutInflater.from(this).inflate(R.layout.single_tab, null);
            TextView tabThree = view3.findViewById(R.id.idTab);
            tabThree.setText("গ্রুপ টেবিল");
            tabLayout.getTabAt(2).setCustomView(tabThree);

            View view4 = LayoutInflater.from(this).inflate(R.layout.single_tab, null);
            TextView tabFour = view4.findViewById(R.id.idTab);
            tabFour.setText("ফলাফল");
            tabLayout.getTabAt(3).setCustomView(tabFour);

            View view5 = LayoutInflater.from(this).inflate(R.layout.single_tab, null);
            TextView tabFive = view5.findViewById(R.id.idTab);
            tabFive.setText("পয়েন্ট টেবিল");
            tabLayout.getTabAt(4).setCustomView(tabFive);
        }




    }





    private void setUpViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());


            adapter.addFragment(new FixtureFragment());
            adapter.addFragment(new KnockOutFragment());
            adapter.addFragment(new GroupFragment());
            adapter.addFragment(new MatchResultFragment());
            adapter.addFragment(new PointTableFragment());
            viewPager.setAdapter(adapter);

    }


    /*################# METHODS OF TabLayout.OnTabSelectedListener Interface #####################*/
  /*  @Override
    public void onTabSelected(TabLayout.Tab tab) {
        LinearLayout tabLayout1 = (LinearLayout)((ViewGroup) tabLayout.getChildAt(0)).getChildAt(tab.getPosition());
        TextView tabTextView = (TextView) tabLayout1.getChildAt(1);
        // tabTextView.setTypeface(tabTextView.getTypeface(), Typeface.BOLD);
        tabTextView.setTextSize(24);
        tabTextView.setTextColor(Color.WHITE);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        LinearLayout tabLayout1 = (LinearLayout)((ViewGroup) tabLayout.getChildAt(0)).getChildAt(tab.getPosition());
        TextView tabTextView = (TextView) tabLayout1.getChildAt(1);
        //tabTextView.setTypeface(tabTextView.getTypeface(), Typeface.NORMAL);
        tabTextView.setTextSize(16);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }*/
    /*##########################################*/


    class ViewPagerAdapter extends FragmentPagerAdapter {

        List<Fragment> fragments = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        private void addFragment(Fragment fragment){

            fragments.add(fragment);
        }





    }




}
