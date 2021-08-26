package com.example.delta_appdev_onsite_task_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentInput.InputGetter, FragmentOutput.OutputSetter {
    private FragmentInput fragmentInput;
    private FragmentOutput fragmentOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentInput=new FragmentInput();
        fragmentOutput=new FragmentOutput();
        getSupportFragmentManager().beginTransaction().replace(R.id.containerInput,fragmentInput).replace(R.id.containerResult,fragmentOutput).commit();
    }

    @Override
    public void getInput(int a) {
        fragmentOutput.setResult(Integer.toString(a));
    }

    @Override
    public void getChar(String s) {
        fragmentOutput.setResult(s);
    }

    @Override
    public void option(int key) {
        if(key==0){
            fragmentOutput.getResult();
        }
        else{
            fragmentOutput.clear();
        }
    }

    @Override
    public void beckSpace() {
        fragmentOutput.backSpace();
    }

    @Override
    public void getResult() {

    }
}