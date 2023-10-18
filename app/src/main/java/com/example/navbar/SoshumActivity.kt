package com.example.navbar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.navbar.databinding.ActivitySoshumBinding

class SoshumActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySoshumBinding

    private val questions = arrayOf("Pelaku sejarah memiliki peran penting dalam penelitian sejarah karena...",
    "Salah satu faktor yang mendorong pemerintah pendudukan Jepang membubarkan Poetera dan mendirikan Jawa Hokokai adalah...",
    "Karakteristik fisik tanah yang dapat terjaga dengan adanya rotasi tanaman pada budidaya pertanian berkelanjutan adalah ....",
    "Identifikasi perbedaan bangunan sekolah dan hotel dapat dilakukan melalui interpretasi foto udara dengan menggunakan unsur ....",
    "Salah satu usaha yang perlu ditingkatkan oleh Pemerintah Indonesia agar dapat memenuhi kriteria sebagai negara maju adalah ....",
    "Sumber energi biomasa biasanya dimanfaatkan untuk pemenuhan kebutuhan energi bagi masyarakat pedesaan karena ....",
    "Proses pembentukan Bukit Barisan di Sumatera lebih disebabkan oleh ....",
    "Pengangguran di Indonesia tidak hanya disebabkan oleh faktor ekonomi, tetapi juga oleh faktor lain, seperti pendidikan dan kebijakan pemerintah. Hal ini menunjukkan bahwa gejala sosial bersifat...",
    "Kebudayaan adalah keseluruhan sistem gagasan, tindakan, dan hasil karya manusia dalam rangka untuk memenuhi kehidupan masyarakat. Pernyataan tersebut merupakan definisi kebudayaan menurut...",
    "Dalam masyarakat majemuk, etnosentrisme kelompok yang sangat kuat kepada etniknya memberikan dampak timbulnya...")

    private val options = arrayOf(arrayOf("Pelaku sejarah adalah orang yang terlibat langsung dalam peristiwa sejarah", "Kesaksian pelaku sejarah menjadi satu-satunya sumber primer dalam penelitian sejarah", "Pelaku sejarah selalu ingin menonjolkan perannya dalam sejarah", "Ingatan pelaku sejarah mengenai peristiwa yang dialaminya selalu benar"),
    arrayOf("Para pemimpin bangsa Indonesia memanfaatkan Poetera untuk mendorong munculnya rasa kebangsaan", "Para pemimpin Poetera tidak mau melakukan Seikerei", "Organisasi Poetera dianggap sebagai lambang seluruh aliran pergerakan nasional", "Para pemimipin Poetera menjalin kerja sama dengan kelompok Islam"),
    arrayOf("Tekstur tanah", "Struktur Tanah", "Kelembapan Tanah", "Permeabilitas tanah"),
    arrayOf("Bentuk dan pola", "Asosiasi dan Rona", "Ukuran dan Bayangan", "Bayangan dan Bentuk"),
    arrayOf("Pemanfaatan sumber daya alam", "Peluasan industri pertanian", "Perluasan lapangan kerja", "Intensifikasi sektor perdagangan"),
    arrayOf("Teknologi belum berkembang", "Harga minyak tidak stabil", "Potensi energi terbatas", "Teknologi belum berkembang"),
    arrayOf("pembentukan struktur graben tengah", "tumbukan antara dua lempeng tektonik", "tumbuhnya gunung api di sepanjang sesar", "penunjaman lempeng Samudera Hindia"),
    arrayOf("Tidak dapat diukur", "Kompleks", "Satu dimensi", "Sulit diprediksi"),
    arrayOf("Koentjaraningrat", "Selo Soemardjan", "Soerjono Soekanto", "Parsudi Suparlan"),
    arrayOf("Adaptasi", "Keekslusifan", "pluralitas", "Integrasi"))

    private val correctAnswers = arrayOf(0, 0, 1, 0, 2, 3, 3, 1, 0, 1)

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySoshumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayQuestion()

        binding.optioon1Button.setOnClickListener {
            checkAnswer(0)
        }
        binding.optioon2Button.setOnClickListener {
            checkAnswer(1)
        }
        binding.optioon3Button.setOnClickListener {
            checkAnswer(2)
        }
        binding.optioon4Button.setOnClickListener {
            checkAnswer(3)
        }
        binding.restartButton.setOnClickListener {
            restartQuiz()
        }
    }

    private fun correctButtonColors(buttonIndex: Int){
        when(buttonIndex){
            0 -> binding.optioon1Button.setBackgroundColor(Color.RED)
            1 -> binding.optioon2Button.setBackgroundColor(Color.RED)
            2 -> binding.optioon3Button.setBackgroundColor(Color.RED)
            3 -> binding.optioon4Button.setBackgroundColor(Color.RED)
        }
    }
    private fun wrongButtonColors(buttonIndex: Int){
        when (buttonIndex){
            0 -> binding.optioon1Button.setBackgroundColor(Color.BLUE)
            1 -> binding.optioon2Button.setBackgroundColor(Color.BLUE)
            2 -> binding.optioon3Button.setBackgroundColor(Color.BLUE)
            3 -> binding.optioon4Button.setBackgroundColor(Color.BLUE)
        }
    }
    private fun resetButtonColors(){
        binding.optioon1Button.setBackgroundColor(Color.rgb(50, 59, 96))
        binding.optioon2Button.setBackgroundColor(Color.rgb(50, 59, 96))
        binding.optioon3Button.setBackgroundColor(Color.rgb(50, 59, 96))
        binding.optioon4Button.setBackgroundColor(Color.rgb(50, 59, 96))
    }

    private fun showResults(){
        Toast.makeText(this, "Score Kamu adalah: $score dari ${questions.size} Soal", Toast.LENGTH_LONG).show()
        binding.restartButton.isEnabled = true
    }
    private fun displayQuestion(){
        binding.questionText.text = questions[currentQuestionIndex]
        binding.optioon1Button.text = options[currentQuestionIndex][0]
        binding.optioon2Button.text = options[currentQuestionIndex][1]
        binding.optioon3Button.text = options[currentQuestionIndex][2]
        binding.optioon4Button.text = options[currentQuestionIndex][3]
        resetButtonColors()
    }
    private fun checkAnswer(selectedAnswerIndex: Int){
        val correctAnswerIndex = correctAnswers[currentQuestionIndex]

        if (selectedAnswerIndex == correctAnswerIndex){
            score++
            correctButtonColors(selectedAnswerIndex)
        } else {
            wrongButtonColors(selectedAnswerIndex)
            correctButtonColors(correctAnswerIndex)
        }
        if (currentQuestionIndex < questions.size -1){
            currentQuestionIndex++
            binding.questionText.postDelayed({displayQuestion()}, 1000)
        } else {
            showResults()
        }
    }
    private fun restartQuiz(){
        currentQuestionIndex = 0
        score = 0
        displayQuestion()
        binding.restartButton.isEnabled = false
    }
}