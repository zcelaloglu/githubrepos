package com.celaloglu.zafer.features.repo_detail

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.celaloglu.zafer.R
import com.celaloglu.zafer.databinding.FragmentRepoDetailBinding
import com.celaloglu.zafer.features.repo_detail.RepoDetailFragmentArgs.fromBundle
import com.celaloglu.zafer.features.repos.ReposActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepoDetailFragment : Fragment() {

    private val viewModel by viewModel<RepoDetailViewModel>()

    private val repo by lazy {
        fromBundle(requireArguments()).repo
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentRepoDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_repo_detail, container, false
        )
        binding.item = repo
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as ReposActivity).supportActionBar?.apply {
            title = repo.repoName
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.title) {
            resources.getString(R.string.add_to_bookmark) ->
                viewModel.addBookmark(repo.githubId)
            resources.getString(R.string.remove_from_bookmark) ->
                viewModel.deleteBookmark(repo.githubId)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_repo, menu)
        getBookmarkStatus(menu)
        viewModel.getBookmarkStatus(repo.githubId)
    }

    private fun getBookmarkStatus(menu: Menu) {
        viewModel.uiState.observe(viewLifecycleOwner, { count ->
            val add = menu.findItem(R.id.add_bookmark)
            val remove = menu.findItem(R.id.delete_bookmark)

            add?.isVisible = count < 1
            remove?.isVisible = count > 0
        })
    }
}