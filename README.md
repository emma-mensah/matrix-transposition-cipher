# Matrix Transposition Cipher

## Overview

This Java program implements the Matrix Transposition Cipher, a method of encryption where the characters of a plaintext are rearranged based on a given key. The key is represented as an integer array, signifying the permutation of columns in the matrix.

## Usage

The program provides two methods:

### Method 1

- Accepts a plaintext (String of characters) and a key (integer array representing column permutation).
- Generates and returns the ciphertext (String of characters).

### Method 2

- Accepts a ciphertext (String of characters) and a key (integer array representing column permutation).
- Generates and returns the plaintext (String of characters).

## Notes

- The program assumes that plaintext and ciphertext consist of uppercase letters, lowercase letters, numbers, and spaces. Spaces are represented by the '%' character.
- No other special characters are allowed in the input.

Feel free to use and modify this code for your cryptographic experiments. If you encounter any issues or have suggestions for improvement, please open an issue on this repository.
