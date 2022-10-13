package com.example.cs501_hw5p1_interfragmentcommunication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class fragmentReceiver extends Fragment {
    private fragmentReceiverListener listener;
    private TextView textView;


    public interface fragmentReceiverListener{
        void onInputReceiverSent(CharSequence input);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_receiver, container, false);

        textView = v.findViewById(R.id.textView_receiver);
        return v;
    }

    public void updateTextView(CharSequence newText){
        textView.setText(newText);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof fragmentReceiverListener){
            listener = (fragmentReceiverListener) context;
        }else{
            throw new RuntimeException(context.toString() + "need implement fragmentReceiverListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}