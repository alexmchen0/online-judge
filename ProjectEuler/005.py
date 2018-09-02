# Project Euler Problem 5: Smallest multiple
def solution(max_divisor):
    ans = 1
    factors = [0] * max_divisor

    for divisor in range(1, max_divisor + 1):
        if ans % divisor == 0:
            continue
        divisor_factors = prime_factorize(divisor)
        for factor in range(len(divisor_factors)):
            if divisor_factors[factor] > factors[factor]:
                power = divisor_factors[factor] - factors[factor]
                ans *= factor ** power
                factors[factor] = divisor_factors[factor]

    return ans


# Returns an array whose value at an index represents the power of that index
# e.g. prime_factorize(12) = [0,0,2,1] (12 = 0^0 * 1^0 * 2^2 * 3^1)
def prime_factorize(num):
    prime_factors = [0, 0]
    factor = 2
    while factor <= num:
        prime_factors.append(0)
        while num % factor == 0:
            prime_factors[factor] += 1
            num /= factor
        factor += 1
    return prime_factors


print(solution(20))
