package com.eosr14.jobplanetexampleapp.common

import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

fun <T : Any> construct(kClass: KClass<T>, vararg args : Any?): T? {
    return kClass.primaryConstructor?.call(args)
}
