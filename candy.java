//Time complexity: o(n)
//space complexity: o(n)

// idea:
// a) This is an o(n) solution
// b) Create an array and fill values with 1 since a child must have atleat 1 candy
// c) to satisfy the second condition that a child must have more candies than neighbouring child if the child's rating is high:
//         iterate through the array and if a child's rating is greater than previous child's rating, increment the rating by 1
//          now, to satisfy the condition of higher rating child must have more candy than the child right to it,
//          iterate from right to left and if the above criteria satisfies, fill the child's candy value as the maximum between current candy and the  next child candy number+1, so that at any point the child would have more candies than the child right to it


class Solution {
    public int candy(int[] ratings) {
        int candies[] = new int[ratings.length];
        Arrays.fill(candies, 1);
        
        for(int i=1;i<candies.length;i++) {
            if(ratings[i] > ratings[i-1]) candies[i] = candies[i-1] +1;
        }
        
        for(int i=candies.length-2;i>=0;i--) {
            if(ratings[i] > ratings[i+1]) candies[i] = Math.max(candies[i], candies[i+1]+ 1);
        }
        int sum = 0;
        for(int i=0;i<candies.length;i++) {
            sum+= candies[i];
        }
        return sum;
    }
}