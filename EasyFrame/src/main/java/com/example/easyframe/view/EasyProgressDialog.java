package com.example.easyframe.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.example.easyframe.R;

/**
 * Created by guogansheng on 2017/12/29.
 */

public class EasyProgressDialog extends Dialog {

    public EasyProgressDialog(@NonNull Context context) {
        super(context, R.style.EasyCommonProgressDialogStyle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.easy_common_progress_dialog);
        setCanceledOnTouchOutside(false);
    }
}
