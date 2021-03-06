package com.example.flyair;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;




public class MainActivity extends AppCompatActivity implements NavegationHost{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState==null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new LoginFragment())
                    .commit();
        }

    }

    //here va el fragmento de navegacion
    //@param fragment a donde vamos a ir a navegar
    //@param addtobackstack si podemos  ir hacia atras 40:31

    @Override
    public void navigateTo(Fragment fragment,boolean addToBackstack){
            FragmentTransaction transaction=
                    getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment);


            if (addToBackstack){
                transaction.addToBackStack(null);
            }


        transaction.commit();

    }
}