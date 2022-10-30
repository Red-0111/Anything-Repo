class Solution:
    def maxLength(self, arr: List[str]) -> int:
        
        uniqELements = ['']
        maximum = 0
        for i in range(len(arr)):
            sz = len(uniqELements)
            for j in range(sz):
                x=arr[i]+uniqELements[j]
                if (len(x)==len(set(x))):
                    uniqELements.append(x)
                    maximum = max(maximum,len(x))
        #print(uniqELements)
        return maximum
