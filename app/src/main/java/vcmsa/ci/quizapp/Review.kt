package vcmsa.ci.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Review : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)

        val displaytext = findViewById<TextView>(R.id.displaytext)
        displaytext.text ="Australia is wider than the moon: True"

        val displaytext2 = findViewById<TextView>(R.id.displaytext2)
        displaytext2.text ="Water boils at a lower temperature at higher altitudes: True"

        val displaytext3 = findViewById<TextView>(R.id.displaytext3)
        displaytext3.text ="Shakespeare wrote the novel Pride and Prejudice: False"

        val displaytext4 = findViewById<TextView>(R.id.displaytext4)
        displaytext4.text ="The human body has more bacterial cells than human cells: True"

        val displaytext5 = findViewById<TextView>(R.id.displaytext5)
        displaytext5.text ="Lightning never strikes the same place twice: False"

        val backkbtn = findViewById<Button>(R.id.backkbtn)
        backkbtn.setOnClickListener(){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }
}

