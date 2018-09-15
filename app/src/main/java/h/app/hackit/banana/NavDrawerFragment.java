package h.app.hackit.banana;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NavDrawerFragment extends Fragment implements NavDrawerAdapter.onItemClickedListener {
    @BindView(R.id.recyclerNav)
    RecyclerView recyclerNav;
    ArrayList<NavDrawerOptions> mOptionsList = new ArrayList<>();

    public void setmOptionsList(ArrayList<NavDrawerOptions> mOptionsList) {
        this.mOptionsList = mOptionsList;
        String[] array = getResources().getStringArray(R.array.options);
        for (int i = 0; i < array.length; i++) {
            if (i == 0)
                mOptionsList.add(new NavDrawerOptions("General", 0));
            else {
                mOptionsList.add(new NavDrawerOptions(array[i], R.drawable.ic_heart));
            }
        }
    }

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nav_drawer, container, false);
        ButterKnife.bind(this, view);
        setmOptionsList(mOptionsList);
        recyclerNav.setAdapter(new NavDrawerAdapter(mOptionsList, this));
        int[] ATTRS = new int[]{android.R.attr.listDivider};
        TypedArray a = Objects.requireNonNull(getContext()).obtainStyledAttributes(ATTRS);
        Drawable divider = a.getDrawable(0);
        int inset = getResources().getDimensionPixelSize(R.dimen.padding_50dp);
        InsetDrawable insetDivider = new InsetDrawable(divider, inset, 0, inset, 0);
        a.recycle();

        DividerItemDecorator itemDecoration = new DividerItemDecorator(insetDivider, getContext());
        /*itemDecoration.setDrawable(insetDivider);*/
        //recyclerNav.addItemDecoration(itemDecoration);


        return view;
    }

    @Override
    public void onItemClicked() {

    }
}
