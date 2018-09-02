# Project Euler Problem 10: Summation of primes
def solution(limit):
    return sum(i for i in sieve_of_eratosthenes(limit))


def sieve_of_eratosthenes(limit):
    prime_list = [True] * limit
    p = 2
    while p < limit:
        if prime_list[p]:
            yield p
            for i in range(p, limit // p):
                prime_list[i * p] = False
        p += 1


print(solution(2000000))
