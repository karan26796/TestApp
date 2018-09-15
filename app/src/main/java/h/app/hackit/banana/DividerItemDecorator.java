package h.app.hackit.banana;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

public class DividerItemDecorator extends RecyclerView.ItemDecoration {
    private Drawable mDivider;
    Context context;
    private Rect mBounds = new Rect();

    public DividerItemDecorator(Drawable divider, Context context) {
        mDivider = divider;
        this.context = context;
    }

    @Override
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        canvas.save();

        final int leftWithMargin = dpToPx(0);

        final int right = parent.getHeight();


        final int childCount = parent.getChildCount();
        for (int i = 1; i < childCount; i++) {

            final View child = parent.getChildAt(i);
            int adapterPosition = parent.getChildAdapterPosition(child);

            int left = (adapterPosition == childCount) ? 0 : leftWithMargin;

            parent.getDecoratedBoundsWithMargins(child, mBounds);

            final int bottom = mBounds.bottom + Math.round(ViewCompat.getTranslationY(child));

            final int top = bottom - mDivider.getIntrinsicHeight();

            mDivider.setBounds(left, top, right, bottom);

            mDivider.draw(canvas);

        }

        canvas.restore();
    }

    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}