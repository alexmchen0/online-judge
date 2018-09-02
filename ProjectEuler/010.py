import math


# Project Euler Problem 10: Summation of primes
def solution(limit):
    ans = 0
    prime_generator = get_prime_generator()
    prime = next(prime_generator)
    while prime < limit:
        ans += prime
        prime = next(prime_generator)
    return ans


def get_prime_generator():
    next_prime = 2
    while True:
        if is_prime(next_prime):
            yield next_prime
        next_prime += 1


def is_prime(num):
    for factor in range(2, int(math.sqrt(num)) + 1):
        if num % factor == 0:
            return False
    return True


print(solution(2000000))
