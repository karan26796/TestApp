package h.app.hackit.banana;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {
    ArrayList<Flash> mList;

    public FragmentPagerAdapter(FragmentManager fm, ArrayList<Flash> mList) {
        super(fm);
        this.mList = mList;
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        switch (mList.get(i).getType()) {
            case "one":
                fragment = FragmentTempOne.newInstance(mList.get(i), i);
                break;
            case "two":
                fragment = FragmentTempTwo.newInstance(mList.get(i), i);
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
