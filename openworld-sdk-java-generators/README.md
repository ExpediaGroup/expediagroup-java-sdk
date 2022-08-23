# Open World <sup>TM</sup> SDK for Java - Generators
The generators component for the Open World<sup>TM</sup> SDK for Java.

## Generating SDKs

1. Build the tooling and generator:
    ```
    ./mvnw clean install
    ```
2. Generate the Sample SDK
    ```
   cd openapi
    ../../mvnw exec:java
    ```
3. Build the Sample SDK
    ```
    cd target/sdk
    ../../../mvnw clean install
    ```

4. (Optional) Generate SDK Documentations
   ```
   ../../../mvnw dokka:dokka
   ```

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## License
This project is licensed under the Apache License - see the [LICENSE](LICENSE) file for details.
