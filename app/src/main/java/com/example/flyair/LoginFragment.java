package com.example.flyair;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginFragment extends Fragment {


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedIntancestate) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);

        final TextInputLayout passwordTextInput = view.findViewById(R.id.password_text_input);
        final TextInputEditText passwordTextEditText = view.findViewById(R.id.password_edit_text);
        MaterialButton nextButton = view.findViewById(R.id.next_button);

        nextButton.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick (View view){
            if(!isPasswordValid(passwordTextEditText.getText())){
                passwordTextInput.setError(getString(R.string.error_password));
            }else{
                passwordTextInput.setError(null);//01:54 7-2 6/12 12:21
                ((NavegationHost)getActivity()).navigateTo(new ProductGridFragment(),false);
            }


        }
          });
             passwordTextEditText.setOnKeyListener(new View.OnKeyListener(){


            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (isPasswordValid(passwordTextEditText.getText())) {

                    passwordTextInput.setError(null);//01:13 7-2
                }

                return false;
            }


    });
        return view;
    }
    private boolean isPasswordValid(@NonNull Editable text){

        return  text != null && text.length() >=6;

    }
}


