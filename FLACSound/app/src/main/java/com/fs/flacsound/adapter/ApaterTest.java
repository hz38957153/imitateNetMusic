package com.fs.flacsound.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fs.flacsound.R;

/**
 * Created by KuNn on 2016/12/6.
 */

public class ApaterTest extends RecyclerView.Adapter<ApaterTest.MyViewHolder> {

    private Context mContext;
    private int Series;
    private boolean boo;

    public ApaterTest(Context mContext, int Series,boolean boo) {
        this.mContext = mContext;
        this.Series = Series;
        this.boo=boo;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.itemss, parent,
                false));
        return holder;
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        int screenWidth= 1080;
        ViewGroup.LayoutParams params = holder.item.getLayoutParams();
        int itemWidth=screenWidth/5;
        int itemHeigth=itemWidth/3*2;
        params.height=itemHeigth;
        params.width=itemWidth;
        holder.item.setLayoutParams(params);
        if(boo){
            holder.item.setText(position+1+"");
        }
        else{
            if(Series > 10){
                if(position==4){
                    holder.item.setText("...");
                }
                else if(position==5){
                    holder.item.setText(Series-4+"");
                }
                else if(position==6){
                    holder.item.setText(Series-3+"");
                }
                else if(position==7){
                    holder.item.setText(Series-2+"");
                }
                else if(position==8){
                    holder.item.setText(Series-1+"");
                }
                else if(position==9){
                    holder.item.setText(Series+"");
                }
                else{
                    holder.item.setText(position+1+"");
                }
            }
            else{
                holder.item.setText(position+1+"");
            }
        }

        if (mOnItemClickLitener != null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(boo){
            return Series;
        }
        else{
            return Series < 10 ? Series : 10;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView item;

        public MyViewHolder(View view)
        {
            super(view);
            item = (TextView) view.findViewById(R.id.tv);
        }
    }

    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view , int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }
}
