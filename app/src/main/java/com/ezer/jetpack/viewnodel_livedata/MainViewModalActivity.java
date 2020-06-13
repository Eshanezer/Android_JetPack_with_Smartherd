package com.ezer.jetpack.viewnodel_livedata;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ezer.jetpack.R;

public class MainViewModalActivity extends AppCompatActivity {

    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view_modal);

        final TextView mTextView = findViewById(R.id.txt_random_number);
        final MainActivityModalView model = new ViewModelProvider(this).get(MainActivityModalView.class);

        //Default ViewModel

        /*String data= model.getNumber();
        mTextView.setText(data);*/

        //ViewModel With LiveData
        final LiveData<String> data = model.getNumber();
        data.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mTextView.setText(s);
                Log.i(TAG,"Data Updated in UI");
            }
        });
        findViewById(R.id.btn_random).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.createNumber();
            }
        });

        Log.i(TAG, "Set Random Number");
    }
}
