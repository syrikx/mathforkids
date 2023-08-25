package com.example.mathforkids.main.problemsolving

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mathforkids.R
import com.example.mathforkids.SharedViewModel
import com.example.mathforkids.databinding.FragmentStarsBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class StarsFragment : Fragment() {

    private var _binding: FragmentStarsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_stars,container,false)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        binding.viewModel = viewModel
//        viewModel.noCorrectAnswers.observe(viewLifecycleOwner, Observer { value ->
//            binding.star10.setImageResource(R.drawable.filled_star)
//        })
        val starImages = listOf(
            binding.star1, binding.star2, binding.star3, binding.star4, binding.star5,
            binding.star6, binding.star7, binding.star8, binding.star9, binding.star10
        )

        viewModel.noCorrectAnswers.observe(viewLifecycleOwner, Observer { value ->
            for (i in 0 until value) {
                starImages[i].setImageResource(R.drawable.filled_star)
            }
        })



//        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}