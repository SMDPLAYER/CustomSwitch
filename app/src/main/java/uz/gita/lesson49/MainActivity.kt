package uz.gita.lesson49

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       /* val switchCustom = findViewById<uz.gita.custom.CustomSwitch>(R.id.switchCustom)
        switchCustom.setOnChangeListener {
            Toast.makeText(this, "isChecked=$it", Toast.LENGTH_SHORT).show()
        }
        switchCustom.isChecked = false*/
       /* switchCustom.setOnClickListener {
            Toast.makeText(this, "Click=$it", Toast.LENGTH_SHORT).show()
        }
        switchCustom.setOnClickListener {
            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
        }*/

    }
}