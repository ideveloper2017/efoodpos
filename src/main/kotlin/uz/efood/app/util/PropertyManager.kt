package uz.efood.app.util

import java.io.IOException
import java.util.*


class PropertyManager private constructor() {
    private var properties: Properties? = null

    init {
        loadProperties(RESTAURANT_CONFIG)
    }

    private fun loadProperties(filename: String) {
        val loader = javaClass.classLoader
        val `in` = loader.getResourceAsStream(filename)
        if (`in` == null) {
            println("Could not open config file $filename")
            return
        }
        properties = Properties()
        try {
            properties!!.load(`in`)
        } catch (e: IOException) {
            println("Exception reading config file $filename")
            println(e.message)
        } finally {
            try {
                `in`.close()
            } catch (ex2: IOException) {
            }
        }
    }

    /**
     * Get the value of a property read from the config file.
     *
     * @param propName
     * @return the value of the property or empty string if not found
     */
    fun getProperty(propName: String?): String {
        return properties!!.getProperty(propName, "")
    }

    /**
     * Get all the properties
     */
    fun getProperties(): Properties? {
        return this.properties
    }

    companion object {
        const val RESTAURANT_CONFIG: String = "restaurant.config"
        private var pm: PropertyManager? = null
        val instance: PropertyManager?
            /**
             * Get a singleton instance of this class
             *
             * @return the property manager object
             */
            get() {
                if (pm == null) pm = PropertyManager()
                return pm
            }
    }
}
