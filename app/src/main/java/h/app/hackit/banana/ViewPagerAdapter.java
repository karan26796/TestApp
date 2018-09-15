package h.app.hackit.banana;


import android.support.annotation.NonNull;
import android.support.design.card.MaterialCardView;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ViewPagerAdapter extends PagerAdapter implements View.OnClickListener {

    private onImageClick mListener;
    private int viewId;

    public ViewPagerAdapter(int viewId) {
        this.viewId = viewId;
    }

    public interface onImageClick {
        void onImageClick(View view);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = LayoutInflater.from(container.getContext())
                .inflate(viewId, container, false);
        ViewHolder holder = new ViewHolder(itemView);
        holder.txt.setText(R.string.textLong);
        holder.txt1.setText("Lorem ipsum dolor");

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((MaterialCardView) object);
    }

    @Override
    public void onClick(View view) {
        mListener.onImageClick(view);
    }

    class ViewHolder {
        @BindView(R.id.imagePager)
        ImageView img;
        @BindView(R.id.textPager)
        TextView txt;
        @BindView(R.id.textPagerHead)
        TextView txt1;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
