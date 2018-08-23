package com.bethejustice.elecchargingstation;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static android.content.Context.MODE_PRIVATE;

public class SettingDialog extends Dialog {

    Button saveButton;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public SettingDialog(@NonNull Context context) {
        super(context);
    }

    public SettingDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_setting);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        preferences = getContext().getSharedPreferences("firstVisit", MODE_PRIVATE);
        editor = preferences.edit();

        saveButton = findViewById(R.id.btn_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(preferences.contains("first")){
                    editor.remove("first");
                    editor.putBoolean("first", true);
                }else{
                    editor.putBoolean("first", false);
                }
                editor.commit();

                Intent intent = new Intent(getContext(), MainActivity.class);
                getContext().startActivity(intent);
                dismiss();
            }
        });

    }
}
