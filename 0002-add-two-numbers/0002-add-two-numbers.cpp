class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* dummy = new ListNode(-1);
        ListNode* temp=dummy;
        ListNode* t1=l1;
        ListNode* t2=l2;
        int carry=0;
        while(t1!=NULL || t2!=NULL){
            int sum = carry;
            if(t1) sum+=t1->val;
            if(t2) sum+=t2->val;
            ListNode* nn=new ListNode(sum%10);
            carry=sum/10;
            temp->next=nn;
            temp=temp->next;
            if(t1) t1=t1->next;
            if(t2) t2=t2->next;
        }
        if(carry){
            ListNode* nn=new ListNode(carry);
            temp->next=nn;
        }
        return dummy->next;
    }
};