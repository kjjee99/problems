'''
  트리의 지름 구하기
  dfs
'''

import sys
input = sys.stdin.readline

v = int(input())

# node 번호가 1부터 시작
graph = [[] for _ in range(v + 1)]

for _ in range(v):
  li = list(map(int, input().split()))
  node = li[0]
  for i in range(1, len(li) - 2, 2):
    # 튜플로 저장
    graph[node].append((li[i], li[i + 1]))


def dfs(index, cnt):
  # 각 노드와 연결된 노드를 확인
  for x, y in graph[index]:
    if visited[x] == -1:
      visited[x] = y + cnt
      dfs(x, y + cnt)

# 1번 노드에서 제일 먼 노드 검색
visited = [-1 for _ in range(v + 1)]
visited[1] = 0
dfs(1, 0)

# 1번 노드에서 제일 먼 노드로 거리 측정
start = visited.index(max(visited))
visited = [-1 for _ in range(v + 1)]
visited[start] = 0
dfs(start, 0)

# result
print(max(visited))