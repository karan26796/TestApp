package h.app.hackit.banana;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import butterknife.BindView;

public abstract class FragmentBase extends Fragment {
    Flash flash;
    Bundle bundle;
    int pos;

    @Nullable
    @BindView(R.id.titleFlash)
    TextView titleText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getArguments();
        assert bundle != null;
        flash = bundle.getParcelable("flash");
        pos = bundle.getInt("pos");
    }
}
