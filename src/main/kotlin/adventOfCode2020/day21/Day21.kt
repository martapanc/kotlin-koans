package adventOfCode2020.day21

import java.io.File

fun readInputToMap(path: String): Day21Input {
    val lineList = mutableListOf<String>()
    File(path).inputStream().bufferedReader().forEachLine { lineList.add(it) }

    val recipesWithAllergens = mutableMapOf<String, MutableSet<Int>>()
    val canContain = mutableMapOf<String, MutableSet<String>>()
    val recipes = mutableListOf<Pair<List<String>, List<String>>>()
    for ((i, line) in lineList.withIndex()) {
        val split = line.replace(")", "").split("(contains")
        val ingredients = split[0].trim().split(" ")
        val allergens = split[1].trim().split(", ")
        recipes.add(Pair(ingredients, allergens))
        for (all in allergens) {
            for (ing in ingredients)
                canContain.getOrPut(ing, ::mutableSetOf) += all
            recipesWithAllergens.getOrPut(all, ::mutableSetOf) += i
        }
    }
    return Day21Input(recipesWithAllergens, canContain, recipes)
}

fun compute(input: Day21Input): Int {
    val recipesWithAllergens = input.recipesWithAllergens
    val canContain = input.canContain.toMutableMap()
    val recipes = input.recipes

    for ((ingredients, allergens) in recipes)
        for (ingredient in ingredients)
            for (allergen in allergens)
                if ((canContain[ingredient] ?: error("")).contains(allergen)) {
                    for (recipeId in recipesWithAllergens[allergen] ?: error("")) {
                        if (!recipes[recipeId].first.contains(ingredient)) {
                            canContain[ingredient]!!.remove(allergen)
                            break
                        }
                    }
                }

    var count = 0
    canContain.entries
        .filter { it.value.size == 0 }
        .forEach { entry ->
            repeat(recipes.filter {
                it.first.contains(entry.key)
            }.size) { count++ }
        }
    return count
}

data class Day21Input(
    var recipesWithAllergens: Map<String, MutableSet<Int>>,
    var canContain: Map<String, MutableSet<String>>,
    var recipes: List<Pair<List<String>, List<String>>>
)