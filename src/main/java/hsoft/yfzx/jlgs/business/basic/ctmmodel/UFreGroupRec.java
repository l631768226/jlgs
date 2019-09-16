package hsoft.yfzx.jlgs.business.basic.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;

import java.util.List;

/**
 * 常用群组排序传参
 */
public class UFreGroupRec extends AbstactBaseRec {

    private List<CtmFreqSortRec> sorts;

    public List<CtmFreqSortRec> getSorts() {
        return sorts;
    }

    public void setSorts(List<CtmFreqSortRec> sorts) {
        this.sorts = sorts;
    }
}
