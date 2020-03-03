package edu.umsl.daniel_janis_rollcall

// Read only
data class Names(val name: String, var present: Boolean, var absent: Boolean, var late: Boolean, var unknown: Boolean, var here: Int)