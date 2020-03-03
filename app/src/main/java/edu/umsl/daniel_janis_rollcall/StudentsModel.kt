package edu.umsl.daniel_janis_rollcall

class StudentsModel {
    var names: ArrayList<Names>? = null
    private set

    fun populate1() {
        names = arrayListOf(
            Names(name = "4011", present = false, absent = false, late = false, unknown = false, here = 0),
            Names(name = "2", present = false, absent = false, late = false, unknown = false, here = 0),
            Names(name = "3", present = false, absent = false, late = false, unknown = false, here = 0),
            Names(name = "4", present = false, absent = false, late = false, unknown = false, here = 0),
            Names(name = "5", present = false, absent = false, late = false, unknown = false, here = 0),
            Names(name = "6", present = false, absent = false, late = false, unknown = false, here = 0),
            Names(name = "7", present = false, absent = false, late = false, unknown = false, here = 0),
            Names(name = "8", present = false, absent = false, late = false, unknown = false, here = 0)
        )
    }

    fun populate2() {
        names = arrayListOf(
            Names(name = "4020", present = false, absent = false, late = false, unknown = false, here = 0),
            Names(name = "2", present = false, absent = false, late = false, unknown = false, here = 0),
            Names(name = "3", present = false, absent = false, late = false, unknown = false, here = 0),
            Names(name = "4", present = false, absent = false, late = false, unknown = false, here = 0),
            Names(name = "5", present = false, absent = false, late = false, unknown = false, here = 0)
        )
    }

    fun populate3() {
        names = arrayListOf(
            Names(name = "4280", present = false, absent = false, late = false, unknown = false, here = 0),
            Names(name = "2", present = false, absent = false, late = false, unknown = false, here = 0),
            Names(name = "3", present = false, absent = false, late = false, unknown = false, here = 0),
            Names(name = "4", present = false, absent = false, late = false, unknown = false, here = 0),
            Names(name = "5", present = false, absent = false, late = false, unknown = false, here = 0),
            Names(name = "6", present = false, absent = false, late = false, unknown = false, here = 0)
        )
    }

    fun populate4() {
        names = arrayListOf(
            Names(name = "4300", present = false, absent = false, late = false, unknown = false, here = 0),
            Names(name = "2", present = false, absent = false, late = false, unknown = false, here = 0),
            Names(name = "3", present = false, absent = false, late = false, unknown = false, here = 0),
            Names(name = "4", present = false, absent = false, late = false, unknown = false, here = 0),
            Names(name = "5", present = false, absent = false, late = false, unknown = false, here = 0),
            Names(name = "6", present = false, absent = false, late = false, unknown = false, here = 0),
            Names(name = "7", present = false, absent = false, late = false, unknown = false, here = 0)
        )
    }
}
