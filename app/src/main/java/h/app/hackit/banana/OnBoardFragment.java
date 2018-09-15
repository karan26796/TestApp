package h.app.hackit.banana;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OnBoardFragment extends BaseFragment {

    @BindView(R.id.pagerOnboard)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_onboard, container, false);
        ButterKnife.bind(this, view);
        viewPager.setClipChildren(false);
        viewPager.setClipToPadding(false);
        viewPager.setPadding(40, 0, 40, 0);
        viewPager.setAdapter(new ViewPagerAdapter(R.layout.item_pager));
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}
