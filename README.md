# Multithreading Communication

This repository contains exercises that demonstrate multithreading communication in Java. The exercises revolve around an array of integers, which multiple threads interact with and perform different tasks. We use a mutex or semaphore to avoid race conditions when threads modify the shared data.

## Exercise Breakdown

### Part I

1. A program is started that creates an array of `N` integers, where `N` is provided by the user.
2. The program fills the array with `N` integer numbers, randomly selected from the range [-100, 100].
3. The program creates 4 threads, each of which performs the following tasks:
    - The first thread calculates the sum `T1` of the `N` elements.
    - The second thread calculates the product `T2` of the `N` elements.
    - The third thread selects a random number from the range [-1000, 1000], i.e., `T3 = random (X): -1000 <= X <= 1000`.
    - The fourth thread sorts the three previous threads in a row from 1 to 3, depending on their results as `T1`, `T2`, `T3`.

### Part II

1. A modified version of the program is created, which does the following:
    - When each of the first two threads executes, it randomly selects half of the table, and replaces it with new random numbers from the range [-100, 100]. Then the program calculates the sum (first thread) or the product (second thread) of the modified table.
    - The program uses a mutex or semaphore to ensure that there is never a chance for both threads to modify the shared table elements at the same time.

Throughout the execution of the program, indicative messages are displayed when a thread starts running, waits for another, and completes its work.

## Contributors

- [x] [Dimitris Matsanganis](https://github.com/dmatsanganis)


![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
