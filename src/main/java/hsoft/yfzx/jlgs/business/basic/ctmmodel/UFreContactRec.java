package hsoft.yfzx.jlgs.business.basic.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;

import java.util.List;
/**
 * 常用联系人排序传参
 */
public class UFreContactRec extends AbstactBaseRec{

    private List<CtmFreqSortRec> sorts;

    public List<CtmFreqSortRec> getSorts() {
        return sorts;
    }

    public void setSorts(List<CtmFreqSortRec> sorts) {
        this.sorts = sorts;
    }
}
