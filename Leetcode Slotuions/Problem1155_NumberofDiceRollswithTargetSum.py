class Solution:
    def numRollsToTarget(self, d: int, f: int, target: int):        
        modulo = 10**9 + 7
        cache = {}
        
        def numRollsToTargetHelper(dd, tt):
            if cache.get((dd,tt)) != None:
                return cache[(dd,tt)]
            nonlocal f
            if dd == 1:
                if tt <= f:
                    return 1
                else:
                    return 0
            
            ret = 0
            for i in range(1, f+1):
                if tt - i > 0:
                    ret += numRollsToTargetHelper(dd-1, tt-i)
            cache[(dd,tt)] = ret
            return ret
        
        ret = numRollsToTargetHelper(d, target)
        return ret % modulo