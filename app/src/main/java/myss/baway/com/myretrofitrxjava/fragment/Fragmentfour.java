package myss.baway.com.myretrofitrxjava.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import myss.baway.com.myretrofitrxjava.MainActivity;
import myss.baway.com.myretrofitrxjava.R;
import myss.baway.com.myretrofitrxjava.ZuceActivity;

/**
 * Created by 陈驰 on 2017/5/26.
 */

public class Fragmentfour extends Fragment implements View.OnClickListener {
    private EditText input_name, input_password, input_email;
    private TextInputLayout layout_name, layout_password, layout_email;
    private Button btn_login;
    private View view;
    private ImageView login_phone;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(), R.layout.fragment_four,null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initWidget();

    }



    private void initWidget() {

        input_name = (EditText)view.findViewById(R.id.input_name);
        input_password = (EditText) view.findViewById(R.id.input_password);
        input_email = (EditText) view.findViewById(R.id.input_email);

        login_phone = (ImageView) view.findViewById(R.id.login_phone);
         login_phone.setOnClickListener(this);

        layout_name = (TextInputLayout) view.findViewById(R.id.layout_name);
        layout_password = (TextInputLayout) view.findViewById(R.id.layout_password);
        layout_email = (TextInputLayout) view.findViewById(R.id.layout_email);

        btn_login = (Button) view.findViewById(R.id.login);
        btn_login.setOnClickListener(this);

        //添加监听
        input_name.addTextChangedListener(new MyTextWatcher(input_name));
        input_password.addTextChangedListener(new MyTextWatcher(input_password));
        input_email.addTextChangedListener(new MyTextWatcher(input_email));
    }

      @Override
      public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                canLogin();

                break;
            case R.id.login_phone:
                login_phone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), ZuceActivity.class);
                        startActivity(intent);
                    }
                });
               break;
            default:
                break;

        }
    }

    private void canLogin1() {


    }

    /**
     * 判断是否可以登录的方法
     */
    private void canLogin() {
        if (!isNameValid()) {

            Toast.makeText(getActivity(), getString(R.string.check), Toast.LENGTH_SHORT).show();
            return;
        }
        if (!isPasswordValid()) {
            Toast.makeText(getActivity(), getString(R.string.check), Toast.LENGTH_SHORT).show();
            return;
        }
        if (!isEmailValid()) {
            Toast.makeText(getActivity(), getString(R.string.check), Toast.LENGTH_SHORT).show();
            return;
        }
     Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);

        Toast.makeText(getActivity(), getString(R.string.login_success), Toast.LENGTH_SHORT).show();
    }

    public boolean isNameValid() {

        if (input_name.getText().toString().trim().equals("") || input_name.getText().toString().trim().isEmpty()) {
            layout_name.setError(getString(R.string.error_name));
            input_name.requestFocus();
            return false;
        }
        layout_name.setErrorEnabled(false);
        return true;
    }

    public boolean isPasswordValid() {
        if (input_password.getText().toString().trim().equals("") || input_password.getText().toString().trim().isEmpty()) {
            layout_password.setErrorEnabled(true);
            layout_password.setError(getResources().getString(R.string.error_password));
            input_password.requestFocus();
            return false;
        }
        layout_password.setErrorEnabled(false);
        return true;
    }

    public boolean isEmailValid() {
        String email = input_email.getText().toString().trim();
        if (TextUtils.isEmpty(email) || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            layout_email.setErrorEnabled(true);
            layout_email.setError(getString(R.string.error_email));
            layout_email.requestFocus();
            return false;
        }
        layout_email.setErrorEnabled(false);
        return true;
    }

    //动态监听输入过程
    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            switch (view.getId()) {
                case R.id.input_name:
                    isNameValid();
                    break;
                case R.id.input_password:
                    isPasswordValid();
                    break;
                case R.id.input_email:
                    isEmailValid();
                    break;

            }

        }
    }
    }


