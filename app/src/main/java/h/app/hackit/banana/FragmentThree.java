package h.app.hackit.banana;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentThree extends BaseFragment {
    @BindView(R.id.rv_list)
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        ButterKnife.bind(this, view);
        final List<Person> people = PeopleRepo.getPeopleSorted();
        recyclerView.setAdapter(new PersonAdapter(people, R.layout.list_item));

        RecyclerSectionItemDecoration sectionItemDecoration =
                new RecyclerSectionItemDecoration(getResources().getDimensionPixelSize(android.R.dimen.notification_large_icon_height),
                        true,
                        getSectionCallback(people));
        recyclerView.addItemDecoration(sectionItemDecoration);

        return view;
    }

    private RecyclerSectionItemDecoration.SectionCallback getSectionCallback(final List<Person> people) {
        return new RecyclerSectionItemDecoration.SectionCallback() {
            @Override
            public boolean isSection(int position) {
                return position == 0
                        || people.get(position)
                        .getLastName()
                        .charAt(0) != people.get(position - 1)
                        .getLastName()
                        .charAt(0);
            }

            @Override
            public CharSequence getSectionHeader(int position) {
                return people.get(position)
                        .getLastName()
                        .subSequence(0,
                                1);
            }
        };
    }

}
