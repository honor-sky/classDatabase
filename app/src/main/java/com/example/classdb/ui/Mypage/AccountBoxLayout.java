package com.example.classdb.ui.Mypage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.classdb.R;

public class AccountBoxLayout extends FrameLayout {
    public AccountBoxLayout(Context context){
        super(context);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.account_box,this,true);

    }
}
