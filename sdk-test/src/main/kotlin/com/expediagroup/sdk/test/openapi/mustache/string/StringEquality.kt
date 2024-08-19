package com.expediagroup.sdk.test.openapi.mustache.string

import com.samskivert.mustache.Mustache

class StringEqualityStore {
    companion object {
        var first: String = ""
        var second: String = ""
    }
}

val firstStringCompare =
    Mustache.Lambda { fragment, writer ->
        StringEqualityStore.first = fragment.context().toString()
    }

val secondStringCompare =
    Mustache.Lambda { fragment, writer ->
        StringEqualityStore.second = fragment.context().toString()
    }

val stringsEqual =
    Mustache.Lambda { fragment, writer ->
        if (StringEqualityStore.first == StringEqualityStore.second) {
            fragment.execute(writer)
        }
    }
