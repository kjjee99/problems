#bj 5618**
n = int(input())
if n == 2:
    li = list(map(int, input().split()))
else:
    li = list(map(int, input().split()))
for a in li:
    for i in range(1, max(li)):
        if a % i == 0:
            print(a)