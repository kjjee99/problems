'''
  트리의 부모 찾기
  dfs & bfs
'''

import sys
# 최대 재귀깊이 한도
# sys.setrecursionlimit(10**9)
from collections import deque
input = sys.stdin.readline

# 노드의 개수
n = int(input())
tree = [[] for _ in range(n + 1)]

for _ in range(n - 1):
  a, b = map(int, input().split(' '))
  tree[a].append(b)
  tree[b].append(a)

# 부모 노드
parent = [0 for _ in range(n + 1)]

# dfs - 재귀
'''def dfs(s):
    for i in tree[s]:
      # 방문한 적이 없을 때
        if parent[i] == 0:
            parent[i] = s
            dfs(i)

# 1부터 시작
dfs(1)

# 출력
for x in range(2, n+1):
    print(parent[x])'''

# bfs
queue = deque()
queue.append(1)

def bfs():
  while queue:
    now = queue.popleft()
    for next in tree[now]:
      if parent[next] == 0:
        parent[next] = now
        queue.append(next)

bfs()

for x in range(2, n + 1):
  print(parent[x])