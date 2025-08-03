# SDK Generation Guide

## Overview

This guide explains how to use the Expedia Group Java SDK Foundations to generate custom SDKs from OpenAPI specifications.

## 🎯 Who This Guide Is For

- **API Providers** who want to generate Java/Kotlin SDKs for their APIs
- **Platform Teams** building internal SDKs
- **Developers** extending existing SDKs with custom functionality

## 🏗️ SDK Generation Architecture

### Core Components

1. **OpenAPI Generator**: Extended OpenAPI code generator with custom templates
2. **Mustache Templates**: Customizable templates for code generation
3. **Core Libraries**: Shared utilities and base classes
4. **Build System**: Maven-based build and publishing pipeline

### Generated SDK Structure

```
generated-sdk/
├── src/main/kotlin/
│   ├── client/              # SDK client classes
│   │   └── MyApiClient.kt   # Main client implementation
│   ├── models/              # Data models
│   │   ├── Request*.kt      # Request objects
│   │   ├── Response*.kt     # Response objects
│   │   └── *.kt            # Domain models
│   └── operations/          # Operation definitions
│       ├── *Operation.kt    # Operation classes
│       ├── *OperationParams.kt  # Parameter classes
│       └── *OperationContext.kt # Context classes
├── docs/                    # Generated documentation
└── pom.xml                 # Maven configuration
```

## 🚀 Getting Started

### Prerequisites

1. **OpenAPI Specification** (3.0+) for your API
2. **Java 8+** development environment
3. **Maven 3.8+** build tool

### Step 1: Prepare Your OpenAPI Spec

Ensure your OpenAPI specification follows best practices:

```yaml
openapi: 3.0.3
info:
  title: My API
  version: 1.0.0
  description: Custom API for demonstration
servers:
  - url: https://api.example.com/v1
    description: Production server
  - url: https://test-api.example.com/v1
    description: Test server

paths:
  /hotels/search:
    post:
      operationId: searchHotels
      summary: Search for hotels
      parameters:
        - name: X-Customer-IP
          in: header
          required: true
          schema:
            type: string
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/SearchRequest'
      responses:
        '200':
          description: Search results
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/SearchResponse'

components:
  schemas:
    SearchRequest:
      type: object
      required:
        - destination
        - checkin
        - checkout
      properties:
        destination:
          type: string
          description: Destination city or property ID
        checkin:
          type: string
          format: date
          description: Check-in date (YYYY-MM-DD)
        checkout:
          type: string
          format: date
          description: Check-out date (YYYY-MM-DD)
        guests:
          type: integer
          minimum: 1
          maximum: 8
          default: 2
          description: Number of guests
    
    SearchResponse:
      type: object
      properties:
        hotels:
          type: array
          items:
            $ref: '#/components/schemas/Hotel'
        totalResults:
          type: integer
    
    Hotel:
      type: object
      properties:
        id:
          type: string
          description: Unique hotel identifier
        name:
          type: string
          description: Hotel name
        location:
          $ref: '#/components/schemas/Location'
        pricePerNight:
          $ref: '#/components/schemas/Price'
    
    Location:
      type: object
      properties:
        city:
          type: string
        country:
          type: string
        coordinates:
          $ref: '#/components/schemas/Coordinates'
    
    Coordinates:
      type: object
      properties:
        latitude:
          type: number
          format: double
        longitude:
          type: number
          format: double
    
    Price:
      type: object
      properties:
        amount:
          type: number
          format: double
        currency:
          type: string
          pattern: '^[A-Z]{3}$'

  securitySchemes:
    ApiKeyAuth:
      type: apiKey
      in: header
      name: X-API-Key
    
security:
  - ApiKeyAuth: []
```

### Step 2: Configure the Generator

1. **Clone the repository**:
   ```bash
   git clone https://github.com/ExpediaGroup/expediagroup-java-sdk.git
   cd expediagroup-java-sdk
   ```

2. **Place your OpenAPI spec**:
   ```bash
   cp your-api-spec.yaml generator/openapi/src/main/resources/specs/
   ```

3. **Configure generation parameters**:
   
   Edit `generator/openapi/pom.xml` to customize generation:
   
   ```xml
   <plugin>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-maven-plugin</artifactId>
       <configuration>
           <arguments>
               <!-- Input specification -->
               <argument>--input-spec=src/main/resources/specs/your-api-spec.yaml</argument>
               
               <!-- Output directory -->
               <argument>--output=target/sdk</argument>
               
               <!-- SDK details -->
               <argument>--package-name=com.example.sdk.myapi</argument>
               <argument>--client-name=MyApiClient</argument>
               <argument>--sdk-version=1.0.0</argument>
               
               <!-- API configuration -->
               <argument>--base-url=https://api.example.com/v1</argument>
               <argument>--auth-type=API_KEY</argument>
           </arguments>
       </configuration>
   </plugin>
   ```

### Step 3: Generate the SDK

```bash
# Build the generator
cd generator/openapi
mvn clean install

# Generate your SDK
../../mvnw exec:java

# Build the generated SDK
cd target/sdk
../../../mvnw clean install
```

### Step 4: Test the Generated SDK

The generator creates a basic test structure:

```kotlin
// Generated client usage
val client = MyApiClient.builder()
    .key("your-api-key")
    .endpoint("https://test-api.example.com/v1")
    .build()

// Search for hotels
val searchRequest = SearchRequest.builder()
    .destination("New York")
    .checkin("2024-12-01")
    .checkout("2024-12-03")
    .guests(2)
    .build()

val searchParams = SearchHotelsOperationParams.builder()
    .customerIp("192.168.1.1")
    .build()

val operation = SearchHotelsOperation(searchParams, searchRequest)
val response = client.execute(operation)

response.data.hotels?.forEach { hotel ->
    println("Hotel: ${hotel.name} - ${hotel.pricePerNight?.amount} ${hotel.pricePerNight?.currency}")
}
```

## 🎨 Customization

### Custom Templates

The generator uses Mustache templates located in `generator/openapi/src/main/resources/templates/`:

```
templates/
├── client.mustache           # Main client class
├── model.mustache           # Data model classes
├── operation.mustache       # Operation classes
├── operationParams.mustache # Parameter classes
├── pom.mustache            # Maven POM file
└── README.mustache         # SDK documentation
```

#### Customizing the Client Template

Edit `templates/client.mustache`:

```mustache
package {{package}}.client

import {{package}}.models.*
import {{package}}.operations.*
import com.expediagroup.sdk.core.client.BaseExpediaGroupClient
import com.expediagroup.sdk.core.configuration.ExpediaGroupClientConfiguration

/**
 * {{appName}} SDK Client
 * {{appDescription}}
 * 
 * Generated on: {{generatedDate}}
 * Version: {{sdkVersion}}
 */
class {{classname}} private constructor(
    clientConfiguration: ExpediaGroupClientConfiguration
) : BaseExpediaGroupClient("{{packageName}}", clientConfiguration) {

    class Builder : BaseExpediaGroupClient.Builder<Builder>() {
        override fun build() = {{classname}}(
            ExpediaGroupClientConfiguration(
                key, secret, endpoint, requestTimeout, 
                connectionTimeout, socketTimeout, 
                maskedLoggingHeaders, maskedLoggingBodyFields
            )
        )
    }

    companion object {
        @JvmStatic fun builder() = Builder()
    }

    {{#operations}}
    {{#operation}}
    /**
     * {{summary}}
     * {{notes}}
     {{#allParams}}
     * @param {{paramName}} {{description}}
     {{/allParams}}
     * @throws ExpediaGroupApiErrorException
     * @return {{#returnType}}{{returnType}}{{/returnType}}{{^returnType}}EmptyResponse{{/returnType}}
     */
    fun execute(operation: {{classname}}Operation): {{#returnType}}Response<{{returnType}}>{{/returnType}}{{^returnType}}EmptyResponse{{/returnType}} {
        return {{#returnType}}execute<{{operationIdCamelCase}}Request, {{returnType}}>(operation){{/returnType}}{{^returnType}}executeWithEmptyResponse<{{operationIdCamelCase}}Request>(operation){{/returnType}}
    }

    {{/operation}}
    {{/operations}}
}
```

### Custom Model Generation

Edit `templates/model.mustache` for custom model structures:

```mustache
package {{package}}.models

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
{{#imports}}
import {{import}}
{{/imports}}

/**
 * {{description}}
 {{#vars}}
 * @param {{name}} {{description}}
 {{/vars}}
 */
@JsonDeserialize(builder = {{classname}}.Builder::class)
data class {{classname}}(
{{#vars}}
    @get:JsonProperty("{{baseName}}")
    val {{name}}: {{dataType}}{{#hasDefaultValue}} = {{{defaultValue}}}{{/hasDefaultValue}}{{^hasDefaultValue}}{{#isNullable}}? = null{{/isNullable}}{{/hasDefaultValue}}{{#hasMore}},{{/hasMore}}
{{/vars}}
) {
    companion object {
        fun builder() = Builder()
    }

    class Builder {
    {{#vars}}
        @JsonProperty("{{baseName}}")
        private var {{name}}: {{dataType}}{{#isNullable}}?{{/isNullable}} = {{#hasDefaultValue}}{{{defaultValue}}}{{/hasDefaultValue}}{{^hasDefaultValue}}{{#isNullable}}null{{/isNullable}}{{^isNullable}}TODO("Required field"){{/isNullable}}{{/hasDefaultValue}}

        fun {{name}}({{name}}: {{dataType}}{{#isNullable}}?{{/isNullable}}) = apply { this.{{name}} = {{name}} }
    {{/vars}}

        fun build(): {{classname}} {
            return {{classname}}(
            {{#vars}}
                {{name}} = {{name}}{{#hasMore}},{{/hasMore}}
            {{/vars}}
            )
        }
    }
}
```

### Advanced Configuration

#### Custom Authentication

For APIs with custom authentication, modify the generator configuration:

```yaml
# In your generation config
authType: CUSTOM
authTemplate: |
  override fun getAuthenticationStrategy(): AuthenticationStrategy {
      return MyCustomAuthStrategy(configurationProvider)
  }
```

#### Custom Error Handling

Add custom error mapping:

```yaml
errorMapping:
  400: BadRequestException
  401: UnauthorizedException
  403: ForbiddenException
  404: NotFoundException
  500: InternalServerErrorException
```

### Step 5: Publishing Your SDK

#### Configure Maven for Publishing

Update the generated `pom.xml`:

```xml
<groupId>com.example</groupId>
<artifactId>myapi-sdk</artifactId>
<version>1.0.0</version>
<name>My API SDK</name>
<description>SDK for My API</description>
<url>https://github.com/example/myapi-sdk</url>

<licenses>
    <license>
        <name>Apache License, Version 2.0</name>
        <url>https://www.apache.org/licenses/LICENSE-2.0.txt</url>
    </license>
</licenses>

<developers>
    <developer>
        <name>Your Name</name>
        <email>your.email@example.com</email>
        <organization>Your Organization</organization>
    </developer>
</developers>

<scm>
    <connection>scm:git:git@github.com:example/myapi-sdk.git</connection>
    <developerConnection>scm:git:git@github.com:example/myapi-sdk.git</developerConnection>
    <url>https://github.com/example/myapi-sdk</url>
</scm>
```

#### GitHub Actions for CI/CD

Create `.github/workflows/publish.yml`:

```yaml
name: Publish SDK
on:
  release:
    types: [published]

jobs:
  publish:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      
      - name: Set up JDK 8
        uses: actions/setup-java@v3
        with:
          java-version: '8'
          distribution: 'temurin'
          
      - name: Build and publish
        run: |
          mvn clean install
          mvn deploy
        env:
          MAVEN_CENTRAL_USERNAME: ${{ secrets.MAVEN_CENTRAL_USERNAME }}
          MAVEN_CENTRAL_PASSWORD: ${{ secrets.MAVEN_CENTRAL_PASSWORD }}
```

## 🧪 Testing Generated SDKs

### Unit Testing Template

The generator creates a testing framework:

```kotlin
@ExtendWith(MockitoExtension::class)
class MyApiClientTest {
    
    @Mock
    private lateinit var httpClient: HttpClient
    
    private lateinit var client: MyApiClient
    
    @BeforeEach
    fun setup() {
        client = MyApiClient.builder()
            .key("test-key")
            .secret("test-secret")
            .endpoint("https://test-api.example.com/v1")
            .build()
    }
    
    @Test
    fun `searchHotels should return valid response`() {
        // Given
        val searchRequest = SearchRequest.builder()
            .destination("New York")
            .checkin("2024-12-01")
            .checkout("2024-12-03")
            .build()
        
        val expectedResponse = SearchResponse.builder()
            .hotels(listOf(
                Hotel.builder()
                    .id("hotel-123")
                    .name("Test Hotel")
                    .build()
            ))
            .totalResults(1)
            .build()
        
        // When
        val operation = SearchHotelsOperation(
            SearchHotelsOperationParams.builder()
                .customerIp("192.168.1.1")
                .build(),
            searchRequest
        )
        
        val response = client.execute(operation)
        
        // Then
        assertThat(response.data.hotels).hasSize(1)
        assertThat(response.data.hotels?.first()?.name).isEqualTo("Test Hotel")
    }
}
```

### Integration Testing

```kotlin
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MyApiClientIntegrationTest {
    
    private lateinit var client: MyApiClient
    
    @BeforeAll
    fun setup() {
        client = MyApiClient.builder()
            .key(System.getenv("TEST_API_KEY"))
            .secret(System.getenv("TEST_API_SECRET"))
            .endpoint("https://test-api.example.com/v1")
            .build()
    }
    
    @Test
    fun `should perform real API call`() {
        val searchRequest = SearchRequest.builder()
            .destination("New York")
            .checkin("2024-12-01")
            .checkout("2024-12-03")
            .guests(2)
            .build()
        
        val operation = SearchHotelsOperation(
            SearchHotelsOperationParams.builder()
                .customerIp("192.168.1.1")
                .build(),
            searchRequest
        )
        
        val response = client.execute(operation)
        
        assertThat(response.statusCode).isEqualTo(200)
        assertThat(response.data.hotels).isNotNull()
    }
}
```

## 📚 Best Practices

### 1. OpenAPI Specification Guidelines

- **Use descriptive operation IDs**: These become method names
- **Include comprehensive examples**: Used in documentation generation
- **Define reusable components**: Reduces code duplication
- **Use appropriate HTTP status codes**: Enables proper error handling
- **Add detailed descriptions**: Improves generated documentation

### 2. SDK Design Patterns

- **Builder pattern**: All request objects use builders for flexibility
- **Operation pattern**: Each API call is represented as an operation object
- **Response wrapping**: Responses include metadata (headers, status codes)
- **Type safety**: Strong typing for all parameters and responses
- **Error handling**: Specific exceptions for different error scenarios

### 3. Versioning Strategy

```xml
<!-- Use semantic versioning -->
<version>1.0.0</version>

<!-- For API changes -->
<version>2.0.0</version> <!-- Breaking changes -->
<version>1.1.0</version> <!-- New features -->
<version>1.0.1</version> <!-- Bug fixes -->
```

### 4. Documentation Generation

The generator can create comprehensive documentation:

```bash
# Generate Dokka documentation
mvn dokka:dokka

# Generate OpenAPI documentation
mvn exec:java -Dexec.args="--generate-docs"
```

## 🔧 Troubleshooting

### Common Issues

1. **Generator fails to parse OpenAPI spec**:
   - Validate your spec using [Swagger Editor](https://editor.swagger.io/)
   - Check for circular references in schemas
   - Ensure all `$ref` references are valid

2. **Generated code doesn't compile**:
   - Check for reserved keywords in property names
   - Verify all required dependencies are included
   - Review custom template syntax

3. **Authentication not working**:
   - Verify security scheme definitions in OpenAPI spec
   - Check API key/secret configuration
   - Review endpoint URLs (test vs production)

### Debug Mode

Enable debug logging during generation:

```bash
mvn exec:java -Dexec.args="--verbose --debug"
```

This comprehensive guide provides everything needed to generate custom SDKs using the Expedia Group Java SDK Foundations.
