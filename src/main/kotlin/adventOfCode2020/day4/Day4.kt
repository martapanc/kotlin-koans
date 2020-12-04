package adventOfCode2020.day4

import java.io.File
import java.io.InputStream

fun readInputFile(path: String): List<String> {
    val inputStream: InputStream = File(path).inputStream()
    val lineList = mutableListOf<String>()

    inputStream.bufferedReader().forEachLine { lineList.add(it) }

    val passportDataList = mutableListOf<String>()
    var passportData = ""
    for (line in lineList) {
        if (line.isNotEmpty()) {
            passportData += if (passportData.isBlank()) {
                line
            } else {
                " $line"
            }
        } else {
            passportDataList.add(passportData)
            passportData = ""
        }
    }

    return passportDataList;
}

fun arePassportKeysValid(passportData: String): Boolean {
    if (!passportData.contains("byr")) {
        return false
    }
    if (!passportData.contains("iyr")) {
        return false
    }
    if (!passportData.contains("eyr")) {
        return false
    }
    if (!passportData.contains("hgt")) {
        return false
    }
    if (!passportData.contains("hcl")) {
        return false
    }
    if (!passportData.contains("ecl")) {
        return false
    }
    if (!passportData.contains("pid")) {
        return false
    }
    return true
}

//byr (Birth Year) - four digits; at least 1920 and at most 2002.
//iyr (Issue Year) - four digits; at least 2010 and at most 2020.
//eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
//hgt (Height) - a number followed by either cm or in:
//If cm, the number must be at least 150 and at most 193.
//If in, the number must be at least 59 and at most 76.
//hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
//ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
//pid (Passport ID) - a nine-digit number, including leading zeroes.
//cid (Country ID) - ignored, missing or not.

fun isPassportDataValid(passportData: String): Boolean {
    if (!arePassportKeysValid(passportData)) {
        return false
    }
    val dataMap = mutableMapOf<String, String>()
    passportData.split(" ")
        .asSequence()
        .map { it.split(":") }
        .forEach { dataMap[it[0]] = it[1] }

    val birthYear: Int? = dataMap["byr"]?.toIntOrNull()
    if (birthYear == null || birthYear < 1920 || birthYear > 2002) {
        return false
    }

    val issueYear: Int? = dataMap["iyr"]?.toIntOrNull()
    if (issueYear == null || issueYear < 2010 || issueYear > 2020) {
        return false
    }

    val expYear: Int? = dataMap["eyr"]?.toIntOrNull()
    if (expYear == null || expYear < 2020 || expYear > 2030) {
        return false
    }

    val height: String = dataMap["hgt"] ?: return false
    if (height.endsWith("in")) {
        val heightVal = height.replace("in", "").toInt()
        if (heightVal < 59 || heightVal > 76) {
            return false
        }
    } else if (height.endsWith("cm")) {
        val heightVal = height.replace("cm", "").toInt()
        if (heightVal < 150 || heightVal > 193) {
            return false
        }
    } else {
        return false
    }

    val hair: String? = dataMap["hcl"]
    if (hair == null || !hair.matches(Regex("""#[0-9a-fA-F]{6}"""))) {
        return false
    }

    val eyes: String? = dataMap["ecl"]
    if (eyes == null || !eyes.matches(Regex("""amb|blu|brn|gry|grn|hzl|oth"""))) {
        return false
    }

    val pid: String? = dataMap["pid"]
    if (pid == null || !pid.matches(Regex("""[0-9]{9}"""))) {
        return false
    }

    return true
}

fun countValidPassports(dataList: List<String>, validationMethod: (String) -> Boolean): Int {
    return dataList.count { validationMethod(it) }
}