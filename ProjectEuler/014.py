# Project Euler Problem 14: Longest Collatz sequence
def solution(limit):
    memo = {}
    max_len = 0
    ans = 0
    for num in range(1, limit):
        if collatz_len(num, memo) > max_len:
            max_len = collatz_len(num, memo)
            ans = num

    return ans


def collatz_len(num, memo):
    if num == 1:
        return 1
    if num in memo:
        return memo[num]

    length = collatz_len(num // 2, memo) + 1 if num % 2 == 0 \
        else collatz_len(num * 3 + 1, memo) + 1
    memo[num] = length
    return length

print(solution(1000000))
