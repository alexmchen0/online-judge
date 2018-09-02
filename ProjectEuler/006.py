# Project Euler Problem 6: Sum square difference
def solution(num):
    ans = square_of_sum(num) - sum_of_squares(num)
    return ans


def sum_of_squares(num):
    return sum(num ** 2 for num in range(1, num + 1))


def square_of_sum(num):
    return sum(num for num in range(1, num + 1)) ** 2


print(solution(100))
