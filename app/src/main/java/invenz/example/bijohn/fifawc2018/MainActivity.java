package invenz.example.bijohn.fifawc2018;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.bijohn.fifawc2018.R;

public class MainActivity extends AppCompatActivity {

    private TextView tvFixtureLabel, tvGroupsLabel, tvMatchresult, tvPointTable, tvKnock;
    private ViewPager mainPager;
    private PageViewAdapter myPageViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/nikosh.ttf");
        tv.setTypeface(myCustomFont);
        tv.setText("জন");*/

       tvFixtureLabel = findViewById(R.id.idFixture);
       tvKnock = findViewById(R.id.idKnockout);
       tvGroupsLabel = findViewById(R.id.idGroups);
       tvMatchresult = findViewById(R.id.idMatchResult);
       tvPointTable = findViewById(R.id.idPointTable);
       mainPager = findViewById(R.id.idViewPager);

        myPageViewAdapter = new PageViewAdapter(getSupportFragmentManager());
        mainPager.setAdapter(myPageViewAdapter);

        /*############### When tab is clicked ##################*/
        tvFixtureLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPager.setCurrentItem(0);
            }
        });

        tvKnock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPager.setCurrentItem(1);
            }
        });
        tvGroupsLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPager.setCurrentItem(2);
            }
        });

        tvMatchresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPager.setCurrentItem(3);
            }
        });

        tvMatchresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPager.setCurrentItem(4);
            }
        });


        /*################# when swap the tab ######################*/
        mainPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //My method
                changeTabs(position);
            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void changeTabs(int position) {
        if (position == 0){
            tvFixtureLabel.setTextSize(24);
            tvFixtureLabel.setTextColor(Color.parseColor("#FFFFFF"));

            tvGroupsLabel.setTextSize(16);
            tvGroupsLabel.setTextColor(Color.parseColor("#FFB08B"));

            tvKnock.setTextSize(16);
            tvKnock.setTextColor(Color.parseColor("#FFB08B"));

            tvMatchresult.setTextSize(16);
            tvMatchresult.setTextColor(Color.parseColor("#FFB08B"));

            tvPointTable.setTextSize(16);
            tvPointTable.setTextColor(Color.parseColor("#FFB08B"));
        }
        if (position == 1){
            tvFixtureLabel.setTextSize(16);
            tvFixtureLabel.setTextColor(Color.parseColor("#FFB08B"));

            tvKnock.setTextSize(24);
            tvKnock.setTextColor(Color.parseColor("#FFFFFF"));

            tvGroupsLabel.setTextSize(16);
            tvGroupsLabel.setTextColor(Color.parseColor("#FFB08B"));

            tvMatchresult.setTextSize(16);
            tvMatchresult.setTextColor(Color.parseColor("#FFB08B"));

            tvPointTable.setTextSize(16);
            tvPointTable.setTextColor(Color.parseColor("#FFB08B"));
        }

        if (position == 2){
            tvFixtureLabel.setTextSize(16);
            tvFixtureLabel.setTextColor(Color.parseColor("#FFB08B"));

            tvKnock.setTextSize(16);
            tvKnock.setTextColor(Color.parseColor("#FFB08B"));

            tvGroupsLabel.setTextSize(24);
            tvGroupsLabel.setTextColor(Color.parseColor("#FFFFFF"));

            tvMatchresult.setTextSize(16);
            tvMatchresult.setTextColor(Color.parseColor("#FFB08B"));

            tvPointTable.setTextSize(16);
            tvPointTable.setTextColor(Color.parseColor("#FFB08B"));
        }

        if (position == 3){
            tvFixtureLabel.setTextSize(16);
            tvFixtureLabel.setTextColor(Color.parseColor("#FFB08B"));

            tvKnock.setTextSize(16);
            tvKnock.setTextColor(Color.parseColor("#FFB08B"));

            tvGroupsLabel.setTextSize(16);
            tvGroupsLabel.setTextColor(Color.parseColor("#FFB08B"));

            tvMatchresult.setTextSize(24);
            tvMatchresult.setTextColor(Color.parseColor("#FFFFFF"));

            tvPointTable.setTextSize(16);
            tvPointTable.setTextColor(Color.parseColor("#FFB08B"));
        }

        if (position == 4){
            tvFixtureLabel.setTextSize(16);
            tvFixtureLabel.setTextColor(Color.parseColor("#FFB08B"));

            tvPointTable.setTextSize(16);
            tvPointTable.setTextColor(Color.parseColor("#FFB08B"));

            tvGroupsLabel.setTextSize(16);
            tvGroupsLabel.setTextColor(Color.parseColor("#FFB08B"));

            tvMatchresult.setTextSize(16);
            tvMatchresult.setTextColor(Color.parseColor("#FFB08B"));

            tvPointTable.setTextSize(24);
            tvPointTable.setTextColor(Color.parseColor("#FFFFFF"));


        }

    }
}
