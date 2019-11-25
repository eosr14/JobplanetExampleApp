package com.eosr14.jobplanetexampleapp.model

import com.google.gson.*
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class ModelDeserializer : JsonDeserializer<Search.Items> {

    private val itemTypes: MutableMap<String, ItemType.Type> = mutableMapOf()
    private val gson: Gson get() = Gson()

    init {
        initItemType()
    }

    private fun initItemType() {
        for (item in ItemType.Type.values()) {
            itemTypes[item.name] = item
        }
    }

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Search.Items {
        return json?.asJsonObject?.let { jsonObject ->
            gson.fromJson(json, Search.Items::class.java).apply {
                if (checkJsonObject(jsonObject, KEY_CELL_TYPE)) {
                    jsonObject.get(KEY_CELL_TYPE).asString?.let { cellType ->
                        itemTypes[cellType]?.let { type ->
                            this.itemType = type


                            // HorizontalTheme List
//                            if (checkJsonObject(jsonObject, KEY_THEMES)) {
//                                jsonObject.getAsJsonArray(KEY_THEMES)?.let { jsonArray ->
//                                    gson.fromJson<List<Search.Theme>>(
//                                        jsonArray.toString(),
//                                        object : TypeToken<List<Search.Theme>>() {}.type
//                                    ).let {
//                                        this.childList = it
//                                    }
//                                }
//                            }
                        }
                    }
                }
            } as Search.Items
        } ?: Search.Items()
    }

    private fun checkJsonObject(jsonObject: JsonObject, key: String) =
        jsonObject.has(key) && !jsonObject.get(key).isJsonNull

    companion object {
        private const val KEY_CELL_TYPE = "cell_type"
        private const val KEY_THEMES = "themes"
    }


}