import math


# Project Euler Problem 9: Special Pythagorean triplet
def solution(target):
    ans = 0
    for a in range(1, target // 3):
        for b in range(a + 1, (target - a) // 2):
            c_squared = a ** 2 + b ** 2
            c = int(math.sqrt(c_squared))
            if c_squared == c ** 2 and a + b + c == 1000:
                return a * b * c
    return ans

print(solution(1000))
