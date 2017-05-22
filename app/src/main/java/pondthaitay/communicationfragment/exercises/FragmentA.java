package pondthaitay.communicationfragment.exercises;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hwangjr.rxbus.RxBus;

public class FragmentA extends Fragment {

    private AppCompatEditText etTest;

    public static FragmentA getInstance() {
        FragmentA fragment = new FragmentA();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        bindView(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) {
            restoreView(savedInstanceState);
        }
    }

    private void restoreView(Bundle savedInstanceState) {
        String text = savedInstanceState.getString("text", "");
        etTest.setText(text);
    }

    private void bindView(View view) {
        etTest = (AppCompatEditText) view.findViewById(R.id.et_test);
        etTest.addTextChangedListener(getWatcher());
    }

    @NonNull
    private TextWatcher getWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // somethings
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                RxBus.get().post("fragment_b", String.valueOf(s));
            }

            @Override
            public void afterTextChanged(Editable s) {
                // somethings
            }
        };
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text", etTest.getText().toString());
    }
}
