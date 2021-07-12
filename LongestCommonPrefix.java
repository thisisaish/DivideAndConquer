//Write a function to find the longest common prefix string amongst an array of strings.

class Lcp{

    private static String commonPrefix(String[] strs, int low, int high){
        //Divide and conquer
        if(low == high)
            return strs[low];
        
        int mid = (high + low)/2;
        String leftStr = commonPrefix(strs, low, mid);
        String rightStr = commonPrefix(strs, mid+1, high);
        return commonPrefixUtil(leftStr, rightStr);
                
    }

    private static String commonPrefixUtil(String left, String right){
        int limit = Math.min(left.length(), right.length());
        for(int iter = 0; iter < limit; iter++){
            if(left.charAt(iter) != right.charAt(iter))return left.substring(0, iter);
        }
        return left.substring(0, limit);
    }

    public static void main(String[] args) {
        //Driver code
        String[] strs = {"apple","appropriate","application","applause"};
        System.out.println("Longest common prefix is "+ commonPrefix(strs, 0, strs.length - 1));
    }
}
