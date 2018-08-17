package invenz.example.bijohn.fifawc2018;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import invenz.example.bijohn.fifawc2018.fragment.FixtureFragment;
import invenz.example.bijohn.fifawc2018.fragment.GroupFragment;
import invenz.example.bijohn.fifawc2018.fragment.KnockOutFragment;
import invenz.example.bijohn.fifawc2018.fragment.MatchResultFragment;
import invenz.example.bijohn.fifawc2018.fragment.PointTableFragment;

class PageViewAdapter extends FragmentPagerAdapter {
    public PageViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                FixtureFragment fixtureFragment = new FixtureFragment();
                return fixtureFragment;
            case 1:
                KnockOutFragment knockOutFragment = new KnockOutFragment();
                return knockOutFragment;
            case 2:
                GroupFragment groupFragment = new GroupFragment();
                return groupFragment;
            case 3:
                MatchResultFragment matchResultFragment = new MatchResultFragment();
                return matchResultFragment;

            case 4:
                PointTableFragment pointTableFragment = new PointTableFragment();
                return pointTableFragment;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 5;
    }
}
