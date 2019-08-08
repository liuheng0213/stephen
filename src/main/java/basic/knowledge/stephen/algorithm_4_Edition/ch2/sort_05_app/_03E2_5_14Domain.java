package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_05_app;


public class _03E2_5_14Domain implements Comparable<_03E2_5_14Domain> {
    private String domain;
    private String[] splitDomain;

    public _03E2_5_14Domain(String domain) {
        this.domain = domain;
        this.splitDomain = this.domain.split("\\.");
    }

    @Override
    public String toString() {
        return domain;
    }

    @Override
    public int compareTo(_03E2_5_14Domain that) {
        int i = this.splitDomain.length - 1;
        int j = that.splitDomain.length - 1;
        for (; i >= 0 && j >= 0; i--, j--) {
            int result = this.splitDomain[i].compareTo(that.splitDomain[j]);
            if (result != 0) {
                return result;
            }
        }
        return i - j;
    }


}
