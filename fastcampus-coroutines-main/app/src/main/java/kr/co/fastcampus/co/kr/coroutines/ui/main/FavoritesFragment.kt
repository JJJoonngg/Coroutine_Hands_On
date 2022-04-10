package kr.co.fastcampus.co.kr.coroutines.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kr.co.fastcampus.co.kr.coroutines.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {

    private val imageSearchViewModel: ImageSearchViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        val root = binding.root

        val favoritesAdapter = FavoritesAdapter()
        binding.recyclerView.adapter = favoritesAdapter
        binding.recyclerView.layoutManager = GridLayoutManager(context, 3)

        viewLifecycleOwner.lifecycleScope.launch {
            imageSearchViewModel.favoritesFlow.collectLatest { items ->
                favoritesAdapter.setItems(items)
            }
        }

        return root
    }
}