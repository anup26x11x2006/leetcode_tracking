class Solution(object):
    def braceExpansionII(self, expression):
        def concat(a, b):
            return {x + y for x in a for y in b}

        def parse_expr():
            res = set()

            while pos[0] < len(expression) and expression[pos[0]] != '}':
                res |= parse_term()

                if pos[0] < len(expression) and expression[pos[0]] == ',':
                    pos[0] += 1

            return res

        def parse_term():
            res = {""}

            while pos[0] < len(expression) and expression[pos[0]] not in '},':
                if expression[pos[0]] == '{':
                    pos[0] += 1
                    part = parse_expr()
                    pos[0] += 1
                else:
                    part = {expression[pos[0]]}
                    pos[0] += 1

                res = concat(res, part)

            return res

        pos = [0]
        return sorted(parse_expr())