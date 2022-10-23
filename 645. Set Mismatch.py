class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        ans = []
        h = Counter(nums)
        for i, k in h.items():
            if k ==2 :
                ans.append(i)
        for i in range(1, len(nums)+1):
            if i not in h:
                ans.append(i)
        return ans
