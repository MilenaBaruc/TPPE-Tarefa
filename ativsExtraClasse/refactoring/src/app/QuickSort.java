package app;

public class QuickSort {

    private int[] valores;

    private QuickSort(int[] valores) {
        this.valores = valores;
    }

    public static QuickSort getInstancia(int[] valores) {
        return new QuickSort(valores);
    }

    public int getSize() {
        return valores.length;
    }

    public int particionamento(int left, int right) {
        Partition partition = new Partition(valores, left, right);
        return partition.partition();
    }

    public int[] ordenar(int left, int right) {
        if (left < right) {
            int indicePivot = particionamento(left, right);
            ordenar(left, indicePivot - 1);
            ordenar(indicePivot + 1, right);
        }
        return valores;
    }

    private static class Partition {
        private int[] valores;
        private int left;
        private int right;
        private int pivot;
        private int i;

        public Partition(int[] valores, int left, int right) {
            this.valores = valores;
            this.left = left;
            this.right = right;
        }

        public int partition() {
            initialize();
            scanAndSwap();
            swapPivotToCorrectPosition();
            return i;
        }

        private void initialize() {
            pivot = valores[left];
            i = left;
        }

        private void scanAndSwap() {
            for (int j = i + 1; j <= right; j++) {
                if (valores[j] <= pivot) {
                    i++;
                    swap(i, j);
                }
            }
        }

        private void swapPivotToCorrectPosition() {
            swap(left, i);
        }

        private void swap(int i, int j) {
            int temp = valores[i];
            valores[i] = valores[j];
            valores[j] = temp;
        }
    }
}
