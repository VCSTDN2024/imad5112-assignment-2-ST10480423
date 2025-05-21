package vcmsa.ci.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var intro : TextView? = null


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        intro = findViewById(R.id.intro)


        val btnStart = findViewById<Button>(R.id.Startbtn)
        val btnExit = findViewById<Button>(R.id.Exitbtn)

        btnStart.setOnClickListener(){
            val intent = Intent(this,Questions::class.java)
            startActivity(intent)
        }

        btnExit.setOnClickListener(){
            finishAffinity()
        }


    }
}