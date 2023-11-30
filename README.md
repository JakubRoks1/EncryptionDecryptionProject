# Encryption and Decryption Program

## Description

The program is designed for encrypting and decrypting messages using different algorithms. In this version, shift and Unicode algorithms are available.

## Table of Contents

- [Instructions](#instructions)
- [Command Line Arguments](#command-line-arguments)
- [Usage Examples](#usage-examples)

## Instructions

To run the program, follow these steps:

1. Clone the repository: `git clone https://github.com/your-account/EncryptionDecryptionProgram.git`
2. Navigate to the project directory: `cd EncryptionDecryptionProgram`
3. Run the program with the appropriate command-line arguments.

## Command Line Arguments

The program supports the following command-line arguments:

- `-mode`: Specifies the operation mode (enc - encryption, dec - decryption). Default is enc.
- `-key`: Key used for modifying the message. Default is 0.
- `-data`: Text or ciphertext to encrypt/decrypt. Default is an empty string.
- `-in`: Full file name with data to read. Cannot be used simultaneously with `-data`.
- `-out`: Full file name to write the result. Default is standard output.

## Usage Examples

1. Encryption using the Unicode algorithm:

java Main -mode enc -key 5 -data "Hello, World!" -alg unicode

Result: `Rovvy6*aay|vn+`

2. Decryption using the Unicode algorithm:

java Main -mode dec -key 5 -data "Mjqqt1%\twqi&" -alg unicode

Result: 'Hello, World!'

