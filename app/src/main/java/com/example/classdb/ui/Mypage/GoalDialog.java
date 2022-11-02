package com.example.classdb.ui.Mypage;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.classdb.R;

public class GoalDialog {

    private Context context;
    boolean isGoal;
    private Dialog dg;
    public Button register_btn;
    public Button cancle_btn;

    public GoalDialog(Context context) {
        this.context = context;

    }

    public void callFunction() {
        dg = new Dialog(context);
        dg.setContentView(R.layout.dialog_goal);
        dg.show();

        register_btn = (Button) dg.findViewById(R.id.button_register_goal);
        cancle_btn = (Button) dg.findViewById(R.id.cancle_btn);
        /*
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DB로 등록 정보 넘어감
                //성공여부 Toast로 제공
                dg.dismiss();
                //변화된 정보 화면에 재구성(현재 프래그먼트에 정보 전달)
                isGoal = true;
            }
        });

        cancle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dg.dismiss();
                isGoal = false;
            }
        });

         */

    }
    public void dismiss(){
        dg.dismiss();
    }

}

