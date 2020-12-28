package com.celaloglu.zafer.features.repos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.celaloglu.zafer.R
import com.celaloglu.zafer.commons.hideKeyboard
import com.celaloglu.zafer.commons.initRecyclerViewWithLineDecoration
import com.celaloglu.zafer.databinding.FragmentReposBinding
import com.celaloglu.zafer.models.ReposItem
import kotlinx.android.synthetic.main.fragment_repos.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ReposFragment : Fragment() {

    private val viewModel by viewModel<ReposViewModel>()

    private lateinit var binding: FragmentReposBinding

    private var text: String? = null

    private val reposAdapter: ReposAdapter by lazy {
        ReposAdapter(
            onClick = { repo, view ->
                val direction =
                    ReposFragmentDirections.actionToRepoDetailFragment(repo)
                view.findNavController().navigate(direction)
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_repos, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as ReposActivity).supportActionBar?.apply {
            title = getString(R.string.app_name)
            setDisplayHomeAsUpEnabled(false)
        }

        observeViewState()

        handleSubmitClick()

        if (text.isNullOrEmpty().not()) {
            viewModel.getUpdatedRepos()
        }
    }

    private fun observeViewState() {
        viewModel.viewState.observe(viewLifecycleOwner, {
            with(binding) {
                viewState = it

                if (it.isLoading().not() && it.getRepos().isNotEmpty()) {
                    displayRepos(it.getRepos())
                }
                executePendingBindings()
            }
        })
    }

    private fun displayRepos(repos: List<ReposItem>) {
        repos_recylerview.apply {
            adapter = reposAdapter.apply {
                submitList(repos)
            }
            initRecyclerViewWithLineDecoration(requireContext())
        }
    }

    private fun handleSubmitClick() {
        submit.setOnClickListener {
            username.clearFocus()
            this.hideKeyboard()

            if (username.text.isNullOrEmpty().not()) {
                with(username.text) {
                    text = this.toString().trim()
                    viewModel.getRepos(this.toString().trim())
                }
            }
        }
    }

}