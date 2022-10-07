class NumArray:

    def __init__(self, nums: List[int]):
        self.sum = []
        sum_till = 0
        for i in nums:
            sum_till += i
            self.sum.append(sum_till)

    def sumRange(self, i: int, j: int) -> int:
        if i > 0 and j > 0:
            return self.sum[j] - self.sum[i - 1]
        else:
            return self.sum[i or j]