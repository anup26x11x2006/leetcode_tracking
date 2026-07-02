from collections import deque

class Solution(object):
    def findSafeWalk(self, grid, health):
       
        linhas = len(grid)
        colunas = len(grid[0])
        vida_inicial = health - grid[0][0]
        if vida_inicial <= 0:
            return False
        fila = deque()
        fila.append((0, 0, vida_inicial))
        visitados = set()
        visitados.add((0, 0))
        direcoes = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        while len(fila) > 0:
            r, c, vida_atual = fila.popleft()
            if r == linhas - 1 and c == colunas - 1:
                return vida_atual >= 1
            for dr, dc in direcoes:
                nr = r + dr
                nc = c + dc
                if 0 <= nr < linhas and 0 <= nc < colunas and (nr, nc) not in visitados:
                    nova_vida = vida_atual - grid[nr][nc]
                    if nova_vida >= 1:
                        visitados.add((nr, nc))
                        if grid[nr][nc] == 0:
                            fila.appendleft((nr, nc, nova_vida))
                        else:
                            fila.append((nr, nc, nova_vida))
        return False