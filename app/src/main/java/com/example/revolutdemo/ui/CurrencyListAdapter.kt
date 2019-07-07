package com.example.revolutdemo.ui

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.revolutdemo.ItemClickListener
import com.example.revolutdemo.R
import com.example.revolutdemo.databinding.ItemCurrencyBinding

class CurrencyListAdapter(val listener: ItemClickListener) : RecyclerView.Adapter<CurrencyListAdapter.ViewHolder>() {
    private lateinit var currencyList: List<Pair<String, Float>>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemCurrencyBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_currency, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (::currencyList.isInitialized) currencyList.size else 0

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position == 0) holder.bind(currencyList[position], listener)
        else holder.bind(currencyList[position], listener)
    }


    fun updatePostList(currencyList: List<Pair<String, Float>>) {
        this.currencyList = currencyList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemCurrencyBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = CurrencyViewModel()

        fun bind(pair: Pair<String, Float>, listener: ItemClickListener) {
            itemView.setOnClickListener { listener.onItemClick(pair.first, pair.second) }
            viewModel.bind(pair)
            binding.viewModel = viewModel
        }
    }
}