# Project Euler Problem 5: Smallest multiple
def solution(max_divisor):
    ans = 1
    for divisor in range(2, max_divisor + 1):
        ans *= divisor // gcd(ans, divisor)

    return ans


def gcd(a, b):
    while b:
        a, b = b, a % b
    return a


print(solution(20))
