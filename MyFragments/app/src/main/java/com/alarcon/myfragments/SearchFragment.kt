import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.alarcon.myfragments.databinding.FragmentSearchBinding
import com.alarcon.myfragments.Student

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val students = mapOf(
        "789" to Student("Bob Johnson", "789", "ic_boy", "3rd Year Level", "Computer Science"),
        "123" to Student("John Doe", "123", "ic_boy1", "1st Year Level", "Psychology"),
        "456" to Student("Jane Smith", "456", "ic_girl", "2nd Year Level", "Zoology")

    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchButton.setOnClickListener {
            val input = binding.userInput.text.toString()
            val student = searchStudent(input)
            if (student != null) {
                displayStudentInfo(student)
                showContinueDialog()
            } else {
                displayNotFound()
            }
        }
    }

    private fun searchStudent(input: String): Student? {
        return students[input] ?: students.values.firstOrNull {
            it.name.equals(
                input,
                ignoreCase = true
            )
        }
    }

    private fun displayStudentInfo(student: Student) {
        val imageResource =
            resources.getIdentifier(student.image, "drawable", activity?.packageName)
        binding.studentImage.setImageResource(imageResource)
        binding.studentName.text = "Name: ${student.name}"
        binding.studentId.text = "ID: ${student.id}"
        binding.studentYearLevel.text = "Year Level: ${student.yearLevel}"
        binding.studentCourse.text = "Course: ${student.course}"

        binding.studentImage.visibility = View.VISIBLE
        binding.studentName.visibility = View.VISIBLE
        binding.studentId.visibility = View.VISIBLE
        binding.studentYearLevel.visibility = View.VISIBLE
        binding.studentCourse.visibility = View.VISIBLE
        binding.userInput.visibility = View.GONE
    }

    private fun displayNotFound() {
        AlertDialog.Builder(requireContext())
            .setTitle("Student not found")
            .setMessage("The student you searched for is not registered.")
            .setPositiveButton("OK", null)
            .show()
    }

    private fun showContinueDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Continue?")
            .setMessage("Do you want to search for another student?")
            .setPositiveButton("Yes") { _, _ ->
                binding.userInput.setText("")
                binding.studentImage.visibility = View.GONE
                binding.studentName.visibility = View.GONE
                binding.studentId.visibility = View.GONE
                binding.studentYearLevel.visibility = View.GONE
                binding.studentCourse.visibility = View.GONE
                binding.userInput.visibility = View.VISIBLE
            }
            .setNegativeButton("No") { _, _ ->
                binding.userInput.setText("")
                binding.studentImage.visibility = View.GONE
                binding.studentName.visibility = View.GONE
                binding.studentId.visibility = View.GONE
                binding.studentYearLevel.visibility = View.GONE
                binding.studentCourse.visibility = View.GONE
                binding.userInput.visibility = View.VISIBLE
            }
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}