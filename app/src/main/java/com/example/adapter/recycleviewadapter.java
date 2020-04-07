package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.API.apiclass;
import com.example.hrloginform.R;

import java.util.List;

public class recycleviewadapter extends RecyclerView.Adapter<recycleviewadapter.employeeViewHolder>{
    private List<apiclass.data> employeelist;
    private Context context;

    public recycleviewadapter(Context context,List<apiclass.data> employeelist) {
        this.employeelist = employeelist;
        this.context = context;
    }

    @NonNull
    @Override
    public recycleviewadapter.employeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RelativeLayout rl= (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new employeeViewHolder(rl);
    }

    @Override
    public void onBindViewHolder(@NonNull recycleviewadapter.employeeViewHolder holder, int position) {
        holder.name.setText(employeelist.get(position).getName());
        holder.salary.setText(String.valueOf(employeelist.get(position).getSalary()));
        holder.age.setText(String.valueOf(employeelist.get(position).getAge()));


    }

    @Override
    public int getItemCount() {
        return employeelist.size();
    }
     class employeeViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView salary;
        TextView age;


        public employeeViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.employeename);
            salary=itemView.findViewById(R.id.salaryname);
            age=itemView.findViewById(R.id.agename);
        }
    }
}
