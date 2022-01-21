package com.example.easyframe.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.example.easyframe.R;

/**
 * Created by zk
 */

public class EasyProgressDialog extends Dialog {

    private TextView mTitle;

    public EasyProgressDialog(@NonNull Context context) {
        super(context, R.style.EasyCommonProgressDialogStyle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.easy_common_progress_dialog);
        mTitle = findViewById(R.id.easy_progress_title);
        setCanceledOnTouchOutside(false);

    }

    public void setTitle(String title) {
        if (mTitle != null && !TextUtils.isEmpty(title)) {
            mTitle.setText(title);
        }
    }

}
