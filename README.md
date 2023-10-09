# token-generator

# Microservices Project - Token Generator and Validator

Welcome to the Microservices Project for Token Generation and Validation. This project leverages Maven, JDK 17, and Spring Boot to provide a robust solution for generating and validating tokens. And a web app on ReactJS for interacting UI.Below, you will find all the essential information to get started with this project.

## Table of Contents

- [Introduction](#introduction)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Configuration](#configuration)

## Introduction
The Microservices Project - Generate a random token with specific given format and allow digits and validate token using Lunh algorihm.

1. **Generator Service**: A Spring Boot microservice responsible for the dynamic generation of tokens based on specified criteria. There is format in application.properties file to decide token format and [0-9] digis are allowed.
    
2. **Validator Service**: Another Spring Boot microservice dedicated to token validation using the Luhn algorithm.

3. **Gateway Service**: This component, powered by Spring Cloud Gateway, serves as the API gateway, directing incoming requests to their respective microservices.



## Project Structure

- `generator-service`: The home of the Generator Service code.
- `validator-service`: The codebase for the Validator Service.
- `gateway-service`: Contains the Gateway Service implementation.
- `frontend`: React project For interacting with services.

## Getting Started

### Prerequisites

Before diving into this project, ensure you have the following prerequisites in place:

- JDK 17
- Maven
- Node JS
- Npm
- Your preferred Integrated Development Environment (IDE), such as IntelliJ IDEA or Eclipse.

### Installation

1. Begin by cloning this repository to your local machine:

   ```shell
   git clone https://github.com/your-username/microservices-project.git

2. There is start.sh for (macOS and Linux) and start.bat for windows scripts file use to run all service. Make sure start.sh or start.bat has execution rights, if not Run chmod a+x start.sh command.

### Usage
You can interact with the services through the following API endpoints:

1. Generator Service: http://localhost:8082/generator/token/{digits}
2. Validator Service: http://localhost:8082/validator/validate/{token}

## API Endpoints

### Generator Service Endpoints:

- **Generate Token**
  - **Endpoint**: `GET /generator/token/{digits}`
  - **Description**: Generates a token with the specified number of digits.
  - **Parameters**:
    - `{digits}` (Path Parameter): The number of digits to include in the generated token.
  - **Example Request**:
    ```http
    GET /generator/token/2,4,7,8
    ```
  - **Example Response**:
    ```json
    {
    "token": "2742-4447-2444-7824",
    "availableDigits": "2,4,7,8"
    }
    ```

### Validator Service Endpoints:

- **Validate Token**
  - **Endpoint**: `GET /validator/validate/{token}`
  - **Description**: Validates a token using the Luhn algorithm.
  - **Parameters**:
    - `{token}` (Path Parameter): The token to be validated.
  - **Example Request**:
    ```http
    GET /validator/validate/8742-7828-4787-7247
    ```
  - **Example Response**:
    ```json
    {
    "token": "8742-7828-4787-7247",
    "valid": true
    }
    ```

## Configuration

Each microservice may have its own configuration files (e.g., `application.properties` or `application.yml`) to enable customization based on specific requirements.
