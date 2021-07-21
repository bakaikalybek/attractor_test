package kg.bakai.test.ui.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kg.bakai.test.R
import kg.bakai.test.databinding.FragmentInfoBinding
import kg.bakai.test.utils.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class InfoFragment : Fragment() {

    private val viewModel by viewModel<InfoViewModel>()
    private lateinit var binding: FragmentInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUser()
        binding.apply {
            val adapter = Adapter()
            rvCompanies.adapter = adapter
            viewModel.user.observe(viewLifecycleOwner) { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        tvName.text = resource.data.firstName
                        tvSurname.text = resource.data.secondName
                        tvEducation.text = resource.data.education.name
                        adapter.submitItems(resource.data.company)
                    }
                }
            }

            btnOpenGallery.setOnClickListener {
                findNavController().navigate(R.id.action_infoFragment_to_galleryFragment)
            }
        }
    }
}