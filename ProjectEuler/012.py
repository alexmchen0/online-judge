# Project Euler Problem 12: Highly divisible triangular number
def solution(target):
    ans = 0
    i = 1
    while True:
        ans += i
        i += 1
        if count_divisors(ans) > target:
            return ans


def count_divisors(num):
    count = 1
    factor = 2
    while factor <= num:
        factor_power = 0
        while num % factor == 0:
            factor_power += 1
            num /= factor
        factor += 1
        if factor_power:
            count *= (factor_power + 1)
    return count

print(solution(500))
