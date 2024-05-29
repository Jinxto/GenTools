# GenTools: Nike Account Generator Bot

A Selenium-based Java bot that automatically generates Nike accounts. The primary function of this bot is accessed through the command-line interface (CLI).

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
  - [Clone the Repository](#clone-the-repository)
  - [Build the Project](#build-the-project)
- [Configuration](#configuration)
  - [License Key](#license-key)
  - [5sim Token and Hyper Token](#5sim-token-and-hyper-token)
  - [Proxies](#proxies)
- [Usage](#usage)
  - [Running the Bot](#running-the-bot)
  - [Command-Line Options](#command-line-options)
- [Example Session](#example-session)
- [Troubleshooting](#troubleshooting)
- [License](#license)

## Overview

GenTools is a powerful bot designed to automate the process of creating Nike accounts. Leveraging Selenium and Java, this bot provides a robust solution for generating multiple accounts efficiently. The main functionality is accessed through a simple command-line interface.

## Features

- **Automated Account Creation**: Generate Nike accounts with random or specified details.
- **Selenium Web Automation**: Uses Selenium WebDriver for browser automation.
- **Command-Line Interface**: Easy-to-use CLI for initiating the bot and managing settings.
- **Customizable**: Configuration options for personalizing account details.
- **Hyper Account Verification**: Checks if the user has an active Hyper account subscription in Discord.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- **Java Development Kit (JDK)** installed on your machine. You can download it from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- **Apache Maven** for managing the project and its dependencies. Install Maven from [here](https://maven.apache.org/install.html).
- **Selenium WebDriver** and a compatible browser driver (e.g., ChromeDriver for Google Chrome). Download ChromeDriver from [here](https://sites.google.com/a/chromium.org/chromedriver/downloads).

## Installation

### Clone the Repository

```bash
git clone https://github.com/yourusername/GammaGen.git
cd GammaGen
```

### Build the Project

```bash
mvn clean install
```

## Configuration

Configuration files are located in the `src/main/resources` directory. Customize the following files as needed:

### License Key

Place your license key in `license.txt`.

### 5sim Token and Hyper Token

Place your 5sim token and Hyper token in `token.txt` in the following format:

```
5sim_token
hyper_token
```

### Proxies

List your proxies in `proxies.txt` in the format `provider:port:username:password`.

Example of `proxies.txt`:
```
provider1:port1:username1:password1
provider2:port2:username2:password2
```

## Usage

### Running the Bot

1. **Navigate to the Project Directory**:
    ```bash
    cd GammaGen
    ```

2. **Run the Bot**:
    ```bash
    java -jar target/gammagen-1.0-SNAPSHOT.jar
    ```

### Command-Line Options

Follow the on-screen prompts to input the following details:

1. **Number of Accounts**: Enter the number of Nike accounts you want to generate.
2. **Custom Domain**: Specify if you want to use a custom domain (e.g., `@YourCustomDomain.com`).
3. **5sim Provider Region**: Choose your 5sim provider region from the available options (e.g., Russia, Malaysia, Singapore, Thailand, UK, Philippines).
4. **Custom Password**: Decide if you want to use a custom password (must include at least 1 uppercase letter, 1 number, and be at least 8 characters long).
5. **Number of Threads**: Set the number of threads for multithreading. Ensure that the number of threads does not exceed the number of accounts and does not leave a remainder when divided by the number of accounts.

## Example Session

### Step-by-Step Guide

1. **Initialize the Bot**:
    ```bash
    java -jar target/gammagen-1.0-SNAPSHOT.jar
    ```

2. **On-Screen Prompts**:
    - **Enter the number of Nike accounts you want to generate**: `10`
    - **Do you wish to use a custom domain? (Type 1 for Yes, press Enter for No)**: `1`
    - **Type in your custom domain (Example: @YourCustomDomain.com)**: `@example.com`
    - **Select your 5sim provider region by stating the number**:
        ```
        1. Russia
        2. Malaysia
        3. Singapore
        4. Thailand
        5. UK
        6. Philippines
        ```
      - **Enter the number corresponding to your region**: `3`
    - **Do you wish to use a custom password? (Type 1 for Yes, press Enter for No)**: `1`
    - **Please type in your custom password**: `ExamplePassword123`
    - **Select the number of threads you want to use**: `2`

## Troubleshooting

### Common Issues and Solutions

- **License Not Found**: Ensure that `license.txt` is present in the project directory and contains a valid license key.
- **Token Not Found**: Ensure that `token.txt` is present in the project directory and contains both a valid 5sim token and a Hyper token.
- **No Proxies File Found**: Ensure that `proxies.txt` is present in the project directory and is correctly formatted.
- **Invalid Number of Threads**: Ensure that the number of threads does not exceed the number of accounts and does not leave a remainder when divided by the number of accounts.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

---
