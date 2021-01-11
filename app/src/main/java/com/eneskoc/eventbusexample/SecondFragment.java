package com.eneskoc.eventbusexample;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class SecondFragment extends Fragment {

    private TextView textView;

    @Override
    public void onStart() {
        super.onStart();
        //Gelen event'ı FirstFragment da yakalamak(dinlemek) için.
        EventBus.getDefault().register(this);
        Log.i("SecondFragment:", "onStart()");
    }

    @Override
    public void onPause() {
        super.onPause();
        //Event'i dinlemek istemiyor veya onunla işlemimiz bittiyse.
        EventBus.getDefault().unregister(this);
        Log.i("SecondFragment:", "onPause()");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        textView = (TextView) view.findViewById(R.id.txtMessageSecondFragment);
        Log.i("SecondFragment:", "onCreateView()");
        return view;
    }

    //Gerçekleştirmek istediğimiz olayı artık yakalayıp kullanmak istiyorsak.
    @Subscribe
    public void onEvent(ActivityToFragmentEvent messageEvent) {
        textView.setText(messageEvent.getMsg());
        Log.i("SecondFragment:", "onEvent()");
    }
}
