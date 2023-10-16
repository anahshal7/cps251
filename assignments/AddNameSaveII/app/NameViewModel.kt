import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider

class NameViewModel : ViewModel() {
    private val nameList = mutableListOf<String>()

    val names: LiveData<List<String>> = MutableLiveData()

    fun addName(name: String) {
        nameList.add(name)
        names.value = nameList.toList()
    }
}

class ActivityMain : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var nameViewModel: NameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nameViewModel = ViewModelProvider(this).get(NameViewModel::class.java)

        // Observe the LiveData object and update the UI accordingly
        nameViewModel.names.observe(this) { names ->
            // Update the UI to display the new name list
        }
    }

    fun onAddButtonClick(view: View) {
        val name = binding.nameEditText.text.toString()
        if (name.isNotBlank()) {
            nameViewModel.addName(name)
        } else {
            // Handle the case where no name is entered
            // Display a message or toast, as shown in your provided specifications
        }
    }
}
