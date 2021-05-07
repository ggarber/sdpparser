plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.31"

    `java-library`
    `maven-publish`
}

version = "0.1.0"

repositories {
    mavenCentral()
    google()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

tasks.jar {
    manifest {
        attributes(mapOf(
            "Implementation-Title" to project.name,
            "Implementation-Version" to project.version
        ))
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.ggarber"
            artifactId = project.name
            version = "0.1"

            from(components["java"])
        }
    }
}