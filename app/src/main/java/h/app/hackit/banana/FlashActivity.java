package h.app.hackit.banana;

import android.animation.ArgbEvaluator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlashActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.pager)
    ViewPager pager;
    FragmentPagerAdapter adapter;
    ArrayList<Flash> mList = new ArrayList<>();
    int[] colors = new int[]{Color.parseColor("#E57373"),
            Color.parseColor("#F06292"),
            Color.parseColor("#BA68C8"),
            Color.parseColor("#9575CD")};
    ArgbEvaluator argbEvaluator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        ButterKnife.bind(this);
        setmList(mList);
        argbEvaluator = new ArgbEvaluator();
        adapter = new FragmentPagerAdapter(getSupportFragmentManager(), mList);
        pager.setAdapter(adapter);
        pager.setPageMargin(20);
        pager.setPadding(20,0,20,0);
        pager.setClipToPadding(false);
        pager.setClipChildren(false);
        pager.addOnPageChangeListener(this);
    }

    public void setmList(ArrayList<Flash> mList) {
        this.mList = mList;
        ArrayList<SubFlash> list = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            list.add(new SubFlash("This is it", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi placerat egestas ante, at tristique urna. "));
        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0)
                mList.add(new Flash(getString(R.string.textLong), list, "one"));
            else
                mList.add(new Flash(getString(R.string.textLong), getString(R.string.text_long), "two"));
        }
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {
        if (i < (adapter.getCount() - 1) && i < (colors.length - 1)) {
            findViewById(android.R.id.content).setBackgroundColor((Integer) argbEvaluator.evaluate(v, colors[i], colors[i + 1]));
        } else {
            findViewById(android.R.id.content).setBackgroundColor(colors[colors.length - 1]);
        }
    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
