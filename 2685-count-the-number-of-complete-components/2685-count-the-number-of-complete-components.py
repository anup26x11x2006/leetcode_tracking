class Solution(object):
    def countCompleteComponents(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: int
        """
        adj = [[] for _ in range(n)]
        cnt = 0
        visited = [0]*n
        
        for u,v in edges:
            adj[u].append(v)
            adj[v].append(u)
        
        for i in range(n):
            if visited[i] == 0:
                comp_nodes = []
                stack = [i]
                visited[i] = 1
                
                while stack:
                    node = stack.pop()
                    comp_nodes.append(node)
                    for j in adj[node]:
                        if visited[j] == 0:
                            stack.append(j)
                            visited[j] = 1
                v_count = len(comp_nodes)
                degree_sum = 0
                for node in comp_nodes:
                    degree_sum+=len(adj[node])
                
                actual_edges = degree_sum//2
                expected_edges = (v_count)*(v_count-1)//2
                if actual_edges == expected_edges:
                    cnt+=1
        return cnt