package tech.visuallatam.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tech.visuallatam.myapplication.R
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
            else -> {
                "lolito"
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
                "<------",
                "------>"
        )
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_bar, barFragment)
                    .commit()
        }
    }
}
