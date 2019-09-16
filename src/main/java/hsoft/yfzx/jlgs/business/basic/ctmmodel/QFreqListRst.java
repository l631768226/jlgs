package hsoft.yfzx.jlgs.business.basic.ctmmodel;

import hsoft.yfzx.jlgs.business.basic.model.Freqcontact;
import hsoft.yfzx.jlgs.business.basic.model.Freqgroup;

import java.util.List;

/**
 * 查询常用联系人和常用群组返回参数
 */
public class QFreqListRst {

    private List<Freqcontact> contactList;

    private List<Freqgroup> groupList;

    public List<Freqcontact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Freqcontact> contactList) {
        this.contactList = contactList;
    }

    public List<Freqgroup> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Freqgroup> groupList) {
        this.groupList = groupList;
    }
}
