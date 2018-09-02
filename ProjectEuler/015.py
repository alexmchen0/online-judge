import math


# Project Euler Problem 15: Lattice paths
def solution(length, width):
    ans = math.factorial(length + width) // \
          (math.factorial(length) * math.factorial(width))

    return ans


print(solution(20, 20))
