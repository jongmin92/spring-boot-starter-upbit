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
    val systemProperty = System.getenv(name) ?: System.getProperty(name)
    return try {
        systemProperty ?: this.property(name)?.toString()
    } catch (e: Exception) {
        null
    }
}
