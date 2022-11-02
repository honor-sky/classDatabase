package com.example.classdb.ui.Mypage;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.classdb.R;
import com.example.classdb.databinding.FragmentAccountBinding;
import com.example.classdb.databinding.FragmentGoalBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment {

    private FragmentAccountBinding fragmentAccountBinding;
    private ArrayList<AccountBoxLayout> items = new ArrayList<AccountBoxLayout>();

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
        ArrayAdapter adapter = new ArrayAdapter(getContext(), R.layout.account_box, items) ;

        //계좌 정보 리스트 가져옴
        //리스트의 크기가 0이 아니면 계좌 정보 그려줌
        ListView layout = (ListView)fragmentAccountBinding.accountBoxLayoutContainer; //버튼 레이아웃을 담을 레이아웃
        layout.setAdapter(adapter);

        for(int i=0;i<3;i++){
            AccountBoxLayout box_layout = new AccountBoxLayout(getContext());//버튼 레이아웃 생성
            items.add(box_layout);
            adapter.notifyDataSetChanged();
            //layout.addView(box_layout);

        }

        //계좌 추가 버튼 달기
        //AddButtonLayout btn_layout = new AddButtonLayout(getContext());//버튼 레이아웃 생성
        //items.add()
        //LinearLayout layout = (LinearLayout)fragmentAccountBinding.accountBoxLayoutContainer; //버튼 레이아웃을 담을 레이아웃
        //layout.addView(btn_layout);


        //return inflater.inflate(R.layout.fragment_account, container, false);
        return fragmentAccountBinding.getRoot();
    }

    class MyAdapter extends ArrayList<AccountBoxLayout>{
        Context context;
        String head[];
        String bank[];
        String type[];
        String money[];
        String accountNumber[];

        MyAdapter(Context con,String head[],String bank[],String type[],Double money[],String accountNumber[]){
            //super(con, R.id.head_mark,R.id.textInput_bank,R.id.textInput_type,R.id.textView_Money,R.id.textInput_accountNumber);
        }

    }
}