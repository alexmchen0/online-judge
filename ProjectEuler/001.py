# Project Euler Problem 1: Multiples of 3 and 5
def solution(limit):
    ans = 0
    for i in range(limit):
        if i % 3 == 0 or i % 5 == 0:
            ans += i
    return ans


print(solution(1000))
