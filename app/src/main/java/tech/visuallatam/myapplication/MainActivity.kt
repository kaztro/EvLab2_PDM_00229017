package tech.visuallatam.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tech.visuallatam.myapplication.fragments.ContentFragment
import tech.visuallatam.myapplication.fragments.FakeBarFragment

class MainActivity : AppCompatActivity(), FakeBarFragment.OnSelectOption {

    override fun onAction(id: Int) {
        var content = when (id) {
            1 -> {
                "Hola"
            }
            2 -> {
                "Wiii"
            }
            3 -> {
                "Bye"
            }
            else -> {
                "Fuck!"
            }
        }

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_content, ContentFragment.newInstance(content))
                .addToBackStack("Co")
                .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var barFragment = FakeBarFragment.newInstace(
                "Op1",
                "Op2",
                "Op3"
        )
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_bar, barFragment)
                    .commit()
        }
    }
}

/*
imagen.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    imagen.setImageResource(R.drawable.correo2);
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    imagen.setImageResource(R.drawable.imagen_actual);
                }
                return true;
            }
        });
*/
}
