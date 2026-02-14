package com.divinelink.core.commons.util

import kotlinx.serialization.json.Json

inline fun <reified T> T.encodeToString() = Json.encodeToString<T>(this)
inline fun <reified T> String.decodeFromString() = Json.decodeFromString<T>(this)
