package h.app.hackit.banana;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends BaseFragment implements HomeFragmentAdapter.ItemClickListener {

    @BindView(R.id.homeRecycler)
    RecyclerView recyclerHome;
    @BindView(R.id.viewPager)
    ViewPager pager;
    ArrayList<Model> mList = new ArrayList<>();
    ArrayList<PagerItems> mListPager = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        recyclerHome.setLayoutManager(new LinearLayoutManager(getContext()));
        setmList(mList);
        setmListPager(mListPager);
        pager.setAdapter(new PagerAdapter(mListPager));
        pager.setPadding(40, 0, 40, 0);
        pager.setClipChildren(false);
        pager.setClipToPadding(false);
        pager.setPageMargin(30);
        recyclerHome.setAdapter(new HomeFragmentAdapter(mList, this));
        return view;
    }

    @Override
    public void onItemClicked(HomeFragmentAdapter.HomeViewHolder viewHolder, int position) {
        startActivity(new Intent(getContext(), DetailActivity.class)
                , ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity()).toBundle());
    }

    public void setmListPager(ArrayList<PagerItems> mListPager) {
        this.mListPager = mListPager;
        for (int i = 0; i < 6; i++) {
            mListPager.add(new PagerItems(R.drawable.card_bg_alternate, "Lorem ipsum"));
        }
    }

    public void setmList(ArrayList<Model> mList) {
        this.mList = mList;
        for (int i = 0; i < 6; i++) {
            mList.add(new Model("Lorem ipsum", getString(R.string.textLong), false));
        }
    }
}
