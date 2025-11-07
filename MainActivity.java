package com.example.android_basedsmarthomecontroller;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat; // <-- correct switch

public class MainActivity extends AppCompatActivity {

    // Switches
    private SwitchCompat lightSwitch, fanSwitch, acSwitch, doorSwitch;

    // Icons
    private ImageView lightIcon, fanIcon, acIcon, doorIcon;

    // Labels
    private TextView lightText, fanText, acText, doorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // must match res/layout/activity_main.xml

        // ----- Binding (IDs must exist in activity_main.xml) -----
        lightSwitch = findViewById(R.id.switch_light);
        fanSwitch   = findViewById(R.id.switch_fan);
        acSwitch    = findViewById(R.id.switch_ac);
        doorSwitch  = findViewById(R.id.switch_door);

        lightIcon = findViewById(R.id.icon_light);
        fanIcon   = findViewById(R.id.icon_fan);
        acIcon    = findViewById(R.id.icon_ac);
        doorIcon  = findViewById(R.id.icon_door);

        lightText = findViewById(R.id.text_light);
        fanText   = findViewById(R.id.text_fan);
        acText    = findViewById(R.id.text_ac);
        doorText  = findViewById(R.id.text_door);

        // ----- Listeners -----
        setupSwitch(lightSwitch, lightIcon, lightText, "Light");
        setupSwitch(fanSwitch,   fanIcon,   fanText,   "Fan");
        setupSwitch(acSwitch,    acIcon,    acText,    "AC");
        setupSwitch(doorSwitch,  doorIcon,  doorText,  "Door");
    }

    private void setupSwitch(SwitchCompat s, ImageView icon, TextView label, String name) {
        // no explicit CompoundButton type -> no extra import needed
        s.setOnCheckedChangeListener((button, isChecked) -> {
            if (isChecked) {
                icon.setAlpha(1.0f);
                label.setText(name + " ON");
                Toast.makeText(this, name + " turned ON", Toast.LENGTH_SHORT).show();
            } else {
                icon.setAlpha(0.4f);
                label.setText(name + " OFF");
                Toast.makeText(this, name + " turned OFF", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
