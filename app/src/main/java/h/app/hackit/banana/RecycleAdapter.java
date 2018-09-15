package h.app.hackit.banana;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.RecyclerHolder> {

    private ArrayList<ModelOne> mList;

    public RecycleAdapter(ArrayList<ModelOne> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RecyclerHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_recycler, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder recyclerHolder, int i) {
        recyclerHolder.txtTitle.setText(mList.get(i).getTextOne());
        recyclerHolder.txtsubTitle.setText(mList.get(i).getTextTwo());
        recyclerHolder.seekBar.setProgress(mList.get(i).getProgress());
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.title)
        TextView txtTitle;
        @BindView(R.id.subTitle)
        TextView txtsubTitle;
        @BindView(R.id.seek)
        SeekBar seekBar;
        @BindView(R.id.imageButton)
        ImageButton imgButton;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            seekBar.setMax(100);
            seekBar.setPadding(0, 0, 0, 0);
            imgButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view == imgButton) {
                RotateAnimation rotateAnimation;
                if (!mList.get(getAdapterPosition()).isExpanded) {
                    imgButton.setImageResource(R.drawable.ic_heart);
                    /*rotateAnimation = new RotateAnimation(0.0f, 180.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    mList.get(getAdapterPosition()).isExpanded = true;*/
                } else {
                    imgButton.setImageResource(R.drawable.ic_heart_outline);
                    /*rotateAnimation = new RotateAnimation(180.0f, 0.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    mList.get(getAdapterPosition()).isExpanded = false;*/
                }

                /*rotateAnimation.setInterpolator(new DecelerateInterpolator());
                rotateAnimation.setRepeatCount(0);
                rotateAnimation.setDuration(300);
                rotateAnimation.setFillAfter(true);
                imgButton.startAnimation(rotateAnimation);*/
            }
        }
    }
}
