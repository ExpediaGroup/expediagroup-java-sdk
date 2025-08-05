# Expedia Group Java SDK Repository Documentation

## Overview

This repository serves as the **foundational infrastructure** for generating, building, and releasing Java SDKs for Expedia Group's APIs. It provides a comprehensive toolkit that enables product teams to automatically generate fully-functional Java SDKs from OpenAPI specifications while maintaining consistency, quality, and best practices across all generated SDKs.

**Key Value Proposition**: This repository acts as a "SDK-as-a-Service" platform, eliminating the need for product teams to build and maintain their own SDK generation infrastructure.

## Repository Purpose & Usage

This repository is **not** a standalone SDK but rather a **service repository** that other product repositories consume through GitHub Actions workflows. Product teams use this repository to:

1. **Generate SDK source code** from OpenAPI specifications
2. **Publish generated code** to their product repositories  
3. **Release SDKs** to Maven Central
4. **Maintain documentation** and reference materials
5. **Provide consistent SDK patterns** across all Expedia Group APIs

### How It Works: Repository-as-a-Service Model

```mermaid
graph LR
    A[Product Team] --> B[Updates OpenAPI Spec]
    B --> C[Triggers GitHub Action]
    C --> D[Calls expediagroup-java-sdk Workflows]
    D --> E[Generates SDK Code]
    E --> F[Creates Pull Request]
    F --> H[Merges Sources to Codebase for Version Tracking]
    H --> G[Publishes to Maven Central]
```

### Real-World Usage Examples

**[Rapid Java SDK](https://github.com/ExpediaGroup/rapid-java-sdk)** - The flagship example showing complete integration:
- **Repository Size**: ~95% auto-generated content
- **Manual Maintenance**: Only workflow configuration and OpenAPI specs
- **Generated Artifacts**: Complete SDK with 200+ API operations
- **Release Frequency**: On-demand releases to Maven Central via manual workflow triggers

**[XAP Java SDK](https://github.com/ExpediaGroup/xap-java-sdk)** - Enterprise API integration:
- **Use Case**: Enterprise API modernization with SDK wrapper
- **Customizations**: Extended authentication and error handling
- **Integration**: Custom post-processing for enterprise requirements

## Architecture & Components

### 1. Core Module (`/core`)
**Location**: `/core/src/main/kotlin/com/expediagroup/sdk/core/`

The core module provides foundational libraries and utilities shared across all generated SDKs:

- **HTTP Client Infrastructure**: Base HTTP handling, authentication, and request/response processing
- **Configuration Management**: Environment-specific configurations and client settings
- **Error Handling**: Common exception types and error response handling
- **Plugin System**: Extensible architecture for adding SDK-specific functionality
- **Model Contracts**: Base interfaces and contracts for generated models

**Key Components**:
- `client/` - HTTP client implementations and base classes
- `configuration/` - SDK configuration and environment management
- `model/` - Base model classes and interfaces
- `plugin/` - Plugin architecture for extensibility

### 2. Generator Module (`/generator`)
**Location**: `/generator/openapi/`

The generator is responsible for transforming OpenAPI specifications into complete Java SDK projects:

- **OpenAPI Code Generation**: Converts OpenAPI 3.x specifications to Kotlin/Java code
- **Template Processing**: Uses customizable templates to generate consistent SDK structure
- **Post-Processing**: Applies transformations and optimizations to generated code
- **Maven Project Creation**: Generates complete Maven projects with proper dependencies

**Key Features**:
- Based on OpenAPI Generator with custom templates
- Supports Kotlin as primary language (Java 8+ compatible)
- Generates models, client classes, and operation methods
- Includes comprehensive documentation generation

### 3. GitHub Actions Workflows (`/.github/workflows`)

The repository provides **reusable workflows** that product repositories consume via GitHub's workflow call mechanism. These workflows form the backbone of the SDK-as-a-Service offering:

#### Core Self-Service Workflows

**`selfserve-full-workflow.yaml`** - **The Complete Generation Pipeline**
- **Purpose**: End-to-end SDK generation and integration (excluding Maven Central publishing)
- **Typical Usage**: Primary workflow for most product repositories to generate and review code
- **Process Flow**: 
    1. Transform OpenAPI specifications
    2. Generate SDK source code
    3. Build and validate generated SDK
    4. Commit generated code back to product repository as a pull request
- **Key Feature**: Stops before Maven Central publishing to allow team review and validation
- **Execution Time**: ~1-5 minutes depending on API complexity
- **Used By**: Rapid SDK, XAP SDK, FPaaS SDK and other product SDKs
- **Next Step**: Teams review the PR, then manually trigger `selfserve-release-sdk.yaml` for Maven Central publishing

**`selfserve-generate-sdk.yaml`** - **Code Generation Engine**
- **Purpose**: Convert OpenAPI specifications into complete Maven SDK project
- **Key Actions**:
    - Checks out this repository for generator tools and templates
    - Downloads transformed OpenAPI specifications from previous workflow step
    - Executes OpenAPI Generator with custom Kotlin/Java templates
    - Applies post-processing (formatting, validation, documentation generation)
    - Builds generated Maven project to verify compilation
    - Uploads complete SDK as GitHub artifact for downstream consumption
- **Input**: SDK name, version, transformed OpenAPI specification
- **Output**: GitHub artifact containing complete Maven project with generated Kotlin/Java code
- **Dependencies**: Requires transformed specifications from `selfserve-transform-specs.yaml`

**`selfserve-publish-sources.yaml`** - **Repository Integration**
- **Purpose**: Integrate generated SDK code into product repositories via pull request
- **Process**:
    - Downloads generated SDK artifact from `selfserve-generate-sdk.yaml`
    - Checks out product repository with write permissions
    - Intelligently replaces generated code while preserving manual customizations
    - Creates feature branch with descriptive name
    - Commits changes with commit message and generation metadata
    - Creates pull request with the changes
- **Review Process**: Generated code requires manual team review, approval, and merge before integration
**`selfserve-release-sdk.yaml`** - **Maven Central Publishing**
- **Purpose**: Release validated SDK to Maven Central and other public repositories
- **Trigger**: Manual execution after team reviews and approves generated code PR
- **Prerequisites**: 
    - Generated SDK code already merged into product repository
    - GPG signing keys configured for artifact security
    - Sonatype Nexus credentials for Maven Central access
    - Proper semantic versioning 
- **Process Flow**: 
    1. **Build**: Compile SDK with release profile, generate javadoc and sources
    2. **Sign**: Cryptographically sign all artifacts with GPG
    3. **Upload**: Deploy to Sonatype staging repository
    4. **Promote**: Automatically promote to Maven Central if validation passes
- **Production Workflow**: Teams execute `selfserve-full-workflow.yaml` → review and merge PR → manually trigger `selfserve-release-sdk.yaml` for public release

**`selfserve-transform-specs.yaml`** - **Specification Processing**
- **Purpose**: Prepare and optimize OpenAPI specifications for SDK generation
- **Tool**: Uses [`spec-transformer`](https://github.com/ExpediaGroup/spec-transformer) for specification manipulation/transformation
- **Key Transformations**:
    - **Header Management**: Add/remove authentication and common headers
    - **Endpoint Filtering**: Include/exclude specific API paths by pattern
    - **Operation ID Processing**: Convert operation IDs to readable method names
- **Multi-file Support**: Merges multiple OpenAPI files using `openapi-merge.json`

#### Supporting Workflows

**Quality Assurance Workflows**
- **`core-verify.yaml`**: Validates core library functionality
- **`generator-verify.yaml`**: Tests SDK generation engine
- **`contribution-lint.yaml`**: Enforces code and commit standards

**Infrastructure Workflows**
- **`generate-ref-docs.yaml`**: Creates API reference documentation
- **`pr-auto-approve.yaml`**: Automates approval for automated PRs

## How Product Teams Use This Repository

This section explains the **practical implementation** of how product teams leverage this infrastructure for their SDK needs.

### 1. Repository Setup & Structure

Product teams create **minimal repositories** that primarily contain configuration rather than code:

```
rapid-java-sdk/                           # Example product repository
├── .github/workflows/                    # Workflow delegation (< 100 lines total)
│   ├── generate-and-publish-sdk-sources.yaml
│   ├── release-sdk.yaml
│   └── verify-examples.yaml
├── specs/                               # OpenAPI specifications
│   ├── rapid-api-spec.yaml              # Main API specification
├── customizations/                      # Optional customizations
├── examples/                            # SDK usage examples
│   └── src/main/kotlin/examples/
├── code/                                # Generated SDK (auto-managed)
│   ├── src/main/kotlin/                 # Generated source code
│   ├── pom.xml                          # Generated Maven configuration
│   └── README.md                        # Generated documentation
└── README.md                            # Product-specific documentation
```

**Key Characteristics**:
- **~90-95% of repository content is auto-generated**
- **Manual files**: Workflow configs, OpenAPI specs, examples, documentation
- **Auto-managed directories**: `code/`, generated documentation

### 2. Workflow Configuration - Delegation Pattern

Product repositories implement **workflow delegation** - minimal configuration that calls powerful workflows from this repository:

**Complete Example: `generate-and-publish-sdk-sources.yaml`**
```yaml
name: Generate and Publish SDK Sources

on:
  workflow_dispatch:                      # Manual trigger for controlled releases
    inputs:
      version:
        description: 'SDK Version (e.g., 1.0.0, 1.0.1, 1.0.0-SNAPSHOT)'
        required: true
        type: string
      sdk_repo_ref:
        description: 'expediagroup-java-sdk branch/tag to use'
        type: string
        default: 'legacy'                 # Production-stable branch (main is used for the new SDK Generator Toolkit - Please don't use it here!)

jobs:
  generate-and-publish-sources:
    # DELEGATION: Call the complete workflow from this repository
    uses: ExpediaGroup/expediagroup-java-sdk/.github/workflows/selfserve-full-workflow.yaml@legacy
    secrets: inherit                      # Pass through all repository secrets
    with:
      name: rapid                         # Product identifier (used in package names, rapid as example)
      version: ${{ inputs.version }}
      transformations: |
        --headers                         # Add authentication headers
        --endpoint /v3                    # Filter to v3 endpoints only  
        --operationIdsToTags             # Convert operation IDs to method names
        --removeUnusedSchemas            # Clean up unused models
      repository: 'ExpediaGroup/rapid-java-sdk'  # Target repository for generated code
      sources_path: 'code'               # Directory for generated SDK code
      sdk_repo_ref: ${{ inputs.sdk_repo_ref }}
```

**Release Workflow Example: `release-sdk.yaml`**
```yaml
name: Release SDK to Maven Central

on:
  workflow_dispatch:
    inputs:
      core-ref:
        description: 'SDK infrastructure version to use'
        type: string
        default: 'legacy'

jobs:
  release-sdk:
    uses: ExpediaGroup/expediagroup-java-sdk/.github/workflows/selfserve-release-sdk.yaml@legacy
    secrets: inherit
    with:
      branch: ${{ inputs.core-ref }}
      sdk_path: 'code'                   # Path to generated SDK code
```

### 3. Detailed Generation Process Flow

Here's the **step-by-step process** that occurs when a product team triggers SDK generation:

#### Phase 1: Specification Transformation
**Workflow**: `selfserve-transform-specs.yaml`

```bash
# What happens behind the scenes:
1. Checkout product repository for OpenAPI specifications
2. If openapi-merge.json exists:
   - Merge multiple spec files into single specification
3. Apply transformations via spec-transformer CLI:
    - --headers: Remove unnecessary headers from operations to clean up SDK generation
    - --endpoint <prefix>: Update operation endpoints with the needed prefix
    - For more details please visit the [`spec-transformer`](https://github.com/ExpediaGroup/spec-transformer) project
4. Upload transformedSpecs.yaml as GitHub artifact
```

#### Phase 2: SDK Code Generation
**Workflow**: `selfserve-generate-sdk.yaml`  

```bash
# Detailed generation process:
1. Download transformed OpenAPI specification
2. Checkout expediagroup-java-sdk repository for generator tools
3. Set up Java 8 environment and Maven dependencies
4. Execute OpenAPI Generator with custom templates:
   - Base templates from generator/openapi/src/main/resources/templates/
   - Product-specific customizations from customizations/ directory
5. Generate Kotlin/Java code:
   - Client classes with proper authentication
   - Model classes with validation and serialization
   - Operation classes with typed request/response handling
   - Exception classes for error handling
6. Apply post-processing:
   - Code formatting and style enforcement
   - License header injection
   - Documentation generation
7. Build generated Maven project to validate compilation
8. Package complete SDK as GitHub artifact
```

#### Phase 3: Source Publishing
**Workflow**: `selfserve-publish-sources.yaml`

```bash
# Integration with product repository:
1. Download generated SDK artifact
2. Checkout product repository with write permissions
3. Intelligent file replacement:
   - Replace entire code/ directory with generated content
   - Preserve manual customizations in other directories
   - Update version references in documentation
4. Git operations:
   - Create new branch: feature/sdk-generation-v{version}
   - Commit changes with a commit message
   - Create pull request with the change
5. Automated validations:
   - Verify compilation of generated code
   - Run basic smoke tests
```

#### Phase 4: Release to Maven Central (when triggered)
**Workflow**: `selfserve-release-sdk.yaml`

```bash
# Publication process:
1. Checkout generated SDK code from product repository
2. Maven build with release profile:
   - Compile source code and generate javadoc
   - Create source and javadoc JARs
3. Security and signing:
   - Sign all artifacts with GPG private key
   - Validate signatures and checksums
4. Sonatype Nexus deployment:
   - Upload to staging repository
   - Validate metadata and POM completeness
   - Promote to Maven Central (if all validations pass)
```

## Customization Support

Product teams can customize the generation process:

### Custom Templates
- Override default OpenAPI Generator templates
- Modify generated code structure and style

### Post-Processing
- Apply product-specific transformations after generation
- Customize package structures and naming conventions

### Build Configuration
- Override Maven configurations
- Add product-specific dependencies or plugins

## Generated SDK Structure

The generated SDKs follow a consistent structure:

```
generated-sdk/
├── pom.xml                          # Maven configuration
├── README.md                        # SDK documentation
├── LICENSE-HEADER.txt               # License information
├── src/main/kotlin/
│   └── com/expediagroup/sdk/
│       ├── [product]/
│       │   ├── client/              # API client classes
│       │   ├── models/              # Data models
│       │   ├── operations/          # Operation classes
│       │   └── [Product]Client.kt   # Main client class
│       └── core/                    # Core infrastructure
└── transformedSpecs.yaml            # Source OpenAPI specification
```

## Integration Examples & Real-World Usage

### Current Production Implementation Example

#### **[Rapid Java SDK](https://github.com/ExpediaGroup/rapid-java-sdk)** 
*Travel Partner API - Booking and Search Operations*

**Scale & Metrics**:
- **API Operations**: 200+ endpoints across booking, search, payment
- **Generated Code**: ~15,000 lines of Kotlin code
- **Usage**: High-volume production traffic (millions of API calls/day)

**Workflow Configuration**:
```yaml
# Real production configuration from rapid-java-sdk
transformations: "--headers --endpoint /v3 --operationIdsToTags"
# Result: Clean SDK with only v3 endpoints, optimized operation names
```

**Generated Structure**:
```
code/src/main/kotlin/com/expediagroup/sdk/rapid/
├── client/
│   ├── RapidClient.kt                 # Main client class
│   └── RapidClientConfiguration.kt    # Configuration management  
├── models/
│   ├── PropertyAvailability.kt        # 100+ generated model classes
│   ├── BookingRequest.kt
│   └── PaymentDetails.kt
├── operations/
│   ├── GetAvailabilityOperation.kt    # Typed operation classes
│   ├── CreateBookingOperation.kt
│   └── CancelBookingOperation.kt
└── exceptions/
    └── RapidException.kt              # SDK-specific exceptions
```

### Partner Integration Examples

#### Maven Central Consumption
```xml
<!-- Partners add this to their pom.xml -->
<dependency>
    <groupId>com.expediagroup</groupId>
    <artifactId>rapid-sdk</artifactId>
    <version>4.0.0</version>
</dependency>
```

#### Kotlin Usage Example
```kotlin
// Real usage example from partner integration
val client = RapidClient.builder()
    .key("your-api-key")
    .secret("your-secret")
    .environment(Environment.PRODUCTION)
    .build()

val availability = client.execute(
    GetAvailabilityOperation.builder()
        .checkin("2024-12-01")
        .checkout("2024-12-03")
        .occupancy("2-adults")
        .build()
)
```

## Advanced Workflow Usage & Monitoring

### Workflow Execution Monitoring

#### GitHub Actions Dashboard
Product teams can monitor workflow execution through comprehensive logging:

```bash
# Example workflow execution log structure:
📋 Workflow: Generate and Publish SDK Sources
├── 🔍 Show inputs                    # Input validation and display
├── 🔄 Transform specs               # OpenAPI processing  
│   ├── Download specifications
│   ├── Apply transformations
│   └── Upload transformed specs
├── ⚙️  Generate SDK                 # Code generation
│   ├── Setup environment
│   ├── Run OpenAPI Generator  
│   ├── Post-process generated code
│   └── Upload SDK artifact
└── 📤 Publish sources               # Repository integration
    ├── Create feature branch
    ├── Commit generated code
    └── Create pull request
```

### Troubleshooting Common Issues

#### 1. **OpenAPI Specification Issues**
```yaml
# Common problems and solutions:
Problem: "Invalid OpenAPI specification"
Solution: Validate with swagger-parser before generation
Command: npx @apidevtools/swagger-parser validate specs/your-spec.yaml
```

#### 2. **Generation Failures**
```yaml
# Template compilation errors:
Problem: "Mustache template compilation failed"
Solution: Check custom templates in customizations/ directory
Debug: Review generator logs in workflow execution

Problem: "Java compilation errors in generated code"
Solution: Verify OpenAPI schema definitions and constraints
```

#### 3. **Publishing Issues**
```yaml
# Authentication and permissions:
Problem: "Failed to create pull request"
Solution: Verify GitHub token has write permissions
Required: actions:write, contents:write, pull-requests:write

Problem: "Maven Central publishing failed"
Solution: Check GPG signing keys and Sonatype credentials
```

### Customization & Extension Points

#### Template Overrides
```
customizations/
├── templates/
│   ├── client.mustache          # Override default client template
│   └── model.mustache           # Custom model generation
└── config/
    └── generator-config.json    # OpenAPI Generator configuration
```

### Integration with External Systems

#### Jenkins Integration
```groovy
// Example Jenkins pipeline integration
pipeline {
    agent any
    stages {
        stage('Trigger SDK Generation') {
            steps {
                script {
                    // Call GitHub Actions via API
                    sh '''
                        curl -X POST \
                        -H "Authorization: token ${GITHUB_TOKEN}" \
                        -H "Accept: application/vnd.github.v3+json" \
                        https://api.github.com/repos/ExpediaGroup/rapid-java-sdk/actions/workflows/generate-and-publish-sdk-sources.yaml/dispatches \
                        -d '{"ref":"main","inputs":{"version":"'${SDK_VERSION}'"}}'
                    '''
                }
            }
        }
    }
}
```

## Getting Started for New Product Teams

### Quick Start Guide (5-Step Process)

#### Step 1: **Repository Creation & Setup**
```bash
# Create new product SDK repository
git clone https://github.com/ExpediaGroup/rapid-java-sdk.git myproduct-java-sdk
cd myproduct-java-sdk

# Clean up for new product
rm -rf code/ examples/
git remote set-url origin https://github.com/YourOrg/myproduct-java-sdk.git

# Update repository configuration
sed -i 's/rapid/myproduct/g' .github/workflows/*.yaml
```

#### Step 2: **Workflow Configuration**
```yaml
# .github/workflows/generate-and-publish-sdk-sources.yaml
name: Generate and Publish SDK Sources

on:
  workflow_dispatch:
    inputs:
      version:
        description: 'SDK Version (e.g., 1.0.0, 1.0.1, 1.0.0-SNAPSHOT)'
        required: true
        type: string

jobs:
  generate-and-publish-sources:
    uses: ExpediaGroup/expediagroup-java-sdk/.github/workflows/selfserve-full-workflow.yaml@legacy
    secrets: inherit
    with:
      name: myproduct                     # ⚠️  CHANGE THIS to your product name
      version: ${{ inputs.version }}
      transformations: "--headers --operationIdsToTags"  # Customize as needed
      repository: ${{ github.repository }}
      sources_path: 'code'
```

#### Step 3: **OpenAPI Specification Setup**
```bash
# Add your OpenAPI specification
mkdir -p specs
# Option A: Single file
cp your-openapi-spec.yaml specs/myproduct-api.yaml

# Option B: Multiple files (recommended for large APIs)
cat > specs/openapi-merge.json << EOF
{
  "inputs": [
    "auth-spec.yaml",
    "core-api-spec.yaml", 
    "models-spec.yaml"
  ],
  "output": "./merged-spec.yaml"
}
EOF
```

#### Step 4: **Execute First Generation**
```bash
# Via GitHub Actions UI:
1. Go to your repository's Actions tab
2. Select "Generate and Publish SDK Sources"
3. Click "Run workflow"
4. Enter version: "1.0.0-SNAPSHOT"  
5. Monitor execution (typically <5 minutes)
6. Review generated pull request
7. Merge PR to complete initial setup
```

#### Step 5: **Maven Central Publishing Setup** (Optional)
```yaml
# Add these secrets to your repository (Settings → Secrets):
SONATYPE_USERNAME: your-sonatype-username
SONATYPE_PASSWORD: your-sonatype-password
GPG_PRIVATE_KEY: |
  -----BEGIN PGP PRIVATE KEY BLOCK-----
  your-gpg-private-key-content
  -----END PGP PRIVATE KEY BLOCK-----
GPG_PASSPHRASE: your-gpg-passphrase

# Then create .github/workflows/release-sdk.yaml:
name: Release SDK
on:
  workflow_dispatch:
    inputs:
      core-ref:
        description: 'SDK infrastructure version'
        type: string
        default: 'legacy'

jobs:
  release-sdk:
    uses: ExpediaGroup/expediagroup-java-sdk/.github/workflows/selfserve-release-sdk.yaml@legacy
    secrets: inherit
    with:
      branch: ${{ inputs.core-ref }}
      sdk_path: 'code'
```

### Initial Project Structure Result
After successful setup, your repository will contain:

```
myproduct-java-sdk/
├── .github/workflows/
│   ├── generate-and-publish-sdk-sources.yaml
│   └── release-sdk.yaml
├── specs/
│   └── myproduct-api.yaml
├── code/                                    # Generated by workflow
│   ├── src/main/kotlin/com/expediagroup/sdk/myproduct/
│   │   ├── client/MyproductClient.kt
│   │   ├── models/[GeneratedModels].kt
│   │   └── operations/[GeneratedOperations].kt
│   ├── pom.xml
│   └── README.md
└── README.md                               # Your product documentation
```

## Support and Troubleshooting

### Common Issues & Solutions

#### 1. **Workflow Execution Failures**

**Issue**: `"Workflow failed at transform-specs step"`
```yaml
# Root Cause: Invalid OpenAPI specification
# Solution: Validate specification before generation
Debug Steps:
  1. Run: npx @apidevtools/swagger-parser validate specs/your-spec.yaml
  2. Check for circular references in $ref definitions
  3. Verify all required fields are present
  4. Ensure OpenAPI version is 3.0+
```

**Issue**: `"Permission denied when creating pull request"`
```yaml
# Root Cause: Insufficient GitHub token permissions
# Solution: Verify repository secrets and permissions
Required Permissions:
  - actions: write
  - contents: write  
  - pull-requests: write
  - metadata: read
```

#### 2. **Generation Quality Issues**

**Issue**: `"Generated code doesn't compile"`
```yaml
# Root Cause: OpenAPI schema constraints or custom templates
# Debugging Process:
  1. Check workflow logs for Java compilation errors
  2. Verify OpenAPI schema definitions and constraints
  3. Test with minimal OpenAPI spec to isolate issue
  4. Review custom templates in customizations/ directory
```

#### 3. **Maven Central Publishing Issues**

**Issue**: `"GPG signing failed"`
```yaml
# Root Cause: Invalid or expired GPG keys
# Solution: Update GPG configuration
Steps:
  1. Generate new GPG key pair: gpg --gen-key
  2. Export private key: gpg --armor --export-secret-keys YOUR_KEY_ID
  3. Update GPG_PRIVATE_KEY secret in repository
  4. Verify GPG_PASSPHRASE matches
```

**Issue**: `"Sonatype validation failed"`
```yaml
# Root Cause: Incomplete POM metadata or duplicate versions
# Solution: Check Maven configuration
Requirements:
  - Valid POM with required metadata (name, description, url)
  - Proper developer and license information  
  - Unique version (no duplicates in Maven Central)
  - Valid SCM and distribution management configuration
```

### Getting Help & Support Channels

#### 1. **Self-Service Resources**
- **Workflow Logs**: Detailed execution logs in GitHub Actions
- **Example Repositories**: Study rapid-java-sdk and xap-java-sdk implementations
- **Documentation**: This guide and SDK_GENERATION_GUIDE.md
- **OpenAPI Tools**: Use swagger-parser and spec-transformer CLI for validation

#### 2. **Community Support**
- **GitHub Issues**: Report bugs and request features in expediagroup-java-sdk repository
- **Pull Requests**: Contribute improvements to templates and workflows
- **Discussions**: GitHub Discussions for questions and best practices

#### 3. **Enterprise Support** (Internal Expedia Teams)
- **SDK Team**: Direct consultation for complex customization needs

---

## Summary

This infrastructure enables Expedia Group to maintain a **consistent, high-quality SDK ecosystem** while allowing product teams to focus on their core business logic rather than SDK implementation details. The **repository-as-a-service model** provides:

- **🚀 Rapid SDK Development**: From OpenAPI spec to production SDK in minutes
- **📦 Automated Publishing**: Seamless Maven Central integration
- **🔄 Continuous Updates**: Keep SDKs current with API evolution  
- **🎯 Standardization**: Consistent patterns across all Expedia Group SDKs
- **⚡ Developer Productivity**: Eliminate manual SDK maintenance overhead

