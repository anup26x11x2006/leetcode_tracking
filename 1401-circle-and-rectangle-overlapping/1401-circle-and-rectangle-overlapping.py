class Solution:
    def checkOverlap(
        self,
        radius,
        xCenter,
        yCenter,
        x1,
        y1,
        x2,
        y2,
    ):
        dist = 0
        if xCenter < x1 or xCenter > x2:
            dist += min((x1 - xCenter) ** 2, (x2 - xCenter) ** 2)
        if yCenter < y1 or yCenter > y2:
            dist += min((y1 - yCenter) ** 2, (y2 - yCenter) ** 2)
        return dist <= radius**2