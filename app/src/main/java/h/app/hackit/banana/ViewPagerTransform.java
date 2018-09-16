package h.app.hackit.banana;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

public class ViewPagerTransform implements ViewPager.PageTransformer {
    @Override
    public void transformPage(@NonNull View view, float v) {
        int pageWidth = view.getWidth();

        if (v < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0);

        } else if (v <= 0) { // [-1,0]
            // Use the default slide transition when moving to the left page
            view.setAlpha(1);
            view.setTranslationX(0);
            view.setTranslationY(0);
            view.setScaleX(1);
            view.setScaleY(1);
            view.setRotation(90 * (v));

        } else if (v < 1) { // (0,1]
            // Fade the page out.
            view.setAlpha(1);
            view.setRotation(0);

            // Counteract the default slide transition
            view.setTranslationX(pageWidth * -v);
            view.setTranslationY(50 * v);

            view.setScaleX(Math.max(0.9f, (1 - v)));
            view.setScaleY(Math.max(0.9f, (1 - v)));

        } else if (v == 1) {
            view.setAlpha(1);
            view.setTranslationX(pageWidth * -v);
            view.setTranslationY(50 * v);

            view.setScaleX(Math.max(0.9f, (1 - v)));
            view.setScaleY(Math.max(0.9f, (1 - v)));

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(1);
        }

    }
}
