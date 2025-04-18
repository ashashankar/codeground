from typing import List


class GoodDaysToRobBankLC2100:
    def goodDaysToRobBank(self, security: List[int], time: int) -> List[int]:
        result = []

        if (time == 0):
            return list(range(len(security)))

        n = len(security)
        pf = [0] * n
        sf = [0] * n

        for i in range(1, n):
            if security[i] <= security[i - 1]:
                pf[i] = pf[i - 1] + 1

        for i in range(n - 2, -1, -1):
            if security[i] <= security[i + 1]:
                sf[i] = sf[i + 1] + 1

        for i in range(n):
            if pf[i] >= time and sf[i] >= time:
                result.append(i)

        return result

def main():
    good = GoodDaysToRobBankLC2100()
    time = 1#2
    #security = [1, 2, 5, 4, 1, 0, 2, 4, 5, 3, 1, 2, 4, 3, 2, 4, 8]
    security = [0,4,3,0,0]
    result = good.goodDaysToRobBank(security, time)
    print(result)

main()