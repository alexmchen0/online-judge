# Project Euler Problem 2: Even Fibonacci numbers
def solution(limit):
    ans = 0
    i1 = 1
    i2 = 2
    while i1 <= limit:
        if i1 % 2 == 0:
            ans += i1
        i1, i2 = i2, i1 + i2
    return ans


print(solution(4000000))
