package h.app.hackit.banana;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragmentAdapter extends RecyclerView.Adapter<HomeFragmentAdapter.HomeViewHolder> {
    private ArrayList<Model> mList;
    private ItemClickListener listener;

    public HomeFragmentAdapter(ArrayList<Model> mList, ItemClickListener listener) {
        this.mList = mList;
        this.listener = listener;
    }

    public interface ItemClickListener {
        void onItemClicked(HomeViewHolder viewHolder, int position);
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_home, viewGroup, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HomeViewHolder homeViewHolder, int i) {
        homeViewHolder.textView.setText(mList.get(i).getTextOne());
        homeViewHolder.textViewTwo.setText(mList.get(i).getTextTwo());
        if (!mList.get(i).isExpanded) {
            homeViewHolder.imgButton.setImageResource(R.drawable.ic_heart_outline);
                    /*rotateAnimation = new RotateAnimation(0.0f, 180.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    mList.get(getAdapterPosition()).isExpanded = true;*/
            mList.get(i).isExpanded = true;

        } else {
            homeViewHolder.imgButton.setImageResource(R.drawable.ic_heart);
                    /*rotateAnimation = new RotateAnimation(180.0f, 0.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    mList.get(getAdapterPosition()).isExpanded = false;*/
            mList.get(i).isExpanded = false;
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.textHome)
        TextView textView;
        @BindView(R.id.textHomeSecond)
        TextView textViewTwo;
        @BindView(R.id.imageButton)
        ImageButton imgButton;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            imgButton.setOnClickListener(this);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view == imgButton) {
                RotateAnimation rotateAnimation;
                notifyItemChanged(getAdapterPosition());
            }
            if (view == itemView) {
                listener.onItemClicked(this, getAdapterPosition());
            }
        }
    }
}
