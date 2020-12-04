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

//byr (Birth Year)
//iyr (Issue Year)
//eyr (Expiration Year)
//hgt (Height)
//hcl (Hair Color)
//ecl (Eye Color)
//pid (Passport ID)
//cid (Country ID)

fun isPassportDataValid(passportData: String): Boolean {
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

fun countValidPassports(dataList: List<String>): Int {
    var count = 0
    for (passportData in dataList) {
        if (isPassportDataValid(passportData)) {
            count++
        }
    }
    return count
}