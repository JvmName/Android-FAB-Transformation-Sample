package com.parthpadg.fabanimation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ColorActionSheetViewModel : ViewModel() {

    private val _colorList = MutableLiveData<List<String>>().apply { value = defaultList }

    fun getColorList(): LiveData<List<String>> = _colorList


    fun setColorListDefault(){
        _colorList.value = defaultList
    }

    fun setColorListRandom(){
        _colorList.value = defaultList.shuffled()
    }


    companion object {
        @JvmField
        val defaultList = listOf("#B71C1C",
                                 "#880E4F",
                                 "#4A148C",
                                 "#311B92",
                                 "#1A237E",
                                 "#0D47A1",
                                 "#01579B",
                                 "#006064",
                                 "#004D40",
                                 "#1B5E20",
                                 "#33691E",
                                 "#827717",
                                 "#F57F17",
                                 "#FF6F00",
                                 "#E65100",
                                 "#BF360C",
                                 "#BF360C",
                                 "#212121",
                                 "#263238")
    }
}