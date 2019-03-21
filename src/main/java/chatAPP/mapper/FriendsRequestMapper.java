package chatAPP.mapper;

import chatAPP.model.FriendsRequest;
import chatAPP.model.FriendsRequestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FriendsRequestMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends_request
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    long countByExample(FriendsRequestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends_request
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    int deleteByExample(FriendsRequestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends_request
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends_request
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    int insert(FriendsRequest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends_request
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    int insertSelective(FriendsRequest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends_request
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    List<FriendsRequest> selectByExample(FriendsRequestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends_request
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    FriendsRequest selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends_request
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    int updateByExampleSelective(@Param("record") FriendsRequest record, @Param("example") FriendsRequestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends_request
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    int updateByExample(@Param("record") FriendsRequest record, @Param("example") FriendsRequestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends_request
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    int updateByPrimaryKeySelective(FriendsRequest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends_request
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    int updateByPrimaryKey(FriendsRequest record);
}