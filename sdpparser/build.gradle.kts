plugins {
    kotlin("multiplatform") version "1.5.0"

    `maven-publish`
    signing
}

group = "io.github.ggarber"
version = "0.1.0"

repositories {
    mavenCentral()
    google()
}

kotlin {
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-protobuf:1.2.0")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
            }
        }
    }
}


//publishing {
//    publications {
//        create<MavenPublication>("maven") {
//            groupId = "com.ggarber"
//            artifactId = project.name
//            version = version
//
//            from(components["java"])
//
//            pom {
//                licenses {
//                    license {
//                        name.set("The Apache License, Version 2.0")
//                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
//                    }
//                }
//
//                scm {
//                    connection.set("scm:git:git@github.com:ggarber/sdpparser.git")
//                    developerConnection.set("scm:git:git@github.com:ggarber/sdpparser.git")
//                    url.set("https://github.com/ggarber/sdpparser")
//                }
//            }
//        }
//    }
//}
//
//signing {
//    sign(publishing.publications["maven"])
//}