package vcmsa.ci.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class Questions : AppCompatActivity() {
    private lateinit var questionsbox : TextView
    private lateinit var viewbox : TextView
    private lateinit var answerbox : TextView
    private lateinit var truebtn : Button
    private lateinit var falsebtn : Button
    private lateinit var nextbtn : Button

    companion object {
        val questions = arrayOf(
            "Australia is wider than the moon?",
            "Water boils at a lower temperature at higher altitudes?",
            "Shakespeare wrote the novel Pride and Prejudice?",
            "The human body has more bacterial cells than human cells?",
            "Lightning never strikes the same place twice?"
        )
        val answers = booleanArrayOf(true,true,false,true,false)
    }

    private var score = 0
    private var currentQuestion = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_questions)

        questionsbox = findViewById(R.id.questionbox)
        viewbox = findViewById(R.id.viewbox)
        answerbox = findViewById(R.id.answerbox)
        truebtn = findViewById(R.id.truebtn)
        falsebtn = findViewById(R.id.falsebtn)
        nextbtn = findViewById(R.id.nextbtn)


        truebtn.setOnClickListener(){
            VaildAnswer(true)
        }
        falsebtn.setOnClickListener(){
            VaildAnswer(false)
        }

        nextbtn.setOnClickListener {
            currentQuestion++
            if (currentQuestion < questions.size) {
                Questiondisplay()
                answerbox.text = ""
                truebtn.isEnabled = true
                falsebtn.isEnabled = true
            } else {
                val intent = Intent(this, Score::class.java)
                intent.putExtra("score",score)
                startActivity(intent)
                finish()

            }
        }
        nextbtn.isEnabled = false
    }
    private fun Questiondisplay() {
        questionsbox.text = questions[currentQuestion]
    }

    private fun VaildAnswer(userAnswer: Boolean){
        val RightAnswer = answers[currentQuestion]

        if (userAnswer == RightAnswer){
            answerbox.text ="Correct"
            score++
        } else {
            answerbox.text = "Incorrect"
        }
        truebtn.isEnabled = false
        falsebtn.isEnabled = false
        nextbtn.isEnabled = true

    }
}