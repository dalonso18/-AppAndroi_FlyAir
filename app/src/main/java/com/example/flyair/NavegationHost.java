package com.example.flyair;
import  androidx.fragment.app.Fragment;



//ESTO Es un host  para una actividad que se  pueda  mostrar con un fragmento
//*los eventos de navegacion 32:58 7-1
public interface NavegationHost {

    void navigateTo(Fragment fragment,boolean addToBackstack);
}
