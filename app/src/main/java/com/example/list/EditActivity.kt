package com.example.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.list.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    private val imageIdList = listOf(R.drawable.worker1, R.drawable.worker2, R.drawable.worker3)
    private var indexImage = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
    }

    private fun initButtons() = with(binding) {
        bNext.setOnClickListener() {
            indexImage++
            Log.d("Tg", indexImage.toString())
            if (indexImage > imageIdList.size - 1) indexImage = 0
            imageView.setImageResource(imageIdList[indexImage])
        }
        bDone.setOnClickListener {
            val worker = Worker(indexImage, edName.text.toString(), edDepart.text.toString())
            val addIntent = Intent().apply { putExtra("worker", worker) }
            setResult(RESULT_OK, addIntent)
            finish()
        }
    }
}