package h.app.hackit.banana;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExpandableAdapter extends RecyclerView.Adapter<ExpandableAdapter.ViewHolder> {
    ArrayList<SubFlash> mList;
    ItemClickListener mListener;
    int currentPos = -1, lastPos = -1, selected = -1;

    public ExpandableAdapter(ArrayList<SubFlash> mList, ItemClickListener mListener) {
        this.mList = mList;
        this.mListener = mListener;
    }

    public interface ItemClickListener {
        void onItemClicked();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_expand_desc, viewGroup, false));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.text.setText(mList.get(i).getDesc());
        viewHolder.textHint.setText(mList.get(i).getHint());
        if (selected != -1 && selected == i) {
            viewHolder.group.setVisibility(View.VISIBLE);
            viewHolder.imgExpand.setImageResource(R.drawable.ic_subtract);
            startAlphaAnimation(viewHolder.textHint, View.VISIBLE);
        } else {
            viewHolder.imgExpand.setImageResource(R.drawable.ic_add_black_24dp);
            viewHolder.group.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.textView)
        TextView text;
        @BindView(R.id.groupExp)
        android.support.constraint.Group group;
        @BindView(R.id.text2)
        TextView textHint;
        @BindView(R.id.imageButton2)
        ImageButton imgExpand;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            imgExpand.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (selected == getAdapterPosition())
                selected = -1;
            else selected = getAdapterPosition();
            mListener.onItemClicked();
            notifyDataSetChanged();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private static void startAlphaAnimation(TextView textView, int visibility) {
        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
                ? new AlphaAnimation(0f, 1f)
                : new AlphaAnimation(1f, 0f);
        alphaAnimation.setDuration((long) 300);
        alphaAnimation.setFillAfter(true);
        textView.startAnimation(alphaAnimation);
    }
}
