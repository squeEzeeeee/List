package com.example.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.list.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), WorkersAdapter.Listener{
    lateinit var binding: ActivityMainBinding
    private val adapter = WorkersAdapter(this)
    private var editLauncher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                adapter.addWorkers(it.data?.getSerializableExtra("worker") as Worker)

            }
        }
    }
    private fun init(){
        binding.apply {
            rcView.layoutManager = LinearLayoutManager  (this@MainActivity)
            rcView.adapter = adapter
            buttonAdd.setOnClickListener{
                editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))

            }
        }
    }

    override fun onClick(worker: Worker) {
        Toast.makeText(this,"Ахуеть", Toast.LENGTH_LONG).show()
    }
}