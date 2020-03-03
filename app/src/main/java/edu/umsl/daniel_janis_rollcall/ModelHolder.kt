package edu.umsl.daniel_janis_rollcall
import java.lang.ref.WeakReference
import kotlin.reflect.KClass

// Private so that nobody can acccess ModelHolder
class ModelHolder private constructor() {

    private val modelClasses = HashMap<String, WeakReference<Any?>>()

    companion object {
        @JvmStatic
        var instance = ModelHolder()
    }

    @Suppress("UNCHECKED_CAST")
    fun <T: Any>get(classType: KClass<T>): T? {
        val modelClass = modelClasses[classType.java.toString()]
        return modelClass?.get() as? T
    }

    fun <T: Any>set(classInstance: T?) {
        modelClasses[classInstance?.javaClass.toString()] = WeakReference(classInstance as? Any)
    }
}