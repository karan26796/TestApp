package h.app.hackit.banana;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestFragment extends BaseFragment {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.viewPage)
    ViewPager pager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        ButterKnife.bind(this, view);
        recycler.setAdapter(new RecycleAdapter(setList()));
        pager.setClipChildren(false);
        pager.setClipToPadding(false);
        pager.setPadding(40, 0, 40, 0);
        pager.setAdapter(new ViewPagerAdapter(R.layout.item_pager_test));
        return view;
    }

    private ArrayList<ModelOne> setList() {
        ArrayList<ModelOne> mList = new ArrayList<>();
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(59);
        lista.add(70);
        lista.add(26);
        Random r = new Random();

        for (int i = 0; i < 5; i++) {
            mList.add(new ModelOne("Title", "Subtitle", false, r.nextInt(lista.size())));
        }
        return mList;
    }
}
