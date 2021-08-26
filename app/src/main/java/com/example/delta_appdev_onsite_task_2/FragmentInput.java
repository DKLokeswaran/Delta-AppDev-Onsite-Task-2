package com.example.delta_appdev_onsite_task_2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentInput extends Fragment {

    private InputGetter inputGetter;
    private Button[] numbers,operations;
    public ImageButton goBack;
    public static final String[] OPERATIONS={"-",".","","+","-","x","÷","(",")"};


    public interface InputGetter{
        void getInput(int a);
        void getChar(String s);
        void option(int key);
        void beckSpace();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.input_fragment,container,false);
        goBack=view.findViewById(R.id.back);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputGetter.beckSpace();
            }
        });
        numbers=new Button[]{view.findViewById(R.id.zero),
                view.findViewById(R.id.one),
                view.findViewById(R.id.two),
                view.findViewById(R.id.three),
                view.findViewById(R.id.four),
                view.findViewById(R.id.five),
                view.findViewById(R.id.six),
                view.findViewById(R.id.seven),
                view.findViewById(R.id.eight),
                view.findViewById(R.id.nine)
        };
        operations=new Button[]{view.findViewById(R.id.sign),
                view.findViewById(R.id.decimal),
                view.findViewById(R.id.equal),
                view.findViewById(R.id.add),
                view.findViewById(R.id.minus),
                view.findViewById(R.id.into),
                view.findViewById(R.id.divide),
                view.findViewById(R.id.open),
                view.findViewById(R.id.close),
                view.findViewById(R.id.clear)
        };
        for(int i=0;i<10;i++){
            int finalI = i;
            numbers[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    inputGetter.getInput(finalI);
                }
            });
        }
        for(int i=0;i<10;i++){
            int finalI = i;
            operations[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(finalI==2){
                        inputGetter.option(0);
                    }
                    else if(finalI==9){
                        inputGetter.option(1);
                    }
                    else{
                        inputGetter.getChar(OPERATIONS[finalI]);
                    }
                }
            });
        }

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof InputGetter){
            inputGetter=(InputGetter)context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        inputGetter=null;
    }
}
