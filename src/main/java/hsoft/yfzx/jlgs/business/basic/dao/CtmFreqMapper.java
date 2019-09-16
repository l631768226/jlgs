package hsoft.yfzx.jlgs.business.basic.dao;

import hsoft.yfzx.jlgs.business.basic.ctmmodel.CtmFreqSortRec;
import hsoft.yfzx.jlgs.business.basic.model.Freqcontact;
import hsoft.yfzx.jlgs.business.basic.model.Freqgroup;
import hsoft.yfzx.jlgs.business.basic.model.Usergroup;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CtmFreqMapper {

    /**
     * 根据ownerId联表查询常用联系人列表
     * @param userId
     * @return
     */
    @Select("select * from FREQCONTACT A, LOGININFO B where A.USERID = B.USERID and A.OWNERID = #{userId} " +
            "and ROWNUM <= 3 ORDER BY A.\"SORT\" ")
    List<Freqcontact> findContactByOwnerId(@Param("userId") String userId);

    /**
     * 根据ownerId联表查询常用群组列表
     * @param userId
     * @return
     */
    @Select("select * from FREQGROUP A, GROUPINFO B where A.GROUPID = B.GROUPID and A.OWNERID = #{userId} " +
            "and ROWNUM <= 3 ORDER BY A.\"SORT\" ")
    List<Freqgroup> findGroupByOwnerId(@Param("userId") String userId);


//    @Update({
//            "<script>",
//            "update FREQGROUP ",
//            "<foreach collection = 'sortList' item = 'sorts' index = 'index' separator = ','>",
//            "set \"SORT\" = #{sorts.sort} where GROUPID = #{sorts.objectId} and OWNERID = #{userId}",
//            "</foreach>",
//            "</script>"
//    })
//    int updateGroupSort(@Param(value = "sortList") List<CtmFreqSortRec> sortList, @Param("userId") String userId);
    @Update("update FREQGROUP set \"SORT\" = #{sort} where GROUPID = #{objectId} and OWNERID = #{userId}")
    int updateGroupSort(@Param(value = "sort") String sort, @Param("objectId") String objectId, @Param("userId") String ownerId);

//    @Update({
//            "<script>",
//            "update FREQCONTACT ",
//            "<foreach collection = 'sortList' item = 'sorts' index = 'index' separator = ','>",
//            "set \"SORT\" = #{sorts.sort} where USERID = #{sorts.objectId} and OWNERID = #{userId}",
//            "</foreach>",
//            "</script>"
//    })
//    int updateContactSort(@Param(value = "sortList") List<CtmFreqSortRec> sortList, @Param("userId") String userId);
@Update("update FREQCONTACT set \"SORT\" = #{sort} where USERID = #{objectId} and OWNERID = #{userId}")
int updateContactSort(@Param(value = "sort") String sort, @Param("objectId") String objectId, @Param("userId") String ownerId);

}
