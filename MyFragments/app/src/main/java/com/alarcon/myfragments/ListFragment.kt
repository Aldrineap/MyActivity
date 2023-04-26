package com.alarcon.myfragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.alarcon.myfragments.databinding.FragmentListBinding

class ListFragment : Fragment(R.layout.fragment_list) {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: StudentAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentListBinding.bind(view)

        try {
            val students = listOf(
                Student("John Doe", "001", "ic_boy1", "4th Year Level", "Computer Science"),
                Student("Jane Smith", "002", "ic_girl", "2nd Year Level", "Mathematics"),
                Student("Bob Johnson", "003", "ic_boy3", "1st Year Level", "Engineering"),
                Student("Mark Davis", "005", "ic_boy2", "3rd Year Level", "Chemistry"),
                Student("Amanda Lee", "006", "ic_girl", "4th Year Level", "Literature"),
                Student("Steph Curry", "001", "ic_boy1", "4th Year Level", "Computer Science"),
                Student("Julienne Kho", "002", "ic_girl", "2nd Year Level", "Mathematics"),
                Student("Xander Wang", "003", "ic_boy2", "1st Year Level", "Engineering"),
                Student("Bradley king", "005", "ic_boy3", "3rd Year Level", "Chemistry"),
                Student("TongkantangTo", "006", "ic_girl", "4th Year Level", "Literature")
            )

            Log.d("StudentListFragment", "Number of students: ${students.size}")

            binding.recyclerView.adapter = StudentAdapter(students)

            binding.recyclerView.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        } catch (ex: Exception) {
            Log.e("StudentListFragment", "Error populating student list", ex)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
