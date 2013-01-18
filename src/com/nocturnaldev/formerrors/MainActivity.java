package com.nocturnaldev.formerrors;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends Activity {

    private EditText editText;
    private CheckBox chbx;
    private RadioButton radionBtn;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edittext_with_error);
        chbx = (CheckBox) findViewById(R.id.checkbox_with_error);
        radionBtn = (RadioButton) findViewById(R.id.radiobutton_with_error);
        btn = (Button) findViewById(R.id.button_with_error);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    public void onShowErrorMarkersClick(View view) {
        if (editText.getError() == null) {
            editText.setError(getString(R.string.must_be_filled));

            chbx.setFocusableInTouchMode(true);
            Drawable customErrorDrawable = getResources().getDrawable(R.drawable.custom_error);
            customErrorDrawable.setBounds(0, 0, 
                    customErrorDrawable.getIntrinsicWidth(), customErrorDrawable.getIntrinsicHeight());
            if (chbx.isChecked()) {
                chbx.setError(getString(R.string.must_be_unchecked), customErrorDrawable);
            } else {
                chbx.setError(getString(R.string.must_be_checked), customErrorDrawable);
            }

            radionBtn.setFocusableInTouchMode(true);
            if (radionBtn.isChecked()) {
                radionBtn.setError(getString(R.string.must_be_unchecked));
            } else {
                radionBtn.setError(getString(R.string.must_be_checked));
            }

            btn.setFocusableInTouchMode(true);
            btn.setError(getString(R.string.unknown_error));
            
            ((Button) view).setText(R.string.hide_error_markers);
        } else {
            editText.setError(null);
            chbx.setFocusableInTouchMode(false);
            chbx.setError(null);
            radionBtn.setFocusableInTouchMode(false);
            radionBtn.setError(null);
            btn.setFocusableInTouchMode(false);
            btn.setError(null);
            ((Button) view).setText(R.string.show_error_markers);
        }
    }

}
