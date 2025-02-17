# Development Guide

## Development Requirements

- Java 11 (for development/compilation)
- Gradle
- Git

Note: The generated SDKs require Java 8+ for runtime usage.

## Quick Start

### 1. Clone the Repository

```bash
git clone https://github.com/ExpediaGroup/lodging-connectivity-java-sdk.git
cd lodging-connectivity-java-sdk
```

### 2. Initialize GraphQL Module

```bash
./scripts/graphql/init.sh
```

This script pulls the required GraphQL schema from the dependent repository.

### 3. Build the Project

Full build with local Maven publication:

```bash
./gradlew clean generateApolloSources build publishToMavenLocal
```

Alternatively, for local development you can use:

```bash
./gradlew clean build
```

## Project Structure

```
lodging-connectivity-java-sdk/
├── code/src/main/
│   ├── graphql/         # GraphQL schema and queries (Sub module)
│   └── kotlin/          # Kotlin source code of the SDK
├── examples/
│   └── src/main/java/   # Example usage of the SDK in Java
├── docs/                # Documentation files
├── scripts/
│   └── graphql/         # GraphQL setup scripts
├── apollo-compiler-plugin/
│   └── src/main/        # Apollo compiler plugin source code
├── build.gradle         # Gradle build configuration
├── gradle.properties    # Gradle properties
├── settings.gradle      # Gradle settings
└── ...
```

## Common Issues

### 1. Gradle Cannot Detect JDK

If Gradle fails to detect your JDK installation, try either:

**Option 1**: Add this line to the root `gradle.properties`:

```properties
org.gradle.java.installations.fromEnv=true
```

**Option 2**: Set JAVA_HOME explicitly:

```bash
export JAVA_HOME=$(/usr/libexec/java_home -v 11)
```

### 2. Build Failures

- Ensure Java 11 is installed and configured as your development JDK
- Check your Java version: `java -version`
- Make sure you've run the GraphQL module initialization script
- Run with `--stacktrace` flag for detailed error information:
  ```bash
  ./gradlew build --stacktrace
  ```

## Questions or Issues?

Create an issue in the GitHub repository with details about your problem.
