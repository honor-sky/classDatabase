package com.example.classdb.ui.Book;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.classdb.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BookAddBottomSheetDialog extends BottomSheetDialogFragment {
    private View view;
    private BottomSheetListener mListener;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        view = inflater.inflate(R.layout.bottomsheet_layout_add, container, false);
        mListener = (BottomSheetListener) getContext();
        return view;
    }

    public interface BottomSheetListener {
        void onButtonClicked(String text);
    }
}
