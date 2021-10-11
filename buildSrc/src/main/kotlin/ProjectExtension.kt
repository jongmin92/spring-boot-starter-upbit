import org.gradle.api.Project

fun Project.resolvedModuleName(): String {
    var self = this
    var name = self.name

    while (self.parent != this.rootProject) {
        self = self.parent!!
        name = "${self.name}-${name}"
    }

    return "${rootProject.name}-${name}"
}

fun Project.getProperty(name: String): String? {
    return try {
        val systemProperty = System.getenv(name) ?: System.getProperty(name)
        println("getProperty(${name}) => ${systemProperty ?: this.property(name)?.toString()}")
        return systemProperty ?: this.property(name)?.toString()
    } catch (e: Exception) {
        null
    }
}
