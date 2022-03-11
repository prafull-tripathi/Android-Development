package com.example.calenderproject;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    private static final String TAG = "RecycleView Adapter";
private ArrayList<Alarm>alarms=new ArrayList<>();

    public RecycleViewAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem_recycleview,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Log.d(TAG, "onBindViewHolder: called");
        holder.alarmMsg.setText(alarms.get(position).getMsg());
        String time=alarms.get(position).getHrs()+":"+alarms.get(position).getMins();
        holder.alarmTime.setText(time);
    }

    @Override
    public int getItemCount() {
        return alarms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView alarmMsg;
        private TextView alarmTime;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            alarmMsg=itemView.findViewById(R.id.txtMsg);
            alarmTime= itemView.findViewById(R.id.txtTime);
        }
    }

    public void setAlarms(ArrayList<Alarm> alarms) {
        this.alarms = alarms;
        notifyDataSetChanged();
    }

}
