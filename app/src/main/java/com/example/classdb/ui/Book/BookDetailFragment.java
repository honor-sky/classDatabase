package com.example.classdb.ui.Book;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.classdb.R;
import com.example.classdb.databinding.FragmentBookDetailBinding;

public class BookDetailFragment extends Fragment {

    private FragmentBookDetailBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBookDetailBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                NavHostFragment.findNavController(BookDetailFragment.this)
                        .navigate(R.id.action_navigation_book_detail_to_navigation_book);
            }
        });

//        binding.addBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                BookAddBottomSheetDialog bookAddBottomSheetDialog = new BookAddBottomSheetDialog();
//                bookAddBottomSheetDialog.show(getParentFragmentManager(),"BottomSheet");
//            }
//        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}