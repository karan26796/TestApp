package h.app.hackit.banana;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;

public class CustomLayout extends ConstraintLayout {

    private static final int[] VIEW_GROUP_ATTRS = new int[]{ android.R.attr.enabled };
    private static final boolean DEFAULT_IS_ENABLED = false;

    private boolean isEnabled = DEFAULT_IS_ENABLED;

    public CustomLayout(Context context) {
        super(context);
    }

    public CustomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        isEnabled = context.obtainStyledAttributes(attrs, VIEW_GROUP_ATTRS).getBoolean(0, DEFAULT_IS_ENABLED);
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        this.isEnabled = selected;

        for (int i = 0; i < getChildCount(); ++i) {
            getChildAt(i).setSelected(selected);
        }
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.isEnabled = enabled;

        for (int i = 0; i < getChildCount(); ++i) {
            getChildAt(i).setSelected(enabled);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        setSelected(isEnabled);
    }
}
