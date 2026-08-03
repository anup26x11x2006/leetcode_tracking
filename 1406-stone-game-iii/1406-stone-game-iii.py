class Solution(object):
    def stoneGameIII(self, stoneValue):
        """
        :type stoneValue: List[int]
        :rtype: str
        """
        def check(n):
            if n>0:
                return('Alice')
            if n<0:
                return('Bob')
            return('Tie')
        dp=[stoneValue[-1]]
        if len(stoneValue)==1:
            return(check(dp[-1]))
            
            
        dp.append(max(stoneValue[-2]-dp[-1],stoneValue[-1]+stoneValue[-2]))
        if len(stoneValue)==2:
            return(check(dp[-1]))
        curr=stoneValue[-3]-dp[-1]
        curr=max(curr,stoneValue[-3]+stoneValue[-2]-dp[-2])
        curr=max(curr,stoneValue[-3]+stoneValue[-2]+stoneValue[-1])
        dp.append(curr)
        for i in range(len(stoneValue)-4,-1,-1):
            curr=stoneValue[i]-dp[-1]
            curr=max(curr,stoneValue[i]+stoneValue[i+1]-dp[-2])
            curr=max(curr,stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-dp[-3])
            dp.append(curr)

        return(check(dp[-1]))