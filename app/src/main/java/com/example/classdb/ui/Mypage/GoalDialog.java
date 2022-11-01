package com.example.classdb.ui.Mypage;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.example.classdb.R;

public class GoalDialog {

    private Context context;

    public GoalDialog(Context context) {
        this.context = context;
    }

    public void callFunction() {
        final Dialog dg = new Dialog(context);
        dg.setContentView(R.layout.dialog_goal);
        dg.show();

        final Button register_btn = (Button) dg.findViewById(R.id.button_register_goal);
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DB로 등록 정보 넘어감
                //성공여부 Toast로 제공
                dg.dismiss();
            }
        });
        final Button cancle_btn = (Button) dg.findViewById(R.id.cancle_btn);
        cancle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dg.dismiss();
            }
        });

    }
}

