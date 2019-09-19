package hsoft.yfzx.jlgs.business.basic.ctmmodel;

import hsoft.yfzx.jlgs.business.basic.model.Freqcontact;
import hsoft.yfzx.jlgs.business.basic.model.Freqgroup;

import java.util.List;

/**
 * 查询常用联系人和常用群组返回参数
 */
public class QFreqListRst {

    private List<QFreqRst> contactList;

    private List<QFreqRst> groupList;

    public List<QFreqRst> getContactList() {
        return contactList;
    }

    public void setContactList(List<QFreqRst> contactList) {
        this.contactList = contactList;
    }

    public List<QFreqRst> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<QFreqRst> groupList) {
        this.groupList = groupList;
    }
}
