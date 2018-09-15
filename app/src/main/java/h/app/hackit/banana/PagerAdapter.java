package h.app.hackit.banana;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PagerAdapter extends android.support.v4.view.PagerAdapter {
    ArrayList<PagerItems> mList;

    public PagerAdapter(ArrayList<PagerItems> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_top_pager, container, false);
        PagerViewHolder holder = new PagerViewHolder(view);
        //holder.imgView.setBackground(ContextCompat.getDrawable(container.getContext(), mList.get(position).getImg()));
        holder.textPager.setText(mList.get(position).getTitle());
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    public class PagerViewHolder {
        @BindView(R.id.imgPager)
        ImageView imgView;

        @BindView(R.id.titlePager)
        TextView textPager;

        public PagerViewHolder(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }
}
