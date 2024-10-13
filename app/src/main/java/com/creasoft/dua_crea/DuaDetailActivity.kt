package com.creasoft.dua_crea

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView


class DuaDetailActivity : AppCompatActivity() {

    lateinit var mAdView: AdView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dua_detail)

        // Gelen Dua nesnesini al

        mAdView = findViewById(R.id.adView)


        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)


        val dua: Dua? = intent.getParcelableExtra("dua")

        // UI öğelerini tanımlayın
        val titleTextView: TextView = findViewById(R.id.textViewTitle)
        val arabicTextView: TextView = findViewById(R.id.textViewArabic)
        val transliterationTextView: TextView = findViewById(R.id.textViewTransliteration)
        val translationTextView: TextView = findViewById(R.id.textViewTranslation)




        if (dua != null) {
            // Dua nesnesini kullanarak UI öğelerini doldurun
            titleTextView.text = dua.title
            arabicTextView.text = dua.arabicText
            transliterationTextView.text = dua.turkishTransliteration
            translationTextView.text = dua.content // Burayı content olarak güncelleyin

        } else {
            // Dua nesnesi null ise hata mesajı göster
            Toast.makeText(this, "Dua bilgisi bulunamadı", Toast.LENGTH_SHORT).show()
            finish() // Aktiviteyi kapat
        }

        // Geri butonuna tıklama dinleyicisi ekleyin
        val backButton: Button = findViewById(R.id.buttonBack)
        backButton.setOnClickListener {
            // Ana menüye dön
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Mevcut aktiviteyi kapat


    }
    }
}
