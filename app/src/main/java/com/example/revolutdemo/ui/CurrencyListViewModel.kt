package com.example.revolutdemo.ui

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.example.revolutdemo.ItemClickListener
import com.example.revolutdemo.R
import com.example.revolutdemo.base.BaseViewModel
import com.example.revolutdemo.network.CurrencyApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CurrencyListViewModel : BaseViewModel(), ItemClickListener {
    @Inject
    lateinit var currencyApi: CurrencyApi
    val postListAdapter: CurrencyListAdapter = CurrencyListAdapter(this)

    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadCurrencies("EUR", 100f) }

    private lateinit var subscription: Disposable

    init {
        loadCurrencies("EUR", 100f)
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    override fun onItemClick(base: String, multiplication: Float) {
        subscription.dispose()
        loadCurrencies(base, multiplication)
    }

    private fun loadCurrencies(base: String, multiplication: Float) {

        subscription = Observable.interval(1, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    currencyApi.getCurrencies(base)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ result ->
                            val list = arrayListOf<Pair<String, Float>>()
                            list.add(0, Pair(base, multiplication))
                            list.addAll(result.rates.toList().map {
                                Pair(it.first, it.second * multiplication)
                            })

                            onRetrievePostListSuccess(list)
                        },
                            { onRetrievePostListError() })
                },
                { onRetrievePostListError() }
            )
    }

    private fun onRetrievePostListSuccess(currencyList: List<Pair<String, Float>>) {
        postListAdapter.updatePostList(currencyList)
    }

    private fun onRetrievePostListError() {
        errorMessage.value = R.string.error
    }
}