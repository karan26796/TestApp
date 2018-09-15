package h.app.hackit.banana;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.widget.Toolbar;

public class BaseFragment extends Fragment {
    FragmentCallBacks callBacks;
    AppBarLayout layout;
    Toolbar toolbar;

    public interface FragmentCallBacks {
        void onPauseFragment();

        void onCreate();

        void onResumeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*((AppCompatActivity) Objects.requireNonNull(getActivity()))
                .getSupportActionBar();*/
        callBacks.onCreate();
    }

    @Override
    public void onResume() {
        super.onResume();
        callBacks.onPauseFragment();
    }

    @Override
    public void onPause() {
        super.onPause();
        callBacks.onPauseFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callBacks = (FragmentCallBacks) context;
        } catch (ClassCastException e) {
        }
    }
}
