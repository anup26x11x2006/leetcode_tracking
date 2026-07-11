class Solution:
    def countCompleteComponents(self, n, edges):

        graph = defaultdict(list)

        for v1, v2 in edges:
            graph[v1].append(v2)
            graph[v2].append(v1)

        complete_count = 0
        visited = set()

        def _dfs(curr, info):
            visited.add(curr)
            info[0] += 1
            info[1] += len(graph[curr])

            for next_vertex in graph[curr]:
                if next_vertex not in visited:
                    _dfs(next_vertex, info)

        for vertex in range(n):
            if vertex in visited:
                continue

            component_info = [0, 0]
            _dfs(vertex, component_info)

            if component_info[0] * (component_info[0] - 1) == component_info[1]:
                complete_count += 1

        return complete_count