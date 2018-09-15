package h.app.hackit.banana;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NavDrawerAdapter extends RecyclerView.Adapter<NavDrawerAdapter.NavDrawerViewHolder> {
    private ArrayList<NavDrawerOptions> mList;
    private onItemClickedListener mListener;
    String selected = null;

    public NavDrawerAdapter(ArrayList<NavDrawerOptions> mList, onItemClickedListener mListener) {
        this.mList = mList;
        this.mListener = mListener;
    }

    public interface onItemClickedListener {
        void onItemClicked();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public NavDrawerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView;
        switch (mList.get(i).getImg()) {
            case 0:
                itemView = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_nav_header, viewGroup, false);
                break;
            default:
                itemView = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_nav_options, viewGroup, false);
                break;
        }
        return new NavDrawerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NavDrawerViewHolder navDrawerViewHolder, int i) {
        if (mList.get(i).getImg() == 0) {
            assert navDrawerViewHolder.tvHeader != null;
            navDrawerViewHolder.tvHeader.setText(mList.get(i).getText());
        } else {
            assert navDrawerViewHolder.tvOption != null;
            navDrawerViewHolder.tvOption.setText(mList.get(i).getText());
            assert navDrawerViewHolder.ivOption != null;
            navDrawerViewHolder.ivOption.setImageResource(mList.get(i).getImg());
            if (selected != null && selected.equals(mList.get(i).getText()))
                navDrawerViewHolder.itemView.setSelected(true);
            else navDrawerViewHolder.itemView.setSelected(false);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class NavDrawerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Nullable
        @BindView(R.id.textHead)
        TextView tvHeader;
        @Nullable
        @BindView(R.id.textOption)
        TextView tvOption;
        @Nullable
        @BindView(R.id.imgOption)
        ImageView ivOption;

        NavDrawerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mList.get(getAdapterPosition()).getImg() != 0) {
                selected = mList.get(getAdapterPosition()).getText();
                mListener.onItemClicked();
                notifyDataSetChanged();
            }
        }
    }
}
