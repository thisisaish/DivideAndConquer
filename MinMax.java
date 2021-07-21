//Write a function to return the minimum and maximum of a given integer array.
class MinMax{
    static class Pair{
        int min;
        int max;
        Pair(int min, int max){
            this.min = min;
            this.max = max;
        }
    }

    private static Pair minMax(int[] arr, int low, int high){
        if(low == high)return new Pair(arr[low], arr[low]);
        else if(high == low+1){
            int min = Math.min(arr[low], arr[high]);
            int max = arr[high] + arr[low] - min;
            return new Pair(min, max);
        }
        int mid = (low + high) / 2;
        Pair p1 = minMax(arr, low, mid);
        Pair p2 = minMax(arr, mid+1, high);        
        return comparePairs(p1, p2);
    }

    private static Pair comparePairs(Pair p1, Pair p2){
        p1.min = p1.min < p2.min ? p1.min : p2.min;
        p1.max = p1.max < p2.max ? p2.max : p1.max;
        return p1;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,-9,55,12};
        Pair pair = minMax(arr, 0, arr.length-1);
        System.out.println("Min : "+ pair.min + " Max : "+ pair.max);
    }
}
