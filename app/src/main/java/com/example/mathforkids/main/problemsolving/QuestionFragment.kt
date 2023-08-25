package com.example.mathforkids.main.problemsolving

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mathforkids.R
import com.example.mathforkids.SharedViewModel
import com.example.mathforkids.databinding.FragmentQuestionBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class QuestionFragment : Fragment() {

    private var _binding: FragmentQuestionBinding? = null
    private lateinit var dingdong: MediaPlayer
    private lateinit var ddeng: MediaPlayer

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_question,container,false)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        viewModel.resetProblem()
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
//        viewModel.isAnswerVisible.observe(viewLifecycleOwner, Observer { value ->
//            binding.cardAnswer.visibility = value
//        })
//        binding.lifecycleOwner = viewLifecycleOwner
        dingdong = MediaPlayer.create(context, R.raw.dingdong)
        ddeng = MediaPlayer.create(context, R.raw.ddeng)
        viewModel.correctAnswerEvent.observe(viewLifecycleOwner) {
            dingdong.start()
        }
        viewModel.incorrectAnswerEvent.observe(viewLifecycleOwner) {
            ddeng.start()
        }
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}