package com.example.rmkengineeringcollege.leaderboard;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by R.M.KEngineeringCollege on 06/07/18.
 */

public class userlist extends ArrayAdapter<Users>{

    private Activity context;
    private List<Users> ulist;

    public  userlist(Activity context,List<Users> ulist)
    {
        super(context,R.layout.listlayout,ulist);
        this.context = context;
        this.ulist = ulist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.listlayout,null,true);

        TextView empid = (TextView) listViewItem.findViewById(R.id.empid);
        TextView name = (TextView) listViewItem.findViewById(R.id.name);
        TextView branch = (TextView) listViewItem.findViewById(R.id.branch);
        TextView score = (TextView) listViewItem.findViewById(R.id.score);

        Users users = ulist.get(position);
        empid.setText(users.getEmpid());
        name.setText(users.getName());
        branch.setText(users.getBranch());
        score.setText(String.valueOf(users.getScore()));

        return  listViewItem;
    }
}
