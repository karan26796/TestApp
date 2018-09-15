package h.app.hackit.banana;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener
        , BaseFragment.FragmentCallBacks {
    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    @BindView(R.id.toolbarMain)
    Toolbar toolbar;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R.id.mainAppBar)
    AppBarLayout appBarLayout;
    final BaseFragment fragment1 = new HomeFragment();
    final BaseFragment fragment2 = new OnBoardFragment();
    final BaseFragment fragment3 = new TestFragment();
    final FragmentManager manager = getSupportFragmentManager();
    BaseFragment active = fragment1;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    manager.beginTransaction().replace(R.id.homeFrame, new HomeFragment()).commit();
                    return true;

                case R.id.navigation_dashboard:
                    manager.beginTransaction().replace(R.id.homeFrame, new OnBoardFragment()).commit();
                    return true;

                case R.id.navigation_notifications:
                    manager.beginTransaction().replace(R.id.homeFrame, new TestFragment()).commit();
                    return true;

                case R.id.navigation_demo:
                    startActivity(new Intent(HomeActivity.this, FlashActivity.class));
                    return true;
            }
            return false;
        }
    };

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_home);
        setSupportActionBar(toolbar);
        getWindow().setExitTransition(new android.transition.Explode());
        ButterKnife.bind(this);
        if (savedInstanceState == null)
            manager.beginTransaction().replace(R.id.homeFrame, new HomeFragment()).commit();
        scrollView.setOnScrollChangeListener(mListener);
        manager.addOnBackStackChangedListener(this);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Log.e("Scroll", String.valueOf(appBarLayout.getTotalScrollRange()));
        appBarLayout.setAlpha(0.0f);
    }

    private NestedScrollView.OnScrollChangeListener mListener = new NestedScrollView.OnScrollChangeListener() {
        @Override
        public void onScrollChange(NestedScrollView nestedScrollView, int i, int i1, int i2, int i3) {
            Log.e("Y-scroll", String.valueOf(nestedScrollView.getScrollY()));
            Log.e("X-scroll", String.valueOf(nestedScrollView.getScrollX()));
            toolbar.setTitle("This");
            appBarLayout.setAlpha(0.0f + Math.abs(nestedScrollView.getScrollY() / (float)
                    100));
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        manager.popBackStackImmediate();
    }

    @Override
    public void onBackStackChanged() {
    }

    @Override
    public void onPauseFragment() {

    }

    @Override
    public void onCreate() {
        //appBarLayout.setExpanded(true);
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResumeFragment() {
        //appBarLayout.setExpanded(true);
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }
}
