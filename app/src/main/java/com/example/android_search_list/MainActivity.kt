package com.example.android_search_list
import android.view.View
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: StudentAdapter
    private lateinit var searchView: EditText
    private lateinit var textViewError: TextView

    private val studentList = listOf(
        Student("Trần Minh Tú", "20216501"),
        Student("Nguyễn Thị Kim Chi", "20216502"),
        Student("Lê Văn Khải", "20216503"),
        Student("Phạm Hoàng Hải", "20216504"),
        Student("Bùi Minh Tâm", "20216505"),
        Student("Đặng Thị Hương", "20216506"),
        Student("Vũ Văn Thành", "20216507"),
        Student("Nguyễn Ngọc Bích", "20216508"),
        Student("Lê Thị Hạnh", "20216509"),
        Student("Hồ Văn Phúc", "20216510"),
        Student("Trương Văn Tâm", "20216511"),
        Student("Phan Thị Nga", "20216512"),
        Student("Nguyễn Tiến Dũng", "20216513"),
        Student("Lý Văn Sơn", "20216514"),
        Student("Hoàng Thị Mai", "20216515"),
        Student("Nguyễn Văn Đạt", "20216516"),
        Student("Đỗ Thị Thu Hà", "20216517"),
        Student("Vũ Minh Trường", "20216518"),
        Student("Trần Văn Khải", "20216519"),
        Student("Nguyễn Hoàng Linh", "20216520"),
        Student("Bùi Thị Xuân", "20216521"),
        Student("Nguyễn Thanh Bình", "20216522"),
        Student("Phạm Văn Tuyên", "20216523"),
        Student("Lê Thị Ngân", "20216524"),
        Student("Nguyễn Đình Thắng", "20216525"),
        Student("Võ Văn Sang", "20216526"),
        Student("Hồ Thị Bảo Ngọc", "20216527"),
        Student("Nguyễn Văn Cường", "20216528"),
        Student("Lê Minh Châu", "20216529"),
        Student("Trần Văn Hữu", "20216530")

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchView = findViewById(R.id.searchView)
        textViewError = findViewById(R.id.textViewError)
        val listViewStudents: ListView = findViewById(R.id.listViewStudents)

        adapter = StudentAdapter(this, studentList)
        listViewStudents.adapter = adapter

        searchView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString()
                filterList(query)
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun filterList(query: String) {
        if (query.length < 3) {
            adapter.updateList(studentList)
            textViewError.visibility = View.GONE
            return
        }

        val filteredStudents = studentList.filter {
            it.name.contains(query, ignoreCase = true) || it.mssv.contains(query)
        }

        if (filteredStudents.isEmpty()) {
            textViewError.text = "No students found."
            textViewError.visibility = View.VISIBLE
        } else {
            textViewError.visibility = View.GONE
        }

        adapter.updateList(filteredStudents)
    }
}