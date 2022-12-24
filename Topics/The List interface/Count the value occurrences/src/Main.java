import java.util.List;

class Counter {

    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {
        int count1 = 0;
        for (Integer integer :
                list1) {
            if (integer == elem) {
                count1++;
            }
        }
        int count2 = 0;
        for (Integer integer :
                list2) {
            if (integer == elem) {
                count2++;
            }
        }
        return count1 == count2;
    }
}