package com.example.classdb.ui.Mypage;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.classdb.R;
import com.example.classdb.databinding.FragmentAccountBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment {

    private FragmentAccountBinding fragmentAccountBinding;
    ListView layout;
    MyAdapter adapter;
    AddButtonLayout2 addLayout;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentAccountBinding = FragmentAccountBinding.inflate(inflater);

        addLayout = new AddButtonLayout2(getContext());
        layout = (ListView)fragmentAccountBinding.list; //리스트 레이아웃
        setList(addLayout,2);

        return fragmentAccountBinding.getRoot();
    }
    //계좌 정보 리스트 adapter에 넘겨서 셋팅
    public void setList(AddButtonLayout2 addLayout,int num){
        //DB에 정보 요청

        ArrayList<Object> items = new ArrayList<Object>();
        for(int i=0;i<num;i++){
            items.add(new AccountBoxLayout(getContext()));
        }
        items.add(addLayout); //계좌 추가 버튼
        adapter = new MyAdapter(getContext(),items) ;
        layout.setAdapter(adapter);

    }

    public class MyAdapter extends ArrayAdapter {
        Context context;
        List list;

        public MyAdapter(Context con, ArrayList list) {
            super(con, 0, list);
            this.context = con;
            this.list = list;
        }
        class ViewHolder {
            public TextView textview_accountNum;
            public TextView textview_bank;
            public TextView textview_type;
            public TextView textview_money;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            final ViewHolder viewHolder;

            if (convertView == null){
                LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
                if(position == list.size()-1){
                    convertView = layoutInflater.inflate(R.layout.addbuttonlayout2, parent, false);
                    convertView.findViewById(R.id.add_btn2).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            GoalDialog dialog = new GoalDialog(view.getContext());
                            dialog.callFunction();

                            dialog.register_btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    //DB로 등록 정보 넘어감

                                    //성공여부 Toast로 제공

                                    dialog.dismiss();

                                    setList(addLayout,3); //변화된 정보 화면에 재구성
                                }
                            });
                            dialog.cancle_btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog.dismiss();
                                }
                            });

                        }
                    });
                }else{
                    convertView = layoutInflater.inflate(R.layout.account_box, parent, false);
                }
            }

            viewHolder = new ViewHolder();
            if(position == list.size()-1){

            }else{
                //리스트의 내용 받아서 셋팅
                viewHolder.textview_accountNum = convertView.findViewById(R.id.accountNumber);
                viewHolder.textview_bank = convertView.findViewById(R.id.bank);
                viewHolder.textview_type = convertView.findViewById(R.id.type);
                viewHolder.textview_money = convertView.findViewById(R.id.money);

                viewHolder.textview_accountNum.setText("dd");
                viewHolder.textview_bank.setText("dd");
                viewHolder.textview_type.setText("dd");
                viewHolder.textview_money.setText("dd");
            }


            return convertView;

        }

    }

}
