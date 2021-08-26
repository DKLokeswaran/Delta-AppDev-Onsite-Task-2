package com.example.delta_appdev_onsite_task_2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentOutput extends Fragment {

    private TextView ans,query;
    private OutputSetter outputSetter;
    private String view="";
    private char operator;
    public int pos;

    public void getResult() {
        char[] arr=view.toCharArray();
        for(int i=0;i<arr.length;i++){
            char ch=arr[i];
            if((ch == '+')||(ch == '-')||(ch == 'x')||(ch == '÷')){
                operator=ch;
                pos=i;
                break;
            }
        }
        String num1="";
        String num2="";
        for(int i=0;i<pos;i++){
            num1+=arr[i];
        }
        for(int i=pos+1;i<arr.length;i++){
            num2+=arr[i];
        }
        int result=0;
        switch(operator){
            case '+':result=Integer.parseInt(num1)+Integer.parseInt(num2);
                    break;
            case '-':result=Integer.parseInt(num1)-Integer.parseInt(num2);
                break;
            case 'x':result=Integer.parseInt(num1)*Integer.parseInt(num2);
                break;
            case '÷':result=Integer.parseInt(num1)/Integer.parseInt(num2);
                break;
            default:ans.setText("Error");
            break;


        }
        ans.setText(Integer.toString(result));
    }

    public interface OutputSetter{
        void getResult();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.result_fragment,container,false);
        query=view.findViewById(R.id.ques);
        ans=view.findViewById(R.id.answer);
        outputSetter.getResult();
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OutputSetter){
            outputSetter=(OutputSetter) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        outputSetter=null;
    }
    public void setResult(String a){
        view+=a;
        query.setText(view);
    }

    public void clear() {
        view="";
        query.setText("");
        ans.setText("");
    }
    public void backSpace(){
        if(!view.equals("")&&view!=null){
            view=view.substring(0, view.length() - 1);
            query.setText(view);
        }

    }
}
