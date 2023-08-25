package com.example.mathforkids.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.mathforkids.R
import com.example.mathforkids.SharedViewModel
import com.example.mathforkids.databinding.FragmentProblemSolvingBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ProblemSolvingFragment : Fragment() {

    private var _binding: FragmentProblemSolvingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_problem_solving,container,false)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        binding.viewModel = viewModel
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_ProblemSolvingFragment)
//        }
//        val starsNavHostFragment = childFragmentManager.findFragmentById(R.id.stars_fragment_container) as NavHostFragment
//        val starsNavController = starsNavHostFragment.navController
//        starsNavController.setGraph(R.navigation.stars_nav_graph)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}