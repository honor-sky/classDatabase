package com.example.classdb;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.classdb.databinding.FragmentMypageBinding;

public class MypageFragment extends Fragment {
    private FragmentMypageBinding fragmentMypageBinding;
    private Fragment fg;

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentMypageBinding = FragmentMypageBinding.inflate(inflater);
        //setInit();

        //목표 프래그먼트 생성(Default)
        //Fragment goalFragment = GoalFragment.newInstance();
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        GoalFragment fg = new GoalFragment();
        fragmentTransaction.replace(R.id.child_fragment_container, fg).commit();
        //목표 리스트 프래그먼트 생성

        return fragmentMypageBinding.getRoot();

    }

    /*
    private void setInit(){
        ViewPager2 viewPageSetUp = View.findViewById(R.id.viewPager2);
        FragmentStateAdapter SetupPagerAdapter = new FragmentStateAdapter(getActivity());

        viewPageSetUp.setAdapter(FragmentStateAdapter);
        viewPageSetUp.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPageSetUp.setOffscreenPageLimit(2);
    }

     */

    public void onViewCreated(){
        fragmentMypageBinding.buttonGoal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //계좌 버튼 선택 해제
                //목표 리스트 프래그먼트 생성
                fg = new GoalFragment();
                setChildFragment(fg,1);
            }
        });
        fragmentMypageBinding.buttonAccount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //목표 버튼 선택 해제
                //계좌 프래그먼트 생성
                fg = new AccountFragment();
                setChildFragment(fg,2);
            }
        });

    }
    @SuppressLint("ResourceType")
    private void setChildFragment(Fragment child, int i) {
        FragmentTransaction childFt = getChildFragmentManager().beginTransaction();

        if (!child.isAdded()) { //프래그먼트가 이미 한 번 스택에 올라가 있는 경우
            childFt.replace(R.id.child_fragment_container, child);
            /*
            if(i==1){
                childFt.replace(R.layout.fragment_goal, child);
            }else{
                //childFt.replace(R.layout.fragment_account, child);
            }

             */
            childFt.addToBackStack(null);
            childFt.commit();
        }
    }
}
