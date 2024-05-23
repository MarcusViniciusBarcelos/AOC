package com.example.mobile;

import androidx.lifecycle.ViewModel;

class MainViewModel : ViewModel() {
    private val list = mutableListOf(
        Product(
            urlImage = "https://t4.ftcdn.net/jpg/06/93/09/47/240_F_693094707_Eavnydwp6Su2Tx9REPzSZxDmEbElu0Az.jpg",
            name = "Laranja",
            price = "199.00"
        ),
        Product(
            urlImage = "https://t4.ftcdn.net/jpg/04/13/50/15/240_F_413501576_JBNFcI7nQ34BYAu7FXJTWLZQ8Y7ptSz3.jpg",
            name = "Creme",
            price = "129.00"
        ),
        Product(
            urlImage = "https://t3.ftcdn.net/jpg/04/91/00/82/240_F_491008206_6J87meZRmjPYlrTpBEeVzFSm1m3kqOd2.jpg",
            name = "Blazer",
            price = "17.90"
        ),
        Product(
            urlImage = "https://t3.ftcdn.net/jpg/04/91/00/82/240_F_491008206_6J87meZRmjPYlrTpBEeVzFSm1m3kqOd2.jpg",
            name = "Ghost",
            price = "17.90"
        ),
        Product(
            urlImage = "https://t3.ftcdn.net/jpg/04/91/00/82/240_F_491008206_6J87meZRmjPYlrTpBEeVzFSm1m3kqOd2.jpg",
            name = "Tapiba",
            price = "17.90"
        )
    )
    fun getProducts() = list


    fun removeItem(index: Int) {
        list.removeAt(index)
    }
}


