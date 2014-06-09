package com.curiouslybuilt.splashvideo.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by shanewarren on 6/7/14.
 */
public class SimpleTextViewFragment extends Fragment {

    private String mMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.simple_text_view_fragment, container, false);

        Bundle arguments = getArguments();
        mMessage = arguments.getString("Message");

        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(mMessage);

        return view;
    }
}
