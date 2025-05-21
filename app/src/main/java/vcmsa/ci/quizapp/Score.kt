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

class Score : AppCompatActivity() {

    private lateinit var scoretext : TextView
    private lateinit var feedback : TextView
    private lateinit var reviewbtn : Button
    private lateinit var  backbtm : Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)

        scoretext = findViewById(R.id.Scoretext)
        feedback = findViewById(R.id.feedback)
        reviewbtn = findViewById(R.id.reviewbtn)
        backbtm = findViewById(R.id.backtn)


        val score = intent.getIntExtra("score" ,0)
        scoretext.text = "Your currrent score is: $score/5"

        val results = if (score >= 3) {
            "Great try you are doing good!"
        } else {
            "Get better this is all you can do!"
        }
        feedback.text = results

        reviewbtn.setOnClickListener(){
            val intent = Intent(this, Review::class.java)
            startActivity(intent)
        }

        backbtm.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}