class Solution(object):
    def minimumPushes(self, word):
        temp={}
        for i in set(word):
            x=word.count(i)
            temp[i]=x
        ans=sorted(temp.items(),key=lambda x:x[1],reverse=True)
        res=0
        for i in range(len(ans)):
            if i>23:
                res+=4*ans[i][1]
            elif i>15:
                res+=3*ans[i][1]
            elif i>7:
                res+=2*ans[i][1]
            else:
                res+=1*ans[i][1]
        return res
        
        