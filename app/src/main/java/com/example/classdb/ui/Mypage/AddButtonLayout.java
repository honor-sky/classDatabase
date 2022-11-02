package com.example.classdb.ui.Mypage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.classdb.R;

public class AddButtonLayout extends FrameLayout {
    public boolean isGoal;

    public AddButtonLayout(Context context){
        super(context);
        init(context);
    }

    private void init(Context context){

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.addbuttonlayout,this,true);

        /*
        Button add_btn = (Button)findViewById(R.id.add_btn);
        add_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //System.out.println("버튼클릭");
                GoalDialog dialog = new GoalDialog(view.getContext());
                isGoal = dialog.callFunction();
            }
        });

         */
    }


}