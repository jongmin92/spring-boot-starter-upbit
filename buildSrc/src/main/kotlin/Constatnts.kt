object OSS {
    object Pom {
        const val name = "Spring Boot Upbit Client Starter"
        const val description = "Spring Boot Upbit Client Starter"
        const val url = "https://github.com/jongmin92/spring-boot-starter-upbit/blob/master/README.md"

        const val licenseName = "MIT License"
        const val licenseUrl = "http://www.opensource.org/licenses/mit-license.php"

        val developers = listOf(
            developer("jongmin92", "JongMin Kim", "imd92@naver.com"),
            developer("evan-hwang", "HyuckJin Hwang", "id920809@naver.com"),
            developer("xyom", "SuHwan Yun", "xyom19@gmail.com")
        )

        const val scmConnection = "scm:git:git://jongmin92/spring-boot-starter-upbit.git"
        const val scmDeveloperConnection = "scm:git:ssh://jongmin92/spring-boot-starter-upbit.git"
        const val scmUrl = "https://github.com/jongmin92/spring-boot-starter-upbit.git"
    }

    object Repository {
        const val releaseRepoUrl = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
        const val snapshotRepoUrl = "https://s01.oss.sonatype.org/content/repositories/snapshots/"
    }

    fun developer(id: String, name: String, email: String) = mapOf(
        "id" to id,
        "name" to name,
        "email" to email
    )
}
