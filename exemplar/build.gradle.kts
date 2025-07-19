plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "2.1.10"
    id("org.jlleitschuh.gradle.ktlint") version "12.1.2"
}

group = "com.expediagroup"

allprojects {
    repositories {
        mavenCentral()
        mavenLocal()
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
        }
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")

    ktlint {
        debug.set(true)
        version.set("1.5.0")
        verbose.set(true)

        additionalEditorconfig.set(
            mapOf(
                "indent_style" to "space",
                "indent_size" to "4",
                "insert_final_newline" to "true",
                "end_of_line" to "lf",
            ),
        )
    }
}
