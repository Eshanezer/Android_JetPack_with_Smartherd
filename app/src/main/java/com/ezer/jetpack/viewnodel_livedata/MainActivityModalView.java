package com.ezer.jetpack.viewnodel_livedata;

import android.util.Log;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainActivityModalView extends ViewModel {
    private String TAG = this.getClass().getSimpleName();
    private MutableLiveData<String> myRandomNumber;

    // Default ViewModel
    //private String myRandomNumber;
   /* public String getNumber(){
        Log.i(TAG,"Get Number");
        if(myRandomNumber==null){
            createNumber();
        }
        return myRandomNumber;
    }*/

    public MutableLiveData<String> getNumber(){
        Log.i(TAG,"Get Number");
        if(myRandomNumber==null){
            myRandomNumber = new MutableLiveData<>();
            createNumber();
        }
        return myRandomNumber;
    }

    public void createNumber() {
        Log.i(TAG,"Create new Number");
        Random random = new Random();
        myRandomNumber.setValue("Number :"+(random.nextInt(10 -1)+1));
    }
}
