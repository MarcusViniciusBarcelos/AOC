package com.example.mobile

fun String.convertToMoneyWithSymbol() = "R$ ".plus(this.replace(".", ","))