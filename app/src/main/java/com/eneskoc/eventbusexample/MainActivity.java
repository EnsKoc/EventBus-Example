package com.eneskoc.eventbusexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_one, new FirstFragment(), "fragmentOne");
        fragmentTransaction.add(R.id.fragment_two, new SecondFragment(), "fragmentTwo");
        fragmentTransaction.commit();

        button = (Button) findViewById(R.id.sendBtnMsg);
        editText = (EditText) findViewById(R.id.edittextMsg);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().length() > 0) {
                    //Event'in yayınlandığı, post edildiği (duyurulduğu) yer
                    EventBus.getDefault().post(new ActivityToFragmentEvent(editText.getText().toString()));
                }
            }
        });
    }
}