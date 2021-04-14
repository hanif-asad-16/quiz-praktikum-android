package id.ac.amikom.hanifasad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    lateinit var etUsername: EditText
    lateinit var btnLogin: Button

    lateinit var prefUtil: PreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        prefUtil = PreferenceUtil.newInstance(this)

        etUsername = findViewById(R.id.et_username)
        btnLogin = findViewById(R.id.btn_submit)

        etUsername.setText(prefUtil.getSring("Username"))
        btnLogin.setOnClickListener {
            saveData()
            val intentWelcomeActivityActivity = Intent(this, WelcomeActivity::class.java).apply{
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            startActivity(intentWelcomeActivityActivity)
        }
    }

    private fun saveData() {
        val nama = etUsername.text.toString().trim()
        prefUtil.setString("nama", nama)
        prefUtil.setBoolean("is_login", true)
    }

}