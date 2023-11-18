import java.util.Arrays;
import java.util.LinkedList;

public class DynamicCounter extends LinkedList<Integer>
{
    public boolean done = false;
    private final int length;
    private final int base;
    private final int[] digits;

    public DynamicCounter(int length, int base)
    {
        this.length = length;
        this.base = base;
        this.digits = new int[length];
        for (int i = 0; i < length; i++) {
            digits[i] = base;
        }
    }

    public void downOne()
    {
        for (int i = 0; i < this.length; i++) {
            if (digits[i] > 1) {
                digits[i]--;
                return;
            } else if (digits[i] == 1) {
                digits[i] = base;
                if ( (i+1) < length && digits[i+1] > 1) {
                    digits[i+1]--;
                    return;
                }
            }
        }
        done = true;
    }

    public int[] getCombinations(int dropLow, int dropHigh)
    {
        int[] arr = new int[length];
        if (length >= 0) System.arraycopy(digits, 0, arr, 0, length);
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, dropLow, length-dropHigh);
    }

    public void printCombinations() {
        System.out.println(Arrays.toString(digits));
    }

    public void printDropCombinations(int dropLow, int dropHigh) {
        System.out.println(Arrays.toString(getCombinations(dropLow, dropHigh)));
    }
}
