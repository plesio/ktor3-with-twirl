
plugins {
    scala
    war
    //
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.gretty)
    alias(libs.plugins.twirl)
}

group = "saurus.plesio"
version = "0.0.1"

application {
  mainClass.set("saurus.plesio.ApplicationKt")

  val isDevelopment: Boolean = project.ext.has("development")
  applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
  mavenCentral()
  maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
}

gretty {
  servletContainer = "tomcat10"
  contextPath = "/"
  logbackConfigFile = "src/main/resources/logback.xml"
}

dependencies {
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.tomcat.jakarta)
    implementation(libs.logback.classic)

  // Tomcat  
  implementation(libs.ktor.server.tomcat.jakarta)
  implementation(libs.ktor.server.servlet.jakarta)
  //compileOnly(libs.jakarta.servlet.api)

    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)
    
  // Scala Codes
  implementation(libs.twirl.api)
  implementation(libs.scala3.library)
  implementation(libs.commons.collections)
}

sourceSets {
  main {
    twirl {
      srcDir("src/main/twirl")
      sourceEncoding.set("UTF-8")
    }
    scala {
      setSrcDirs(listOf("src/main/scala", "build/generated/sources/twirl/main"))
    }
    kotlin {
      compileClasspath += files(tasks.compileScala.get().destinationDir)
    }
  }
}

// Scala Compile Options
twirl {
  scalaVersion.set("3")
}

tasks {
  processResources {
    //duplicatesStrategy = DuplicatesStrategy.INCLUDE
  }
  assemble {
    dependsOn("compileTwirl")
  }
  compileScala {
    dependsOn("compileTwirl")
    options.encoding = "UTF-8"
    scalaCompileOptions.isForce = true
  }
  compileKotlin {
    compilerOptions {
      freeCompilerArgs = listOf("-Xjsr305=strict")
      //jvmTarget.set(JvmTarget.JVM_17)
    }
  }
  compileJava {
    options.encoding = "UTF-8"
  }
  jar {
    enabled = false
  }
  war {
    //
  }
}

afterEvaluate {
  tasks.getByName("run") {
    dependsOn("appRunWar")
  }
}
