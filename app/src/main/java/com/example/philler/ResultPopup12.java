package com.example.philler;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class ResultPopup12 extends Dialog implements View.OnClickListener {
    ImageView img;

    public ResultPopup12(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_result_popup12);
        img = findViewById(R.id.img);
        img.setOnClickListener(this);

        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        lp.x = 400;
        lp.y = 190;
        getWindow().setAttributes(lp);
    }

    @Override
    public void onClick(View v) {
        dismiss();
    }
}
