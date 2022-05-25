package sos.haruhi.hadoop.top;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

// 分组比较器
public class TGroupingComparator extends WritableComparator {
    public TGroupingComparator() {
        super(TKey.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        // 按照 年 月 分组
        TKey k1 = (TKey) a;
        TKey k2 = (TKey) b;

        // 年、月、温度  ，  且温度倒序比较
        int c1 = Integer.compare(k1.getYear(), k2.getYear());
        if (c1 == 0) {
            return Integer.compare(k1.getMonth(), k2.getMonth());
        }

        return c1;
    }
}
