# OpenCV 3.3.1 (re-packaged by FRC Team1294)

OpenCV Java bindings packaged with native libraries.

## Usage

### Add the dependency to your project

#### Gradle

1. add the frc1294 maven repository 
```groovy
repositories {
  maven {
    uri('https://todo')
  }
}
```

2. add the opencv dependency
```groovy
dependencies {
  compile group: 'org.usfirst.frc.team1294', name: 'opencv', version: '3.3.1-SNAPSHOT'
}
```

#### Maven
_todo_

#### Eclipse (without gradle or maven)
_todo_

### Load native libraries es early as possible in your code
```java
public class Application {
  
  public static void main(String[] args) {
    org.usfirst.frc.team1294.opencv.OpenCV.loadNativeLibraries();
  }
  
}
```

## Support

The following platforms are supported by this package:

OS | Architecture
--- | ---
OS X | x86_32
OS X | x86_64
Linux | x86_64
Linux | x86_32
Windows | x86_32
Windows | x86_64