package com.example.classdb.ui.Mypage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.classdb.R;

public class AddButtonLayout extends FrameLayout {

    public AddButtonLayout(Context context){
        super(context);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.addbuttonlayout,this,true);

        Button add_btn = (Button)findViewById(R.id.add_btn);
        add_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //System.out.println("버튼클릭");
                GoalDialog dialog = new GoalDialog(view.getContext());
                dialog.callFunction();
            }
        });
    }


}