package com.race.radiobuttonsupport;

import android.view.View;
import android.view.ViewParent;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class GRadioGroup {
    List<RadioButton> radios = new ArrayList<RadioButton>();

    public GRadioGroup(RadioButton... radios) {
        super();

        for (RadioButton rb : radios) {
            this.radios.add(rb);
            rb.setOnClickListener(onClick);
        }
    }

    public GRadioGroup(View activity, int... radiosIDs) {
        super();

        for (int radioButtonID : radiosIDs) {
            RadioButton rb = (RadioButton) activity.findViewById(radioButtonID);
            if (rb != null) {
                this.radios.add(rb);
                rb.setOnClickListener(onClick);
            }
        }
    }


    View.OnClickListener onClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            for (RadioButton rb : radios) {

                ViewParent p = rb.getParent();
                if (p.getClass().equals(RadioGroup.class)) {
                    RadioGroup rg = (RadioGroup) p;
                    rg.clearCheck();
                } else {
                    rb.setChecked(false);
                }
            }
        }
    };
}