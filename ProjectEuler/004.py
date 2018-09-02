# Project Euler Problem 4: Largest palindrome product
def solution():
    ans = 0
    for x in range(1000, 0, -1):
        for y in range(1000, x, -1):
            prod = x * y
            if prod < ans:
                break
            if is_palindrome(prod):
                ans = prod
    return ans


def is_palindrome(num):
    return str(num) == str(num)[::-1]


print(solution())
