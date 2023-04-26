package com.alarcon.myfragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alarcon.myfragments.databinding.ListItemStudentBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class StudentAdapter(private val students: List<Student>) :
    RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ListItemStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(student: Student) {
            binding.tvName.text = student.name
            binding.tvId.text = student.id
            binding.tvCourse.text = student.course
            binding.tvYear.text = student.yearLevel

            val imageResourceId = binding.root.context.resources.getIdentifier(
                student.image, "drawable", binding.root.context.packageName
            )

            Glide.with(binding.root.context)
                .load(imageResourceId)
                .apply(RequestOptions().circleCrop())
                .into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemStudentBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = students[position]
        holder.bind(student)
    }

    override fun getItemCount(): Int {
        return students.size
    }
}
