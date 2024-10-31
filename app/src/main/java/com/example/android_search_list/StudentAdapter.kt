package com.example.android_search_list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class StudentAdapter(private val context: Context, private var studentList: List<Student>) : BaseAdapter() {

    fun updateList(filteredStudents: List<Student>) {
        this.studentList = filteredStudents
        notifyDataSetChanged()
    }

    override fun getCount(): Int = studentList.size

    override fun getItem(position: Int): Student = studentList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_student, parent, false)

        val student = getItem(position)
        view.findViewById<TextView>(R.id.textViewName).text = student.name
        view.findViewById<TextView>(R.id.textViewMSSV).text = student.mssv

        return view
    }
}