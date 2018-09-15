package h.app.hackit.banana;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentTempTwo extends FragmentBase implements ExpandableAdapter.ItemClickListener {
    @BindView(R.id.textDesc)
    TextView textDesc;

    public static FragmentTempTwo newInstance(Flash flash, int i) {

        Bundle args = new Bundle();
        args.putParcelable("flash", flash);
        args.putInt("pos", i);
        FragmentTempTwo fragment = new FragmentTempTwo();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_temp_2, container, false);
        ButterKnife.bind(this, view);
        assert titleText != null;
        String s = "Question "
                .concat(String.valueOf(pos + 1)
                        .concat(".\n")
                        .concat(flash.getTitle()));
        SpannableString ss1 = new SpannableString(s);
        int span;
        if (pos < 9)
            span = 11;
        else span = 12;
        ss1.setSpan(new RelativeSizeSpan(.7f), 0, span, 0); // set size
        ss1.setSpan(new ForegroundColorSpan(Color.parseColor("#212121")), 0, span, 0);// set color
        titleText.setText(ss1);
        textDesc.setText(flash.getDesc());
        return view;
    }

    @Override
    public void onItemClicked() {

    }
}
