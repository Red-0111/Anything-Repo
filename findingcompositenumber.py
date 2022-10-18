val=int(input("enter the number="))
if(val>2):
    for i in range(2,val):
        if(val%i!=0):
            print("the number is prime")
            break
        else:
            print("the number is composite")
            break
