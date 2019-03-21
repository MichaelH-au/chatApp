package chatAPP.mapper;

import chatAPP.model.Friends;
import chatAPP.model.FriendsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FriendsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    long countByExample(FriendsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    int deleteByExample(FriendsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    int insert(Friends record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    int insertSelective(Friends record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    List<Friends> selectByExample(FriendsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    Friends selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    int updateByExampleSelective(@Param("record") Friends record, @Param("example") FriendsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    int updateByExample(@Param("record") Friends record, @Param("example") FriendsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    int updateByPrimaryKeySelective(Friends record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    int updateByPrimaryKey(Friends record);
}