package com.bethejustice.elecchargingstation;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CustomDialog extends Dialog {

    static int state;

    Button setButton;
    Button cancelButton;

    RadioGroup radioGroup;
    RadioButton radioButton1;
    RadioButton radioButton2;

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        setButton = findViewById(R.id.btn_select);


        radioButton1 = findViewById(R.id.radio_set1);
        radioButton2 = findViewById(R.id.radio_set2);

        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(radioGroupButtonChangeListener);

        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state = radioGroup.getCheckedRadioButtonId();
                dismiss();
            }
        });
    }

    RadioGroup.OnCheckedChangeListener radioGroupButtonChangeListener = new RadioGroup.OnCheckedChangeListener(){

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(group.getId() == R.id.radioGroup){
                switch (checkedId){
                    case R.id.radio_set1:
                        state = 1;
                        break;
                    case R.id.radio_set2:
                        state = 2;
                        break;
                }
            }
        }
    };


}
