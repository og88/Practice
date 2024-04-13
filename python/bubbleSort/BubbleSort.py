import random
num = 50
x = random.sample(range(1, num + 1), num)

for i in range(0, num - 1):
    for y in range(i, num):
        if x[i] > x[y]:
            #print(str(x[i]) + " > " + str(x[y]))
            temp = x[y]
            x[y] = x[i]
            x[i] = temp
        print(str(x))

input("Press Enter to continue...")