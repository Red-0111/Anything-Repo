##sum of even and odd numbers in list
lst=[1,2,3,4,5,6,7]
even=0
odd=0
for i in lst:
    if(i%2==0):
        even=even+i
    else:
        odd=odd+i
print(even,odd)
