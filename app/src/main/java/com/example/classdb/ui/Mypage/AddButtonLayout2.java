package com.example.classdb.ui.Mypage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.classdb.R;

public class AddButtonLayout2 extends LinearLayout {
    public boolean isGoal;

    public AddButtonLayout2(Context context){
        super(context);
        init(context);
    }

    private void init(Context context) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.addbuttonlayout2, this, true);

    }


}
