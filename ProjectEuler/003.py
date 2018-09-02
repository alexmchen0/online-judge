# Project Euler Problem 3: Largest prime factor
def solution(num):
    ans = 0
    i = 2
    while i <= num:
        if num % i == 0:
            ans = i
            num /= i
        else:
            i += 1
    return ans


print(solution(600851475143))
