package com.lordmegamax.omdbandroidclient.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lordmegamax.omdbandroidclient.data.OmdbApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

private const val TAG = "HomeViewModel"

class HomeViewModel(omdbApi: OmdbApi) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val compositeDisposable = CompositeDisposable()

    init {
        loadFirstDummyData(omdbApi)
    }

    private fun loadFirstDummyData(omdbApi: OmdbApi) {
        omdbApi.search("Happy")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy { response ->

                _text.value = response.toString()

            }.addTo(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()

        compositeDisposable.dispose()
    }
}