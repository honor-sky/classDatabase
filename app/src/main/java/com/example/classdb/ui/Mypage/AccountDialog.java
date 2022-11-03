package com.example.classdb.ui.Mypage;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.Button;

import com.example.classdb.R;

public class AccountDialog {
    private Context context;
    private Dialog dg;
    public Button register_btn;
    public Button cancle_btn;

    public AccountDialog(Context context) {
        this.context = context;

    }

    public void callFunction() {
        dg = new Dialog(context);
        dg.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dg.setContentView(R.layout.dialog_goal);
        dg.show();

        register_btn = (Button) dg.findViewById(R.id.button_register_account);
        cancle_btn = (Button) dg.findViewById(R.id.cancle_btn_account);

    }
    public void dismiss(){
        dg.dismiss();
    }
}
