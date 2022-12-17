package com.example.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.list.databinding.WorkersItemBinding
import java.util.ArrayList

class WorkersAdapter(val listener: Listener) : RecyclerView.Adapter<WorkersAdapter.WorkersHolder>() {
    val workersList= ArrayList<Worker>()
    class WorkersHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding= WorkersItemBinding.bind(item)
        fun bind(worker: Worker,listener: Listener) = with(binding){
            val imageList = listOf(
                R.drawable.worker1, R.drawable.worker2, R.drawable.worker3
            )
            im.setImageResource(imageList[worker.imageId])
            nametitle.text=worker.workerName
            departtitle.text=worker.workerDepartament
            itemView.setOnClickListener{
                listener.onClick(worker)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkersHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.workers_item, parent, false)
        return WorkersHolder(view)
    }

    override fun onBindViewHolder(holder: WorkersHolder, position: Int) {
        holder.bind(workersList[position],listener)

    }

    override fun getItemCount(): Int {
        return workersList.size
    }

    fun addWorkers(worker: Worker){
        workersList.add(worker)
        notifyDataSetChanged()
    }
interface Listener {
    fun onClick(worker: Worker){

    }
}
}


