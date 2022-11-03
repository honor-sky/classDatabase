package com.example.classdb.ui.Mypage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.classdb.R;
import com.example.classdb.databinding.FragmentMypageBinding;

public class MypageFragment extends Fragment {

    private FragmentMypageBinding fragmentMypageBinding;
    private Fragment fg;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //MypageViewModel notificationsViewModel = new ViewModelProvider(this).get(MypageViewModel.class);

        fragmentMypageBinding = FragmentMypageBinding.inflate(inflater);

        //목표 프래그먼트 생성(Default)
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fg = GoalFragment.newInstance("1","2");
        fragmentTransaction.replace(R.id.child_fragment_container, fg).commit();
        //fragmentMypageBinding.buttonGoal.setSelected(true);

        fragmentMypageBinding.buttonGoal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //계좌 버튼 선택 해제
                fragmentMypageBinding.buttonGoal.setPressed(true);
                fragmentMypageBinding.buttonAccount.setPressed(false);
                //목표 리스트 프래그먼트 생성
                fg = GoalFragment.newInstance("1","2");
                setChildFragment(fg);
            }
        });
        fragmentMypageBinding.buttonAccount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //목표 버튼 선택 해제
                fragmentMypageBinding.buttonAccount.setPressed(true);
                fragmentMypageBinding.buttonGoal.setPressed(false);
                //계좌 프래그먼트 생성
                fg = AccountFragment.newInstance("1","2");;
                setChildFragment(fg);
            }
        });


        //목표 리스트 프래그먼트 생성
        return fragmentMypageBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentMypageBinding = null;
    }

    @SuppressLint("ResourceType")
    private void setChildFragment(Fragment child) {
        FragmentTransaction childFt = getChildFragmentManager().beginTransaction();

        if (!child.isAdded()) { //프래그먼트가 이미 한 번 스택에 올라가 있는 경우
            childFt.replace(R.id.child_fragment_container, child);

            childFt.addToBackStack(null);
            childFt.commit();
        }
    }
}